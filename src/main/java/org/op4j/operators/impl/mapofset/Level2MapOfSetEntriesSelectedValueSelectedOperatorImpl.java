package org.op4j.operators.impl.mapofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesSelectedValueSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> {


    public Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsOperator<K,V,I> forEach() {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsOperatorImpl<K,V,I>(getTarget().iterate());
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> insertAll(final int position, final V... newElements) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> removeAllIndexes(final int... indices) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllIndexes<V>(indices)));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> removeAllEqual(final V... values) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<V>(indices)));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> removeAllNull() {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> eval(final IEvaluator<? extends Set<? extends V>,? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.SET));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> endIf() {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> add(final V newElement) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.Add<V>(newElement)));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> addAll(final V... newElements) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.Add<V>(newElements)));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> addAll(final Collection<V> collection) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.AddAll<V>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> insert(final int position, final V newElement) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.Insert<V>(position, newElement)));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> exec(final IFunction<? extends Set<? extends V>,? super Set<V>> function) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.SET));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> sort() {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> replaceWith(final Set<V> replacement) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> convert(final IConverter<? extends Set<? extends V>,? super Set<V>> converter) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.SET));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }


    public Operation<Map<K,Set<V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
