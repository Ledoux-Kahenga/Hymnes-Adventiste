/*
 *  Created by TVB Ledoux on 10/07/22 22:19
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 10/07/22 22:15
 */

//package com.sda.projet.chant.model.adapteur.viewpager;
//
//import android.content.Context;
import android.text.Html;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.viewpager.widget.PagerAdapter;
//
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.sda.projet.MainModel;
//import com.sda.projet.R;
//
//import java.util.List;
//
//public class ViewPaginationAdapteur extends PagerAdapter {
//
//
//    Context context;
//    List<MainModel> mainModelList;
//    LayoutInflater inflater;
//
//    public ViewPaginationAdapteur(Context context, List<MainModel> mainModelList) {
//        this.context = context;
//        this.mainModelList = mainModelList;
//        inflater = LayoutInflater.from(context);
//    }
//
//    @Override
//    public int getCount() {
//        return mainModelList.size();
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view == object;
//    }
//
//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        container.removeView((ViewGroup)object);
//    }
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        // inflate View
//        View view = inflater.inflate(R.layout.chant,container,false);
//
//        //view
//        TextView num = (TextView) view.findViewById(R.id.movie_texte);
//        TextView titre = (TextView) view.findViewById(R.id.movie_title);
//        TextView auter = (TextView) view.findViewById(R.id.movie_texte_description);
//
//        FloatingActionButton btn_fav = (FloatingActionButton)view.findViewById(R.id.btn_fav);
//
//        //set data
//        num.setText(Html.fromHtml(mainModelList.get(position).num));
//        titre.setText(Html.fromHtml(mainModelList.get(position).titre));
//        auter.setText(Html.fromHtml(mainModelList.get(position).auteur));
//
//        //Event
////        btn_fav.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Toast.makeText(context, "Favoris Clicker", Toast.LENGTH_SHORT).show();
////            }
////        });
//
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Titre Clicker", Toast.LENGTH_SHORT).show();
//            }
//        });
//        container.addView(view);
//        return view;
//    }
//}
