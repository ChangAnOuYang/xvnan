package com.xvnan.jpbc.plaf.field.base;

import com.xvnan.jpbc.api.Element;
import com.xvnan.jpbc.api.Field;
import com.xvnan.jpbc.api.FieldOver;
import com.xvnan.jpbc.plaf.field.base.AbstractField;

import java.security.SecureRandom;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 */
public abstract class AbstractFieldOver<F extends Field, E extends Element> extends AbstractField<E> implements FieldOver<F, E> {
    protected F targetField;


    protected AbstractFieldOver(SecureRandom random, F targetField) {
        super(random);
        this.targetField = targetField;
    }


    public F getTargetField() {
        return targetField;
    }

}
