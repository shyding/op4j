package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> {


    public Level1MapOfMapSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends Entry<K1,Map<K2,V>>,? super Entry<K1,Map<K2,V>>> eval) {
        return null;
    }


    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V> endIf() {
        return null;
    }


    public Level2MapOfMapSelectedEntriesSelectedKeyOperator<K1,K2,V> onKey() {
        return null;
    }


    public Level2MapOfMapSelectedEntriesSelectedValueOperator<K1,K2,V> onValue() {
        return null;
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> exec(final IFunction<? extends Entry<K1,Map<K2,V>>,? super Entry<K1,Map<K2,V>>> function) {
        return null;
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> convert(final IConverter<? extends Entry<K1,Map<K2,V>>,? super Entry<K1,Map<K2,V>>> converter) {
        return null;
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}