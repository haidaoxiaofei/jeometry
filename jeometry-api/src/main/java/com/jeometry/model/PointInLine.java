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

import com.jeometry.model.scalar.Scalar;
import com.jeometry.model.scalar.ScalarSupplier;
import com.jeometry.op.Sum;
import com.jeometry.op.Times;

/**
 * A point defined by belonging to a line.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @since 0.1
 */
public class PointInLine implements Vector {

    /**
     * The line to belong to.
     */
    private final Line line;

    /**
     * A random scalar.
     */
    private final Scalar factor;

    /**
     * Constructor.
     * @param line The line to belong to
     * @param supp Scalar supplier for randomization
     */
    public PointInLine(final Line line, final ScalarSupplier supp) {
        super();
        this.line = line;
        this.factor = supp.random();
    }

    @Override
    public Scalar x() {
        return new Sum(
            new Times(this.line.direction(), this.factor), this.line.point()
        ).x();
    }

    @Override
    public Scalar y() {
        return new Sum(
            new Times(this.line.direction(), this.factor), this.line.point()
        ).y();
    }

}
