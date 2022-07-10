/*
 *  Created by TVB Ledoux on 10/07/22 22:19
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 10/07/22 22:15
 */

package com.sda.projet.parametres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sda.projet.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapteur extends ArrayAdapter {


    public CustomAdapteur(@NonNull Context context, ArrayList<CustomItem> customItems) {
        super(context, 0, customItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner, parent, false);
        }

        CustomItem item = (CustomItem) getItem(position);
        ImageView spinnerIv = convertView.findViewById(R.id.ivSpinner_layout);
        TextView spinnerTv = convertView.findViewById(R.id.tvSpinner_layout);

        if (item != null) {
            spinnerIv.setImageResource(item.getSpinnerItemImage());
            spinnerTv.setText(item.getSpinnerItemNane());
        }

        return convertView;

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_drop_down, parent, false);
        }

        CustomItem item = (CustomItem) getItem(position);

        ImageView dropDownIv = convertView.findViewById(R.id.ivDropDown_layout);
        TextView dropDownTv = convertView.findViewById(R.id.tvDropDownayout);

        if (item != null) {
            dropDownIv.setImageResource(item.getSpinnerItemImage());
            dropDownTv.setText(item.getSpinnerItemNane());
        }
        return convertView;
    }
}
