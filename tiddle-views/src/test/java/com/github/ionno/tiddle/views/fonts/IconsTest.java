package com.github.ionno.tiddle.views.fonts;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class IconsTest {
    
    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void starting(Description description) {
            System.out.printf("Testing '%s'() method.\n", description.getMethodName());
        }
    };
    
    @Test(expected = NullPointerException.class)
    public void tryUseANullIconModel(){
        Icons.setIconModel(null);
    }
    

    @Test
    public void testFontAwesomeLoader(){
        Icons.setIconModel(FontAwesome.BARS);
        Assert.assertNotNull(Icons.set(FontAwesome.COGS, 20));
    }
}