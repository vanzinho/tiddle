package com.github.ionno.tiddle.core.style;

import java.awt.Color;
import java.util.Optional;

/**
 * {@code Style} contains the properties used to format the topic appearance.
 */
public class Style {
    
    /**
     * The font family.
     */
    private Webfont header, content;
    
    /**
     * The separator to be inserted after {@code ContentBlock}s.
     * This field holds an URL to an image that will be used as separator.
     */
    private Optional<String> separator;
    
    /**
     * The respective color for the content.
     */
    private Color headerColor, contentColor;
    
    /**
     * Initialize the style with the fonts and colors.
     * The separator will be an empty {@code String}.
     * 
     * @param fonts
     *      The correspondent font for header and content.
     * 
     * @param colors
     *      The correspondent color for header and content.
     */
    public Style(Webfont[] fonts, Color[] colors){
        setFonts(fonts);
        setColors(colors);
        setSeparator(null);
    }
    
    /**
     * Initialize the style with the fonts, colors and separator .
     * 
     * @param fonts
     *      The correspondent font for header and content.
     * 
     * @param colors
     *      The correspondent color for header and content.
     * 
     * @param separator 
     *      The image URL to be used as block separator.
     */
    public Style(Webfont[] fonts, Color[] colors, String separator){
        setFonts(fonts);
        setColors(colors);
        setSeparator(separator);
    }
    
    
    /**
     * Set the header/content fonts.
     * 
     * @param fonts
     *      The correspondent fonts for the header and content.
     */
    public final void setFonts(Webfont[] fonts){
        if(fonts != null && fonts.length == 2){
            header = fonts[0];
            content = fonts[1];
            return;
        }
        throw new IllegalArgumentException("The 'fonts' arg cannot be null and must have at least two values (for header/content)");
    }
    
    /**
     * Set the header/content colors.
     * 
     * @param colors
     *      The correspondent colors for the header and content.
     */
    public final void setColors(Color[] colors){
        if(colors != null && colors.length == 2){
            headerColor = colors[0];
            contentColor = colors[1];
            return;
        }
        throw new IllegalArgumentException("The 'colors' arg cannot be null and must have at least two values (for header/content)");
    }
    
    /**
     * Set the separator. If the parameter is defined with {@code null}, when call
     * {@link Style#getSeparator()}, the separator will be an empty {@code String}.
     * 
     * @param separator
     *      The image URL to be use as block separator.
     */
    public final void setSeparator(String separator){
        this.separator = Optional.ofNullable(separator);
    }

    /**
     * @return The content font. 
     */
    public Webfont getContentFont(){
        return content;
    }

    /**
     * @return The header font.
     */
    public Webfont getHeaderFont(){
        return header;
    }

    /**
     * @return The separator or an empty {@code String} if the separator is undefined.
     */
    public String getSeparator() {
        return separator.orElse("");
    }

    /**
     * @return The color of the content.
     */
    public Color getContentColor() {
        return contentColor;
    }

    /**
     * @return The color of the header. 
     */
    public Color getHeaderColor() {
        return headerColor;
    }

    @Override
    public String toString() {
        return new StringBuilder("Style { header: ").append(header).append(", content: ").append(content)
                                                    .append(", separator: ").append(getSeparator()).append(", header color: ")
                                                    .append(Hexcolor.parseColor(headerColor)).append(", content color: ").append(Hexcolor.parseColor(contentColor))
                                                    .append(" }").toString();
    }
}