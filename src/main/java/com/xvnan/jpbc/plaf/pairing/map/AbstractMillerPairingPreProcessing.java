package com.xvnan.jpbc.plaf.pairing.map;

import com.xvnan.jpbc.api.Pairing;
import com.xvnan.jpbc.api.PairingPreProcessing;
import com.xvnan.jpbc.api.Point;
import com.xvnan.jpbc.plaf.pairing.map.AbstractMillerPairingMap;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 */
public abstract class AbstractMillerPairingPreProcessing implements PairingPreProcessing {

    protected com.xvnan.jpbc.plaf.pairing.map.AbstractMillerPairingMap.MillerPreProcessingInfo processingInfo;


    protected AbstractMillerPairingPreProcessing() {
    }

    protected AbstractMillerPairingPreProcessing(Point in1, int processingInfoSize) {
        this.processingInfo = new com.xvnan.jpbc.plaf.pairing.map.AbstractMillerPairingMap.MillerPreProcessingInfo(processingInfoSize);
    }

    protected AbstractMillerPairingPreProcessing(Pairing pairing, byte[] source, int offset) {
        this.processingInfo = new AbstractMillerPairingMap.MillerPreProcessingInfo(pairing, source, offset);
    }

    public byte[] toBytes() {
        if (processingInfo != null)
            return processingInfo.toBytes();
        else
            return new byte[0];
    }
}
