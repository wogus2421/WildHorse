package org.jsoup.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.*;

import static org.junit.Assert.*;

public class OpenerFileTest {
    public static OpenerFile op;
    public static Document doc;

    @BeforeClass
    public static void makeInstance()throws Exception{
        op = new OpenerFile();
        doc = Jsoup.connect("http://en.wikipedia.org/").get();
    }
    @Before
    public void beforeTest()throws Exception{
        System.out.println("Before!!!");
    }
    @Test
    public void makeNewPath() {
        assertEquals(0, op.makeNewPath()/100);
    }

    @Test
    public void open() {
        assertEquals(0,op.open(doc));

    }

    @After
    public void printAfter()throws Exception{
        System.out.println("After!!");
    }

    @AfterClass
    public static void printAfterClass()throws Exception{
        System.out.println("AFTER CLASS");
    }
}