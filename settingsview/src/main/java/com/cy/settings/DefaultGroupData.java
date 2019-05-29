package com.cy.settings;

import java.util.ArrayList;
import java.util.List;

public class DefaultGroupData implements IGroupData {

    private List<ISubItemData> mISubItemData = new ArrayList<>();
    private String mGroupTitle;
    @Override
    public IGroupData addSubItem(ISubItemData subItemData) {
        mISubItemData.add(subItemData);
        return this;
    }

    @Override
    public List<ISubItemData> getSubItems() {
        return mISubItemData;
    }

    @Override
    public String getGroupTitle() {
        return mGroupTitle;
    }

    @Override
    public IGroupData setGroupTitle(String groupTitle) {
        mGroupTitle=groupTitle;
        return this;
    }
}
