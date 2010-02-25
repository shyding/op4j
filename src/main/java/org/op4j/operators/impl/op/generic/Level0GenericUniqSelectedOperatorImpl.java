package org.op4j.operators.impl.op.generic;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level0GenericUniqSelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqOpOperator<I,T>, Level0GenericUniqSelectedOperator<I,T> {


    public Level0GenericUniqSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0GenericUniqOperatorImpl<I,T> endIf() {
        return new Level0GenericUniqOperatorImpl<I,T>(getTarget().endSelect());
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> execIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public T get() {
        return endIf().get();
    }



}