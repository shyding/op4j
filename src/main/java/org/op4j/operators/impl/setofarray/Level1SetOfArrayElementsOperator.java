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
package org.op4j.operators.impl.setofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ArrayFunc;
import org.op4j.executables.functions.builtin.ArrayFuncOLD;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setofarray.ILevel2SetOfArrayElementsElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1SetOfArrayElementsOperator<T> extends Operator
        implements ILevel1SetOfArrayElementsOperator<T>  {
    
    private final Type<? super T> arrayOf; 

    
    public Level1SetOfArrayElementsOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel1SetOfArrayElementsOperator<T> add(final T... newElements) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.Add<T>(newElements)));
    }


    public ILevel1SetOfArrayElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.Insert<T>(position, newElements)));
    }


    public ILevel1SetOfArrayElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.AddAll<T>(collection)));
    }


    public ILevel1SetOfArrayElementsOperator<T> distinct() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFuncOLD.distinct()));
    }


    public ILevel0SetOfArrayOperator<T> endFor() {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().endIterate(Structure.SET, null));
    }


    public ILevel1SetOfArrayElementsOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfArrayElementsOperator<T> extract(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfArrayElementsOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfArrayElementsOperator<T> extractAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfArrayElementsOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfArrayElementsOperator<T> extractAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfArrayElementsOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfArrayElementsOperator<T> extractAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfArrayElementsOperator<T> extractAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfArrayElementsOperator<T> extractAllBut(
            ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEach() {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEach(final int... positions) {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(positions));
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEach(final ISelect<T> selector) {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNot(final int... positions) {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNot(positions));
    }








    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNotNull() {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNull() {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel1SetOfArrayElementsOperator<X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1SetOfArrayElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfArrayElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfArrayElementsOperator<T> removePositions(final int... positions) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFuncOLD.removePositions(positions)));
    }


    public ILevel1SetOfArrayElementsOperator<T> removeValues(final T... values) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFuncOLD.removeValues(values)));
    }


    public ILevel1SetOfArrayElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFuncOLD.removeMatching(expression, optionalExpParams)));
    }


    public ILevel1SetOfArrayElementsOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFuncOLD.removeSelected(selector)));
    }


    public ILevel1SetOfArrayElementsOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFuncOLD.removeAllExceptPositions(positions)));
    }



    public ILevel1SetOfArrayElementsOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFuncOLD.removeNotNullsMatching(expression, optionalExpParams)));
    }


    public ILevel1SetOfArrayElementsOperator<T> removeNulls() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFuncOLD.removeNulls()));
    }

    


    public ILevel1SetOfArrayElementsOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfArrayElementsOperator<T> sort(
            Comparator<? super T> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> toList() {
        // TODO Auto-generated method stub
        return null;
    }


    public <K> ILevel1SetOfMapElementsOperator<K, T> toMap(
            IEval<K, ? super T> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel1SetOfMapElementsOperator<K, V> toMap(
            IMapBuild<K, V, ? super T> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> toSet() {
        // TODO Auto-generated method stub
        return null;
    }


    public Set<T[]> get() {
        return endFor().get();
    }

}
