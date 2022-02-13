package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class WikiPageAuthenticator {
    public boolean doesPageExist(String wikiPage) {
        JSONArray pageID = JsonPath.read(wikiPage, "$..pageid");
        return pageID.size() > 0;
    }
}
