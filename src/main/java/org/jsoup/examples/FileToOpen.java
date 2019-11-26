package org.jsoup.examples;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * A simple example, used on the jsoup website.
 */
public class FileToOpen {
    public static void main(String[] args) throws IOException {

        String filePath ="src/test/resources/htmltests/google-ipod.html";
        File exampleFile = new File(filePath);
        Jsoup.open(exampleFile,"UTF8");


    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}
