package edu.bsu.cs222.model;

import java.util.List;

public class RevisionListSummary {

    //TODO: Find length of longest username in a revision list.

    public StringBuilder UpToThirtyRevisions(List<Revision> revisionList) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (Revision revision : revisionList) {
            String revisionString = String.format("\n%-2d. %s %-31s\n", i, "User: " + revision.getUsername(),
                    "Timestamp: " + revision.getTimestamp());
            stringBuilder.append(revisionString);
            i++;
        }
        return stringBuilder;
    }

}
