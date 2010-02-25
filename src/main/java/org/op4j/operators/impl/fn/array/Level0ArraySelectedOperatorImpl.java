package org.op4j.operators.impl.fn.array;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.structures.FArray;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level0ArraySelectedOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0ArraySelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqFnOperator<I,T[]>, Level0ArraySelectedOperator<I,T> {


    private final Type<T> type;


    public Level0ArraySelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArraySelectedElementsOperatorImpl<I,T> forEach() {
        return new Level1ArraySelectedElementsOperatorImpl<I,T>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level0ArraySelectedOperatorImpl<I,T> distinct() {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.Distinct<T>()));
    }


    public Level0ArraySelectedOperatorImpl<I,T> insertAll(final int position, final T... newElements) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.Insert<T>(position, newElements)));
    }


    public Level0ArraySelectedOperatorImpl<I,T> removeAllIndexes(final int... indexes) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.RemoveAllIndexes<T>(indexes)));
    }


    public Level0ArraySelectedOperatorImpl<I,T> removeAllEqual(final T... values) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.RemoveAllEqual<T>(values)));
    }


    public Level0ArraySelectedOperatorImpl<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.RemoveAllTrue<T>(eval)));
    }


    public Level0ArraySelectedOperatorImpl<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.RemoveAllFalse<T>(eval)));
    }


    public Level0ArraySelectedOperatorImpl<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level0ArraySelectedOperatorImpl<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ArraySelectedOperatorImpl<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ArraySelectedOperatorImpl<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ArraySelectedOperatorImpl<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level0ArraySelectedOperatorImpl<I,T> removeAllNull() {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.RemoveAllNull<T>()));
    }


    public Level0ArraySelectedOperatorImpl<I,T> execIfNotNullAsArray(final IFunction<? super T[],? extends T[]> function) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().executeIfNotNull(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0ArraySelectedOperatorImpl<I,T> execAsArray(final IFunction<? super T[],? extends T[]> function) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0ArraySelectedOperatorImpl<I,T> mapIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().mapIfNotNull(Structure.ARRAY, function, this.type.getRawClass()));
    }


    public Level0ArrayOperatorImpl<I,T> endIf() {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperatorImpl<I,T> add(final T newElement) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.Add<T>(newElement)));
    }


    public Level0ArraySelectedOperatorImpl<I,T> addAll(final T... newElements) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.Add<T>(newElements)));
    }


    public Level0ArraySelectedOperatorImpl<I,T> addAll(final Collection<T> collection) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperatorImpl<I,T> insert(final int position, final T newElement) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperatorImpl<I,T> sort() {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.Sort()));
    }


    public Level0ArraySelectedOperatorImpl<I,T> sort(final Comparator<? super T> comparator) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().execute(new FArray.SortByComparator<T>(comparator)));
    }


    public Level0ArraySelectedOperatorImpl<I,T> replaceWith(final T[] replacement) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0ArraySelectedOperatorImpl<I,T> map(final IFunction<? super T,? extends T> function) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }


    public T[] get() {
        return endIf().get();
    }



}