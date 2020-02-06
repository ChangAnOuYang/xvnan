package com.xvnan.jpbc.plaf.field.quadratic;

import com.xvnan.jpbc.api.Element;
import com.xvnan.jpbc.plaf.field.quadratic.DegreeTwoExtensionQuadraticElement;
import com.xvnan.jpbc.plaf.field.quadratic.DegreeTwoExtensionQuadraticField;
import com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement;

import java.math.BigInteger;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 */
public class ImmutableDegreeTwoExtensionQuadraticElement<E extends Element> extends com.xvnan.jpbc.plaf.field.quadratic.DegreeTwoExtensionQuadraticElement<E> {

    public ImmutableDegreeTwoExtensionQuadraticElement(com.xvnan.jpbc.plaf.field.quadratic.DegreeTwoExtensionQuadraticElement<E> element) {
        super((DegreeTwoExtensionQuadraticField)element.getField());

        this.x = (E) element.getX().getImmutable();
        this.y = (E) element.getY().getImmutable();

        this.immutable = true;
    }

    @Override
    public Element getImmutable() {
        return this;
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.DegreeTwoExtensionQuadraticElement duplicate() {
        return super.duplicate();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement set(Element e) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement set(int value) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement set(BigInteger value) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement setToZero() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement setToOne() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement setToRandom() {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public int setFromBytes(byte[] source, int offset) {
        throw new IllegalStateException("Invalid call on an immutable element");
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement twice() {
        return (com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement) super.duplicate().twice().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement mul(int z) {
        return (com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement) super.duplicate().mul(z).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.DegreeTwoExtensionQuadraticElement square() {
        return (com.xvnan.jpbc.plaf.field.quadratic.DegreeTwoExtensionQuadraticElement) super.duplicate().square().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.DegreeTwoExtensionQuadraticElement invert() {
        return (com.xvnan.jpbc.plaf.field.quadratic.DegreeTwoExtensionQuadraticElement) super.duplicate().invert().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement negate() {
        return (com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement) super.duplicate().negate().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement add(Element e) {
        return (com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement) super.duplicate().add(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement sub(Element e) {
        return (com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement) super.duplicate().sub(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.DegreeTwoExtensionQuadraticElement mul(Element e) {
        return (com.xvnan.jpbc.plaf.field.quadratic.DegreeTwoExtensionQuadraticElement) super.duplicate().mul(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement mul(BigInteger n) {
        return (com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement) super.duplicate().mul(n).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement mulZn(Element e) {
        return (com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement) super.duplicate().mulZn(e).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.DegreeTwoExtensionQuadraticElement sqrt() {
        return (DegreeTwoExtensionQuadraticElement) super.duplicate().sqrt().getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement powZn(Element n) {
        return (com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement) super.duplicate().powZn(n).getImmutable();
    }

    @Override
    public com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement setFromHash(byte[] source, int offset, int length) {
        return (com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement) super.duplicate().setFromHash(source, offset, length).getImmutable();
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
        return (com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement) super.duplicate().pow(n).getImmutable();
    }

    @Override
    public Element halve() {
        return (com.xvnan.jpbc.plaf.field.quadratic.QuadraticElement) super.duplicate().halve().getImmutable();
    }

    @Override
    public Element div(Element element) {
        return (QuadraticElement) super.duplicate().div(element).getImmutable();
    }

}
