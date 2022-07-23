/*
 *  Created by TVB Ledoux on 23/07/22 20:59
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 23/07/22 20:12
 */

package com.sda.projet.navigation;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.sda.projet.R;
import com.sda.projet.chant.Hymnes_et_lg;
import com.sda.projet.chant.Nyimbo_z_kristo;
import com.sda.projet.chant.categorie.Categorie;
import com.sda.projet.chant.favoris.NyimboFav;


import java.util.Calendar;
import java.util.Date;


public class HomeFragment extends Fragment {
    Context context;
    private HomeViewModel homeViewModel;

    private TextView acceuil;

    public static int getDayNumberOld(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.get(7);
    }

    public static int getHours(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.get(11);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.homeViewModel = (HomeViewModel) new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);




        acceuil = (TextView) root.findViewById(R.id.titreacceuil);

        if (isSabbath()) {
            acceuil.setText(getResources().getString(R.string.sabbat));

        } else {
            acceuil.setText(getResources().getString(R.string.bienvenu));

        }



        ((ImageView) root.findViewById(R.id.img_livre2)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeFragment.this.startActivity(new Intent(HomeFragment.this.getActivity(), Nyimbo_z_kristo.class));
                Animatoo.animateSlideLeft(HomeFragment.this.getContext());
            }
        });

        ((ImageView) root.findViewById(R.id.img_livre1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeFragment.this.startActivity(new Intent(HomeFragment.this.getActivity(), Hymnes_et_lg.class));
                Animatoo.animateSlideRight(HomeFragment.this.getContext());
            }
        });

        ((ImageView) root.findViewById(R.id.nyimboFav)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeFragment.this.startActivity(new Intent(HomeFragment.this.getActivity(), NyimboFav.class));
                Animatoo.animateSlideRight(HomeFragment.this.getContext());
            }
        });

        ((ImageView) root.findViewById(R.id.nyimboCat)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeFragment.this.startActivity(new Intent(HomeFragment.this.getActivity(), Categorie.class));
                Animatoo.animateSlideRight(HomeFragment.this.getContext());
            }
        });



        return root;
    }

    public boolean isSabbath() {
        if (getDayNumberOld(new Date()) == 6 && getHours(new Date()) > 16 ) {
            return true;
        }
        if (getDayNumberOld(new Date()) != 7 || getHours(new Date()) >= 18) {
            return false;
        }
        return true;
    }

}
