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
package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.array.Level0ArrayOperator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ArrayOfSetOperator<T> extends Operator
        implements ILevel0ArrayOfSetOperator<T>  {

    
    public Level0ArrayOfSetOperator(final Target target) {
        super(target);
    }


    public ILevel0ArrayOfSetOperator<T> add(final Set<T>... newElements) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.Add<Set<T>>(newElements)));
    }


    public ILevel0ArrayOfSetOperator<T> insert(final int position, final Set<T>... newElements) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.Insert<Set<T>>(position, newElements)));
    }


    public ILevel0ArrayOfSetOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.AddAll<Set<T>>(collection)));
    }


    public ILevel0ArrayOfSetOperator<T> distinct() {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.Distinct<Set<T>>()));
    }


    public ILevel0ArrayOperator<T> flatten(final Type<? super T> type) {
        return new Level0ArrayOperator<T>(type, getTarget().execute(new ArrayFuncs.FlattenArrayOfSets<T>(type)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEach() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachIndex(final int... indices) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel1ArrayOfSetElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterate(eval));
    }

    public ILevel1ArrayOfSetElementsOperator<T> forEachNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNot(eval));
    }

    public ILevel1ArrayOfSetElementsOperator<T> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNullOrNot(eval));
    }

    public ILevel1ArrayOfSetElementsOperator<T> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNotNullAndNot(eval));
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel1ArrayOfSetElementsOperator<T> forEachNotNull() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachNull() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel0ArrayOfSetOperator<T> removeIndexes(final int... indices) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.RemoveIndexes<Set<T>>(indices)));
    }


    public ILevel0ArrayOfSetOperator<T> removeEquals(final Set<T>... values) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.RemoveEquals<Set<T>>(values)));
    }


    public ILevel0ArrayOfSetOperator<T> removeMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.RemoveMatching<Set<T>>(eval)));
    }

    public ILevel0ArrayOfSetOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<Set<T>>(eval)));
    }

    public ILevel0ArrayOfSetOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<Set<T>>(eval)));
    }

    public ILevel0ArrayOfSetOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<Set<T>>(eval)));
    }


    public ILevel0ArrayOfSetOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<Set<T>>(eval)));
    }


    public ILevel0ArrayOfSetOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<Set<T>>(eval)));
    }


    public ILevel0ArrayOfSetOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<Set<T>>(indices)));
    }



    public ILevel0ArrayOfSetOperator<T> removeNulls() {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.RemoveNulls<Set<T>>()));
    }

    
    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfSetOperator<T> sort() {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }

    public ILevel0ArrayOfSetOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public ILevel0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return forEach().toArray(of).endFor();
    }


    public ILevel0ArrayOfListOperator<T> toArrayOfList() {
        return forEach().toList().endFor();
    }


    public <K> ILevel0ArrayOfMapOperator<K, T> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> ILevel0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public ILevel0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return Op.onListOfArray(of, Op.onArray(forEach().toArray(of).get()).toList().get());
    }


    public ILevel0ListOfListOperator<T> toListOfList() {
        return Op.onListOfList(Op.onArray(forEach().toList().get()).toList().get());
    }


    public <K> ILevel0ListOfMapOperator<K, T> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onListOfMap(Op.onArray(forEach().toMap(keyEval).get()).toList().get());
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onListOfMap(Op.onArray(forEach().toMap(mapBuild).get()).toList().get());
    }


    public ILevel0ListOfSetOperator<T> toListOfSet() {
        return Op.onListOfSet(Op.onArray(get()).toList().get());
    }


    public ILevel0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(of, Op.onArray(forEach().toArray(of).get()).toSet().get());
    }


    public ILevel0SetOfListOperator<T> toSetOfList() {
        return Op.onSetOfList(Op.onArray(forEach().toList().get()).toSet().get());
    }


    public <K> ILevel0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onSetOfMap(Op.onArray(forEach().toMap(keyEval).get()).toSet().get());
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onSetOfMap(Op.onArray(forEach().toMap(mapBuild).get()).toSet().get());
    }


    public ILevel0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(Op.onArray(get()).toSet().get());
    }


    public ILevel0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return forEach().toMap().endFor();
    }


    public ILevel0ListOfMapOperator<T, T> toListOfMap() {
        return Op.onListOfMap(Op.onArray(forEach().toMap().get()).toList().get());
    }


    public ILevel0SetOfMapOperator<T, T> toSetOfMap() {
        return Op.onSetOfMap(Op.onArray(forEach().toMap().get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
    public Set<T>[] get() {
        return (Set<T>[]) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<T>[]> generic() {
        return new Level0GenericUniqOperator<Set<T>[]>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
	public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super Set<T>[]> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Set<T>[]> eval) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Set<T>[]> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
	}

    
    
    
    


    public <X> ILevel0ArrayOfSetOperator<X> asArrayOfSetOf(final Type<X> type) {
        return generic().asArrayOfSetOf(type);
    }


    public ILevel0ArrayOfSetOperator<?> asArrayOfSetOfUnknown() {
        return asArrayOfSetOf(Types.OBJECT);
    }
    
    
    
    
}
