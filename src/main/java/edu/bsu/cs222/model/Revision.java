package edu.bsu.cs222.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Revision {
    private final String username;
    private final Date timestamp;

    public Revision(Date timestamp, String username) {
        this.timestamp = timestamp;
        this.username = username;
    }

    public String getUsername() {

        return username;
    }

    public String getTimestamp() {
        SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return timestampFormat.format(timestamp);
    }


}
