/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2016, Hamdi Douss
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
 * OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.jeometry.twod.angle;

import com.aljebra.vector.Vect;
import lombok.ToString;

/**
 * An angle defined by a point, a vector porting the starting ray,
 * and a vector porting the ending ray.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@ToString
public class VectsAngle implements Angle {

    /**
     * Angle origin.
     */
    private final Vect org;

    /**
     * Vector porting the starting ray.
     */
    private final Vect frst;

    /**
     * Vector porting the ending ray.
     */
    private final Vect scnd;

    /**
     * Constructor.
     * @param origin Angle summit (vertex)
     * @param start Vector porting the starting ray
     * @param end Vector porting the ending ray
     */
    public VectsAngle(final Vect origin, final Vect start, final Vect end) {
        this.org = origin;
        this.frst = start;
        this.scnd = end;
    }

    @Override
    public final Vect origin() {
        return this.org;
    }

    @Override
    public final Vect start() {
        return this.frst;
    }

    @Override
    public final Vect end() {
        return this.scnd;
    }
}
