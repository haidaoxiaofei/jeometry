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
package com.aljebra.vector.metric;

import com.aljebra.aspects.DimensionsEqual;
import com.aljebra.field.Field;
import com.aljebra.field.MetricSpaceField;
import com.aljebra.scalar.Scalar;
import com.aljebra.vector.Vect;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Class representing dot operation (scalar product) or inner product
 * of 2 vectors.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@ToString(includeFieldNames = false)
@EqualsAndHashCode
public final class Product implements Scalar {

    /**
     * First operand.
     */
    private final Vect first;

    /**
     * Second operand.
     */
    private final Vect second;

    /**
     * Constructor.
     * @param first First operand
     * @param second Second operand
     */
    @DimensionsEqual
    public Product(final Vect first, final Vect second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public <T> T value(final Field<T> field) {
        if (field instanceof MetricSpaceField<?>) {
            final MetricSpaceField<T> metric = (MetricSpaceField<T>) field;
            return field.actual(
                metric.product().product(this.first, this.second)
            );
        } else {
            throw new UnsupportedOperationException(
                String.format("Field %s is not a metric space field", field)
            );
        }
    }

}