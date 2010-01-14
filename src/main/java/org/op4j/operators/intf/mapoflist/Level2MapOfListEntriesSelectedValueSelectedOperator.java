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

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListSelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.SelectedOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2MapOfListEntriesSelectedValueSelectedOperator<K,V>
        extends UniqOperator<Map<K,List<V>>>,
                NavigableCollectionOperator<V>,
		        DistinguishableOperator,
		        SortableOperator<V>,
                ExecutableListSelectedOperator<V>,
                ModifiableCollectionOperator<V>,
                SelectedOperator<List<V>> {



    public Level2MapOfListEntriesSelectedValueOperator<K,V> endIf();

    
    public Level3MapOfListEntriesSelectedValueSelectedElementsOperator<K,V> forEach();

    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> distinct();
    
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> sort();
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> add(final V... newElements);
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> insert(final int position, final V... newElements);
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> addAll(final Collection<V> collection);
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeIndexes(final int... indices);
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeEquals(final V... values);
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeIndexesNot(final int... indices);
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeNulls();

    
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> convert(final IConverter<? extends List<? extends V>, ? super List<V>> converter);
    
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> eval(final IEvaluator<? extends List<? extends V>, ? super List<V>> eval);

    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> exec(final IFunction<? extends List<? extends V>, ? super List<V>> function);
    
    
    
}
