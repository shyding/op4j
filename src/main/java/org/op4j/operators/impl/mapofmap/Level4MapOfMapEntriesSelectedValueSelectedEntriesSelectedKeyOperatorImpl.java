package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeyOperator<K1,K2,V> {


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indices));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNull() {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNull());
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indices));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNull() {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNull());
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeyOperator<K1,K2,V> eval(final IEvaluator<? extends K2,? super K2> eval) {
        return null;
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> endOn() {
        return null;
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeyOperator<K1,K2,V> exec(final IFunction<? extends K2,? super K2> function) {
        return null;
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeyOperator<K1,K2,V> convert(final IConverter<? extends K2,? super K2> converter) {
        return null;
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}