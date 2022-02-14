package edu.bsu.cs222.view;

import edu.bsu.cs222.model.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class WikipediaRevisionApplication extends Application {
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Label label = new Label("");
    private final Button button = new Button("Search");
    private final TextField textField = new TextField();
    private String display;



        


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(makeUI()));
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 450, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Wiki");
        ScrollPane scroll = new ScrollPane();
        root.setCenter(scroll);
        scroll.setContent(makeUI());
        scroll.setPannable(true);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        primaryStage.show();
    }

    private Parent makeUI() {
        button.setOnAction((event) ->{
            button.setDisable(true);
            textField.setDisable(true);

            executor.execute(()->{
                String articleTitle = textField.getText();
                URLBuilder urlBuilder = new URLBuilder();
                String wikiUrl = urlBuilder.makeURL(articleTitle);
                StringBuilder stringBuilder = new StringBuilder();
                WikiPageFetcher wikiPageFetcher = new WikiPageFetcher();
                try {
                    String wikiPage = wikiPageFetcher.getWikiPageInfo(wikiUrl);
                    WikiPageAuthenticator wikiPageAuthenticator = new WikiPageAuthenticator();
                    if (wikiPageAuthenticator.doesPageExist(wikiPage)) {
                        RedirectParser redirectParser = new RedirectParser();
                        if (redirectParser.doesPageRedirect(wikiPage)) {
                            String redirectTo = "Redirected to " + redirectParser.redirectedTo(wikiPage) + "\n";
                            stringBuilder.append(redirectTo);
                        }
                        RevisionParser revisionParser = new RevisionParser();
                        List<Revision> revisionList = revisionParser.parse(wikiPage);
                        RevisionListSummary revisionListSummary = new RevisionListSummary();
                        StringBuilder summaryOfRevisions = revisionListSummary.summaryOfRevisions(revisionList);
                        stringBuilder.append(summaryOfRevisions);
                        this.display = stringBuilder.toString();
                    } else {
                        this.display = "Page does not exist.";
                    }
                } catch (IOException e) {
                    this.display = "Connection issue. Wikipedia servers may be down.";
                }

                Platform.runLater(()->{
                    label.setText(display);
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
