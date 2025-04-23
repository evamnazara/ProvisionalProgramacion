package ud6.apuntesstream.e1301;
/* 
E1301. Definir una interfaz funcional cuya función abstracta permita generar un saludo 
dirigido al objeto que se le pasa como parámetro. Implementar un saludo para nombres 
(clase String) y otro para clientes (clase Cliente). Aplicarlas a varios casos particulares.  */
public interface Saludo <T>  {
    //cualquier tipo - cualquier objeto. Añadimos arriba la T por tipo predefinido
    //add type parameter T
   
    String saludar(T t );
}
