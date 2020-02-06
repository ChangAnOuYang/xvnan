package com.xvnan.jpbc.plaf.field.z;


import com.xvnan.jpbc.plaf.field.base.AbstractElement;
import com.xvnan.jpbc.plaf.field.base.AbstractField;

import java.math.BigInteger;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 */
public abstract class AbstractZElement<F extends AbstractField> extends AbstractElement<F> {

    public BigInteger value;

    protected AbstractZElement(F field) {
        super(field);
    }
}
