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

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.intf.map.ILevel2MapSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesSelectedKeyOperator<I,K,V> extends AbstractOperator implements UniqOpOperator<I,Map<K,V>>, ILevel2MapSelectedEntriesSelectedKeyOperator<I,K,V> {


    public Level2MapSelectedEntriesSelectedKeyOperator(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifTrue(final IFunction<? super K,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifFalse(final IFunction<? super K,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifNull() {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V>(getTarget().selectNull());
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifNotNull() {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V>(getTarget().selectNotNull());
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifNullOrFalse(final IFunction<? super K,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifNotNullAndFalse(final IFunction<? super K,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifNullOrTrue(final IFunction<? super K,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifNotNullAndTrue(final IFunction<? super K,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1MapSelectedEntriesSelectedOperator<I,K,V> endOn() {
        return new Level1MapSelectedEntriesSelectedOperator<I,K,V>(getTarget().endOn());
    }


    public Level2MapSelectedEntriesSelectedKeyOperator<I,K,V> exec(final IFunction<? super K,? extends K> function) {
        return new Level2MapSelectedEntriesSelectedKeyOperator<I,K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedKeyOperator<I,K,V> replaceWith(final K replacement) {
        return new Level2MapSelectedEntriesSelectedKeyOperator<I,K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endOn().get();
    }



}
