package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RevisionParser {

    public String parse(InputStream testDataStream) throws IOException {
        JSONArray result = (JSONArray) JsonPath.read(testDataStream, "$..user");
        List<Revision> revisionList = new ArrayList<Revision>();
        Revision revision = new Revision(null, result.get(0).toString());
        return revision.getUsername();
    }
}
