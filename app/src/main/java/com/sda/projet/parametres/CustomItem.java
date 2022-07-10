package com.sda.projet.parametres;

public class CustomItem {

    private String spinnerItemNane;
    private int spinnerItemImage;

    public CustomItem(String spinnerItemNane, int spinnerItemImage) {
        this.spinnerItemNane = spinnerItemNane;
        this.spinnerItemImage = spinnerItemImage;
    }

    public String getSpinnerItemNane() {
        return spinnerItemNane;
    }

    public int getSpinnerItemImage() {
        return spinnerItemImage;
    }
}
