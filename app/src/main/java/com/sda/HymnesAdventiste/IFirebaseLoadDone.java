/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 16:32
 */

package com.sda.HymnesAdventiste;

import com.sda.HymnesAdventiste.chant.models.MainModel;

import java.util.List;

public interface IFirebaseLoadDone {
    void onFirebaseLoadSuccess(List<MainModel> mainModelList);
    void onFirebaseFailed(String message);
}
