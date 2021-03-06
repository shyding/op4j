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
package org.op4j.operators.qualities;






/**
 * <p>
 * This interface contains methods for ending map entry iterations.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface NavigatingMapOperator<K,V> {

    
    /**
     * <p>
     * Ends the current iteration. After the execution of this method, all subsequent operations
     * will be applied on the iterated map as a whole instead of each entry.
     * </p>
     * 
     * @return an operator which will execute all operations on the iterated map as a whole.
     */
    public NavigableMapOperator<K,V> endFor();
    
	
}
