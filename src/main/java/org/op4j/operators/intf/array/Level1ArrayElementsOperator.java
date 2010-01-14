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
package org.op4j.operators.intf.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.CastableToListOperator;
import org.op4j.operators.qualities.CastableToMapOperator;
import org.op4j.operators.qualities.CastableToSetOperator;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.NavigatingArrayOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1ArrayElementsOperator<T>
        extends UniqOperator<T[]>,
                CastableToArrayOperator,
                CastableToListOperator,
                CastableToMapOperator,
                CastableToSetOperator,
                NavigatingArrayOperator<T>,
                SelectableOperator<T>,
        		ExecutableOperator<T>,
                CastableToTypeOperator<T> {



    public Level1ArrayElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1ArrayElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayElementsSelectedOperator<T> ifNull();
    public Level1ArrayElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1ArrayElementsSelectedOperator<T> ifNotNull();
    public Level1ArrayElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval);


		    
    public Level0ArrayOperator<T> endFor();
    
    public <X> Level1ArrayElementsOperator<X> convert(final IConverter<X,? super T> converter);
    public <X> Level1ArrayElementsOperator<X> eval(final IEvaluator<X,? super T> eval);
    public <X> Level1ArrayElementsOperator<X> exec(final IFunction<X,? super T> function);
    
    
    public <X> Level1ArrayElementsOperator<X> asType(final Type<X> type);
    public Level1ArrayElementsOperator<?> asUnknown();
        
    public <X> Level1ArrayOfArrayElementsOperator<X> asArrayOf(final Type<X> type);
    public <X> Level1ArrayOfListElementsOperator<X> asListOf(final Type<X> type);
    public <K,V> Level1ArrayOfMapElementsOperator<K,V> asMapOf(final Type<K> keyType, final Type<V> valueType);
    public <X> Level1ArrayOfSetElementsOperator<X> asSetOf(final Type<X> type);
    public Level1ArrayOfArrayElementsOperator<?> asArrayOfUnknown();
    public Level1ArrayOfListElementsOperator<?> asListOfUnknown();
    public Level1ArrayOfMapElementsOperator<?,?> asMapOfUnknown();
    public Level1ArrayOfSetElementsOperator<?> asSetOfUnknown();
	
    
}
