package main;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class App {
    static final Logger logger = Logger.getLogger(App.class.getName());
    private static App app;
    private int vacunadosTotalCentros ;
    private int vacunadosParcialCentros;
    private static List<Usuario> usuarios;
    private static List<CentroDeVacunacion> centros;
    private static final int TOTAL = 22935533;

    public static App getInstance() {
        if (app == null) {
            app = new App();
            usuarios = new ArrayList<>();
            centros = new ArrayList<>();
        }
        return app;
    }

    public boolean checkUser(String username, String pass){
        for(var users: usuarios){
            if (users.getNombre().equals(username) && users.getPassword().equals(pass)) {
                users.setActive(true);
                return true;
            }
        }
        return false;
    }

    public void addCentro(CentroDeVacunacion centroDeVacunacion){
        centros.add(centroDeVacunacion);
    }

    public void addUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void showInfoCentros(){
        for(var c: centros){
            c.showInfo();
        }
    }

    public void notificarUsuarios(){
        logger.info("Notificando personas vacunadas .... \n");
    }

    public void darDeAltaCentro(String name, boolean bool){
        for(var c: centros){
            if(c.getNombre().equals(name)){
                c.estadoAlta(bool);
                notificarUsuarios();
            }
        }
    }

    public void darDebajaCentro(String name){
        for(var c: centros){
            if(c.getNombre().equals(name)){
                c.setAlta(false);
            }
        }
    }

    private void calcular(){
        for(var c: centros){
            vacunadosParcialCentros += c.getParcialVacunado();
            vacunadosTotalCentros += c.getTotalVacunado();
        }
    }

    public void generalInfo() {
        calcular();
        logger.info("Se ha vacunado un " + vacunadosTotalCentros * 100 / TOTAL + "% de la población \n"
                + "Vacunados parciales: " + vacunadosParcialCentros);
    }
    
    public void cerrarCesion(String user) {
        for (var u : usuarios) {
            if (u.getNombre().equals(user)) {
                u.setActive(false);
            }
        }
    }
}