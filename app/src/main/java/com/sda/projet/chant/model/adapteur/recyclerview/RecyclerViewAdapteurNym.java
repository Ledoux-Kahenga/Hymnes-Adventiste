package com.sda.projet.chant.model.adapteur.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
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
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.sda.projet.MainActivity2;
import com.sda.projet.MainActivity3;
import com.sda.projet.MainModel;
import com.sda.projet.MainModel2;
import com.sda.projet.R;
import com.sda.projet.chant.Nyimbo_z_kristo;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class RecyclerViewAdapteurNym extends RecyclerView.Adapter<RecyclerViewAdapteurNym.ViewHolder> {

    Context context;
    ArrayList<MainModel2> list;
    ArrayList<MainModel2> ListSearch;
    //Recherche des chants
    private Timer timer;

    public RecyclerViewAdapteurNym(Context context, ArrayList<MainModel2> list) {
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

        MainModel2 mainModel = list.get(position);

        holder.numero.setText(Html.fromHtml(mainModel.getNum()));
        holder.titre.setText(Html.fromHtml(mainModel.getTitre()));
        holder.auteur.setText(Html.fromHtml(mainModel.getAuteur()));
        holder.contenu.setText(Html.fromHtml(mainModel.getContenu()));

        String posItm = list.get(position).getNum();
        int varIndex = Integer.parseInt(posItm);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MainActivity3.class);
                intent.putExtra("pose", varIndex - 1);

                context.startActivity(intent);
                Animatoo.animateSplit(context);
            }
        });

        if(holder.getAdapterPosition()>-1){
//            item_principale = (RelativeLayout) itemView.findViewById(R.id.item_principal);
          Animation  translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_item);
           holder.itemView.startAnimation(translate_anim);
//            item_principale.setAnimation(translate_anim);

        }
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
                    ArrayList<MainModel2> temp = new ArrayList();
                    for (MainModel2 liste : ListSearch ) {
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

    public class ViewHolder extends RecyclerView.ViewHolder{

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
