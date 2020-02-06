package com.xvnan.jpbc.plaf.field.quadratic;

import com.xvnan.jpbc.api.Field;
import com.xvnan.jpbc.plaf.field.quadratic.DegreeTwoExtensionQuadraticElement;
import com.xvnan.jpbc.plaf.field.quadratic.QuadraticField;

import java.security.SecureRandom;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 */
public class DegreeTwoExtensionQuadraticField<F extends Field> extends QuadraticField<F, DegreeTwoExtensionQuadraticElement> {

    public DegreeTwoExtensionQuadraticField(SecureRandom random, F targetField) {
        super(random, targetField);
    }


    public DegreeTwoExtensionQuadraticElement newElement() {
        return new DegreeTwoExtensionQuadraticElement(this);
    }

}
