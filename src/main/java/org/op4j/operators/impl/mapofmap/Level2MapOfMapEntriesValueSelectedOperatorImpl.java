package org.op4j.operators.impl.mapofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueSelectedEntriesOperator;
import org.op4j.target.Target;


public class Level2MapOfMapEntriesValueSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> {


    public Level2MapOfMapEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> removeMatching(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveMatching<K2,V>(eval)));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K2,V>(eval)));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends Map<K2,V>,? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval));
    }


    public Level2MapOfMapEntriesValueOperator<K1,K2,V> endIf() {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level3MapOfMapEntriesValueSelectedEntriesOperator<K1,K2,V> forEachEntry() {
        return null;
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> insertAll(final int position, final Map<K2,V> map) {
        return null;
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> removeKeys(final K2... keys) {
        return null;
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> removeKeysNot(final K2... keys) {
        return null;
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> put(final K2 newKey, final V newValue) {
        return null;
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> putAll(final Map<K2,V> map) {
        return null;
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> insert(final int position, final K2 newKey, final V newValue) {
        return null;
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> exec(final IFunction<? extends Map<K2,V>,? super Map<K2,V>> function) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> sort() {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> sort(final Comparator<? super Entry<K2,V>> comparator) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.SortEntries<K2,V>(comparator)));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> convert(final IConverter<? extends Map<K2,V>,? super Map<K2,V>> converter) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
