package com.cy.settingviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout mllSettingsContainerAct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("demo");
        setContentView(R.layout.activity_main);
        mllSettingsContainerAct=findViewById(R.id.mllSettingsContainerAct);

        ISettings adapter=new SettingsAdapter();
        ViewGroup viewGroup = adapter.build();
        mllSettingsContainerAct.addView(viewGroup);
    }
}
