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
public final class FnMathOfBigInteger {

	private final static IFunction<Iterable<BigInteger>, BigInteger> MAX_FUNC = new Max();
	
	private final static IFunction<Iterable<BigInteger>, BigInteger> MIN_FUNC = new Min();
	
	private final static IFunction<Iterable<BigInteger>, BigInteger> SUM_FUNC = new Sum();
	
	private final static IFunction<Iterable<BigInteger>, BigInteger> AVG_FUNC = new Avg();

    private final static IFunction<BigInteger[], BigInteger> MAX_ARRAY_FUNC = new MaxArray();
    
    private final static IFunction<BigInteger[], BigInteger> MIN_ARRAY_FUNC = new MinArray();
    
    private final static IFunction<BigInteger[], BigInteger> SUM_ARRAY_FUNC = new SumArray();
    
    private final static IFunction<BigInteger[], BigInteger> AVG_ARRAY_FUNC = new AvgArray();
	
	private final static IFunction<BigInteger, BigInteger> ABS_FUNC = new Abs();
	
	
	FnMathOfBigInteger() {
		super();           
	}

    /**
     * @return function that returns the maximum {@link BigInteger} of an object
     *         implementing {@link Iterable}
     */
    public final IFunction<Iterable<BigInteger>, BigInteger> max() {
        return MAX_FUNC;
    }

    /**
     * @return function that returns the minimum {@link BigInteger} of an object
     *         implementing {@link Iterable}
     */
    public final IFunction<Iterable<BigInteger>, BigInteger> min() {
        return MIN_FUNC;
    }

    /**
     * @return function that returns the sum of the {@link BigInteger} elements
     *         in an object implementing {@link Iterable}
     */
    public final IFunction<Iterable<BigInteger>, BigInteger> sum() {
        return SUM_FUNC;
    }

    /**
     * @return function that returns the average of the {@link BigInteger}
     *         elements in an object implementing {@link Iterable}
     */
    public final IFunction<Iterable<BigInteger>, BigInteger> avg() {
        return AVG_FUNC;
    }

    public final IFunction<Iterable<BigInteger>, BigInteger> avg(RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }

    public final IFunction<Iterable<BigInteger>, BigInteger> avg(MathContext mathContext) {
        return new Avg(mathContext);
    }
    
    public final IFunction<BigInteger[], BigInteger> maxArray() {
        return MAX_ARRAY_FUNC;
    }

    public final IFunction<BigInteger[], BigInteger> minArray() {
        return MIN_ARRAY_FUNC;
    }

    public final IFunction<BigInteger[], BigInteger> sumArray() {
        return SUM_ARRAY_FUNC;
    }

    public final IFunction<BigInteger[], BigInteger> avgArray() {
        return AVG_ARRAY_FUNC;
    }

    public final IFunction<BigInteger[], BigInteger> avgArray(RoundingMode roundingMode) {
        return new AvgArray(roundingMode);
    }

    public final IFunction<BigInteger[], BigInteger> avgArray(MathContext mathContext) {
        return new AvgArray(mathContext);
    }

    public final IFunction<BigInteger, BigInteger> abs() {
        return ABS_FUNC;
    }

    public final IFunction<BigInteger, BigInteger> add(Number add) {
        return new Add(fromNumber(add));
    }

    public final IFunction<BigInteger, BigInteger> add(byte add) {
        return add(Byte.valueOf(add));
    }

    public final IFunction<BigInteger, BigInteger> add(short add) {
        return add(Short.valueOf(add));
    }

    public final IFunction<BigInteger, BigInteger> add(int add) {
        return add(Integer.valueOf(add));
    }

    public final IFunction<BigInteger, BigInteger> add(long add) {
        return add(Long.valueOf(add));
    }

    public final IFunction<BigInteger, BigInteger> add(float add) {
        return add(Float.valueOf(add));
    }

    public final IFunction<BigInteger, BigInteger> add(double add) {
        return add(Double.valueOf(add));
    }


    public final IFunction<BigInteger, BigInteger> subtract(Number subtract) {
        return new Subtract(fromNumber(subtract));
    }

    public final IFunction<BigInteger, BigInteger> subtract(byte subtract) {
        return subtract(Byte.valueOf(subtract));
    }

    public final IFunction<BigInteger, BigInteger> subtract(short subtract) {
        return subtract(Short.valueOf(subtract));
    }

    public final IFunction<BigInteger, BigInteger> subtract(int subtract) {
        return subtract(Integer.valueOf(subtract));
    }

    public final IFunction<BigInteger, BigInteger> subtract(long subtract) {
        return subtract(Long.valueOf(subtract));
    }

    public final IFunction<BigInteger, BigInteger> subtract(float subtract) {
        return subtract(Float.valueOf(subtract));
    }

    public final IFunction<BigInteger, BigInteger> subtract(double subtract) {
        return subtract(Double.valueOf(subtract));
    }


    public final IFunction<BigInteger, BigInteger> divideBy(Number divisor) {
        return new Divide(fromNumber(divisor));
    }

