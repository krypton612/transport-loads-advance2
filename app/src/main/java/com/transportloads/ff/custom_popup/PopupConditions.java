package com.transportloads.ff.custom_popup;


import android.content.Context;

import androidx.annotation.NonNull;

import com.lxj.xpopup.core.PositionPopupView;
import com.transportloads.ff.R;

public class PopupConditions extends PositionPopupView {
    public PopupConditions(@NonNull Context context){
        super(context);
    }

    @Override
    protected int getImplLayoutId(){ return R.layout.activity_popup_conditions; }
}
