package org.op4j.operators.impl.op.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.structures.FSet;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level0SetSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0SetSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements UniqOpOperator<Set<T>>, Level0SetSelectedOperator<T,I> {


    public Level0SetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsOperatorImpl<T,I> forEach() {
        return new Level1SetSelectedElementsOperatorImpl<T,I>(getTarget().iterate(Structure.SET));
    }


    public Level0SetSelectedOperatorImpl<T,I> insertAll(final int position, final T... newElements) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.Insert<T>(position, newElements)));
    }


    public Level0SetSelectedOperatorImpl<T,I> removeAllIndexes(final int... indexes) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllIndexes<T>(indexes)));
    }


    public Level0SetSelectedOperatorImpl<T,I> removeAllEqual(final T... values) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllEqual<T>(values)));
    }


    public Level0SetSelectedOperatorImpl<T,I> removeAllTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllTrue<T>(eval)));
    }


    public Level0SetSelectedOperatorImpl<T,I> removeAllFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllFalse<T>(eval)));
    }


    public Level0SetSelectedOperatorImpl<T,I> removeAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level0SetSelectedOperatorImpl<T,I> removeAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0SetSelectedOperatorImpl<T,I> removeAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0SetSelectedOperatorImpl<T,I> removeAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0SetSelectedOperatorImpl<T,I> removeAllIndexesNot(final int... indexes) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level0SetSelectedOperatorImpl<T,I> removeAllNull() {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllNull<T>()));
    }


    public Level0SetSelectedOperatorImpl<T,I> mapIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().mapIfNotNull(Structure.SET, function, null));
    }


    public Level0SetOperatorImpl<T,I> endIf() {
        return new Level0SetOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level0SetSelectedOperatorImpl<T,I> execIfNotNullAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.SET));
    }


    public Level0SetSelectedOperatorImpl<T,I> execAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalisation.SET));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperatorImpl<T,I> add(final T newElement) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.Add<T>(newElement)));
    }


    public Level0SetSelectedOperatorImpl<T,I> addAll(final T... newElements) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.Add<T>(newElements)));
    }


    public Level0SetSelectedOperatorImpl<T,I> addAll(final Collection<T> collection) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperatorImpl<T,I> insert(final int position, final T newElement) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperatorImpl<T,I> sort() {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.Sort()));
    }


    public Level0SetSelectedOperatorImpl<T,I> sort(final Comparator<? super T> comparator) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new FSet.SortByComparator<T>(comparator)));
    }


    public Level0SetSelectedOperatorImpl<T,I> replaceWith(final Set<T> replacement) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Level0SetSelectedOperatorImpl<T,I> map(final IFunction<? extends T,? super T> function) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().map(Structure.SET, function, null));
    }


    public Set<T> get() {
        return endIf().get();
    }



}
