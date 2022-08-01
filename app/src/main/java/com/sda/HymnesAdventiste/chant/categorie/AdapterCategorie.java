///*
// *  Created by TVB Ledoux on 23/07/22 20:59
// *  Copyright (c) 2022 . All rights reserved.
// *  Last modified 23/07/22 20:39
// */
//
//package com.sda.HymnesAdventiste.chant.categorie;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.text.Html;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.viewpager.widget.PagerAdapter;
//
//import com.sda.HymnesAdventiste.chant.models.Model;
//import com.sda.HymnesAdventiste.R;
//import com.sda.HymnesAdventiste.database.DBcantique;
//
//import java.util.List;
//
//public class PagerCategorie extends PagerAdapter {
//
//    Context context;
//    List<Model> models;
//    LayoutInflater inflater;
//    DBcantique dBcantique;
//
//    public PagerCategorie(Context context, List<Model> models) {
//        this.context = context;
//        this.models = models;
//        inflater = LayoutInflater.from(context);
//    }
//
//    @Override
//    public int getCount() {
//        return models.size();
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view == object;
//    }
//
//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        container.removeView((ViewGroup) object);
//    }
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//
//        DBcantique dBcantique = new DBcantique(context);
//        // inflate View
//
////        AudioPlay audioC = new AudioPlay(position);
//        View view = inflater.inflate(R.layout.chant1, container, false);
//
//        TextView num = (TextView) view.findViewById(R.id.movie_texte);
//        TextView titleSwahili = (TextView) view.findViewById(R.id.movie_title);
//        TextView titreEnlish = (TextView) view.findViewById(R.id.movie_auteur);
//        TextView liryc = (TextView) view.findViewById(R.id.movie_texte_description);
//        ImageView AddFavorite = view.findViewById(R.id.imageBack);
//        int id;
//        id = models.get(position).getId();
//
//
//            num.setText(models.get(position).getNumber());
//            titleSwahili.setText(models.get(position).getTitleSwahili());
//            titreEnlish.setText(models.get(position).getTitleEnglish());
//            liryc.setText(Html.fromHtml(models.get(position).getLyric()));
//
//
//
//
//        AddFavorite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Model model = models.get(position);
//
//                if (model.getLyricFavorite() == 0){
//
//                    model.setLyricFavorite(1);
//                    dBcantique.AddToFavorite(id);
//                    AddFavorite.setImageResource(R.drawable.ic_coeur2);
//                    Toast.makeText(context, "Vous avez Ajouter ce chant aux favoris", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    model.setLyricFavorite(0);
//                    dBcantique.RemoveToFavorite(models.get(position).getId());
//                    AddFavorite.setImageResource(R.drawable.ic_coeur1);
//                    Toast.makeText(context, "Vous avez Supprimer ce chant des favoris", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//
//
//        container.addView(view);
//        return view;
//    }
//
//}
