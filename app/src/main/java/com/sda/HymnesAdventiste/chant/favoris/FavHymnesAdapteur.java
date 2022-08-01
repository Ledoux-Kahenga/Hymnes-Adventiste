/*
 *  Created by TVB Ledoux on 01/08/22 18:55
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 01/08/22 15:41
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
import com.sda.HymnesAdventiste.R;
import com.sda.HymnesAdventiste.chant.chantActivity.HynesActivity;
import com.sda.HymnesAdventiste.chant.chantActivity.NyimboActivity;
import com.sda.HymnesAdventiste.chant.models.Model;
import com.sda.HymnesAdventiste.database.DBcantique;

import java.util.ArrayList;
import java.util.List;

public class FavHymnesAdapteur extends RecyclerView.Adapter<FavHymnesAdapteur.ViewHolder>{

    Context context;
    ArrayList id, number, titleSwahili, TitleEnglis;
    List<Model> mainModels;
    DBcantique dBcantique;

//    public FavNyimboAdapteur(Context context, ArrayList id, ArrayList number, ArrayList titleSwahili, ArrayList titleEnglis) {
//        this.context = context;
//        this.id = id;
//        this.number = number;
//        this.titleSwahili = titleSwahili;
//        this.TitleEnglis = titleEnglis;
//    }


    public FavHymnesAdapteur(Context context, List<Model> mainModels) {
        this.context = context;
        this.mainModels = mainModels;
    }

    @NonNull
    @Override
    public FavHymnesAdapteur.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        DBcantique dBcantique = new DBcantique(context);
        View view = LayoutInflater.from(context).inflate(R.layout.liste_chant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavHymnesAdapteur.ViewHolder holder, int position) {

        holder.titreSwahil.setText(mainModels.get(position).getTitleSwahili().substring(6));
        holder.titreEnglish.setText((mainModels.get(position).getTitleEnglish()));
        holder.number.setText(mainModels.get(position).getNumber());

//        final  MainModel mainModel = list.get(position);

        String posItm = mainModels.get(position).getNumber();
        int varIndex = Integer.parseInt(posItm);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, HynesActivity.class);
                intent.putExtra("pos", varIndex - 1);

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
