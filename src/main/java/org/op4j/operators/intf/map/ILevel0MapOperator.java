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

import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.ICastableToMapOfArrayOperator;
import org.op4j.operators.qualities.ICastableToMapOfListOperator;
import org.op4j.operators.qualities.ICastableToMapOfMapOperator;
import org.op4j.operators.qualities.ICastableToMapOfSetOperator;
import org.op4j.operators.qualities.ICastableToMapOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IExtractableMapOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableMapOperator;
import org.op4j.operators.qualities.INavigableMapOperator;
import org.op4j.operators.qualities.ISortableOperator;
import org.op4j.operators.qualities.IUniqOperator;
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
                ICastableToMapOperator,
                ICastableToMapOfArrayOperator,
                ICastableToMapOfListOperator,
                ICastableToMapOfMapOperator,
                ICastableToMapOfSetOperator,
		        ISortableOperator<Map.Entry<K,V>>,
                IExecutableOperator<Map<K,V>>,
                IConvertibleOperator<Map<K,V>>,
                IEvaluableOperator<Map<K,V>>,
                IModifiableMapOperator<K,V>,
                IExtractableMapOperator<K,V>,
		        IGenerizableOperator<Map<K,V>> {

    
    public ILevel1MapEntriesOperator<K,V> forEachEntry();
    
    public ILevel0MapOperator<K,V> sort();
    public ILevel0MapOperator<K,V> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    
    public ILevel0MapOperator<K,V> put(final K newKey, final V newValue);
    public ILevel0MapOperator<K,V> insert(final int position, final K newKey, final V newValue);
    public ILevel0MapOperator<K,V> putAll(final Map<K,V> map);
    public ILevel0MapOperator<K,V> insertAll(final int position, final Map<K,V> map);
    public ILevel0MapOperator<K,V> removeKeys(final K... keys);
    public ILevel0MapOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public ILevel0MapOperator<K,V> removeNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public ILevel0MapOperator<K,V> removeKeysNot(final K... keys);
    
    
    public ILevel0SetOperator<K> extractKeys();
    public ILevel0ListOperator<V> extractValues();
    
    public ILevel1MapEntriesOperator<K,V> forEachEntryWithKeys(final K... keys);
    public ILevel1MapEntriesOperator<K,V> forEachEntryMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public ILevel1MapEntriesOperator<K,V> forEachEntryWithKeysNot(final K... keys);
    
    
    
    public ILevel0GenericUniqOperator<Map<K,V>> generic();

    
    
    
    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X,? super Map<K,V>> converter);
    
    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X,? super Map<K,V>> eval);

    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K,V>> function);
    
    
    public <X,Y> ILevel0MapOfArrayOperator<X,Y> asMapOfArrayOf(final Type<X> keyType, final Type<Y> valueType);
    public ILevel0MapOfArrayOperator<?,?> asMapOfArrayOfUnknown();

    
    public <X,Y> ILevel0MapOfListOperator<X,Y> asMapOfListOf(final Type<X> keyType, final Type<Y> valueType);
    public ILevel0MapOfListOperator<?,?> asMapOfListOfUnknown();
    
    
    public <X1,X2,Y> ILevel0MapOfMapOperator<X1,X2,Y> asMapOfMapOf(final Type<X1> key1Type, final Type<X2> key2Type, final Type<Y> valueType);
    public ILevel0MapOfMapOperator<?,?,?> asMapOfMapOfUnknown();

    
    public <X,Y> ILevel0MapOfSetOperator<X,Y> asMapOfSetOf(final Type<X> keyType, final Type<Y> valueType);
    public ILevel0MapOfSetOperator<?,?> asMapOfSetOfUnknown();

    
    public <X,Y> ILevel0MapOperator<X,Y> asMapOf(final Type<X> keyType, final Type<Y> valueType);
    public ILevel0MapOperator<?,?> asMapOfUnknown();
    
    
}
