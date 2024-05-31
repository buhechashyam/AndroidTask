package com.example.materialuicomponent.recyclerview.model;

public class ExpandableData {

    int image;
    String title;
    String description;
    boolean isVisible;

    public ExpandableData(int image, String title, String description, boolean isVisible) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.isVisible = isVisible;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
