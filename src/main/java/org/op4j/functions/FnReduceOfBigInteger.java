package org.op4j.functions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfBigInteger extends FnReduceOf<BigInteger> {

    private static final IFunction<ValuePair<Number,Number>,BigInteger> SUM = new Sum();
    private static final IFunction<ValuePair<Number,Number>,BigInteger> AVG = new Avg();
    private static final IFunction<ValuePair<Number,Number>,BigInteger> SUBT = new Subt();
    private static final IFunction<ValuePair<Number,Number>,BigInteger> MULT = new Mult();
    private static final IFunction<ValuePair<Number,Number>,BigInteger> DIV = new Div();
    private static final IFunction<ValuePair<Number,Number>,BigInteger> REMAINDER = new Remainder();

    
    public IFunction<ValuePair<Number,Number>,BigInteger> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Number,Number>,BigInteger> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Number,Number>,BigInteger> avg(final RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }
    
    public IFunction<ValuePair<Number,Number>,BigInteger> avg(final MathContext mathContext) {
        return new Avg(mathContext);
    }
    
    public IFunction<ValuePair<Number,Number>,BigInteger> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Number,Number>,BigInteger> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Number,Number>,BigInteger> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Number,Number>,BigInteger> div(final RoundingMode roundingMode) {
        return new Div(roundingMode);
    }
    
    public IFunction<ValuePair<Number,Number>,BigInteger> div(final MathContext mathContext) {
        return new Div(mathContext);
    }
    
    public IFunction<ValuePair<Number,Number>,BigInteger> remainder() {
        return REMAINDER;
    }
    
    public IFunction<ValuePair<Number,Number>,BigInteger> remainder(final MathContext mathContext) {
        return new Remainder(mathContext);
    }
    

    
    FnReduceOfBigInteger() {
        super(Types.BIG_INTEGER);
    }

    
    
    
    
    static BigInteger fromNumber(final Number number) {
        if (number instanceof BigDecimal) {
            return ((BigDecimal) number).toBigInteger();
        }
        if (number instanceof BigInteger) {
            return (BigInteger)number;
        }
        return (BigDecimal.valueOf(number.doubleValue())).toBigInteger();
    }

    
    
    
    
    static final class Sum extends FnReduceOfNumber.NonDecimalSum<BigInteger> {

        public Sum() {
            super();
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return FnReduceOfBigInteger.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOfNumber.NonDecimalSubt<BigInteger> {

        public Subt() {
            super();
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return FnReduceOfBigInteger.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOfNumber.NonDecimalMult<BigInteger> {

        public Mult() {
            super();
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return FnReduceOfBigInteger.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOfNumber.NonDecimalDiv<BigInteger> {

        public Div() {
            super();
        }

        public Div(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public Div(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return FnReduceOfBigInteger.fromNumber(number);
        }
        
    }

    
    static final class Remainder extends FnReduceOfNumber.NonDecimalRemainder<BigInteger> {

        public Remainder() {
            super();
        }

        public Remainder(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return FnReduceOfBigInteger.fromNumber(number);
        }
        
    }

    
    static final class Avg extends FnReduceOfNumber.NonDecimalAvg<BigInteger> {

        public Avg() {
            super();
        }

        public Avg(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public Avg(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return FnReduceOfBigInteger.fromNumber(number);
        }
        
    }
    
    
}