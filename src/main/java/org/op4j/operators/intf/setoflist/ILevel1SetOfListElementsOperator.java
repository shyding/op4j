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
package org.op4j.operators.intf.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.IOf;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
import org.op4j.operators.qualities.IConvertibleToSetOperator;
import org.op4j.operators.qualities.IDistinguishableOperator;
import org.op4j.operators.qualities.IExtractableCollectionOperator;
import org.op4j.operators.qualities.IModifiableCollectionOperator;
import org.op4j.operators.qualities.INavigableCollectionOperator;
import org.op4j.operators.qualities.INavigatingCollectionOperator;
import org.op4j.operators.qualities.ISortableOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel1SetOfListElementsOperator<T> 
		extends IUniqOperator<Set<List<T>>>,
		        INavigableCollectionOperator<T>,
                INavigatingCollectionOperator<List<T>>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                ITypeParameterizableXOperator<T>,
                IModifiableCollectionOperator<T>,
                IExtractableCollectionOperator<T>,
                IConvertibleToArrayOperator,
                IConvertibleToSetOperator,
                IConvertibleToMapOperator<T> {

    
    public ILevel2SetOfListElementsElementsOperator<T> forEach();
    
    public ILevel0SetOfListOperator<T> endFor();

    public ILevel1SetOfListElementsOperator<T> distinct();
    
    public ILevel1SetOfListElementsOperator<T> sort();
    public ILevel1SetOfListElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel1SetOfListElementsOperator<X> of(final IOf<X> of);
    public <X> ILevel1SetOfListElementsOperator<X> of(final Class<X> ofClass);
    
    public ILevel1SetOfListElementsOperator<?> raw();
    
    public ILevel1SetOfListElementsOperator<T> add(final T newElement);
    public ILevel1SetOfListElementsOperator<T> add(final int position, final T newElement);
    public ILevel1SetOfListElementsOperator<T> addAll(final T... newElements);
    public ILevel1SetOfListElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1SetOfListElementsOperator<T> remove(final int position);
    public ILevel1SetOfListElementsOperator<T> remove(final T value);
    public ILevel1SetOfListElementsOperator<T> removeAll(final int... positions);
    public ILevel1SetOfListElementsOperator<T> removeAll(final T... values);
    public ILevel1SetOfListElementsOperator<T> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfListElementsOperator<T> removeAll(final ISelect<T> selector);
    public ILevel1SetOfListElementsOperator<T> removeAllBut(final int... positions);
    public ILevel1SetOfListElementsOperator<T> removeAllBut(final T... values);
    public ILevel1SetOfListElementsOperator<T> removeAllBut(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfListElementsOperator<T> removeAllBut(final ISelect<T> selector);
    
    public <X> ILevel1SetOfArrayElementsOperator<X> toArray(final IOf<X> of);
    public <X> ILevel1SetOfArrayElementsOperator<X> toArray(final Class<X> of);
    
    public ILevel1SetOfSetElementsOperator<T> toSet();
    
    public <K> ILevel1SetOfMapElementsOperator<K,T> toMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel1SetOfMapElementsOperator<K,V> toMap(final IMapBuild<K,V,? super T> mapBuild);

    
    public ILevel1SetOfListElementsOperator<T> extract(final int position);
    public ILevel1SetOfListElementsOperator<T> extract(final T value);
    public ILevel1SetOfListElementsOperator<T> extractAll(final int... positions);
    public ILevel1SetOfListElementsOperator<T> extractAll(final T... values);
    public ILevel1SetOfListElementsOperator<T> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfListElementsOperator<T> extractAll(final ISelect<T> selector);
    public ILevel1SetOfListElementsOperator<T> extractAllBut(final int... positions);
    public ILevel1SetOfListElementsOperator<T> extractAllBut(final T... values);
    public ILevel1SetOfListElementsOperator<T> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfListElementsOperator<T> extractAllBut(final ISelect<T> selector);
    
    
    public ILevel2SetOfListElementsElementsOperator<T> forEach(final int... positions);
    public ILevel2SetOfListElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams);
    public ILevel2SetOfListElementsElementsOperator<T> forEach(final ISelect<T> selector);
    public ILevel2SetOfListElementsElementsOperator<T> forEachNull();
    public ILevel2SetOfListElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel2SetOfListElementsElementsOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams);
    public ILevel2SetOfListElementsElementsOperator<T> forEachNot(final int... positions);
    public ILevel2SetOfListElementsElementsOperator<T> forEachNot(final String expression, final Object... optionalExpParams);
    public ILevel2SetOfListElementsElementsOperator<T> forEachNot(final ISelect<T> selector);
    public ILevel2SetOfListElementsElementsOperator<T> forEachNotNull();
    public ILevel2SetOfListElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    public ILevel2SetOfListElementsElementsOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams);
    

    
    
                                    
}