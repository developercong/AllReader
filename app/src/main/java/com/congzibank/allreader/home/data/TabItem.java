package com.congzibank.allreader.home.data;

/**
 * description of tab
 * @author wangcong
 */
public class TabItem {

    private String tabTitle;
    private int selectIconId;
    private int unselectIconId;
    private int selectColor;
    private int unbselectColor;

    private TabStatus status;
    private boolean enable;

    public TabItem(String tabTitle, int iconId) {
        this(tabTitle, iconId, TabStatus.NONE, true);
    }

    public TabItem(String tabTitle, int iconId, TabStatus status, boolean enable) {
        this.tabTitle = tabTitle;
        this.iconId = iconId;
        this.status = status;
        this.enable = enable;
    }

    public String getTabTitle() {
        return tabTitle;
    }

    public TabItem setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
        return this;
    }

    public int getIconId() {
        return iconId;
    }

    public TabItem setIconId(int iconId) {
        this.iconId = iconId;
        return this;

    }

    public TabStatus getStatus() {
        return status;
    }

    public TabItem setStatus(TabStatus status) {
        this.status = status;
        return this;
    }

    public boolean isEnable() {
        return enable;
    }

    public TabItem setEnable(boolean enable) {
        this.enable = enable;
        return this;
    }

    public enum TabStatus{
        NONE, //默认状态
        SELECTED, //选中状态
        UNSELECTED,  //未选中状态

    }
}
