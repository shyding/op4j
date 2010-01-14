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

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableMapOfArrayEntrySelectedOperator;
import org.op4j.operators.qualities.NavigableMapEntryOperator;
import org.op4j.operators.qualities.SelectedMapEntryOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1MapOfArrayEntriesSelectedOperator<K,V>
		extends UniqOperator<Map<K,V[]>>,
		        NavigableMapEntryOperator,
                ExecutableMapOfArrayEntrySelectedOperator<K,V>,
                SelectedMapEntryOperator<K, V[]> {


    public Level1MapOfArrayEntriesOperator<K,V> endIf();
    
    
    public Level2MapOfArrayEntriesSelectedKeyOperator<K,V> onKey();
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> onValue();
    
    public Level1MapOfArrayEntriesSelectedOperator<K,V> exec(final IFunction<? extends Map.Entry<? extends K,? extends V[]>, ? super Map.Entry<K,V[]>> function);
    
    public Level1MapOfArrayEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Map.Entry<? extends K,? extends V[]>, ? super Map.Entry<K,V[]>> eval);
    
    public Level1MapOfArrayEntriesSelectedOperator<K,V> convert(final IConverter<? extends Map.Entry<? extends K,? extends V[]>, ? super Map.Entry<K,V[]>> converter);
                                    
}
