package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> {


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> eval(final IEvaluator<? extends K2,? super K2> eval) {
        return null;
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeyOperator<K1,K2,V> endIf() {
        return null;
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> exec(final IFunction<? extends K2,? super K2> function) {
        return null;
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> convert(final IConverter<? extends K2,? super K2> converter) {
        return null;
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}