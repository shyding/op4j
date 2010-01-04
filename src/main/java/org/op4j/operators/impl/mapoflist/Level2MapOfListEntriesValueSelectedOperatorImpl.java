package org.op4j.operators.impl.mapoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesValueElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfListEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListEntriesValueSelectedOperator<K,V> {


    public Level2MapOfListEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListEntriesValueElementsOperator<K,V> forEach() {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> distinct() {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends List<V>,? super List<V>> eval) {
        return null;
    }


    public Level2MapOfListEntriesValueOperator<K,V> endIf() {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends List<V>,? super List<V>> function) {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> sort() {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return null;
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends List<V>,? super List<V>> converter) {
        return null;
    }


    public Map<K,List<V>> get() {
        return null;
    }



}