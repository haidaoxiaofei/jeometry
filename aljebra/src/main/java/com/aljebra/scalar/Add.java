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
package com.aljebra.scalar;

import com.aljebra.field.Field;
import com.aljebra.field.FieldAddition;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import java.util.Arrays;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * A scalar represented as the scalar sum of a set of scalars.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
@ToString(includeFieldNames = false)
public final class Add implements Scalar {

    /**
     * Addition operands.
     */
    private final Multiset<Scalar> opers;

    /**
     * Constructor.
     * @param operands Addition operands
     */
    public Add(final Scalar... operands) {
        this.opers = HashMultiset.create(Arrays.asList(operands));
    }

    /**
     * Gives the addition operands.
     * @return Operands of the sum.
     */
    public Scalar[] operands() {
        return this.opers.toArray(new Scalar[this.opers.size()]);
    }

    @Override
    public <T> T value(final Field<T> field) {
        final FieldAddition<T> addition = field.addition();
        T result = addition.neutral();
        final Scalar[] operands = this.operands();
        for (int idx = 0; idx < operands.length; ++idx) {
            result = addition.add(result, operands[idx].value(field));
        }
        return result;
    }

}
