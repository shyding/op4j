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
package org.op4j.operators.intf.mapofset;

import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.CastableToTypeOperator;
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
public interface Level2MapOfSetEntriesKeyOperator<K,V,I>
        extends UniqOperator<Map<K,Set<V>>,I>,
                NavigatingMapEntryOperator<I>,
                CastableToTypeOperator<K,I>,
                ExecutableOperator<K,I>, 
                SelectableOperator<K,I> {



    public Level2MapOfSetEntriesKeySelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level2MapOfSetEntriesKeySelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super K> eval);
    public Level2MapOfSetEntriesKeySelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super K> eval);
    public Level2MapOfSetEntriesKeySelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval);
    public Level2MapOfSetEntriesKeySelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval);
    public Level2MapOfSetEntriesKeySelectedOperator<K,V,I> ifNull();
    public Level2MapOfSetEntriesKeySelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval);
    public Level2MapOfSetEntriesKeySelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level2MapOfSetEntriesKeySelectedOperator<K,V,I> ifNotNull();
    public Level2MapOfSetEntriesKeySelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval);

    
    public Level1MapOfSetEntriesOperator<K,V,I> endOn();
    
    public <X> Level2MapOfSetEntriesKeyOperator<X,V,I> asType(final Type<X> type);
    public Level2MapOfSetEntriesKeyOperator<?,V,I> asUnknown();

    public <X> Level2MapOfSetEntriesKeyOperator<X,V,I> exec(final IFunction<X, ? super K> function);
    
    public <X> Level2MapOfSetEntriesKeyOperator<X,V,I> eval(final IEvaluator<X,? super K> eval);
    
    public Level2MapOfSetEntriesKeyOperator<K,V,I> replaceWith(final K replacement);
    public Level2MapOfSetEntriesKeyOperator<K,V,I> replaceIfNullWith(final K replacement);


    public <X> Level2MapOfSetEntriesKeyOperator<X,V,I> convert(final IConverter<X,? super K> converter);
    
        
}
