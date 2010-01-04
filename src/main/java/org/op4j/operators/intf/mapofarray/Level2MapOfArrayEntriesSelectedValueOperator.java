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
package org.op4j.operators.intf.mapofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;


import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ConvertibleSelectedOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.EvaluableSelectedOperator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2MapOfArrayEntriesSelectedValueOperator<K,V>
        extends UniqOperator<Map<K,V[]>>,
                NavigableCollectionOperator<V>,
	        	NavigatingMapEntryOperator,
		        DistinguishableOperator,
		        SortableOperator<V>,
                ExecutableSelectedOperator<V[]>,
                ConvertibleSelectedOperator<V[]>,
                EvaluableSelectedOperator<V[]>,
                ModifiableCollectionOperator<V>,
                SelectableOperator<V[]> {



    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices);
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNull();
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNotNull();
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V[]> eval);

    
    public Level3MapOfArrayEntriesSelectedValueElementsOperator<K,V> forEach();
    
    public Level1MapOfArrayEntriesSelectedOperator<K,V> endOn();

    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> distinct();
    
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> sort();
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> add(final V... newElements);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> insert(final int position, final V... newElements);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> addAll(final Collection<V> collection);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeIndexes(final int... indices);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeEquals(final V... values);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeIndexesNot(final int... indices);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeNulls();

    
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V[], ? super V[]> converter);
    
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V[], ? super V[]> eval);

    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V[], ? super V[]> function);
    
    
    
}