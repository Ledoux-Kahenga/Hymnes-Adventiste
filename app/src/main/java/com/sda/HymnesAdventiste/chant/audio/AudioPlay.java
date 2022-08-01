/*
 *  Created by TVB Ledoux on 01/08/22 18:55
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 01/08/22 16:55
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
            mediaPlayer.setLooping(true);
        }
    }

    public static void stopAudio(){
        mediaPlayer.release();
        mediaPlayer = null;
    }


}
