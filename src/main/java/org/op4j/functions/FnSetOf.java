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

package org.op4j.functions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.op4j.exceptions.ExecutionException;
import org.op4j.util.ExecCtxImpl;
import org.op4j.util.ValuePair;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class FnSetOf<T> {


    
    protected final Type<T> type;
    
    
    




    public final IFunction<Set<T>,Set<T>> sort() {
        return new Sort<T>();
    }

    public final IFunction<Set<T>,Set<T>> sort(final Comparator<? super T> comparator) {
        return new SortByComparator<T>(comparator);
    }
    
    public final IFunction<Set<T>,Set<T>> add(final T... newElements) {
        return new Add<T>(newElements);
    }
    
    public final IFunction<Set<T>,Set<T>> insert(final int position, final T... newElements) {
        return new Insert<T>(position, newElements);
    }
    
    public final IFunction<Set<T>,Set<T>> addAll(final Collection<T> collection) {
        return new AddAll<T>(collection);
    }
    
    public final IFunction<Set<T>,Set<T>> removeAllIndexes(final int... indexes) {
        return new RemoveAllIndexes<T>(indexes);
    }
    
    public final IFunction<Set<T>,Set<T>> removeAllEqual(final T... values) {
        return new RemoveAllEqual<T>(values);
    }
    
    public final IFunction<Set<T>,Set<T>> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllTrue<T>(eval);
    }
    
    public final IFunction<Set<T>,Set<T>> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllFalse<T>(eval);
    }
    
    public final IFunction<Set<T>,Set<T>> removeAllIndexesNot(final int... indexes) {
        return new RemoveAllIndexesNot<T>(indexes);
    }
    
    public final IFunction<Set<T>,Set<T>> removeAllNull() {
        return new RemoveAllNull<T>();
    }
    
    public final IFunction<Set<T>,Set<T>> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNotNullAndTrue<T>(eval);
    }
    
    public final IFunction<Set<T>,Set<T>> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNotNullAndFalse<T>(eval);
    }
    
    public final IFunction<Set<T>,Set<T>> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNullOrTrue<T>(eval);
    }
    
    public final IFunction<Set<T>,Set<T>> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNullOrFalse<T>(eval);
    }
    

    
    public final IFunction<Set<T>,T[]> toArray() {
        return new ToArray<T>(this.type);
    }

    public final IFunction<Set<T>,List<T>> toList() {
        return new ToList<T>();
    }
    
    public final <K> IFunction<Set<T>,Map<K,T>> toMapByKeyEval(final IFunction<? super T, K> eval) {
        return new ToMapByKeyEval<K,T>(eval);
    }
    
    public final <K,V> IFunction<Set<T>,Map<K,V>> toMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new ToMapByMapBuilder<K,V,T>(mapBuilder);
    }
    
    public final IFunction<Set<T>,Map<T,T>> toMapByAlternateElements() {
        return new ToMapByAlternateElements<T>();
    }
    
    public final <K> IFunction<Set<T>,Map<K,T[]>> toMapOfArrayByKeyEval(final IFunction<? super T, K> eval) {
        return new ToMapOfArrayByKeyEval<K,T>(this.type, eval);
    }
    
    public final <K,V> IFunction<Set<T>,Map<K,V[]>> toMapOfArrayOf(final Type<V> valueType, final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new ToMapOfArrayByMapBuilder<K,V,T>(valueType, mapBuilder);
    }
    
    public final IFunction<Set<T>,Map<T,T[]>> toMapOfArrayByAlternateElements() {
        return new ToMapOfArrayByAlternateElements<T>(this.type);
    }
    
    public final <K> IFunction<Set<T>,Map<K,List<T>>> toMapOfListByKeyEval(final IFunction<? super T, K> eval) {
        return new ToMapOfListByKeyEval<K,T>(eval);
    }
    
    public final <K,V> IFunction<Set<T>,Map<K,List<V>>> toMapOfList(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new ToMapOfListByMapBuilder<K,V,T>(mapBuilder);
    }
    
    public final IFunction<Set<T>,Map<T,List<T>>> toMapOfListByAlternateElements() {
        return new ToMapOfListByAlternateElements<T>();
    }
    
    public final <K> IFunction<Set<T>,Map<K,Set<T>>> toMapOfSetByKeyEval(final IFunction<? super T, K> eval) {
        return new ToMapOfSetByKeyEval<K,T>(eval);
    }
    
    public final <K,V> IFunction<Set<T>,Map<K,Set<V>>> toMapOfSet(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new ToMapOfSetByMapBuilder<K,V,T>(mapBuilder);
    }
    
    public final IFunction<Set<T>,Map<T,Set<T>>> toMapOfSetByAlternateElements() {
        return new ToMapOfSetByAlternateElements<T>();
    }
    
    
    
    
    
    public final IFunction<T,Set<T>> unfold(final IFunction<? super T,? extends T> function, final IFunction<? super T,Boolean> unless) {
        return new Unfold<T>(function, unless);
    }
    
    public final IFunction<T,Set<T>> unfold(final IFunction<? super T,? extends T> function) {
        return new Unfold<T>(function, null);
    }

    
    public final IFunction<Set<T>,T> reduce(final IFunction<? extends ValuePair<? super T,? super T>, ? extends T> function) {
        return new Reduce<T>(function);
    }
    
    public final <R> IFunction<Set<T>,R> reduce(final IFunction<? extends ValuePair<? super R,? super T>,R> function, final R initialValue) {
        return new ReduceInitialValue<T,R>(function, initialValue);
    }
    
    
    

    
    
    protected FnSetOf(final Type<T> type) {
        super();
        this.type = type;
    }

    
    
    
    static final class Sort<T> extends FnCollection.Sort<T, Set<T>> {

        Sort() {
            super();
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }

    }


    
    
    
    static final class SortByComparator<T> extends FnCollection.SortByComparator<T, Set<T>> {

        SortByComparator(final Comparator<? super T> comparator) {
            super(comparator);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }

    }
    
    
    
    
    static final class Add<T> extends FnCollection.Add<T, Set<T>> {

        Add(final T... newElements) {
            super(newElements);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    
    static final class Insert<T> extends FnCollection.Insert<T, Set<T>> {

        Insert(final int position, T... newElements) {
            super(position, newElements);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    
    
    
    
    
    static final class AddAll<T> extends FnCollection.AddAll<T, Set<T>> {

        AddAll(final Collection<T> collection) {
            super(collection);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllIndexes<T> extends FnCollection.RemoveAllIndexes<T, Set<T>> {

        
        RemoveAllIndexes(final int... indexes) {
            super(indexes);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllEqual<T> extends FnCollection.RemoveAllEqual<T, Set<T>> {

        RemoveAllEqual(final T... values) {
            super(values);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllTrue<T> extends FnCollection.RemoveAllTrue<T, Set<T>> {

        RemoveAllTrue(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllFalse<T> extends FnCollection.RemoveAllTrue<T, Set<T>> {

        RemoveAllFalse(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllIndexesNot<T> extends FnCollection.RemoveAllIndexesNot<T, Set<T>> {

        RemoveAllIndexesNot(final int... indexes) {
            super(indexes);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllNull<T> extends FnCollection.RemoveAllNull<T, Set<T>> {

        RemoveAllNull() {
            super();
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllNotNullAndTrue<T> extends FnCollection.RemoveAllNotNullAndTrue<T, Set<T>> {

        RemoveAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllNotNullAndFalse<T> extends FnCollection.RemoveAllNotNullAndTrue<T, Set<T>> {

        RemoveAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }


    
    
    static final class RemoveAllNullOrTrue<T> extends FnCollection.RemoveAllNullOrTrue<T, Set<T>> {

        RemoveAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }


    
    
    static final class RemoveAllNullOrFalse<T> extends FnCollection.RemoveAllNullOrTrue<T, Set<T>> {

        RemoveAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    
    
    
    
    
    static final class ToArray<T> extends AbstractNullAsNullFunction<Set<T>,T[]>  {

        private final Type<T> type;
        
        ToArray(final Type<T> type) {
            super();
            Validate.notNull(type, "A type representing the collection elements must be specified");
            this.type = type;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T[] nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            final T[] array = (T[]) Array.newInstance(this.type.getRawClass(), result.size());
            return result.toArray(array);
        }
        
    }
    
    
    
    static final class ToList<T> extends AbstractNullAsNullFunction<Set<T>,List<T>> {

        ToList() {
            super();
        }

        @Override
        protected List<T> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            return new ArrayList<T>(object);
        }
        
    }
    
    
    
    
    
    
    static final class ToMapByKeyEval<K, T> extends AbstractNullAsNullFunction<Set<T>,Map<K, T>>  {

        private final IFunction<? super T,K>  eval;
        
        ToMapByKeyEval(final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected Map<K, T> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, T> result = new LinkedHashMap<K, T>();
            for (final T element: object) {
                result.put(this.eval.execute(element, ctx), element);
            }
            return result;
        }
        
    }

    
    
    
    
    static final class ToMapByMapBuilder<K, V, T> extends AbstractNullAsNullFunction<Set<T>,Map<K, V>>  {

        private final IFunction<? super T,Map.Entry<K,V>> mapBuilder;
        
        ToMapByMapBuilder(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
            super();
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, V> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final T element: object) {
                final Map.Entry<K,V> entry = this.mapBuilder.execute(element, ctx);
                if (entry == null) {
                    throw new ExecutionException(
                            "Map builder returned null, but a map builder should never return null");
                }
                result.put(entry.getKey(), entry.getValue());
            }
            return result;
        }
        
    }

    
    
    
    
    static final class ToMapByAlternateElements<T> extends AbstractNullAsNullFunction<Set<T>,Map<T, T>>  {

        ToMapByAlternateElements() {
            super();
        }

        @Override
        protected Map<T, T> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            if (object.size() % 2 != 0) {
                throw new IllegalArgumentException("Cannot create a map from objects: the number of objects must be even.");
            }
            final List<T> objectAsList = new ArrayList<T>(object);
            final Map<T, T> result = new LinkedHashMap<T, T>();
            for (int i = 0, n = objectAsList.size() - 1; i < n; i += 2) {
                result.put(objectAsList.get(i), objectAsList.get(i + 1));
            }
            return result;
        }
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    protected static final <K,V> Map<K, V[]> createFromMapOfList(final Type<V> type, final Map<K, List<V>> mapOfList) {
        final Map<K, V[]> result = new LinkedHashMap<K, V[]>();
        for (final Map.Entry<K, List<V>> listEntry : mapOfList.entrySet()) {
            final K key = listEntry.getKey();
            final List<V> listValue = listEntry.getValue();
            final V[] arrayValue = (V[]) Array.newInstance(type.getRawClass(), listValue.size());
            result.put(key, listValue.toArray(arrayValue));
        }
        return result;
    }
    
    
    
    static final class ToMapOfArrayByKeyEval<K, T> extends AbstractNullAsNullFunction<Set<T>,Map<K, T[]>>  {

        private final IFunction<? super T,K>  eval;
        private final Type<T> type;
        
        ToMapOfArrayByKeyEval(final Type<T> type, final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(type, "A type representing the collection elements must be specified");
            Validate.notNull(eval, "An evaluator must be specified");
            this.type = type;
            this.eval = eval;
        }

        @Override
        protected Map<K, T[]> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            
            final Map<K, List<T>> result = new LinkedHashMap<K, List<T>>();
            for (final T element: object) {
                final K key = this.eval.execute(element, ctx);
                List<T> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<T>();
                    result.put(key, value);
                }
                value.add(element);
            }
            
            return createFromMapOfList(this.type, result);

        }
        
    }

    
    
    
    
    static final class ToMapOfArrayByMapBuilder<K, V, T> extends AbstractNullAsNullFunction<Set<T>,Map<K, V[]>>  {

        private final IFunction<? super T,Map.Entry<K,V>> mapBuilder;
        private final Type<V> type;
        
        ToMapOfArrayByMapBuilder(final Type<V> type, final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
            super();
            Validate.notNull(type, "A type representing the collection elements must be specified");
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.type = type;
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, V[]> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            
            final Map<K, List<V>> result = new LinkedHashMap<K, List<V>>();
            for (final T element: object) {
                final Map.Entry<K,V> entry = this.mapBuilder.execute(element, ctx);
                if (entry == null) {
                    throw new ExecutionException(
                            "Map builder returned null, but a map builder should never return null");
                }
                final K key = entry.getKey();
                List<V> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<V>();
                    result.put(key, value);
                }
                value.add(entry.getValue());
            }
            
            return createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    
    
    static final class ToMapOfArrayByAlternateElements<T> extends AbstractNullAsNullFunction<Set<T>,Map<T, T[]>>  {

        private final Type<T> type;
        
        ToMapOfArrayByAlternateElements(final Type<T> type) {
            super();
            Validate.notNull(type, "A type representing the collection elements must be specified");
            this.type = type;
        }

        @Override
        protected Map<T, T[]> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            
            if (object.size() % 2 != 0) {
                throw new IllegalArgumentException("Cannot create a map from objects: the number of objects must be even.");
            }
            
            final List<T> objectAsList = new ArrayList<T>(object);
            final Map<T, List<T>> result = new LinkedHashMap<T, List<T>>();
            for (int i = 0, n = objectAsList.size() - 1; i < n; i += 2) {
                final T key = objectAsList.get(i);
                List<T> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<T>();
                    result.put(key, value);
                }
                value.add(objectAsList.get(i + 1));
            }
            
            return createFromMapOfList(this.type, result);
            
        }
        
    }
    
    
    
    
    
    
    
    
    static final class ToMapOfListByKeyEval<K, T> extends AbstractNullAsNullFunction<Set<T>,Map<K, List<T>>>  {

        private final IFunction<? super T,K>  eval;
        
        ToMapOfListByKeyEval(final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected Map<K, List<T>> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, List<T>> result = new LinkedHashMap<K, List<T>>();
            for (final T element: object) {
                final K key = this.eval.execute(element, ctx);
                List<T> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<T>();
                    result.put(key, value);
                }
                value.add(element);
            }
            return result;
        }
        
    }

    
    
    
    
    static final class ToMapOfListByMapBuilder<K, V, T> extends AbstractNullAsNullFunction<Set<T>,Map<K, List<V>>>  {

        private final IFunction<? super T,Map.Entry<K,V>> mapBuilder;
        
        ToMapOfListByMapBuilder(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
            super();
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, List<V>> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, List<V>> result = new LinkedHashMap<K, List<V>>();
            for (final T element: object) {
                final Map.Entry<K,V> entry = this.mapBuilder.execute(element, ctx);
                if (entry == null) {
                    throw new ExecutionException(
                            "Map builder returned null, but a map builder should never return null");
                }
                final K key = entry.getKey();
                List<V> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<V>();
                    result.put(key, value);
                }
                value.add(entry.getValue());
            }
            return result;
        }
        
    }

    
    
    
    
    static final class ToMapOfListByAlternateElements<T> extends AbstractNullAsNullFunction<Set<T>,Map<T, List<T>>>  {

        ToMapOfListByAlternateElements() {
            super();
        }

        @Override
        protected Map<T, List<T>> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            if (object.size() % 2 != 0) {
                throw new IllegalArgumentException("Cannot create a map from objects: the number of objects must be even.");
            }
            final List<T> objectAsList = new ArrayList<T>(object);
            final Map<T, List<T>> result = new LinkedHashMap<T, List<T>>();
            for (int i = 0, n = objectAsList.size() - 1; i < n; i += 2) {
                final T key = objectAsList.get(i);
                List<T> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<T>();
                    result.put(key, value);
                }
                value.add(objectAsList.get(i + 1));
            }
            return result;
        }
        
    }
    
    
    
    
    
    
    
    
    static final class ToMapOfSetByKeyEval<K, T> extends AbstractNullAsNullFunction<Set<T>,Map<K, Set<T>>>  {

        private final IFunction<? super T,K>  eval;
        
        ToMapOfSetByKeyEval(final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected Map<K, Set<T>> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, Set<T>> result = new LinkedHashMap<K, Set<T>>();
            for (final T element: object) {
                final K key = this.eval.execute(element, ctx);
                Set<T> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<T>();
                    result.put(key, value);
                }
                value.add(element);
            }
            return result;
        }
        
    }

    
    
    
    
    static final class ToMapOfSetByMapBuilder<K, V, T> extends AbstractNullAsNullFunction<Set<T>,Map<K, Set<V>>>  {

        private final IFunction<? super T,Map.Entry<K,V>> mapBuilder;
        
        ToMapOfSetByMapBuilder(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
            super();
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, Set<V>> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, Set<V>> result = new LinkedHashMap<K, Set<V>>();
            for (final T element: object) {
                final Map.Entry<K,V> entry = this.mapBuilder.execute(element, ctx);
                if (entry == null) {
                    throw new ExecutionException(
                            "Map builder returned null, but a map builder should never return null");
                }
                final K key = entry.getKey();
                Set<V> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<V>();
                    result.put(key, value);
                }
                value.add(entry.getValue());
            }
            return result;
        }
        
    }

    
    
    
    
    static final class ToMapOfSetByAlternateElements<T> extends AbstractNullAsNullFunction<Set<T>,Map<T, Set<T>>>  {

        ToMapOfSetByAlternateElements() {
            super();
        }

        @Override
        protected Map<T, Set<T>> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            if (object.size() % 2 != 0) {
                throw new IllegalArgumentException("Cannot create a map from objects: the number of objects must be even.");
            }
            final List<T> objectAsList = new ArrayList<T>(object);
            final Map<T, Set<T>> result = new LinkedHashMap<T, Set<T>>();
            for (int i = 0, n = objectAsList.size() - 1; i < n; i += 2) {
                final T key = objectAsList.get(i);
                Set<T> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<T>();
                    result.put(key, value);
                }
                value.add(objectAsList.get(i + 1));
            }
            return result;
        }
        
    }
    
 
    
    
    
    
    
    static final class Unfold<T> extends AbstractNotNullFunction<T,Set<T>> {
        
        private final IFunction<? super T,? extends T> function;
        private final IFunction<? super T,Boolean> unless;

        
        public Unfold(final IFunction<? super T,? extends T> function, final IFunction<? super T,Boolean> unless) {
            super();
            Validate.notNull(function, "Unfold function cannot be null");
            this.function = function;
            this.unless = unless;
        }

        @Override
        public Set<T> notNullExecute(final T input, final ExecCtx ctx) throws Exception {
            
            final Set<T> resultSet = new LinkedHashSet<T>();
            int index = 0;
            
            T currentTarget = input;
            ExecCtx currentCtx = new ExecCtxImpl(Integer.valueOf(index));

            if (this.unless == null) {
                
                while (currentTarget != null) {
                    resultSet.add(currentTarget);
                    index++;
                    currentCtx = new ExecCtxImpl(Integer.valueOf(index));
                    currentTarget = this.function.execute(currentTarget, currentCtx);
                }
                
            } else {
                
                Boolean unlessResult = null;
                resultSet.add(currentTarget);
                do {
                    index++;
                    currentCtx = new ExecCtxImpl(Integer.valueOf(index));
                    currentTarget = this.function.execute(currentTarget, currentCtx);
                    resultSet.add(currentTarget);
                    unlessResult = this.unless.execute(currentTarget, currentCtx);
                    if (unlessResult == null) {
                        throw new ExecutionException("Unless function returned null!");
                    }
                } while (!unlessResult.booleanValue());
                
            }
            
            return Collections.unmodifiableSet(resultSet);
            
        }
        
        
    }
    
    

    
    
    
    
    
    static final class Reduce<T> extends AbstractNotNullFunction<Set<T>,T> {
        
        private final IFunction<? extends ValuePair<? super T,? super T>, ? extends T> function;

        
        public Reduce(final IFunction<? extends ValuePair<? super T,? super T>, ? extends T> function) {
            super();
            Validate.notNull(function, "Reduce function cannot be null");
            this.function = function;
        }

        
        @Override
        @SuppressWarnings("unchecked")
        public T notNullExecute(final Set<T> input, final ExecCtx ctx) throws Exception {
            final List<T> inputList = new ArrayList<T>(input);
            if (inputList.size() == 0) {
                throw new ExecutionException("Cannot reduce: array contains no elements");
            }
            if (inputList.size() == 1) {
                return inputList.get(0);
            }
            T result = inputList.get(0);
            
            for (int i = 1, z = inputList.size(); i < z; i++) {
                final ValuePair<T,T> currentPair = new ValuePair<T,T>(result, inputList.get(i));
                final ExecCtx currentCtx = new ExecCtxImpl(Integer.valueOf(i - 1));
                result = (T) ((IFunction)this.function).execute(currentPair, currentCtx);
            }
            return result;
        }
        
    }
    
    
    
    static final class ReduceInitialValue<T,R> extends AbstractNotNullFunction<Set<T>,R> {
        
        private final IFunction<? extends ValuePair<? super R,? super T>,R> function;
        private final R initialValue;

        
        public ReduceInitialValue(final IFunction<? extends ValuePair<? super R,? super T>,R> function, final R initialValue) {
            super();
            Validate.notNull(function, "Reduce function cannot be null");
            this.function = function;
            this.initialValue = initialValue;
        }

        
        @Override
        @SuppressWarnings("unchecked")
        public R notNullExecute(final Set<T> input, final ExecCtx ctx) throws Exception {
            final List<T> inputList = new ArrayList<T>(input);
            if (inputList.size() == 0) {
                return this.initialValue;
            }
            R result = this.initialValue;
            
            for (int i = 0, z = inputList.size(); i < z; i++) {
                final ValuePair<R,T> currentPair = new ValuePair<R,T>(result, inputList.get(i));
                final ExecCtx currentCtx = new ExecCtxImpl(Integer.valueOf(i));
                result = (R) ((IFunction)this.function).execute(currentPair, currentCtx);
            }
            return result;
        }
        
    }
    
    
    
}
