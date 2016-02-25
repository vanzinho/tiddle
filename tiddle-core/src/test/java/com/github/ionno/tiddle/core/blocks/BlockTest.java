package com.github.ionno.tiddle.core.blocks;

import com.github.ionno.tiddle.core.blocks.models.TextBlock;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class BlockTest {
    
    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void starting(Description description) {
            System.out.printf("Testing '%s'() method.\n", description.getMethodName());
        }
    };
    
    @Test(expected = NullPointerException.class)
    public void tryUseABlockWithNullValue(){
        Block<String> block = new TextBlock(null, "content.");
    }
    
    @Test
    public void blockWithSameTitle(){
        Block<String> block = new TextBlock("Title", "content A.");
        Block<String> zblock = new TextBlock("Title", "content B.");
        Assert.assertTrue(block.equals(zblock));
    }
}