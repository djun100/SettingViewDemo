package com.cy.settingviewdemo;

import java.util.ArrayList;
import java.util.List;

public class DefaultGroupData implements IGroupData {

    public List<ISubItemData> mISubItemData = new ArrayList<>();

    @Override
    public IGroupData addSubItem(ISubItemData subItemData) {
        mISubItemData.add(subItemData);
        return this;
    }

    @Override
    public List<ISubItemData> getSubItems() {
        return mISubItemData;
    }
}
