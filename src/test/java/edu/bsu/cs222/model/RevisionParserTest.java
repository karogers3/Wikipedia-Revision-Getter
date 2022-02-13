package edu.bsu.cs222.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class RevisionParserTest {
    private final RevisionParser parser = new RevisionParser();
    private final InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("SoupQuery.json");
    private final InputStreamReader inputStreamReader = new InputStreamReader();
    private final String dataString = inputStreamReader.makeString(testDataStream);
    private final List<Revision> revisionList = parser.parse(dataString);

    @Test
    public void testGetNameOfFirstRevision() {
        Assertions.assertEquals("G\u00fcnniX", revisionList.get(0).getUsername());
    }

    @Test
    public void testGetTimeStampOfFirstRevision() {
        Assertions.assertEquals("2021-12-04T18:29:33Z", revisionList.get(0).getTimestamp());
    }

    @Test
    public void testGetNameOfLastRevision() {
        Assertions.assertEquals("Spencer", revisionList.get(revisionList.size()-1).getUsername());
    }

    @Test
    public void testGetTimeStampOfLastRevision() {
        Assertions.assertEquals("2020-06-17T22:42:45Z", revisionList.get(revisionList.size()-1).getTimestamp());
    }
}
