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
package org.op4j;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.operators.impl.op.array.Level0ArrayOperator;
import org.op4j.operators.impl.op.array.Level0IndefiniteArrayOperator;
import org.op4j.operators.impl.op.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.op.list.Level0ListOperator;
import org.op4j.operators.impl.op.map.Level0BuildingMapOperator;
import org.op4j.operators.impl.op.map.Level0MapOperator;
import org.op4j.operators.impl.op.set.Level0SetOperator;
import org.op4j.target.ExecutionTarget;
import org.op4j.target.Target.Normalisation;
import org.op4j.util.VarArgsUtil;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Op {
    

    
    
    
    private Op() {
        super();
    }

    
    
    
    
    
    
    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0GenericUniqOperator<T,T> on(final T target) {
        return new Level0GenericUniqOperator<T,T>(ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object, specifying the
     * target type by means of the <tt>type</tt> parameter.
     * </p>
     * 
     * @param type the type of the target object (input type for the expression)
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0GenericUniqOperator<T,T> on(final Type<T> type, final T target) {
        return new Level0GenericUniqOperator<T,T>(ExecutionTarget.forOp(target, Normalisation.NONE));
    }
    
    
    
    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0IndefiniteArrayOperator<T[],T> on(final T[] target) {
        return onArray(target);
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object, specifying the
     * target type by means of the <tt>type</tt> parameter.
     * </p>
     * 
     * @param type the type of the target object (input type for the expression)
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<T[],T> on(final Type<T[]> type, final T[] target) {
        return onArrayOf(Types.arrayComponentOf(type), target);
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Byte[],Byte> on(final byte[] target) {
        return onArrayOf(Types.BYTE, ArrayUtils.toObject(target));
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Short[],Short> on(final short[] target) {
        return onArrayOf(Types.SHORT, ArrayUtils.toObject(target));
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Integer[],Integer> on(final int[] target) {
        return onArrayOf(Types.INTEGER, ArrayUtils.toObject(target));
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Long[],Long> on(final long[] target) {
        return onArrayOf(Types.LONG, ArrayUtils.toObject(target));
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Float[],Float> on(final float[] target) {
        return onArrayOf(Types.FLOAT, ArrayUtils.toObject(target));
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Double[],Double> on(final double[] target) {
        return onArrayOf(Types.DOUBLE, ArrayUtils.toObject(target));
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Character[],Character> on(final char[] target) {
        return onArrayOf(Types.CHARACTER, ArrayUtils.toObject(target));
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Boolean[],Boolean> on(final boolean[] target) {
        return onArrayOf(Types.BOOLEAN, ArrayUtils.toObject(target));
    }
    

    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Byte[],Byte> on(final Byte[] target) {
        return onArrayOf(Types.BYTE, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Short[],Short> on(final Short[] target) {
        return onArrayOf(Types.SHORT, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Integer[],Integer> on(final Integer[] target) {
        return onArrayOf(Types.INTEGER, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Long[],Long> on(final Long[] target) {
        return onArrayOf(Types.LONG, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Float[],Float> on(final Float[] target) {
        return onArrayOf(Types.FLOAT, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Double[],Double> on(final Double[] target) {
        return onArrayOf(Types.DOUBLE, target);
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Character[],Character> on(final Character[] target) {
        return onArrayOf(Types.CHARACTER, target);
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Boolean[],Boolean> on(final Boolean[] target) {
        return onArrayOf(Types.BOOLEAN, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<String[],String> on(final String[] target) {
        return onArrayOf(Types.STRING, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<BigInteger[],BigInteger> on(final BigInteger[] target) {
        return onArrayOf(Types.BIG_INTEGER, target);
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<BigDecimal[],BigDecimal> on(final BigDecimal[] target) {
        return onArrayOf(Types.BIG_DECIMAL, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Calendar[],Calendar> on(final Calendar[] target) {
        return onArrayOf(Types.CALENDAR, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Date[],Date> on(final Date[] target) {
        return onArrayOf(Types.DATE, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<java.sql.Date[],java.sql.Date> on(final java.sql.Date[] target) {
        return onArrayOf(Types.forClass(java.sql.Date.class), target);
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Timestamp[],Timestamp> on(final Timestamp[] target) {
        return onArrayOf(Types.forClass(Timestamp.class), target);
    }
    
    
    
    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ListOperator<List<T>,T> on(final List<T> target) {
        return onList(target);
    }
    

    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object, specifying the
     * target type by means of the <tt>type</tt> parameter.
     * </p>
     * 
     * @param type the type of the target object (input type for the expression)
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ListOperator<List<T>,T> on(final Type<List<T>> type, final List<? extends T> target) {
        return onListOf(Types.listComponentOf(type),target);
    }

    
    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <K,V> Level0MapOperator<Map<K,V>,K,V> on(final Map<K,V> target) {
        return onMap(target);
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object, specifying the
     * target map key and value types by means of the <tt>keyType</tt> and <tt>valueType</tt> 
     * parameters.
     * </p>
     * 
     * @param keyType the type of the map keys
     * @param valueType the type of the map values
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <K,V> Level0MapOperator<Map<K,V>,K,V> on(final Type<K> keyType, final Type<V> valueType, final Map<K,V> target) {
        return onMapOf(keyType, valueType, target);
    }

    
    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0SetOperator<Set<T>,T> on(final Set<T> target) {
        return onSet(target);
    }
    
    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object, specifying the
     * target type by means of the <tt>type</tt> parameter.
     * </p>
     * 
     * @param type the type of the target object (input type for the expression)
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0SetOperator<Set<T>,T> on(final Type<Set<T>> type, final Set<? extends T> target) {
        return onSetOf(Types.setComponentOf(type),target);
    }
    
    
    
    
    
    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0IndefiniteArrayOperator<T[],T> onArray(final T[] target) {
        return new Level0IndefiniteArrayOperator<T[],T>(ExecutionTarget.forOp(target, Normalisation.NONE));
    }
    


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object, specifying the
     * target type by means of the <tt>type</tt> parameter.
     * </p>
     * 
     * @param type the type of the target object (input type for the expression)
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<T[],T> onArrayOf(final Type<T> type, final T[] target) {
        return new Level0ArrayOperator<T[],T>(type, ExecutionTarget.forOp(target, Normalisation.ARRAY(type.getRawClass())));
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Byte[],Byte> onArray(final byte[] target) {
        return onArrayOf(Types.BYTE, ArrayUtils.toObject(target));
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Short[],Short> onArray(final short[] target) {
        return onArrayOf(Types.SHORT, ArrayUtils.toObject(target));
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Integer[],Integer> onArray(final int[] target) {
        return onArrayOf(Types.INTEGER, ArrayUtils.toObject(target));
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Long[],Long> onArray(final long[] target) {
        return onArrayOf(Types.LONG, ArrayUtils.toObject(target));
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Float[],Float> onArray(final float[] target) {
        return onArrayOf(Types.FLOAT, ArrayUtils.toObject(target));
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Double[],Double> onArray(final double[] target) {
        return onArrayOf(Types.DOUBLE, ArrayUtils.toObject(target));
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Character[],Character> onArray(final char[] target) {
        return onArrayOf(Types.CHARACTER, ArrayUtils.toObject(target));
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Boolean[],Boolean> onArray(final boolean[] target) {
        return onArrayOf(Types.BOOLEAN, ArrayUtils.toObject(target));
    }
    

    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Byte[],Byte> onArray(final Byte[] target) {
        return onArrayOf(Types.BYTE, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Short[],Short> onArray(final Short[] target) {
        return onArrayOf(Types.SHORT, target);
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Integer[],Integer> onArray(final Integer[] target) {
        return onArrayOf(Types.INTEGER, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Long[],Long> onArray(final Long[] target) {
        return onArrayOf(Types.LONG, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Float[],Float> onArray(final Float[] target) {
        return onArrayOf(Types.FLOAT, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Double[],Double> onArray(final Double[] target) {
        return onArrayOf(Types.DOUBLE, target);
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Character[],Character> onArray(final Character[] target) {
        return onArrayOf(Types.CHARACTER, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Boolean[],Boolean> onArray(final Boolean[] target) {
        return onArrayOf(Types.BOOLEAN, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<String[],String> onArray(final String[] target) {
        return onArrayOf(Types.STRING, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<BigInteger[],BigInteger> onArray(final BigInteger[] target) {
        return onArrayOf(Types.BIG_INTEGER, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<BigDecimal[],BigDecimal> onArray(final BigDecimal[] target) {
        return onArrayOf(Types.BIG_DECIMAL, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Calendar[],Calendar> onArray(final Calendar[] target) {
        return onArrayOf(Types.CALENDAR, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Date[],Date> onArray(final Date[] target) {
        return onArrayOf(Types.DATE, target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<java.sql.Date[],java.sql.Date> onArray(final java.sql.Date[] target) {
        return onArrayOf(Types.forClass(java.sql.Date.class), target);
    }


    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Timestamp[],Timestamp> onArray(final Timestamp[] target) {
        return onArrayOf(Types.forClass(Timestamp.class), target);
    }
    

    
    /*
     * ------------------------------------------------------------------------------
     * No "onArrayFor" methods can be added here for primitives, as vararg parameters
     * cannot be used with primitives without causing "ambiguous method" problems.
     * ------------------------------------------------------------------------------
     */
    

    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0IndefiniteArrayOperator<T[],T> onArrayFor(final T... elements) {
        return new Level0IndefiniteArrayOperator<T[],T>(ExecutionTarget.forOp(VarArgsUtil.asRequiredObjectArray(elements), Normalisation.NONE));
    }

    
    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Byte[],Byte> onArrayFor(final Byte... elements) {
        return onArrayOf(Types.BYTE, VarArgsUtil.asRequiredObjectArray(elements));
    }

    
    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Short[],Short> onArrayFor(final Short... elements) {
        return onArrayOf(Types.SHORT, VarArgsUtil.asRequiredObjectArray(elements));
    }


    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Integer[],Integer> onArrayFor(final Integer... elements) {
        return onArrayOf(Types.INTEGER, VarArgsUtil.asRequiredObjectArray(elements));
    }

    
    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Long[],Long> onArrayFor(final Long... elements) {
        return onArrayOf(Types.LONG, VarArgsUtil.asRequiredObjectArray(elements));
    }


    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Float[],Float> onArrayFor(final Float... elements) {
        return onArrayOf(Types.FLOAT, VarArgsUtil.asRequiredObjectArray(elements));
    }

    
    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Double[],Double> onArrayFor(final Double... elements) {
        return onArrayOf(Types.DOUBLE, VarArgsUtil.asRequiredObjectArray(elements));
    }

    
    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Character[],Character> onArrayFor(final Character... elements) {
        return onArrayOf(Types.CHARACTER, VarArgsUtil.asRequiredObjectArray(elements));
    }


    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Boolean[],Boolean> onArrayFor(final Boolean... elements) {
        return onArrayOf(Types.BOOLEAN, VarArgsUtil.asRequiredObjectArray(elements));
    }


    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<String[],String> onArrayFor(final String... elements) {
        return onArrayOf(Types.STRING, VarArgsUtil.asRequiredObjectArray(elements));
    }


    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<BigInteger[],BigInteger> onArrayFor(final BigInteger... elements) {
        return onArrayOf(Types.BIG_INTEGER, VarArgsUtil.asRequiredObjectArray(elements));
    }


    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<BigDecimal[],BigDecimal> onArrayFor(final BigDecimal... elements) {
        return onArrayOf(Types.BIG_DECIMAL, VarArgsUtil.asRequiredObjectArray(elements));
    }


    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Calendar[],Calendar> onArrayFor(final Calendar... elements) {
        return onArrayOf(Types.CALENDAR, VarArgsUtil.asRequiredObjectArray(elements));
    }


    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Date[],Date> onArrayFor(final Date... elements) {
        return onArrayOf(Types.DATE, VarArgsUtil.asRequiredObjectArray(elements));
    }

    
    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<java.sql.Date[],java.sql.Date> onArrayFor(final java.sql.Date... elements) {
        return onArrayOf(Types.forClass(java.sql.Date.class), VarArgsUtil.asRequiredObjectArray(elements));
    }


    /**
     * <p>
     * Creates an array with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the array being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<Timestamp[],Timestamp> onArrayFor(final Timestamp... elements) {
        return onArrayOf(Types.forClass(Timestamp.class), VarArgsUtil.asRequiredObjectArray(elements));
    }

    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ListOperator<List<T>,T> onList(final List<T> target) {
        return new Level0ListOperator<List<T>,T>(ExecutionTarget.forOp(target, Normalisation.LIST));
    }
    
    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object, specifying the
     * target type by means of the <tt>type</tt> parameter.
     * </p>
     * 
     * @param type the type of the target object (input type for the expression)
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0ListOperator<List<T>,T> onListOf(final Type<T> type, final List<? extends T> target) {
        return new Level0ListOperator<List<T>,T>(ExecutionTarget.forOp(target, Normalisation.LIST));
    }

    
    /**
     * <p>
     * Creates a list with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the list being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0ListOperator<List<T>,T> onListFor(final T... elements) {
        return new Level0ListOperator<List<T>,T>(ExecutionTarget.forOp(VarArgsUtil.asRequiredObjectList(elements), Normalisation.LIST));
    }


    
    
    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <K,V> Level0MapOperator<Map<K,V>,K,V> onMap(final Map<K,V> target) {
        return new Level0MapOperator<Map<K,V>,K,V>(ExecutionTarget.forOp(target, Normalisation.MAP));
    }
    

    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object, specifying the
     * target map key and value types by means of the <tt>keyType</tt> and <tt>valueType</tt> 
     * parameters.
     * </p>
     * 
     * @param keyType the type of the map keys
     * @param valueType the type of the map values
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <K,V> Level0MapOperator<Map<K,V>,K,V> onMapOf(final Type<K> keyType, final Type<V> valueType, final Map<? extends K,? extends V> target) {
        return new Level0MapOperator<Map<K,V>,K,V>(ExecutionTarget.forOp(target, Normalisation.MAP));
    }


    /**
     * <p>
     * Creates a map containing one entry with the specified key and value, and an <i>operation
     * expression</i> on it. Also enables the addition of new entries to the map by means of the
     * <tt>and(...)</tt> action. 
     * </p>
     * 
     * @param key the key for the map's first entry
     * @param value the value for the map's first entry
     * @return an operator, ready for chaining
     */
    public static <K,V> Level0BuildingMapOperator<Map<K,V>,K,V> onMapFor(final K key, final V value) {
        final Map<K,V> newTarget = new LinkedHashMap<K, V>();
        newTarget.put(key, value);
        return new Level0BuildingMapOperator<Map<K,V>,K,V>(ExecutionTarget.forOp(newTarget, Normalisation.MAP));
    }

    
    
    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object.
     * </p>
     * 
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0SetOperator<Set<T>,T> onSet(final Set<T> target) {
        return new Level0SetOperator<Set<T>,T>(ExecutionTarget.forOp(target, Normalisation.SET));
    }

    
    /**
     * <p>
     * Creates an <i>operation expression</i> on the specified target object, specifying the
     * target type by means of the <tt>type</tt> parameter.
     * </p>
     * 
     * @param type the type of the target object (input type for the expression)
     * @param target the target object on which the expression will execute
     * @return an operator, ready for chaining
     */
    public static <T> Level0SetOperator<Set<T>,T> onSetOf(final Type<T> type, final Set<? extends T> target) {
        return new Level0SetOperator<Set<T>,T>(ExecutionTarget.forOp(target, Normalisation.SET));
    }
    
    
    /**
     * <p>
     * Creates a set with the specified elements and an <i>operation expression</i> on it.
     * </p>
     * 
     * @param elements the elements of the set being created
     * @return an operator, ready for chaining
     */
    public static <T> Level0SetOperator<Set<T>,T> onSetFor(final T... elements) {
        return new Level0SetOperator<Set<T>,T>(ExecutionTarget.forOp(VarArgsUtil.asRequiredObjectSet(elements), Normalisation.SET));
    }
    
    

}
