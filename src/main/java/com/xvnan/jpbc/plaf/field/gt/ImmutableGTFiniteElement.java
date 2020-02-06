package com.xvnan.jpbc.plaf.field.gt;

import com.xvnan.jpbc.api.Element;
import com.xvnan.jpbc.plaf.field.gt.GTFiniteElement;

import java.math.BigInteger;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 */
public class ImmutableGTFiniteElement extends com.xvnan.jpbc.plaf.field.gt.GTFiniteElement {

    public ImmutableGTFiniteElement(com.xvnan.jpbc.plaf.field.gt.GTFiniteElement gtFiniteElement) {
        super(gtFiniteElement);

        this.value = gtFiniteElement.value.getImmutable();
        this.immutable = true;
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement duplicate() {
        return super.duplicate();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement getImmutable() {
        return this;
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement set(Element value) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement set(int value) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement set(BigInteger value) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement twice() {
        return (com.xvnan.jpbc.plaf.field.gt.GTFiniteElement) duplicate().twice().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement mul(int z) {
        return (com.xvnan.jpbc.plaf.field.gt.GTFiniteElement) duplicate().mul(z).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement setToZero() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement setToOne() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement setToRandom() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement setFromHash(byte[] source, int offset, int length) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public int setFromBytes(byte[] source) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public int setFromBytes(byte[] source, int offset) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement square() {
        return (com.xvnan.jpbc.plaf.field.gt.GTFiniteElement) duplicate().square().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement invert() {
        return duplicate().invert().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement halve() {
        return (com.xvnan.jpbc.plaf.field.gt.GTFiniteElement) duplicate().halve().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement negate() {
        return duplicate().negate().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement add(Element element) {
        return duplicate().add(element).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement sub(Element element) {
        return duplicate().sub(element).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement div(Element element) {
        return duplicate().div(element).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement mul(Element element) {
        return duplicate().mul(element).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement mul(BigInteger n) {
        return duplicate().mul(n).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement mulZn(Element z) {
        return (com.xvnan.jpbc.plaf.field.gt.GTFiniteElement) duplicate().mulZn(z).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement sqrt() {
        return (com.xvnan.jpbc.plaf.field.gt.GTFiniteElement) duplicate().sqrt().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.gt.GTFiniteElement pow(BigInteger n) {
        return duplicate().pow(n).getImmutable();
    }

    @Override
    public GTFiniteElement powZn(Element n) {
        return duplicate().powZn(n).getImmutable();
    }

}