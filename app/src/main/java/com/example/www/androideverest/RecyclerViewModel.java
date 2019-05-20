package com.example.www.androideverest;

import android.graphics.drawable.Drawable;

public class RecyclerViewModel {

    private String title, subtitle, identification;
    private Drawable icon, photo;

    RecyclerViewModel(String title, String subtitle, String identification, Drawable icon, Drawable photo) {
        this.title = title;
        this.subtitle = subtitle;
        this.identification = identification;
        this.icon = icon;
        this.photo = photo;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getSubtitle() {
        return subtitle;
    }

    void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    String getIdentification() {
        return identification;
    }

    void setIdentification(String identification) {
        this.identification = identification;
    }

    Drawable getIcon() {
        return icon;
    }

    void setIcon(Drawable icon) {
        this.icon = icon;
    }

    Drawable getPhoto() {
        return photo;
    }

    void setPhoto(Drawable photo) {
        this.photo = photo;
    }
}
