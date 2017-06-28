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
package com.jeometry.twod.point;

import com.aljebra.field.impl.doubles.Decimal;
import com.aljebra.metric.angle.VectsDegrees;
import com.aljebra.vector.Vect;
import com.jeometry.twod.line.Line;
import com.jeometry.twod.line.PtsLine;
import com.jeometry.twod.line.RandomLine;
import com.jeometry.twod.line.analytics.PointInLine;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link ProjectionPoint}.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class ProjectionPointTest {

    /**
     * {@link ProjectionPoint} can build a point that belongs
     * to the line projected onto.
     */
    @Test
    public void buildsBelongingPoint() {
        final Line line = new RandomLine();
        MatcherAssert.assertThat(
            new PointInLine(
                new ProjectionPoint(line, new RandomPoint(), new RandomPoint()),
                line
            ).resolve(new Decimal()),
            Matchers.is(true)
        );
    }

    /**
     * {@link ProjectionPoint} can build a point that, with the input point
     * forms a parallel line to the projection direction.
     */
    @Test
    public void makesParallelLine() {
        final Line dir = new RandomLine();
        final Vect input = new RandomPoint();
        final double error = 1.e-6;
        MatcherAssert.assertThat(
            new VectsDegrees(
                new PtsLine(
                    input, new ProjectionPoint(new RandomLine(), dir, input)
                ).direction(),
                dir.direction()
            ).resolve(new Decimal().product()).doubleValue(),
            Matchers.anyOf(
                Matchers.closeTo(0., error),
                Matchers.closeTo(-Math.PI, error),
                Matchers.closeTo(Math.PI, error)
            )
        );
    }

    /**
     * {@link ProjectionPoint} can build an orthogonally projected point.
     */
    @Test
    public void buildsOrthogonalProjection() {
        final Line line = new RandomLine();
        final Vect input = new RandomPoint();
        final double error = 1.e-6;
        MatcherAssert.assertThat(
            new VectsDegrees(
                new PtsLine(
                    input, new ProjectionPoint(line, input)
                ).direction(),
                line.direction()
            ).resolve(new Decimal().product()).doubleValue(),
            Matchers.anyOf(
                Matchers.closeTo(Math.PI / 2, error),
                Matchers.closeTo(-Math.PI / 2, error)
            )
        );
    }

}
