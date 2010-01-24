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
package org.op4j.operators.impl.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.NonEmptyTargetException;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.arrayofset.Level0ArrayOfSetOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.setofset.Level0SetOfSetOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetSelectedOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.target.OperationChainingTarget;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ListOfSetOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level0ListOfSetOperator<T,I>  {

    
    public Level0ListOfSetOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfSetOperator<T,I> add(final Set<T> newElement) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<Set<T>>(NormalizationUtils.normalizeSet(newElement))));
    }

    public Level0ListOfSetOperator<T,I> addAll(final Set<T>... newElements) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<Set<T>>(NormalizationUtils.normalizeSets(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfSetOperator<T,I> insert(final int position, final Set<T> newElement) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<Set<T>>(position, NormalizationUtils.normalizeSet(newElement))));
    }

    public Level0ListOfSetOperator<T,I> insertAll(final int position, final Set<T>... newElements) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<Set<T>>(position, NormalizationUtils.normalizeSets(newElements))));
    }


    public Level0ListOfSetOperator<T,I> addAll(final Collection<Set<T>> collection) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.AddAll<Set<T>>(NormalizationUtils.normalizeSets(collection))));
    }


    public Level0ListOfSetOperator<T,I> distinct() {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Distinct<Set<T>>()));
    }


    public Level0ListOperator<T,I> flatten() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.FlattenListOfSets<T>()));
    }


    public Level1ListOfSetElementsOperator<T,I> forEach() {
        return new Level1ListOfSetElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level0ListOfSetOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexes<Set<T>>(indices)));
    }


    public Level0ListOfSetOperator<T,I> removeAllEqual(final Set<T>... values) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllEqual<Set<T>>(values)));
    }


    public Level0ListOfSetOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllTrue<Set<T>>(eval)));
    }

    public Level0ListOfSetOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllFalse<Set<T>>(eval)));
    }

    public Level0ListOfSetOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<Set<T>>(eval)));
    }

    public Level0ListOfSetOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<Set<T>>(eval)));
    }


    public Level0ListOfSetOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<Set<T>>(eval)));
    }


    public Level0ListOfSetOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<Set<T>>(eval)));
    }


    public Level0ListOfSetOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<Set<T>>(indices)));
    }


    public Level0ListOfSetOperator<T,I> removeAllNull() {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNull<Set<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ListOfSetOperator<T,I> sort() {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfSetOperator<T,I> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().execute(new ListFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T,I> toArrayOfArray(final Type<T> of) {
        return toListOfArray(of).toArrayOfArray(of);
    }


    public Level0ArrayOfListOperator<T,I> toArrayOfList() {
        return toListOfList().toArrayOfList();
    }


    public <K> Level0ArrayOfMapOperator<K, T,I> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return toListOfMap(keyEval).toArrayOfMap();
    }


    public <K, V> Level0ArrayOfMapOperator<K, V,I> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return toListOfMap(mapBuild).toArrayOfMap();
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetOperator<T,I> toArrayOfSet() {
        return new Level0ArrayOfSetOperatorImpl<T, I>(getTarget().execute(new ToArray.FromCollection<Set<T>>((Type<Set<T>>)(Type<?>)Types.SET_OF_UNKNOWN)));
    }


    public Level0ListOfArrayOperator<T,I> toListOfArray(final Type<T> of) {
        return forEach().toArray(of).endFor();
    }


    public Level0ListOfListOperator<T,I> toListOfList() {
        return forEach().toList().endFor();
    }


    public <K> Level0ListOfMapOperator<K, T,I> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> Level0ListOfMapOperator<K, V,I> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public Level0SetOfArrayOperator<T,I> toSetOfArray(final Type<T> of) {
        return toListOfArray(of).toSetOfArray(of);
    }


    public Level0SetOfListOperator<T,I> toSetOfList() {
        return toListOfList().toSetOfList();
    }


    public <K> Level0SetOfMapOperator<K, T,I> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return toListOfMap(keyEval).toSetOfMap();
    }


    public <K, V> Level0SetOfMapOperator<K, V,I> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return toListOfMap(mapBuild).toSetOfMap();
    }


    public Level0SetOfSetOperator<T,I> toSetOfSet() {
        return new Level0SetOfSetOperatorImpl<T, I>(getTarget().execute(new ToSet.FromCollection<Set<T>>()));
    }


    public Level0ArrayOfMapOperator<T, T,I> toArrayOfMap() {
        return toListOfMap().toArrayOfMap();
    }


    public Level0ListOfMapOperator<T, T,I> toListOfMap() {
        return forEach().toMap().endFor();
    }


    public Level0SetOfMapOperator<T, T,I> toSetOfMap() {
        return toArrayOfMap().toSetOfMap();
    }


    @SuppressWarnings("unchecked")
    public List<Set<T>> get() {
        return (List<Set<T>>) getTarget().get();
    }


    public Level0GenericUniqOperator<List<Set<T>>,I> generic() {
        return new Level0GenericUniqOperatorImpl<List<Set<T>>,I>(getTarget());
    }

    
    
    
    
    
    
	public <X> Level0ListOfSetOperator<X,I> asListOfSetOf(final Type<X> type) {
        return generic().asListOfSetOf(type);
    }


    public Level0ListOfSetOperator<?,I> asListOfSetOfUnknown() {
        return asListOfSetOf(Types.OBJECT);
    }


    public Level0ListOfSetSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level0ListOfSetSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level0ListOfSetSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level0ListOfSetSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level0ListOfSetSelectedOperator<T,I> ifNotNull() {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level0ListOfSetSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListOfSetSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListOfSetSelectedOperator<T,I> ifNull() {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level0ListOfSetSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ListOfSetSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0ListOfSetOperator<X,I> convert(final IConverter<? extends List<? extends Set<X>>, ? super List<Set<T>>> converter) {
        return new Level0ListOfSetOperatorImpl<X,I>(getTarget().execute(converter, Normalization.LIST_OF_SET));
    }


    public <X> Level0ListOfSetOperator<X,I> eval(final IEvaluator<? extends List<? extends Set<X>>, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetOperatorImpl<X,I>(getTarget().execute(eval, Normalization.LIST_OF_SET));
    }


    public <X> Level0ListOfSetOperator<X,I> exec(final IFunction<? extends List<? extends Set<X>>, ? super List<Set<T>>> function) {
        return new Level0ListOfSetOperatorImpl<X,I>(getTarget().execute(function, Normalization.LIST_OF_SET));
    }


    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super List<Set<T>>> converter) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super List<Set<T>>> eval) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<Set<T>>> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0ListOfSetOperator<T,I> replaceWith(final List<Set<T>> replacement) {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0ListOfSetOperator<T,I> replaceIfNullWith(final List<Set<T>> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<List<Set<T>>, I> createOperation() {
        final Target target = getTarget();
        if (!(target instanceof OperationChainingTarget)) {
            throw new NonEmptyTargetException();
        }
        final OperationChainingTarget ocTarget = (OperationChainingTarget) target;
        if (!ocTarget.isEmpty()) {
            throw new NonEmptyTargetException();
        }
        return new Operation<List<Set<T>>, I>(ocTarget);
    }
    
    
    
}
