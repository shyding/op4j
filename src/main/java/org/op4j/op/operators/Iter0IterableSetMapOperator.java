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
package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.op4j.exceptions.InvalidExpressionResultClassException;
import org.op4j.exceptions.InvalidOperatorCastException;
import org.op4j.exceptions.NonIterableException;
import org.op4j.exceptions.NullTargetException;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.IterableSetMapOperator;
import org.op4j.operation.SetMapTarget;
import org.op4j.operation.Target;
import org.op4j.type.Type;
import org.op4j.type.Types;
import org.op4j.util.MapEntry;
import org.op4j.util.OgnlUtils;
import org.op4j.util.TypeAggregationUtils;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Iter0IterableSetMapOperator<K,V> 
        extends Iter0AbstractOperator<Map<K,Set<V>>>
        implements IterableSetMapOperator<K,V> {

    
    private final Type operatorKeyType;
    private final Type operatorValueType;
    
    

    /*
     *  Targets are created for each object computing intended type as Map<keyType,List<valueType>>.
     *  
     *  Creating the intended type as rawtype (as in generic or array) is not 
     *  appliable here because we cannot guarantee that the real type that
     *  the user intended for the object ListMap is the one we could compute from
     *  its values (Integer extends Number and Integer[] extends Number[], but 
     *  Map<Integer,List<Integer>> does not extend Map<Number,List<Number>>).  
     *  
     */
    @SuppressWarnings("unchecked")
    private static SetMapTarget<?,?> prepareTargets(
            final Type keyType, final Type valueType, 
            final Map<?,? extends Set<?>> object) {
        
        return new SetMapTarget(keyType, valueType, object);
        
    }
    
    
    Iter0IterableSetMapOperator(final Class<K> operatorKeyClass, final Class<V> operatorValueClass, final Map<?,? extends Set<?>> object) {
        this((operatorKeyClass != null? Types.getRawTypeForClass(operatorKeyClass) : null), (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), object);
    }
    
    
    Iter0IterableSetMapOperator(final Class<K> operatorKeyClass, final Type operatorValueType, final Map<?,? extends Set<?>> object) {
        this((operatorKeyClass != null? Types.getRawTypeForClass(operatorKeyClass) : null), operatorValueType, object);
    }
    
    
    Iter0IterableSetMapOperator(final Type operatorKeyType, final Class<V> operatorValueClass, final Map<?,? extends Set<?>> object) {
        this(operatorKeyType, (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), object);
    }
    
    
    @SuppressWarnings("unchecked")
    Iter0IterableSetMapOperator(
            final Type operatorKeyType, final Type operatorValueType, 
            final Map<?,? extends Set<?>> object) {
        
        super((SetMapTarget) prepareTargets(operatorKeyType, operatorValueType, object));
        this.operatorKeyType = operatorKeyType;
        this.operatorValueType = operatorValueType;
        /*
         * Check that the intended type is always compatible with the operator type.
         */
        checkOperatorType(this.operatorKeyType, this.operatorValueType, getTargets().get(0).getIntendedType());
        
    }
    

    @SuppressWarnings("unchecked")
    Iter0IterableSetMapOperator(
            final Type operatorKeyType, final Type operatorValueType, 
            final Type keyType, final Type valueType, 
            final Map<?,? extends Set<?>> object) {
        
        super((SetMapTarget) prepareTargets(keyType, valueType, object));
        this.operatorKeyType = operatorKeyType;
        this.operatorValueType = operatorValueType;
        /*
         * Check that the intended type is always compatible with the operator type.
         */
        checkOperatorType(this.operatorKeyType, this.operatorValueType, getTargets().get(0).getIntendedType());
        
    }
    
    
    private static void checkOperatorType(final Type operatorKeyType, final Type operatorValueType, final Type intendedType) {
        final Type operatorType = 
            TypeAggregationUtils.createSetMapOfType(operatorKeyType, operatorValueType);
        if (!operatorType.isAssignableFrom(intendedType)) {
            throw new InvalidOperatorCastException(operatorType, intendedType);
        }
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<SetMapTarget<K,V>> getTargets() {
        return (List<SetMapTarget<K,V>>) getAbstractTargets();
    }
    
    
    final Type getOperatorKeyType() {
        return this.operatorKeyType;
    }
    
    
    final Type getOperatorValueType() {
        return this.operatorValueType;
    }
    
    
    final Iter0IterableSetMapOperator<?,?> unsafeRaw() {
        return new Iter0IterableSetMapOperator<Object,Object>(
                (Type) null, (Type) null, getTargetObjects().get(0));
    }
    
    
    public final Iter0IterableSetMapOperator<?,?> raw() {
        return unsafeRaw();
    }
    
    
    final <X> Iter0IterableSetMapOperator<K,X> unsafeEachExecUniqValue(
            final Class<X> resultClass, final String operationName, final List<Object> parameters) {
        return unsafeEachEntry().unsafeExecUniqOnValue(resultClass, operationName, parameters).unsafeUneachSetMap();
    }
    
    
    public final Iter0IterableSetMapOperator<K,?> eachExecUniqValue(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExecUniqValue(null, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final <X> Iter0IterableSetMapOperator<K,X> eachExecUniqValue(
            final Class<X> resultClass, final String operationName, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExecUniqValue(resultClass, operationName, OperatorUtils.safeOperationParameters(parameters));
    }


    final Iter0IterableSetMapOperator<K,V> unsafeSortKeys() {
        return unsafeSortKeys(null);
    }


    public final Iter0IterableSetMapOperator<K,V> sortKeys() {
        return unsafeSortKeys();
    }


    final Iter0IterableSetMapOperator<K,V> unsafeSortKeys(final Comparator<? super K> comparator) {
        
        final SetMapTarget<K,V> target = getTargets().get(0);
        
        if (areAllTargetsNull()) {
            throw new NullTargetException("sortKeys");
        }
        
        /*
         * This collection is intentionally type-unsafe as we cannot know
         * whether K is Comparable or not until runtime.
         */
        final Map<K,Set<V>> targetObject = target.getObject(); 
        final List<K> keyObjectList = new ArrayList<K>(targetObject.keySet());
        Collections.sort(keyObjectList, comparator);
        final Map<K,Set<V>> newTargetObject = new LinkedHashMap<K,Set<V>>();
        for (K key : keyObjectList) {
            // List is already ordered, so we use its order to order the new map
            newTargetObject.put(key,targetObject.get(key));
        }
        

        return new Iter0IterableSetMapOperator<K,V>(
                getOperatorKeyType(), getOperatorValueType(),
                target.getListMapKeyType(), target.getListMapValueType(),
                newTargetObject);
        
    }


    public final Iter0IterableSetMapOperator<K,V> sortKeys(final Comparator<? super K> comparator) {
        // Comparator can be null. This is to adhere to the Collections.sort(...) API.
        return unsafeSortKeys(comparator);
    }


    final Iter0IterableSetMapOperator<K,V> unsafeSortValueSets() {
        return unsafeSortValueSets(null);
    }


    public final Iter0IterableSetMapOperator<K,V> sortValueSets() {
        return unsafeSortValueSets();
    }


    final Iter0IterableSetMapOperator<K,V> unsafeSortValueSets(final Comparator<? super V> comparator) {
        
        final SetMapTarget<K,V> target = getTargets().get(0);
        
        if (areAllTargetsNull()) {
            throw new NullTargetException("sortValueLists");
        }
        
        /*
         * This collection is intentionally type-unsafe as we cannot know
         * whether V is Comparable or not until runtime.
         */
        final Map<K,Set<V>> targetObject = target.getObject();
        final Map<K,Set<V>> newTargetObject = new LinkedHashMap<K,Set<V>>();
        for (Map.Entry<K,Set<V>> entry : targetObject.entrySet()) {
            final List<V> valuesForKeyList = new ArrayList<V>(entry.getValue());
            Collections.sort(valuesForKeyList, comparator);
            newTargetObject.put(entry.getKey(), new LinkedHashSet<V>(valuesForKeyList));
        }
        

        return new Iter0IterableSetMapOperator<K,V>(
                getOperatorKeyType(), getOperatorValueType(),
                target.getListMapKeyType(), target.getListMapValueType(), 
                newTargetObject);
        
    }


    public final Iter0IterableSetMapOperator<K,V> sortValueSets(final Comparator<? super V> comparator) {
        // Comparator can be null. This is to adhere to the Collections.sort(...) API.
        return unsafeSortValueSets(comparator);
    }
    
    
    final Iter1GenericUniqTargetOperator<V> unsafeEachValue() {
        final Map<K,Set<V>> targetObject = getTargetObjects().get(0);
        final List<Iter0GenericUniqTargetOperator<V>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<V>>();
        for (Set<V> componentObj : targetObject.values()) {
            for (V componentComponentObj : componentObj) {
                components.add(new Iter0GenericUniqTargetOperator<V>(getOperatorValueType(), componentComponentObj));
            }
        }
        return new Iter1GenericUniqTargetOperator<V>(getOperatorValueType(), components);
    }
    
    
    public final Iter1GenericUniqTargetOperator<V> eachValue() {
        return unsafeEachValue();
    }
    
    
    final Iter1GenericUniqTargetOperator<K> unsafeEachKey() {
        final Map<K,Set<V>> targetObject = getTargetObjects().get(0);
        final List<Iter0GenericUniqTargetOperator<K>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<K>>();
        for (K componentObj : targetObject.keySet()) {
            components.add(new Iter0GenericUniqTargetOperator<K>(getOperatorKeyType(), componentObj));
        }
        return new Iter1GenericUniqTargetOperator<K>(getOperatorKeyType(), components);
    }
    
    
    public final Iter1GenericUniqTargetOperator<K> eachKey() {
        return unsafeEachKey();
    }
    
    
    final Iter1MapEntryOperator<K,V> unsafeEachEntry() {
        final Map<K,Set<V>> targetObject = getTargetObjects().get(0);
        final List<Iter0MapEntryOperator<K,V>> components = 
            new ArrayList<Iter0MapEntryOperator<K,V>>();
        for (Map.Entry<K,Set<V>> componentObj : targetObject.entrySet()) {
            final K key = componentObj.getKey();
            if (componentObj.getValue() == null) {
                throw new NonIterableException(
                        "Cannot iterate a null value group");
            }
            for (V value : componentObj.getValue()) {
                final Map.Entry<K,V> newMapEntry = new MapEntry<K,V>(key, value);
                components.add(new Iter0MapEntryOperator<K,V>(
                        getOperatorKeyType(), getOperatorValueType(), newMapEntry));
            }
        }
        return new Iter1MapEntryOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }
    
    
    public final Iter1MapEntryOperator<K,V> eachEntry() {
        return unsafeEachEntry();
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter1GenericUniqTargetOperator<Set<V>> unsafeEachSetValue() {
        final Map<K,Set<V>> targetObject = getTargetObjects().get(0);
        final List<Iter0GenericUniqTargetOperator<Set<V>>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<Set<V>>>();
        for (Set<V> componentObj : targetObject.values()) {
            components.add(new Iter0GenericUniqTargetOperator(
                    TypeAggregationUtils.createSetOfType(getOperatorValueType()), componentObj));
        }
        return new Iter1GenericUniqTargetOperator(TypeAggregationUtils.createSetOfType(getOperatorValueType()), components);
    }
    
    
    public final Iter1GenericUniqTargetOperator<Set<V>> eachSetValue() {
        return unsafeEachSetValue();
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter1MapEntryOperator<K,Set<V>> unsafeEachSetEntry() {
        final Map<K,Set<V>> targetObject = getTargetObjects().get(0);
        final List<Iter0MapEntryOperator<K,V>> components = 
            new ArrayList<Iter0MapEntryOperator<K,V>>();
        for (Map.Entry<K,Set<V>> componentObj : targetObject.entrySet()) {
            components.add(new Iter0MapEntryOperator(
                    getOperatorKeyType(), TypeAggregationUtils.createSetOfType(getOperatorValueType()), componentObj));
        }
        return new Iter1MapEntryOperator(getOperatorKeyType(), TypeAggregationUtils.createSetOfType(getOperatorValueType()), components);
    }
    
    
    public final Iter1MapEntryOperator<K,Set<V>> eachSetEntry() {
        return unsafeEachSetEntry();
    }


    final <X,Y> Iter0IterableSetMapOperator<X,Y> unsafeAsSetMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        // Note that "as" operations make casts dissapear
        return unsafeGeneric().asSetMap(keyClass, valueClass);
    }


    public final <X,Y> Iter0IterableSetMapOperator<X,Y> asSetMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsSetMap(keyClass,valueClass);
    }


    @SuppressWarnings("unchecked")
    final Iter0GenericUniqTargetOperator<Map<K,Set<V>>> unsafeGeneric() {
        final Target<? extends Map<?,?>> target = getTargets().get(0);
        return new Iter0GenericUniqTargetOperator(
                TypeAggregationUtils.createSetMapOfType(getOperatorKeyType(), getOperatorValueType()),
                target.getIntendedType(),
                target.getObject());
    }

    
    public final Iter0GenericUniqTargetOperator<Map<K,Set<V>>> generic() {
        return unsafeGeneric();
    }


    final Iter0IterableSetMapOperator<K,V> unsafeEachFilterEntry(
            final String expression, final List<Object> parameters) {
        if (areAllTargetsNull()) {
            throw new NullTargetException("eachFilterEntry");
        }
        return unsafeEachEntry().unsafeFilter(expression, parameters).unsafeUneachSetMap();
    }

    
    final Iter0IterableSetMapOperator<K,V> unsafeEachFilterEntry(final Filter<Map.Entry<K,V>> filter) {
        if (areAllTargetsNull()) {
            throw new NullTargetException("eachFilterEntry");
        }
        return unsafeEachEntry().unsafeFilter(filter).unsafeUneachSetMap();
    }


    public final Iter0IterableSetMapOperator<K,V> eachFilterEntry(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null");
        return unsafeEachFilterEntry(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

        
    public final Iter0IterableSetMapOperator<K,V> eachFilterEntry(final Filter<Map.Entry<K,V>> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeEachFilterEntry(filter);
    }


    final Iter0IterableSetOperator<K> unsafeKeySet() {
        
        final SetMapTarget<K,V> oldTarget = getTargets().get(0);
        if (areAllTargetsNull()) {
            throw new NullTargetException("keys");
        }
        final Set<K> newObject = new LinkedHashSet<K>(oldTarget.getObject().keySet());
        
        return new Iter0IterableSetOperator<K>(
                getOperatorKeyType(),
                newObject);
        
    }


    public final Iter0IterableSetOperator<K> keySet() {
        return unsafeKeySet();
    }


    @SuppressWarnings("unchecked")
    final Iter0IterableListOperator<Set<V>> unsafeValues() {
        
        final SetMapTarget<K,V> oldTarget = getTargets().get(0);
        
        if (areAllTargetsNull()) {
            throw new NullTargetException("values");
        }
        
        final List<?> newObject = new ArrayList<Set<V>>(oldTarget.getObject().values());
        
        return new Iter0IterableListOperator(
                TypeAggregationUtils.createSetOfType(getOperatorValueType()),
                newObject);
    }


    public final Iter0IterableListOperator<Set<V>> values() {
        return unsafeValues();
    }


    final Iter0IterableSetOperator<V> unsafeValuesForKey(final K key) {
        
        final SetMapTarget<K,V> oldTarget = getTargets().get(0);
        if (areAllTargetsNull()) {
            throw new NullTargetException("valuesForKey");
        }
        final Set<V> newObject = new LinkedHashSet<V>(oldTarget.getObject().get(key));
        
        return new Iter0IterableSetOperator<V>(
                    getOperatorValueType(),
                    oldTarget.getListMapValueType(),
                    newObject);
        
    }


    public final Iter0IterableSetOperator<V> valuesForKey(final K key) {
        // We should not check nullity of key as some implementations might allow it 
        return unsafeValuesForKey(key);
    }


    final Iter0IterableSetOperator<V> unsafeValuesForAllKeys() {
        
        final SetMapTarget<K,V> oldTarget = getTargets().get(0);
        
        if (areAllTargetsNull()) {
            throw new NullTargetException("valuesForAllKeys");
        }
        final Set<V> newObject = new LinkedHashSet<V>();
        for (Set<V> value : oldTarget.getObject().values()) {
            newObject.addAll(value);
        }
        
        return new Iter0IterableSetOperator<V>(
                    getOperatorValueType(),
                    newObject);
        
    }


    public final Iter0IterableSetOperator<V> valuesForAllKeys() {
        return unsafeValuesForAllKeys();
    }


    @SuppressWarnings("unchecked")
    final <X> Iter0IterableMapOperator<K,X> unsafeMergeValues(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        
        final SetMapTarget<K,V> oldTarget = getTargets().get(0);
        if (areAllTargetsNull()) {
            throw new NullTargetException("convergeValues");
        }
        final Map<K,X> newMap = new LinkedHashMap<K,X>();
        for (Map.Entry<K,Set<V>> entry : oldTarget.getObject().entrySet()) {
            Object newValue =
                OgnlUtils.getValueByOgnlExpression(entry.getValue(),expression, parameters);
            if (newValue != null && resultClass != null) {
                if (!resultClass.isAssignableFrom(newValue.getClass())) {
    	            throw new InvalidExpressionResultClassException(newValue.getClass(), resultClass);
                }
            }
            newMap.put(entry.getKey(),(X)newValue);
        }
        
        return new Iter0IterableMapOperator<K,X>(
                    getOperatorKeyType(),
                    resultClass,
                    newMap);
        
    }


    public final Iter0IterableMapOperator<K,?> mergeValues(final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null");
        return unsafeMergeValues(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter0IterableMapOperator<K,X> mergeValues(final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Class cannot be null");
        Validate.notNull(expression, "Expression cannot be null");
        return unsafeMergeValues(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <X> Iter0IterableSetMapOperator<K,X> unsafeEachEvalValue(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        return unsafeEachEntry().unsafeEvalOnValue(resultClass, expression, parameters).unsafeUneachSetMap();
    }

    
    final <X> Iter0IterableSetMapOperator<K,X> unsafeEachEvalValue(
            final Class<X> resultClass, final Evaluator<V,X> evaluator) {
        return unsafeEachEntry().unsafeEvalOnValue(resultClass, evaluator).unsafeUneachSetMap();
    }

    
    public final Iter0IterableSetMapOperator<K,?> eachEvalValue(
            final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEvalValue(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter0IterableSetMapOperator<K,X> eachEvalValue(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Return class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEvalValue(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter0IterableSetMapOperator<K,X> eachEvalValue(
            final Class<X> resultClass, final Evaluator<V,X> evaluator) {
        Validate.notNull(resultClass, "Class cannot be null");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEvalValue(resultClass, evaluator);
    }

    
    public final Iter0IterableSetMapOperator<K,?> eachEvalValue(
            final Evaluator<V,Object> evaluator) {
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEvalValue(null, evaluator);
    }
    

    final <X> Iter0IterableSetMapOperator<K,X> unsafeEachCallValue(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {
        if (areAllTargetsNull()) {
            throw new NullTargetException("eachCall");
        }
        return unsafeEachEntry().unsafeCallOnValue(resultClass, methodName, arguments).unsafeUneachSetMap();
    }
    

    public final Iter0IterableSetMapOperator<K,?> eachCallValue(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCallValue(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter0IterableSetMapOperator<K,X> eachCallValue(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "Return class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCallValue(resultClass, methodName,OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    final <X> Iter0IterableSetMapOperator<K,X> unsafeEachToValue(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        return unsafeEachEntry().unsafeToOnValue(resultClass, resultType, parameters).unsafeUneachSetMap();
    }
    

    public final Iter0IterableSetMapOperator<K,?> eachToValue(
            final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeEachToValue(null, resultType, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final Iter0IterableSetMapOperator<K,?> eachToValue(
            final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeEachToValue(null, Types.forName(resultTypeName), OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter0IterableSetMapOperator<K,X> eachToValue(
            final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeEachToValue(resultClass, Types.getRawTypeForClass(resultClass), OperatorUtils.safeEvaluationParameters(parameters));
    }

    
    public final Map<K,Set<V>> get() {
        return getTargetObjects().get(0);
    }
    

    public final <X,Y> Map<X,Set<Y>> get(Class<X> keyClass, Class<Y> valueClass) {
        return unsafeAsSetMap(keyClass,valueClass).getTargetObjects().get(0);
    }
    
    
}
