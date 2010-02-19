package org.op4j.operators.impl.mapofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.structures.FArray;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesSelectedValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArrayEntriesSelectedValueOperator<K,V> {


    private final Type<V> type;


    public Level2MapOfArrayEntriesSelectedValueOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().selectIndex(indexes));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().selectMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().selectNull());
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNull());
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsOperator<K,V> forEach() {
        return new Level3MapOfArrayEntriesSelectedValueElementsOperatorImpl<K,V>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> distinct() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.Distinct<V>()));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> insertAll(final int position, final V... newElements) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.Insert<V>(position, newElements)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllIndexes(final int... indexes) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.RemoveAllIndexes<V>(indexes)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllEqual(final V... values) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllTrue(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllFalse(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllNullOrFalse(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllNotNullAndFalse(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllNotNullAndTrue(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllNullOrTrue(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllIndexesNot(final int... indexes) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.RemoveAllIndexesNot<V>(indexes)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllNull() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.RemoveAllNull<V>()));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> execIfNotNullAsArray(final IFunction<? extends V[],? super V[]> function) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().executeIfNotNull(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> execAsArray(final IFunction<? extends V[],? super V[]> function) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> mapIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().mapIfNotNull(Structure.ARRAY, function, this.type.getRawClass()));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V> endOn() {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V>(this.type, getTarget().endOn());
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> add(final V newElement) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.Add<V>(newElement)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> addAll(final V... newElements) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.Add<V>(newElements)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.AddAll<V>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> insert(final int position, final V newElement) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.Insert<V>(position, newElement)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.SortByComparator<V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> sort() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().execute(new FArray.Sort()));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> map(final IFunction<? extends V,? super V> function) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> replaceWith(final V[] replacement) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Map<K,V[]> get() {
        return endOn().get();
    }



}
