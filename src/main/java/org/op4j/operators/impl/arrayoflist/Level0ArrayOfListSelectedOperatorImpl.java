package org.op4j.operators.impl.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListSelectedOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;


public class Level0ArrayOfListSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ArrayOfListSelectedOperator<T> {


    public Level0ArrayOfListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfListSelectedElementsOperator<T> forEach() {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().iterate(Structure.ARRAY));
    }


    public Level0ArrayOfListSelectedOperator<T> distinct() {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<List<T>>()));
    }


    public Level0ArrayOfListSelectedOperator<T> insertAll(final int position, final List<T>... newElements) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<List<T>>(position, NormalisationUtils.normaliseLists(newElements))));
    }


    public Level0ArrayOfListSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<List<T>>(indexes)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeAllEqual(final List<T>... values) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<List<T>>(values)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<List<T>>(indexes)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeAllNull() {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNull<List<T>>()));
    }


    public Level0ArrayOfListOperator<T> endIf() {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0ArrayOfListSelectedOperator<T> mapMap(final IFunction<? extends T,? super T> function) {
        return forEach().map(function).endFor();
    }


    public Level0ArrayOfListSelectedOperator<T> convertAsArrayOfList(final IConverter<? extends List<? extends T>[],? super List<T>[]> converter) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.ARRAY_OF_LIST));
    }


    public Level0ArrayOfListSelectedOperator<T> evalAsArrayOfList(final IEvaluator<? extends List<? extends T>[],? super List<T>[]> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.ARRAY_OF_LIST));
    }


    public Level0ArrayOfListSelectedOperator<T> execAsArrayOfList(final IFunction<? extends List<? extends T>[],? super List<T>[]> function) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.ARRAY_OF_LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfListSelectedOperator<T> add(final List<T> newElement) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<List<T>>(NormalisationUtils.normaliseList(newElement))));
    }


    public Level0ArrayOfListSelectedOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<List<T>>(NormalisationUtils.normaliseLists(collection))));
    }


    public Level0ArrayOfListSelectedOperator<T> addAll(final List<T>... newElements) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<List<T>>(NormalisationUtils.normaliseLists(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfListSelectedOperator<T> insert(final int position, final List<T> newElement) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<List<T>>(position, NormalisationUtils.normaliseList(newElement))));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfListSelectedOperator<T> sort() {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArrayOfListSelectedOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<List<T>>(comparator)));
    }


    public Level0ArrayOfListSelectedOperator<T> replaceWith(final List<T>[] replacement) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.ARRAY_OF_LIST));
    }


    public List<T>[] get() {
        return endIf().get();
    }



}
