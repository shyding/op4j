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
package org.op4j.operators.intf.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ConvertibleSelectedOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.EvaluableSelectedOperator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.SelectedOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level0ArrayOfSetSelectedOperator<T>
        extends UniqOperator<Set<T>[]>,
                NavigableCollectionOperator<Set<T>>,
                DistinguishableOperator,
                SortableOperator<Set<T>>,
                ModifiableCollectionOperator<Set<T>>,
                ExecutableSelectedOperator<Set<T>[]>,
                ConvertibleSelectedOperator<Set<T>[]>,
                SelectedOperator<Set<T>[]>,
                EvaluableSelectedOperator<Set<T>[]> {



    public Level0ArrayOfSetOperator<T> endIf();



    public Level1ArrayOfSetSelectedElementsOperator<T> forEach();

    public Level0ArrayOfSetSelectedOperator<T> distinct();
    
    public Level0ArrayOfSetSelectedOperator<T> sort();
    public Level0ArrayOfSetSelectedOperator<T> sort(final Comparator<? super Set<T>> comparator);


    public Level0ArrayOfSetSelectedOperator<T> add(final Set<T>... newElements);
    public Level0ArrayOfSetSelectedOperator<T> insert(final int position, final Set<T>... newElements);
    public Level0ArrayOfSetSelectedOperator<T> addAll(final Collection<Set<T>> collection);
    public Level0ArrayOfSetSelectedOperator<T> removeIndexes(final int... indices);
    public Level0ArrayOfSetSelectedOperator<T> removeEquals(final Set<T>... values);
    public Level0ArrayOfSetSelectedOperator<T> removeMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T> removeIndexesNot(final int... indices);
    public Level0ArrayOfSetSelectedOperator<T> removeNulls();



    
    public Level0ArrayOfSetSelectedOperator<T> convert(final IConverter<? extends Set<T>[],? super Set<T>[]> converter);
    
    public Level0ArrayOfSetSelectedOperator<T> eval(final IEvaluator<? extends Set<T>[],? super Set<T>[]> eval);

    public Level0ArrayOfSetSelectedOperator<T> exec(final IFunction<? extends Set<T>[], ? super Set<T>[]> function);

    
}