package org.jsoup.parser;

import org.jsoup.Connection;
import org.jsoup.helper.DataUtil;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class Opener {
    private OpenerFile of;

    public static int open(String html, String baseUri) {
        try {
            OpenerFile of = new OpenerFile();
            of.open(Parser.parse(html, baseUri));
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public static int open(String html, String baseUri, Parser parser) {
        try {
            OpenerFile of = new OpenerFile();
            of.open(parser.parseInput(html, baseUri));
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public static int open(String html) {
        try{
            OpenerFile of = new OpenerFile();
            of.open(Parser.parse(html, ""));
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }


    public static int open(File in, String charsetName, String baseUri) throws IOException {
        try {
            OpenerFile of = new OpenerFile();
            of.open(DataUtil.load(in, charsetName, baseUri));
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;

    }

    public static int open(File in, String charsetName) throws IOException {
        try {
            OpenerFile of = new OpenerFile();
            of.open(DataUtil.load(in, charsetName, in.getAbsolutePath()));
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;

    }

    public static int open(InputStream inputStream, String charsetName, String baseUri) throws IOException {
        try {
            OpenerFile of = new OpenerFile();
            of.open(DataUtil.load(inputStream, charsetName, baseUri));
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public static int open(InputStream inputStream, String charsetName, String baseUri, Parser parser) throws IOException {
        try {
            OpenerFile of = new OpenerFile();
            of.open(DataUtil.load(inputStream, charsetName, baseUri, parser));
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public static int openBodyFragment(String bodyHtml, String baseUri) {
        try {
            OpenerFile of = new OpenerFile();
            of.open(Parser.parseBodyFragment(bodyHtml, baseUri));
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;

    }

    public static int openBodyFragment(String bodyHtml) {
        try {
            OpenerFile of = new OpenerFile();
            of.open(Parser.parseBodyFragment(bodyHtml, ""));
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;

    }

    public static int open(URL url, int timeoutMillis) throws IOException {
        try {
            OpenerFile of = new OpenerFile();
            Connection con = HttpConnection.connect(url);
            con.timeout(timeoutMillis);
            of.open(con.get());
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;

    }

    public static int open(Document doc) throws IOException {
        try {
            OpenerFile of = new OpenerFile();
            of.open(doc);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;

    }
}
