package com.xvnan.jpbc.plaf.util.io.disk;

import com.xvnan.jpbc.plaf.util.io.disk.Sector;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 * @since 1.0.0
 */
public interface Disk<S extends Sector> {

    S getSectorAt(int index);

    S getSector(String key);

    void flush();
}
