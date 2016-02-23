package com.github.ionno.tiddle.core.blocks;

import java.util.Objects;
import java.util.Optional;

/**
 * 
 * {@code Block} represents a section with content in a topic.
 * 
 * <br><br>
 * See {@link ContentType} for some type of contents that a block can have.
 * If you want to implement a section with a different type of content, add more
 * options to {@link ContentType} enum and reference in the class that implements
 * {@link Block} methods.
 * 
 * <br><br>
 * <b>NOTE:</b> Do not create similar types of content. For example, if there is a
 * {@code Block} that holds a list, do not implement another "list" type just to render
 * a "list for images only", it's completely useless.
 * 
 * @param <T>
 *      Is the type of the block content. {@code Block}s can have plain text({@code String}),
 *      lists({@code List<T>}) and tables({@code List<List<T>>}) and other types of content.
 */
public abstract class Block<T> implements ContentBlock {
    
    /**
     * The {@code Block} identifier.
     * This title cannot be null. Every block requires an unique title to be identified.
     */
    private String title;
    
    /**
     * The {@code Optional} icon for the {@code Block}.
     * This field holds an image URL to be used as icon next to the block's title.
     */
    private Optional<String> icon;
    
    /**
     * The content of the block.
     * The content cannot be null.
     */
    private T content;

    
    public Block(String title, T content){
        setRequiredFields(title, content, null);
    }
    
    public Block(String title, T content, String icon){
        setRequiredFields(title, content, icon);
    }
    
    private void setRequiredFields(String title, T content, String icon){
        setIcon(icon);
        setTitle(title);
        setContent(content);
    }

    //<editor-fold defaultstate="collapsed" desc="get/set"> 
    /**
     * Get the {@code Block} title.
     * @return the block title.
     */
    public final String getTitle() {
        return title;
    }
    
    /**
     * Set the {@code Block} title.
     * @param title the block title.
     * @throws NullPointerException if the title is {@code null}.
     */
    public final void setTitle(String title) {
        this.title = Objects.requireNonNull(title, "The block title cannot be null.");
    }

    /**
     * Get the {@code Block} icon.
     * @return an empty {@code String} if the icon is {@code null}. Otherwise, this
     * method return the icon value.
     */
    public final String getIcon() {
        return icon.orElse("");
    }
    
    /**
     * Set the {@code Block} icon.
     * @param icon the icon value.
     */
    public final void setIcon(String icon) {
        this.icon = Optional.ofNullable(icon);
    }
    
    /**
     * Get the {@code Block content}.
     * @return the block content.
     */
    public final T getContent() {
        return content;
    }
    
    /**
     * Set the {@code Block} content.
     * @param content the block content.
     * @throws NullPointerException if the block content is {@code null}.
     */
    public final void setContent(T content) {
        this.content = content;
    }
    //</editor-fold>
    
    @Override public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.title);
        return hash;
    }

    /**
     * Check if this {@code Block} is equal to another one.
     * @param obj the block to verified.
     * @return {@code true} if the blocks are equals.
     */
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final Block<?> other = (Block<?>) obj;
        return Objects.equals(this.title, other.title);
    }

    @Override
    public String toString() {
        return "Block{" + "title=" + title + ", icon=" + icon.orElse("") + ", content=" + content + '}';
    }
}