package edu.bsu.cs222.model;

public class ArticleFinder {
    private String articleName;

    public String findArticle(String articleName) {
        String firstPartOfURL = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=";
        String secondPartOfURL = "&rvprop=timestamp|user&rvlimit=30&redirects";
        return firstPartOfURL + articleName + secondPartOfURL;
    }
}
