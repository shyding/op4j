package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V> {


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2ArrayOfMapElementsSelectedEntriesOperator<K,V> endIf() {
        return new Level2ArrayOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return null;
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V> onValue() {
        return null;
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return new Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return new Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V>[] get() {
        return null;
    }



}
