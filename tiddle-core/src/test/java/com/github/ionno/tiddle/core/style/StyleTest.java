package com.github.ionno.tiddle.core.style;

import java.awt.Color;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class StyleTest {
    
    private final Webfont[] fonts = {Webfont.ARIAL, Webfont.ARIAL_B};
    private final Color[] colors = new Color[]{Color.BLACK, Color.RED};
    
    
    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void starting(Description description) {
            System.out.printf("Testing '%s'() method.\n", description.getMethodName());
        }
    };
    
    @Test(expected = IllegalArgumentException.class)
    public void trySetNullFonts(){
        Style style = new Style(null, colors);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void trySetNullColors(){
        Style style = new Style(fonts, null);
    }
    
    @Test
    public void separatorIsEmptyStringWhenSetNull(){
        Style style = new Style(fonts, colors, null);
        Assert.assertTrue(style.getSeparator().isEmpty());
    }
    
    @Test
    public void printToString(){
        String separator = "https://foo.com";
        Style style = new Style(fonts, colors, separator);
        System.out.println(style.toString());
    }
}