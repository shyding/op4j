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
package org.op4j.operators.impl.map;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.list.Level0ListOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.map.ILevel1MapEntriesOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.select.ISelector;
import org.op4j.target.Target;
import org.op4j.util.VarArgsUtil;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0MapOperator<K,V> extends Operator
        implements ILevel0MapOperator<K,V> {

    
    public Level0MapOperator(final Target target) {
        super(target);
    }


    public ILevel0SetOperator<K> extractKeys() {
        return new Level0SetOperator<K>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public ILevel0ListOperator<V> extractValues() {
        return new Level0ListOperator<V>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntry() {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterate());
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntryWithKeys(final K... keys) {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntryMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntryMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterate(eval));
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntrySelected(final ISelector<Entry<K, V>> selector) {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterateNot(keys));
    }








    public <X, Y> ILevel0MapOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        return new Level0MapOperator<X, Y>(getTarget());
    }


    public ILevel0MapOperator<K, V> put(final K newKey, final V newValue) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.Put<K, V>(newKey, newValue)));
    }


    public ILevel0MapOperator<K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.Insert<K, V>(position, newKey, newValue)));
    }


    public ILevel0MapOperator<K, V> putAll(final Map<K, V> map) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.PutAll<K, V>(map)));
    }


    public ILevel0MapOperator<K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.InsertAll<K, V>(position, map)));
    }


    public ILevel0MapOperator<?, ?> raw() {
        return new Level0MapOperator<K, V>(getTarget());
    }


    public ILevel0MapOperator<K, V> removeKeys(final K... keys) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.RemoveKeys<K, V>(keys)));
    }


    public ILevel0MapOperator<K, V> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.RemoveMatching<K, V>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0MapOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.RemoveMatching<K, V>(eval)));
    }


    public ILevel0MapOperator<K, V> removeSelected(final ISelector<Entry<K, V>> selector) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.RemoveSelected<K, V>(selector)));
    }


    public ILevel0MapOperator<K, V> removeKeysNot(final K... keys) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K, V>(keys)));
    }











    @SuppressWarnings("unchecked")
    public ILevel0MapOperator<K, V> sort() {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public ILevel0MapOperator<K, V> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.SortEntries<K, V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Map<K, V> get() {
        return (Map<K, V>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Map<K, V>> generic() {
        return new Level0GenericUniqOperator<Map<K, V>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> ILevel0GenericUniqOperator<X> call(final IMethodCaller<X, ? super Map<K,V>> call) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(call));
	}


    public ILevel0GenericUniqOperator<?> callForObject(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Object>(getTarget().execute(Call.forObject(methodName, optionalParameters)));
    }

    public <X> ILevel0GenericUniqOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(Call.forObjectOfType(resultType, methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }

    

	public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super Map<K,V>> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Map<K,V>> eval) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(eval));
    }


    public ILevel0GenericUniqOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel0GenericUniqOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel0GenericUniqOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel0GenericUniqOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel0GenericUniqOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }


	public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K,V>> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
	}

    
    
}
