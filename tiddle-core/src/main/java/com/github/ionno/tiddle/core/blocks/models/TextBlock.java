package com.github.ionno.tiddle.core.blocks.models;

import com.github.ionno.tiddle.core.blocks.Block;
import com.github.ionno.tiddle.core.blocks.ContentType;

// TODO: DOCS
public class TextBlock extends Block<String> {

    public TextBlock(String title, String content) {
        super(title, content);
    }
    
    public TextBlock(String title, String content, String icon){
        super(title, content, icon);
    }
    
    @Override
    public ContentType getContentType() {
        return ContentType.TEXT;
    }
}