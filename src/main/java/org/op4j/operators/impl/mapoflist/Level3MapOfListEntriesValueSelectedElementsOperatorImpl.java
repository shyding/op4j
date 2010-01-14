package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesValueSelectedElementsOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level3MapOfListEntriesValueSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfListEntriesValueSelectedElementsOperator<K,V> {


    public Level3MapOfListEntriesValueSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListEntriesValueSelectedElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3MapOfListEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3MapOfListEntriesValueSelectedElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfListEntriesValueSelectedElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfListEntriesValueSelectedElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfListEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfListEntriesValueSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfListEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3MapOfListEntriesValueSelectedElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfListEntriesValueSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3MapOfListEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfListEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfListEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3MapOfListEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfListEntriesValueSelectedElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfListEntriesValueSelectedElementsOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2MapOfListEntriesValueSelectedOperator<K,V> endFor() {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level3MapOfListEntriesValueSelectedElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfListEntriesValueSelectedElementsOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3MapOfListEntriesValueSelectedElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfListEntriesValueSelectedElementsOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,List<V>> get() {
        return endFor().get();
    }



}
