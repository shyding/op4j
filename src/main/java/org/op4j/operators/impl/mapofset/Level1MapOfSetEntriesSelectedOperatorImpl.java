package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesSelectedOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level1MapOfSetEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfSetEntriesSelectedOperator<K,V> {


    public Level1MapOfSetEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfSetEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<? extends K,? extends Set<? extends V>>,? super Entry<K,Set<V>>> eval) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level1MapOfSetEntriesOperator<K,V> endIf() {
        return new Level1MapOfSetEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfSetEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level2MapOfSetEntriesSelectedKeyOperatorImpl<K,V>(getTarget().iterateIndex(0));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> onValue() {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().iterateIndex(1));
    }


    public Level1MapOfSetEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<? extends K,? extends Set<? extends V>>,? super Entry<K,Set<V>>> function) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level1MapOfSetEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<? extends K,? extends Set<? extends V>>,? super Entry<K,Set<V>>> converter) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
