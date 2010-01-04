package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level1MapOfListSelectedEntriesOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListSelectedEntriesKeyOperator<K,V> {


    public Level2MapOfListSelectedEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifNull() {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level1MapOfListSelectedEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level2MapOfListSelectedEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2MapOfListSelectedEntriesKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
