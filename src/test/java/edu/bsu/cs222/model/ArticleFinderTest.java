package edu.bsu.cs222.model;

import edu.bsu.cs222.model.ArticleFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArticleFinderTest {

    @Test
    public void testURLString() {
        ArticleFinder finder = new ArticleFinder();
        String url = finder.findArticle("Apples");
        boolean result = url.equals("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Apples&rvprop=timestamp|user&rvlimit=30&redirects");
        Assertions.assertTrue(result);
    }

}