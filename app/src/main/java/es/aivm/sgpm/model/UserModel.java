package es.aivm.sgpm.model;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private String name;
    private String email;
    private String password;

    private List<ItemProduct> cesta;
    private List<ItemProduct> probador;

    private int puntos;
    private int puntosUsados;
    private List<PromocionModel> promocionesActivadas;

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
        this.puntos = 0;
        this.puntosUsados = 0;
    }

    //No usar este método. Usar el LogIn de DataModel
    public void logIn() {
        this.active = true;

        this.cesta = new ArrayList<>();
        this.probador = new ArrayList<>();
        this.promocionesActivadas = new ArrayList<>();
    }
    public void logOut() {
        // así podemos mantener su probador activo y comprobar que existe (chapuza)
        //this.active = false;
    }
    public void finalizarCompra() {
        this.cesta = null;
        this.probador = null;
        this.active = false;

        puntos += 100;
    }

    public boolean addProductToCesta(ItemProduct product) {
        if (this.cesta.size() < 10){
            this.cesta.add(product);
            return true;
        }
        return false;
    }
    public void removeProductFromCesta(int index) {
        if (0 <= index && index <= 10)
            this.cesta.remove(index);
    }
    public boolean addProductToProbador(ItemProduct product) {
        if (this.probador.size() < 10){
            this.probador.add(product);
            return true;
        }
        return false;
    }
    public void removeProductFromProbador(int index) {
        if (0 <= index && index <= 10)
            this.probador.remove(index);
    }
    public void addPromocion(PromocionModel promocion) {
        promocionesActivadas.add(promocion);
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
    public void usarPuntos() {
        puntosUsados = puntos;
        puntos = 0;
    }
    public int getPuntos() {
        return puntos;
    }
    public int getPuntosUsados() {
        return puntosUsados;
    }
    public List<ItemProduct> getCesta() {
        return cesta;
    }
    public List<ItemProduct> getProbador() {
        return probador;
    }
    public List<PromocionModel> getPromocionesActivadas() {
        return promocionesActivadas;
    }
    public boolean isGuest() {
        return guest;
    }
    public boolean isActive() {
        return active;
    }
}
