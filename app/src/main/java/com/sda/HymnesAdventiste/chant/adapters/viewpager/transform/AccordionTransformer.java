/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 16:30
 */

package com.sda.HymnesAdventiste.chant.adapters.viewpager.transform;

import android.view.View;

public class AccordionTransformer extends ABaseTransformer {

    public void onTransform(View view, float f) {
        view.setPivotX(f < 0.0f ? 0.0f : (float) view.getWidth());
        view.setScaleX(f < 0.0f ? f + 1.0f : 1.0f - f);
    }
}