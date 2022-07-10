/*
 *  Created by TVB Ledoux on 10/07/22 22:19
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 10/07/22 22:15
 */

package com.sda.projet;

import java.util.List;

public interface IFirebaseLoadDone {
    void onFirebaseLoadSuccess(List<MainModel> mainModelList);
    void onFirebaseFailed(String message);
}
