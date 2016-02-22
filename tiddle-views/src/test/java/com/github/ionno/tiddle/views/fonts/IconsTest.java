package com.github.ionno.tiddle.views.fonts;

import org.junit.Assert;
import org.junit.Test;

public class IconsTest {

    @Test
    public void testFontAwesomeLoader(){
        Icons.setIconModel(FontAwesome.BARS);
        Assert.assertNotNull(Icons.set(FontAwesome.COGS, 20));
    }
}