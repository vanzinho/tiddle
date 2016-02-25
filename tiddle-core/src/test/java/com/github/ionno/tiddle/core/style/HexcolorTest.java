package com.github.ionno.tiddle.core.style;

import java.awt.Color;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class HexcolorTest {
    
    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void starting(Description description) {
            System.out.printf("Testing '%s'() method.\n", description.getMethodName());
        }
    };

    @Test(expected = IllegalArgumentException.class)
    public void tryParseAStringHexWithNullEmptyOrWrongFormatValue(){
        Hexcolor.parseHex(null);
        Hexcolor.parseHex("");
        Hexcolor.parseHex("#WW1233");
    }
    
    @Test
    public void tryParseAnOKStringHex(){
        Hexcolor.parseHex("#000"); 
        Hexcolor.parseHex("#ffffff");
        Hexcolor.parseHex("#FFFFFF");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void tryParseAColorWithNullValue(){
        Hexcolor.parseColor(null);
    }
    
    @Test
    public void tryParseAnOKColor(){
        Hexcolor.parseColor(Color.BLACK);
        Hexcolor.parseColor(new Color(20, 20, 20));
    }
}