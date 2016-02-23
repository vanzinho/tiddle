package com.github.ionno.tiddle.core.blocks;

import com.github.ionno.tiddle.core.blocks.models.ListBlock;
import com.github.ionno.tiddle.core.blocks.models.TextBlock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

public class BlockTest {
    
    private static final Logger log = Logger.getLogger(BlockTest.class.getSimpleName());
     
    @Test
    public void equalTextBlock(){
        
        log.info("Testing 'equalTextBlock':");
        
        TextBlock tblock  = new TextBlock("TextBlock", "TextBlockContent.");
        TextBlock tBlockz = new TextBlock("TextBlock", "AnotherTextBlockContentWithSameTitle.");
        TextBlock tBlocky = new TextBlock("TextBlock2", "TextBlockContent");
        
        log.log(Level.INFO, "TextBlock1 title: {0}. TextBlock2 title: {1}. Is equal: {2}.", new Object[]{tblock.getTitle(), tBlockz.getTitle(), tblock.equals(tBlockz)});
        Assert.assertEquals(tblock, tBlockz);
        
        log.log(Level.INFO, "TextBlock1 title: {0}. TextBlock3 title: {1}. Is equal: {2}.", new Object[]{tblock.getTitle(), tBlocky.getTitle(), tblock.equals(tBlocky)});
        Assert.assertNotEquals(tblock, tBlocky);
    }
}