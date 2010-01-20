package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> {


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> endIf() {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }



}
