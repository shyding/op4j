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

import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level3MapOfListEntriesValueElementsOperator<K,V>
        extends UniqOperator<Map<K,List<V>>>,
                NavigatingCollectionOperator<V>,
        		ExecutableOperator<V>,
                SelectableOperator<V>,
                ReplaceableOperator<V>,
                ReplaceableIfNullOperator<V>,
                CastableToTypeOperator<V> {



    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V> ifIndex(final int... indices);
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V> ifNull();
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V> ifNotNull();
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);

    
    public Level2MapOfListEntriesValueOperator<K,V> endFor();
    
    public Level3MapOfListEntriesValueElementsOperator<K,V> replaceWith(final V replacement);
    public Level3MapOfListEntriesValueElementsOperator<K,V> replaceIfNullWith(final V replacement);


    public <X> Level3MapOfListEntriesValueElementsOperator<K,X> convert(final IConverter<X,? super V> converter);
    
    public <X> Level3MapOfListEntriesValueElementsOperator<K,X> eval(final IEvaluator<X,? super V> eval);

    public <X> Level3MapOfListEntriesValueElementsOperator<K,X> exec(final IFunction<X, ? super V> function);
    
    public <X> Level3MapOfListEntriesValueElementsOperator<K,X> asType(final Type<X> type);
    public Level3MapOfListEntriesValueElementsOperator<K,?> asUnknown();
    
        
    }
