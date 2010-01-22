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
package org.op4j.operators.impl.arrayofmap;

import java.util.Map;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesValueOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesValueSelectedOperator;
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
public class Level3ArrayOfMapElementsEntriesValueOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level3ArrayOfMapElementsEntriesValueOperator<K,V,I>  {

    
    public Level3ArrayOfMapElementsEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfMapElementsEntriesOperator<K, V,I> endOn() {
        return new Level2ArrayOfMapElementsEntriesOperatorImpl<K, V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> Level3ArrayOfMapElementsEntriesValueOperator<K, X,I> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsArrayOfMapOfValue(type, get());
        return new Level3ArrayOfMapElementsEntriesValueOperatorImpl<K, X,I>(getTarget());
    }

    public Level3ArrayOfMapElementsEntriesValueOperator<K,?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Map<K, V>[] get() {
        return endOn().endFor().endFor().get();
    }


    public Level3ArrayOfMapElementsEntriesValueSelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level3ArrayOfMapElementsEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indices));
    }


    public Level3ArrayOfMapElementsEntriesValueSelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level3ArrayOfMapElementsEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level3ArrayOfMapElementsEntriesValueSelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesValueSelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesValueSelectedOperator<K, V,I> ifNotNull() {
        return new Level3ArrayOfMapElementsEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotNull());
    }


    public Level3ArrayOfMapElementsEntriesValueSelectedOperator<K, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesValueSelectedOperator<K, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesValueSelectedOperator<K, V,I> ifNull() {
        return new Level3ArrayOfMapElementsEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNull());
    }


    public Level3ArrayOfMapElementsEntriesValueSelectedOperator<K, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesValueSelectedOperator<K, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level3ArrayOfMapElementsEntriesValueOperator<K, X,I> convert(final IConverter<X, ? super V> converter) {
        return new Level3ArrayOfMapElementsEntriesValueOperatorImpl<K, X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level3ArrayOfMapElementsEntriesValueOperator<K, X,I> eval(final IEvaluator<X, ? super V> eval) {
        return new Level3ArrayOfMapElementsEntriesValueOperatorImpl<K, X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level3ArrayOfMapElementsEntriesValueOperator<K, X,I> exec(final IFunction<X, ? super V> function) {
        return new Level3ArrayOfMapElementsEntriesValueOperatorImpl<K, X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3ArrayOfMapElementsEntriesValueOperator<K, V,I> replaceWith(final V replacement) {
        return new Level3ArrayOfMapElementsEntriesValueOperatorImpl<K, V,I>(getTarget().replaceWith(replacement));
    }


    public Level3ArrayOfMapElementsEntriesValueOperator<K, V,I> replaceIfNullWith(final V replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Map<K, V>[], I> createOperation() {
        return endOn().createOperation();
    }

}
