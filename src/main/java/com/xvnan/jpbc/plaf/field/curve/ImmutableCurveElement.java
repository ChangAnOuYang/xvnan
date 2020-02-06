package com.xvnan.jpbc.plaf.field.curve;

import com.xvnan.jpbc.api.Element;
import com.xvnan.jpbc.plaf.field.curve.CurveElement;
import com.xvnan.jpbc.plaf.field.curve.CurveField;

import java.math.BigInteger;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 */
public class ImmutableCurveElement<E extends Element, F extends CurveField> extends com.xvnan.jpbc.plaf.field.curve.CurveElement<E, F> {

    public ImmutableCurveElement(com.xvnan.jpbc.plaf.field.curve.CurveElement<E,F> curveElement) {
        super(curveElement);
        this.x = (E) curveElement.getX().getImmutable();
        this.y = (E) curveElement.getY().getImmutable();

        this.immutable = true;
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement duplicate() {
        return super.duplicate();
    }

    public Element getImmutable() {
        return this;
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement set(Element e) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement set(int value) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement set(BigInteger value) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement twice() {
        return (com.xvnan.jpbc.plaf.field.curve.CurveElement) super.duplicate().twice().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement setToZero() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement setToOne() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement setToRandom() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public int setFromBytes(byte[] source, int offset) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement square() {
        return (com.xvnan.jpbc.plaf.field.curve.CurveElement) super.duplicate().square().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement invert() {
        return (com.xvnan.jpbc.plaf.field.curve.CurveElement) super.duplicate().invert().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement negate() {
        return (com.xvnan.jpbc.plaf.field.curve.CurveElement) super.duplicate().negate().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement add(Element e) {
        return (com.xvnan.jpbc.plaf.field.curve.CurveElement) super.duplicate().add(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement mul(Element e) {
        return (com.xvnan.jpbc.plaf.field.curve.CurveElement) super.duplicate().mul(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement mul(BigInteger n) {
        return (com.xvnan.jpbc.plaf.field.curve.CurveElement) super.duplicate().mul(n).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement mulZn(Element e) {
        return (com.xvnan.jpbc.plaf.field.curve.CurveElement) super.duplicate().mulZn(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement powZn(Element e) {
        return (com.xvnan.jpbc.plaf.field.curve.CurveElement) super.duplicate().powZn(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.curve.CurveElement setFromHash(byte[] source, int offset, int length) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public int setFromBytesCompressed(byte[] source) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public int setFromBytesCompressed(byte[] source, int offset) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public int setFromBytesX(byte[] source) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public int setFromBytesX(byte[] source, int offset) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public int setFromBytes(byte[] source) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public Element pow(BigInteger n) {
        return (com.xvnan.jpbc.plaf.field.curve.CurveElement) super.duplicate().pow(n).getImmutable();
    }

    @Override
    public Element halve() {
        return (com.xvnan.jpbc.plaf.field.curve.CurveElement) super.duplicate().halve().getImmutable();
    }

    @Override
    public Element sub(Element element) {
        return (com.xvnan.jpbc.plaf.field.curve.CurveElement) super.duplicate().sub(element).getImmutable();
    }

    @Override
    public Element div(Element element) {
        return (com.xvnan.jpbc.plaf.field.curve.CurveElement) super.duplicate().div(element).getImmutable();
    }

    @Override
    public Element mul(int z) {
        return (com.xvnan.jpbc.plaf.field.curve.CurveElement) super.duplicate().mul(z).getImmutable();
    }

    @Override
    public Element sqrt() {
        return (CurveElement) super.duplicate().sqrt().getImmutable();
    }

}
