/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 06:00
 */

package com.sda.HymnesAdventiste.parametres;

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
