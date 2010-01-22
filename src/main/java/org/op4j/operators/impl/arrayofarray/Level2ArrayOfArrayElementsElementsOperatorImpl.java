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
package org.op4j.operators.impl.arrayofarray;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsElementsSelectedOperator;
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
public class Level2ArrayOfArrayElementsElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level2ArrayOfArrayElementsElementsOperator<T,I> {
    
    private final Type<? extends T> type; 

    
    public Level2ArrayOfArrayElementsElementsOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArrayOfArrayElementsOperator<T,I> endFor() {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(Types.arrayOf(this.type), getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public <X> Level2ArrayOfArrayElementsElementsOperator<X,I> asType(final Type<X> elementType) {
        return endFor().endFor().asArrayOfArrayOf(elementType).forEach(Types.arrayOf(elementType)).forEach(elementType);
    }

    public Level2ArrayOfArrayElementsElementsOperator<?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public T[][] get() {
        return endFor().endFor().get();
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndex(indices));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNull());
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifNull() {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNull());
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2ArrayOfArrayElementsElementsOperator<X,I> convert(final IConverter<X, ? super T> converter) {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<X,I>(converter.getResultType(this.type), getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2ArrayOfArrayElementsElementsOperator<X,I> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<X,I>(eval.getResultType(this.type), getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level2ArrayOfArrayElementsElementsOperator<X,I> exec(final IFunction<X, ? super T> function) {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<X,I>(function.getResultType(this.type), getTarget().execute(function, Normalization.NONE));
    }


    public Level2ArrayOfArrayElementsElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfArrayElementsElementsOperator<T,I> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<T[][], I> createOperation() {
        return endFor().createOperation();
    }

}
