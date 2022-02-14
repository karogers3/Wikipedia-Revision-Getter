package edu.bsu.cs222.view;

import edu.bsu.cs222.model.*;
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
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class WikipediaRevisionApplication  extends Application {
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
        WikiPageFetcher wikiPageFetcher = new WikiPageFetcher();
        String dataString = wikiPageFetcher.getWikiPageInfo(urlString);
        RevisionParser parser = new RevisionParser();
        List<Revision> revisionList = parser.parse(dataString);
        return revisionList.get(0).getUsername();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(makeUI()));
        primaryStage.show();
    }

    private Parent makeUI() {
        button.setOnAction((event) ->{
            button.setDisable(true);
            textField.setDisable(true);

            executor.execute(()->{
                String articleTitle = textField.getText();
                RevisionParser parser = new RevisionParser();




                Platform.runLater(()->{

                    button.setDisable(false);
                   textField.setDisable(false);
                });

            });

        });
        VBox vbox = new VBox();
        vbox.getChildren().addAll(
                textField,
                button,
                label
        );
        return vbox;
    }


}
