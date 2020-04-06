package es.aivm.sgpm.model;

import android.graphics.drawable.Drawable;

/**
 * Created by AIVM on 06/04/2020.
 */
public class ItemProduct {

    private Drawable imageSrc;
    private String name;

    public ItemProduct(Drawable imageSrc, String name) {
        this.imageSrc = imageSrc;
        this.name = name;
    }

    public Drawable getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(Drawable imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
