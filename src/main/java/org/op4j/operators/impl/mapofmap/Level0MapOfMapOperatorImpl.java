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
package org.op4j.operators.impl.mapofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.listofmap.Level0ListOfMapOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapEntriesOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0MapOfMapOperatorImpl<K1,K2,V> extends AbstractOperatorImpl
        implements Level0MapOfMapOperator<K1,K2,V> {

    
    public Level0MapOfMapOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOperator<K1> extractKeys() {
        return new Level0SetOperatorImpl<K1>(getTarget().execute(new MapFuncs.ExtractKeys<K1, Map<K2, V>>()));
    }


    public Level0ListOfMapOperator<K2, V> extractValues() {
        return new Level0ListOfMapOperatorImpl<K2, V>(getTarget().execute(new MapFuncs.ExtractValues<K1, Map<K2, V>>()));
    }


    public Level1MapOfMapEntriesOperator<K1, K2, V> forEachEntry() {
        return new Level1MapOfMapEntriesOperatorImpl<K1, K2, V>(getTarget().iterate());
    }






    public Level0MapOfMapOperator<K1, K2, V> put(final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.Put<K1, Map<K2,V>>(newKey, newValue)));
    }


    public Level0MapOfMapOperator<K1, K2, V> insert(final int position, final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.Insert<K1, Map<K2,V>>(position, newKey, newValue)));
    }


    public Level0MapOfMapOperator<K1, K2, V> putAll(final Map<K1, Map<K2,V>> map) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.PutAll<K1, Map<K2,V>>(map)));
    }


    public Level0MapOfMapOperator<K1, K2, V> insertAll(final int position, final Map<K1, Map<K2,V>> map) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.InsertAll<K1, Map<K2,V>>(position, map)));
    }


    public Level0MapOfMapOperator<K1, K2, V> removeKeys(final K1... keys) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveKeys<K1, Map<K2,V>>(keys)));
    }


    public Level0MapOfMapOperator<K1, K2, V> removeMatching(final IEvaluator<Boolean, ? super Entry<K1, Map<K2,V>>> eval) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveMatching<K1, Map<K2,V>>(eval)));
    }

    public Level0MapOfMapOperator<K1, K2, V> removeNotMatching(final IEvaluator<Boolean, ? super Entry<K1, Map<K2,V>>> eval) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K1, Map<K2,V>>(eval)));
    }


    public Level0MapOfMapOperator<K1, K2, V> removeKeysNot(final K1... keys) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K1, Map<K2,V>>(keys)));
    }











    @SuppressWarnings("unchecked")
    public Level0MapOfMapOperator<K1, K2, V> sort() {
        return new Level0MapOfMapOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOfMapOperator<K1, K2, V> sort(final Comparator<? super Entry<K1, Map<K2, V>>> comparator) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.SortEntries(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Map<K1, Map<K2, V>> get() {
        return (Map<K1,Map<K2,V>>) getTarget().get();
    }


    public Level0GenericUniqOperator<Map<K1, Map<K2, V>>> generic() {
        return new Level0GenericUniqOperatorImpl<Map<K1, Map<K2, V>>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> Level0GenericUniqOperator<X> convert(final IConverter<X, ? super Map<K1,Map<K2,V>>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter));
	}


    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Map<K1,Map<K2,V>>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K1,Map<K2,V>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function));
	}
    
    
    


    public <X1,X2,Y> Level0MapOfMapOperator<X1,X2,Y> asMapOfMapOf(final Type<X1> key1Type, final Type<X2> key2Type, final Type<Y> valueType) {
        return generic().asMapOfMapOf(key1Type, key2Type, valueType);
    }


    public Level0MapOfMapOperator<?,?,?> asMapOfMapOfUnknown() {
        return asMapOfMapOf(Types.OBJECT, Types.OBJECT, Types.OBJECT);
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V> ifIndex(final int... indices) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V>(getTarget().selectIndex(indices));
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V> ifIndexNot(final int... indices) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V>(getTarget().selectIndexNot(indices));
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V> ifMatching(final IEvaluator<Boolean, ? super Map<K1, Map<K2, V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V>(getTarget().selectMatching(eval));
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V> ifNotMatching(final IEvaluator<Boolean, ? super Map<K1, Map<K2, V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V>(getTarget().selectNotMatching(eval));
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V> ifNotNull() {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V>(getTarget().selectNotNull());
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V> ifNotNullMatching(final IEvaluator<Boolean, ? super Map<K1, Map<K2, V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K1, Map<K2, V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V> ifNull() {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V>(getTarget().selectNull());
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V> ifNullOrMatching(final IEvaluator<Boolean, ? super Map<K1, Map<K2, V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K1, Map<K2, V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V>(getTarget().selectNullOrNotMatching(eval));
    }

    

    
}