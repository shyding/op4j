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
import org.op4j.Op;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ArrayFunc;
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
import org.op4j.util.VarArgsUtil;


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
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.Add<Set<T>>(newElements)));
    }


    public ILevel0ArrayOfSetOperator<T> insert(final int position, final Set<T>... newElements) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.Insert<Set<T>>(position, newElements)));
    }


    public ILevel0ArrayOfSetOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.AddAll<Set<T>>(collection)));
    }


    public ILevel0ArrayOfSetOperator<T> distinct() {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.Distinct<Set<T>>()));
    }


    public ILevel0ArrayOperator<T> flatten(final Type<? super T> type) {
        return new Level0ArrayOperator<T>(type, getTarget().execute(new ArrayFunc.FlattenSets<T>(type)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEach() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachIndex(final int... indices) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel1ArrayOfSetElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachMatching(final IEval<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterate(eval));
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachSelected(final ISelect<Set<T>> selector) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel1ArrayOfSetElementsOperator<T> forEachNotNull() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNotNullAnd(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel1ArrayOfSetElementsOperator<T> forEachNull() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNullOr(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel0ArrayOfSetOperator<X> of(final Type<X> of) {
        return new Level0ArrayOfSetOperator<X>(getTarget());
    }


    public ILevel0ArrayOfSetOperator<?> raw() {
        return new Level0ArrayOfSetOperator<T>(getTarget());
    }


    public ILevel0ArrayOfSetOperator<T> removeIndexes(final int... indices) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.RemoveIndexes<Set<T>>(indices)));
    }


    public ILevel0ArrayOfSetOperator<T> removeEquals(final Set<T>... values) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.RemoveEquals<Set<T>>(values)));
    }


    public ILevel0ArrayOfSetOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.RemoveMatching<Set<T>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ArrayOfSetOperator<T> removeMatching(final IEval<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.RemoveMatching<Set<T>>(eval)));
    }


    public ILevel0ArrayOfSetOperator<T> removeNullOrMatching(final IEval<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.RemoveNullOrMatching<Set<T>>(eval)));
    }


    public ILevel0ArrayOfSetOperator<T> removeNotNullMatching(final IEval<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.RemoveNotNullMatching<Set<T>>(eval)));
    }


    public ILevel0ArrayOfSetOperator<T> removeSelected(final ISelect<Set<T>> selector) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.RemoveSelected<Set<T>>(selector)));
    }


    public ILevel0ArrayOfSetOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.RemoveIndexesNot<Set<T>>(indices)));
    }



    public ILevel0ArrayOfSetOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.RemoveNotNullMatching<Set<T>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ArrayOfSetOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.RemoveNullOrMatching<Set<T>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ArrayOfSetOperator<T> removeNulls() {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.RemoveNulls<Set<T>>()));
    }

    
    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfSetOperator<T> sort() {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.Sort()));
    }

    public ILevel0ArrayOfSetOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(new ArrayFunc.SortByComparator<Set<T>>(comparator)));
    }


    public ILevel0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return forEach().toArray(of).endFor();
    }


    public ILevel0ArrayOfListOperator<T> toArrayOfList() {
        return forEach().toList().endFor();
    }


    public <K> ILevel0ArrayOfMapOperator<K, T> toArrayOfMap(final IEval<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> ILevel0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public ILevel0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return Op.onListOfArray(of, Op.onArray(forEach().toArray(of).get()).toList().get());
    }


    public ILevel0ListOfListOperator<T> toListOfList() {
        return Op.onListOfList(Op.onArray(forEach().toList().get()).toList().get());
    }


    public <K> ILevel0ListOfMapOperator<K, T> toListOfMap(final IEval<K, ? super T> keyEval) {
        return Op.onListOfMap(Op.onArray(forEach().toMap(keyEval).get()).toList().get());
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> toListOfMap(final IMapBuild<K, V, ? super T> mapBuild) {
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


    public <K> ILevel0SetOfMapOperator<K, T> toSetOfMap(final IEval<K, ? super T> keyEval) {
        return Op.onSetOfMap(Op.onArray(forEach().toMap(keyEval).get()).toSet().get());
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> toSetOfMap(final IMapBuild<K, V, ? super T> mapBuild) {
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

}
