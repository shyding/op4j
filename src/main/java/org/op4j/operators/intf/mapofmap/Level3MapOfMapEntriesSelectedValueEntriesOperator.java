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

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableMapEntrySelectedOperator;
import org.op4j.operators.qualities.NavigableMapEntryOperator;
import org.op4j.operators.qualities.NavigatingMapOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableMapEntryOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V,I>
		extends UniqOperator<Map<K1,Map<K2,V>>,I>,
		        NavigableMapEntryOperator<I>,
                ExecutableMapEntrySelectedOperator<K2,V,I>,
                SelectableMapEntryOperator<K2, V,I>,
                ReplaceableOperator<Map.Entry<K2,V>,I>,
		        NavigatingMapOperator<K2,V,I> {


    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> ifIndex(final int... indices);
    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> ifTrue(final IEvaluator<Boolean, ? super Map.Entry<K2, V>> eval);
    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> ifFalse(final IEvaluator<Boolean, ? super Map.Entry<K2, V>> eval);
    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> ifIndexNot(final int... indices);
    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> ifKeyEquals(final K2... keys);
    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> ifKeyNotEquals(final K2... keys);
    
    
    public Level4MapOfMapEntriesSelectedValueEntriesKeyOperator<K1,K2,V,I> onKey();
    public Level4MapOfMapEntriesSelectedValueEntriesValueOperator<K1,K2,V,I> onValue();
    
    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> endFor();
    
    public Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V,I> replaceWith(final Map.Entry<K2,V> replacement);


    public Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V,I> exec(final IFunction<? extends Map.Entry<? extends K2,? extends V>, ? super Map.Entry<K2,V>> function);
    
    public Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V,I> eval(final IEvaluator<? extends Map.Entry<? extends K2,? extends V>,? super Map.Entry<K2,V>> eval);
    
    public Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V,I> convert(final IConverter<? extends Map.Entry<? extends K2,? extends V>,? super Map.Entry<K2,V>> converter);
                                            
}
