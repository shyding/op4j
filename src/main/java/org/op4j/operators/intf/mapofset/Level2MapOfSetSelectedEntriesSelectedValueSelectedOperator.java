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
package org.op4j.operators.intf.mapofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSetSelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.SelectedOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I>
        extends UniqOperator<Map<K,Set<V>>,I>,
                NavigableCollectionOperator<V,I>,
		        SortableOperator<V,I>,
                ExecutableSetSelectedOperator<V,I>,
                ReplaceableOperator<Set<V>,I>,
                ModifiableCollectionOperator<V,I>,
                SelectedOperator<Set<V>,I> {



    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V,I> endIf();

    
    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperator<K,V,I> forEach();

    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> sort();
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> add(final V newElement);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> addAll(final V... newElements);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> insert(final int position, final V newElement);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> insertAll(final int position, final V... newElements);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> addAll(final Collection<V> collection);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> removeAllIndexes(final int... indices);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> removeAllEqual(final V... values);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> removeAllIndexesNot(final int... indices);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> removeAllNull();

    
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> convert(final IConverter<? extends Set<? extends V>, ? super Set<V>> converter);
    
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> eval(final IEvaluator<? extends Set<? extends V>, ? super Set<V>> eval);

    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> replaceWith(final Set<V> replacement);

    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V,I> exec(final IFunction<? extends Set<? extends V>, ? super Set<V>> function);
    
    
    
}
