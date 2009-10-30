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
package org.op4j.operators.intf.mapoflist;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.op4j.IOf;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.IConvertibleToMapOfArrayOperator;
import org.op4j.operators.qualities.IConvertibleToMapOfMapOperator;
import org.op4j.operators.qualities.IConvertibleToMapOfSetOperator;
import org.op4j.operators.qualities.IExtractableMapOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableMapOperator;
import org.op4j.operators.qualities.INavigableMapOperator;
import org.op4j.operators.qualities.ISortableOperator;
import org.op4j.operators.qualities.ITypeParameterizableXYOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0MapOfListOperator<K,V>
		extends IUniqOperator<Map<K,List<V>>>,
		        INavigableMapOperator<K,List<V>>,
		        ISortableOperator<Map.Entry<K,List<V>>>,
                ITypeParameterizableXYOperator<K,V>,
		        IModifiableMapOperator<K,List<V>>,
                IExtractableMapOperator<K,List<V>>,
		        IGenerizableOperator<Map<K,List<V>>>,
                IConvertibleToMapOfArrayOperator<K,V>,
                IConvertibleToMapOfSetOperator<K,V>,
                IConvertibleToMapOfMapOperator<K,V> {

    
    public ILevel1MapOfListEntriesOperator<K,V> forEachEntry();
    
    public ILevel0MapOfListOperator<K,V> sort();
    public ILevel0MapOfListOperator<K,V> sort(final Comparator<? super Map.Entry<K,List<V>>> comparator);
    
    public <X,Y> ILevel0MapOfListOperator<X,Y> of(final IOf<X> ofX, final IOf<Y> ofY);
    public <X,Y> ILevel0MapOfListOperator<X,Y> of(final Class<X> ofXClass, final Class<Y> ofYClass);
    
    public ILevel0MapOfListOperator<?,?> raw();
    
    public ILevel0MapOfListOperator<K,V> put(final K newKey, final List<V> newValue);
    public ILevel0MapOfListOperator<K,V> put(final int position, final K newKey, final List<V> newValue);
    public ILevel0MapOfListOperator<K,V> putAll(final Map<K,List<V>> map);
    public ILevel0MapOfListOperator<K,V> remove(final K key);
    public ILevel0MapOfListOperator<K,V> removeAll(final K... keys);
    public ILevel0MapOfListOperator<K,V> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel0MapOfListOperator<K,V> removeAll(final ISelect<Map.Entry<K,List<V>>> selector);
    public ILevel0MapOfListOperator<K,V> removeAllBut(final K... keys);
    public ILevel0MapOfListOperator<K,V> removeAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0MapOfListOperator<K,V> removeAllBut(final ISelect<Map.Entry<K,List<V>>> selector);
    
    public <X> ILevel0MapOfArrayOperator<K,X> toMapOfArray(final IOf<X> of);
    public <X> ILevel0MapOfArrayOperator<K,X> toMapOfArray(final Class<X> ofClass);
    
    public ILevel0MapOfSetOperator<K,V> toMapOfSet();
    
    public <K2> ILevel0MapOfMapOperator<K,K2,V> toMapOfMap(final IEval<K2,? super V> keyEval);
    public <K2,V2> ILevel0MapOfMapOperator<K,K2,V2> toMapOfMap(final IMapBuild<K2,V2,? super V> mapBuild);
    

    
    public ILevel0MapOfListOperator<K,V> extract(final K key);
    public ILevel0MapOfListOperator<K,V> extractAll(final K... keys);
    public ILevel0MapOfListOperator<K,V> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel0MapOfListOperator<K,V> extractAll(final ISelect<Map.Entry<K,List<V>>> selector);
    public ILevel0MapOfListOperator<K,V> extractAllBut(final K... keys);
    public ILevel0MapOfListOperator<K,V> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0MapOfListOperator<K,V> extractAllBut(final ISelect<Map.Entry<K,List<V>>> selector);
    
    public ILevel0SetOperator<K> extractKeys();
    public ILevel0ListOfListOperator<V> extractValues();
    
    
    public ILevel1MapOfListEntriesOperator<K,V> forEachEntryWithKeys(final K... keys);
    public ILevel1MapOfListEntriesOperator<K,V> forEachEntry(final String expression, final Object... optionalExpParams);
    public ILevel1MapOfListEntriesOperator<K,V> forEachEntry(final ISelect<Map.Entry<K,List<V>>> selector);
    public ILevel1MapOfListEntriesOperator<K,V> forEachEntryWithKeysNot(final K... keys);
    public ILevel1MapOfListEntriesOperator<K,V> forEachEntryNot(final String expression, final Object... optionalExpParams);
    public ILevel1MapOfListEntriesOperator<K,V> forEachEntryNot(final ISelect<Map.Entry<K,List<V>>> selector);
    

    
    
}