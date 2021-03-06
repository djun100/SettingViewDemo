package com.cy.settingviewdemo;

import android.app.Activity;
import android.view.View;

import com.cy.io.Log;
import com.cy.settings.DefaultGroupData;
import com.cy.settings.DefaultSettingAdapter;
import com.cy.settings.DefaultSubItemData;
import com.cy.settings.IGroupData;
import com.cy.settings.ISubItemData;
import com.cy.settings.SubItemView;

import java.util.ArrayList;
import java.util.List;

public class SettingsAdapter extends DefaultSettingAdapter {


    public SettingsAdapter(Activity activity) {
        super(activity);
    }

    @Override
    public List<IGroupData> getSettingsData() {
        List<IGroupData> data = new ArrayList<>();

        IGroupData groupData = new DefaultGroupData();
        groupData
                .addSubItem(
                        DefaultSubItemData.create()
                                .setTitle("清空缓存")
                                .setTitleValue("500M")
                                .setDrawableRight(R.drawable.ic_delete))
                .addSubItem(
                        DefaultSubItemData.create()
                                .setTitle("国家地区")
                                .setShowArrow(true));
        data.add(groupData);

        List<String> netConditions = new ArrayList<>();
        netConditions.add("仅Wi-Fi网络");
        netConditions.add("总是自动播放");
        netConditions.add("永不播放");

        IGroupData groupData2 = new DefaultGroupData();
        groupData2.setGroupTitle("自动播放")
                .addSubItem(DefaultSubItemData.create()
                        .setTitle("自动播放专辑相似节目")
                        .setContent("专辑列表播放结束后，将自动播放相似的推荐节目")
                        .setShowSpinner("仅Wi-Fi网络", netConditions))

                .addSubItem(DefaultSubItemData.create()
                        .setTitle("其他")
                        .setDrawableLeft(R.drawable.ic_launcher_background))

                .addSubItem(DefaultSubItemData.create()
                        .setTitle("相册")
                        .setSubTitle("本地相册"))
                .addSubItem(DefaultSubItemData.create()
                        .setTitle("断点续播")
                        .setShowSwitch(true))
                .addSubItem(DefaultSubItemData.create()
                        .setTitle("流浪地球.rmvb")
                        .setContent("/Users/cy/cy/projects/android/CommonLayout/app/src/main/java/com/cy/commonlayout/MainActivity.java")
                        .setShowCheckbox(true)
                );
        data.add(groupData2);

        return data;
    }


    @Override
    public void bindViewMore(int position, final SubItemView itemView,
                             IGroupData groupData, ISubItemData subItemData) {

        if (((DefaultSubItemData) subItemData).getTitle().equals("流浪地球.rmvb")) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i();
                    itemView.getCheckbox().setChecked(!itemView.getCheckbox().isChecked());
                }
            });
        }
    }

}
