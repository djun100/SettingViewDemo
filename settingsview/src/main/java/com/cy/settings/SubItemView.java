package com.cy.settings;

import android.content.Context;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cy.settingsview.R;

public class SubItemView extends RelativeLayout {
    public SubItemView(Context context) {
        super(context);
        init();
    }

    public SubItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SubItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
//        View.inflate(getContext(), R.layout.item_setting_group_item, this);
        LayoutInflater.from(getContext()).inflate(R.layout.item_setting_group_item,this);
//        LayoutInflater.from(getContext()).inflate(R.layout.item_setting_group_item,this,true);
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
    }

    public TextView getTitle(){
        return findViewById(R.id.tvTitle);
    }

    public TextView getTitleValue(){
        return findViewById(R.id.tvTitleValue);
    }

    public ImageView getIcon(){
        return findViewById(R.id.ivIcon);
    }

    public TextView getSubTitle(){
        return findViewById(R.id.tvSubTitle);
    }

    public TextView getContent(){
        return findViewById(R.id.tvContent);
    }

    public SwitchCompat getSwitchCompat(){
        return findViewById(R.id.switchCompat);
    }

    public CheckBox getCheckbox(){
        return findViewById(R.id.checkbox);
    }

    public ImageView getArrow(){
        return findViewById(R.id.ivArrow);
    }

}
