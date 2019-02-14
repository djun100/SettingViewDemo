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

    public ImageView mIvIcon;
    public TextView mTvTitle;
    public TextView mTvContent;
    public View mDivider;
    public SwitchCompat mSwitchCompat;
    public CheckBox mCheckBox;
    public TextView mTvSubTitle;
    public ImageView mIvArrow;

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

         mIvIcon =itemView.findViewById(R.id.ivIcon);
         mTvTitle = itemView.findViewById(R.id.tvTitle);
         mTvContent = itemView.findViewById(R.id.tvContent);
         mDivider =itemView.findViewById(R.id.vDivider);
         mSwitchCompat = itemView.findViewById(R.id.switchCompat);
         mCheckBox =itemView.findViewById(R.id.checkbox);
         mTvSubTitle = itemView.findViewById(R.id.tvSubTitle);
         mIvArrow =itemView.findViewById(R.id.ivArrow);


        mTvTitle.setText(((DefaultSubItemData) subItemData).title);
        if (position == groupData.getSubItems().size() - 1) {
            mDivider.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(((DefaultSubItemData) subItemData).content)){
            mTvContent.setVisibility(View.VISIBLE);
            mTvContent.setText(((DefaultSubItemData) subItemData).content);
        }
        if (((DefaultSubItemData) subItemData).drawableLeft>0){
            mIvIcon.setImageResource(((DefaultSubItemData) subItemData).drawableLeft);
            mIvIcon.setVisibility(View.VISIBLE);
        }
        if (((DefaultSubItemData) subItemData).showSwitch){
            mSwitchCompat.setVisibility(View.VISIBLE);
            mIvArrow.setVisibility(View.GONE);
        }
        if (((DefaultSubItemData) subItemData).showCheckbox){
            mCheckBox.setVisibility(View.VISIBLE);
            mIvArrow.setVisibility(View.GONE);
            mCheckBox.setChecked(((DefaultSubItemData) subItemData).checkboxChecked);
        }
        if (!TextUtils.isEmpty(((DefaultSubItemData) subItemData).subTitle)){
            mTvSubTitle.setVisibility(View.VISIBLE);
            mTvSubTitle.setText(((DefaultSubItemData) subItemData).subTitle);
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
