package com.cy.settings;

import java.util.List;

public interface IGroupData {
    IGroupData addSubItem(ISubItemData subItemData);
    List<ISubItemData> getSubItems();
}
