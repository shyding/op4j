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

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableMapOfMapOperator<K1,K2,V> {

    public <X1,X2,Y> ExecutableMapOfMapOperator<X1,X2,Y> exec(final IFunction<? extends Map<X1,? extends Map<X2,Y>>, ? super Map<K1,Map<K2,V>>> function);
    
    public <X1,X2,Y> ExecutableMapOfMapOperator<X1,X2,Y> eval(final IEvaluator<? extends Map<X1,? extends Map<X2,Y>>,? super Map<K1,Map<K2,V>>> eval);
    
    public <X1,X2,Y> ExecutableMapOfMapOperator<X1,X2,Y> convert(final IConverter<? extends Map<X1,? extends Map<X2,Y>>,? super Map<K1,Map<K2,V>>> converter);
    
}
