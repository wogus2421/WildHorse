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

    public static void open(String html, String baseUri) {
        OpenerFile of = new OpenerFile();
        of.open(Parser.parse(html, baseUri));
    }

    public static void open(String html, String baseUri, Parser parser) {
        OpenerFile of = new OpenerFile();
        of.open(parser.parseInput(html, baseUri));
    }

    public static void open(String html) {
        OpenerFile of = new OpenerFile();
        of.open(Parser.parse(html, ""));
    }


    public static void open(File in, String charsetName, String baseUri) throws IOException {
        OpenerFile of = new OpenerFile();
        of.open(DataUtil.load(in, charsetName, baseUri));
    }

    public static void open(File in, String charsetName) throws IOException {
        OpenerFile of = new OpenerFile();
        of.open(DataUtil.load(in, charsetName, in.getAbsolutePath()));
    }

    public static void open(InputStream in, String charsetName, String baseUri) throws IOException {
        OpenerFile of = new OpenerFile();
        of.open(DataUtil.load(in, charsetName, baseUri));
    }

    public static void open(InputStream in, String charsetName, String baseUri, Parser parser) throws IOException {
        OpenerFile of = new OpenerFile();
        of.open(DataUtil.load(in, charsetName, baseUri, parser));
    }

    public static void openBodyFragment(String bodyHtml, String baseUri) {
        OpenerFile of = new OpenerFile();
        of.open(Parser.parseBodyFragment(bodyHtml, baseUri));
    }

    public static void openBodyFragment(String bodyHtml) {
        OpenerFile of = new OpenerFile();
        of.open(Parser.parseBodyFragment(bodyHtml, ""));
    }

    public static void open(URL url, int timeoutMillis) throws IOException {
        OpenerFile of = new OpenerFile();
        Connection con = HttpConnection.connect(url);
        con.timeout(timeoutMillis);
        of.open(con.get());
    }

    public static void open(Document doc) throws IOException {
        OpenerFile of = new OpenerFile();
        of.open(doc);
    }
}
