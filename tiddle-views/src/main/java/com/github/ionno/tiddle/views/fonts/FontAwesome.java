package com.github.ionno.tiddle.views.fonts;

import java.io.InputStream;

/**
 * 
 * The <a href='http://fontawesome.io/'>Font Awesome</a> cheatsheet.
 * 
 * <br><br>
 * {@code FontAwesome} class provides constants and methods to manipulate the icons
 * used in this application as fonts. This class is totally extensible, if you want
 * to add any other icon from Font Awesome set, just copy the respective unicode of
 * the icon to a new constant.
 * Check out the <a href='http://fontawesome.io/cheatsheet'>cheatsheet page</a> for more icons.
 * 
 * <br><br>
 * For convention, use the same name from cheatsheet page for new constants, but
 * without any prefix/suffix (E.g {@code fa-...} and {@code fa-...-o} can be omitted).
 */

public enum FontAwesome implements IconModel {
    
    BARS('\uf0c9'),
    BUG('\uf188'),
    COGS('\uf085'),
    COMMENTING('\uf27b'),
    COPYRIGHT('\uf1f9'),
    ENVELOPE('\uf003'),
    FLOPPY('\uf0c7'),
    GITHUB('\uf092'),
    HEART('\uf004'),
    INFO('\uf129'),
    MINUS('\uf068'),
    PAINT_BRUSH('\uf1fc'),
    REFRESH('\uf021'),
    START('\uf006'),
    TRASH('\uf014');
        
    private final char unicode;

    private FontAwesome(char unicode) {
        this.unicode = unicode;
    }
    
    @Override
    public char unicode() {
        return this.unicode;
    }

    @Override
    public String getFontFamily() {
        return "Font Awesome";
    }

    @Override
    public InputStream getFontStream() {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("assets/fonts/fontawesome-webfont.ttf");
    }
}