package edu.bsu.cs222.model;

public class Revision {
    private final String timestamp;
    private final String username;

    public Revision(String timestamp, String username) {
        this.timestamp = timestamp;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    public String getTimestamp() {return timestamp;
    }


}
