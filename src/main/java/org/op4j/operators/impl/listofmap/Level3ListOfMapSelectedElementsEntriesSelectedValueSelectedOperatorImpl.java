package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesSelectedValueOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V,I> {


    public Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedValueOperator<K,V,I> endIf() {
        return new Level3ListOfMapSelectedElementsEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V,I> replaceWith(final V replacement) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }


    public Operation<List<Map<K,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
