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
import org.op4j.operators.qualities.ExecutableMapEntrySelectedOperator;
import org.op4j.operators.qualities.NavigableMapEntryOperator;
import org.op4j.operators.qualities.SelectedMapEntryOperator;
import org.op4j.operators.qualities.UniqOperator;
import org.op4j.operators.qualities.ReplaceableOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> 
		extends UniqOperator<List<Map<K,V>>,I>,
		        NavigableMapEntryOperator<I>,
                ExecutableMapEntrySelectedOperator<K,V,I>,
                ReplaceableOperator<Map.Entry<K,V>,I>,
                SelectedMapEntryOperator<K, V,I> {


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V,I> endIf();
    	    
    
    public Level3ListOfMapSelectedElementsEntriesSelectedKeyOperator<K,V,I> onKey();
    public Level3ListOfMapSelectedElementsEntriesSelectedValueOperator<K,V,I> onValue();
    
    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> replaceWith(final Map.Entry<K,V> replacement);

    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> exec(final IFunction<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> function);
    
    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> eval(final IEvaluator<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> eval);
    
    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> convert(final IConverter<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> converter);
                                    
}
