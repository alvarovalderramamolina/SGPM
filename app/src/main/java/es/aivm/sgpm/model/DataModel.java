package es.aivm.sgpm.model;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.aivm.sgpm.R;

public class DataModel {
    /**
     * Sólo se deben de usar las funciones públicas.
     * No modificar las funciones privadas.
     *
     */
    private Context context;

    public static boolean first = true;
    public static boolean firstInvitee = true;

    public List<UserModel> usuarios = new ArrayList<>();
    public List<UserModel> admins = new ArrayList<>();
    public List<ProbadorModel> probadores = new ArrayList<ProbadorModel>();
    public String[] nombres = new String[]{
      "Alain Aspect", "David Baltimore", "Allen Bard", "Timothy Berners-Lee", "Dennis Bray", "Elon Musk", "Jeff Bezos",
      "Mark Zuckerberg", "Tim Cook", "Sundar Pichai"
    };
    // PromocionesCliente es la lista de descuentos a las que opta el usuario fidelizado.
    // El usuario no fidelizado no opta a ellas. No debe de aparecerle esa pantalla.
    public List<PromocionModel> promociones = new ArrayList<>();

    public List<ProductModel> pantalones = new ArrayList<ProductModel>();
    public List<ProductModel> jerseys = new ArrayList<ProductModel>();
    public List<ProductModel> abrigos = new ArrayList<ProductModel>();
    public List<ProductModel> calzado = new ArrayList<ProductModel>();
    public List<ProductModel> accesorios = new ArrayList<ProductModel>();
    public List<ProductModel> ofertas = new ArrayList<ProductModel>();

    public static DataModel database;
    public static UserModel currentUser;

    public static ProductModel currentProduct;

    public DataModel(Context context) {
        this.context = context;

        initProducts();
        initUsuarios();
        initPromociones();
    }

