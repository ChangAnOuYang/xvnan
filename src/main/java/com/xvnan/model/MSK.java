package com.xvnan.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author nan_xu
 * @date 2020/1/6
 */
public class MSK implements Serializable {
    private static final long serialVersionUID = 1L;

    public String x;
    public String y;
    public String[] uList;
    public String w;

    @Override
    public String toString() {
        return "MSK{" +
                "x=" + x +
                ", y=" + y +
                ", uList=" + (uList == null ? null : Arrays.asList(uList)) +
                ", w=" + w +
                '}';
    }
}
