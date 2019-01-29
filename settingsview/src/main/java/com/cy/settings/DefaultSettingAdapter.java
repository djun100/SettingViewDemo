package com.cy.settings;

import android.app.Activity;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cy.settingsview.R;

public abstract class DefaultSettingAdapter extends BaseSettingAdapter {
    public DefaultSettingAdapter(Activity activity) {
        super(activity);
    }

    @Override
    public int getGroupLayoutRes() {
        return R.layout.item_setting_group;
    }

    @Override
    public int getGroupContainerViewId() {
        return R.id.parent;
    }

    @Override
    public int getItemLayoutRes() {
        return R.layout.item_setting_group_item;
    }

    @Override
    public void bindView(int position, View itemView,
                         IGroupData groupData, ISubItemData subItemData) {

        ImageView ivIcon=itemView.findViewById(R.id.ivIcon);
        TextView tvTitle = itemView.findViewById(R.id.tvTitle);
        View divider=itemView.findViewById(R.id.vDivider);
        SwitchCompat switchCompat = itemView.findViewById(R.id.switchCompat);
        TextView tvSubTitle = itemView.findViewById(R.id.tvSubTitle);
        ImageView ivArrow=itemView.findViewById(R.id.ivArrow);


        tvTitle.setText(((DefaultSubItemData) subItemData).title);
        if (position == groupData.getSubItems().size() - 1) {
            divider.setVisibility(View.GONE);
        }
        if (((DefaultSubItemData) subItemData).drawableLeft>0){
            ivIcon.setImageResource(((DefaultSubItemData) subItemData).drawableLeft);
            ivIcon.setVisibility(View.VISIBLE);
        }
        if (((DefaultSubItemData) subItemData).showSwitch){
            switchCompat.setVisibility(View.VISIBLE);
            ivArrow.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(((DefaultSubItemData) subItemData).subTitle)){
            tvSubTitle.setVisibility(View.VISIBLE);
            tvSubTitle.setText(((DefaultSubItemData) subItemData).subTitle);
        }

        bindViewMore(position, itemView, groupData, subItemData);
    }

    /**margin padding clicklistener switchcompat`s event and so on
     * @param position
     * @param itemView
     * @param groupData
     * @param subItemData
     */
    public abstract void bindViewMore(int position, View itemView,
                                      IGroupData groupData, ISubItemData subItemData);
}
