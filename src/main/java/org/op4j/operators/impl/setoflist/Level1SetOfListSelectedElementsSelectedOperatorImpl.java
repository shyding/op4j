package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1SetOfListSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfListSelectedElementsSelectedOperator<T> {


    public Level1SetOfListSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListSelectedElementsSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> distinct() {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends List<T>,? super List<T>> eval) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> endIf() {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> exec(final IFunction<? extends List<T>,? super List<T>> function) {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> sort() {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> convert(final IConverter<? extends List<T>,? super List<T>> converter) {
        return null;
    }


    public Set<List<T>> get() {
        return null;
    }



}