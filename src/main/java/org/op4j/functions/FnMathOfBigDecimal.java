/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.op4j.functions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

import org.apache.commons.lang.Validate;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class FnMathOfBigDecimal {

	private final static Max MAX_FUNC = new Max();
	
	private final static Min MIN_FUNC = new Min();
	
	private final static Sum SUM_FUNC = new Sum();
	
	private final static Avg AVG_FUNC = new Avg();
	
	private final static Abs ABS_FUNC = new Abs();
	
	
	FnMathOfBigDecimal() {
		super();           
	}

	/**
	 * @return function that returns the maximum {@link BigDecimal} of an object implementing {@link Iterable}
	 */
	public final IFunction<Iterable<BigDecimal>,BigDecimal> max() {
        return MAX_FUNC;
    }
	
	/**
	 * @return function that returns the minimum {@link BigDecimal} of an object implementing {@link Iterable}
	 */
	public final IFunction<Iterable<BigDecimal>,BigDecimal> min() {
        return MIN_FUNC;
    }
	
	/**
	 * @return function that returns the sum of the {@link BigDecimal} elements in an object 
	 * implementing {@link Iterable}
	 */
	public final IFunction<Iterable<BigDecimal>,BigDecimal> sum() {
        return SUM_FUNC;
    }
	
	/**
	 * @return function that returns the average of the {@link BigDecimal} elements in an object 
	 * implementing {@link Iterable}
	 */
	public final IFunction<Iterable<BigDecimal>,BigDecimal> avg() {
        return AVG_FUNC;
    }
	public final IFunction<Iterable<BigDecimal>,BigDecimal> avg(MathContext mathContext) {
        return new Avg(mathContext);
    }
	public final IFunction<Iterable<BigDecimal>,BigDecimal> avg(RoundingMode roundingMode) {
		return new Avg(roundingMode);
    }
	
	public final IFunction<BigDecimal,BigDecimal> round(MathContext mathContext) {
        return new Round(mathContext);
    }
	public final IFunction<BigDecimal,BigDecimal> round(RoundingMode roundingMode) {
		return new Round(roundingMode);
    }
	
	public final IFunction<BigDecimal,BigDecimal> abs() {
		return ABS_FUNC;
    }
	
	public final IFunction<BigDecimal,BigDecimal> add(Number add) {
		return new Add(fromNumber(add));
    }
	
	public final IFunction<BigDecimal,BigDecimal> subtract(Number subtract) {
		return new Subtract(fromNumber(subtract));
    }
	
	public final IFunction<BigDecimal,BigDecimal> divideBy(Number divisor) {
		return new Divide(fromNumber(divisor));
    }
	public final IFunction<BigDecimal,BigDecimal> divideBy(Number divisor, MathContext mathContext) {
        return new Divide(fromNumber(divisor), mathContext);
    }
	public final IFunction<BigDecimal,BigDecimal> divideBy(Number divisor, RoundingMode roundingMode) {
		return new Divide(fromNumber(divisor), roundingMode);
    }
	
	public final IFunction<BigDecimal,BigDecimal> remainder(Number divisor) {
		return new Remainder(fromNumber(divisor));
    }
	public final IFunction<BigDecimal,BigDecimal> remainder(Number divisor, MathContext mathContext) {
		return new Remainder(fromNumber(divisor), mathContext);
    }
	
	public final IFunction<BigDecimal,BigDecimal> multiplyBy(Number multiplicand) {
		return new Multiply(fromNumber(multiplicand));
    }
	public final IFunction<BigDecimal,BigDecimal> multiplyBy(Number multiplicand, MathContext mathContext) {
        return new Multiply(fromNumber(multiplicand), mathContext);
    }
	public final IFunction<BigDecimal,BigDecimal> multiplyBy(Number multiplicand, RoundingMode roundingMode) {
		return new Multiply(fromNumber(multiplicand), roundingMode);
    }
	
	public final IFunction<BigDecimal,BigDecimal> pow(int power) {
		return new Pow(power);
    }
	public final IFunction<BigDecimal,BigDecimal> pow(int power, MathContext mathContext) {
        return new Pow(power, mathContext);
    }
	public final IFunction<BigDecimal,BigDecimal> pow(int power, RoundingMode roundingMode) {
		return new Pow(power, roundingMode);
    }
	
	
	
	
	private static BigDecimal fromNumber(final Number number) {
	    if (number == null) {
	        return null;
	    }
	    if (number instanceof BigDecimal) {
	        return (BigDecimal) number;
	    }
	    if (number instanceof BigInteger) {
	        return new BigDecimal((BigInteger)number);
	    }
	    return BigDecimal.valueOf(number.doubleValue());
	}
	
	
	
	
	static final class Max extends AbstractNotNullFunction<Iterable<BigDecimal>,BigDecimal> {

		Max() {
			super();
		}

		@Override
		protected BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			BigDecimal max = input.iterator().next();
			for (BigDecimal number : input) {
				if (number != null) {
					if (number.compareTo(max) > 0) {
						max = number;
					}
				}
			}	
			return max;
		}
	}
	
	static final class Min extends AbstractNotNullFunction<Iterable<BigDecimal>,BigDecimal> {

		Min() {
			super();
		}

		@Override
		protected BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			BigDecimal min = input.iterator().next();
			for (BigDecimal number : input) {
				if (number != null) {
					if (number.compareTo(min) < 0) {
						min = number;
					}
				}
			}	
			return min;
		}	
	}
	
	static final class Sum extends AbstractNotNullFunction<Iterable<BigDecimal>,BigDecimal> {

		Sum() {
			super();
		}

		@Override
		protected BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
			BigDecimal sum = BigDecimal.valueOf(0);
			for (BigDecimal number : input) {
				if (number != null) {
					sum = sum.add(number);
				}
			}	
			return sum;
		}		
	}
	
	static final class Avg extends AbstractNotNullFunction<Iterable<BigDecimal>,BigDecimal> {

		private final RoundingMode roundingMode;
		private final MathContext mathContext;
		
		Avg() {
			super();
			this.roundingMode = null;
			this.mathContext = null;
		}

		Avg(RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.roundingMode = roundingMode;
			this.mathContext = null;
		}
		
		Avg(MathContext mathContext) {
			super();
			Validate.notNull(mathContext, "MathContext can't be null");
			this.roundingMode = null;
			this.mathContext = mathContext;
		}
		
		@Override
		protected BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
			
			int countNotNull = 0;
			BigDecimal sum = BigDecimal.valueOf(0);
			for (BigDecimal number : input) {
				if (number != null) {
					sum = sum.add(number);
					countNotNull++;
				}
			}	
			if (this.roundingMode != null) {
				return sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode);
			}
			if (this.mathContext != null) {
				return sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext);
			}
			return sum.divide(BigDecimal.valueOf(countNotNull));
		}		
	}
	
	static final class Round extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final MathContext mathContext;
		private final RoundingMode roundingMode;
		
		Round(RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.mathContext = null;
			this.roundingMode = roundingMode;
		}
		
		Round(MathContext mathContext) {
			super();
			Validate.notNull(mathContext, "MathContext can't be null");
			this.mathContext = mathContext;
			this.roundingMode = null;
		}
		
		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			if (this.roundingMode != null) {
				return result.setScale(0, this.roundingMode);
			}			
			return result.round(this.mathContext);
		}	
	}
	
	static final class Abs extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		Abs() {
			super();
		}
		
		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			return input.abs();
		}
	}
	
	static final class Add extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final BigDecimal add;
		
		Add(BigDecimal add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			result = result.add(this.add);
				
			return result;
		}	
	}
	
	static final class Subtract extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final BigDecimal subtract;
		
		Subtract(BigDecimal subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			result = result.subtract(this.subtract);
				
			return result;
		}		
	}
	
	static final class Divide extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final BigDecimal divisor;
		private final RoundingMode roundingMode;
		private final MathContext mathContext;
		
		Divide(BigDecimal divisor) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = null;
		}
		
		Divide(BigDecimal divisor, RoundingMode roundingMode) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.divisor = divisor;
			this.roundingMode = roundingMode;
			this.mathContext = null;
		}
		
		Divide(BigDecimal divisor, MathContext mathContext) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = mathContext;
		}

		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			
			if (this.roundingMode != null) {
				result = result.divide(this.divisor, this.roundingMode);					
			} else if (this.mathContext != null) {
				result = result.divide(this.divisor, this.mathContext);				
			} else {
				result = result.divide(this.divisor);	
			}
			return result;
		}		
	}
	
	
	static final class Remainder extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final BigDecimal divisor;
		private final MathContext mathContext;
		
		Remainder(BigDecimal divisor) {
			super();
			this.divisor = divisor;
			this.mathContext = null;
		}
		
		Remainder(BigDecimal divisor, MathContext mathContext) {
			super();
			this.divisor = divisor;
			this.mathContext = mathContext;
		}
		
		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			if (this.mathContext != null) {
				return input.remainder(this.divisor, this.mathContext);
			}
			return input.remainder(this.divisor);
		}	
	}
	
	static final class Multiply extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final BigDecimal multiplicand;
		private final MathContext mathContext;
		private final RoundingMode roundingMode;
		
		Multiply(BigDecimal multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = null;
		}
		
		Multiply(BigDecimal multiplicand, RoundingMode roundingMode) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = roundingMode;
		}
		
		Multiply(BigDecimal multiplicand, MathContext mathContext) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = mathContext;
			this.roundingMode = null;
		}

		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			
			if (this.mathContext != null) {
				result = result.multiply(this.multiplicand, this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.multiply(this.multiplicand).setScale(0, this.roundingMode);	
			} else {
				result = result.multiply(this.multiplicand);	
			}
			return result;
		}	
	}
	
	static final class Pow extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final int power;
		private final MathContext mathContext;
		private final RoundingMode roundingMode;
		
		Pow(int power) {
			super();
			this.power = power;
			this.mathContext = null;
			this.roundingMode = null;
		}
		
		Pow(int power, RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.power = power;
			this.mathContext = null;
			this.roundingMode = roundingMode;
		}
		
		Pow(int power, MathContext mathContext) {
			super();
			Validate.notNull(mathContext, "MathContext can't be null");
			this.power = power;
			this.mathContext = mathContext;
			this.roundingMode = null;
		}

		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			
			if (this.mathContext != null) {
				result = result.pow(this.power, this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.pow(this.power).setScale(0, this.roundingMode);	
			} else {
				result = result.pow(this.power);	
			}
			return result;
		}		
	}
}
