package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level2ListOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ListOfMapSelectedElementsSelectedEntriesOperator<K,V> {


    public Level2ListOfMapSelectedElementsSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return new Level2ListOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> endFor() {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesKeyOperator<K,V> onKey() {
        return new Level3ListOfMapSelectedElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().iterateIndex(0));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueOperator<K,V> onValue() {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().iterateIndex(1));
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return new Level2ListOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return new Level2ListOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public List<Map<K,V>> get() {
        return endFor().get();
    }



}
