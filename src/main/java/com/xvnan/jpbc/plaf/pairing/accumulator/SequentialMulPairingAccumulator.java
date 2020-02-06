package com.xvnan.jpbc.plaf.pairing.accumulator;

import com.xvnan.jpbc.api.Element;
import com.xvnan.jpbc.api.Pairing;
import com.xvnan.jpbc.api.PairingPreProcessing;
import com.xvnan.jpbc.plaf.pairing.accumulator.PairingAccumulator;
import com.xvnan.jpbc.plaf.util.concurrent.Pool;
import com.xvnan.jpbc.plaf.util.concurrent.accumultor.Accumulator;

import java.util.concurrent.Callable;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 * @since 2.0.0
 */
public class SequentialMulPairingAccumulator implements com.xvnan.jpbc.plaf.pairing.accumulator.PairingAccumulator {

    private Pairing pairing;
    private Element value;


    public SequentialMulPairingAccumulator(Pairing pairing) {
        this.pairing = pairing;
        this.value = pairing.getGT().newOneElement();
    }

    public SequentialMulPairingAccumulator(Pairing pairing, Element value) {
        this.pairing = pairing;
        this.value = value;
    }

    public Accumulator<Element> accumulate(Callable<Element> callable) {
        throw new IllegalStateException("Not supported!!!");
    }

    public Accumulator<Element> awaitTermination() {
        return this;
    }

    public Element getResult() {
        return value;
    }

    public Pool submit(Callable<Element> callable) {
        throw new IllegalStateException("Not supported!!!");
    }

    public Pool submit(Runnable runnable) {
        throw new IllegalStateException("Not supported!!!");
    }

    public com.xvnan.jpbc.plaf.pairing.accumulator.PairingAccumulator addPairing(Element e1, Element e2) {
        value.mul(pairing.pairing(e1, e2));

        return this;
    }

    public com.xvnan.jpbc.plaf.pairing.accumulator.PairingAccumulator addPairing(PairingPreProcessing pairingPreProcessing, Element e2) {
        value.mul(pairingPreProcessing.pairing(e2));

        return this;
    }

    public PairingAccumulator addPairingInverse(Element e1, Element e2) {
        value.mul(pairing.pairing(e1, e2).invert());

        return this;
    }

    public Element awaitResult(){
        return value;
    }

}
