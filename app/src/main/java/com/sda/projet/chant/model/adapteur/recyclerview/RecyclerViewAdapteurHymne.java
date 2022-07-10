/*
 *  Created by TVB Ledoux on 10/07/22 22:19
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 10/07/22 22:15
 */

package com.sda.projet.chant.model.adapteur.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.sda.projet.MainActivity2;
import com.sda.projet.MainModel;
import com.sda.projet.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;

public class RecyclerViewAdapteurHymne extends RecyclerView.Adapter<RecyclerViewAdapteurHymne.ViewHolder> {

    Context context;
    ArrayList<MainModel> list;
    ArrayList<MainModel> ListSearch;
    //Recherche des chants
    private Timer timer;

    public RecyclerViewAdapteurHymne(Context context, ArrayList<MainModel> list) {
        this.context = context;
        this.list = list;
        ListSearch = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.liste_chant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        MainModel mainModel = list.get(position);

        holder.numero.setText(Html.fromHtml(mainModel.getNum()));
        holder.titre.setText(Html.fromHtml(mainModel.getTitre()));
        holder.auteur.setText(Html.fromHtml(mainModel.getAuteur()));
        holder.contenu.setText(Html.fromHtml(mainModel.getContenu()));

        String posItm = list.get(position).getNum();
        int varIndex = Integer.parseInt(posItm);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("pos", varIndex - 1);

                context.startActivity(intent);
                Animatoo.animateSplit(context);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void rechercheChant(final String searchkeyword) {
        Timer timer = new Timer();
        this.timer = timer;
        timer.schedule(new TimerTask() {
            public void run() {
                if (searchkeyword.trim().isEmpty()) {

                    list = ListSearch;
                } else {
                    ArrayList<MainModel> temp = new ArrayList();
                    for (MainModel liste : ListSearch ) {
                        if (liste.getNum().toLowerCase().contains(searchkeyword.toLowerCase()) || liste.getTitre().toLowerCase().contains(searchkeyword.toLowerCase()) || liste.getContenu().toLowerCase().contains(searchkeyword.toLowerCase())) {
                            temp.add(liste);
                        }
                    }
                    list = temp;
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contenu = (TextView) itemView.findViewById(R.id.liste_conteu);
            numero = (TextView) itemView.findViewById(R.id.liste_num);
            titre = (TextView) itemView.findViewById(R.id.liste_titre);
            auteur = (TextView) itemView.findViewById(R.id.liste_auteur);

        }
    }
}
