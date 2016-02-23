package com.github.ionno.tiddle.core.blocks;

/**
 * 
 * {@code IBlock} represents a section with content in a topic.
 * 
 * <br><br>
 * See {@link ContentType} for some type of contents that a block can have.
 * If you want to implement a section with a different type of content, add more
 * options to {@link ContentType} enum and reference it on {@link AbstractBlock}
 * implementation.
 */
public interface ContentBlock {
    ContentType getContentType();
}