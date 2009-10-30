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
package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.IOf;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel2SetOfListElementsElementsOperator;
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
public class Level1SetOfListElementsOperator<T> extends Operator
        implements ILevel1SetOfListElementsOperator<T>  {

    
    public Level1SetOfListElementsOperator(final Target target) {
        super(target);
    }


    public ILevel1SetOfListElementsOperator<T> add(T newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> add(int position, T newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> addAll(T... newElements) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> addAll(Collection<T> collection) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> distinct() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfListOperator<T> endFor() {
        return new Level0SetOfListOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public ILevel1SetOfListElementsOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> extract(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> extractAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> extractAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> extractAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> extractAllBut(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEach() {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterate());
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEach(final int... positions) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterate(positions));
    }


    


    public ILevel2SetOfListElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEach(final ISelect<T> selector) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachNot(final int... positions) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNot(positions));
    }


    


    public ILevel2SetOfListElementsElementsOperator<T> forEachNot(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNot(expression, optionalExpParams));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachNot(final ISelect<T> selector) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNot(selector));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachNotNull() {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNotNullAndNot(expression, optionalExpParams));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachNull() {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNullOrNot(expression, optionalExpParams));
    }


    public <X> ILevel1SetOfListElementsOperator<X> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1SetOfListElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> remove(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> remove(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> removeAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> removeAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> removeAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> removeAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> removeAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> removeAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> removeAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> removeAllBut(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> sort(
            Comparator<? super T> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1SetOfArrayElementsOperator<X> toArray(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1SetOfArrayElementsOperator<X> toArray(Class<X> of) {
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


    public Set<List<T>> get() {
        return endFor().get();
    }

}