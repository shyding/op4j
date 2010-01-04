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
package org.op4j.operators.intf.setofmap;

import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ConvertibleOperator;
import org.op4j.operators.qualities.EvaluableOperator;
import org.op4j.operators.qualities.ExecutableOperator;
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
public interface Level3SetOfMapElementsEntriesKeyOperator<K,V>
        extends UniqOperator<Set<Map<K,V>>>,
                NavigatingMapEntryOperator,
                CastableToTypeOperator<K>,
                ExecutableOperator<K>, 
                EvaluableOperator<K>, 
                SelectableOperator<K>,
                ConvertibleOperator<K> {



    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> ifIndex(final int... indices);
    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval);
    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval);
    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval);
    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval);
    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> ifNull();
    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval);
    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> ifNotNull();
    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval);

    
    public Level2SetOfMapElementsEntriesOperator<K,V> endOn();
    
    public <X> Level3SetOfMapElementsEntriesKeyOperator<X,V> asType(final Type<X> type);
    public Level3SetOfMapElementsEntriesKeyOperator<?,V> asUnknown();

    public <X> Level3SetOfMapElementsEntriesKeyOperator<X,V> exec(final IFunction<X, ? super K> function);
    
    public <X> Level3SetOfMapElementsEntriesKeyOperator<X,V> eval(final IEvaluator<X,? super K> eval);
    
    public <X> Level3SetOfMapElementsEntriesKeyOperator<X,V> convert(final IConverter<X,? super K> converter);
    
        
}