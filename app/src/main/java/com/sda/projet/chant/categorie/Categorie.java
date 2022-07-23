/*
 *  Created by TVB Ledoux on 23/07/22 20:59
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 23/07/22 20:21
 */

package com.sda.projet.chant.categorie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.sda.projet.Model;
import com.sda.projet.PagerNyimbo;
import com.sda.projet.R;
import com.sda.projet.chant.favoris.FavAdapteur;
import com.sda.projet.chant.favoris.NyimboFav;
import com.sda.projet.chant.model.adapteur.viewpager.transform.AccordionTransformer;
import com.sda.projet.database.DBcantique;

import java.util.ArrayList;
import java.util.List;

public class Categorie extends AppCompatActivity {

    DBcantique dBcantique;
    List<Model> model = new ArrayList<>();
    ViewPager viewPager;
    PagerCategorie pagerCategorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        viewPager = (ViewPager)findViewById(R.id.view_pager4);
        viewPager.setPageTransformer(true,new AccordionTransformer());

        dBcantique = new DBcantique(Categorie.this);

        storeDataInArray();


    }

    private void storeDataInArray() {

        SQLiteDatabase database = dBcantique.getReadableDatabase();
        Cursor cursor = dBcantique.readAllData();
        try {
            while (cursor.moveToNext()){
                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(dBcantique.ID)));
                String number = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_NUMBER));
                String titreShahili = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_TITLE_SWAHILI));
                String titreEnglish = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_TITLE_ENGLISH));
                Model mainModel = new Model(id,number,titreShahili,titreEnglish);
                model.add(mainModel);

            }

        }finally {
            if (cursor != null && cursor.isClosed()){
                cursor.close();
                database.close();
            }
            pagerCategorie = new PagerCategorie(Categorie.this ,model);
            viewPager.setAdapter(pagerCategorie);
        }
    }
}