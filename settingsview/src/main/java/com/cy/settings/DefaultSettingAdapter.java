package com.cy.settings;

import android.app.Activity;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

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

        ImageView mIvIcon =itemView.findViewById(R.id.ivIcon);
        TextView mTvTitle = itemView.findViewById(R.id.tvTitle);
        TextView mTvContent = itemView.findViewById(R.id.tvContent);
        View mDivider =itemView.findViewById(R.id.vDivider);
        SwitchCompat mSwitchCompat = itemView.findViewById(R.id.switchCompat);
        CheckBox mCheckBox =itemView.findViewById(R.id.checkbox);
        TextView mTvSubTitle = itemView.findViewById(R.id.tvSubTitle);
        ImageView mIvArrow =itemView.findViewById(R.id.ivArrow);


        mTvTitle.setText(((DefaultSubItemData) subItemData).getTitle());
        if (position == groupData.getSubItems().size() - 1) {
            mDivider.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(((DefaultSubItemData) subItemData).getContent())){
            mTvContent.setVisibility(View.VISIBLE);
            mTvContent.setText(((DefaultSubItemData) subItemData).getContent());
        }
        if (((DefaultSubItemData) subItemData).getDrawableLeft()>0){
            mIvIcon.setImageResource(((DefaultSubItemData) subItemData).getDrawableLeft());
            mIvIcon.setVisibility(View.VISIBLE);
        }
        if (((DefaultSubItemData) subItemData).getShowSwitch()){
            mSwitchCompat.setVisibility(View.VISIBLE);
            mIvArrow.setVisibility(View.GONE);
        }
        if (((DefaultSubItemData) subItemData).getShowCheckbox()){
            mCheckBox.setVisibility(View.VISIBLE);
            mIvArrow.setVisibility(View.GONE);
            mCheckBox.setChecked(((DefaultSubItemData) subItemData).getCheckboxChecked());
        }
        if (((DefaultSubItemData) subItemData).getShowArrow()){
            mIvArrow.setVisibility(View.VISIBLE);
        }
        if (!TextUtils.isEmpty(((DefaultSubItemData) subItemData).getSubTitle())){
            mTvSubTitle.setVisibility(View.VISIBLE);
            mTvSubTitle.setText(((DefaultSubItemData) subItemData).getSubTitle());
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
