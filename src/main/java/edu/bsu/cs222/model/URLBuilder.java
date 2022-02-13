package edu.bsu.cs222.model;

import java.net.URLEncoder;
import java.nio.charset.Charset;

public class URLBuilder {

    public String makeURL(String articleTitle) {
        String encodedArticleTitle = URLEncoder.encode(articleTitle, Charset.defaultCharset());
        String wikiURL = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                "%s&rvprop=timestamp|user&rvlimit=30&redirects";
        return String.format(wikiURL, encodedArticleTitle);
    }
}
