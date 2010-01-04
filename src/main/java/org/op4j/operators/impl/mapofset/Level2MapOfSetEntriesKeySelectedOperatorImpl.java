package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level2MapOfSetEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetEntriesKeySelectedOperator<K,V> {


    public Level2MapOfSetEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return null;
    }


    public Level2MapOfSetEntriesKeyOperator<K,V> endIf() {
        return null;
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return null;
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return null;
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}