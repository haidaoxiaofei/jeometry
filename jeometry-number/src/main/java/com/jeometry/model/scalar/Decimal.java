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
 * A {@link ScalarSupplier} implementation based on double.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Decimal implements ScalarSupplier {

    /**
     * Minimum value to generate when randomizing a scalar.
     */
	private static final int MINBOUND = -1000;
	/**
     * Maximum value to generate when randomizing a scalar.
     */
	private static final int MAXBOUND = 1000;
	
	/**
	 * A tolerance threshold to consider two values as equal.
	 */
	private static final double TOLERANCE = 1.E-3;

	/**
	 * Randomizer.
	 */
	private final transient java.util.Random rand;

	/**
	 * Constructor.
	 */
	public Decimal() {
		this(new java.util.Random());
	}

	/**
	 * Constructor.
	 * @param rand Randomizer
	 */
	public Decimal(java.util.Random rand) {
		super();
		this.rand = rand;
	}

	@Override
	public Scalar random() {
		return new Scalar.Default<Double>(
			this.rand.nextDouble()
			* (Decimal.MAXBOUND - Decimal.MINBOUND)
			+ Decimal.MINBOUND
		);
	}

	@Override
	public Scalar other(Scalar x) {
		Scalar result = this.random();
		while (this.equals(result, x)) {
		    result = this.random();
		}
		return result;
	}

	@Override
	public Scalar addIdentity() {
		return new Scalar.Default<Double>(new Double(0));
	}

	@SuppressWarnings("unchecked")
    @Override
	public boolean equals(Scalar x, Scalar y) {
		if (Scalar.Default.class.isAssignableFrom(x.getClass())
		    && Scalar.Default.class.isAssignableFrom(y.getClass())) {
		    return Math.abs(
		        ((Scalar.Default<Double>)x).value()
		        - ((Scalar.Default<Double>)y).value()
		    ) < Decimal.TOLERANCE;
		}
		return false;
	}

	

}
