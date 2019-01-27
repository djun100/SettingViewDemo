package com.cy.settingviewdemo;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public interface ISettings {
    List<IGroupData> getSettingsData();
    int getGroupContainerLayoutRes();
    int getGroupItemLayoutRes();
    void bindView(View item,ISubItemData subItemData);
    void addItem(ViewGroup viewGroup, View item);
    ViewGroup build();
}
