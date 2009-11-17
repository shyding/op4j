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
public class ToFloat {

    
    private static FromNumber FROM_NUMBER = new FromNumber();
    private static FromBoolean FROM_BOOLEAN = new FromBoolean();
    private static FromString FROM_STRING = new FromString();

    
    
    private ToFloat() {
        super();
    }

    
    
    public static final FromNumber fromNumber() {
        return FROM_NUMBER;
    }
    
    public static final FromNumber fromNumber(final int scale, final RoundingMode roundingMode) {
        return new FromNumber(scale, roundingMode);
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
    
    public static final FromString fromString(final DecimalPoint decimalPoint) {
        return new FromString(decimalPoint);
    }
    
    public static final FromString fromString(final int scale, final RoundingMode roundingMode) {
        return new FromString(scale, roundingMode);
    }
    
    public static final FromString fromString(final int scale, final RoundingMode roundingMode, final Locale locale) {
        return new FromString(scale, roundingMode, locale);
    }
    
    public static final FromString fromString(final int scale, final RoundingMode roundingMode, final String locale) {
        return new FromString(scale, roundingMode, locale);
    }
    
    public static final FromString fromString(final int scale, final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new FromString(scale, roundingMode, decimalPoint);
    }
    
    
    
    
    
    
    static final Float internalFromNumber(final Number number) {
        return Float.valueOf(number.floatValue());
    }
    
    
    static final Float internalFromString(final String string) {
        return Float.valueOf(string);
    }

    
    
    
    public static final class FromNumber extends ToDecimalNumber.FromNumber<Float> {

        public FromNumber() {
            super();
        }

        public FromNumber(int scale, RoundingMode roundingMode) {
            super(scale, roundingMode);
        }

        public Type<? super Float> getResultType() {
            return Types.FLOAT;
        }

        @Override
        protected Float fromNumber(final Number number) {
            return ToFloat.internalFromNumber(number);
        }

        @Override
        protected Float fromString(final String string) {
            return ToFloat.internalFromString(string);
        }
        
    }
  
    
    
    
    public static final class FromBoolean extends ToNumber.FromBoolean<Float> {

        public FromBoolean() {
            super();
        }

        public Type<? super Float> getResultType() {
            return Types.FLOAT;
        }

        @Override
        protected Float fromNumber(final Number number) {
            return ToFloat.internalFromNumber(number);
        }

        @Override
        protected Float fromString(final String string) {
            return ToFloat.internalFromString(string);
        }
        
    }
    
    
    
    
    public static final class FromString extends ToDecimalNumber.FromString<Float> {

        public FromString() {
            super();
        }

        public FromString(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        public FromString(final Locale locale) {
            super(locale);
        }

        public FromString(final int scale, final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(scale, roundingMode, decimalPoint);
        }

        public FromString(final int scale, final RoundingMode roundingMode, final Locale locale) {
            super(scale, roundingMode, locale);
        }

        public FromString(final int scale, final RoundingMode roundingMode, final String locale) {
            super(scale, roundingMode, locale);
        }

        public FromString(final int scale, final RoundingMode roundingMode) {
            super(scale, roundingMode);
        }

        public FromString(final String locale) {
            super(locale);
        }

        public Type<? super Float> getResultType() {
            return Types.FLOAT;
        }

        @Override
        protected Float fromNumber(final Number number) {
            return ToFloat.internalFromNumber(number);
        }

        @Override
        protected Float fromString(final String string) {
            return ToFloat.internalFromString(string);
        }
        
    }
    
    
    
}
