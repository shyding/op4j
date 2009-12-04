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
package org.op4j.operators.impl.listofmap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.list.Level1ListElementsOperator;
import org.op4j.operators.impl.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.impl.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel2ListOfMapElementsEntriesOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
import org.op4j.select.ISelector;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListOfMapElementsOperator<K,V> extends Operator
        implements ILevel1ListOfMapElementsOperator<K,V>  {

    
    public Level1ListOfMapElementsOperator(final Target target) {
        super(target);
    }


    public ILevel0ListOfMapOperator<K, V> endFor() {
        return new Level0ListOfMapOperator<K,V>(getTarget().endIterate(Structure.LIST, null));
    }


    public ILevel1ListOfSetElementsOperator<K> extractKeys() {
        return new Level1ListOfSetElementsOperator<K>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public ILevel1ListOfListElementsOperator<V> extractValues() {
        return new Level1ListOfListElementsOperator<V>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public ILevel2ListOfMapElementsEntriesOperator<K, V> forEachEntry() {
        return new Level2ListOfMapElementsEntriesOperator<K, V>(getTarget().iterate());
    }


    public ILevel2ListOfMapElementsEntriesOperator<K, V> forEachEntryWithKeys(final K... keys) {
        return new Level2ListOfMapElementsEntriesOperator<K, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel2ListOfMapElementsEntriesOperator<K, V> forEachEntryMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level2ListOfMapElementsEntriesOperator<K, V>(getTarget().iterate(eval));
    }


    public ILevel2ListOfMapElementsEntriesOperator<K, V> forEachEntrySelected(final ISelector<Entry<K, V>> selector) {
        return new Level2ListOfMapElementsEntriesOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel2ListOfMapElementsEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level2ListOfMapElementsEntriesOperator<K, V>(getTarget().iterateNot(keys));
    }








    public <X, Y> ILevel1ListOfMapElementsOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        return new Level1ListOfMapElementsOperator<X, Y>(getTarget());
    }


    public ILevel1ListOfMapElementsOperator<K, V> put(final K newKey, final V newValue) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.Put<K, V>(newKey, newValue)));
    }


    public ILevel1ListOfMapElementsOperator<K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.Insert<K, V>(position, newKey, newValue)));
    }


    public ILevel1ListOfMapElementsOperator<K, V> putAll(final Map<K, V> map) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.PutAll<K, V>(map)));
    }


    public ILevel1ListOfMapElementsOperator<K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.InsertAll<K, V>(position, map)));
    }


    public ILevel1ListOfMapElementsOperator<?, ?> raw() {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget());
    }


    public ILevel1ListOfMapElementsOperator<K, V> removeKeys(final K... keys) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveKeys<K, V>(keys)));
    }


    public ILevel1ListOfMapElementsOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveMatching<K, V>(eval)));
    }

    public ILevel1ListOfMapElementsOperator<K, V> removeNotMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K, V>(eval)));
    }


    public ILevel1ListOfMapElementsOperator<K, V> removeSelected(final ISelector<Entry<K, V>> selector) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveSelected<K, V>(selector)));
    }


    public ILevel1ListOfMapElementsOperator<K, V> removeKeysNot(final K... keys) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K, V>(keys)));
    }






    @SuppressWarnings("unchecked")
    public ILevel1ListOfMapElementsOperator<K, V> sort() {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public ILevel1ListOfMapElementsOperator<K, V> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.SortEntries<K, V>(comparator)));
    }


    public List<Map<K, V>> get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
    
	public <X> ILevel1ListElementsOperator<X> convert(final IConverter<X, ? super Map<K,V>> converter) {
        return new Level1ListElementsOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel1ListElementsOperator<X> eval(final IEvaluator<X, ? super Map<K,V>> eval) {
        return new Level1ListElementsOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel1ListElementsOperator<X> exec(final IFunction<X, ? super Map<K,V>> function) {
        return new Level1ListElementsOperator<X>(getTarget().execute(function));
	}
    
    
    
}
