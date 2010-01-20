package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> {


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> eval(final IEvaluator<? extends K2,? super K2> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeyOperator<K1,K2,V> endIf() {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> exec(final IFunction<? extends K2,? super K2> function) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalization.NONE));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> replaceWith(final K2 replacement) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> convert(final IConverter<? extends K2,? super K2> converter) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
