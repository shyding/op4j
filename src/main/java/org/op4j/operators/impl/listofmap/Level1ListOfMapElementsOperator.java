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

import org.op4j.Of;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.MapFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel2ListOfMapElementsEntriesOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
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


    public ILevel1ListOfMapElementsOperator<K, V> extract(K key) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfMapElementsOperator<K, V> extractAll(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfMapElementsOperator<K, V> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfMapElementsOperator<K, V> extractAll(
            ISelect<Entry<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfMapElementsOperator<K, V> extractAllBut(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfMapElementsOperator<K, V> extractAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfMapElementsOperator<K, V> extractAllBut(
            ISelect<Entry<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<K> extractKeys() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<V> extractValues() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfMapElementsEntriesOperator<K, V> forEachEntry() {
        return new Level2ListOfMapElementsEntriesOperator<K, V>(getTarget().iterate());
    }


    public ILevel2ListOfMapElementsEntriesOperator<K, V> forEachEntryWithKeys(final K... keys) {
        return new Level2ListOfMapElementsEntriesOperator<K, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel2ListOfMapElementsEntriesOperator<K, V> forEachEntry(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfMapElementsEntriesOperator<K, V>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel2ListOfMapElementsEntriesOperator<K, V> forEachEntry(final ISelect<Entry<K, V>> selector) {
        return new Level2ListOfMapElementsEntriesOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel2ListOfMapElementsEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level2ListOfMapElementsEntriesOperator<K, V>(getTarget().iterateNot(keys));
    }








    public <X, Y> ILevel1ListOfMapElementsOperator<X, Y> of(Of<X> ofX,
            Of<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel1ListOfMapElementsOperator<X, Y> of(Class<X> ofXClass,
            Class<Y> ofYClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfMapElementsOperator<K, V> put(final K newKey, final V newValue) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.put(newKey, newValue)));
    }


    public ILevel1ListOfMapElementsOperator<K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.insert(position, newKey, newValue)));
    }


    public ILevel1ListOfMapElementsOperator<K, V> putAll(final Map<K, V> map) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.putAll(map)));
    }

    public ILevel1ListOfMapElementsOperator<K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.insertAll(position, map)));
    }


    public ILevel1ListOfMapElementsOperator<?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfMapElementsOperator<K, V> removeKeys(final K... keys) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.removeKeys(keys)));
    }


    public ILevel1ListOfMapElementsOperator<K, V> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.removeMatching(expression, optionalExpParams)));
    }


    public ILevel1ListOfMapElementsOperator<K, V> removeSelected(final ISelect<Entry<K, V>> selector) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.removeoSelected(selector)));
    }


    public ILevel1ListOfMapElementsOperator<K, V> removeAllExceptKeys(final K... keys) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.removeAllExceptKeys(keys)));
    }








    public ILevel1ListOfMapElementsOperator<K, V> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfMapElementsOperator<K, V> sort(
            Comparator<? super Entry<K, V>> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public List<Map<K, V>> get() {
        return endFor().get();
    }

}
