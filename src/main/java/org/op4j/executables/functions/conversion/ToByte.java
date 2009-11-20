/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
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

package org.op4j.executables.functions.conversion;

import java.math.RoundingMode;
import java.util.Locale;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class ToByte {

    
    private static FromNumber FROM_NUMBER = new FromNumber();
    private static FromBoolean FROM_BOOLEAN = new FromBoolean();
    private static FromString FROM_STRING = new FromString();

    
    private ToByte() {
        super();
    }

    
    
    public static final FromNumber fromNumber() {
        return FROM_NUMBER;
    }
  
    
    
    
    public static final FromBoolean fromBoolean() {
        return FROM_BOOLEAN;
    }
    
    
    
    
    public static final FromString fromString() {
        return FROM_STRING;
    }
    
    public static final FromString fromString(final Locale locale) {
        return new FromString(locale);
    }
    
    public static final FromString frtomString(final String locale) {
        return new FromString(locale);
    }
    
    public static final FromString fromString(final Integer radix) {
        return new FromString(radix);
    }
    
    public static final FromString fromString(final DecimalPoint decimalPoint) {
        return new FromString(decimalPoint);
    }
    
    public static final FromString fromString(final RoundingMode roundingMode) {
        return new FromString(roundingMode);
    }
    
    public static final FromString fromString(final RoundingMode roundingMode, final Locale locale) {
        return new FromString(roundingMode, locale);
    }
    
    public static final FromString fromString(final RoundingMode roundingMode, final String locale) {
        return new FromString(roundingMode, locale);
    }
    
    public static final FromString fromString(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new FromString(roundingMode, decimalPoint);
    }
    
    
    
    
    public static final FromFloat fromFloat(final RoundingMode roundingMode) {
        return new FromFloat(roundingMode);
    }
    
    
    
    
    public static final FromDouble fromDouble(final RoundingMode roundingMode) {
        return new FromDouble(roundingMode);
    }
    
    
    public static final FromBigDecimal fromBigDecimal(final RoundingMode roundingMode) {
        return new FromBigDecimal(roundingMode);
    }
    
    
    
    
    
    
    static final Byte internalFromNumber(final Number number) {
        return Byte.valueOf(number.byteValue());
    }
    
    
    static final Byte internalFromString(final String string) {
        return Byte.valueOf(string);
    }
    
    
    static final Byte internalFromString(final String string, final int radix) {
        return Byte.valueOf(string, radix);
    }

    
    
    
    public static final class FromNumber extends ToNonDecimalNumber.FromNumber<Byte> {

        public FromNumber() {
            super();
        }

        public Type<? super Byte> getResultType() {
            return Types.BYTE;
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return ToByte.internalFromNumber(number);
        }

        @Override
        protected Byte fromString(final String string) {
            return ToByte.internalFromString(string);
        }
        
    }
  
    
    
    
    public static final class FromBoolean extends ToNumber.FromBoolean<Byte> {

        public FromBoolean() {
            super();
        }

        public Type<? super Byte> getResultType() {
            return Types.BYTE;
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return ToByte.internalFromNumber(number);
        }

        @Override
        protected Byte fromString(final String string) {
            return ToByte.internalFromString(string);
        }
        
    }
    
    
    
    
    public static final class FromString extends ToNonDecimalNumber.FromString<Byte> {

        public FromString() {
            super();
        }

        public FromString(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        public FromString(final Integer radix) {
            super(radix);
        }

        public FromString(final Locale locale) {
            super(locale);
        }

        public FromString(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(roundingMode, decimalPoint);
        }

        public FromString(final RoundingMode roundingMode, final Locale locale) {
            super(roundingMode, locale);
        }

        public FromString(final RoundingMode roundingMode, final String locale) {
            super(roundingMode, locale);
        }

        public FromString(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public FromString(final String locale) {
            super(locale);
        }

        public Type<? super Byte> getResultType() {
            return Types.BYTE;
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return ToByte.internalFromNumber(number);
        }

        @Override
        protected Byte fromString(final String string) {
            return ToByte.internalFromString(string);
        }

        @Override
        protected Byte fromString(final String string, final int withRadix) throws Exception {
            return ToByte.internalFromString(string, withRadix);
        }
        
    }
    
    
    
    
    public static final class FromFloat extends ToNonDecimalNumber.FromFloat<Byte> {

        public FromFloat(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public Type<? super Byte> getResultType() {
            return Types.BYTE;
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return ToByte.internalFromNumber(number);
        }

        @Override
        protected Byte fromString(final String string) {
            return ToByte.internalFromString(string);
        }
        
    }
    
    
    
    
    public static final class FromDouble extends ToNonDecimalNumber.FromDouble<Byte> {

        public FromDouble(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public Type<? super Byte> getResultType() {
            return Types.BYTE;
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return ToByte.internalFromNumber(number);
        }

        @Override
        protected Byte fromString(final String string) {
            return ToByte.internalFromString(string);
        }
        
    }
    
    
    
    
    public static final class FromBigDecimal extends ToNonDecimalNumber.FromBigDecimal<Byte> {

        public FromBigDecimal(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public Type<? super Byte> getResultType() {
            return Types.BYTE;
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return ToByte.internalFromNumber(number);
        }

        @Override
        protected Byte fromString(final String string) {
            return ToByte.internalFromString(string);
        }
        
    }
    
}