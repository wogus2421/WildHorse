package org.jsoup.nodes;

import org.jsoup.parser.Tag;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuilderTest {
    public static Tag tag;
    public static String sTag;
    private static String uri;
    public static Attribute attr = null;

    @Before
    public void Initialize(){
        tag = Tag.valueOf("a");
        sTag = "a";
        attr = null;
        uri = "https://sourceforge.net/";
    }

    @Test
    public void tagEqualsTest(){
        Element elem1 = new Element
                .Builder()
                .tag(tag)
                .baseUri(uri)
                .build();
        assertNull(elem1.attributes);

        Element elem2 = new Element
                .Builder()
                .tag(sTag)
                .baseUri(uri)
                .build();
        assertNull(elem2.attributes);

        assertEquals(elem1.tag, elem2.tag);
    }

    @Test
    public void builderTest(){
        Element elem1 = new Element
                .Builder()
                .tag(sTag)
                .baseUri("")
                .build();

        assertNull(elem1.attributes);
        assertEquals(Tag.valueOf(sTag), elem1.tag);
        assertEquals("", elem1.baseUri);
    }


}
