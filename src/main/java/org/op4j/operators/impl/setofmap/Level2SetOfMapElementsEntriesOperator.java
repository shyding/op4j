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
package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;

import org.op4j.IOf;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel2SetOfMapElementsEntriesOperator;
import org.op4j.operators.intf.setofmap.ILevel3SetOfMapElementsEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.ILevel3SetOfMapElementsEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2SetOfMapElementsEntriesOperator<K,V> extends Operator
        implements ILevel2SetOfMapElementsEntriesOperator<K,V>  {

    
    public Level2SetOfMapElementsEntriesOperator(final Target target) {
        super(target);
    }


    public ILevel1SetOfMapElementsOperator<K, V> endFor() {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().endIterate(Structure.MAP, null));
    }


    public <X, Y> ILevel2SetOfMapElementsEntriesOperator<X, Y> of(IOf<X> ofX,
            IOf<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel2SetOfMapElementsEntriesOperator<X, Y> of(
            Class<X> ofXClass, Class<Y> ofYClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3SetOfMapElementsEntriesKeyOperator<K, V> onKey() {
        return new Level3SetOfMapElementsEntriesKeyOperator<K, V>(getTarget().iterate(0));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, V> onValue() {
        return new Level3SetOfMapElementsEntriesValueOperator<K, V>(getTarget().iterate(1));
    }


    public ILevel2SetOfMapElementsEntriesOperator<?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public Set<Map<K, V>> get() {
        return endFor().endFor().get();
    }

}