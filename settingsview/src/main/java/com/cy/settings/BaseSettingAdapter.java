package com.cy.settings;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseSettingAdapter implements ISettings {

    /**
     * inflate switchcompat 所在布局所用的上下文必须为activity上下文，否则不显示
     */
    protected Activity mActivity;

    public BaseSettingAdapter(Activity activity) {
        mActivity = activity;
    }
    @Override
    public List<ViewGroup> build() {
        List<IGroupData> data = getSettingsData();
        List<ViewGroup> viewGroups = new ArrayList<>();

        for (IGroupData groupData : data) {
            LinearLayout groupContainerLayout =
                    (LinearLayout) LayoutInflater.from(mActivity)
                            .inflate(getGroupLayoutRes(), null);

            for (int i = 0; i < groupData.getSubItems().size(); i++) {
                ISubItemData subItem = groupData.getSubItems().get(i);
                View subItemView = LayoutInflater.from(mActivity)
                        .inflate(getItemLayoutRes(), null);
                bindView(i, subItemView, groupData, subItem);

                ViewGroup derectContainerView = groupContainerLayout
                        .findViewById(getGroupContainerViewId());
                derectContainerView.addView(subItemView);
            }
            viewGroups.add(groupContainerLayout);
        }
        return viewGroups;
    }

}
