package com.github.ionno.tiddle.core.format;

import com.github.ionno.tiddle.core.blocks.Block;
import com.github.ionno.tiddle.core.blocks.ContentBlock;

/**
 * The formatter interface.
 * 
 * <br><br>
 * This interface have only one method, responsible to transform the block data
 * into a {@code String}, with the formatted content.
 * 
 * @param <T>
 *      The type of the target content.
 */
interface IFormat<T extends Block & ContentBlock> {
    String format(T block);
}