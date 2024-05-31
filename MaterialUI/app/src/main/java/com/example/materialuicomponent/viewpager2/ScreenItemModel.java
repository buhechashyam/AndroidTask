package com.example.materialuicomponent.viewpager2;

public class ScreenItemModel {

    int itemImg;
    String itemTitle, description;

    public ScreenItemModel(int itemImg, String itemTitle, String description) {
        this.itemImg = itemImg;
        this.itemTitle = itemTitle;
        this.description = description;
    }

    public int getItemImg() {
        return itemImg;
    }

    public void setItemImg(int itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
