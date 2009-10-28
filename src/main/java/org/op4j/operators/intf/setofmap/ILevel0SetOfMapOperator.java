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

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.op4j.IOf;
import org.op4j.executables.ISelect;
import org.op4j.operators.qualities.IExtractableCollectionOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableCollectionOperator;
import org.op4j.operators.qualities.INavigableCollectionOperator;
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
public interface ILevel0SetOfMapOperator<K,V> 
		extends IUniqOperator<Set<Map<K,V>>>,
		        INavigableCollectionOperator<Map<K,V>>,
		        ISortableOperator<Map<K,V>>,
                ITypeParameterizableXYOperator<K,V>,
		        IModifiableCollectionOperator<Map<K,V>>,
		        IExtractableCollectionOperator<Map<K,V>>,
		        IGenerizableOperator<Set<Map<K,V>>> {

    
    public ILevel1SetOfMapElementsOperator<K,V> forEach();
    
    public ILevel0SetOfMapOperator<K,V> sort();
    public ILevel0SetOfMapOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator);
    
    public <X,Y> ILevel0SetOfMapOperator<X,Y> of(final IOf<X> ofX, final IOf<Y> ofY);
    public <X,Y> ILevel0SetOfMapOperator<X,Y> of(final Class<X> ofXClass, final Class<Y> ofYClass);
    
    public ILevel0SetOfMapOperator<?,?> raw();
    
    public ILevel0SetOfMapOperator<K,V> add(final Map<K,V> newElement);
    public ILevel0SetOfMapOperator<K,V> add(final int position, final Map<K,V> newElement);
    public ILevel0SetOfMapOperator<K,V> addAll(final Map<K,V>... newElements);
    public ILevel0SetOfMapOperator<K,V> addAll(final Collection<Map<K,V>> collection);
    public ILevel0SetOfMapOperator<K,V> remove(final int position);
    public ILevel0SetOfMapOperator<K,V> remove(final Map<K,V> value);
    public ILevel0SetOfMapOperator<K,V> removeAll(final int... positions);
    public ILevel0SetOfMapOperator<K,V> removeAll(final Map<K,V>... values);
    public ILevel0SetOfMapOperator<K,V> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel0SetOfMapOperator<K,V> removeAll(final ISelect<Map<K,V>> selector);
    public ILevel0SetOfMapOperator<K,V> removeAllBut(final int... positions);
    public ILevel0SetOfMapOperator<K,V> removeAllBut(final Map<K,V>... values);
    public ILevel0SetOfMapOperator<K,V> removeAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0SetOfMapOperator<K,V> removeAllBut(final ISelect<Map<K,V>> selector);
    
    
    public ILevel0SetOfMapOperator<K,V> extract(final int position);
    public ILevel0SetOfMapOperator<K,V> extract(final Map<K,V> value);
    public ILevel0SetOfMapOperator<K,V> extractAll(final int... positions);
    public ILevel0SetOfMapOperator<K,V> extractAll(final Map<K,V>... values);
    public ILevel0SetOfMapOperator<K,V> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel0SetOfMapOperator<K,V> extractAll(final ISelect<Map<K,V>> selector);
    public ILevel0SetOfMapOperator<K,V> extractAllBut(final int... positions);
    public ILevel0SetOfMapOperator<K,V> extractAllBut(final Map<K,V>... values);
    public ILevel0SetOfMapOperator<K,V> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0SetOfMapOperator<K,V> extractAllBut(final ISelect<Map<K,V>> selector);

    
    public ILevel1SetOfMapElementsOperator<K,V> forEach(final int... positions);
    public ILevel1SetOfMapElementsOperator<K,V> forEach(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfMapElementsOperator<K,V> forEach(final ISelect<Map<K,V>> selector);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNull();
    public ILevel1SetOfMapElementsOperator<K,V> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNullOrNot(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNot(final int... positions);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNot(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNot(final ISelect<Map<K,V>> selector);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNotNull();
    public ILevel1SetOfMapElementsOperator<K,V> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNotNullAndNot(final String expression, final Object... optionalExpParams);
    
    
}
