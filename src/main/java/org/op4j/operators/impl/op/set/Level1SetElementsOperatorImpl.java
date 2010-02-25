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
package org.op4j.operators.impl.op.set;

import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level1SetElementsOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level1SetElementsOperatorImpl<I,T> extends AbstractOperatorImpl
        implements UniqOpOperator<I,Set<T>>, Level1SetElementsOperator<I,T>  {

    
    public Level1SetElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOperatorImpl<I,T> endFor() {
        return new Level0SetOperatorImpl<I,T>(getTarget().endIterate(null));
    }


    public <X> Level1SetElementsOperatorImpl<I,X> asType(final Type<X> type) {
    	return endFor().generic().asSetOf(type).forEach();
    }

    public Level1SetElementsOperatorImpl<I,?> asUnknown() {
        return asType(Types.OBJECT);
    }


    
    
    
    
    
    
    

    public Set<T> get() {
        return endFor().get();
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> ifIndex(final int... indexes) {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().selectIndex(indexes));
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> ifIndexNot(final int... indexes) {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().selectIndexNot(indexes));
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> ifTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().selectMatching(eval));
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> ifFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> ifNotNull() {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().selectNotNull());
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> ifNull() {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().selectNull());
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level1SetElementsOperatorImpl<I,X> execIfNotNull(final IFunction<? super T,X> function) {
        return new Level1SetElementsOperatorImpl<I,X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level1SetElementsOperatorImpl<I,X> exec(final IFunction<? super T,X> function) {
        return new Level1SetElementsOperatorImpl<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1SetElementsOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level1SetElementsOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1SetElementsOperatorImpl<I,T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    
    
}