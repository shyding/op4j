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
public final class FnMathOfInteger {

	private final static IFunction<Iterable<Integer>, Integer> MAX_FUNC = new Max();
	
	private final static IFunction<Iterable<Integer>, Integer> MIN_FUNC = new Min();
	
	private final static IFunction<Iterable<Integer>, Integer> SUM_FUNC = new Sum();
	
	private final static IFunction<Iterable<Integer>, Integer> AVG_FUNC = new Avg();

    private final static IFunction<Integer[], Integer> MAX_ARRAY_FUNC = new MaxArray();
    
    private final static IFunction<Integer[], Integer> MIN_ARRAY_FUNC = new MinArray();
    
    private final static IFunction<Integer[], Integer> SUM_ARRAY_FUNC = new SumArray();
    
    private final static IFunction<Integer[], Integer> AVG_ARRAY_FUNC = new AvgArray();
	
	private final static IFunction<Integer, Integer> ABS_FUNC = new Abs();
	
	
	FnMathOfInteger() {
		super();           
	}

    /**
     * @return function that returns the maximum {@link Integer} of an object
     *         implementing {@link Iterable}
     */
    public final IFunction<Iterable<Integer>, Integer> max() {
        return MAX_FUNC;
    }

    /**
     * @return function that returns the minimum {@link Integer} of an object
     *         implementing {@link Iterable}
     */
    public final IFunction<Iterable<Integer>, Integer> min() {
        return MIN_FUNC;
    }

    /**
     * @return function that returns the sum of the {@link Integer} elements in
     *         an object implementing {@link Iterable}
     */
    public final IFunction<Iterable<Integer>, Integer> sum() {
        return SUM_FUNC;
    }

    /**
     * @return function that returns the average of the {@link Integer} elements
     *         in an object implementing {@link Iterable}
     */
    public final IFunction<Iterable<Integer>, Integer> avg() {
        return AVG_FUNC;
    }

    public final IFunction<Iterable<Integer>, Integer> avg(MathContext mathContext) {
        return new Avg(mathContext);
    }

    public final IFunction<Iterable<Integer>, Integer> avg(RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }

    public final IFunction<Integer[], Integer> maxArray() {
        return MAX_ARRAY_FUNC;
    }

    public final IFunction<Integer[], Integer> minArray() {
        return MIN_ARRAY_FUNC;
    }

    public final IFunction<Integer[], Integer> sumArray() {
        return SUM_ARRAY_FUNC;
    }

    public final IFunction<Integer[], Integer> avgArray() {
        return AVG_ARRAY_FUNC;
    }

    public final IFunction<Integer[], Integer> avgArray(MathContext mathContext) {
        return new AvgArray(mathContext);
    }

    public final IFunction<Integer[], Integer> avgArray(RoundingMode roundingMode) {
        return new AvgArray(roundingMode);
    }

    public final IFunction<Integer, Integer> abs() {
        return ABS_FUNC;
    }

    public final IFunction<Integer, Integer> add(Number add) {
        return new Add(fromNumber(add));
    }

    public final IFunction<Integer, Integer> add(byte add) {
        return add(Byte.valueOf(add));
    }

    public final IFunction<Integer, Integer> add(short add) {
        return add(Short.valueOf(add));
    }

    public final IFunction<Integer, Integer> add(int add) {
        return add(Integer.valueOf(add));
    }

    public final IFunction<Integer, Integer> add(long add) {
        return add(Long.valueOf(add));
    }

    public final IFunction<Integer, Integer> add(float add) {
        return add(Float.valueOf(add));
    }

    public final IFunction<Integer, Integer> add(double add) {
        return add(Double.valueOf(add));
    }


    public final IFunction<Integer, Integer> subtract(Number subtract) {
        return new Subtract(fromNumber(subtract));
    }

    public final IFunction<Integer, Integer> subtract(byte subtract) {
        return subtract(Byte.valueOf(subtract));
    }

    public final IFunction<Integer, Integer> subtract(short subtract) {
        return subtract(Short.valueOf(subtract));
    }

    public final IFunction<Integer, Integer> subtract(int subtract) {
        return subtract(Integer.valueOf(subtract));
    }

    public final IFunction<Integer, Integer> subtract(long subtract) {
        return subtract(Long.valueOf(subtract));
    }

    public final IFunction<Integer, Integer> subtract(float subtract) {
        return subtract(Float.valueOf(subtract));
    }

    public final IFunction<Integer, Integer> subtract(double subtract) {
        return subtract(Double.valueOf(subtract));
    }


    public final IFunction<Integer, Integer> divideBy(Number divisor) {
        return new Divide(fromNumber(divisor));
    }

