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
package org.op4j.operators.impl.arrayofmap;

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
import org.op4j.operators.impl.array.Level1ArrayElementsOperatorImpl;
import org.op4j.operators.impl.arrayoflist.Level1ArrayOfListElementsOperatorImpl;
import org.op4j.operators.impl.arrayofset.Level1ArrayOfSetElementsOperatorImpl;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsEntriesOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayOfMapElementsOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level1ArrayOfMapElementsOperator<K,V>  {

    
    public Level1ArrayOfMapElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ArrayOfMapOperator<K, V> endFor() {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().endIterate(Map.class));
    }


    public Level1ArrayOfSetElementsOperator<K> extractKeys() {
        return new Level1ArrayOfSetElementsOperatorImpl<K>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public Level1ArrayOfListElementsOperator<V> extractValues() {
        return new Level1ArrayOfListElementsOperatorImpl<V>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public Level2ArrayOfMapElementsEntriesOperator<K, V> forEachEntry() {
        return new Level2ArrayOfMapElementsEntriesOperatorImpl<K, V>(getTarget().iterate(Structure.MAP));
    }








    public Level1ArrayOfMapElementsOperator<K, V> put(final K newKey, final V newValue) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.Put<K, V>(newKey, newValue)));
    }


    public Level1ArrayOfMapElementsOperator<K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.Insert<K, V>(position, newKey, newValue)));
    }


    public Level1ArrayOfMapElementsOperator<K, V> putAll(final Map<K, V> map) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.PutAll<K, V>(map)));
    }


    public Level1ArrayOfMapElementsOperator<K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.InsertAll<K, V>(position, map)));
    }


    public Level1ArrayOfMapElementsOperator<K, V> removeAllKeys(final K... keys) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K, V>(keys)));
    }


    public Level1ArrayOfMapElementsOperator<K, V> removeAllTrue(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K, V>(eval)));
    }

    public Level1ArrayOfMapElementsOperator<K, V> removeAllFalse(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K, V>(eval)));
    }


    public Level1ArrayOfMapElementsOperator<K, V> removeAllKeysNot(final K... keys) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K, V>(keys)));
    }











    @SuppressWarnings("unchecked")
    public Level1ArrayOfMapElementsOperator<K, V> sort() {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1ArrayOfMapElementsOperator<K, V> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.SortEntries<K, V>(comparator)));
    }


    public Map<K, V>[] get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X,Y> Level1ArrayOfMapElementsOperator<X,Y> asMapOf(final Type<X> keyType, final Type<Y> valueType) {
        return endFor().asArrayOfMapOf(keyType, valueType).forEach();
    }


    public Level1ArrayOfMapElementsOperator<?,?> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectIndex(indexes));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V> ifNotNull() {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V> ifNull() {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X, Y> Level1ArrayOfMapElementsOperator<X, Y> convertAsMap(final IConverter<? extends Map<X, Y>, ? super Map<K, V>> converter) {
        return new Level1ArrayOfMapElementsOperatorImpl<X, Y>(getTarget().execute(converter, Normalisation.MAP));
    }


    public <X, Y> Level1ArrayOfMapElementsOperator<X, Y> evalAsMap(final IEvaluator<? extends Map<X, Y>, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsOperatorImpl<X, Y>(getTarget().execute(eval, Normalisation.MAP));
    }


    public <X, Y> Level1ArrayOfMapElementsOperator<X, Y> execAsMap(final IFunction<? extends Map<X, Y>, ? super Map<K, V>> function) {
        return new Level1ArrayOfMapElementsOperatorImpl<X, Y>(getTarget().execute(function, Normalisation.MAP));
    }


    public <X> Level1ArrayElementsOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super Map<K, V>> converter) {
        return new Level1ArrayElementsOperatorImpl<X>(resultType, getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level1ArrayElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Map<K, V>> eval) {
        return new Level1ArrayElementsOperatorImpl<X>(resultType, getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level1ArrayElementsOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K, V>> function) {
        return new Level1ArrayElementsOperatorImpl<X>(resultType, getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ArrayOfMapElementsOperator<K, V> replaceWith(final Map<K, V> replacement) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().replaceWith(replacement));
    }


    public Level1ArrayOfMapElementsOperator<K, V> replaceIfNullWith(final Map<K, V> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
    
    
    
}
