package com.example.ecommerceapp_webservice.model.xmlmodel;

import org.simpleframework.xml.Element;
        import org.simpleframework.xml.ElementList;
        import org.simpleframework.xml.Root;

        import java.util.List;

@Root(name = "rss", strict = false)
public class TrendingSearchResponseWrapper {
    @Element(name = "channel")
    private TrendingSearchResponse channel;

    public TrendingSearchResponseWrapper() {
    }

    public TrendingSearchResponseWrapper(TrendingSearchResponse channel) {
        this.channel = channel;
    }

    public TrendingSearchResponse getChannel() {
        return channel;
    }

    public void setChannel(TrendingSearchResponse channel) {
        this.channel = channel;
    }
}

