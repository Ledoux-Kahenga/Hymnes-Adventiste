/*
 *  Created by TVB Ledoux on 23/07/22 20:59
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 22/07/22 17:30
 */

package com.sda.projet.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.sda.projet.R;
import com.sda.projet.navigation.HomeFragment;
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideRight(getApplicationContext());
    }
}