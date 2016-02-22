package com.github.ionno.tiddle.views.fonts;

import java.io.InputStream;

/**
 * The {@code IconModel} contain a method to retrieve the font icon unicode.
 */
public interface IconModel {
    
    /**
     * Retrieve the icon unicode.
     * @return  the icon unicode.
     */
    char unicode();
    
    /**
     * Retrieve an unique identifier to the font.
     * @return an unique identifier to the font.
     */
    String getFontFamily();
    
    /**
     * Retrieves a stream to the font file.
     * @return a stream to the font file.
     */
    InputStream getFontStream();
}