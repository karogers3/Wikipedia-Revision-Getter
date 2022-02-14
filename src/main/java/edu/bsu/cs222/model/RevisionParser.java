package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RevisionParser {

    public List<Revision> parse(String dataString) {

        JSONArray userNames = JsonPath.read(dataString, "$..user");
        JSONArray timeStamps = JsonPath.read(dataString, "$..timestamp");
        List<Revision> revisionList = new ArrayList<>();
        for (int i = 0; i < userNames.size(); i++) {
            Revision revision = new Revision(stringToDate(timeStamps.get(i).toString()), userNames.get(i).toString());
            revisionList.add(revision);
        }
        return revisionList;
    }

    public Date stringToDate(String stringDate) {
        SimpleDateFormat timeStamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = new Date();
        try {
            date = timeStamp.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
