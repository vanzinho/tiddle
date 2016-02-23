package com.github.ionno.tiddle.core.style;

/**
 * 
 * {@code Webfont} contain the common fonts used on forums platforms at Internet.
 * Based on the main platforms, such as
 * <a href='https://www.vbulletin.com/'>VBulletin</a>,
 * <a href='https://www.invisionpower.com/'>IPBoard</a> and
 * <a href='https://xenforo.com/'>Xenforo</a>.
 * 
 */

public enum Webfont {
    
    ARIAL("Arial"),
    ARIAL_B("Arial Black"),
    ARIAL_N("Arial Narrow"),
    BOOK("Book Antiqua"),
    CENTURY("Century Gothic"),
    COMIC("Comic Sans MS"),
    COURIER("Courier New"),
    FIXEDSYS("Fixedsys"),
    FRANKLIN("Franklin Gothic"),
    GARAMOND("Garamond"),
    GEORGIA("Georgia"),
    IMPACT("Impact"),
    LUCIDA_C("Lucida Console"),
    LUCIDA_S("Lucida Sans Unicode"),
    SERIF("Microsoft Sans Serif"),
    PALATINO("Palatino Linotype"),
    SYSTEM("System"),
    TAHOMA("Tahoma"),
    TIMES("Times New Roman"),
    TREBUCHET("Trebuchet MS"),
    VERDANA("Verdana");

    private final String fontName;

    private Webfont(String fontName) {
        this.fontName = fontName;
    }

    @Override
    public String toString() {
        return this.fontName;
    }
}