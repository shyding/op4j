package org.op4j.operators.impl.op.generic;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericMultiSelectedOperator;
import org.op4j.operators.qualities.MultiOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level0GenericMultiSelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements MultiOpOperator<I,T>, Level0GenericMultiSelectedOperator<I,T> {


    public Level0GenericMultiSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0GenericMultiOperatorImpl<I,T> endIf() {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endSelect());
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> execIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public List<T> getAsList() {
        return endIf().buildList().get();
    }


    public T[] getAsArrayOf(final Type<T> type) {
        return endIf().buildArrayOf(type).get();
    }


    public int size() {
        return endIf().size();
    }



}
