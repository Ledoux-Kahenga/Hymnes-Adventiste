/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 06:00
 */

package com.sda.HymnesAdventiste.chant.audio;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlay {

    public static MediaPlayer mediaPlayer;

    public static void playAudio(Context context, int id){
        mediaPlayer = MediaPlayer.create(context, id);

        if (!mediaPlayer.isPlaying()){

            mediaPlayer.start();
        }
    }

    public static void stopAudio(){
        mediaPlayer.release();
        mediaPlayer = null;
    }


}
