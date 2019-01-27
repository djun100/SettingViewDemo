package com.cy.settingviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cy.app.UtilContext;

import java.util.ArrayList;
import java.util.List;

public class SettingsAdapter implements ISettings {
    @Override
    public List<IGroupData> getSettingsData() {
        List<IGroupData> data = new ArrayList<>();

        IGroupData groupData = new DefaultGroupData();
        groupData.addSubItem(new DefaultSubItemData("支付"));
        data.add(groupData);

        IGroupData groupData2 = new DefaultGroupData();
        groupData2.addSubItem(new DefaultSubItemData("收藏"))
                .addSubItem(new DefaultSubItemData("相册"));
        data.add(groupData2);

        return data;
    }

    @Override
    public int getGroupContainerLayoutRes() {
        return R.layout.item_setting_group;
    }

    @Override
    public int getGroupItemLayoutRes() {
        return R.layout.item_setting_group_item;
    }

    @Override
    public void bindView(View item, ISubItemData subItemData) {
        TextView textView = item.findViewById(R.id.title);
        textView.setText(((DefaultSubItemData) subItemData).title);
    }

    @Override
    public void addItem(ViewGroup viewGroup, View item) {
        LinearLayout mllSettingsContainer = viewGroup.findViewById(R.id.parent);
        mllSettingsContainer.addView(item);
    }

    @Override
    public ViewGroup build() {
        List<IGroupData> data = getSettingsData();
        ViewGroup containerView = (ViewGroup) LayoutInflater.from(UtilContext.getContext()).inflate(R.layout.setting_container, null);
        LinearLayout mllSettingsContainer = containerView.findViewById(R.id.mllSettingsContainer);

        for (IGroupData groupData : data) {
            ViewGroup groupView = (ViewGroup) LayoutInflater.from(UtilContext.getContext()).inflate(getGroupContainerLayoutRes(), null);

            for (ISubItemData subItem : groupData.getSubItems()) {
                View subItemView = LayoutInflater.from(UtilContext.getContext()).inflate(getGroupItemLayoutRes(), null);
                bindView(subItemView, subItem);
                addItem(groupView, subItemView);
            }

            mllSettingsContainer.addView(groupView);
        }

        return containerView;
    }
}
