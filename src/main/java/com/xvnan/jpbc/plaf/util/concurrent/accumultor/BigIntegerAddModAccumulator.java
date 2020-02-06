package com.xvnan.jpbc.plaf.util.concurrent.accumultor;

import com.xvnan.jpbc.plaf.util.concurrent.accumultor.AbstractAccumulator;

import java.math.BigInteger;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 * @since 2.0.0
 */
public class BigIntegerAddModAccumulator extends AbstractAccumulator<BigInteger> {

    private BigInteger modulo;


    public BigIntegerAddModAccumulator(BigInteger modulo) {
        this.result = BigInteger.ZERO;
        this.modulo = modulo;
    }

    protected void reduce(BigInteger value) {
        result = result.add(value).mod(modulo);
    }

}
