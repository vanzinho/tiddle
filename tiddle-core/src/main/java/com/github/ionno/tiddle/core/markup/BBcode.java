package com.github.ionno.tiddle.core.markup;

public enum BBcode {
    BOLD("b"),
    ITALIC("i"),
    UNDERLINE("u");
    
    
    
    private final String key;

    private BBcode(String key) {
        this.key = key;
    }
    
    public String key(){
        return this.key;
    }
}