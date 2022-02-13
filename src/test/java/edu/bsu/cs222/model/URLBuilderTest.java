package edu.bsu.cs222.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class URLBuilderTest {
    URLBuilder urlBuilder = new URLBuilder();

    @Test
    public void testURL() {
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&" +
                "titles=Soup&rvprop=timestamp|user&rvlimit=30&redirects", urlBuilder.makeURL("Soup"));
    }

    @Test
    public void testURLWithSpace() {
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&" +
                        "titles=national+football+league&rvprop=timestamp|user&rvlimit=30&redirects",
                urlBuilder.makeURL("national football league"));
    }
}
