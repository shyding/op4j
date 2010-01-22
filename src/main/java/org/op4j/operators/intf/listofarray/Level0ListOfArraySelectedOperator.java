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
package org.op4j.operators.intf.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListOfArraySelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.SelectedOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level0ListOfArraySelectedOperator<T,I>
        extends UniqOperator<List<T[]>,I>,
                NavigableCollectionOperator<T[],I>,
                DistinguishableOperator<I>,
                SortableOperator<T[],I>,
                ModifiableCollectionOperator<T[],I>,
                ExecutableListOfArraySelectedOperator<T,I>,
                ReplaceableOperator<List<T[]>,I>,
                SelectedOperator<List<T[]>,I> {



    public Level0ListOfArrayOperator<T,I> endIf();



    public Level1ListOfArraySelectedElementsOperator<T,I> forEach();

    public Level0ListOfArraySelectedOperator<T,I> distinct();
    
    public Level0ListOfArraySelectedOperator<T,I> sort();
    public Level0ListOfArraySelectedOperator<T,I> sort(final Comparator<? super T[]> comparator);


    public Level0ListOfArraySelectedOperator<T,I> add(final T[] newElement);
    public Level0ListOfArraySelectedOperator<T,I> addAll(final T[]... newElements);
    public Level0ListOfArraySelectedOperator<T,I> insert(final int position, final T[] newElement);
    public Level0ListOfArraySelectedOperator<T,I> insertAll(final int position, final T[]... newElements);
    public Level0ListOfArraySelectedOperator<T,I> addAll(final Collection<T[]> collection);
    public Level0ListOfArraySelectedOperator<T,I> removeAllIndexes(final int... indices);
    public Level0ListOfArraySelectedOperator<T,I> removeAllEqual(final T[]... values);
    public Level0ListOfArraySelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level0ListOfArraySelectedOperator<T,I> removeAllNull();



    
    public Level0ListOfArraySelectedOperator<T,I> convert(final IConverter<? extends List<? extends T[]>,? super List<T[]>> converter);
    
    public Level0ListOfArraySelectedOperator<T,I> eval(final IEvaluator<? extends List<? extends T[]>,? super List<T[]>> eval);

    public Level0ListOfArraySelectedOperator<T,I> replaceWith(final List<T[]> replacement);

    public Level0ListOfArraySelectedOperator<T,I> exec(final IFunction<? extends List<? extends T[]>, ? super List<T[]>> function);

    
}
