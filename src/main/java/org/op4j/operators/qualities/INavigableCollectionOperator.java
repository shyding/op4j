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

import org.op4j.executables.ISelect;






/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface INavigableCollectionOperator<T>  {

    public INavigatingCollectionOperator<T> forEach();
    
    public INavigatingCollectionOperator<T> forEach(final int... positions);
    public INavigatingCollectionOperator<T> forEach(final String expression, final Object... optionalExpParams);
    public INavigatingCollectionOperator<T> forEach(final ISelect<T> selector);
    public INavigatingCollectionOperator<T> forEachNull();
    public INavigatingCollectionOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams);
    public INavigatingCollectionOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams);
    public INavigatingCollectionOperator<T> forEachNot(final int... positions);
    public INavigatingCollectionOperator<T> forEachNot(final String expression, final Object... optionalExpParams);
    public INavigatingCollectionOperator<T> forEachNot(final ISelect<T> selector);
    public INavigatingCollectionOperator<T> forEachNotNull();
    public INavigatingCollectionOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    public INavigatingCollectionOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams);
	
}