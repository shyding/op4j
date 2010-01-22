package org.op4j.operators.impl.arrayoflist;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T,I> {


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsOperator<T,I> endIf() {
        return new Level2ArrayOfListSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<T>[] get() {
        return endIf().get();
    }


    public Operation<List<T>[],I> createOperation() {
        return endIf().createOperation();
    }



}
