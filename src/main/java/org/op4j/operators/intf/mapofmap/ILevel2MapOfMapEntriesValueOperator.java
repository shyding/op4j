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
package org.op4j.operators.intf.mapofmap;

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
import org.op4j.operators.intf.map.ILevel2MapEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel2MapOfSetEntriesValueOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IExtractableMapOperator;
import org.op4j.operators.qualities.IModifiableMapOperator;
import org.op4j.operators.qualities.INavigableMapOperator;
import org.op4j.operators.qualities.INavigatingMapEntryOperator;
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
public interface ILevel2MapOfMapEntriesValueOperator<K1,K2,V>
		extends IUniqOperator<Map<K1,Map<K2,V>>>,
		        INavigableMapOperator<K2,V>,
		        INavigatingMapEntryOperator,
		        ISortableOperator<Map.Entry<K2,V>>,
                ITypeParameterizableXYOperator<K2,V>,
                IExecutableOperator<Map<K2,V>>,
                IConvertibleOperator<Map<K2,V>>,
                IEvaluableOperator<Map<K2,V>>,
                IModifiableMapOperator<K2,V>,
                IExtractableMapOperator<K2,V> {
    
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> forEachEntry();
    
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> endOn();
    
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> sort();
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> sort(final Comparator<? super Map.Entry<K2,V>> comparator);
    
    public <X,Y> ILevel2MapOfMapEntriesValueOperator<K1,X,Y> of(final Type<X> ofX, final Type<Y> ofY);
    
        
    public ILevel2MapOfMapEntriesValueOperator<K1,?,?> raw();
    
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> put(final K2 newKey, final V newValue);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> insert(final int position, final K2 newKey, final V newValue);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> putAll(final Map<K2,V> map);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> insertAll(final int position, final Map<K2,V> map);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> removeKeys(final K2... keys);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> removeMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> removeMatching(final IEvaluator<Boolean, ? super Map.Entry<K2,V>> eval);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> removeSelected(final ISelector<Map.Entry<K2,V>> selector);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> removeKeysNot(final K2... keys);
    
    
    public ILevel2MapOfSetEntriesValueOperator<K1,K2> extractKeys();
    public ILevel2MapOfListEntriesValueOperator<K1,V> extractValues();
    
    
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> forEachEntryWithKeys(final K2... keys);
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> forEachEntryMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> forEachEntryMatching(final IEvaluator<Boolean, ? super Map.Entry<K2,V>> eval);
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> forEachEntrySelected(final ISelector<Map.Entry<K2,V>> selector);
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> forEachEntryWithKeysNot(final K2... keys);
    

    
    
    
    public <X> ILevel2MapEntriesValueOperator<K1,X> convert(final IConverter<X,? super Map<K2,V>> converter);
    
    public <X> ILevel2MapEntriesValueOperator<K1,X> eval(final IEvaluator<X,? super Map<K2,V>> eval);

    public ILevel2MapEntriesValueOperator<K1,?> evalForObject(final String ognlExpression, final Object... optionalExpParams);
    public <X> ILevel2MapEntriesValueOperator<K1,X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K1,Byte> evalForByte(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K1,Short> evalForShort(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K1,Integer> evalForInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K1,Long> evalForLong(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K1,Float> evalForFloat(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K1,Double> evalForDouble(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K1,BigInteger> evalForBigInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K1,BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K1,Boolean> evalForBoolean(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K1,Calendar> evalForCalendar(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K1,String> evalForString(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K1,Character> evalForCharacter(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K1,Date> evalForDate(final String ognlExpression, final Object... optionalExpParams);


    public <X> ILevel2MapEntriesValueOperator<K1,X> exec(final IFunction<X, ? super Map<K2,V>> function);
    
    
}
