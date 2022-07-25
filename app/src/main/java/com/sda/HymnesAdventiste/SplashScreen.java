/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 06:00
 */

package com.sda.HymnesAdventiste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.sda.HymnesAdventiste.parametres.SharedPref;

public class SplashScreen extends AppCompatActivity {

    private final int SPLASH_SCREEN_TIMEOUT = 1800;
    Animation topAnim, topAnim_texte, bottomAnim, bottomAnim_texte, leftAnim, rightAnim;

    ImageView livre1, livre2;
    TextView hymne1, hymne2, hymne3, nyimbo1, nyimbo2, nyimbo3;
    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPref = new SharedPref(this);
        if (sharedPref.loardDarkModeState()){
            setTheme(R.style.AppThemeDark);
            getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.primary_fond_splash2));
        }else {
            setTheme(R.style.AppThemeLight);
            getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.primary_fond_splash1));
        }

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        // Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        topAnim_texte = AnimationUtils.loadAnimation(this, R.anim.top_anim_texte);
        bottomAnim_texte = AnimationUtils.loadAnimation(this, R.anim.bottom_anim_texte);

        leftAnim = AnimationUtils.loadAnimation(this, R.anim.left_anim);
        rightAnim = AnimationUtils.loadAnimation(this, R.anim.right_anim);

        // Hooks
        livre1 = findViewById(R.id.livre1);
        livre2 = findViewById(R.id.livre2);

        hymne1 = findViewById(R.id.hymne1);
        hymne2 = findViewById(R.id.hymne2);
        hymne3 = findViewById(R.id.hymne3);
        nyimbo1 = findViewById(R.id.nyimbo1);
        nyimbo2 = findViewById(R.id.nyimbo2);
        nyimbo3 = findViewById(R.id.nyimbo3);

        // Definitions des animations

        livre1.setAnimation(topAnim);
        livre2.setAnimation(bottomAnim);

        hymne1.setAnimation(topAnim_texte);
        hymne2.setAnimation(leftAnim);
        hymne3.setAnimation(topAnim_texte);

        nyimbo1.setAnimation(bottomAnim_texte);
        nyimbo2.setAnimation(rightAnim);
        nyimbo3.setAnimation(bottomAnim_texte);

        // rediriger vers la page principale "MainActivity" apres 3 sececondes
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Demarer une page
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_TIMEOUT);
    }
}