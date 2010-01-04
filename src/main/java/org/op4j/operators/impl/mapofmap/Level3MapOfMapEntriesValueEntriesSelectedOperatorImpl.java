package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level3MapOfMapEntriesValueEntriesSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level3MapOfMapEntriesValueEntriesSelectedOperator<K1,K2,V> {


    public Level3MapOfMapEntriesValueEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends Entry<K2,V>,? super Entry<K2,V>> eval) {
        return null;
    }


    public Level3MapOfMapEntriesValueEntriesOperator<K1,K2,V> endIf() {
        return null;
    }


    public Level4MapOfMapEntriesValueEntriesSelectedKeyOperator<K1,K2,V> onKey() {
        return null;
    }


    public Level4MapOfMapEntriesValueEntriesSelectedValueOperator<K1,K2,V> onValue() {
        return null;
    }


    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1,K2,V> exec(final IFunction<? extends Entry<K2,V>,? super Entry<K2,V>> function) {
        return null;
    }


    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1,K2,V> convert(final IConverter<? extends Entry<K2,V>,? super Entry<K2,V>> converter) {
        return null;
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}