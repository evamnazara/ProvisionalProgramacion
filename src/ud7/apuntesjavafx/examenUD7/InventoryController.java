package ud7.apuntesjavafx.examenUD7;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class InventoryController implements Initializable {

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtSearchBox;

    @FXML
    private ListView<Producto> lstProductos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AppInventarioFX.cargarInventario(AppInventarioFX.FILE_PATH);
        AppInventarioFX.mainStage.setTitle("Titulo Procedural " + AppInventarioFX.FILE_PATH);

        lstProductos.getItems().addAll(AppInventarioFX.inventario);

        lstProductos.getSelectionModel().selectedItemProperty().addListener(
                (obs, prevProducto, producto) -> {
                    txtCodigo.setText(String.valueOf(producto.getCodigo()));
                    txtName.setText(producto.getName());
                    txtPrice.setText(String.valueOf(producto.getPrice()));
                    txtAmount.setText(String.valueOf(producto.getAmount()));
                });
        txtSearchBox.textProperty().addListener((observable, oldValue, newValue) -> searchProduct(null));

    }

    private Producto createProduct(String strCodigo, String name, String strPrice, String strAmount) {
        Producto p = null;

        if (name.isEmpty()) {
            System.out.println("El campo nombre debe rellenarse");
            return null;
        }

        try {
            p = new Producto(
                    Integer.parseInt(strCodigo),
                    name,
                    Double.parseDouble(strPrice),
                    Integer.parseInt(strAmount));

        } catch (NumberFormatException e) {
            System.out.println("Uno de los campos númericos están vacio o es invalido");
            return null;
        }

        return p;
    }

    @FXML
    void addProduct(ActionEvent event) {

        Producto p = createProduct(
                txtCodigo.getText(),
                txtName.getText(),
                txtPrice.getText(),
                txtAmount.getText());

        if (p == null) {
            return;
        }

        if (AppInventarioFX.inventario.contains(p)) {
            System.out.println("El producto ya existe en el inventario");
        } else {
            AppInventarioFX.inventario.add(p);
            refreshListView();
        }

    }

    @FXML
    void loadInventory(ActionEvent event) {
        AppInventarioFX.cargarInventario(AppInventarioFX.FILE_PATH);
    }

    @FXML
    void removeProduct(ActionEvent event) {

        int id = -1;
        try {
            id = Integer.parseInt(txtCodigo.getText());
        } catch (NumberFormatException e) {
        }

        Producto p = new Producto(id);
        AppInventarioFX.inventario.remove(p);
        lstProductos.getItems().remove(p);
        refreshListView();
    }

    @FXML
    void searchProduct(ActionEvent event) {

        String strCodigo = txtSearchBox.getText();

        if (strCodigo.isEmpty()) {
            refreshListView();
            return;
        }

        int codigo = -1;
        try {
            codigo = Integer.parseInt(strCodigo);

        } catch (NumberFormatException e) {
            return;
        }

        Producto p = AppInventarioFX.findProductByID(codigo);

        if (p == null) {
            lstProductos.getItems().clear();
            return;
        }

        lstProductos.getItems().clear();
        lstProductos.getItems().add(p);
    }

    @FXML
    void saveInventory(ActionEvent event) {
        AppInventarioFX.guardarInventario(AppInventarioFX.FILE_PATH);
    }

    @FXML
    void updateProductData(ActionEvent event) {

        int codigo = -1;

        try {
            codigo = Integer.parseInt(txtCodigo.getText());
        } catch (NumberFormatException e) {
            System.out.println("El código del producto no es un valor númerico valido");
            return;
        }

        Producto p = null;

        for (int i = 0; i < AppInventarioFX.inventario.size(); i++) {

            p = AppInventarioFX.inventario.get(i);

            if (p.getCodigo() == codigo) {

                Producto modProducto = createProduct(
                        txtCodigo.getText(),
                        txtName.getText(),
                        txtPrice.getText(),
                        txtAmount.getText());

                AppInventarioFX.inventario.set(i, modProducto);
                refreshListView();
                return;
            }
        }
    }

    private void refreshListView() {
        lstProductos.getItems().clear();
        lstProductos.getItems().addAll(AppInventarioFX.inventario);
    }

    @FXML
    void displayInventory(ActionEvent event) {
        refreshListView();
    }

}
