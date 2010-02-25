package org.op4j.operators.impl.op.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesSelectedKeySelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V> extends AbstractOperatorImpl implements UniqOpOperator<I,Map<K,V>>, Level2MapEntriesSelectedKeySelectedOperator<I,K,V> {


    public Level2MapEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapEntriesSelectedKeyOperatorImpl<I,K,V> endIf() {
        return new Level2MapEntriesSelectedKeyOperatorImpl<I,K,V>(getTarget().endSelect());
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V> execIfNotNull(final IFunction<? super K,? extends K> function) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V> exec(final IFunction<? super K,? extends K> function) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V> replaceWith(final K replacement) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}