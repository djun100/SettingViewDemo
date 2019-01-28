package com.cy.settingviewdemo;

import android.os.Bundle;

import com.cy.host.mvp.BaseMVPActivity;
import com.cy.settings.SettingsView;

public class MainActivity extends BaseMVPActivity {
    SettingsView mSettingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("demo");
        setContentView(R.layout.activity_main);
        mSettingView=findViewById(R.id.mSettingView);
        mSettingView.setAdapter(new SettingsAdapter(this));

    }

    @Override
    protected void baseInit1Data() {

    }

    @Override
    protected void baseInit2View() {

    }
}
