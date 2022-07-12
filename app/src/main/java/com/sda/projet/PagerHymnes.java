/*
 *  Created by TVB Ledoux on 12/07/22 21:29
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 12/07/22 21:28
 */

package com.sda.projet;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PagerHymnes extends PagerAdapter {

    Context context;
    List<MainModel> mainModelList;
    LayoutInflater inflater;
//    private  boolean flags = true;
//    private  MediaPlayer mediaPlayer;
//    private static MediaPlayer mp2 = null;
//    private static boolean myIsPlaying = false;
//    private static int nowPlaying;
//    private int DisplayedSongNo;
//
    private List<String> allmp3 = new ArrayList();

//    ArrayList<String> StrigList;
//    MediaPlayer mediaPlayer;


    public PagerHymnes(Context context, List<MainModel> mainModelList) {
        this.context = context;
        this.mainModelList = mainModelList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mainModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
             container.removeView((ViewGroup)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        // inflate View

//        Audio audioC = new Audio(position);
        View view = inflater.inflate(R.layout.chant,container,false);


        String refer;

        //view
        TextView num = (TextView) view.findViewById(R.id.movie_texte);
        TextView titre = (TextView) view.findViewById(R.id.movie_title);
        TextView contenu = (TextView) view.findViewById(R.id.movie_texte_description);
        TextView auteur = (TextView) view.findViewById(R.id.movie_auteur);
        ImageView audio = (ImageView) view.findViewById(R.id.audio);
        ImageView ref = (ImageView) view.findViewById(R.id.ref);
        String midi;


        //set data
        num.setText(Html.fromHtml(mainModelList.get(position).num));
        titre.setText(Html.fromHtml(mainModelList.get(position).titre));
        contenu.setText(Html.fromHtml(mainModelList.get(position).contenu));
        auteur.setText(Html.fromHtml(mainModelList.get(position).auteur));
        refer =  mainModelList.get(position).ref;
        midi = mainModelList.get(position).chemin;
         int varRef = Integer.parseInt(refer);


        ref.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MainActivity3.class);
                intent.putExtra("pose", varRef-1);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                context.startActivity(intent);
                Animatoo.animateSpin(context);
            }
        });



                audio.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        int resID = context.getResources().getIdentifier(midi,"raw",context.getPackageName());


                        MediaPlayer mediaPlayer = MediaPlayer.create(context, resID);
                        mediaPlayer.start();


                    }

                });



        container.addView(view);
        return view;
    }



}
