/*
 *  Created by TVB Ledoux on 23/07/22 20:59
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 22/07/22 17:30
 */

package com.sda.projet;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.Html;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.PagerAdapter;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sda.projet.animation.TranslateAnimationUtil;
import com.sda.projet.chant.Nyimbo_z_kristo;
import com.sda.projet.chant.audio.AudioPlay;

import java.util.ArrayList;
import java.util.List;

public class PagerNyimbo extends PagerAdapter {

    Context context;
    List<MainModel2> mainModelList2;
    LayoutInflater inflater;
    LayoutInflater inflatere;
    FloatingActionButton bottomsheet;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;

    RelativeLayout relativeLayoutZoomm;
    NestedScrollView nestedScrollView;

    ImageView zoomIn, zoomOut;
    float x;


    MediaPlayer mediaPlayer;
    ImageView btn_Sup, btn_Go;
    TextView affichage;
    private Dialog dialog;
    private Dialog dialogs;


    public PagerNyimbo(Context context, List<MainModel2> mainModelList2) {
        this.context = context;
        this.mainModelList2 = mainModelList2;
        inflater = LayoutInflater.from(context);
        inflatere = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mainModelList2.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ViewGroup) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        // inflate View

//        AudioPlay audioC = new AudioPlay(position);
        View view = inflater.inflate(R.layout.chant1, container, false);


        //view
        TextView num = (TextView) view.findViewById(R.id.movie_texte);
        TextView titre = (TextView) view.findViewById(R.id.movie_title);
        TextView contenu = (TextView) view.findViewById(R.id.movie_texte_description);
        TextView auteur = (TextView) view.findViewById(R.id.movie_auteur);
        ImageView audio = (ImageView) view.findViewById(R.id.audio);
        ImageView ref = (ImageView) view.findViewById(R.id.ref1);
        TextView refTexte = (TextView) view.findViewById(R.id.h_l_ref);
        ImageView back = view.findViewById(R.id.imageBacke);
        String midi;
        int reference;


        //set data
        num.setText(Html.fromHtml(mainModelList2.get(position).num));
        titre.setText(Html.fromHtml(mainModelList2.get(position).titre));
        contenu.setText(Html.fromHtml(mainModelList2.get(position).contenu));
        auteur.setText(Html.fromHtml(mainModelList2.get(position).auteur));
        midi = mainModelList2.get(position).chemin;
        reference = mainModelList2.get(position).ref;

        if (reference == 0) {
            refTexte.setText(" ");
        } else {
            refTexte.setText("H&L:" + reference);
        }

        nestedScrollView = view.findViewById(R.id.scrollv);
        relativeLayoutZoomm = view.findViewById(R.id.zoom);

        nestedScrollView.setOnTouchListener(new TranslateAnimationUtil(context, relativeLayoutZoomm));


        zoomIn = view.findViewById(R.id.zoomIn);
        zoomOut = view.findViewById(R.id.zoomOut);

        float max = 0;
        float min = 40;

        zoomIn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                x = contenu.getTextSize();

