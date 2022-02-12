package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class RevisionParser {

    public List<Revision> parse(String dataString) {
        JSONArray userNames = JsonPath.read(dataString, "$..user");
        JSONArray timeStamps = JsonPath.read(dataString, "$..timestamp");
        List<Revision> revisionList = new ArrayList<>();
        for (int i = 0; i < userNames.size(); i++) {
            Revision revision = new Revision(timeStamps.get(i).toString(), userNames.get(i).toString());
            revisionList.add(revision);
        }
        return revisionList;
    }
}
