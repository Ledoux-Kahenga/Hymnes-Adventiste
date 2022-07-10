/*
 *  Created by TVB Ledoux on 10/07/22 22:19
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 10/07/22 22:15
 */

package com.sda.projet.navigation;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.sda.projet.R;
import com.sda.projet.chant.Hymnes_et_lg;
import com.sda.projet.chant.Nyimbo_z_kristo;
import com.sda.projet.menu.Apropos;
import com.sda.projet.parametres.Parametres;


public class MenuFragment extends Fragment {
    private MenuViewModel menuViewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.menuViewModel = (MenuViewModel) new ViewModelProvider(this).get(MenuViewModel.class);
        View root = inflater.inflate(R.layout.fragment_menu, container, false);
        ((RelativeLayout) root.findViewById(R.id.h_el_l)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MenuFragment.this.startActivity(new Intent(MenuFragment.this.getActivity(), Hymnes_et_lg.class));
            }
        });

        ((RelativeLayout) root.findViewById(R.id.nzk)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MenuFragment.this.startActivity(new Intent(MenuFragment.this.getActivity(), Nyimbo_z_kristo.class));
            }
        });

        ((RelativeLayout) root.findViewById(R.id.parametre)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MenuFragment.this.startActivity(new Intent(MenuFragment.this.getActivity(), Parametres.class));
            }
        });

        ((RelativeLayout) root.findViewById(R.id.apropos)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MenuFragment.this.startActivity(new Intent(MenuFragment.this.getActivity(), Apropos.class));
            }
        });
        return root;
    }
}