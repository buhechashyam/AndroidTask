package com.example.ecommerceapp_webservice.model.xmlmodel;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)
public class TrendingSearchItem {
    @Element(name = "title")
    private String title;
    @Element(name = "description", required = false)
    private String description;
    @Element(name = "link")
    private String link;

    public TrendingSearchItem() {
    }

    public TrendingSearchItem(String title, String description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
