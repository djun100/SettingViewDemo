package com.cy.settings;

public class DefaultSubItemData implements ISubItemData {
    private String title;
    private String content;
    private String subTitle;
    private int drawableLeft;
    private boolean showSwitch;
    private boolean showCheckbox;
    private boolean checkboxChecked;
    private boolean showArrow;

    private DefaultSubItemData() {
    }

    public static DefaultSubItemData create(){
        return new DefaultSubItemData();
    }

    public String getTitle() {
        return title;
    }

    public DefaultSubItemData setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public DefaultSubItemData setContent(String content) {
        this.content = content;
        return this;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public DefaultSubItemData setSubTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    public int getDrawableLeft() {
        return drawableLeft;
    }

    public DefaultSubItemData setDrawableLeft(int drawableLeft) {
        this.drawableLeft = drawableLeft;
        return this;
    }

    public boolean getShowSwitch() {
        return showSwitch;
    }

    public DefaultSubItemData setShowSwitch(boolean showSwitch) {
        this.showSwitch = showSwitch;
        return this;
    }

    public boolean getShowCheckbox() {
        return showCheckbox;
    }

    public DefaultSubItemData setShowCheckbox(boolean showCheckbox) {
        this.showCheckbox = showCheckbox;
        return this;
    }

    public boolean getCheckboxChecked() {
        return checkboxChecked;
    }

    public DefaultSubItemData setCheckboxChecked(boolean checkboxChecked) {
        this.checkboxChecked = checkboxChecked;
        return this;
    }

    public boolean getShowArrow() {
        return showArrow;
    }

    public DefaultSubItemData setShowArrow(boolean showArrow) {
        this.showArrow = showArrow;
        return this;
    }
}
