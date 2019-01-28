package com.cy.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.cy.settingsview.R;

import java.util.List;

public class SettingsView extends ScrollView {
    ISettings mSettings;
    LinearLayout mLinearLayout;

    public SettingsView(Context context) {
        super(context);
    }

    public SettingsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SettingsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.setting_container,this);
        mLinearLayout=findViewById(R.id.mllInternalSettingsContainer);

        List<ViewGroup> viewGroups = mSettings.build();
        for (ViewGroup view : viewGroups) {
            mLinearLayout.addView(view);
        }
    }

    public void setAdapter(ISettings settings) {
        mSettings = settings;
        init();
    }
}
