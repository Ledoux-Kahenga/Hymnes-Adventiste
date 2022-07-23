/*
 *  Created by TVB Ledoux on 23/07/22 20:59
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 23/07/22 20:21
 */

package com.sda.projet.chant.favoris;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.sda.projet.MainModel;
import com.sda.projet.Model;
import com.sda.projet.R;
import com.sda.projet.database.DBcantique;

import java.util.ArrayList;
import java.util.List;

public class NyimboFav extends AppCompatActivity {

    List<Model> model = new ArrayList<>();

    RecyclerView recyclerView;
    FavAdapteur favAdapteur;
    DBcantique dBcantique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyimbo_fav);

        recyclerView = findViewById(R.id.recyclerNyimboFav);

        dBcantique = new DBcantique(NyimboFav.this);

        storeDataInArray();


//        favAdapteur = new FavAdapteur(NyimboFav.this, id, number, titleSwahili, TitleEnglis);



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
            favAdapteur = new FavAdapteur(NyimboFav.this, model);
            recyclerView.setAdapter(favAdapteur);
            recyclerView.setLayoutManager(new LinearLayoutManager(NyimboFav.this));
        }
    }
}