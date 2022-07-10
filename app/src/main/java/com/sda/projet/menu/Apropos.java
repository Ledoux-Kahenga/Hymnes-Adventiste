/*
 *  Created by TVB Ledoux on 10/07/22 22:19
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 10/07/22 22:15
 */

package com.sda.projet.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sda.projet.R;
import com.sda.projet.parametres.SharedPref;

public class Apropos extends AppCompatActivity {

    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPref = new SharedPref(this);
        if (sharedPref.loardDarkModeState()){
            setTheme(R.style.AppThemeDark);
        }else {
            setTheme(R.style.AppThemeLight);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apropos);
    }
}