    public final IFunction<BigInteger, BigInteger> divideBy(byte divisor) {
        return divideBy(Byte.valueOf(divisor));
    }

    public final IFunction<BigInteger, BigInteger> divideBy(short divisor) {
        return divideBy(Short.valueOf(divisor));
    }

    public final IFunction<BigInteger, BigInteger> divideBy(int divisor) {
        return divideBy(Integer.valueOf(divisor));
    }

    public final IFunction<BigInteger, BigInteger> divideBy(long divisor) {
        return divideBy(Long.valueOf(divisor));
    }

    public final IFunction<BigInteger, BigInteger> divideBy(float divisor) {
        return divideBy(Float.valueOf(divisor));
    }

    public final IFunction<BigInteger, BigInteger> divideBy(double divisor) {
        return divideBy(Double.valueOf(divisor));
    }


    public final IFunction<BigInteger, BigInteger> module(Number module) {
        return new Module(fromNumber(module));
    }

    public final IFunction<BigInteger, BigInteger> remainder(Number module) {
        return new Remainder(fromNumber(module));
    }

    public final IFunction<BigInteger, BigInteger> multiplyBy(Number multiplicand) {
        return new Multiply(fromNumber(multiplicand));
    }

    public final IFunction<BigInteger, BigInteger> multiplyBy(byte multiplicand) {
        return multiplyBy(Byte.valueOf(multiplicand));
    }

    public final IFunction<BigInteger, BigInteger> multiplyBy(short multiplicand) {
        return multiplyBy(Short.valueOf(multiplicand));
    }

    public final IFunction<BigInteger, BigInteger> multiplyBy(int multiplicand) {
        return multiplyBy(Integer.valueOf(multiplicand));
    }

    public final IFunction<BigInteger, BigInteger> multiplyBy(long multiplicand) {
        return multiplyBy(Long.valueOf(multiplicand));
    }

    public final IFunction<BigInteger, BigInteger> multiplyBy(float multiplicand) {
        return multiplyBy(Float.valueOf(multiplicand));
    }

    public final IFunction<BigInteger, BigInteger> multiplyBy(double multiplicand) {
        return multiplyBy(Double.valueOf(multiplicand));
    }


    public final IFunction<BigInteger, BigInteger> pow(int power) {
        return new Pow(power);
    }	
	
	
	
	
	
	
    
    private static BigInteger fromNumber(final Number number) {
        if (number == null) {
            return null;
        }
        if (number instanceof BigDecimal) {
            return ((BigDecimal) number).toBigInteger();
        }
        if (number instanceof BigInteger) {
            return (BigInteger)number;
        }
        return (BigDecimal.valueOf(number.doubleValue())).toBigInteger();
    }
	
	
	
	
    
    
	static final class Max extends AbstractNotNullFunction<Iterable<BigInteger>,BigInteger> {

		Max() {
			super();
		}

