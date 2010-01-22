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

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalizationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level3ListOfMapElementsEntriesKeyOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level3ListOfMapElementsEntriesKeyOperator<K,V,I>  {

    
    public Level3ListOfMapElementsEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfMapElementsEntriesOperator<K, V,I> endOn() {
        return new Level2ListOfMapElementsEntriesOperatorImpl<K,V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> Level3ListOfMapElementsEntriesKeyOperator<X, V,I> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsListOfMapOfKey(type, get());
        return new Level3ListOfMapElementsEntriesKeyOperatorImpl<X, V,I>(getTarget());
    }

    public Level3ListOfMapElementsEntriesKeyOperator<?,V,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public List<Map<K, V>> get() {
        return endOn().endFor().endFor().get();
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indices));
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V,I> ifNotNull() {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V,I>(getTarget().selectNotNull());
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V,I> ifNull() {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V,I>(getTarget().selectNull());
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level3ListOfMapElementsEntriesKeyOperator<X, V,I> convert(final IConverter<X, ? super K> converter) {
        return new Level3ListOfMapElementsEntriesKeyOperatorImpl<X, V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level3ListOfMapElementsEntriesKeyOperator<X, V,I> eval(final IEvaluator<X, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesKeyOperatorImpl<X, V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level3ListOfMapElementsEntriesKeyOperator<X, V,I> exec(final IFunction<X, ? super K> function) {
        return new Level3ListOfMapElementsEntriesKeyOperatorImpl<X, V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3ListOfMapElementsEntriesKeyOperator<K, V,I> replaceWith(final K replacement) {
        return new Level3ListOfMapElementsEntriesKeyOperatorImpl<K, V,I>(getTarget().replaceWith(replacement));
    }


    public Level3ListOfMapElementsEntriesKeyOperator<K, V,I> replaceIfNullWith(final K replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<List<Map<K, V>>, I> createOperation() {
        return endOn().createOperation();
    }

}
