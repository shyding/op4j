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
import org.op4j.operators.intf.map.ILevel2MapSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesSelectedValueSelectedOperator<I,K,V> extends AbstractOperator implements UniqOpOperator<I,Map<K,V>>, ILevel2MapSelectedEntriesSelectedValueSelectedOperator<I,K,V> {


    public Level2MapSelectedEntriesSelectedValueSelectedOperator(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesSelectedValueOperator<I,K,V> endIf() {
        return new Level2MapSelectedEntriesSelectedValueOperator<I,K,V>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<I,K,V> exec(final IFunction<? super V,? extends V> function) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperator<I,K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<I,K,V> replaceWith(final V replacement) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperator<I,K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