		@Override
		protected BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			BigInteger max = input.iterator().next();
			for (BigInteger number : input) {
				if (number != null) {
					if (number.compareTo(max) > 0) {
						max = number;
					}
				}
			}	
			return max;
		}
	}
	
	static final class Min extends AbstractNotNullFunction<Iterable<BigInteger>,BigInteger> {

		Min() {
			super();
		}

		@Override
		protected BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			BigInteger min = input.iterator().next();
			for (BigInteger number : input) {
				if (number != null) {
					if (number.compareTo(min) < 0) {
						min = number;
					}
				}
			}	
			return min;
		}	
	}
	
	static final class Sum extends AbstractNotNullFunction<Iterable<BigInteger>,BigInteger> {

		Sum() {
			super();
		}

		@Override
		protected BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
			BigInteger sum = BigInteger.valueOf(0);
			for (BigInteger number : input) {
				if (number != null) {
					sum = sum.add(number);
				}
			}	
			return sum;
		}		
	}
	
	static final class Avg extends AbstractNotNullFunction<Iterable<BigInteger>,BigInteger> {

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
		protected BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
			
			int countNotNull = 0;
			BigDecimal sum = BigDecimal.valueOf(0);
			for (BigInteger number : input) {
				if (number != null) {
					sum = sum.add(new BigDecimal(number));
					countNotNull++;
				}
			}
            if (this.roundingMode != null) {
                return sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).setScale(0,this.roundingMode).toBigInteger();
            }
            if (this.mathContext != null) {
                return sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).setScale(0,this.mathContext.getRoundingMode()).toBigInteger();
            }
			return sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.FLOOR).setScale(0, RoundingMode.FLOOR).toBigInteger();
		}		
	}

	
	
	
	
	
	
	
	
    
    static final class MaxArray extends AbstractNotNullFunction<BigInteger[],BigInteger> {

        MaxArray() {
            super();
        }

        @Override
        protected BigInteger notNullExecute(final BigInteger[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            BigInteger max = input[0];
            for (BigInteger number : input) {
                if (number != null) {
                    if (number.compareTo(max) > 0) {
                        max = number;
                    }
                }
            }   
            return max;
        }
    }
    
    static final class MinArray extends AbstractNotNullFunction<BigInteger[],BigInteger> {

        MinArray() {
            super();
        }

        @Override
        protected BigInteger notNullExecute(final BigInteger[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            BigInteger min = input[0];
            for (BigInteger number : input) {
                if (number != null) {
                    if (number.compareTo(min) < 0) {
                        min = number;
                    }
                }
            }   
            return min;
        }   
    }
    
    static final class SumArray extends AbstractNotNullFunction<BigInteger[],BigInteger> {

        SumArray() {
            super();
        }

        @Override
        protected BigInteger notNullExecute(final BigInteger[] input, final ExecCtx ctx) throws Exception {
            BigInteger sum = BigInteger.valueOf(0);
            for (BigInteger number : input) {
                if (number != null) {
                    sum = sum.add(number);
                }
            }   
            return sum;
        }       
    }
    
    static final class AvgArray extends AbstractNotNullFunction<BigInteger[],BigInteger> {

        private final RoundingMode roundingMode;
        private final MathContext mathContext;
        
        AvgArray() {
            super();
            this.roundingMode = null;
            this.mathContext = null;
        }

        AvgArray(RoundingMode roundingMode) {
            super();
            Validate.notNull(roundingMode, "RoundingMode can't be null");
            this.roundingMode = roundingMode;
            this.mathContext = null;
        }
        
        AvgArray(MathContext mathContext) {
            super();
            Validate.notNull(mathContext, "MathContext can't be null");
            this.roundingMode = null;
            this.mathContext = mathContext;
        }
        
        @Override
        protected BigInteger notNullExecute(final BigInteger[] input, final ExecCtx ctx) throws Exception {
            
            int countNotNull = 0;
            BigDecimal sum = BigDecimal.valueOf(0);
            for (BigInteger number : input) {
                if (number != null) {
                    sum = sum.add(new BigDecimal(number));
                    countNotNull++;
                }
            }   
            if (this.roundingMode != null) {
                return sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).setScale(0,this.roundingMode).toBigInteger();
            }
            if (this.mathContext != null) {
                return sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).setScale(0,this.mathContext.getRoundingMode()).toBigInteger();
            }
            return sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.FLOOR).setScale(0, RoundingMode.FLOOR).toBigInteger();
        }       
    }
	
	
	
	
	
	
	
	
	
	static final class Abs extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		Abs() {
			super();
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			return input.abs();
		}
	}
	
	static final class Add extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger add;
		
		Add(BigInteger add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;
			result = result.add(this.add);
				
			return result;
		}	
	}
	
	static final class Subtract extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger subtract;
		
		Subtract(BigInteger subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;
			result = result.subtract(this.subtract);
				
			return result;
		}		
	}
	
	static final class Divide extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

        private final BigInteger divisor;
        private final RoundingMode roundingMode;
        private final MathContext mathContext;
        
        Divide(BigInteger divisor) {
            super();
            Validate.notNull(divisor, "Divisor can't be null");
            this.divisor = divisor;
            this.roundingMode = null;
            this.mathContext = null;
        }
        
        Divide(BigInteger divisor, RoundingMode roundingMode) {
            super();
            Validate.notNull(divisor, "Divisor can't be null");
            Validate.notNull(roundingMode, "RoundingMode can't be null");
            this.divisor = divisor;
            this.roundingMode = roundingMode;
            this.mathContext = null;
        }
        
        Divide(BigInteger divisor, MathContext mathContext) {
            super();
            Validate.notNull(divisor, "Divisor can't be null");
            Validate.notNull(mathContext, "MathContext can't be null");
            this.divisor = divisor;
            this.roundingMode = null;
            this.mathContext = mathContext;
        }
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
            BigDecimal bigInput = new BigDecimal(input);
            
            if (this.roundingMode != null) {
                return bigInput.divide(new BigDecimal(this.divisor), this.roundingMode).setScale(0, this.roundingMode).toBigInteger();                    
            } else if (this.mathContext != null) {
                return bigInput.divide(new BigDecimal(this.divisor), this.mathContext).setScale(0, this.mathContext.getRoundingMode()).toBigInteger();             
            } else {
                return bigInput.divide(new BigDecimal(this.divisor), RoundingMode.FLOOR).setScale(0, RoundingMode.FLOOR).toBigInteger();   
            }

		}		
	}
	
	
	static final class Module extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger module;
		
		Module(BigInteger module) {
			super();
			this.module = module;
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			return input.mod(this.module);
		}	
	}
	
	static final class Remainder extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger divisor;
		
		Remainder(BigInteger module) {
			super();
			this.divisor = module;
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			return input.remainder(this.divisor);
		}	
	}
	
	static final class Multiply extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger multiplicand;
		
		Multiply(BigInteger multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;			
			result = result.multiply(this.multiplicand);			
			return result;
		}	
	}
	
	static final class Pow extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final int power;
		
		Pow(int power) {
			super();
			this.power = power;
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;			
			result = result.pow(this.power);			
			return result;
		}		
	}
}