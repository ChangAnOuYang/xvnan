package com.xvnan.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author nan_xu
 * @date 2020/1/6
 */
public class Params implements Serializable {
    private static final long serialVersionUID = 1L;

    public BigInteger n;
    public String X;
    public String Y;
    public String[] UList;
    public String R3;
    public String R4;
    public String E;

    @Override
    public String toString() {
        return "Params{" +
                "n=" + n +
                ", X=" + X +
                ", Y=" + Y +
                ", UList=" + (UList == null ? null : Arrays.asList(UList)) +
                ", R3=" + R3 +
                ", R4=" + R4 +
                ", E=" + E +
                '}';
    }
}
