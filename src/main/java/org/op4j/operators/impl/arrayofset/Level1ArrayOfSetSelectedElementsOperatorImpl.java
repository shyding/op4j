package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level1ArrayOfSetSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfSetSelectedElementsOperator<T> {


    public Level1ArrayOfSetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfSetSelectedElementsElementsOperator<T> forEach() {
        return new Level2ArrayOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeEquals(final T... values) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveEquals<T>(values)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveMatching<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeNulls() {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNulls<T>()));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level0ArrayOfSetSelectedOperator<T> endFor() {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().endIterate(Structure.ARRAY, Set.class));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> add(final T... newElements) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> exec(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetSelectedElementsOperator<T> sort() {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<T>[] get() {
        return endFor().get();
    }



}
