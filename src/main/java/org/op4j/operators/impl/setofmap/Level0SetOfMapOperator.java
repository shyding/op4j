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
package org.op4j.operators.impl.setofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0SetOfMapOperator<K,V> extends Operator
        implements ILevel0SetOfMapOperator<K,V>  {

    
    public Level0SetOfMapOperator(final Target target) {
        super(target);
    }


    public ILevel0SetOfMapOperator<K, V> add(final Map<K, V>... newElements) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFuncs.Add<Map<K, V>>(newElements)));
    }


    public ILevel0SetOfMapOperator<K, V> insert(final int position, final Map<K, V>... newElements) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFuncs.Insert<Map<K, V>>(position, newElements)));
    }


    public ILevel0SetOfMapOperator<K, V> addAll(final Collection<Map<K, V>> collection) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFuncs.AddAll<Map<K, V>>(collection)));
    }


    public ILevel1SetOfMapElementsOperator<K, V> forEach() {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterate());
    }


    public ILevel1SetOfMapElementsOperator<K, V> forEachIndex(final int... indices) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterate(indices));
    }


    


    public ILevel1SetOfMapElementsOperator<K, V> forEachMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterate(eval));
    }

    public ILevel1SetOfMapElementsOperator<K, V> forEachNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterateNot(eval));
    }

    public ILevel1SetOfMapElementsOperator<K, V> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterateNullOrNot(eval));
    }

    public ILevel1SetOfMapElementsOperator<K, V> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterateNotNullAndNot(eval));
    }


    public ILevel1SetOfMapElementsOperator<K, V> forEachNotNullMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1SetOfMapElementsOperator<K, V> forEachNullOrMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterateNullOr(eval));
    }


    public ILevel1SetOfMapElementsOperator<K, V> forEachIndexNot(final int... indices) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterateNot(indices));
    }


    








    public ILevel1SetOfMapElementsOperator<K, V> forEachNotNull() {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterateNotNull());
    }


    public ILevel1SetOfMapElementsOperator<K, V> forEachNull() {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterateNull());
    }


    public ILevel0SetOfMapOperator<K, V> removeIndexes(final int... indices) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFuncs.RemoveIndexes<Map<K, V>>(indices)));
    }


    public ILevel0SetOfMapOperator<K, V> removeEquals(final Map<K, V>... values) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFuncs.RemoveEquals<Map<K, V>>(values)));
    }


    public ILevel0SetOfMapOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFuncs.RemoveMatching<Map<K, V>>(eval)));
    }

    public ILevel0SetOfMapOperator<K, V> removeNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNotMatching<Map<K, V>>(eval)));
    }

    public ILevel0SetOfMapOperator<K, V> removeNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<Map<K, V>>(eval)));
    }

    public ILevel0SetOfMapOperator<K, V> removeNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<Map<K, V>>(eval)));
    }


    public ILevel0SetOfMapOperator<K, V> removeNullOrMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<Map<K, V>>(eval)));
    }


    public ILevel0SetOfMapOperator<K, V> removeNotNullMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<Map<K, V>>(eval)));
    }


    public ILevel0SetOfMapOperator<K, V> removeIndexesNot(final int... indices) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFuncs.RemoveIndexesNot<Map<K, V>>(indices)));
    }


    public ILevel0SetOfMapOperator<K, V> removeNulls() {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNulls<Map<K, V>>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0SetOfMapOperator<K, V> sort() {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public ILevel0SetOfMapOperator<K, V> sort(final Comparator<? super Map<K, V>> comparator) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFuncs.SortByComparator<Map<K, V>>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Set<Map<K, V>> get() {
        return (Set<Map<K,V>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<Map<K, V>>> generic() {
        return new Level0GenericUniqOperator<Set<Map<K, V>>>(getTarget());
    }

    
    
    
    
    
    
    
	public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super Set<Map<K,V>>> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Set<Map<K,V>>> eval) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Set<Map<K,V>>> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
	}

    
    

    public <X,Y> ILevel0SetOfMapOperator<X,Y> asSetOfMap(final Type<X> keyOf, final Type<Y> valueOf) {
    	return generic().asSetOfMap(keyOf, valueOf);
    }


    public ILevel0SetOfMapOperator<?,?> asSetOfMapOfUnknown() {
        return asSetOfMap(Types.OBJECT, Types.OBJECT);
    }
    
    
    
    
}