    public void signUp(String name, String email, String password) {
        UserModel u = new UserModel(name, email, password);
        this.usuarios.add(u);
    }
    public UserModel logInUsuario(String email, String password) {
        for (int i=0; i<usuarios.size(); i++) {
            UserModel u = this.usuarios.get(i);
            if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
                u.logIn();
                crearProbador(i);
                return u;
            }
        }
        return null;
    }
    public boolean logInAdmin(String email, String password) {
        for (int i=0; i<admins.size(); i++) {
            UserModel u = this.admins.get(i);
            if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
                u.logIn();

                return true;
            }
        }
        return false;
    }
    public HashMap<String, Double> generarFactura(UserModel usuario) {
        HashMap<String, Double> factura = new HashMap<>();
        List<ProductModel> cesta = usuario.getCesta();
        List<PromocionModel> promocionesActivadas = usuario.getPromocionesActivadas();
        int puntos = usuario.getPuntosUsados();
        double total = 0, discount = 0;
        for(int i=0; i<cesta.size(); i++) {
            total += cesta.get(i).getPrecio();
        }
        for(int i=0; i<promocionesActivadas.size(); i++) {
            discount += promocionesActivadas.get(i).getDiscount();
        }

        total = total - total*discount - puntos*0.01;

        factura.put("Discount", discount);
        factura.put("Total", total);

        return factura;
    }
    public void finalizarCompra(UserModel user) {
        for(int i = 0; i<usuarios.size(); i++) {
            UserModel u = usuarios.get(i);
            if (u.getEmail() == user.getEmail()) {
                u.finalizarCompra();
                eliminarProbador(i);
            }
        }
    }


    /**
     * Funciones auxiliares: No cambiar el alcance de estas funciones
     *
     */
    public void crearProbador(int i) {
        String nombreImagen = "probador" + i;
        System.out.println(nombreImagen);
        final int resourceId = context.
                getResources().
                getIdentifier(nombreImagen,
                        "drawable",
                        context.getPackageName());
        Drawable image = context.getResources().getDrawable(resourceId);
        ProbadorModel p = new ProbadorModel(nombres[i], image, usuarios.get(i));
        probadores.add(p);
    }
    private void eliminarProbador(int i) {
        probadores.remove(i);
    }
    private void initPromociones() {
        PromocionModel promoNuevaTemp = new PromocionModel("Ahorra 30%", context.getResources().getDrawable(R.drawable.promo1), "Aprovecha esta promoción de nueva temporada", 0.3);
        PromocionModel promoBadDays = new PromocionModel("Hasta 30%", context.getResources().getDrawable(R.drawable.promo2), "Este es un mal día, solo puedes ahorrar 15%", 0.15);

        promociones.add(promoNuevaTemp);
        promociones.add(promoBadDays);
    }
    private void initProducts() {
        ProductModel levisSkinny = new ProductModel(0, "Chino de hombre regular", "Calvin Klein", 5, 300, 89.99, true, context.getResources().getDrawable(R.drawable.skinny_jeans));
        ProductModel chandalJeans = new ProductModel(1, "Chandal de hombre regular", "Calvin Klein", 2, 234, 99.99, true, context.getResources().getDrawable(R.drawable.chandal_jeans));
        ProductModel chinoSupreme = new ProductModel(2, "Chino supreme flex de hombre", "Dockers", 3, 643, 69.99, true, context.getResources().getDrawable(R.drawable.chino_supreme));
        ProductModel chinoAlpha = new ProductModel(3, "Chino alpha original khaki de hombre", "Dockers", 3, 211, 32.99, true, context.getResources().getDrawable(R.drawable.chino_alpha));
        ProductModel cargo_de_hombre = new ProductModel(4, "Pantalon cargo de hombre", "G-Star Raw", 5, 300, 99.99, true, context.getResources().getDrawable(R.drawable.cargo_jeans));
        ProductModel merakijerseys = new ProductModel(5, "Jersey de algodón con cremallera", "MERAKI", 5, 421, 25.23, false, context.getResources().getDrawable(R.drawable.meraki_jersey));
        ProductModel goodthreadsjerseys = new ProductModel(6, "Sudadera hombre", "Goodthreads", 4, 470, 26.49, true, context.getResources().getDrawable(R.drawable.goodthreads_jersey));
        ProductModel jackjonesjerseys = new ProductModel(7, "Jjebasic Knit V-Neck Noos", "Jack & Jones", 5, 2047, 69.99, true, context.getResources().getDrawable(R.drawable.jackandjones));
        ProductModel levisjerseys = new ProductModel(8, "Housemark Graphic tee", "Levi's", 4, 1240, 15.99, true, context.getResources().getDrawable(R.drawable.housemark_levi));
        ProductModel tazziojerseys = new ProductModel(9, "Chaqueta de punto para hombre", "Tazzio", 3, 153, 26.90, true, context.getResources().getDrawable(R.drawable.tazzio_jersey));
        ProductModel findabrigos = new ProductModel(10, "Marca Amazon - find. Abrigo Hombre", "find.", 5, 167, 60.90, true, context.getResources().getDrawable(R.drawable.find_chaqueta));
        ProductModel mirecooabrigos = new ProductModel(11, "Abrigo de lana para hombre", "Mirecoo", 2, 205, 112.69, true, context.getResources().getDrawable(R.drawable.mirecoo_chaqueta));
        ProductModel hellyabrigos = new ProductModel(12, "Crew Midlayer - Chaqueta Impermeable con Capucha", "Helly Hansen", 3, 636, 92.33, true, context.getResources().getDrawable(R.drawable.helly_hansen));
        ProductModel blackabrigos = new ProductModel(13, "Chaqueta de Plumas para Hombre", "Black Crevice", 3, 260, 40.21, true, context.getResources().getDrawable(R.drawable.black_clarive));
        ProductModel bolfabrigos = new ProductModel(14, "BOLF Hombre Chaqueta de Invierno", "BOLF", 5, 367, 45.95, true, context.getResources().getDrawable(R.drawable.bolf_chaqueta));
        ProductModel adidascalzado = new ProductModel(15, "Runfalcon, Zapatillas de Running para Hombre", "Adidas", 5, 300, 89.99, true, context.getResources().getDrawable(R.drawable.adidas_calzado));
        ProductModel columbiacalzado = new ProductModel(16, "Fairbanks Omni-Heat Bota de invierno para hombre", "Columbia", 2, 234, 99.99, true, context.getResources().getDrawable(R.drawable.columbia_calzado));
        ProductModel pumacalzado = new ProductModel(17, "St Runner V2 NL, Zapatillas de Cross Unisex Adulto", "Puma", 3, 643, 69.99, true, context.getResources().getDrawable(R.drawable.puma_calzado));
        ProductModel salomoncalzado = new ProductModel(18, "Alphacross, Zapatillas de Trail Running para Hombre", "Salomon", 3, 211, 32.99, true, context.getResources().getDrawable(R.drawable.salomon_calzado));
        ProductModel clarkscalzado = new ProductModel(19, "Cotrell Stride, Zapatos de Cordones Derby para Hombre", "Clarks", 5, 300, 59.99, true, context.getResources().getDrawable(R.drawable.clarks_calzadi));
        ProductModel levisSkinnyaccesorios = new ProductModel(20, "Sonnenbrille Mason (FT0445)", "Tom Ford", 4, 55, 193.80, true, context.getResources().getDrawable(R.drawable.tom_ford_accesorio));
        ProductModel chandalJeansaccesorios = new ProductModel(21, "Cartera Carbon, Metallic-Grey ", "I-CLIP", 2, 8590, 40.00, true, context.getResources().getDrawable(R.drawable.i_clip_accesorio));
        ProductModel chinoSupremeaccesorios = new ProductModel(22, "Marró Cartera para hombre Estilo plegable ", "MPTECK", 5, 428, 9.99, true, context.getResources().getDrawable(R.drawable.mpteck_accesorios));
        ProductModel chinoAlphaaccesorios = new ProductModel(23, "Accesorios Bolso Bandolera, 22 cm, Azul", "Converse", 3, 518, 24.90, true, context.getResources().getDrawable(R.drawable.converse_accesorio));
        ProductModel cargo_de_hombreaccesorios = new ProductModel(24, "Cinturón para Hombre", "Tommy Hilfiger", 2, 150, 34.41, true, context.getResources().getDrawable(R.drawable.tommy_accesorio));
        ProductModel levisSkinnyofertas = new ProductModel(25, "Camiseta Hombre", "CARE OF by PUMA", 4, 102, 20.00, false, context.getResources().getDrawable(R.drawable.puma_oferta));
        ProductModel chandalJeansofertas = new ProductModel(26, "Hombre Camisa Manga Larga ", "Kayhan", 5, 3194, 19.99, false, context.getResources().getDrawable(R.drawable.kayhan_oferta));
        ProductModel chinoSupremeofertas = new ProductModel(27, "The Original tee Camiseta para Hombre", "Levi's", 5, 9, 12.50, false, context.getResources().getDrawable(R.drawable.levi_oferta));
        ProductModel chinoAlphaofertas = new ProductModel(28, "Fitted Boxer (Pack de 12) para Hombre", "FM London", 3, 211, 29.99, true, context.getResources().getDrawable(R.drawable.fm_london_oferta));
        ProductModel cargo_de_hombreofertas = new ProductModel(29, "Jogging para Hombre", "MERISH", 5, 300, 19.90, true, context.getResources().getDrawable(R.drawable.merish_oferta));

        pantalones.add(levisSkinny);
        pantalones.add(chandalJeans);
        pantalones.add(chinoSupreme);
        pantalones.add(chinoAlpha);
        pantalones.add(cargo_de_hombre);
        jerseys.add(merakijerseys);
        jerseys.add(goodthreadsjerseys);
        jerseys.add(jackjonesjerseys);
        jerseys.add(levisjerseys);
        jerseys.add(tazziojerseys);
        abrigos.add(findabrigos);
        abrigos.add(mirecooabrigos);
        abrigos.add(hellyabrigos);
        abrigos.add(blackabrigos);
        abrigos.add(bolfabrigos);
        calzado.add(adidascalzado);
        calzado.add(columbiacalzado);
        calzado.add(pumacalzado);
        calzado.add(salomoncalzado);
        calzado.add(clarkscalzado);
        accesorios.add(levisSkinnyaccesorios);
        accesorios.add(chandalJeansaccesorios);
        accesorios.add(chinoSupremeaccesorios);
        accesorios.add(chinoAlphaaccesorios);
        accesorios.add(cargo_de_hombreaccesorios);
        ofertas.add(levisSkinnyofertas);
        ofertas.add(chandalJeansofertas);
        ofertas.add(chinoSupremeofertas);
        ofertas.add(chinoAlphaofertas);
        ofertas.add(cargo_de_hombreofertas);
    }
    private void initUsuarios() {
        UserModel u = new UserModel("Mohammed", "m.makhfi@alumnos.upm.es", "abc123");
        UserModel v = new UserModel("Álvaro", "aivm@alumnos.upm.es", "abc456");
        UserModel w = new UserModel("Khalid", "kAlfozan@alumnos.upm.es", "abc789");
        UserModel x = new UserModel("Alonso", "a.dinavarro@alumnos.upm.es", "abc101");
        UserModel y = new UserModel("El Jefazo", "jefe@alumnos.upm.es", "tencuidado");
        UserModel t = new UserModel("Alonso", "a.dinavarro@alumnos.upm.es", "abc101");


        usuarios.add(u);
        usuarios.add(v);
        usuarios.add(w);
        usuarios.add(x);
        usuarios.add(t);
        admins.add(y);
    }
}
