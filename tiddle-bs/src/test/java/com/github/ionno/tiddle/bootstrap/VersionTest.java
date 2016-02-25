package com.github.ionno.tiddle.bootstrap;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class VersionTest {
    
    private Version version;
    
    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void starting(Description description) {
            System.out.printf("Testing '%s'() method.\n", description.getMethodName());
        }
    };
    
    @Test(expected = NullPointerException.class)
    public void tryUseANullVersion(){
        version = new Version(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void tryUseAIncorrectFormatVersion(){
        version = new Version("0.A.0.B");
    }
    
    @Test
    public void compareAMinorVersion(){
        version = new Version("0.1.0.0");
        Version otherVersion = new Version("2.0.0.0");
        
        int result = version.compareTo(otherVersion); // Must return a negative integer.
        Assert.assertTrue(result < 0);
    }
    
    @Test
    public void compareAMajorVersion(){
        Version v = new Version("0.1.1.0");
        Version otherVersion = new Version("0.0.1.0");
        
        int result = v.compareTo(otherVersion); // Must return a positive integer.
        Assert.assertTrue(result > 0);
    }
    
    @Test
    public void compareEqualVersions(){
        version = new Version("0.1.0.0");
        Version otherVersion = new Version("0.1.0.0");
        
        boolean result = version.equals(otherVersion); // Must return true.
        Assert.assertTrue(result);
    }
}