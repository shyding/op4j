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
package org.op4j.operators.intf.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSetSelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1SetOfSetSelectedElementsOperator<T>
        extends UniqOperator<Set<Set<T>>>,
                NavigableCollectionOperator<T>,
    	        SortableOperator<T>,
                ExecutableSetSelectedOperator<T>,
                ReplaceableOperator<Set<T>>,
                NavigatingCollectionOperator<Set<T>>,
                ModifiableCollectionOperator<T>,
                SelectableOperator<Set<T>> {



    public Level0SetOfSetSelectedOperator<T> endFor();


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNull();
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotNull();
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval);


            
    public Level2SetOfSetSelectedElementsElementsOperator<T> forEach();

    public Level1SetOfSetSelectedElementsOperator<T> sort();
    public Level1SetOfSetSelectedElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1SetOfSetSelectedElementsOperator<T> add(final T newElement);
    public Level1SetOfSetSelectedElementsOperator<T> addAll(final T... newElements);
    public Level1SetOfSetSelectedElementsOperator<T> insert(final int position, final T newElement);
    public Level1SetOfSetSelectedElementsOperator<T> insertAll(final int position, final T... newElements);
    public Level1SetOfSetSelectedElementsOperator<T> addAll(final Collection<T> collection);
    public Level1SetOfSetSelectedElementsOperator<T> removeAllIndexes(final int... indexes);
    public Level1SetOfSetSelectedElementsOperator<T> removeAllEqual(final T... values);
    public Level1SetOfSetSelectedElementsOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsOperator<T> removeAllIndexesNot(final int... indexes);
    public Level1SetOfSetSelectedElementsOperator<T> removeAllNull();
    
    
    public Level1SetOfSetSelectedElementsOperator<T> convertAsSet(final IConverter<? extends Set<? extends T>,? super Set<T>> converter);
    
    public Level1SetOfSetSelectedElementsOperator<T> evalAsSet(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval);

    public Level1SetOfSetSelectedElementsOperator<T> replaceWith(final Set<T> replacement);

    public Level1SetOfSetSelectedElementsOperator<T> execAsSet(final IFunction<? extends Set<? extends T>, ? super Set<T>> function);


    
    public Level1SetOfSetSelectedElementsOperator<T> map(final IFunction<? extends T, ? super T> function);
		            
}
