package com.xvnan.jpbc.plaf.pairing.accumulator;

import com.xvnan.jpbc.api.Element;
import com.xvnan.jpbc.api.Pairing;
import com.xvnan.jpbc.api.PairingPreProcessing;
import com.xvnan.jpbc.plaf.pairing.accumulator.PairingAccumulator;
import com.xvnan.jpbc.plaf.util.concurrent.accumultor.AbstractAccumulator;
import com.xvnan.jpbc.plaf.util.concurrent.accumultor.Accumulator;

import java.util.concurrent.Callable;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 * @since 2.0.0
 */
public abstract class AbstractPairingAccumulator extends AbstractAccumulator<Element> implements com.xvnan.jpbc.plaf.pairing.accumulator.PairingAccumulator {

    protected Pairing pairing;


    public AbstractPairingAccumulator(Pairing pairing) {
        this(pairing, pairing.getGT().newOneElement());
    }

    public AbstractPairingAccumulator(Pairing pairing, Element value) {
        this.pairing = pairing;
        this.result = value;
    }


    public Accumulator<Element> accumulate(Callable<Element> callable) {
        throw new IllegalStateException("Invalid call method!");
    }

    public com.xvnan.jpbc.plaf.pairing.accumulator.PairingAccumulator addPairing(final Element e1, final Element e2) {
        super.accumulate(new Callable<Element>() {
            public Element call() throws Exception {
                return pairing.pairing(e1, e2);
            }
        });

        return this;
    }

    public com.xvnan.jpbc.plaf.pairing.accumulator.PairingAccumulator addPairingInverse(final Element e1, final Element e2) {
        super.accumulate(new Callable<Element>() {
            public Element call() throws Exception {
                return pairing.pairing(e1, e2).invert();
            }
        });

        return this;
    }

    public PairingAccumulator addPairing(final PairingPreProcessing pairingPreProcessing, final Element e2) {
        super.accumulate(new Callable<Element>() {
            public Element call() throws Exception {
                return pairingPreProcessing.pairing(e2);
            }
        });

        return this;
    }

}
