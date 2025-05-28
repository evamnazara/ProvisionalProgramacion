//Eva Maria Otero Názara
package ud7.eonexamen.web;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GeneraWeb {
    static final String PATH = "src/ud7/eonexamen/web/";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce los datos de tu web:");
        System.out.println("Titulo: ");
        String titulo = sc.nextLine();
        System.out.println("Descripcion: ");
        String descripcion = sc.nextLine();
        System.out.println("URL enlace: ");
        String urlEnlace = sc.nextLine();
        System.out.println("Texto de tu enlace: ");
        String textoEnlace = sc.nextLine();

        try {

            BufferedWriter out = new BufferedWriter(new FileWriter(PATH + "Web.html", true));
            String web = "<html> \r\n" + //
                                "<head> \r\n" + //
                                "<title>" + titulo + "</title> \r\n" + //
                                "<meta charset=\"utf-8\"> \r\n" + //
                                "</head> \r\n" + //
                                " \r\n" + //
                                "<body> \r\n" + //
                                "<h1>" +  titulo + "</h1> \r\n" + //
                                " \r\n" + //
                                "<p>" + descripcion + ". <br> \r\n" + //
                                "<a href=\"" + urlEnlace + "\">" + textoEnlace + "</a> \r\n" + //
                                "</p> \r\n" + //
                                " \r\n" + //
                                "</body> \r\n" + //
                                "</html>";

            for (int i = 0; i < web.length(); i++) {
                out.write(web.charAt(i));
            }

            out.flush();
            out.newLine();

            out.write(web);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        sc.close();

    }

}
