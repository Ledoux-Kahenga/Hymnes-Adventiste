/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 16:32
 */

package com.sda.HymnesAdventiste.chant.favoris;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sda.HymnesAdventiste.chant.models.Model;
import com.sda.HymnesAdventiste.R;
import com.sda.HymnesAdventiste.database.DBcantique;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
    Context context;
    List<Model> mainModels;
    DBcantique dBcantique;

    public FavoriteAdapter(Context context, List<Model> mainModels) {
        this.context = context;
        this.mainModels = mainModels;
    }

    @NonNull
    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DBcantique dBcantique = new DBcantique(context);
        View view = LayoutInflater.from(context).inflate(R.layout.liste_chant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder holder, int position) {

        holder.titreSwahil.setText(mainModels.get(position).getTitleSwahili());
        holder.titreEnglish.setText((mainModels.get(position).getTitleEnglish()));
        holder.number.setText(mainModels.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView number, titreSwahil, titreEnglish, contenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            contenu = (TextView) itemView.findViewById(R.id.liste_conteu);
            number = (TextView) itemView.findViewById(R.id.liste_num);
            titreSwahil = (TextView) itemView.findViewById(R.id.liste_titre);
            titreEnglish = (TextView) itemView.findViewById(R.id.liste_auteur);

        }
    }
}
