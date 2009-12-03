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
package org.op4j.operators.intf.setofmap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableCollectionOperator;
import org.op4j.operators.qualities.INavigableCollectionOperator;
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
public interface ILevel0SetOfMapOperator<K,V> 
		extends IUniqOperator<Set<Map<K,V>>>,
		        INavigableCollectionOperator<Map<K,V>>,
		        ISortableOperator<Map<K,V>>,
                IExecutableOperator<Set<Map<K,V>>>,
                IConvertibleOperator<Set<Map<K,V>>>,
                IEvaluableOperator<Set<Map<K,V>>>,
                ITypeParameterizableXYOperator<K,V>,
		        IModifiableCollectionOperator<Map<K,V>>,
		        IGenerizableOperator<Set<Map<K,V>>> {

    
    public ILevel1SetOfMapElementsOperator<K,V> forEach();
    
    public ILevel0SetOfMapOperator<K,V> sort();
    public ILevel0SetOfMapOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator);
    
    public <X,Y> ILevel0SetOfMapOperator<X,Y> of(final Type<X> ofX, final Type<Y> ofY);
        
    public ILevel0SetOfMapOperator<?,?> raw();
    public ILevel0SetOfMapOperator<K,V> add(final Map<K,V>... newElements);
    public ILevel0SetOfMapOperator<K,V> insert(final int position, final Map<K,V>... newElements);
    public ILevel0SetOfMapOperator<K,V> addAll(final Collection<Map<K,V>> collection);
    public ILevel0SetOfMapOperator<K,V> removeIndexes(final int... indices);
    public ILevel0SetOfMapOperator<K,V> removeEquals(final Map<K,V>... values);
    public ILevel0SetOfMapOperator<K,V> removeMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0SetOfMapOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel0SetOfMapOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel0SetOfMapOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel0SetOfMapOperator<K,V> removeSelected(final ISelector<Map<K,V>> selector);
    public ILevel0SetOfMapOperator<K,V> removeIndexesNot(final int... indices);
    public ILevel0SetOfMapOperator<K,V> removeNulls();
    public ILevel0SetOfMapOperator<K,V> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0SetOfMapOperator<K,V> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams);
    
    
    public ILevel1SetOfMapElementsOperator<K,V> forEachIndex(final int... indices);
    public ILevel1SetOfMapElementsOperator<K,V> forEachMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetOfMapElementsOperator<K,V> forEachMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNullOrMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNotNullMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel1SetOfMapElementsOperator<K,V> forEachSelected(final ISelector<Map<K,V>> selector);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNull();
    public ILevel1SetOfMapElementsOperator<K,V> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetOfMapElementsOperator<K,V> forEachIndexNot(final int... indices);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNotNull();
    public ILevel1SetOfMapElementsOperator<K,V> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams);
    
 
    
    
    public ILevel0GenericUniqOperator<Set<Map<K,V>>> generic();
    
    
    
    
    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X,? super Set<Map<K,V>>> converter);
    
    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X,? super Set<Map<K,V>>> eval);

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


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Set<Map<K,V>>> function);
    
    
}
