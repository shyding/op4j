/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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
package org.op4j.operators.intf.map;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableElementsOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel2MapEntriesValueOperator<I,K,V>
        extends UniqOperator<Map<K,V>>,
				NavigatingMapEntryOperator,
        		ExecutableOperator<V>,
                SelectableElementsOperator<V>,
                ReplaceableOperator<V>,
                ReplaceableIfNullOperator<V>,
                CastableToTypeOperator<V> {



    public ILevel2MapEntriesValueSelectedOperator<I,K,V> ifIndex(final int... indexes);
    public ILevel2MapEntriesValueSelectedOperator<I,K,V> ifTrue(final IFunction<? super V,Boolean> eval);
    public ILevel2MapEntriesValueSelectedOperator<I,K,V> ifFalse(final IFunction<? super V,Boolean> eval);
    public ILevel2MapEntriesValueSelectedOperator<I,K,V> ifNullOrFalse(final IFunction<? super V,Boolean> eval);
    public ILevel2MapEntriesValueSelectedOperator<I,K,V> ifNotNullAndFalse(final IFunction<? super V,Boolean> eval);
    public ILevel2MapEntriesValueSelectedOperator<I,K,V> ifNull();
    public ILevel2MapEntriesValueSelectedOperator<I,K,V> ifNullOrTrue(final IFunction<? super V,Boolean> eval);
    public ILevel2MapEntriesValueSelectedOperator<I,K,V> ifIndexNot(final int... indexes);
    public ILevel2MapEntriesValueSelectedOperator<I,K,V> ifNotNull();
    public ILevel2MapEntriesValueSelectedOperator<I,K,V> ifNotNullAndTrue(final IFunction<? super V,Boolean> eval);

    
    public ILevel1MapEntriesOperator<I,K,V> endOn();
    
    public ILevel2MapEntriesValueOperator<I,K,V> replaceWith(final V replacement);
    public ILevel2MapEntriesValueOperator<I,K,V> replaceIfNullWith(final V replacement);


    public <X> ILevel2MapEntriesValueOperator<I,K,X> execIfNotNull(final IFunction<? super V,X> function);

    public <X> ILevel2MapEntriesValueOperator<I,K,X> exec(final IFunction<? super V,X> function);
    
    public <X> ILevel2MapEntriesValueOperator<I,K,X> castTo(final Type<X> type);
    
    
        
}
