/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 17:16
 */

package com.sda.HymnesAdventiste.chant.favoris;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.sda.HymnesAdventiste.chant.chantActivity.NyimboActivity;
import com.sda.HymnesAdventiste.chant.models.Model;
import com.sda.HymnesAdventiste.R;
import com.sda.HymnesAdventiste.database.DBcantique;


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

        String posItm = mainModels.get(position).getNumber();
        int varIndex = Integer.parseInt(posItm);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, NyimboActivity.class);
                intent.putExtra("pose", varIndex - 1);

                context.startActivity(intent);
                Animatoo.animateSplit(context);
            }
        });
//
//        readCursorData();

    }


    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView number, titreSwahil, titreEnglish, contenu;
        int favo;

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
