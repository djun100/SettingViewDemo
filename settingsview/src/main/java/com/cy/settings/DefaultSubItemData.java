package com.cy.settings;

import java.util.List;

public class DefaultSubItemData implements ISubItemData {
    private String title;
    private String content;
    private String subTitle;
    private String titleValue;
    private int drawableLeft;
    private int drawableRight;
    private boolean showSwitch;
    private boolean defaultSwitchOn;
    private boolean showCheckbox;
    private boolean checkboxChecked;
    private boolean showArrow;
    private String showSpinner;
    private List<String> spinnerDatas;

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

    public String getTitleValue() {
        return titleValue;
    }

    public DefaultSubItemData setTitleValue(String titleValue) {
        this.titleValue = titleValue;
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

    public int getDrawableRight() {
        return drawableRight;
    }

    public DefaultSubItemData setDrawableRight(int drawableRight) {
        this.drawableRight = drawableRight;
        return this;
    }

    public boolean getShowSwitch() {
        return showSwitch;
    }

    public boolean getDefaultSwitchOn() {
        return defaultSwitchOn;
    }

    public DefaultSubItemData setShowSwitch(boolean defaultSwitchOn) {
        this.showSwitch = true;
        this.defaultSwitchOn = defaultSwitchOn;
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

    public String getShowSpinner() {
        return showSpinner;
    }

    public DefaultSubItemData setShowSpinner(String showSpinner,List<String> spinnerDatas) {
        this.showSpinner = showSpinner;
        this.spinnerDatas = spinnerDatas;
        return this;
    }

    public List<String> getSpinnerDatas() {
        return spinnerDatas;
    }

}
