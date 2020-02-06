package com.xvnan.jpbc.plaf.field.z;

import com.xvnan.jpbc.api.Element;
import com.xvnan.jpbc.plaf.field.z.ZrElement;

import java.math.BigInteger;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 */
public class ImmutableZrElement extends com.xvnan.jpbc.plaf.field.z.ZrElement {

    public ImmutableZrElement(com.xvnan.jpbc.plaf.field.z.ZrElement zrElement) {
        super(zrElement);
        this.immutable = true;
    }

    @Override
    public Element getImmutable() {
        return this;
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement duplicate() {
        return super.duplicate();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement set(Element value) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement set(int value) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement set(BigInteger value) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement setToZero() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement setToOne() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement setToRandom() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement setFromHash(byte[] source, int offset, int length) {
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
    public com.xvnan.jpbc.plaf.field.z.ZrElement twice() {
        return (com.xvnan.jpbc.plaf.field.z.ZrElement) super.duplicate().twice().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement mul(int z) {
        return (com.xvnan.jpbc.plaf.field.z.ZrElement) super.duplicate().mul(z).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement square() {
        return (com.xvnan.jpbc.plaf.field.z.ZrElement) super.duplicate().square().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement invert() {
        return (com.xvnan.jpbc.plaf.field.z.ZrElement) super.duplicate().invert().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement halve() {
        return (com.xvnan.jpbc.plaf.field.z.ZrElement) super.duplicate().halve().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement negate() {
        return (com.xvnan.jpbc.plaf.field.z.ZrElement) super.duplicate().negate().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement add(Element element) {
        return (com.xvnan.jpbc.plaf.field.z.ZrElement) super.duplicate().add(element).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement sub(Element element) {
        return (com.xvnan.jpbc.plaf.field.z.ZrElement) super.duplicate().sub(element).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement div(Element element) {
        return (com.xvnan.jpbc.plaf.field.z.ZrElement) super.duplicate().div(element).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement mul(Element element) {
        return (com.xvnan.jpbc.plaf.field.z.ZrElement) super.duplicate().mul(element).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement mul(BigInteger n) {
        return (com.xvnan.jpbc.plaf.field.z.ZrElement) super.duplicate().mul(n).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement mulZn(Element z) {
        return (com.xvnan.jpbc.plaf.field.z.ZrElement) super.duplicate().mulZn(z).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement sqrt() {
        return (com.xvnan.jpbc.plaf.field.z.ZrElement) super.duplicate().sqrt().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement pow(BigInteger n) {
        return (com.xvnan.jpbc.plaf.field.z.ZrElement) super.duplicate().pow(n).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.z.ZrElement powZn(Element n) {
        return (ZrElement) super.duplicate().powZn(n).getImmutable();
    }

}
