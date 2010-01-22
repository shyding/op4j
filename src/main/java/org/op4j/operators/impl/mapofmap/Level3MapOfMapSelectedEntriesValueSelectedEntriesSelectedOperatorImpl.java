package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V,I> {


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V,I> eval(final IEvaluator<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator<K1,K2,V,I> endIf() {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesOperatorImpl<K1,K2,V,I>(getTarget().endSelect());
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeyOperator<K1,K2,V,I> onKey() {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperator<K1,K2,V,I> onValue() {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V,I> exec(final IFunction<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V,I> replaceWith(final Entry<K2,V> replacement) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V,I> convert(final IConverter<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
