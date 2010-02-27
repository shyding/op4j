/*  
 * ============================================================================= 
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org) 
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License"); 
 *   you may not use this file except in compliance with the License. 
 *   You may obtain a copy of the License at 
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0 
 * 
 *   Unless required by applicable law or agreed to in writing, software 
 *   distributed under the License is distributed on an "AS IS" BASIS, 
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 *   See the License for the specific language governing permissions and 
 *   limitations under the License. 
 * 
 * ============================================================================= 
 */ 
package org.op4j.operators.impl.op.map;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> extends AbstractOperatorImpl implements UniqOpOperator<I,Map<K,V>>, Level1MapSelectedEntriesSelectedOperator<I,K,V> {


    public Level1MapSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapSelectedEntriesOperatorImpl<I,K,V> endIf() {
        return new Level1MapSelectedEntriesOperatorImpl<I,K,V>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesSelectedKeyOperatorImpl<I,K,V> onKey() {
        return new Level2MapSelectedEntriesSelectedKeyOperatorImpl<I,K,V>(getTarget().onKey());
    }


    public Level2MapSelectedEntriesSelectedValueOperatorImpl<I,K,V> onValue() {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<I,K,V>(getTarget().onValue());
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> execAsMapEntry(final IFunction<? super Entry<K,V>,? extends Entry<? extends K,? extends V>> function) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> execIfNotNullAsMapEntry(final IFunction<? super Entry<K,V>,? extends Entry<? extends K,? extends V>> function) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
