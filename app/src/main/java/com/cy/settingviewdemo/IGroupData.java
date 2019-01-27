package com.cy.settingviewdemo;

import java.util.List;

public interface IGroupData {
    IGroupData addSubItem(ISubItemData subItemData);
    List<ISubItemData> getSubItems();
}
