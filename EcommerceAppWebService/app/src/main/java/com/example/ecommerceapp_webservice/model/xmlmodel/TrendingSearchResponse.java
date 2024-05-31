package com.example.ecommerceapp_webservice.model.xmlmodel;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "channel", strict = false)
public class TrendingSearchResponse {
    @ElementList(inline = true)
    private List<TrendingSearchItem> itemList;

    public TrendingSearchResponse() {
    }

    public TrendingSearchResponse(List<TrendingSearchItem> itemList) {
        this.itemList = itemList;
    }

    public List<TrendingSearchItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<TrendingSearchItem> itemList) {
        this.itemList = itemList;
    }
}
