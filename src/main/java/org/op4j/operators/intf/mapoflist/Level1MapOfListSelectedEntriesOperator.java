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

import java.util.Map;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableMapOfListEntrySelectedOperator;
import org.op4j.operators.qualities.NavigableMapEntryOperator;
import org.op4j.operators.qualities.NavigatingMapOperator;
import org.op4j.operators.qualities.SelectableMapEntryOperator;
import org.op4j.operators.qualities.UniqOperator;
import org.op4j.operators.qualities.ReplaceableOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1MapOfListSelectedEntriesOperator<K,V,I>
		extends UniqOperator<Map<K,List<V>>,I>,
		        NavigableMapEntryOperator<I>,
		        NavigatingMapOperator<K,List<V>,I>,
                ExecutableMapOfListEntrySelectedOperator<K,V,I>,
                ReplaceableOperator<Map.Entry<K,List<V>>,I>,
                SelectableMapEntryOperator<K, List<V>,I> {


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Map.Entry<K,List<V>>> eval);
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Map.Entry<K,List<V>>> eval);
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V,I> ifKeyEquals(final K... keys);
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V,I> ifKeyNotEquals(final K... keys);
    
    
    public Level2MapOfListSelectedEntriesKeyOperator<K,V,I> onKey();
    public Level2MapOfListSelectedEntriesValueOperator<K,V,I> onValue();
    
    public Level0MapOfListSelectedOperator<K,V,I> endFor();
    
    public Level1MapOfListSelectedEntriesOperator<K,V,I> replaceWith(final Map.Entry<K,List<V>> replacement);

    public Level1MapOfListSelectedEntriesOperator<K,V,I> exec(final IFunction<? extends Map.Entry<? extends K,? extends List<? extends V>>, ? super Map.Entry<K,List<V>>> function);
    
    public Level1MapOfListSelectedEntriesOperator<K,V,I> eval(final IEvaluator<? extends Map.Entry<? extends K,? extends List<? extends V>>, ? super Map.Entry<K,List<V>>> eval);
    
    public Level1MapOfListSelectedEntriesOperator<K,V,I> convert(final IConverter<? extends Map.Entry<? extends K,? extends List<? extends V>>, ? super Map.Entry<K,List<V>>> converter);
                                    
}
