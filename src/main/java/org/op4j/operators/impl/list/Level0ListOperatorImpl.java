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
package org.op4j.operators.impl.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.list.Level0ListSelectedOperator;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ListOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0ListOperator<T>  {

    
    public Level0ListOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ListOperator<T> add(final T... newElements) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level0ListOperator<T> insert(final int position, final T... newElements) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level0ListOperator<T> addAll(final Collection<T> collection) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level0ListOperator<T> distinct() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1ListElementsOperator<T> forEach() {
        return new Level1ListElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0ListOperator<T> removeIndexes(final int... indices) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public Level0ListOperator<T> removeEquals(final T... values) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public Level0ListOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }

    public Level0ListOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<T>(eval)));
    }

    public Level0ListOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<T>(eval)));
    }

    public Level0ListOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level0ListOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level0ListOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level0ListOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level0ListOperator<T> removeNulls() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ListOperator<T> sort() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level0ArrayOperator<T> toArray(final Type<T> of) {
        return new Level0ArrayOperatorImpl<T>(of, getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public Level0MapOperator<T, T> toMap() {
        return new Level0MapOperatorImpl<T, T>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }

    public <K> Level0MapOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0SetOperator<T> toSet() {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    @SuppressWarnings("unchecked")
    public List<T> get() {
        return (List<T>) getTarget().get();
    }


    public Level0GenericUniqOperator<List<T>> generic() {
        return new Level0GenericUniqOperatorImpl<List<T>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
    
	public <X> Level0GenericUniqOperator<X> convert(final IConverter<X, ? super List<T>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter));
	}


    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X, ? super List<T>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super List<T>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function));
	}

    

    public <X> Level0ListOperator<X> asListOf(final Type<X> type) {
        return generic().asListOf(type);
    }


    public <X> Level0ListOfArrayOperator<X> asListOfArrayOf(final Type<X> type) {
        return generic().asListOfArrayOf(type);
    }


    public Level0ListOfArrayOperator<?> asListOfArrayOfUnknown() {
        return asListOfArrayOf(Types.OBJECT);
    }


    public <X> Level0ListOfListOperator<X> asListOfListOf(final Type<X> type) {
        return generic().asListOfListOf(type);
    }


    public Level0ListOfListOperator<?> asListOfListOfUnknown() {
        return asListOfListOf(Types.OBJECT);
    }


    public <K, V> Level0ListOfMapOperator<K, V> asListOfMapOf(final Type<K> keyType, final Type<V> valueType) {
        return generic().asListOfMapOf(keyType, valueType);
    }


    public Level0ListOfMapOperator<?, ?> asListOfMapOfUnknown() {
        return asListOfMapOf(Types.OBJECT, Types.OBJECT);
    }


    public <X> Level0ListOfSetOperator<X> asListOfSetOf(final Type<X> type) {
        return generic().asListOfSetOf(type);
    }


    public Level0ListOfSetOperator<?> asListOfSetOfUnknown() {
        return asListOfSetOf(Types.OBJECT);
    }


    public Level0ListOperator<?> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level0ListSelectedOperator<T> ifIndex(final int... indices) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level0ListSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level0ListSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0ListSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0ListSelectedOperator<T> ifNotNull() {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0ListSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListSelectedOperator<T> ifNull() {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0ListSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ListSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }

    
    
    

}