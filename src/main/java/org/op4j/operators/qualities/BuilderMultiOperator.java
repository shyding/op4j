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

import org.javaruntype.type.Type;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface BuilderMultiOperator<T> {
    
    public Level0MapOperator<T,T> buildMap();
    
    public Level0MapOfListOperator<T,T> buildMapOfList();
    
    public Level0MapOfSetOperator<T,T> buildMapOfSet();
    
    public Level0MapOfArrayOperator<T,T> buildMapOfArray(final Type<T> of);
    
}