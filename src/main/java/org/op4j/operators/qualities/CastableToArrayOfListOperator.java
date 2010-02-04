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
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;


/**
 * <p>
 * This interface contains methods for casts to array of List (List<T>[]).
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface CastableToArrayOfListOperator {
    

    /**
     * <p>
     * Casts the operator's target as an array of list of the specified type.
     * </p>
     * 
     * @param <X> the type of the array of list
     * @param type the type of the array of list
     * @return the resulting casted operator
     */
    public <X> Level0ArrayOfListOperator<X> asArrayOfListOf(final Type<X> type);

    
    /**
     * <p>
     * Casts the operator's target as an array of list of unknown.
     * </p>
     * 
     * @return the resulting casted operator
     */
    public Level0ArrayOfListOperator<?> asArrayOfListOfUnknown();

    
}
