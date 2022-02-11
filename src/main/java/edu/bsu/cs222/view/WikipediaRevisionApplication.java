package edu.bsu.cs222.view;

import edu.bsu.cs222.model.RevisionParser;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class WikipediaRevisionApplication extends Application {

    public static void main(String[] args) {
        WikipediaRevisionApplication revisionApplication = new WikipediaRevisionApplication();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        try {
            String name = revisionApplication.getLatestRevisionOf(line);
            System.out.println(name);
        } catch (IOException ioException) {
            System.err.println("Network connection Problem: " + ioException.getMessage());
        }
    }

    private String getLatestRevisionOf(String articleTitle) throws IOException {
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp|user&rvlimit=30&redirects",
                articleTitle);
        String encodedUrlString = URLEncoder.encode(urlString, Charset.defaultCharset());
        try {
            URL url = new URL(encodedUrlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent",
                    "RevisionParser/0.1 (karogers3@bsu.edu; nplian@bsu.edu)");
            InputStream inputStream = connection.getInputStream();
            RevisionParser parser = new RevisionParser();
            String name = parser.parse(inputStream);
            return name;
        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(makeUI()));
        primaryStage.show();
    }

    private Parent makeUI() {
        return null;
    }


}
