package com.xvnan.jpbc.plaf.field.vector;

import com.xvnan.jpbc.api.Element;
import com.xvnan.jpbc.plaf.field.vector.VectorElement;

import java.math.BigInteger;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 */
public class ImmutableVectorElement<E extends Element> extends com.xvnan.jpbc.plaf.field.vector.VectorElement<E> {

    public ImmutableVectorElement(com.xvnan.jpbc.plaf.field.vector.VectorElement element) {
        super(element.getField());

        this.coeff.clear();
        for (int i = 0; i < field.n; i++)
            coeff.add((E) element.getAt(i).getImmutable());

        this.immutable = true;
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement<E> duplicate() {
        return super.duplicate();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement<E> getImmutable() {
        return this;
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement set(Element e) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement set(int value) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement set(BigInteger value) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement twice() {
        return (com.xvnan.jpbc.plaf.field.vector.VectorElement) duplicate().twice().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement setToZero() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement setToOne() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement setToRandom() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public int setFromBytes(byte[] source, int offset) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement square() {
        return (com.xvnan.jpbc.plaf.field.vector.VectorElement) duplicate().square().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement invert() {
        return (com.xvnan.jpbc.plaf.field.vector.VectorElement) duplicate().invert().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement negate() {
        return (com.xvnan.jpbc.plaf.field.vector.VectorElement) duplicate().negate().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement add(Element e) {
        return (com.xvnan.jpbc.plaf.field.vector.VectorElement) duplicate().add(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement mul(Element e) {
        return (com.xvnan.jpbc.plaf.field.vector.VectorElement) duplicate().mul(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement mul(BigInteger n) {
        return (com.xvnan.jpbc.plaf.field.vector.VectorElement) duplicate().mul(n).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement mulZn(Element e) {
        return (com.xvnan.jpbc.plaf.field.vector.VectorElement) duplicate().mulZn(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement powZn(Element e) {
        return (com.xvnan.jpbc.plaf.field.vector.VectorElement) duplicate().powZn(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement setFromHash(byte[] source, int offset, int length) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public int setFromBytes(byte[] source) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public Element pow(BigInteger n) {
        return duplicate().pow(n).getImmutable();
    }

    @Override
    public Element halve() {
        return duplicate().halve().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement sub(Element element) {
        return (com.xvnan.jpbc.plaf.field.vector.VectorElement) duplicate().sub(element).getImmutable();
    }

    @Override
    public Element div(Element element) {
        return duplicate().div(element).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement mul(int z) {
        return (com.xvnan.jpbc.plaf.field.vector.VectorElement) duplicate().mul(z).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.vector.VectorElement sqrt() {
        return (VectorElement) duplicate().sqrt().getImmutable();
    }

}
