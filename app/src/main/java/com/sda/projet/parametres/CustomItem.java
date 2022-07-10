/*
 *  Created by TVB Ledoux on 10/07/22 22:19
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 10/07/22 22:15
 */

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
