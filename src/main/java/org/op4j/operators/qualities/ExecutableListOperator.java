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

import java.util.List;

import org.op4j.functions.IFunction;




/**
 * <p>
 * This interface contains methods for executing functions on operators with
 * list target objects.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableListOperator<T> {

    
    /**
     * <p>
     * Executes the specified function on the target object, creating a new list operator
     * containing the result of the execution.
     * </p>
     * <p>
     * This function must be able to take as input a list of the current operator's
     * target type, and can return a list of a different type, 
     * which will be from then on the new operator's target type.
     * </p>
     * 
     * @param <X> the type of the result elements
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X> ExecutableListOperator<X> execAsList(final IFunction<? super List<T>,? extends List<X>> function);
    
    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsList(IFunction)} but only
     * on non-null elements, leaving null elements untouched.
     * </p>
     *
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public ExecutableListOperator<T> execIfNotNullAsList(final IFunction<? super List<T>,? extends List<? extends T>> function);


    
    /**
     * <p>
     * Executes the specified function on the target list, creating a new generic operator
     * containing the result of the execution and setting the new operator type to the one
     * specified.
     * </p>
     * 
     * @param <X> the type of the result object
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X> Operator exec(final IFunction<? super List<T>,X> function);
    


    
    /**
     * <p>
     * Executes the specified function on each of the elements, creating a new list operator
     * containing the result of all the executions and setting the new operator type to the one
     * resulting from the function execution.
     * </p>
     * <p>
     * This method is equivalent to <tt>forEach().exec(function).endFor()</tt>.
     * </p>
     * 
     * @param <X> the type of the result elements
     * @param function the function to be executed
     * @return an operator on the results of function execution on each element
     */
    public <X> ExecutableListOperator<X> map(final IFunction<? super T,X> function);


    
    /**
     * <p>
     * Executes the specified function on each of the non-null elements, creating a new list operator
     * containing the result of all the executions.
     * </p>
     * <p>
     * This method is equivalent to <tt>forEach().execIfNotNull(function).endFor()</tt>.
     * </p>
     * 
     * @param function the function to be executed
     * @return an operator on the results of function execution on each element
     */
    public ExecutableListOperator<T> mapIfNotNull(final IFunction<? super T,? extends T> function);
        
}
