package com.xvnan.jpbc.plaf.util.io.disk;

import com.xvnan.jpbc.plaf.util.io.disk.Sector;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 * @since 2.0.0
 */
public interface ArraySector<T> extends Sector {

    int getSize();

    T getAt(int index);

    void setAt(int index, T value);


    T getAt(String label);

    void setAt(String label, T value);

}
