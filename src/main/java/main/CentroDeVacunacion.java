package main;

import java.util.Map;
import java.util.logging.Logger;

import static java.util.Map.entry;

public class CentroDeVacunacion {
    static final Logger logger = Logger.getLogger(CentroDeVacunacion.class.getName());
    private String nombre;
    private String ubicacion;
    private Boolean alta;
    private int totalVacunado;
    private int parcialVacunado;
    private int capacidad;
    private double avance;
    private Map<String, Integer> vacunadosEdadCompleto;
    private Map<String, Integer> vacunadosEdadParcial;

    public CentroDeVacunacion(String nombre, String ubicacion, int capacidad) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.alta = false;
        this.capacidad = capacidad;
        vacunadosEdadCompleto = Map.ofEntries(
                entry("80", 0),
                entry("70-79", 0),
                entry("60-69", 0),
                entry("50-59", 0),
                entry("40-49", 0),
                entry("30-39", 0),
                entry("18-29", 0)
        );
        vacunadosEdadParcial = Map.ofEntries(
                entry("80", 0),
                entry("70-79", 0),
                entry("60-69", 0),
                entry("50-59", 0),
                entry("40-49", 0),
                entry("30-39", 0),
                entry("18-29", 0)
        );
        totalVacunado = 0;
        parcialVacunado = 0;
    }

    private void calcularTotal(){
        for(var value: vacunadosEdadCompleto.values()){
            totalVacunado += value;
        }
        for(var value: vacunadosEdadParcial.values()){
            parcialVacunado += value;
        }

        avance = totalVacunado * 100 / capacidad;

    }

    public void showInfo(){
        if(alta) {
            calcularTotal();
            logger.info("Avance de la vacunación en: " + nombre + "\n" +
                    "Vacunados totalmente: " + totalVacunado + "\n" +
                    "Vacunados Parcialmente: " + parcialVacunado + "\n" +
                    "Avance de la vacunación: " + avance + "\n"
            );
        } else {
            logger.info("El centro todavia no fue dado de alta. \n");
        }
    }

    public void estadoAlta (Boolean bool){
        alta = bool;
    }

    public void setCantidadVacunadosTotalmente(String rango, int cantidad){
        vacunadosEdadCompleto.put(rango, cantidad);
    }

    public void setCantidadVacunadosParcialmente(String rango, int cantidad){
        vacunadosEdadParcial.put(rango, cantidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public int getTotalVacunado() {
        return totalVacunado;
    }

    public void setTotalVacunado(int totalVacunado) {
        this.totalVacunado = totalVacunado;
    }

    public int getParcialVacunado() {
        return parcialVacunado;
    }

    public void setParcialVacunado(int parcialVacunado) {
        this.parcialVacunado = parcialVacunado;
    }
}
