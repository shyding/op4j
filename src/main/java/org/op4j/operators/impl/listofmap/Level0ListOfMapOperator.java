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
package org.op4j.operators.impl.listofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ListFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.target.Target;
import org.op4j.util.VarArgsUtil;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ListOfMapOperator<K,V> extends Operator
        implements ILevel0ListOfMapOperator<K,V>  {

    
    public Level0ListOfMapOperator(final Target target) {
        super(target);
    }


    public ILevel0ListOfMapOperator<K, V> add(final Map<K, V>... newElements) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFunc.Add<Map<K, V>>(newElements)));
    }


    public ILevel0ListOfMapOperator<K, V> insert(final int position, final Map<K, V>... newElements) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFunc.Insert<Map<K, V>>(position, newElements)));
    }


    public ILevel0ListOfMapOperator<K, V> addAll(final Collection<Map<K, V>> collection) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFunc.AddAll<Map<K, V>>(collection)));
    }


    public ILevel0ListOfMapOperator<K, V> distinct() {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFunc.Distinct<Map<K, V>>()));
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEach() {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterate());
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachIndex(final int... indices) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterate(indices));
    }


    


    public ILevel1ListOfMapElementsOperator<K, V> forEachMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachMatching(final IEval<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterate(eval));
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachNotNullMatching(final IEval<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachNullOrMatching(final IEval<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNullOr(eval));
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachSelected(final ISelect<Map<K, V>> selector) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachIndexNot(final int... indices) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNot(indices));
    }


    








    public ILevel1ListOfMapElementsOperator<K, V> forEachNotNull() {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNotNull());
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNotNullAnd(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel1ListOfMapElementsOperator<K, V> forEachNull() {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNull());
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNullOr(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X, Y> ILevel0ListOfMapOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        return new Level0ListOfMapOperator<X, Y>(getTarget());
    }


    public ILevel0ListOfMapOperator<?, ?> raw() {
        return new Level0ListOfMapOperator<K, V>(getTarget());
    }


    public ILevel0ListOfMapOperator<K, V> removeIndexes(final int... indices) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFunc.RemoveIndexes<Map<K, V>>(indices)));
    }


    public ILevel0ListOfMapOperator<K, V> removeEquals(final Map<K, V>... values) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFunc.RemoveEquals<Map<K, V>>(values)));
    }


    public ILevel0ListOfMapOperator<K, V> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFunc.RemoveMatching<Map<K, V>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ListOfMapOperator<K, V> removeSelected(final ISelect<Map<K, V>> selector) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFunc.RemoveSelected<Map<K, V>>(selector)));
    }


    public ILevel0ListOfMapOperator<K, V> removeIndexesNot(final int... indices) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFunc.RemoveIndexesNot<Map<K, V>>(indices)));
    }


    public ILevel0ListOfMapOperator<K, V> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFunc.RemoveNotNullMatching<Map<K, V>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ListOfMapOperator<K, V> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFunc.RemoveNullOrMatching<Map<K, V>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ListOfMapOperator<K, V> removeNulls() {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFunc.RemoveNulls<Map<K, V>>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0ListOfMapOperator<K, V> sort() {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFunc.Sort()));
    }


    public ILevel0ListOfMapOperator<K, V> sort(final Comparator<? super Map<K, V>> comparator) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFunc.SortByComparator<Map<K, V>>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public List<Map<K, V>> get() {
        return (List<Map<K,V>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<List<Map<K, V>>> generic() {
        return new Level0GenericUniqOperator<List<Map<K, V>>>(getTarget());
    }

}
