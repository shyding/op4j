package org.op4j.operators.impl.mapoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesValueSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> {


    public Level2MapOfListSelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsOperator<K,V,I> forEach() {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsOperatorImpl<K,V,I>(getTarget().iterate());
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> distinct() {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.Distinct<V>()));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> insertAll(final int position, final V... newElements) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> removeAllIndexes(final int... indices) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllIndexes<V>(indices)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> removeAllEqual(final V... values) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<V>(indices)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> removeAllNull() {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> eval(final IEvaluator<? extends List<? extends V>,? super List<V>> eval) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.LIST));
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V,I> endIf() {
        return new Level2MapOfListSelectedEntriesValueOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> add(final V newElement) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.Add<V>(newElement)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> addAll(final V... newElements) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.Add<V>(newElements)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> addAll(final Collection<V> collection) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.AddAll<V>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> insert(final int position, final V newElement) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.Insert<V>(position, newElement)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> exec(final IFunction<? extends List<? extends V>,? super List<V>> function) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> sort() {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> replaceWith(final List<V> replacement) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> convert(final IConverter<? extends List<? extends V>,? super List<V>> converter) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.LIST));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }


    public Operation<Map<K,List<V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
