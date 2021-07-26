package main;

import java.util.Scanner;
import java.util.logging.Logger;

public class MainClass {
    static Logger logger = Logger.getLogger(MainClass.class.getName());
    static Scanner read = new Scanner(System.in);
    public static void main(String[] args) {

        App app = App.getInstance();
        var c1 = new CentroDeVacunacion("C1", "Lima", 5000);
        var c2 = new CentroDeVacunacion("C2", "Chiclayo", 5000);
        var c3 = new CentroDeVacunacion("C3", "Arequipa", 5000);
        var usuario = new Usuario("user");
        app.addCentro(c1);
        app.addCentro(c2);
        app.addCentro(c3);
        app.addUsuario(usuario);
        while(true) {
            logger.info("Por favor ingrese su nombre de usuario y contraseña: ");
            var username = read.nextLine();
            var pass = read.nextLine();
            if(app.checkUser(username, pass)){
                logger.info("Loggeado exitosamente \n");

            } else {
                logger.info("Datos incorrectos \n");
                break;
            }
        }
    }
}
