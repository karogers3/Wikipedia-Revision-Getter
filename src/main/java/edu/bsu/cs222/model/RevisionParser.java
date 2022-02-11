package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RevisionParser {

    public String parse(InputStream testDataStream) throws IOException {
        Scanner scanner = new Scanner(testDataStream);
        String jsonString = scanner.nextLine();
        JSONArray result = (JSONArray) JsonPath.read(jsonString, "$..user");
        JSONArray result2 = (JSONArray) JsonPath.read(jsonString, "$..timestamp");
        List<Revision> revisionList = new ArrayList<Revision>();
        Revision revision = new Revision(result2.get(0).toString(), result.get(0).toString());
        return revision.getUsername();
    }
}
