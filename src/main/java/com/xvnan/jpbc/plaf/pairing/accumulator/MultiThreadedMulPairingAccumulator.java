package com.xvnan.jpbc.plaf.pairing.accumulator;

import com.xvnan.jpbc.api.Element;
import com.xvnan.jpbc.api.Pairing;
import com.xvnan.jpbc.plaf.pairing.accumulator.AbstractPairingAccumulator;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 * @since 2.0.0
 */
public class MultiThreadedMulPairingAccumulator extends AbstractPairingAccumulator {


    public MultiThreadedMulPairingAccumulator(Pairing pairing) {
        super(pairing);
    }

    public MultiThreadedMulPairingAccumulator(Pairing pairing, Element value) {
        super(pairing, value);
    }


    protected void reduce(Element value) {
        this.result.mul(value);
    }
}