    public final IFunction<Integer, Integer> divideBy(byte divisor) {
        return divideBy(Byte.valueOf(divisor));
    }

    public final IFunction<Integer, Integer> divideBy(short divisor) {
        return divideBy(Short.valueOf(divisor));
    }

    public final IFunction<Integer, Integer> divideBy(int divisor) {
        return divideBy(Integer.valueOf(divisor));
    }

    public final IFunction<Integer, Integer> divideBy(long divisor) {
        return divideBy(Long.valueOf(divisor));
    }

    public final IFunction<Integer, Integer> divideBy(float divisor) {
        return divideBy(Float.valueOf(divisor));
    }

    public final IFunction<Integer, Integer> divideBy(double divisor) {
        return divideBy(Double.valueOf(divisor));
    }


    public final IFunction<Integer, Integer> divideBy(Number divisor, MathContext mathContext) {
        return new Divide(fromNumber(divisor), mathContext);
    }

    public final IFunction<Integer, Integer> divideBy(byte divisor, MathContext mathContext) {
        return divideBy(Byte.valueOf(divisor), mathContext);
    }

    public final IFunction<Integer, Integer> divideBy(short divisor, MathContext mathContext) {
        return divideBy(Short.valueOf(divisor), mathContext);
    }

    public final IFunction<Integer, Integer> divideBy(int divisor, MathContext mathContext) {
        return divideBy(Integer.valueOf(divisor), mathContext);
    }

    public final IFunction<Integer, Integer> divideBy(long divisor, MathContext mathContext) {
        return divideBy(Long.valueOf(divisor), mathContext);
    }

    public final IFunction<Integer, Integer> divideBy(float divisor, MathContext mathContext) {
        return divideBy(Float.valueOf(divisor), mathContext);
    }

    public final IFunction<Integer, Integer> divideBy(double divisor, MathContext mathContext) {
        return divideBy(Double.valueOf(divisor), mathContext);
    }


    public final IFunction<Integer, Integer> divideBy(Number divisor, RoundingMode roundingMode) {
        return new Divide(fromNumber(divisor), roundingMode);
    }

    public final IFunction<Integer, Integer> divideBy(byte divisor, RoundingMode roundingMode) {
        return divideBy(Byte.valueOf(divisor), roundingMode);
    }

    public final IFunction<Integer, Integer> divideBy(short divisor, RoundingMode roundingMode) {
        return divideBy(Short.valueOf(divisor), roundingMode);
    }

    public final IFunction<Integer, Integer> divideBy(int divisor, RoundingMode roundingMode) {
        return divideBy(Integer.valueOf(divisor), roundingMode);
    }

    public final IFunction<Integer, Integer> divideBy(long divisor, RoundingMode roundingMode) {
        return divideBy(Long.valueOf(divisor), roundingMode);
    }

    public final IFunction<Integer, Integer> divideBy(float divisor, RoundingMode roundingMode) {
        return divideBy(Float.valueOf(divisor), roundingMode);
    }

    public final IFunction<Integer, Integer> divideBy(double divisor, RoundingMode roundingMode) {
        return divideBy(Double.valueOf(divisor), roundingMode);
    }


    public final IFunction<Integer, Integer> module(int module) {
        return new Module(module);
    }

    public final IFunction<Integer, Integer> multiplyBy(Number multiplicand) {
        return new Multiply(fromNumber(multiplicand));
    }

    public final IFunction<Integer, Integer> multiplyBy(byte multiplicand) {
        return multiplyBy(Byte.valueOf(multiplicand));
    }

    public final IFunction<Integer, Integer> multiplyBy(short multiplicand) {
        return multiplyBy(Short.valueOf(multiplicand));
    }

    public final IFunction<Integer, Integer> multiplyBy(int multiplicand) {
        return multiplyBy(Integer.valueOf(multiplicand));
    }

    public final IFunction<Integer, Integer> multiplyBy(long multiplicand) {
        return multiplyBy(Long.valueOf(multiplicand));
    }

    public final IFunction<Integer, Integer> multiplyBy(float multiplicand) {
        return multiplyBy(Float.valueOf(multiplicand));
    }

    public final IFunction<Integer, Integer> multiplyBy(double multiplicand) {
        return multiplyBy(Double.valueOf(multiplicand));
    }


    public final IFunction<Integer, Integer> multiplyBy(Number multiplicand, MathContext mathContext) {
        return new Multiply(fromNumber(multiplicand), mathContext);
    }

    public final IFunction<Integer, Integer> multiplyBy(byte multiplicand, MathContext mathContext) {
        return multiplyBy(Byte.valueOf(multiplicand), mathContext);
    }

