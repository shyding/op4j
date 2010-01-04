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
package org.op4j.operators.intf.listofmap;

import java.util.Map;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ConvertibleSelectedOperator;
import org.op4j.operators.qualities.EvaluableSelectedOperator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.NavigableMapEntryOperator;
import org.op4j.operators.qualities.NavigatingMapOperator;
import org.op4j.operators.qualities.SelectableMapEntryOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2ListOfMapSelectedElementsEntriesOperator<K,V> 
		extends UniqOperator<List<Map<K,V>>>,
		        NavigableMapEntryOperator,
                ExecutableSelectedOperator<Map.Entry<K,V>>,
                EvaluableSelectedOperator<Map.Entry<K,V>>,
                ConvertibleSelectedOperator<Map.Entry<K,V>>,
                SelectableMapEntryOperator<K, V>,
                NavigatingMapOperator<K,V> {


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifIndex(final int... indices);
    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Map.Entry<K, V>> eval);
    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K, V>> eval);
    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys);
    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys);
		    
    
    public Level3ListOfMapSelectedElementsEntriesKeyOperator<K,V> onKey();
    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V> onValue();
    
    public Level1ListOfMapSelectedElementsOperator<K,V> endFor();
    
    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> exec(final IFunction<? extends Map.Entry<K,V>, ? super Map.Entry<K,V>> function);
    
    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> eval(final IEvaluator<? extends Map.Entry<K,V>, ? super Map.Entry<K,V>> eval);
    
    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> convert(final IConverter<? extends Map.Entry<K,V>, ? super Map.Entry<K,V>> converter);
                                    
}