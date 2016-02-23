package com.github.ionno.tiddle.core.blocks.models;

import com.github.ionno.tiddle.core.blocks.Block;
import com.github.ionno.tiddle.core.blocks.ContentType;
import java.util.ArrayList;

// TODO: DOCS
public class ListBlock extends Block<ArrayList<String>> {

    public ListBlock(String title, ArrayList<String> content){
        super(title, content);
    }
    
    public ListBlock(String title, ArrayList<String> content, String icon){
        super(title, content, icon);
    }

    @Override
    public ContentType getContentType() {
        return ContentType.LIST;
    }
}