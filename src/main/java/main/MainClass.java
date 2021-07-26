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
            if (app.checkUser(username, pass)) {
                while (true) {
                    logger.info("Loggeado exitosamente \n");
                    logger.info("1. Mostrar información general.\n");
                    logger.info("2. Mostrar información de los centros.\n");
                    logger.info("3. Dar de baja un centro de vacunación.\n");
                    logger.info("4. Dar de alta un centro de vacunación.\n");
                    logger.info("5. Cerrar cesión.\n");
                    var opcion = read.nextInt();
                    switch (opcion) {
                        case 1:
                            app.generalInfo();
                            break;
                        case 2:
                            app.showInfoCentros();
                            break;
                        case 3:
                            logger.info("Escriba el nombre del centro que dará de baja.");
                            var name = read.nextLine();
                            app.darDebajaCentro(name);
                            break;
                        case 4:
                            logger.info("Escriba el nombre del centro que dará de alta.");
                            var namec = read.nextLine();
                            app.darDebajaCentro(namec);
                            break;
                        case 5:
                            app.cerrarCesion(username);
                            logger.info("Cerrando cesion");
                            break;
                        default:
                            break;
                    }
                    break;
                }
            } else {
                logger.info("Datos incorrectos \n");
                break;
            }
        }
    }
}
