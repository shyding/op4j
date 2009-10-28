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

import java.util.Collection;

import org.op4j.executables.ISelect;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IModifiableOperator<T> {

    public IModifiableOperator<T> add(final T newElement);
    public IModifiableOperator<T> add(final int position, final T newElement);
    public IModifiableOperator<T> addAll(final T... newElements);
    public IModifiableOperator<T> addAll(final Collection<T> collection);
    public IModifiableOperator<T> remove(final int position);
    public IModifiableOperator<T> remove(final T value);
    public IModifiableOperator<T> removeAll(final int... positions);
    public IModifiableOperator<T> removeAll(final T... values);
    public IModifiableOperator<T> removeAll(final String expression, final Object... optionalExpParams);
    public IModifiableOperator<T> removeAll(final ISelect<T> filter);
    public IModifiableOperator<T> removeAllBut(final int... positions);
    public IModifiableOperator<T> removeAllBut(final T... values);
    public IModifiableOperator<T> removeAllBut(final String expression, final Object... optionalExpParams);
    public IModifiableOperator<T> removeAllBut(final ISelect<T> filter);
    
    
}
