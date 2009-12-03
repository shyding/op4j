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
package org.op4j.operators.intf.map;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IExtractableMapOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableMapOperator;
import org.op4j.operators.qualities.INavigableMapOperator;
import org.op4j.operators.qualities.ISortableOperator;
import org.op4j.operators.qualities.ITypeParameterizableXYOperator;
import org.op4j.operators.qualities.IUniqOperator;
import org.op4j.select.ISelector;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0MapOperator<K,V>
		extends IUniqOperator<Map<K,V>>,
		        INavigableMapOperator<K,V>,
		        ISortableOperator<Map.Entry<K,V>>,
                ITypeParameterizableXYOperator<K,V>,
                IExecutableOperator<Map<K,V>>,
                IConvertibleOperator<Map<K,V>>,
                IEvaluableOperator<Map<K,V>>,
                IModifiableMapOperator<K,V>,
                IExtractableMapOperator<K,V>,
		        IGenerizableOperator<Map<K,V>> {

    
    public ILevel1MapEntriesOperator<K,V> forEachEntry();
    
    public ILevel0MapOperator<K,V> sort();
    public ILevel0MapOperator<K,V> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    
    public <X,Y> ILevel0MapOperator<X,Y> of(final Type<X> ofX, final Type<Y> ofY);
        
    public ILevel0MapOperator<?,?> raw();
    
    public ILevel0MapOperator<K,V> put(final K newKey, final V newValue);
    public ILevel0MapOperator<K,V> insert(final int position, final K newKey, final V newValue);
    public ILevel0MapOperator<K,V> putAll(final Map<K,V> map);
    public ILevel0MapOperator<K,V> insertAll(final int position, final Map<K,V> map);
    public ILevel0MapOperator<K,V> removeKeys(final K... keys);
    public ILevel0MapOperator<K,V> removeMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0MapOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public ILevel0MapOperator<K,V> removeSelected(final ISelector<Map.Entry<K,V>> selector);
    public ILevel0MapOperator<K,V> removeKeysNot(final K... keys);
    
    
    public ILevel0SetOperator<K> extractKeys();
    public ILevel0ListOperator<V> extractValues();
    
    public ILevel1MapEntriesOperator<K,V> forEachEntryWithKeys(final K... keys);
    public ILevel1MapEntriesOperator<K,V> forEachEntryMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1MapEntriesOperator<K,V> forEachEntryMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public ILevel1MapEntriesOperator<K,V> forEachEntrySelected(final ISelector<Map.Entry<K,V>> selector);
    public ILevel1MapEntriesOperator<K,V> forEachEntryWithKeysNot(final K... keys);
    
    
    
    public ILevel0GenericUniqOperator<Map<K,V>> generic();

    
    
    
    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X,? super Map<K,V>> converter);
    
    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X,? super Map<K,V>> eval);

    public ILevel0GenericUniqOperator<?> evalForObject(final String ognlExpression, final Object... optionalExpParams);
    public <X> ILevel0GenericUniqOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Byte> evalForByte(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Short> evalForShort(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Integer> evalForInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Long> evalForLong(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Float> evalForFloat(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Double> evalForDouble(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<String> evalForString(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Character> evalForCharacter(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Date> evalForDate(final String ognlExpression, final Object... optionalExpParams);


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K,V>> function);
    
    
}
