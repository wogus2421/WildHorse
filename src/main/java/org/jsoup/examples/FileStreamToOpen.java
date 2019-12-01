package org.jsoup.examples;

import org.jsoup.Jsoup;

import java.io.FileInputStream;
import java.io.IOException;

public class FileStreamToOpen {

    public static void main(String[] args) throws IOException {

        String filePath ="src/test/resources/htmltests/google-ipod.html";
        FileInputStream fileStream = null;
        try{
            fileStream = new FileInputStream(filePath);
            Jsoup.open(fileStream,"UTF8","");

        }
        catch (Exception e){
            System.out.println("file open error " +e);
        }
        finally {
            try {
                fileStream.close();
            }
            catch (Exception e){
                System.out.println("file close error " +e);
            }
        }
        //Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        //log(doc.title());
        // This is test code for opening
        //Jsoup.open(doc);
        //Jsoup.open(doc);


    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}
