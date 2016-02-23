package com.github.ionno.tiddle.views.fonts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * TODO: DOCS
 */
public class Icons {
    
    private static Font font;
    
    private Icons(){}
    
    public static void setIconModel(IconModel model){
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, model.getFontStream());
        } catch(Exception e){
            throw new IllegalArgumentException("Cannot load '" + model.getFontFamily() + "' font.");
        }
    }
    
    public static Icon set(IconModel icon, Color color, int size){
        return new ImageIcon(render(icon, color, size));
    }
    
    public static Icon set(IconModel icon, int size){
        return set(icon, Color.BLACK, size);
    }
    
    private static Image render(IconModel model, Color color, float size){
        font = font.deriveFont(size);
        return setIconImage(Character.toString(model.unicode()), color);
    }
    
    private static BufferedImage setIconImage(String iconUnicode, Color color){
        JLabel templabel = new JLabel(iconUnicode);
        templabel.setForeground(color);
        templabel.setFont(font);
        
        Dimension labelSize = templabel.getPreferredSize();
        int width  = labelSize.width  + 1;
        int height = labelSize.height + 1;
        
        templabel.setSize(width, height);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        templabel.print(graphics);
        graphics.dispose();
        return image;
    }
}