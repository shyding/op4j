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
package org.op4j.executables.functions.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.javaruntype.type.Type;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.Function;
import org.op4j.executables.functions.FunctionArguments;
import org.op4j.executables.functions.Functions;
import org.op4j.executables.functions.IFunc;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class ListFunc<X,T> implements IFunc<X,List<T>>  {
    
    private final Function<X,List<T>> function;
    private final List<? extends Object> parameters;

    
    
	@SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> distinct() {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListDistinctFunction.NAME), ListUtils.EMPTY_LIST); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> add(final T newElement) {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListModifyFunction.NAME), Arrays.asList(new Object[] {Collections.singletonList(newElement), "ADD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> add(final int position, final T newElement) {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListModifyFunction.NAME), Arrays.asList(new Object[] {Collections.singletonList(newElement), Integer.valueOf(position), "ADD"})); 
    }
    
    @SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> addAllValues(final T... newElements) {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(newElements), "ADD"})); 
    }
    
    @SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> addAllValues(final int position, final T... newElements) {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(newElements), Integer.valueOf(position), "ADD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> addAll(final Collection<T> collection) {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListModifyFunction.NAME), Arrays.asList(new Object[] {new ArrayList<Object>(collection), "ADD"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> remove(final int position) {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListModifyFunction.NAME), Arrays.asList(new Object[] {new Integer[] {Integer.valueOf(position)}, "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> removeValue(final T value) {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListModifyFunction.NAME), Arrays.asList(new Object[] {Collections.singletonList(value), "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> removeAll(final int... positions) {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredIntegerArray(positions), "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> removeAllValues(final T... values) {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(values), "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> removeAll(final String expression, final Object... optionalExpParams) {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListModifyFunction.NAME), Arrays.asList(new Object[] {expression, VarArgsUtil.asOptionalObjectList(optionalExpParams), "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> removeAll(final ISelect<T> selector) {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListModifyFunction.NAME), Arrays.asList(new Object[] {selector, "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> removeAllNot(final int... positions) {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredIntegerArray(positions), "REMOVE_NOT"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> removeAllValuesNot(final T... values) {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(values), "REMOVE_NOT"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> removeAllNot(final String expression, final Object... optionalExpParams) {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListModifyFunction.NAME), Arrays.asList(new Object[] {expression, VarArgsUtil.asOptionalObjectList(optionalExpParams), "REMOVE_NOT"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ListFunc<List<T>,T> removeAllNot(final ISelect<T> selector) {
        return new ListFunc<List<T>,T>((Function<List<T>, List<T>>) Functions.getFunctionByName(ListModifyFunction.NAME), Arrays.asList(new Object[] {selector, "REMOVE_NOT"})); 
    }


    public ILevel0ListOperator<T> removeAllNulls() {
    }
    
    
    public ILevel0ListOperator<T> removeAllNotNullsAnd(String expression, Object... optionalExpParams) {
    }

    
    public ILevel0ListOperator<T> removeAllNotNullsAndNot(String expression, Object... optionalExpParams) {
    }

    
    public ILevel0ListOperator<T> removeAllNullsOr(String expression, Object... optionalExpParams) {
    }

    
    public ILevel0ListOperator<T> removeAllNullsOrNot(String expression, Object... optionalExpParams) {
        
    }
    
    
    
    
    
    
    private ListFunc(final Function<X,List<T>> function, final List<? extends Object> parameters) {
        super();
        this.function = function;
        this.parameters = parameters;
    }



    public Type<X> getResultType() {
        return this.function.getResultType();
    }



    public X execute(final List<T> object) {
        return this.function.executeFunction(FunctionArguments.fromObjects(object, this.parameters));
    }

     
        
}
