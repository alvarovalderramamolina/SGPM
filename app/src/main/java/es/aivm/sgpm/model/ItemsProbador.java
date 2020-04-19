package es.aivm.sgpm.model;

import android.content.ClipData;
import android.graphics.drawable.Drawable;

public class ItemsProbador  {
    public enum Talla {
        XL,L,M,S
    }
    public enum Color{
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
    private double precio;
    private ItemsProbador.Talla talla;
    private ItemsProbador.Color color;
    private Drawable imagen;

    public ItemsProbador( int id, String nombre, String marca, double precio, Talla talla, Color color, Drawable imagen){
        this.id=id;
        this.marca=marca;
        this.imagen= imagen;
        this.precio=precio;
        this.nombre= nombre;
        this.talla=talla;
        this.color=color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
}
