package com.github.ionno.tiddle.core.markup;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class BBcodesTest {
    
    private final BBcode BBCODE  = BBcode.BOLD;
    private final String CONTENT = "Hello World!";
    private final String VALUE   = "Tahoma";
    
    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void starting(Description description) {
            System.out.printf("Testing '%s'() method.\n", description.getMethodName());
        }
    };
    
    @Test
    public void usingSimpleBBcode(){
        // [b]Hello World![/b]
        String expected = MessageFormat.format("[{0}]{1}[/{0}]", BBCODE.key(), CONTENT);
        String result = BBcodes.set(BBCODE, CONTENT);
        Assert.assertEquals(expected, result);
    }
    
    @Test
    public void usingBBcodeWithValue(){
        // [b=Tahoma]Hello World![/b]
        String expected = MessageFormat.format("[{0}={1}]{2}[/{0}]", BBCODE.key(), VALUE, CONTENT);
        String result = BBcodes.set(BBCODE, VALUE, CONTENT);
        Assert.assertEquals(expected, result);
    }
    
    @Test
    public void usingBBcodeWithParameters(){
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