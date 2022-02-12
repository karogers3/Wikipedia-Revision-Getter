package edu.bsu.cs222.model;

import java.io.InputStream;
import java.util.Scanner;

public class InputStreamReader {

    public String makeString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextLine();
    }
}
