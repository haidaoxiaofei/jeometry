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
package com.jeometry.twod.segment;

import com.aljebra.field.Field;
import com.aljebra.field.impl.doubles.Decimal;
import com.aljebra.metric.scalar.Norm;
import com.aljebra.scalar.Random;
import com.aljebra.scalar.Scalar;
import com.aljebra.vector.Minus;
import com.aljebra.vector.Vect;
import com.jeometry.twod.point.RandomPoint;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link LengthSegment}.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class LengthSegmentTest {

    /**
     * {@link LengthSegment} builds a segment congruent to the passed segment.
     */
    @Test
    public void createsCongruentSegment() {
        final Segment ref = new RandomSegment();
        final Segment seg = new LengthSegment(ref);
        final Field<Double> dec = new Decimal();
        final double error = 1.e-6;
        MatcherAssert.assertThat(
            new Norm(new Minus(ref.end(), ref.start())).value(dec),
            Matchers.closeTo(
                new Norm(new Minus(seg.end(), seg.start())).value(dec), error
            )
        );
    }

    /**
     * {@link LengthSegment} builds a segment congruent to the passed segment,
     * having the passed start extremity.
     */
    @Test
    public void createsCongruentSegmentWithStartPoint() {
        final Segment ref = new RandomSegment();
        final Vect start = new RandomPoint();
        final Segment seg = new LengthSegment(start, ref);
        final Field<Double> dec = new Decimal();
        final double error = 1.e-6;
        MatcherAssert.assertThat(
            new Norm(new Minus(ref.end(), ref.start())).value(dec),
            Matchers.closeTo(
                new Norm(new Minus(seg.end(), seg.start())).value(dec), error
            )
        );
        MatcherAssert.assertThat(seg.start(), Matchers.equalTo(start));
    }

    /**
     * {@link LengthSegment} builds a segment with the given length.
     */
    @Test
    public void createsLengthSegment() {
        final Scalar length = new Random();
        final Segment seg = new LengthSegment(length);
        final Field<Double> dec = new Decimal();
        final double error = 1.e-6;
        MatcherAssert.assertThat(
            Math.abs(length.value(dec)),
            Matchers.closeTo(
                new Norm(new Minus(seg.end(), seg.start())).value(dec), error
            )
        );
    }

    /**
     * {@link LengthSegment} builds a segment with the given length,
     * having the passed start extremity.
     */
    @Test
    public void createsLengthSegmentWithStartPoint() {
        final Scalar length = new Random();
        final Vect start = new RandomPoint();
        final Segment seg = new LengthSegment(start, length);
        final Field<Double> dec = new Decimal();
        final double error = 1.e-6;
        MatcherAssert.assertThat(
            Math.abs(length.value(dec)),
            Matchers.closeTo(
                new Norm(new Minus(seg.end(), seg.start())).value(dec), error
            )
        );
        MatcherAssert.assertThat(seg.start(), Matchers.equalTo(start));
    }
}