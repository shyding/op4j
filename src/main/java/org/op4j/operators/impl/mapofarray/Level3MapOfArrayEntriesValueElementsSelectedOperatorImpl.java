package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3MapOfArrayEntriesValueElementsSelectedOperator<K,V,I> {


    private final Type<? extends V> type;


    public Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl(final Type<? extends V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level3MapOfArrayEntriesValueElementsOperator<K,V,I> endIf() {
        return new Level3MapOfArrayEntriesValueElementsOperatorImpl<K,V,I>(this.type, getTarget().endSelect());
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K,V,I> replaceWith(final V replacement) {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }


    public Operation<Map<K,V[]>,I> createOperation() {
        return endIf().createOperation();
    }



}
