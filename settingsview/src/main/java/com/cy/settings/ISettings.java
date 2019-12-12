package com.cy.settings;

import android.view.ViewGroup;

import java.util.List;

public interface ISettings {
    List<IGroupData> getSettingsData();
    int getGroupLayoutRes();
    int getGroupContainerViewId();
    int getItemLayoutRes();
    int getGroupTitleRes();

    /**
     * @param position
     * @param itemView  inflated form getItemLayoutRes()
     * @param groupData
     * @param subItemData
     */
    void bindView(int position, SubItemView itemView,IGroupData groupData ,ISubItemData subItemData);
    List<ViewGroup> build();
}
