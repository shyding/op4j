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
package org.op4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.operators.impl.fn.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.fn.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.fn.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.fn.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.fn.set.Level0SetOperatorImpl;
import org.op4j.target.ExecutionTarget;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Fn {
    

    
    
    
    private Fn() {
        super();
    }

    
    
    
    
    
    
    
    public static <T> Level0GenericUniqOperatorImpl<T,T> on(final Type<T> type) {
        return new Level0GenericUniqOperatorImpl<T,T>(ExecutionTarget.forFn(Normalisation.NONE));
    }
    
    
    public static <T> Level0ArrayOperatorImpl<T[],T> on(final Type<T[]> type) {
        return onArrayOf(Types.arrayComponentOf(type));
    }
    
    public static <T> Level0ListOperatorImpl<List<T>,T> on(final Type<List<T>> type) {
        return onListOf(Types.listComponentOf(type));
    }

    
    public static <K,V> Level0MapOperatorImpl<Map<K,V>,K,V> on(final Type<Map<K,V>> type) {
        return onMapOf(Types.mapKeyComponentOf(type), Types.mapValueComponentOf(type));
    }

    
    public static <T> Level0SetOperatorImpl<Set<T>,T> on(final Type<Set<T>> type) {
        return onSetOf(Types.setComponentOf(type));
    }
    
    
    
    
    
    public static <T> Level0ArrayOperatorImpl<T[],T> onArrayOf(final Type<T> type) {
        return new Level0ArrayOperatorImpl<T[],T>(type, ExecutionTarget.forFn(Normalisation.ARRAY(type.getRawClass())));
    }

    
    public static <T> Level0ListOperatorImpl<List<T>,T> onListOf(final Type<T> type) {
        return new Level0ListOperatorImpl<List<T>,T>(ExecutionTarget.forFn(Normalisation.LIST));
    }

    
    public static <K,V> Level0MapOperatorImpl<Map<K,V>,K,V> onMapOf(final Type<K> keyType, Type<V> valueType) {
        return new Level0MapOperatorImpl<Map<K,V>,K,V>(ExecutionTarget.forFn(Normalisation.MAP));
    }

    
    public static <T> Level0SetOperatorImpl<Set<T>,T> onSetOf(final Type<T> type) {
        return new Level0SetOperatorImpl<Set<T>,T>(ExecutionTarget.forFn(Normalisation.SET));
    }
    
    

}