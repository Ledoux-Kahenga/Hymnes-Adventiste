/*
 *  Created by TVB Ledoux on 01/08/22 18:55
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 01/08/22 15:39
 */

package com.sda.HymnesAdventiste.chant.adapters.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.sda.HymnesAdventiste.chant.chantActivity.HynesActivity;
import com.sda.HymnesAdventiste.chant.chantActivity.NyimboActivity;
import com.sda.HymnesAdventiste.chant.models.MainModel;
import com.sda.HymnesAdventiste.R;
import com.sda.HymnesAdventiste.chant.models.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;

public class RecyclerViewAdapteurHymne extends RecyclerView.Adapter<RecyclerViewAdapteurHymne.ViewHolder> {

    Context context;
    //    ArrayList<MainModel2> list;
    List<Model> ListSearch; // refere..........

    List<Model> models;
    //Recherche des chants
    private Timer timer;


    public RecyclerViewAdapteurHymne(Context context, List<Model> models) {
        this.context = context;
        this.models = models;
        ListSearch = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.liste_chant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Model model = models.get(position);

        holder.numero.setText(Html.fromHtml(model.getNumber()));
        holder.titre.setText(Html.fromHtml(model.getTitleSwahili().substring(6)));
        holder.auteur.setText(Html.fromHtml(model.getTitleEnglish()));
        holder.contenu.setText(Html.fromHtml(model.getLyric()));

        String posItm = models.get(position).getNumber();
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

        if(holder.getAdapterPosition()>-1){
//            item_principale = (RelativeLayout) itemView.findViewById(R.id.item_principal);
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_item);
            holder.itemView.startAnimation(translate_anim);
//            item_principale.setAnimation(translate_anim);

        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void rechercheChant(final String searchkeyword) {
        Timer timer = new Timer();
        this.timer = timer;
        timer.schedule(new TimerTask() {
            public void run() {
                if (searchkeyword.trim().isEmpty()) {

                    models = ListSearch;
                } else {
                    List<Model> temp = new ArrayList<>();
                    for (Model liste : ListSearch ) {
                        if (liste.getNumber().toLowerCase().contains(searchkeyword.toLowerCase()) || liste.getTitleSwahili().toLowerCase().contains(searchkeyword.toLowerCase()) || liste.getLyric().toLowerCase().contains(searchkeyword.toLowerCase())) {
                            temp.add(liste);
                        }
                    }
                    models = temp;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        notifyDataSetChanged();
                    }
                });
            }
        }, 500);
    }

    public void suppTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView numero, titre, auteur, contenu;
        RelativeLayout item_principale;
//        Context context;

        //Animation item
        Animation translate_anim;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contenu = (TextView) itemView.findViewById(R.id.liste_conteu);
            numero = (TextView) itemView.findViewById(R.id.liste_num);
            titre = (TextView) itemView.findViewById(R.id.liste_titre);
            auteur = (TextView) itemView.findViewById(R.id.liste_auteur);

        }
    }
}
