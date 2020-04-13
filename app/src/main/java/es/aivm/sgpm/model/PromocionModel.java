package es.aivm.sgpm.model;

import android.graphics.drawable.Drawable;

public class PromocionModel {
    private String name;
    private Drawable image;
    private String description;
    private double discount;

    public PromocionModel(String name, Drawable image, String description, double discount) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Drawable getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscount() {
        return discount;
    }
}
