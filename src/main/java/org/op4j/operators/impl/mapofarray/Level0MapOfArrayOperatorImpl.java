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
package org.op4j.operators.impl.mapofarray;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.structures.FMap;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArraySelectedOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level0MapOfArrayOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level0MapOfArrayOperator<K,V> {

    private final Type<V> type; 

    
    public Level0MapOfArrayOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level0SetOperator<K> extractKeys() {
        return new Level0SetOperatorImpl<K>(getTarget().execute(new FMap.ExtractKeys<K, V>()));
    }


    public Level0ListOperator<V[]> extractValues() {
        return new Level0ListOperatorImpl<V[]>(getTarget().execute(new FMap.ExtractValues<K, V>()));
    }


    public Level1MapOfArrayEntriesOperator<K, V> forEachEntry() {
        return new Level1MapOfArrayEntriesOperatorImpl<K, V>(this.type, getTarget().iterate(Structure.MAP));
    }







    public Level0MapOfArrayOperator<K, V> put(final K newKey, final V[] newValue) {
        return new Level0MapOfArrayOperatorImpl<K, V>(this.type, getTarget().execute(new FMap.Put<K,V[]>(newKey, NormalisationUtils.normaliseArray(newValue, this.type.getRawClass()))));
    }


    public Level0MapOfArrayOperator<K, V> insert(final int position, final K newKey, final V[] newValue) {
        return new Level0MapOfArrayOperatorImpl<K, V>(this.type, getTarget().execute(new FMap.Insert<K,V[]>(position, newKey, NormalisationUtils.normaliseArray(newValue, this.type.getRawClass()))));
    }


    public Level0MapOfArrayOperator<K, V> putAll(final Map<K, V[]> map) {
        return new Level0MapOfArrayOperatorImpl<K, V>(this.type, getTarget().execute(new FMap.PutAll<K,V[]>(NormalisationUtils.normaliseMapOfArray(map, this.type.getRawClass()))));
    }

    
    public Level0MapOfArrayOperator<K, V> insertAll(final int position, final Map<K, V[]> map) {
        return new Level0MapOfArrayOperatorImpl<K, V>(this.type, getTarget().execute(new FMap.InsertAll<K,V[]>(position, NormalisationUtils.normaliseMapOfArray(map, this.type.getRawClass()))));
    }


    public Level0MapOfArrayOperator<K, V> removeAllKeys(final K... keys) {
        return new Level0MapOfArrayOperatorImpl<K, V>(this.type, getTarget().execute(new FMap.RemoveAllKeys<K,V[]>(keys)));
    }


    public Level0MapOfArrayOperator<K, V> removeAllTrue(final IFunction<Boolean, ? super Entry<K, V[]>> eval) {
        return new Level0MapOfArrayOperatorImpl<K, V>(this.type, getTarget().execute(new FMap.RemoveAllTrue<K,V[]>(eval)));
    }

    public Level0MapOfArrayOperator<K, V> removeAllFalse(final IFunction<Boolean, ? super Entry<K, V[]>> eval) {
        return new Level0MapOfArrayOperatorImpl<K, V>(this.type, getTarget().execute(new FMap.RemoveAllFalse<K,V[]>(eval)));
    }


    public Level0MapOfArrayOperator<K, V> removeAllKeysNot(final K... keys) {
        return new Level0MapOfArrayOperatorImpl<K, V>(this.type, getTarget().execute(new FMap.RemoveAllKeysNot<K,V[]>(keys)));
    }






    @SuppressWarnings("unchecked")
    public Level0MapOfArrayOperator<K, V> sort() {
        return new Level0MapOfArrayOperatorImpl<K, V>(this.type, getTarget().execute(new FMap.SortByKey()));
    }


    public Level0MapOfArrayOperator<K, V> sort(final Comparator<? super Entry<K, V[]>> comparator) {
        return new Level0MapOfArrayOperatorImpl<K, V>(this.type, getTarget().execute(new FMap.SortEntries<K, V[]>(comparator)));
    }


    public Level0MapOfListOperator<K, V> toMapOfList() {
        return forEachEntry().onValue().toList().endOn().endFor();
    }


    public Level0MapOfSetOperator<K, V> toMapOfSet() {
        return forEachEntry().onValue().toSet().endOn().endFor();
    }


    @SuppressWarnings("unchecked")
    public Map<K, V[]> get() {
        return (Map<K,V[]>) getTarget().get();
    }


    public Level0GenericUniqOperator<Map<K, V[]>> generic() {
        return new Level0GenericUniqOperatorImpl<Map<K, V[]>>(getTarget());
    }

    
    
    
    
    
    
    
    
	public <X,Y> Level0MapOfArrayOperator<X,Y> asMapOfArrayOf(final Type<X> keyType, final Type<Y> valueType) {
        return generic().asMapOfArrayOf(keyType, valueType);
    }


    


    public Level0MapOfArraySelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(this.type, getTarget().selectIndex(indexes));
    }


    public Level0MapOfArraySelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level0MapOfArraySelectedOperator<K, V> ifTrue(final IFunction<Boolean, ? super Map<K, V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(this.type, getTarget().selectMatching(eval));
    }


    public Level0MapOfArraySelectedOperator<K, V> ifFalse(final IFunction<Boolean, ? super Map<K, V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level0MapOfArraySelectedOperator<K, V> ifNotNull() {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(this.type, getTarget().selectNotNull());
    }


    public Level0MapOfArraySelectedOperator<K, V> ifNotNullAndTrue(final IFunction<Boolean, ? super Map<K, V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level0MapOfArraySelectedOperator<K, V> ifNotNullAndFalse(final IFunction<Boolean, ? super Map<K, V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0MapOfArraySelectedOperator<K, V> ifNull() {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(this.type, getTarget().selectNull());
    }


    public Level0MapOfArraySelectedOperator<K, V> ifNullOrTrue(final IFunction<Boolean, ? super Map<K, V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level0MapOfArraySelectedOperator<K, V> ifNullOrFalse(final IFunction<Boolean, ? super Map<K, V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level0MapOfArrayOperator<K,V> execIfNotNullAsMapOfArray(final IFunction<? extends Map<? extends K, ? extends V[]>, ? super Map<K, V[]>> function) {
        return new Level0MapOfArrayOperatorImpl<K,V>(this.type, getTarget().executeIfNotNull(function, Normalisation.MAP_OF_ARRAY(this.type.getRawClass())));
    }


    public Level0MapOfArrayOperator<K,V> execAsMapOfArray(final IFunction<? extends Map<? extends K, ? extends V[]>, ? super Map<K, V[]>> function) {
        return new Level0MapOfArrayOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalisation.MAP_OF_ARRAY(this.type.getRawClass())));
    }


    


    public <X, Y> Level0MapOfArrayOperator<X, Y> execAsMapOfArrayOf(final Type<Y> valueType, final IFunction<? extends Map<X, Y[]>, ? super Map<K, V[]>> function) {
        return new Level0MapOfArrayOperatorImpl<X, Y>(valueType, getTarget().execute(function, Normalisation.MAP_OF_ARRAY(valueType.getRawClass())));
    }


    


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K, V[]>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0MapOfArrayOperator<K, V> replaceWith(final Map<K, V[]> replacement) {
        return new Level0MapOfArrayOperatorImpl<K, V>(this.type, getTarget().replaceWith(replacement, Normalisation.MAP_OF_ARRAY(this.type.getRawClass())));
    }


    public Level0MapOfArrayOperator<K, V> replaceIfNullWith(final Map<K, V[]> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    
}
