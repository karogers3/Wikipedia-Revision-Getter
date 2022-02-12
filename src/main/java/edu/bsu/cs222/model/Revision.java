package edu.bsu.cs222.model;

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
    public Date getTimestamp() {return timestamp;
    }


}
