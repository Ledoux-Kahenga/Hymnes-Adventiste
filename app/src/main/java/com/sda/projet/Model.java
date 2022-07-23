/*
 *  Created by TVB Ledoux on 23/07/22 20:59
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 23/07/22 19:13
 */

package com.sda.projet;

public class Model {

    int id;
    String number, titleSwahili, titleEnglish;

    public Model(int id, String number, String titleSwahili, String titleEnglish) {
        this.id = id;
        this.number = number;
        this.titleSwahili = titleSwahili;
        this.titleEnglish = titleEnglish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitleSwahili() {
        return titleSwahili;
    }

    public void setTitleSwahili(String titleSwahili) {
        this.titleSwahili = titleSwahili;
    }

    public String getTitleEnglish() {
        return titleEnglish;
    }

    public void setTitleEnglish(String titleEnglish) {
        this.titleEnglish = titleEnglish;
    }
}
