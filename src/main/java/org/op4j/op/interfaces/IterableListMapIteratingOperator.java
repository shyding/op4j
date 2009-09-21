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
package org.op4j.op.interfaces;

import java.util.List;
import java.util.Map;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IterableListMapIteratingOperator<K,V> 
        extends IterableListMapOperator<K,V>, IteratingOperator<Map<K,List<V>>> {
    
    public IterableListOperator<Map<K,List<V>>> uneachList();
    
    public IterableSetOperator<Map<K,List<V>>> uneachSet();
    
    public IterableArrayOperator<Map<K,List<V>>> uneachArray();
    
    public IterableMapOperator<?,Map<K,List<V>>> uneachMap(
            final String keyExpression, final Object... optionalExpParams);
    public <X> IterableMapOperator<X,Map<K,List<V>>> uneachMap(
            final Class<X> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableMapOperator<?,?> uneachMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <X,Y> IterableMapOperator<X,Y> uneachMap(
            final Class<X> keyClass, final Class<Y> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <X,Y> IterableMapOperator<X,Y> uneachMap(
            final Class<X> keyClass, final Class<Y> valueClass, final MapBuilder<Map<K,List<V>>,X,Y> mapBuilder);
    public IterableMapOperator<?,?> uneachMap(
            final MapBuilder<Map<K,List<V>>,Object,Object> mapBuilder);
    
    public IterableListMapOperator<?,Map<K,List<V>>> uneachListMap(
            final String keyExpression, final Object... optionalExpParams);
    public <X> IterableListMapOperator<X,Map<K,List<V>>> uneachListMap(
            final Class<X> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableListMapOperator<?,?> uneachListMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <X,Y> IterableListMapOperator<X,Y> uneachListMap(
            final Class<X> keyClass, final Class<Y> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <X,Y> IterableListMapOperator<X,Y> uneachListMap(
            final Class<X> keyClass, final Class<Y> valueClass, final MapBuilder<Map<K,List<V>>,X,Y> mapBuilder);
    public IterableListMapOperator<?,?> uneachListMap(
            final MapBuilder<Map<K,List<V>>,Object,Object> mapBuilder);
    
    public IterableSetMapOperator<?,Map<K,List<V>>> uneachSetMap(
            final String keyExpression, final Object... optionalExpParams);
    public <X> IterableSetMapOperator<X,Map<K,List<V>>> uneachSetMap(
            final Class<X> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableSetMapOperator<?,?> uneachSetMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <X,Y> IterableSetMapOperator<X,Y> uneachSetMap(
            final Class<X> keyClass, final Class<Y> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <X,Y> IterableSetMapOperator<X,Y> uneachSetMap(
            final Class<X> keyClass, final Class<Y> valueClass, final MapBuilder<Map<K,List<V>>,X,Y> mapBuilder);
    public IterableSetMapOperator<?,?> uneachSetMap(
            final MapBuilder<Map<K,List<V>>,Object,Object> mapBuilder);
    
}
