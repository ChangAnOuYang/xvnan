package com.xvnan.jpbc.plaf.util.concurrent.accumultor;

import com.xvnan.jpbc.plaf.util.concurrent.accumultor.AbstractAccumulator;

import java.math.BigInteger;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 * @since 2.0.0
 */
public class BigIntegerMulAccumulator extends AbstractAccumulator<BigInteger> {

    public BigIntegerMulAccumulator() {
        this.result = BigInteger.ONE;
    }


    protected void reduce(BigInteger value) {
        result = result.multiply(value);
    }

}
