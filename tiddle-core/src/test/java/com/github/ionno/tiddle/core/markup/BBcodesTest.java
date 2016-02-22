package com.github.ionno.tiddle.core.markup;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class BBcodesTest {
    
    private final String BBCODE  = "FONT";
    private final String CONTENT = "Hello World!";
    private final String VALUE   = "Tahoma";
    
    @Test
    public void simpleBBcode(){
        String expected = String.format("[%s]%s[/%s]", BBCODE, CONTENT, BBCODE);
        Assert.assertEquals(expected, BBcodes.set(BBCODE, CONTENT));
    }
    
    @Test
    public void bbcodeWithValue(){
        String expected = String.format("[%s=%s]%s[/%s]", BBCODE, VALUE, CONTENT, BBCODE);
        Assert.assertEquals(expected, BBcodes.set(BBCODE, VALUE, CONTENT));
    }
    
    @Test
    public void bbcodeWithParameters(){
        Map<String,String> map = new HashMap(){{
            put("align", "center");
            put("width", "500");
        }};
        
        String params = "width:500,align:center";
        String expected = String.format("[%s=\"%s\"]%s[/%s]", BBCODE, params, CONTENT, BBCODE);
        Assert.assertEquals(expected, BBcodes.set(BBCODE, map, CONTENT));
    }
}