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
package org.op4j.operators.intf.mapofmap;

import java.util.Comparator;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableMapSelectedOperator;
import org.op4j.operators.qualities.ModifiableMapOperator;
import org.op4j.operators.qualities.NavigableMapOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
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
public interface Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I>
        extends UniqOperator<Map<K1,Map<K2,V>>,I>,
                NavigableMapOperator<K2,V,I>,
		        SortableOperator<Map.Entry<K2,V>,I>,
                ExecutableMapSelectedOperator<K2,V,I>,
                ModifiableMapOperator<K2,V,I>,
                ReplaceableOperator<Map<K2,V>,I>,
                SelectedOperator<Map<K2,V>,I> {



    public Level2MapOfMapEntriesValueOperator<K1,K2,V,I> endIf();

    
    public Level3MapOfMapEntriesValueSelectedEntriesOperator<K1,K2,V,I> forEachEntry();
    
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> sort();
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> sort(final Comparator<? super Map.Entry<K2,V>> comparator);
    
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> put(final K2 newKey, final V newValue);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> insert(final int position, final K2 newKey, final V newValue);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> putAll(final Map<K2,V> map);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> insertAll(final int position, final Map<K2,V> map);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> removeAllKeys(final K2... keys);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> removeAllTrue(final IEvaluator<Boolean, ? super Map.Entry<K2,V>> eval);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> removeAllFalse(final IEvaluator<Boolean, ? super Map.Entry<K2,V>> eval);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> removeAllKeysNot(final K2... keys);
    
    
    
    
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> convert(final IConverter<? extends Map<? extends K2,? extends V>,? super Map<K2,V>> converter);
    
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> eval(final IEvaluator<? extends Map<? extends K2,? extends V>,? super Map<K2,V>> eval);

    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> replaceWith(final Map<K2,V> replacement);


    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> exec(final IFunction<? extends Map<? extends K2,? extends V>, ? super Map<K2,V>> function);
    
    
}
