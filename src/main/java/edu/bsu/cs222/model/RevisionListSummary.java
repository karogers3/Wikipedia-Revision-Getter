package edu.bsu.cs222.model;

import java.util.List;

public class RevisionListSummary {

    public StringBuilder summaryOfRevisions(List<Revision> revisionList) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        int maxLength = sizeOfLongestUsername(revisionList) + 6; // length of "User: " = 6
        String userNameFormat = "%-" + maxLength + "s";
        for (Revision revision : revisionList) {
            // length of "Timestamp: " + "yyyy.MM.ddTHH:mm:ssZ" = 31
            // Largest digit will be 30, which is why there is a 2 in "%-2d."
            String revisionString = String.format("\n%-2d. " + userNameFormat + " %-31s\n", i, "User: " +
                            revision.getUsername(), "Timestamp: " + revision.getTimestamp());
            stringBuilder.append(revisionString);
            i++;
        }
        return stringBuilder;
    }

    private int sizeOfLongestUsername(List<Revision> revisionList) {
        int maxLength = 0;
        for (Revision revision : revisionList) {
            int revisionLength = revision.getUsername().length();
            if (maxLength < revisionLength) {
                maxLength = revisionLength;
            }
        }
        return maxLength;
    }

}
