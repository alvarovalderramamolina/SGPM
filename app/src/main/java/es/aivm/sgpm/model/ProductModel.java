package es.aivm.sgpm.model;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class ProductModel implements Cloneable {
    public enum Talla {
        S,
        M,
        L,
        XL
    }

    public enum Color {
        AZUL,
        NEGRO,
        ROJO,
        MARRÓN,
        BLANCO,
        NARANJA,
        VERDE,
        GRIS
    }

    private int id;
    private String nombre;
    private String marca;
    private int valoracionMedia;
    private int numValoraciones;
    private double precio;
    private boolean disponible;
    private Talla talla;
    private Color color;
    private Drawable imagen;


    public ProductModel(int id, String nombre, String marca, int valoracionMedia, int numValoraciones, double precio, boolean disponible, Drawable imagen) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.valoracionMedia = valoracionMedia;
        this.numValoraciones = numValoraciones;
        this.precio = precio;
        this.disponible = disponible;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getValoracionMedia() {
        return valoracionMedia;
    }

    public void setValoracionMedia(int valoracionMedia) {
        this.valoracionMedia = valoracionMedia;
    }

    public int getNumValoraciones() {
        return numValoraciones;
    }

    public void setNumValoraciones(int numValoraciones) {
        this.numValoraciones = numValoraciones;
    }

    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }

    public Object clone() throws
            CloneNotSupportedException
    {
        return super.clone();
    }
}