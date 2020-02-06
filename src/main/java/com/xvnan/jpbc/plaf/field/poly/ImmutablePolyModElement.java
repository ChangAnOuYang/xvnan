package com.xvnan.jpbc.plaf.field.poly;

import com.xvnan.jpbc.api.Element;
import com.xvnan.jpbc.plaf.field.poly.PolyModElement;

import java.math.BigInteger;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 */
public class ImmutablePolyModElement<E extends Element> extends com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> {

    public ImmutablePolyModElement(com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> element) {
        super(element.getField());

        coefficients.clear();
        for (int i = 0; i < field.n; i++) {
            coefficients.add((E) element.getCoefficient(i).getImmutable());
        }
        this.immutable = true;
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> duplicate() {
        return super.duplicate();
    }

    @Override
    public Element getImmutable() {
        return this;
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> set(Element e) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> set(int value) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> set(BigInteger value) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> setToRandom() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> setFromHash(byte[] source, int offset, int length) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> setToZero() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> setToOne() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> map(Element e) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> twice() {
        return (com.xvnan.jpbc.plaf.field.poly.PolyModElement<E>) super.duplicate().twice().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> square() {
        return (com.xvnan.jpbc.plaf.field.poly.PolyModElement<E>) super.duplicate().square().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> invert() {
        return (com.xvnan.jpbc.plaf.field.poly.PolyModElement<E>) super.duplicate().invert().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> negate() {
        return (com.xvnan.jpbc.plaf.field.poly.PolyModElement<E>) super.duplicate().negate().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> add(Element e) {
        return (com.xvnan.jpbc.plaf.field.poly.PolyModElement<E>) super.duplicate().add(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> sub(Element e) {
        return (com.xvnan.jpbc.plaf.field.poly.PolyModElement<E>) super.duplicate().sub(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> mul(Element e) {
        return (com.xvnan.jpbc.plaf.field.poly.PolyModElement<E>) super.duplicate().mul(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> mul(int z) {
        return (com.xvnan.jpbc.plaf.field.poly.PolyModElement<E>) super.duplicate().mul(z).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> mul(BigInteger n) {
        return (com.xvnan.jpbc.plaf.field.poly.PolyModElement<E>) super.duplicate().mul(n).getImmutable();
    }

    @Override
    public Element pow(BigInteger n) {
        return (com.xvnan.jpbc.plaf.field.poly.PolyModElement<E>) super.duplicate().pow(n).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> powZn(Element e) {
        return (com.xvnan.jpbc.plaf.field.poly.PolyModElement<E>) super.duplicate().powZn(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.poly.PolyModElement<E> sqrt() {
        return (com.xvnan.jpbc.plaf.field.poly.PolyModElement<E>) super.duplicate().sqrt().getImmutable();
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
    public Element halve() {
        return (com.xvnan.jpbc.plaf.field.poly.PolyModElement<E>) super.duplicate().halve().getImmutable();
    }

    @Override
    public Element div(Element element) {
        return (com.xvnan.jpbc.plaf.field.poly.PolyModElement<E>) super.duplicate().div(element).getImmutable();
    }

    @Override
    public Element mulZn(Element z) {
        return (PolyModElement<E>) super.duplicate().mulZn(z).getImmutable();
    }

}
