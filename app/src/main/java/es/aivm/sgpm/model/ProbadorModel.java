package es.aivm.sgpm.model;

import android.graphics.drawable.Drawable;

public class ProbadorModel {
    private String name;
    private Drawable image;
    private UserModel user;

    public ProbadorModel(String name, Drawable image, UserModel user) {
        this.name = name;
        this.image = image;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public Drawable getImage() {
        return image;
    }

    public UserModel getUser() {
        return user;
    }
}
