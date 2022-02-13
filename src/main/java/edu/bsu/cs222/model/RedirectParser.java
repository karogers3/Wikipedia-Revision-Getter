package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class RedirectParser {

    public boolean doesPageRedirect(String wikiPage) {
        JSONArray redirects = JsonPath.read(wikiPage, "$..redirects");
        return redirects.size() > 0;
    }

    public String redirectedTo(String wikiPage) {
        JSONArray redirectsTo = JsonPath.read(wikiPage, "$..redirects..to");
        return redirectsTo.get(0).toString();
    }
}
