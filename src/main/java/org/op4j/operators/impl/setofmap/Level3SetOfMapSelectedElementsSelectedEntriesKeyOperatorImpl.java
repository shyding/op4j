package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level3SetOfMapSelectedElementsSelectedEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapSelectedElementsSelectedEntriesKeyOperator<K,V> {


    public Level3SetOfMapSelectedElementsSelectedEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifNull() {
        return new Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNull() {
        return new Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return null;
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return null;
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return null;
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}