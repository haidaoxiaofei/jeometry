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
package com.jeometry.model.scalar;

/**
 * A scalar represented as the division of a scalar by another scalar.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Division implements Scalar {
    /**
     * First operand.
     */
    private final Scalar first;

    /**
     * Second operand.
     */
    private final Scalar second;

    /**
     * Constructor.
     * @param first First operand (dividend)
     * @param second Second operand (divisor)
     */
    public Division(final Scalar first, final Scalar second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Gives first operand (dividend).
     * @return The first operand of the division.
     */
    public Scalar first() {
        return first;
    }

    /**
     * Gives second operand (divisor).
     * @return The second operand of the sum.
     */
    public Scalar second() {
        return second;
    }

}
