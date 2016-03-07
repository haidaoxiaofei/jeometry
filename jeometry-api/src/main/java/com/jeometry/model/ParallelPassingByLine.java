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
package com.jeometry.model;

/**
 * A line defined by being parallel to another line, and passing by a given
 * point.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @since 0.1
 */
public final class ParallelPassingByLine implements Line {

    /**
     * The point to pass by.
     */
    private Vector point;

    /**
     * The line to be parallel to.
     */
    private Line parallel;

    /**
     * Constructor.
     * @param point The point to pass by
     * @param parallel The line to be parallel to
     */
    public ParallelPassingByLine(final Vector point, final Line parallel) {
        super();
        this.point = point;
        this.parallel = parallel;
    }

    @Override
    public Vector direction() {
        return this.parallel.direction();
    }

    @Override
    public Vector point() {
        return this.point;
    }

}
