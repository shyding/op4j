package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfArraySelectedEntriesSelectedOperator<K,V> {


    public Level1MapOfArraySelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> eval) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> endIf() {
        return new Level1MapOfArraySelectedEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfArraySelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level2MapOfArraySelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().iterateIndex(0));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> onValue() {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().iterateIndex(1));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> function) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> converter) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
