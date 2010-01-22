package org.op4j.operators.impl.arrayoflist;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ArrayOfListElementsElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ArrayOfListElementsElementsSelectedOperator<T,I> {


    public Level2ArrayOfListElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ArrayOfListElementsElementsOperator<T,I> endIf() {
        return new Level2ArrayOfListElementsElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<T>[] get() {
        return endIf().get();
    }


    public Operation<List<T>[],I> createOperation() {
        return endIf().createOperation();
    }



}
