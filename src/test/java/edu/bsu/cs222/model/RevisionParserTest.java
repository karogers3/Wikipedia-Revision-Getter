package edu.bsu.cs222.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class RevisionParserTest {

    @Test
    public void testParse() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("SoupQuery.json");
        String name = parser.parse(testDataStream);
        Assertions.assertEquals("G\u00fcnniX", name);
    }
}
