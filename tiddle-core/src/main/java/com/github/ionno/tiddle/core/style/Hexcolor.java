package com.github.ionno.tiddle.core.style;

import java.awt.Color;

public class Hexcolor {
    
    private static final String HEX_PATTERN = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
    
    private static final String HEX_FORMAT = "#%02x%02x%02x";
    
    public static Color parseHex(String hex){
        if(hex != null && !hex.isEmpty() && hex.matches(HEX_PATTERN))
            return Color.decode(hex);
        throw new IllegalArgumentException("The color does not have a valid format. E.g: #RRGGBB");
    }
    
    public static String parseColor(final Color color){
        if(color != null)
            return String.format(HEX_FORMAT, color.getRed(), color.getGreen(), color.getBlue());
        throw new IllegalArgumentException("The color cannot be null.");
    }

}