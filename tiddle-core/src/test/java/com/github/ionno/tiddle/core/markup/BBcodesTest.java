package com.github.ionno.tiddle.core.markup;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

public class BBcodesTest {
    
    private static final Logger LOG = Logger.getLogger(BBcodesTest.class.getSimpleName());
    
    private final BBcode BBCODE  = BBcode.BOLD;
    private final String CONTENT = "Hello World!";
    private final String VALUE   = "Tahoma";
    
    @Test
    public void simpleBBcode(){
        // [b]Hello World![/b]
        String expected = MessageFormat.format("[{0}]{1}[/{0}]", BBCODE.key(), CONTENT);
        String result = BBcodes.set(BBCODE, CONTENT);
        Assert.assertEquals(expected, result);
    }
    
    @Test
    public void bbcodeWithValue(){
        // [b=Tahoma]Hello World![/b]
        String expected = MessageFormat.format("[{0}={1}]{2}[/{0}]", BBCODE.key(), VALUE, CONTENT);
        String result = BBcodes.set(BBCODE, VALUE, CONTENT);
        Assert.assertEquals(expected, result);
    }
    
    @Test
    public void bbcodeWithParameters(){
        Map<String,String> map = new HashMap(){{
            put("align", "center");
            put("width", "500");
        }};
        
        String params = "width:500,align:center";
        
        // [b="width:500,align:center"]Hello World![/b]
        String expected = MessageFormat.format("[{0}=\"{1}\"]{2}[/{0}]", BBCODE.key(), params, CONTENT);
        String result = BBcodes.set(BBCODE, map, CONTENT);
        Assert.assertEquals(expected, result);
    }
}