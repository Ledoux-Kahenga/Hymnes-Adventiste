/*
 *  Created by TVB Ledoux on 23/07/22 20:59
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 23/07/22 19:22
 */

package com.sda.projet.chant.favoris;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sda.projet.MainModel;
import com.sda.projet.Model;
import com.sda.projet.R;
import com.sda.projet.database.DBcantique;


import java.util.ArrayList;
import java.util.List;

public class FavAdapteur extends RecyclerView.Adapter<FavAdapteur.ViewHolder>{

    Context context;
    ArrayList id, number, titleSwahili, TitleEnglis;
    List<Model> mainModels;
    DBcantique dBcantique;

//    public FavAdapteur(Context context, ArrayList id, ArrayList number, ArrayList titleSwahili, ArrayList titleEnglis) {
//        this.context = context;
//        this.id = id;
//        this.number = number;
//        this.titleSwahili = titleSwahili;
//        this.TitleEnglis = titleEnglis;
//    }


    public FavAdapteur(Context context, List<Model> mainModels) {
        this.context = context;
        this.mainModels = mainModels;
    }

    @NonNull
    @Override
    public FavAdapteur.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        DBcantique dBcantique = new DBcantique(context);
        View view = LayoutInflater.from(context).inflate(R.layout.liste_chant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavAdapteur.ViewHolder holder, int position) {

        holder.titreSwahil.setText(mainModels.get(position).getTitleSwahili());
        holder.titreEnglish.setText((mainModels.get(position).getTitleEnglish()));
        holder.number.setText(mainModels.get(position).getNumber());
//        final  MainModel mainModel = list.get(position);
//
//        readCursorData();

    }


    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView number, titreSwahil, titreEnglish, contenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            contenu = (TextView) itemView.findViewById(R.id.liste_conteu);
            number = (TextView) itemView.findViewById(R.id.liste_num);
            titreSwahil = (TextView) itemView.findViewById(R.id.liste_titre);
            titreEnglish = (TextView) itemView.findViewById(R.id.liste_auteur);

        }
    }

//    private void readCursorData() {
//        Cursor cursor = dBcantique.readAllData();
//        SQLiteDatabase db = dBcantique.getReadableDatabase();
//
//    }
}
