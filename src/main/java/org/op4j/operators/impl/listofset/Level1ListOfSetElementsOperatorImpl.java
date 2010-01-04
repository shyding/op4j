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
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.list.Level1ListElementsOperatorImpl;
import org.op4j.operators.impl.listofarray.Level1ListOfArrayElementsOperatorImpl;
import org.op4j.operators.impl.listoflist.Level1ListOfListElementsOperatorImpl;
import org.op4j.operators.impl.listofmap.Level1ListOfMapElementsOperatorImpl;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsSelectedOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListOfSetElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1ListOfSetElementsOperator<T>  {

    
    public Level1ListOfSetElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfSetElementsOperator<T> add(final T... newElements) {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1ListOfSetElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfSetElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public Level0ListOfSetOperator<T> endFor() {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level2ListOfSetElementsElementsOperator<T> forEach() {
        return new Level2ListOfSetElementsElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1ListOfSetElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1ListOfSetElementsOperator<T> removeEquals(final T... values) {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveEquals<T>(values)));
    }


    public Level1ListOfSetElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveMatching<T>(eval)));
    }

    public Level1ListOfSetElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotMatching<T>(eval)));
    }

    public Level1ListOfSetElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<T>(eval)));
    }

    public Level1ListOfSetElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1ListOfSetElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1ListOfSetElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1ListOfSetElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1ListOfSetElementsOperator<T> removeNulls() {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level1ListOfSetElementsOperator<T> sort() {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1ListOfSetElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfArrayElementsOperator<T> toArray(final Type<T> of) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(of, getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public Level1ListOfListElementsOperator<T> toList() {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public Level1ListOfMapElementsOperator<T, T> toMap() {
        return new Level1ListOfMapElementsOperatorImpl<T, T>(getTarget().execute(new ToMap.FromSetByAlternateElements<T>()));
    }

    
    public <K> Level1ListOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1ListOfMapElementsOperatorImpl<K, T>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1ListOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ListOfMapElementsOperatorImpl<K, V>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    public List<Set<T>> get() {
        return endFor().get();
    }


    
    
    
    
    
	public <X> Level1ListElementsOperator<X> convert(final IConverter<X, ? super Set<T>> converter) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(converter));
	}


    public <X> Level1ListElementsOperator<X> eval(final IEvaluator<X, ? super Set<T>> eval) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level1ListElementsOperator<X> exec(final IFunction<X, ? super Set<T>> function) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(function));
	}

    
    

    public <X> Level1ListOfSetElementsOperator<X> asSetOf(final Type<X> type) {
    	return endFor().generic().asListOfSetOf(type).forEach();
    }


    public Level1ListOfSetElementsOperator<?> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }


    public Level1ListOfSetElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1ListOfSetElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1ListOfSetElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ListOfSetElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfSetElementsSelectedOperator<T> ifNotNull() {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ListOfSetElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListOfSetElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfSetElementsSelectedOperator<T> ifNull() {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ListOfSetElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfSetElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }
    
    
    
}