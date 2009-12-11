/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
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
package org.op4j.operators.impl.map;

import java.util.Map;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.map.ILevel1MapEntriesOperator;
import org.op4j.operators.intf.map.ILevel2MapEntriesKeyOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;
import org.op4j.util.TargetUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapEntriesKeyOperator<K,V> extends Operator
        implements ILevel2MapEntriesKeyOperator<K,V> {

    
    public Level2MapEntriesKeyOperator(final Target target) {
        super(target);
    }


    public ILevel1MapEntriesOperator<K, V> endOn() {
        return new Level1MapEntriesOperator<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> ILevel2MapEntriesKeyOperator<X, V> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        TargetUtils.checkIsMapOfKey(type, get());
        return new Level2MapEntriesKeyOperator<X, V>(getTarget());
    }

    public ILevel2MapEntriesKeyOperator<?, V> asUnknown() {
        return asType(Types.OBJECT);
    }


    public <X> ILevel2MapEntriesKeyOperator<X, V> convert(final IConverter<X, ? super K> converter) {
        return new Level2MapEntriesKeyOperator<X, V>(getTarget().execute(converter));
    }


    public <X> ILevel2MapEntriesKeyOperator<X, V> eval(final IEvaluator<X, ? super K> eval) {
        return new Level2MapEntriesKeyOperator<X, V>(getTarget().execute(eval));
    }


    public <X> ILevel2MapEntriesKeyOperator<X, V> exec(final IFunction<X, ? super K> function) {
        return new Level2MapEntriesKeyOperator<X, V>(getTarget().execute(function));
    }

    
    

    public Map<K, V> get() {
        return endOn().endFor().get();
    }


}
