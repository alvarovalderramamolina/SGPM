package es.aivm.sgpm.model;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.aivm.sgpm.R;

public class DataModel {

    public static List<ItemProduct> pantalones = new ArrayList<ItemProduct>();
    public static List<ItemProduct> jerseys = new ArrayList<ItemProduct>();
    public static List<ItemProduct> abrigos = new ArrayList<ItemProduct>();
    public static List<ItemProduct> calzado = new ArrayList<ItemProduct>();
    public static List<ItemProduct> accesorios = new ArrayList<ItemProduct>();
    public static List<ItemProduct> ofertas = new ArrayList<ItemProduct>();

    public static List<ItemProduct> pantalones(Context context) {
        ItemProduct levisSkinny = new ItemProduct(0, "Chino de hombre regular", "Calvin Klein", 5, 300, 89.99, true, context.getResources().getDrawable(R.drawable.skinny_jeans));
        ItemProduct chandalJeans = new ItemProduct(1, "Chandal de hombre regular", "Calvin Klein", 2, 234, 99.99, true, context.getResources().getDrawable(R.drawable.chandal_jeans));
        ItemProduct chinoSupreme = new ItemProduct(2, "Chino supreme flex de hombre", "Dockers", 3, 643, 69.99, true, context.getResources().getDrawable(R.drawable.chino_supreme));
        ItemProduct chinoAlpha = new ItemProduct(3, "Chino alpha original khaki de hombre", "Dockers", 3, 211, 32.99, true, context.getResources().getDrawable(R.drawable.chino_alpha));
        ItemProduct cargo_de_hombre = new ItemProduct(4, "Pantalon cargo de hombre", "G-Star Raw", 5, 300, 99.99, true, context.getResources().getDrawable(R.drawable.cargo_jeans));

        DataModel.pantalones.add(levisSkinny);
        DataModel.pantalones.add(chandalJeans);
        DataModel.pantalones.add(chinoSupreme);
        DataModel.pantalones.add(chinoAlpha);
        DataModel.pantalones.add(cargo_de_hombre);

        return DataModel.pantalones;
    }

    public static List<ItemProduct> jerseys(Context context) {
        ItemProduct levisSkinny = new ItemProduct(0, "Chino de hombre regular", "Calvin Klein", 5, 300, 89.99, true, context.getResources().getDrawable(R.drawable.skinny_jeans));
        ItemProduct chandalJeans = new ItemProduct(1, "Chandal de hombre regular", "Calvin Klein", 2, 234, 99.99, true, context.getResources().getDrawable(R.drawable.chandal_jeans));
        ItemProduct chinoSupreme = new ItemProduct(2, "Chino supreme flex de hombre", "Dockers", 3, 643, 69.99, true, context.getResources().getDrawable(R.drawable.chino_supreme));
        ItemProduct chinoAlpha = new ItemProduct(3, "Chino alpha original khaki de hombre", "Dockers", 3, 211, 32.99, true, context.getResources().getDrawable(R.drawable.chino_alpha));
        ItemProduct cargo_de_hombre = new ItemProduct(4, "Pantalon cargo de hombre", "G-Star Raw", 5, 300, 99.99, true, context.getResources().getDrawable(R.drawable.cargo_jeans));

        DataModel.jerseys.add(levisSkinny);
        DataModel.jerseys.add(chandalJeans);
        DataModel.jerseys.add(chinoSupreme);
        DataModel.jerseys.add(chinoAlpha);
        DataModel.jerseys.add(cargo_de_hombre);

        return DataModel.jerseys;
    }

    public static List<ItemProduct> abrigos(Context context) {
        ItemProduct levisSkinny = new ItemProduct(0, "Chino de hombre regular", "Calvin Klein", 5, 300, 89.99, true, context.getResources().getDrawable(R.drawable.skinny_jeans));
        ItemProduct chandalJeans = new ItemProduct(1, "Chandal de hombre regular", "Calvin Klein", 2, 234, 99.99, true, context.getResources().getDrawable(R.drawable.chandal_jeans));
        ItemProduct chinoSupreme = new ItemProduct(2, "Chino supreme flex de hombre", "Dockers", 3, 643, 69.99, true, context.getResources().getDrawable(R.drawable.chino_supreme));
        ItemProduct chinoAlpha = new ItemProduct(3, "Chino alpha original khaki de hombre", "Dockers", 3, 211, 32.99, true, context.getResources().getDrawable(R.drawable.chino_alpha));
        ItemProduct cargo_de_hombre = new ItemProduct(4, "Pantalon cargo de hombre", "G-Star Raw", 5, 300, 99.99, true, context.getResources().getDrawable(R.drawable.cargo_jeans));

        DataModel.abrigos.add(levisSkinny);
        DataModel.abrigos.add(chandalJeans);
        DataModel.abrigos.add(chinoSupreme);
        DataModel.abrigos.add(chinoAlpha);
        DataModel.abrigos.add(cargo_de_hombre);

        return DataModel.abrigos;
    }

