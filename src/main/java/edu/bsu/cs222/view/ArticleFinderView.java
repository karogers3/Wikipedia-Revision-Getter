package edu.bsu.cs222.view;

public class ArticleFinderView {
    private String articleName;

    public boolean checkIfEmpty(String articleName) {
        return articleName.equals("");
    }

    public String replaceSpaces(String articleName) {
        char array[] = articleName.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++){
            if (array[i] == 32)
                sb.append("%20");
            else
                sb.append(array[i]);


        }
        return sb.toString();

        }
    }

