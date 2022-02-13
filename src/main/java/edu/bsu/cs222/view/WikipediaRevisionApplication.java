package edu.bsu.cs222.view;

import edu.bsu.cs222.model.InputStreamReader;
import edu.bsu.cs222.model.Revision;
import edu.bsu.cs222.model.RevisionParser;
import edu.bsu.cs222.model.URLBuilder;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class WikipediaRevisionApplication { // extends Application
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Label label = new Label();
    private final Button button = new Button();
    private final TextField textField = new TextField();

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
        URLBuilder urlBuilder = new URLBuilder();
        String urlString = urlBuilder.makeURL(articleTitle);
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent",
                    "RevisionParser/0.1 (karogers3@bsu.edu; nplian@bsu.edu)");
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader();
            String dataString = inputStreamReader.makeString(inputStream);
            RevisionParser parser = new RevisionParser();
            List<Revision> revisionList = parser.parse(dataString);
            return revisionList.get(0).getUsername();
        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }
    }

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        primaryStage.setScene(new Scene(makeUI()));
//        primaryStage.show();
//    }
//
//    private Parent makeUI() {
//        button.setOnAction((event) ->{
//            button.setDisable(true);
//            textField.setDisable(true);
//
//            executor.execute(()->{
//                String articleTitle = textField.getText();
//                RevisionParser parser = new RevisionParser();
//                boolean result = parser.parse(value);
//
//                Platform.runLater(()->{
//                    if (result){
//                        label.setText("Searching...");
//                    }else{
//                        label.setText("Error..");
//                    }
//                    button.setDisable(false);
//                    textField.setDisable(false);
//                });
//
//            });
//
//
//        });
//        VBox vbox = new VBox();
//        vbox.getChildren().addAll(
//                textField,
//                button,
//                label
//        );
//        return vbox;
//    }
//
//
}
