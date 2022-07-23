/*
 *  Created by TVB Ledoux on 23/07/22 20:59
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 23/07/22 20:39
 */

package com.sda.projet.chant.categorie;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.sda.projet.MainModel2;
import com.sda.projet.Model;
import com.sda.projet.R;
import com.sda.projet.database.DBcantique;

import java.util.ArrayList;
import java.util.List;

public class PagerCategorie extends PagerAdapter {

    Context context;
    List<Model> models;
    LayoutInflater inflater;

    public PagerCategorie(Context context, List<Model> models) {
        this.context = context;
        this.models = models;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ViewGroup) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        DBcantique dBcantique = new DBcantique(context);
        // inflate View

//        AudioPlay audioC = new AudioPlay(position);
        View view = inflater.inflate(R.layout.chant1, container, false);

        TextView num = (TextView) view.findViewById(R.id.movie_texte);
        TextView titleSwahili = (TextView) view.findViewById(R.id.movie_title);
        TextView titreEnlish = (TextView) view.findViewById(R.id.movie_auteur);
        int id;

        id = models.get(position).getId();
        num.setText(models.get(position).getNumber());
        titleSwahili.setText(models.get(position).getTitleSwahili());
        titreEnlish.setText(models.get(position).getTitleEnglish());

        container.addView(view);
        return view;
    }
}
