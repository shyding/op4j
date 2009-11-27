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
package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ListFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.list.Level0ListOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
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
public class Level0ListOfArrayOperator<T> extends Operator
        implements ILevel0ListOfArrayOperator<T>  {
    
    private final Type<? super T> arrayOf; 

    
    public Level0ListOfArrayOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel0ListOfArrayOperator<T> add(final T[]... newElements) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.Add<T[]>(newElements)));
    }


    public ILevel0ListOfArrayOperator<T> insert(final int position, final T[]... newElements) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.Insert<T[]>(position, newElements)));
    }


    public ILevel0ListOfArrayOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.AddAll<T[]>(collection)));
    }


    public ILevel0ListOfArrayOperator<T> distinct() {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.Distinct<T[]>()));
    }


    public ILevel0ListOperator<T> flatten() {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.FlattenArrays<T>()));
    }


    public ILevel1ListOfArrayElementsOperator<T> forEach() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }


    public ILevel1ListOfArrayElementsOperator<T> forEachIndex(final int... indices) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(indices));
    }


    public ILevel1ListOfArrayElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1ListOfArrayElementsOperator<T> forEachMatching(final IEval<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(eval));
    }


    public ILevel1ListOfArrayElementsOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1ListOfArrayElementsOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(eval));
    }


    public ILevel1ListOfArrayElementsOperator<T> forEachSelected(final ISelect<T[]> selector) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel1ListOfArrayElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNot(indices));
    }








    public ILevel1ListOfArrayElementsOperator<T> forEachNotNull() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel1ListOfArrayElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel1ListOfArrayElementsOperator<T> forEachNull() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel1ListOfArrayElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel0ListOfArrayOperator<X> of(final Type<X> of) {
        return new Level0ListOfArrayOperator<X>(of, getTarget());
    }


    public ILevel0ListOfArrayOperator<?> raw() {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget());
    }


    public ILevel0ListOfArrayOperator<T> removeIndexes(final int... indices) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.RemoveIndexes<T[]>(indices)));
    }


    public ILevel0ListOfArrayOperator<T> removeEquals(final T[]... values) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.RemoveEquals<T[]>(values)));
    }


    public ILevel0ListOfArrayOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.RemoveMatching<T[]>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ListOfArrayOperator<T> removeMatching(final IEval<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.RemoveMatching<T[]>(eval)));
    }


    public ILevel0ListOfArrayOperator<T> removeNullOrMatching(final IEval<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.RemoveNullOrMatching<T[]>(eval)));
    }


    public ILevel0ListOfArrayOperator<T> removeNotNullMatching(final IEval<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.RemoveNotNullMatching<T[]>(eval)));
    }


    public ILevel0ListOfArrayOperator<T> removeSelected(final ISelect<T[]> selector) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.RemoveSelected<T[]>(selector)));
    }


    public ILevel0ListOfArrayOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.RemoveIndexesNot<T[]>(indices)));
    }


    public ILevel0ListOfArrayOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.RemoveNotNullMatching<T[]>(Eval.booleanExp(expression, optionalExpParams))));
    }

    public ILevel0ListOfArrayOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.RemoveNullOrMatching<T[]>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ListOfArrayOperator<T> removeNulls() {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.RemoveNulls<T[]>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0ListOfArrayOperator<T> sort() {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.Sort()));
    }


    public ILevel0ListOfArrayOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ListFunc.SortByComparator<T[]>(comparator)));
    }


    public ILevel0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return Op.onArrayOfArray(Op.onList(get()).toArray(Types.arrayOf(of)).get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfListOperator<T> toArrayOfList() {
        return Op.onArrayOfList(Op.onList(forEach().toList().get()).toArray((Type<List<T>>)((Type<?>)Types.LIST_OF_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K> ILevel0ArrayOfMapOperator<K, T> toArrayOfMap(final IEval<K, ? super T> keyEval) {
        return Op.onArrayOfMap(Op.onList(forEach().toMap(keyEval).get()).toArray((Type<Map<K, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K, V> ILevel0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return Op.onArrayOfMap(Op.onList(forEach().toMap(mapBuild).get()).toArray((Type<Map<K, V>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfSetOperator<T> toArrayOfSet() {
        return Op.onArrayOfSet(Op.onList(forEach().toSet().get()).toArray((Type<Set<T>>)((Type<?>)Types.SET_OF_UNKNOWN)).get());
    }


    public ILevel0ListOfListOperator<T> toListOfList() {
        return forEach().toList().endFor();
    }


    public <K> ILevel0ListOfMapOperator<K, T> toListOfMap(final IEval<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> toListOfMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public ILevel0ListOfSetOperator<T> toListOfSet() {
        return forEach().toSet().endFor();
    }


    public ILevel0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(of, Op.onList(get()).toSet().get());
    }


    public ILevel0SetOfListOperator<T> toSetOfList() {
        return Op.onSetOfList(Op.onList(forEach().toList().get()).toSet().get());
    }


    public <K> ILevel0SetOfMapOperator<K, T> toSetOfMap(final IEval<K, ? super T> keyEval) {
        return Op.onSetOfMap(Op.onList(forEach().toMap(keyEval).get()).toSet().get());
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> toSetOfMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return Op.onSetOfMap(Op.onList(forEach().toMap(mapBuild).get()).toSet().get());
    }


    public ILevel0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(Op.onList(forEach().toSet().get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return Op.onArrayOfMap(Op.onList(forEach().toMap().get()).toArray((Type<Map<T, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    public ILevel0ListOfMapOperator<T, T> toListOfMap() {
        return forEach().toMap().endFor();
    }


    public ILevel0SetOfMapOperator<T, T> toSetOfMap() {
        return Op.onSetOfMap(Op.onList(forEach().toMap().get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
    public List<T[]> get() {
        return (List<T[]>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<List<T[]>> generic() {
        return new Level0GenericUniqOperator<List<T[]>>(getTarget());
    }

}
