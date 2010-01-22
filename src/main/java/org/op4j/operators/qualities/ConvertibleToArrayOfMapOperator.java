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

import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ConvertibleToArrayOfMapOperator<T,I> {
    
    
    public Level0ArrayOfMapOperator<T,T,I> toArrayOfMap();
    public <K> Level0ArrayOfMapOperator<K,T,I> toArrayOfMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0ArrayOfMapOperator<K,V,I> toArrayOfMap(final IMapBuilder<K,V,? super T> mapBuild);

}
