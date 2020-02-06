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
public class ProductPairingAccumulator implements com.xvnan.jpbc.plaf.pairing.accumulator.PairingAccumulator {

    private Pairing pairing;

    private int cursor;
    private Element[] in1, in2;
    private Element result;


    public ProductPairingAccumulator(Pairing pairing, int n) {
        this.pairing = pairing;
        this.in1 = new Element[n];
        this.in2 = new Element[n];
        this.cursor = 0;
    }


    public Accumulator<Element> accumulate(Callable<Element> callable) {
        throw new IllegalStateException("Not supported!!!");
    }

    public Accumulator<Element> awaitTermination() {
        awaitResult();

        return this;
    }

    public Element getResult() {
        return result;
    }

    public Pool<Element> submit(Callable<Element> callable) {
        throw new IllegalStateException("Not supported!!!");
    }

    public Pool<Element> submit(Runnable runnable) {
        throw new IllegalStateException("Not supported!!!");
    }



    public com.xvnan.jpbc.plaf.pairing.accumulator.PairingAccumulator addPairing(Element e1, Element e2) {
        in1[cursor] =  e1;
        in2[cursor++] =  e2;

        return this;
    }

    public com.xvnan.jpbc.plaf.pairing.accumulator.PairingAccumulator addPairing(PairingPreProcessing pairingPreProcessing, Element e2) {
        throw new IllegalStateException("Not supported!!!");
    }

    public PairingAccumulator addPairingInverse(Element e1, Element e2) {
        throw new IllegalStateException("Not supported!!!");
    }

    public Element awaitResult(){
        return (result = pairing.pairing(in1, in2));
    }

}
