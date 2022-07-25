/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 06:00
 */

package com.sda.HymnesAdventiste.navigation;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.sda.HymnesAdventiste.R;
import com.sda.HymnesAdventiste.chant.Hymnes_et_lg;
import com.sda.HymnesAdventiste.chant.Nyimbo_z_kristo;
import com.sda.HymnesAdventiste.menu.Apropos;
import com.sda.HymnesAdventiste.parametres.Parametres;


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