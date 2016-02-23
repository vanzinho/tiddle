package com.github.ionno.tiddle.core.blocks.models;

import com.github.ionno.tiddle.core.blocks.Block;
import com.github.ionno.tiddle.core.blocks.ContentType;
import java.util.ArrayList;

// TODO: DOCS
public class TableBlock extends Block<ArrayList<ArrayList<String>>> {
    
    public TableBlock(String title, ArrayList<ArrayList<String>> content){
        super(title, content);
    }
    
    public TableBlock(String title, ArrayList<ArrayList<String>> content, String icon){
        super(title, content, icon);
    }

    @Override
    public ContentType getContentType() {
        return ContentType.TABLE;
    }
}