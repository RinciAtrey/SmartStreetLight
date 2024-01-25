package com.app.Models;

import java.util.List;

public class DataModel {
    private List<String> poles;
    private String itemText;
    private boolean isExpandable;

    public DataModel(List<String> poles, String itemText) {
        this.poles = poles;
        this.itemText = itemText;
        isExpandable = false;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }

    public List<String> getPoles() {
        return poles;
    }

    public String getItemText() {
        return itemText;
    }

    public boolean isExpandable() {
        return isExpandable;
    }
}
