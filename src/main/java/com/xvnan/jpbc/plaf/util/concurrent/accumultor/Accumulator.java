package com.xvnan.jpbc.plaf.util.concurrent.accumultor;

import com.xvnan.jpbc.plaf.util.concurrent.Pool;

import java.util.concurrent.Callable;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 * @since 2.0.0
 */
public interface Accumulator<T> extends Pool<T> {

    Accumulator<T> accumulate(Callable<T> callable);

    Accumulator<T> awaitTermination();

    T awaitResult();

    T getResult();

}
