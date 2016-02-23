package com.github.ionno.tiddle.core.markup;

import java.text.MessageFormat;
import java.util.Map;

public class BBcodes {
    
    private static final String BBCODE = "[{0}]{1}[/{0}]";
    private static final String BBCODE_WITH_VALUE = "[{0}={1}]{2}[/{0}]";
    
    private BBcodes(){}
    
    /**
     * Format a content with a simple bbcode markup.
     * 
     * @param bbcode
     *      The markup code.
     * @param content
     *      The content to be formatted.
     * @return 
     *      The content rendered as BBcode: {@code [code]content[/code]}.
     * 
     */
    public static String set(BBcode bbcode, String content){
        return MessageFormat.format(BBCODE, bbcode.key(), content);
    }
    
    /**
     * Format a content with a bbcode containing some value.
     * 
     * @param bbcode
     *      The markup code.
     * @param value
     *      The value of markup.
     * @param content
     *      The content to be formatted.
     * @return 
     *      The content rendered as BBcode: {@code [code=value]content[/code]}.
     */
    public static String set(BBcode bbcode, String value, String content){
        return MessageFormat.format(BBCODE_WITH_VALUE, bbcode.key(), value, content);
    }

    /**
     * Format a content with a list of parameters.
     * 
     * @param bbcode
     *      The markup code.
     * @param parameters
     *      The parameters set.
     * @param content
     *      The content to be formatted.
     * @return 
     *      The content rendered as BBcode, containing all parameters wrapped 
     *      in a {@code " "} string. E.g: {@code [code="p1:v1,p2:v2,p3:v3"]content[/code]}.
     */
    public static String set(BBcode bbcode, Map<String, String> parameters, String content){
        
        StringBuilder sb = new StringBuilder();
        parameters.entrySet().stream().forEach((each) -> {
            sb.append(each.getKey()).append(":").append(each.getValue()).append(",");
        });
        
        // Removes the last ","
        String value = sb.toString().substring(0, sb.length() - 1);
        return set(bbcode, String.format("\"%s\"", value), content);
    }
}