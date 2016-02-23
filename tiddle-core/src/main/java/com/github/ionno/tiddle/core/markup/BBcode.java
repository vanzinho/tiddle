package com.github.ionno.tiddle.core.markup;

/**
 * 
 * BBcode tags.
 * See the <a href='http://www.bbcode.org/reference.php'>BBcode reference</a>.
 * 
 */
public enum BBcode {
    BOLD("b"),
    ITALIC("i"),
    UNDERLINE("u"),
    STRIKE("s"),
    
    SIZE("size"),
    FONT("font"),
    COLOR("color"),
    
    LEFT("left"),
    RIGHT("right"),
    CENTER("center"),
    
    LINK("url"),
    IMAGE("img"),
    VIDEO("video"),
    
    TABLE("table"),
    TABLE_ROW("tr"),
    TABLE_HEADING_CELL("th"),
    TABLE_CONTENT_CELL("td"),
    
    CODE("code"),
    QUOTE("quote")
    ;
    
    private final String key;

    private BBcode(String key) {
        this.key = key;
    }
    
    public String key(){
        return this.key;
    }
}