    public static List<ItemProduct> calzado(Context context) {
        ItemProduct levisSkinny = new ItemProduct(0, "Chino de hombre regular", "Calvin Klein", 5, 300, 89.99, true, context.getResources().getDrawable(R.drawable.skinny_jeans));
        ItemProduct chandalJeans = new ItemProduct(1, "Chandal de hombre regular", "Calvin Klein", 2, 234, 99.99, true, context.getResources().getDrawable(R.drawable.chandal_jeans));
        ItemProduct chinoSupreme = new ItemProduct(2, "Chino supreme flex de hombre", "Dockers", 3, 643, 69.99, true, context.getResources().getDrawable(R.drawable.chino_supreme));
        ItemProduct chinoAlpha = new ItemProduct(3, "Chino alpha original khaki de hombre", "Dockers", 3, 211, 32.99, true, context.getResources().getDrawable(R.drawable.chino_alpha));
        ItemProduct cargo_de_hombre = new ItemProduct(4, "Pantalon cargo de hombre", "G-Star Raw", 5, 300, 99.99, true, context.getResources().getDrawable(R.drawable.cargo_jeans));

        DataModel.calzado.add(levisSkinny);
        DataModel.calzado.add(chandalJeans);
        DataModel.calzado.add(chinoSupreme);
        DataModel.calzado.add(chinoAlpha);
        DataModel.calzado.add(cargo_de_hombre);

        return DataModel.calzado;
    }

    public static List<ItemProduct> accesorios(Context context) {
        ItemProduct levisSkinny = new ItemProduct(0, "Chino de hombre regular", "Calvin Klein", 5, 300, 89.99, true, context.getResources().getDrawable(R.drawable.skinny_jeans));
        ItemProduct chandalJeans = new ItemProduct(1, "Chandal de hombre regular", "Calvin Klein", 2, 234, 99.99, true, context.getResources().getDrawable(R.drawable.chandal_jeans));
        ItemProduct chinoSupreme = new ItemProduct(2, "Chino supreme flex de hombre", "Dockers", 3, 643, 69.99, true, context.getResources().getDrawable(R.drawable.chino_supreme));
        ItemProduct chinoAlpha = new ItemProduct(3, "Chino alpha original khaki de hombre", "Dockers", 3, 211, 32.99, true, context.getResources().getDrawable(R.drawable.chino_alpha));
        ItemProduct cargo_de_hombre = new ItemProduct(4, "Pantalon cargo de hombre", "G-Star Raw", 5, 300, 99.99, true, context.getResources().getDrawable(R.drawable.cargo_jeans));

        DataModel.accesorios.add(levisSkinny);
        DataModel.accesorios.add(chandalJeans);
        DataModel.accesorios.add(chinoSupreme);
        DataModel.accesorios.add(chinoAlpha);
        DataModel.accesorios.add(cargo_de_hombre);

        return DataModel.accesorios;
    }

    public static List<ItemProduct> ofertas(Context context) {
        ItemProduct levisSkinny = new ItemProduct(0, "Chino de hombre regular", "Calvin Klein", 5, 300, 89.99, true, context.getResources().getDrawable(R.drawable.skinny_jeans));
        ItemProduct chandalJeans = new ItemProduct(1, "Chandal de hombre regular", "Calvin Klein", 2, 234, 99.99, true, context.getResources().getDrawable(R.drawable.chandal_jeans));
        ItemProduct chinoSupreme = new ItemProduct(2, "Chino supreme flex de hombre", "Dockers", 3, 643, 69.99, true, context.getResources().getDrawable(R.drawable.chino_supreme));
        ItemProduct chinoAlpha = new ItemProduct(3, "Chino alpha original khaki de hombre", "Dockers", 3, 211, 32.99, true, context.getResources().getDrawable(R.drawable.chino_alpha));
        ItemProduct cargo_de_hombre = new ItemProduct(4, "Pantalon cargo de hombre", "G-Star Raw", 5, 300, 99.99, true, context.getResources().getDrawable(R.drawable.cargo_jeans));

        DataModel.ofertas.add(levisSkinny);
        DataModel.ofertas.add(chandalJeans);
        DataModel.ofertas.add(chinoSupreme);
        DataModel.ofertas.add(chinoAlpha);
        DataModel.ofertas.add(cargo_de_hombre);

        return DataModel.ofertas;
    }

}
