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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArraySelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableArrayOperator;
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
public interface Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V>
        extends UniqOperator<Map<K,V[]>>,
                NavigableArrayOperator<V>,
		        DistinguishableOperator,
		        SortableOperator<V>,
                ExecutableArraySelectedOperator<V>,
                ModifiableCollectionOperator<V>,
                SelectedOperator<V[]> {



    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> endIf();

    
    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperator<K,V> forEach(final Type<V> elementType);

    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> distinct();
    
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> sort();
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> add(final V... newElements);
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> insert(final int position, final V... newElements);
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> addAll(final Collection<V> collection);
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeIndexes(final int... indices);
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeEquals(final V... values);
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeIndexesNot(final int... indices);
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeNulls();

    
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> convert(final IConverter<? extends V[], ? super V[]> converter);
    
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> eval(final IEvaluator<? extends V[], ? super V[]> eval);

    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> exec(final IFunction<? extends V[], ? super V[]> function);
    
    
    
}
