package es.aivm.sgpm.model;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private String name;
    private String email;
    private String password;

    private List<ItemProduct> cesta;
    private List<ItemProduct> probador;

    private boolean guest;
    private boolean active = false;

    public UserModel() {
        this.cesta = new ArrayList<>();
        this.probador = new ArrayList<>();

        this.guest = true;
        this.active = true;
    }
    public UserModel(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void logIn() {
        this.active = true;

        this.cesta = new ArrayList<>();
        this.probador = new ArrayList<>();
    }
    public void logOut() {
        // así podemos mantener su probador activo y comprobar que existe (chapuza)
        //this.active = false;
    }
    public void finalizarCompra() {this.cesta = null; this.probador = null; this.active = false;}

    public void addProductToCesta(ItemProduct product) {
        if (this.cesta.size() < 10)
            this.cesta.add(product);
    }
    public void removeProductFromCesta(int index) {
        if (0 <= index && index <= 10)
            this.cesta.remove(index);
    }
    public void addProductToProbador(ItemProduct product) {
        if (this.cesta.size() < 10)
            this.cesta.add(product);
    }
    public void removeProductFromProbador(int index) {
        if (0 <= index && index <= 10)
            this.probador.remove(index);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<ItemProduct> getCesta() {
        return cesta;
    }
    public List<ItemProduct> getProbador() {
        return probador;
    }
    public boolean isGuest() {
        return guest;
    }
    public boolean isActive() {
        return active;
    }

}