    public final IFunction<Integer, Integer> multiplyBy(short multiplicand, MathContext mathContext) {
        return multiplyBy(Short.valueOf(multiplicand), mathContext);
    }

    public final IFunction<Integer, Integer> multiplyBy(int multiplicand, MathContext mathContext) {
        return multiplyBy(Integer.valueOf(multiplicand), mathContext);
    }

    public final IFunction<Integer, Integer> multiplyBy(long multiplicand, MathContext mathContext) {
        return multiplyBy(Long.valueOf(multiplicand), mathContext);
    }

    public final IFunction<Integer, Integer> multiplyBy(float multiplicand, MathContext mathContext) {
        return multiplyBy(Float.valueOf(multiplicand), mathContext);
    }

    public final IFunction<Integer, Integer> multiplyBy(double multiplicand, MathContext mathContext) {
        return multiplyBy(Double.valueOf(multiplicand), mathContext);
    }


    public final IFunction<Integer, Integer> multiplyBy(Number multiplicand, RoundingMode roundingMode) {
        return new Multiply(fromNumber(multiplicand), roundingMode);
    }

    public final IFunction<Integer, Integer> multiplyBy(byte multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Byte.valueOf(multiplicand), roundingMode);
    }

    public final IFunction<Integer, Integer> multiplyBy(short multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Short.valueOf(multiplicand), roundingMode);
    }

    public final IFunction<Integer, Integer> multiplyBy(int multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Integer.valueOf(multiplicand), roundingMode);
    }

    public final IFunction<Integer, Integer> multiplyBy(long multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Long.valueOf(multiplicand), roundingMode);
    }

    public final IFunction<Integer, Integer> multiplyBy(float multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Float.valueOf(multiplicand), roundingMode);
    }

    public final IFunction<Integer, Integer> multiplyBy(double multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Double.valueOf(multiplicand), roundingMode);
    }


    public final IFunction<Integer, Integer> pow(int power) {
        return new Pow(power);
    }

    public final IFunction<Integer, Integer> pow(int power, MathContext mathContext) {
        return new Pow(power, mathContext);
    }

    public final IFunction<Integer, Integer> pow(int power, RoundingMode roundingMode) {
        return new Pow(power, roundingMode);
    }	
	
	
	
	

    
    private static Integer fromNumber(final Number number) {
        if (number == null) {
            return null;
        }
        return Integer.valueOf(number.intValue());
    }
	
	
	
	
	
	static final class Max extends AbstractNotNullFunction<Iterable<Integer>,Integer> {

		Max() {
			super();
		}

		@Override
		protected Integer notNullExecute(final Iterable<Integer> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			Integer max = input.iterator().next();
			for (Integer number : input) {
				if (number != null) {
					if (number.compareTo(max) > 0) {
						max = number;
					}
				}
			}	
			return max;
		}		
	}
	
	static final class Min extends AbstractNotNullFunction<Iterable<Integer>,Integer> {

		Min() {
			super();
		}

		@Override
		protected Integer notNullExecute(final Iterable<Integer> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			Integer min = input.iterator().next();
			for (Integer number : input) {
				if (number != null) {
					if (number.compareTo(min) < 0) {
						min = number;
					}
				}
			}	
			return min;
		}	
	}
	
	static final class Sum extends AbstractNotNullFunction<Iterable<Integer>,Integer> {

		Sum() {
			super();
		}

		@Override
		protected Integer notNullExecute(final Iterable<Integer> input, final ExecCtx ctx) throws Exception {
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Integer number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.intValue()));
				}
			}	
			return Integer.valueOf(sum.intValue());
		}	
	}
	
	static final class Avg extends AbstractNotNullFunction<Iterable<Integer>,Integer> {

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
		protected Integer notNullExecute(final Iterable<Integer> input, final ExecCtx ctx) throws Exception {
			
			int countNotNull = 0;
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Integer number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.intValue()));
					countNotNull++;
				}
			}	
			if (this.roundingMode != null) {
				return Integer.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).intValue());
			}
			if (this.mathContext != null) {
				return Integer.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).intValue());
			}
			return Integer.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.FLOOR).intValue());
		}	
	}
	

	
	
	
	
    
    
    static final class MaxArray extends AbstractNotNullFunction<Integer[],Integer> {

        MaxArray() {
            super();
        }

        @Override
        protected Integer notNullExecute(final Integer[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            Integer max = input[0];
            for (Integer number : input) {
                if (number != null) {
                    if (number.compareTo(max) > 0) {
                        max = number;
                    }
                }
            }   
            return max;
        }       
    }
    
    static final class MinArray extends AbstractNotNullFunction<Integer[],Integer> {

        MinArray() {
            super();
        }

        @Override
        protected Integer notNullExecute(final Integer[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            Integer min = input[0];
            for (Integer number : input) {
                if (number != null) {
                    if (number.compareTo(min) < 0) {
                        min = number;
                    }
                }
            }   
            return min;
        }   
    }
    
    static final class SumArray extends AbstractNotNullFunction<Integer[],Integer> {

        SumArray() {
            super();
        }

        @Override
        protected Integer notNullExecute(final Integer[] input, final ExecCtx ctx) throws Exception {
            BigDecimal sum = BigDecimal.valueOf(0);
            for (Integer number : input) {
                if (number != null) {
                    sum = sum.add(BigDecimal.valueOf(number.intValue()));
                }
            }   
            return Integer.valueOf(sum.intValue());
        }   
    }
    
    static final class AvgArray extends AbstractNotNullFunction<Integer[],Integer> {

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
        protected Integer notNullExecute(final Integer[] input, final ExecCtx ctx) throws Exception {
            
            int countNotNull = 0;
            BigDecimal sum = BigDecimal.valueOf(0);
            for (Integer number : input) {
                if (number != null) {
                    sum = sum.add(BigDecimal.valueOf(number.intValue()));
                    countNotNull++;
                }
            }   
            if (this.roundingMode != null) {
                return Integer.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).intValue());
            }
            if (this.mathContext != null) {
                return Integer.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).intValue());
            }
            return Integer.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.FLOOR).intValue());
        }   
    }
	

	
	
	
	
	
	
	
	static final class Abs extends AbstractNullAsNullFunction<Integer, Integer> {

		Abs() {
			super();
		}
		
		@Override
		protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
			return Integer.valueOf(Math.abs(input.intValue()));
		}	
	}
	
	static final class Add extends AbstractNullAsNullFunction<Integer, Integer> {

		private final Integer add;
		
		Add(Integer add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.intValue());
			result = result.add(BigDecimal.valueOf(this.add.intValue()));
				
			return Integer.valueOf(result.intValue());
		}	
	}
	
	static final class Subtract extends AbstractNullAsNullFunction<Integer, Integer> {

		private final Integer subtract;
		
		Subtract(Integer subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.intValue());
			result = result.subtract(BigDecimal.valueOf(this.subtract.intValue()));
				
			return Integer.valueOf(result.intValue());
		}	
	}
	
	static final class Divide extends AbstractNullAsNullFunction<Integer, Integer> {

		private final Integer divisor;
		private final RoundingMode roundingMode;
		private final MathContext mathContext;
		
		Divide(Integer divisor) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = null;
		}
		
		Divide(Integer divisor, RoundingMode roundingMode) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.divisor = divisor;
			this.roundingMode = roundingMode;
			this.mathContext = null;
		}
		
		Divide(Integer divisor, MathContext mathContext) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = mathContext;
		}

		@Override
		protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.intValue());
			
			if (this.roundingMode != null) {
				result = result.divide(BigDecimal.valueOf(this.divisor.intValue()), this.roundingMode);					
			} else if (this.mathContext != null) {
				result = result.divide(BigDecimal.valueOf(this.divisor.intValue()), this.mathContext);				
			} else {
				result = result.divide(BigDecimal.valueOf(this.divisor.intValue()), RoundingMode.FLOOR);	
			}
			return Integer.valueOf(result.intValue());
		}		
	}
	
	
	static final class Module extends AbstractNullAsNullFunction<Integer, Integer> {

		private final int module;
		
		Module(int module) {
			super();
			this.module = module;
		}
		
		@Override
		protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
			return Integer.valueOf(input.intValue() % this.module);
		}	
	}
	
	static final class Multiply extends AbstractNullAsNullFunction<Integer, Integer> {

		private final Integer multiplicand;
		private final MathContext mathContext;
		private final RoundingMode roundingMode;
		
		Multiply(Integer multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = null;
		}
		
		Multiply(Integer multiplicand, RoundingMode roundingMode) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = roundingMode;
		}
		
		Multiply(Integer multiplicand, MathContext mathContext) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = mathContext;
			this.roundingMode = null;
		}

		@Override
		protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.intValue());
			
			if (this.mathContext != null) {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.intValue()), this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.intValue())).setScale(0, this.roundingMode);	
			} else {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.intValue()));	
			}
			return Integer.valueOf(result.intValue());
		}
	}
	
	static final class Pow extends AbstractNullAsNullFunction<Integer, Integer> {

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
		protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.intValue());
			
			if (this.mathContext != null) {
				result = result.pow(this.power, this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.pow(this.power).setScale(0, this.roundingMode);	
			} else {
				result = result.pow(this.power);	
			}
			return Integer.valueOf(result.intValue());
		}	
	}
}