                if (x <= 40) {

                    Toast.makeText(context, R.string.moinsTaille, Toast.LENGTH_SHORT).show();

                } else {
                    contenu.setTextSize(TypedValue.COMPLEX_UNIT_PX, x - 5f);
                }


            }
        });

        zoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = contenu.getTextSize();

                if (x >= 110) {
                    Toast.makeText(context, R.string.plusTaille, Toast.LENGTH_SHORT).show();
                } else {
                    contenu.setTextSize(TypedValue.COMPLEX_UNIT_PX, x + 5f);
                }

            }

        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Nyimbo_z_kristo.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
                try {

                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.release();
                        mediaPlayer = null;
//                    audio.setImageResource(R.drawable.ic_play_btn);
                    } else if (!mediaPlayer.isPlaying()) {
                        mediaPlayer = null;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


                Animatoo.animateSlideRight(context);
            }
        });


        int finalReference = reference;
        ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (finalReference < 1) {

                    dialog = new Dialog(context);
                    dialog.setContentView(R.layout.page_introuvable);
                    dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation_pageIntrouvable;

                    dialog.show();

                    ImageView Whatsapp = dialog.findViewById(R.id.Whatsapp);
                    Whatsapp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String var_NB = "N.B: Remplacer les (???) par le numero correspondant\n\n\n ";

                            try {
                                String headerReceiver = "tete";// Replace with your message.
                                String bodyMessageFormal = "corp";// Replace with your message.
                                String whatsappContain = headerReceiver + bodyMessageFormal;
                                String trimToNumner = "+243 972525920"; //10 digit number
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse("https://wa.me/" + trimToNumner + "/?text=" + var_NB + Html.fromHtml(mainModelList2.get(position).num + " - " + mainModelList2.get(position).titre + " = (???) ")));
                                context.startActivity(Intent.createChooser(intent, "Soumettez la reference"));
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    });

                    ImageView Gmail = dialog.findViewById(R.id.Gmail);
                    Gmail.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            try {

                                Intent intent = new Intent(Intent.ACTION_SENDTO);
                                intent.setData(Uri.parse("mailto:"));
                                String[] to = {"ledouxkahenga25@gmail.com"};
                                intent.putExtra(Intent.EXTRA_EMAIL, to);
                                intent.putExtra(Intent.EXTRA_SUBJECT, "LES REFERENCES DES NUMEROS NYIMBO ZA KRISTO - HYMNES ET LOUANGES ");
                                intent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(mainModelList2.get(position).num + " - " + mainModelList2.get(position).titre + " = ?????? "));
                                dialog.dismiss();
                                context.startActivity(Intent.createChooser(intent, "Soumettez la reference"));

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    ImageView Sms = dialog.findViewById(R.id.Sms);
                    Sms.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            try {
                                String var_NB = "N.B: Remplacer les (???) par le numero correspondant\n\n\n ";
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "0972525920", null));

                                intent.putExtra(Intent.EXTRA_TEXT, var_NB + mainModelList2.get(position).num + " - " + mainModelList2.get(position).titre + " = (???) ");
                                dialog.dismiss();
                                context.startActivity(Intent.createChooser(intent, "Soumettez la reference "));

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                } else {
                    Intent intent = new Intent(context, MainActivity2.class);
                    intent.putExtra("pos", finalReference - 1);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    context.startActivity(intent);
                    try {

                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.release();
                            mediaPlayer = null;
//                    audio.setImageResource(R.drawable.ic_play_btn);
                        } else if (!mediaPlayer.isPlaying()) {
                            mediaPlayer = null;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    audio.setImageResource(R.drawable.ic_play_btn);
                    Animatoo.animateSpin(context);
                }

            }
        });


        //    bottom sheet
        bottomsheet = view.findViewById(R.id.btn_sheet_nzk);
        bottomsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialogs = new Dialog(context);
                dialogs.setContentView(R.layout.clavier_numero);

                dialogs.show();
                dialogs.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialogs.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogs.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialogs.getWindow().setGravity(Gravity.BOTTOM);

                btn0 = dialogs.findViewById(R.id.btn0);
                btn1 = dialogs.findViewById(R.id.btn1);
                btn2 = dialogs.findViewById(R.id.btn2);
                btn3 = dialogs.findViewById(R.id.btn3);
                btn4 = dialogs.findViewById(R.id.btn4);
                btn5 = dialogs.findViewById(R.id.btn5);
                btn6 = dialogs.findViewById(R.id.btn6);
                btn7 = dialogs.findViewById(R.id.btn7);
                btn8 = dialogs.findViewById(R.id.btn8);
                btn9 = dialogs.findViewById(R.id.btn9);
                btn_Sup = dialogs.findViewById(R.id.btn_sup);
                btn_Go = dialogs.findViewById(R.id.btn_ok);
                affichage = dialogs.findViewById(R.id.txvDisplay);

                btn0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (affichage.length() <= 2) {
                            affichage.setText(affichage.getText() + "0");
                        } else {
                            affichage.setText(affichage.getText());
                        }

                    }
                });

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (affichage.length() <= 2) {
                            affichage.setText(affichage.getText() + "1");
                        } else {
                            affichage.setText(affichage.getText());
                        }

                    }
                });

                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (affichage.length() <= 2) {
                            affichage.setText(affichage.getText() + "2");
                        } else {
                            affichage.setText(affichage.getText());
                        }

                    }
                });

                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (affichage.length() <= 2) {
                            affichage.setText(affichage.getText() + "3");
                        } else {
                            affichage.setText(affichage.getText());
                        }

                    }
                });

                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (affichage.length() <= 2) {
                            affichage.setText(affichage.getText() + "4");
                        } else {
                            affichage.setText(affichage.getText());
                        }

                    }
                });

                btn5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (affichage.length() <= 2) {
                            affichage.setText(affichage.getText() + "5");
                        } else {
                            affichage.setText(affichage.getText());
                        }

                    }
                });

                btn6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (affichage.length() <= 2) {
                            affichage.setText(affichage.getText() + "6");
                        } else {
                            affichage.setText(affichage.getText());
                        }

                    }
                });

                btn7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (affichage.length() <= 2) {
                            affichage.setText(affichage.getText() + "7");
                        } else {
                            affichage.setText(affichage.getText());
                        }

                    }
                });

                btn8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (affichage.length() <= 2) {
                            affichage.setText(affichage.getText() + "8");
                        } else {
                            affichage.setText(affichage.getText());
                        }

                    }
                });

                btn9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (affichage.length() <= 2) {
                            affichage.setText(affichage.getText() + "9");
                        } else {
                            affichage.setText(affichage.getText());
                        }

                    }
                });

                btn_Sup.setOnClickListener(new View.OnClickListener() {
                    String val;

                    @Override
                    public void onClick(View v) {

                        try {
                            val = affichage.getText().toString();
                            val = val.substring(0, val.length() - 1);

                        } catch (StringIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }


                        affichage.setText(val);

                    }
                });

                btn_Go.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                String val = "bonjour";

                        int go = 0;

                        try {
                            go = Integer.parseInt(affichage.getText().toString());

                            if (go == 0 || go > 220) {

                                View layout = inflatere.inflate(R.layout.chant_introuvable, (ViewGroup) view.findViewById(R.id.exit_toast));
                                Toast toast = new Toast(context);
                                toast.setView(layout);
                                toast.setDuration(Toast.LENGTH_SHORT);
                                toast.show();
                                toast.setGravity(Gravity.CENTER, 0, 0);
                            } else {
                                Intent intent = new Intent(context, MainActivity3.class);
                                intent.putExtra("pose", go - 1);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                context.startActivity(intent);
                                Animatoo.animateFade(context);

                                dialogs.dismiss();

                            }

                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                    }

                });
            }
        });


        audio.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                int resID = context.getResources().getIdentifier(midi, "raw", context.getPackageName());


                if (AudioPlay.mediaPlayer == null) {

                    AudioPlay.playAudio(context, resID);
                    audio.setImageResource(R.drawable.ic_stop);

                } else if (AudioPlay.mediaPlayer != null) {

                    AudioPlay.stopAudio();
                    audio.setImageResource(R.drawable.ic_play_btn);
                }

            }

        });

        ImageView Share = view.findViewById(R.id.share);
        Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");

                intent.putExtra(Intent.EXTRA_TEXT, mainModelList2.get(position).num + " - " + mainModelList2.get(position).titre + "</br>" +  mainModelList2.get(position).contenu);
                context.startActivity(Intent.createChooser(intent, "Partager"));

            }
        });


        container.addView(view);
        return view;


    }

}
