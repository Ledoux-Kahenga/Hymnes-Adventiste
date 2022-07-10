package com.sda.projet;

import java.util.List;

public interface IFirebaseLoadDone {
    void onFirebaseLoadSuccess(List<MainModel> mainModelList);
    void onFirebaseFailed(String message);
}
