package com.cy.settings;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public interface ISettings {
    List<IGroupData> getSettingsData();
    int getGroupLayoutRes();
    int getGroupContainerViewId();
    int getItemLayoutRes();

    /**
     * @param position
     * @param itemView  inflated form getItemLayoutRes()
     * @param groupData
     * @param subItemData
     */
    void bindView(int position, View itemView,IGroupData groupData ,ISubItemData subItemData);
    List<ViewGroup> build();
}
