package edu.bsu.cs222.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WikiPageFetcher {

    public String getWikiPageInfo(String wikiURL) throws IOException {
        URL url = verifyURL(wikiURL);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "RevisionParser/0.1 (karogers3@bsu.edu; nplian@bsu.edu)");
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader();
        return inputStreamReader.makeString(inputStream);
    }

    private URL verifyURL(String wikiURL) {
        try {
            return new URL(wikiURL);
        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }
    }
}
