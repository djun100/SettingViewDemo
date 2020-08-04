package com.cy.settings;

import android.app.Activity;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.cy.settingsview.R;
import com.cy.view.popupwindow.PopUpAdapter;
import com.cy.view.popupwindow.PopupItem;
import com.cy.view.popupwindow.UtilPopup;

import java.util.List;

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
    public int getGroupTitleRes() {
        return R.id.tvTitle;
    }

    @Override
    public void bindView(final int position, SubItemView itemView,
                         IGroupData groupData, final ISubItemData subItemData) {

        ImageView mIvIcon =itemView.findViewById(R.id.ivIcon);
        TextView mTvTitle = itemView.findViewById(R.id.tvTitle);
        TextView mTvTitleValue = itemView.findViewById(R.id.tvTitleValue);
        TextView mTvContent = itemView.findViewById(R.id.tvContent);
        View mDivider =itemView.findViewById(R.id.vDivider);
        SwitchCompat mSwitchCompat = itemView.findViewById(R.id.switchCompat);
        CheckBox mCheckBox =itemView.findViewById(R.id.checkbox);
        final TextView mTvSubTitle = itemView.findViewById(R.id.tvSubTitle);
        ImageView mIvArrow =itemView.findViewById(R.id.ivArrow);


        mTvTitle.setText(((DefaultSubItemData) subItemData).getTitle());
        if (position == groupData.getSubItems().size() - 1) {
            mDivider.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(((DefaultSubItemData) subItemData).getTitleValue())){
            mTvTitleValue.setVisibility(View.VISIBLE);
            mTvSubTitle.setVisibility(View.GONE);
            mTvTitleValue.setText(((DefaultSubItemData) subItemData).getTitleValue());
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
            if (((DefaultSubItemData) subItemData).getDefaultSwitchOn()){
                mSwitchCompat.setChecked(true);
            }
        }
        if (((DefaultSubItemData) subItemData).getShowCheckbox()){
            mCheckBox.setVisibility(View.VISIBLE);
            mIvArrow.setVisibility(View.GONE);
            mCheckBox.setChecked(((DefaultSubItemData) subItemData).getCheckboxChecked());
        }
        if (((DefaultSubItemData) subItemData).getDrawableRight()>0){
            mIvArrow.setVisibility(View.VISIBLE);
            mIvArrow.setImageResource(((DefaultSubItemData) subItemData).getDrawableRight());
        }
        if (((DefaultSubItemData) subItemData).getShowArrow()){
            mIvArrow.setVisibility(View.VISIBLE);
        }
        if (!TextUtils.isEmpty(((DefaultSubItemData) subItemData).getSubTitle())){
            mTvSubTitle.setVisibility(View.VISIBLE);
            mTvSubTitle.setText(((DefaultSubItemData) subItemData).getSubTitle());
        }
        if (!TextUtils.isEmpty(((DefaultSubItemData) subItemData).getShowSpinner())){
            final List<String> data = ((DefaultSubItemData) subItemData).getSpinnerDatas();
            final UtilPopup utilPopup = UtilPopup.create()
                    .setOnItemClickListener(new PopUpAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            mTvSubTitle.setText(data.get(position));
                            // TODO: 2019/5/29 处理业务逻辑

                        }
                    })
                    .setPopupItems(PopupItem.convert(data));

            mTvSubTitle.setVisibility(View.VISIBLE);
            mTvSubTitle.setText(((DefaultSubItemData) subItemData).getShowSpinner());
            mTvSubTitle.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_down,0);
            mTvSubTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (utilPopup.isShowing()){
                        utilPopup.dismiss();
                    }else {
                        utilPopup.showAsDropDown(mTvSubTitle);
                    }
                }
            });

        }

        bindViewMore(position, itemView, groupData, subItemData);
    }

    /**margin padding clicklistener switchcompat`s event and so on
     * @param position
     * @param itemView
     * @param groupData
     * @param subItemData
     */
    public abstract void bindViewMore(int position, SubItemView itemView,
                                      IGroupData groupData, ISubItemData subItemData);

    public void notifyDatasetChanged(){

    }
}
