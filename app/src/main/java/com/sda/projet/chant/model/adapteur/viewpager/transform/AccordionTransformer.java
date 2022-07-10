package com.sda.projet.chant.model.adapteur.viewpager.transform;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class AccordionTransformer extends ABaseTransformer {

    public void onTransform(View view, float f) {
        view.setPivotX(f < 0.0f ? 0.0f : (float) view.getWidth());
        view.setScaleX(f < 0.0f ? f + 1.0f : 1.0f - f);
    }
}