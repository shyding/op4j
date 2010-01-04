package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapSelectedElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesValueOperator;
import org.op4j.target.Target;


public class Level2ArrayOfMapSelectedElementsEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ArrayOfMapSelectedElementsEntriesOperator<K,V> {


    public Level2ArrayOfMapSelectedElementsEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2ArrayOfMapSelectedElementsEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> endFor() {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level3ArrayOfMapSelectedElementsEntriesKeyOperator<K,V> onKey() {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueOperator<K,V> onValue() {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsEntriesOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsEntriesOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return null;
    }


    public Map<K,V>[] get() {
        return null;
    }



}