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
package org.op4j.operators.qualities;

import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableMapOfSetEntryOperator<K,V,I> {

    public <X,Y> ExecutableMapOfSetEntryOperator<X,Y,I> exec(final IFunction<? extends Map.Entry<X,? extends Set<Y>>, ? super Map.Entry<K,Set<V>>> function);
    
    public <X,Y> ExecutableMapOfSetEntryOperator<X,Y,I> eval(final IEvaluator<? extends Map.Entry<X,? extends Set<Y>>,? super Map.Entry<K,Set<V>>> eval);
    
    public <X,Y> ExecutableMapOfSetEntryOperator<X,Y,I> convert(final IConverter<? extends Map.Entry<X,? extends Set<Y>>,? super Map.Entry<K,Set<V>>> converter);

    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map.Entry<K,Set<V>>> function);
    
    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map.Entry<K,Set<V>>> eval);
    
    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super Map.Entry<K,Set<V>>> converter);    
    
}
