package com.xvnan.model;

import java.io.Serializable;

/**
 * @author nan_xu
 * @date 2020/1/6
 */
public class Index implements Serializable {
    public String C0;
    public String C1;
    public String C2;
    public String Mv;

    @Override
    public String toString() {
        return "C{" +
                "C0=" + C0 +
                ", C1=" + C1 +
                ", C2=" + C2 +
                ", Mv=" + Mv +
                '}';
    }
}
