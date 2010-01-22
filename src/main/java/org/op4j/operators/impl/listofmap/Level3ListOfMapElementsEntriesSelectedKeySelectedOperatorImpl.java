package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V,I> {


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V,I> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level3ListOfMapElementsEntriesSelectedKeyOperator<K,V,I> endIf() {
        return new Level3ListOfMapElementsEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V,I> replaceWith(final K replacement) {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V,I> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }


    public Operation<List<Map<K,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
