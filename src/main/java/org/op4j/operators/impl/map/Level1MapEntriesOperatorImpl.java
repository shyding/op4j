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
package org.op4j.operators.impl.map;

import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.list.Level1ListElementsOperatorImpl;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.map.Level1MapEntriesOperator;
import org.op4j.operators.intf.map.Level1MapEntriesSelectedOperator;
import org.op4j.operators.intf.map.Level2MapEntriesKeyOperator;
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1MapEntriesOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level1MapEntriesOperator<K,V,I> {

    
    public Level1MapEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOperator<K, V,I> endFor() {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level2MapEntriesKeyOperator<K, V,I> onKey() {
        return new Level2MapEntriesKeyOperatorImpl<K, V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level2MapEntriesValueOperator<K, V,I> onValue() {
        return new Level2MapEntriesValueOperatorImpl<K, V,I>(getTarget().iterate().selectIndex(1));
    }


    public Map<K, V> get() {
        return endFor().get();
    }



    
    public Level1MapEntriesSelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level1MapEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indices));
    }


    public Level1MapEntriesSelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level1MapEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level1MapEntriesSelectedOperator<K, V,I> ifKeyEquals(final K... keys) {
        return new Level1MapEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectMapKeys(keys));
    }


    public Level1MapEntriesSelectedOperator<K, V,I> ifKeyNotEquals(final K... keys) {
        return new Level1MapEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level1MapEntriesSelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1MapEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level1MapEntriesSelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1MapEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public <X, Y> Level1MapEntriesOperator<X, Y,I> convert(final IConverter<? extends Entry<X, Y>, ? super Entry<K, V>> converter) {
        return new Level1MapEntriesOperatorImpl<X, Y,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public <X, Y> Level1MapEntriesOperator<X, Y,I> eval(final IEvaluator<? extends Entry<X, Y>, ? super Entry<K, V>> eval) {
        return new Level1MapEntriesOperatorImpl<X, Y,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public <X, Y> Level1MapEntriesOperator<X, Y,I> exec(final IFunction<? extends Entry<X, Y>, ? super Entry<K, V>> function) {
        return new Level1MapEntriesOperatorImpl<X, Y,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public <X> Level1ListElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Entry<K, V>> converter) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level1ListElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Entry<K, V>> eval) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level1ListElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Entry<K, V>> function) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level1MapEntriesOperator<K, V,I> replaceWith(final Entry<K, V> replacement) {
        return new Level1MapEntriesOperatorImpl<K, V,I>(getTarget().replaceWith(replacement));
    }


    public Operation<Map<K, V>, I> createOperation() {
        return endFor().createOperation();
    }

}
