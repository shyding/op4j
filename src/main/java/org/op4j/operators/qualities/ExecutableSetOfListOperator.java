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
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;




/**
 * <p>
 * This interface contains methods for executing functions on operators with
 * set of list entry target objects.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableSetOfListOperator<T> {

    
    /**
     * <p>
     * Executes the specified function on the target object, creating a new operator
     * containing the result of the execution.
     * </p>
     * <p>
     * This function must be able to take as input an object of the current operator's
     * target type, and will return an object of a different type but same structure, 
     * which will be from then on the new operator's target type.
     * </p>
     * 
     * @param <X> the type of the result elements
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X> ExecutableSetOfListOperator<X> execAsSetOfList(final IFunction<? extends Set<? extends List<X>>, ? super Set<List<T>>> function);
    
    
    /**
     * <p>
     * Specialisation of the {@link #execAsSetOfList(IFunction)} method which executes a function
     * implementing the {@link IEvaluator} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #execAsSetOfList(IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     *
     * @param <X> the type of the result elements
     * @param eval the evaluator to be executed
     * @return an operator on the results of evaluator execution
     */
    public <X> ExecutableSetOfListOperator<X> evalAsSetOfList(final IEvaluator<? extends Set<? extends List<X>>,? super Set<List<T>>> eval);
    
    
    /**
     * <p>
     * Specialisation of the {@link #execAsSetOfList(IFunction)} method which executes a function
     * implementing the {@link IConverter} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #execAsSetOfList(IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     *
     * @param <X> the type of the result elements
     * @param converter the converter to be executed
     * @return an operator on the results of converter execution
     */
    public <X> ExecutableSetOfListOperator<X> convertAsSetOfList(final IConverter<? extends Set<? extends List<X>>,? super Set<List<T>>> converter);

    
    /**
     * <p>
     * Executes the specified function on the target object, creating a new operator
     * containing the result of the execution and setting the new operator type to the one
     * specified.
     * </p>
     * 
     * @param <X> the type of the result object
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Set<List<T>>> function);
    
    
    /**
     * <p>
     * Specialisation of the {@link #exec(IFunction)} method which executes a function
     * implementing the {@link IEvaluator} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #exec(IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     *
     * @param <X> the type of the result object
     * @param eval the evaluator to be executed
     * @return an operator on the results of evaluator execution
     */
    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X,? super Set<List<T>>> eval);
    
    
    /**
     * <p>
     * Specialisation of the {@link #exec(IFunction)} method which executes a function
     * implementing the {@link IConverter} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #exec(IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     *
     * @param <X> the type of the result object
     * @param converter the converter to be executed
     * @return an operator on the results of converter execution
     */
    public <X> Level0GenericUniqOperator<X> convert(final IConverter<X,? super Set<List<T>>> converter);    
    
}
