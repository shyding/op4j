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
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level3ListOfMapSelectedElementsEntriesSelectedValueOperator<K,V>
        extends UniqOperator<List<Map<K,V>>>,
                NavigatingMapEntryOperator,
        		ExecutableSelectedOperator<V>,
                SelectableOperator<V> {



    public Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices);
    public Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifNull();
    public Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNull();
    public Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval);

            
    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> endOn();
    
    public Level3ListOfMapSelectedElementsEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V, ? super V> converter);
    
    public Level3ListOfMapSelectedElementsEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V, ? super V> eval);

    public Level3ListOfMapSelectedElementsEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V, ? super V> function);
        
}
