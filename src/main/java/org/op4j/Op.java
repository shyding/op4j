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

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.Eval;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.StringFunc;
import org.op4j.executables.functions.builtin.ArrayFunc;
import org.op4j.executables.functions.builtin.ListFunc;
import org.op4j.executables.functions.builtin.SetFunc;
import org.op4j.executables.functions.conversion.DecimalPoint;
import org.op4j.executables.functions.conversion.ToBigDecimal;
import org.op4j.executables.functions.conversion.ToBigInteger;
import org.op4j.executables.functions.conversion.ToCalendar;
import org.op4j.executables.functions.conversion.ToDouble;
import org.op4j.executables.functions.conversion.ToInteger;
import org.op4j.executables.functions.conversion.ToLong;
import org.op4j.executables.functions.conversion.ToMap;
import org.op4j.executables.functions.conversion.ToMapOfArray;
import org.op4j.executables.functions.conversion.ToString;
import org.op4j.executables.functions.conversion.ToString.DateStyle;
import org.op4j.executables.functions.conversion.ToString.TimeStyle;
import org.op4j.operators.impl.array.Level0ArrayOperator;
import org.op4j.operators.impl.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.impl.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.impl.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.impl.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.impl.generic.Level0GenericMultiOperator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.list.Level0ListOperator;
import org.op4j.operators.impl.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.impl.listoflist.Level0ListOfListOperator;
import org.op4j.operators.impl.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.impl.listofset.Level0ListOfSetOperator;
import org.op4j.operators.impl.map.Level0MapOperator;
import org.op4j.operators.impl.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.impl.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.impl.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.impl.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.impl.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.impl.setoflist.Level0SetOfListOperator;
import org.op4j.operators.impl.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.impl.setofset.Level0SetOfSetOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericMultiOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.target.Target;
import org.op4j.util.VarArgsUtil;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Op {
    

    
    
    
    private Op() {
        super();
    }

    
    public static <T> ILevel0GenericUniqOperator<T> on(final T target) {
        return new Level0GenericUniqOperator<T>(Target.forObject(target));
    }

    
    public static <T> ILevel0GenericMultiOperator<T> onAll(final T... targets) {
        return new Level0GenericMultiOperator<T>(Target.forObject(VarArgsUtil.asRequiredObjectList(targets)));
    }

    
    public static ILevel0GenericMultiOperator<?> onAllObjs(final Object... targets) {
        return null;
    }

    
    public static <T> ILevel0GenericMultiOperator<T> onAll(final Type<T> of, final T... targets) {
        return null;
    }

    
    @SuppressWarnings("unchecked")
    public static <T> ILevel0ArrayOperator<T> onArray(final T[] target) {
        final Class<?> componentClass = 
            (target == null)? Object.class : target.getClass().getComponentType();
        return new Level0ArrayOperator<T>((Type<? super T>) Types.forClass(componentClass), Target.forObject(target));
    }

    
    @SuppressWarnings("unchecked")
    public static <T> ILevel0ArrayOfArrayOperator<T> onArrayOfArray(final T[][] target) {
        final Class<?> componentClass = 
            (target == null)? Object.class : target.getClass().getComponentType().getComponentType();
        return new Level0ArrayOfArrayOperator<T>((Type<? super T>) Types.forClass(componentClass), Target.forObject(target));
    }

    
    public static <T> ILevel0ArrayOfListOperator<T> onArrayOfList(final List<T>[] target) {
        return new Level0ArrayOfListOperator<T>(Target.forObject(target));
    }

    
    public static <K,V> ILevel0ArrayOfMapOperator<K,V> onArrayOfMap(final Map<K,V>[] target) {
        return new Level0ArrayOfMapOperator<K,V>(Target.forObject(target));
    }

    
    public static <T> ILevel0ArrayOfSetOperator<T> onArrayOfSet(final Set<T>[] target) {
        return new Level0ArrayOfSetOperator<T>(Target.forObject(target));
    }

    
    public static <T> ILevel0ListOperator<T> onList(final List<T> target) {
        return new Level0ListOperator<T>(Target.forObject(target));
    }

    
    public static <T> ILevel0ListOfArrayOperator<T> onListOfArray(final Type<T> of, final List<? extends T[]> target) {
        Validate.notNull(of, "Array component cannot be null");
        return new Level0ListOfArrayOperator<T>(of, Target.forObject(target));
    }

    
    public static <T> ILevel0ListOfListOperator<T> onListOfList(final List<? extends List<T>> target) {
        return new Level0ListOfListOperator<T>(Target.forObject(target));
    }

    
    public static <K,V> ILevel0ListOfMapOperator<K,V> onListOfMap(final List<? extends Map<K,V>> target) {
        return new Level0ListOfMapOperator<K,V>(Target.forObject(target));
    }

    
    public static <T> ILevel0ListOfSetOperator<T> onListOfSet(final List<? extends Set<T>> target) {
        return new Level0ListOfSetOperator<T>(Target.forObject(target));
    }

    
    public static <K,V> ILevel0MapOperator<K,V> onMap(final Map<K,V> target) {
        return new Level0MapOperator<K,V>(Target.forObject(target));
    }

    
    public static <K,V> ILevel0MapOfArrayOperator<K,V> onMapOfArray(final Type<V> of, final Map<K,V[]> target) {
        Validate.notNull(of, "Array component cannot be null");
        return new Level0MapOfArrayOperator<K,V>(of, Target.forObject(target));
    }

    
    public static <K,V> ILevel0MapOfListOperator<K,V> onMapOfList(final Map<K,? extends List<V>> target) {
        return new Level0MapOfListOperator<K,V>(Target.forObject(target));
    }

    
    public static <K1,K2,V> ILevel0MapOfMapOperator<K1,K2,V> onMapOfMap(final Map<K1,? extends Map<K2,V>> target) {
        return new Level0MapOfMapOperator<K1,K2,V>(Target.forObject(target));
    }

    
    public static <K,V> ILevel0MapOfSetOperator<K,V> onMapOfSet(final Map<K,? extends Set<V>> target) {
        return new Level0MapOfSetOperator<K,V>(Target.forObject(target));
    }

    
    public static <T> ILevel0SetOperator<T> onSet(final Set<T> target) {
        return new Level0SetOperator<T>(Target.forObject(target));
    }

    
    public static <T> ILevel0SetOfArrayOperator<T> onSetOfArray(final Type<T> of, final Set<? extends T[]> target) {
        Validate.notNull(of, "Array component cannot be null");
        return new Level0SetOfArrayOperator<T>(of, Target.forObject(target));
    }

    
    public static <T> ILevel0SetOfListOperator<T> onSetOfList(final Set<? extends List<T>> target) {
        return new Level0SetOfListOperator<T>(Target.forObject(target));
    }

    
    public static <K,V> ILevel0SetOfMapOperator<K,V> onSetOfMap(final Set<? extends Map<K,V>> target) {
        return new Level0SetOfMapOperator<K,V>(Target.forObject(target));
    }

    
    public static <T> ILevel0SetOfSetOperator<T> onSetOfSet(final Set<? extends Set<T>> target) {
        return new Level0SetOfSetOperator<T>(Target.forObject(target));
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> ILevel0ArrayOperator<T> buildArray(final Type<T> of) {
        return onArray((T[]) Array.newInstance(of.getRawClass(), 0));
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> ILevel0ArrayOfArrayOperator<T> buildArrayOfArray(final Type<T> of) {
        return onArrayOfArray((T[][]) Array.newInstance(Types.arrayOf(of).getRawClass(), 0));
    }
    
    @SuppressWarnings("unchecked")
    public static <T> ILevel0ArrayOfListOperator<T> buildArrayOfList(final Type<T> of) {
        return onArrayOfList((List<T>[]) Array.newInstance(Types.listOf(of).getRawClass(), 0));
    }
    
    @SuppressWarnings("unchecked")
    public static <K,V> ILevel0ArrayOfMapOperator<K,V> buildArrayOfMap(final Type<K> keyOf, final Type<V> valueOf) {
        return onArrayOfMap((Map<K,V>[]) Array.newInstance(Types.mapOf(keyOf,valueOf).getRawClass(), 0));
    }
    
    @SuppressWarnings("unchecked")
    public static <T> ILevel0ArrayOfSetOperator<T> buildArrayOfSet(final Type<T> of) {
        return onArrayOfSet((Set<T>[]) Array.newInstance(Types.setOf(of).getRawClass(), 0));
    }

    
    public static <T> ILevel0ListOperator<T> buildList(final Type<T> of) {
        return onList(new ArrayList<T>());
    }
    
    
    public static <T> ILevel0ListOfArrayOperator<T> buildListOfArray(final Type<T> of) {
        return onListOfArray(of, new ArrayList<T[]>());
    }
    
    public static <T> ILevel0ListOfListOperator<T> buildListOfList(final Type<T> of) {
        return onListOfList(new ArrayList<List<T>>());
    }
    
    public static <K,V> ILevel0ListOfMapOperator<K,V> buildListOfMap(final Type<K> keyOf, final Type<V> valueOf) {
        return onListOfMap(new ArrayList<Map<K,V>>());
    }
    
    public static <T> ILevel0ListOfSetOperator<T> buildListOfSet(final Type<T> of) {
        return onListOfSet(new ArrayList<Set<T>>());
    }
    
    
    public static <T> ILevel0SetOperator<T> buildSet(final Type<T> of) {
        return onSet(new LinkedHashSet<T>());
    }
    
    
    public static <T> ILevel0SetOfArrayOperator<T> buildSetOfArray(final Type<T> of) {
        return onSetOfArray(of, new LinkedHashSet<T[]>());
    }
    
    public static <T> ILevel0SetOfListOperator<T> buildSetOfList(final Type<T> of) {
        return onSetOfList(new LinkedHashSet<List<T>>());
    }
    
    public static <K,V> ILevel0SetOfMapOperator<K,V> buildSetOfMap(final Type<K> keyOf, final Type<V> valueOf) {
        return onSetOfMap(new LinkedHashSet<Map<K,V>>());
    }
    
    public static <T> ILevel0SetOfSetOperator<T> buildSetOfSet(final Type<T> of) {
        return onSetOfSet(new LinkedHashSet<Set<T>>());
    }
    
    
    public static <K,V> ILevel0MapOperator<K,V> buildMap(final Type<K> keyOf, final Type<V> valueOf) {
        return onMap(new LinkedHashMap<K,V>());
    }
    
    
    public static <K,V> ILevel0MapOfArrayOperator<K,V> buildMapOfArray(final Type<K> keyOf, final Type<V> valueOf) {
        return onMapOfArray(valueOf, new LinkedHashMap<K,V[]>());
    }
    
    
    public static <K,V> ILevel0MapOfListOperator<K,V> buildMapOfList(final Type<K> keyOf, final Type<V> valueOf) {
        return onMapOfList(new LinkedHashMap<K,List<V>>());
    }
    
    
    public static <K1,K2,V> ILevel0MapOfMapOperator<K1,K2,V> buildMapOfMap(final Type<K1> key1Of, final Type<K2> key2Of, final Type<V> valueOf) {
        return onMapOfMap(new LinkedHashMap<K1,Map<K2,V>>());
    }
    
    
    public static <K,V> ILevel0MapOfSetOperator<K,V> buildMapOfSet(final Type<K> keyOf, final Type<V> valueOf) {
        return onMapOfSet(new LinkedHashMap<K,Set<V>>());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    public static void main(String[] args) {
        


        final String[] stringsArr1 = new String[] {"Hello", "Goodbye", null};
        final List<String> stringsList1 = Arrays.asList(stringsArr1);
        
        final String[][] stringsStrings1 = new String[][] { new String[] {"Hello!","Goodbye!"}, new String[]{"�Hola!","�Adi�s!"}};
        final List<String>[] stringsListStrings1 = (List<String>[]) new List<?>[] { Arrays.asList(new String[] {"Hello!","Goodbye!"}), Arrays.asList(new String[]{"�Hola!","�Adi�s!"})};
        final List<List<String>> stringsListStringsList1 = Arrays.asList(stringsListStrings1);
        
        final Map<String,String> map1 = new LinkedHashMap<String,String>();
        map1.put("es", "�Hola!");
        map1.put("en", "Hello!");
        map1.put("gl", "Ola!");
        map1.put("ca", "Hola!");
        
        final Map<String,String> map2 = new LinkedHashMap<String,String>();
        map2.put("es", "�Adi�s!");
        map2.put("en", "Goodbye!");
        map2.put("gl", "Ad�us!");
        map2.put("ca", "Ad�u!");
        map2.put("fr", "Adieu!");
        
        final Map<String,String>[] maps1 = (Map<String, String>[]) new Map<?,?>[] { map1, map2 };

        
        System.out.println(Op.onList(stringsList1).get());
        System.out.println(Op.onList(stringsList1).forEach().get());
        System.out.println(Op.onList(stringsList1).forEachNotNull().eval(Eval.stringExp("toUpperCase()")).get());
        
        
        System.out.println(Op.onArrayOfArray(stringsStrings1).forEach().forEach().eval(Eval.integerExp("length()")).get());
        
        System.out.println(Arrays.asList(Op.onArrayOfList(stringsListStrings1).forEach().forEach().eval(Eval.stringExp("toUpperCase()")).get()));

        System.out.println(Arrays.asList(Op.onArrayOfMap(maps1).forEachMatching("size() > 6").forEachEntry().onValue().eval(Eval.stringExp("toUpperCase()"))));
        
        System.out.println(Arrays.asList(Op.onArrayOfArray(stringsStrings1).forEach().forEachMatching("length() > 6").eval(Eval.stringExp("toUpperCase()")).get()[0]));
        
        System.out.println(Op.onListOfList(stringsListStringsList1).forEach().forEach().get());
        
        System.out.println(Op.onListOfList(stringsListStringsList1).forEach().forEach().callInteger("length").get());
        
        
        final BigDecimal bd = new BigDecimal("3455234.6325");
        final Float f = Float.valueOf(3455234.6325f);
        final Double d = Double.valueOf(3455234.6325);
        
        System.out.println(bd.doubleValue());
        System.out.println(f);
        System.out.println(d);
        
        System.out.println(Op.onList(Arrays.asList(new Integer[] {2,3,4,1,2,2,4,5,2,3,5,6,87,45,2,3,34,1})).get());
        System.out.println(Op.onList(Arrays.asList(new Integer[] {2,3,4,1,2,2,4,5,2,3,5,6,87,45,2,3,34,1})).distinct().get());
        
        final List<List<String>> listOfListOfString1 = 
        	Arrays.asList((List<String>[]) new List<?>[] { Arrays.asList(new String[] {"a", "b", "a"}), Arrays.asList(new String[] {"a", "b", "a"})});
        
        final Set<Set<String>> setOfsetOfString1 = 
            new LinkedHashSet<Set<String>>(Arrays.asList((Set<String>[]) new Set<?>[] { new LinkedHashSet<String>(Arrays.asList(new String[] {"a", "b", "a"})), new LinkedHashSet<String>(Arrays.asList(new String[] {"a", "b", "a"}))}));
        
        final String[][] arrayOfArrayOfString1 = 
        	new String[][] { new String[] {"a", "b", "a"}, new String[] {"a", "b", "a"}};
        
        System.out.println(Op.onListOfList(listOfListOfString1).get());
        System.out.println(Op.onListOfList(listOfListOfString1).distinct().get());
        System.out.println(Op.onListOfList(listOfListOfString1).forEach().distinct().get());
        
        System.out.println(printArray(Op.onArrayOfArray(arrayOfArrayOfString1).get()));
        System.out.println(printArray(Op.onArrayOfArray(arrayOfArrayOfString1).distinct().get()));
        System.out.println(printArray(Op.onArrayOfArray(arrayOfArrayOfString1).forEach().distinct().get()));
     
        System.out.println(Op.onList(stringsList1).add("World!", "Mars!").get());
        System.out.println(Op.onList(stringsList1).insert(1, "World!", "Mars!").get());
        System.out.println(Op.onList(stringsList1).addAll(stringsList1).get());
        System.out.println(Op.onList(stringsList1).get());
        System.out.println(Op.onList(stringsList1).removeIndexes(0,2).get());
        System.out.println(Op.onList(stringsList1).removeIndexesNot(0).get());
        System.out.println(Op.onList(stringsList1).removeIndexesNot(0,2).get());
        System.out.println(Op.onList(stringsList1).removeMatching("#target eq 'Hello'").get());
        System.out.println(Op.onList(stringsList1).removeSelected(new ISelect<String>() {

			public boolean eval(String target) {
				return target == null;
			}
        	
        }).get());
        System.out.println(Op.onList(stringsList1).removeNulls().get());
        System.out.println(Op.onList(stringsList1).removeNotNullMatching("length() > 5").get());
            
        System.out.println("================");
        
        
        final Set<String> stringSet1 = new LinkedHashSet<String>(stringsList1);
        System.out.println(Op.onSet(stringSet1).add("World!", "Mars!").get());
        System.out.println(Op.onSet(stringSet1).insert(1, "World!", "Mars!").get());
        System.out.println(Op.onSet(stringSet1).addAll(stringsList1).get());
        System.out.println("---");
        System.out.println(Op.onSet(stringSet1).get());
        System.out.println(Op.onSet(stringSet1).removeIndexes(0,2).get());
        System.out.println(Op.onSet(stringSet1).removeIndexesNot(0).get());
        System.out.println(Op.onSet(stringSet1).removeIndexesNot(0,2).get());
        System.out.println(Op.onSet(stringSet1).removeMatching("#target eq 'Hello'").get());
        System.out.println(Op.onSet(stringSet1).removeSelected(new ISelect<String>() {

            public boolean eval(String target) {
                return target == null;
            }
            
        }).get());
        System.out.println(Op.onSet(stringSet1).removeNulls().get());
        System.out.println(Op.onSet(stringSet1).removeNotNullMatching("length() > 5").get());
            
        System.out.println(printArray(Op.onArray(stringsArr1).insert(2,"lalero","lururu").get()));
     
        
        System.out.println(Op.onMap(map1).put("fr", "All�!").get());
        System.out.println(Op.onMap(map1).insert(0,"fr", "All�!").get());
        System.out.println(Op.onMap(map1).insert(2,"fr", "All�!").get());
        System.out.println(Op.onMap(map2).get());
        System.out.println(Op.onMap(map2).putAll(Op.onMap(map1).insert(0,"gl", "Meuuuu!").get()).get());
        System.out.println(Op.onMap(map2).putAll(Op.onMap(map1).insert(0,"gl", "Meuuuu!").get()).removeMatching("!#target.key.startsWith('e')").get());
        
        System.out.println(printArray(Op.onArrayOfMap(maps1).get()));
        
        System.out.println(Op.onAll(234,12,231));
        System.out.println(Op.on(234).add(10));
        System.out.println(Op.on(234).insert(0,10));
        System.out.println(Op.on(234).add(10).insert(1,3));
        System.out.println(Op.on(234).add(10).insert(1,3).add((Integer)null));
        System.out.println(Op.on(234).add(10).insert(1,3).add((Integer)null).removeNulls());
        System.out.println(Op.on(234).add(10).insert(1,3).removeIndexesNot(1));
        System.out.println(Op.on(234).add(10).insert(1,3).removeMatching("#target > 100"));
        System.out.println(printArray(Op.on(234).add(10).insert(1,3).removeMatching("#target > 100").buildArray(Types.INTEGER).get()));
        System.out.println(printArray(Op.on(234).buildArray(Types.INTEGER).add(8).get()));
        System.out.println(Op.on(null).add(123));
        System.out.println(Op.on(null).buildList().get());
        System.out.println(Op.on(null).buildSet().get());
        System.out.println(printArray(Op.on((String)null).buildArray(Types.STRING).add("a").removeNulls().removeIndexes(0).get()));
        
        System.out.println(printArray(Op.buildArrayOfArray(Types.STRING).add(Op.buildArray(Types.STRING).add("a","b").get()).add(Op.buildArray(Types.STRING).add("1","2","3").get()).get()));
        System.out.println(Op.buildMap(Types.INTEGER,Types.STRING).put(12,"hello!").get());
        System.out.println(Op.onAll("a",1,"b",3).buildMap().get());
        System.out.println(Op.onAll("hello", "goodbye").buildMap(Eval.integerExp("length()")).get());
        
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildMapOfSet(Eval.integerExp("length()")).get());
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildMapOfList(Eval.integerExp("length()")).get());
        
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildMapOfArray(Types.STRING, Eval.integerExp("length()")).get());
        
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildList().sort().get());
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildSet().sort(new Comparator<String>() {

			public int compare(String o1, String o2) {
				if (o1.length() < o2.length()) {
					return -1;
				} else if (o1.length() == o2.length()) {
					return 0;
				}
				return 1;
			}
        	
        }).get());
        
        System.out.println(printArray(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildArray(Types.STRING).sort().get()));
        System.out.println(printArray(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildArray(Types.STRING).sort(new Comparator<String>() {

			public int compare(String o1, String o2) {
				if (o1.length() < o2.length()) {
					return -1;
				} else if (o1.length() == o2.length()) {
					return 0;
				}
				return 1;
			}
        	
        }).get()));
        
        
        System.out.println(Op.on("12314123.4123").exec(new ToInteger.FromString(RoundingMode.CEILING, DecimalPoint.IS_POINT)).get());
        System.out.println(Op.on("12314123.4123").exec(ToInteger.fromString(RoundingMode.CEILING, DecimalPoint.IS_POINT)).get());
        System.out.println(Op.on("12314123").exec(ToInteger.fromString()).get());
        System.out.println(Op.on("12314123").exec(ToLong.fromString()).get());
        System.out.println(Op.on("12314123").exec(ToBigInteger.fromString()).get());
        System.out.println(Op.on("12314123.4123").exec(ToDouble.fromString()).get());
        System.out.println(Op.on("12314123.4123").exec(ToDouble.fromString(3, RoundingMode.CEILING)).get());
        System.out.println(Op.on("12314123.4123").exec(ToBigDecimal.fromString(3, RoundingMode.CEILING)).get());
        
        final SimpleDateFormat dateFormat = new SimpleDateFormat();
        System.out.println(dateFormat.format(Op.on(Calendar.getInstance()).exec(new ToCalendar.FromCalendar(Calendar.DATE)).get().getTime()));
        
        System.out.println(dateFormat.format(Op.on("25/nov/1979").exec(ToCalendar.fromString("dd/MMM/yyyy", "es")).get().getTime()));
        
//        System.out.println(dateFormat.format(Op.onAll(1979, 11, 25, 12, 30).buildList().exec(ToCalendar.fromString("dd/MMM/yyyy", "es")).get().getTime()));
        System.out.println(dateFormat.format(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildList().get()).exec(ToCalendar.fromIntegerFieldList()).get().getTime()));
        System.out.println(dateFormat.format(Op.on(Op.onAll("1979", "11", "25", "12", "30").buildArray(Types.STRING).get()).exec(ToCalendar.fromStringFieldArray()).get().getTime()));
        
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildList().get()).exec(new ListFunc.Sort<Integer>()).get());
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildSet().get()).exec(new SetFunc.Sort<Integer>()).get());
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildList().get()).exec(new ListFunc.Distinct<Integer>()).get());
        
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildArray(Types.INTEGER).get()).exec(new ArrayFunc.Sort<Integer>()).get()));
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildArray(Types.INTEGER).get()).exec(new ArrayFunc.Distinct<Integer>()).get()));
        
        
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildList().get()).exec(new ListFunc.Insert<Integer>(2, 1492)).get());
        
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildList().get()).exec(new ListFunc.Insert<Integer>(2, 1492)).exec(new ListFunc.RemoveMatching<Integer>(Eval.booleanExp("#target < 1000"))).exec(new ListFunc.Sort<Integer>()).get());
        
        
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildArray(Types.INTEGER).get()).exec(new ArrayFunc.Insert<Integer>(2, 1492)).get()));
        
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildArray(Types.INTEGER).get()).exec(new ArrayFunc.Insert<Integer>(2, 1492)).exec(new ArrayFunc.RemoveMatching<Integer>(Eval.booleanExp("#target < 1000"))).exec(new ArrayFunc.Sort<Integer>()).get()));
        
        System.out.println(Op.on(Op.onAll("hello", "hola", "ciao", "ola", "ol�", "hall�", "hallo", "hej").buildArray(Types.STRING).get()).exec(new ToMap.FromArrayByKeyEval<Integer,String>(Eval.integerExp("length()"))).get());

        final Map<Integer,String[]> greetingsByLength = 
        	Op.on(Op.onAll("hello", "hola", "ciao", "ola", "ol�", "hall�", "hallo", "hej").buildArray(Types.STRING).get()).exec(new ToMapOfArray.FromArrayByKeyEval<Integer, String>(Types.STRING, Eval.integerExp("length()"))).get();
        System.out.println("*** MAP: ");
        for (Map.Entry<Integer,String[]> entry : greetingsByLength.entrySet()) {
        	System.out.println(entry.getKey() + " : " + Arrays.asList(entry.getValue()));
        }
        System.out.println("***");


        System.out.println(Op.on("hello").add("goodbye"));
        System.out.println(Op.on("hello").buildList().get());
        System.out.println(printArray(Op.on("hello").buildArray(Types.STRING).get()));
        System.out.println(Op.on("hello").buildMap(Eval.integerExp("length()")).get());
        System.out.println(Op.on("hello").buildMapOfList(Eval.integerExp("length()")).get());
        System.out.println(Op.onAll(12, "hello", 14, "goodbye").buildMapOfList().get());
        
        
        System.out.println(Op.buildList(Types.CALENDAR)
            	.add(Calendar.getInstance(), Calendar.getInstance())
            	.forEach().exec(ToString.fromCalendar(DateStyle.FULL, TimeStyle.NONE, Locale.UK)).get());
        
        System.out.println(Op.buildList(Types.CALENDAR)
            	.add(Calendar.getInstance(), Calendar.getInstance())
            	.forEach().exec(ToString.fromCalendar(DateStyle.FULL, TimeStyle.SHORT, Locale.UK)).get());
        
        System.out.println(Op.buildList(Types.CALENDAR)
            	.add(Calendar.getInstance(), Calendar.getInstance())
            	.forEach().exec(ToString.fromCalendar("dd-MMM-yyyy", Locale.UK)).get());
            
        System.out.println(Op.buildList(Types.CALENDAR)
            	.add(Calendar.getInstance(), Calendar.getInstance())
            	.forEach().exec(ToString.fromCalendar("dd-MMMM-yyyy")).get());
        
        System.out.println(Op.buildList(Types.DATE)
            	.add(new java.sql.Date(Calendar.getInstance().getTimeInMillis()))
            	.forEach().exec(ToString.fromDate("dd-MMM-yyyy", Locale.UK)).get());
        
        
        System.out.println(Op.buildList(Types.STRING)
            	.add("  Company ", " day ")
            	.forEach().exec(StringFunc.trim()).get());
        System.out.println(Op.buildList(Types.STRING)
            	.add("  Company ", " day ")
            	.forEach().exec(StringFunc.trim()).exec(StringFunc.toUpperCase()).get());
        
        System.out.println(Op.on("Dublin")
            	.exec(StringFunc.toHexadecimal(Charset.forName("ISO-8859-1")))
            	.exec(StringFunc.fromHexadecimal(Charset.forName("ISO-8859-1"))).get());
        
        System.out.println(Op.buildList(Types.NUMBER)
                .add(45.9, new BigDecimal(34.456))
                .forEach().exec(ToString.fromCurrency(Locale.getDefault(), 
                        1, 2, 10, true)).get());
        System.out.println(Op.buildList(Types.NUMBER)
                .add(45.9, 45, new BigDecimal(34.456))
                .forEach().exec(ToString.fromCurrency(Locale.getDefault(), 
                        1, 0, 0, true)).get());
        
        System.out.println(Op.buildList(Types.NUMBER)
                .add(45.9, 45, new BigDecimal(34.456), 0, 0.5, 0.211)
                .forEach().exec(ToString.fromPercent(Locale.getDefault(), 
                        1, 0, 10, ',', '\'', false)).get());
     
        
        System.out.println(Op.onArray(stringsArr1).toSet().get());
        System.out.println(printArray(Op.onArrayOfList(stringsListStrings1).forEach().toSet().get()));
        System.out.println(printArray(Op.onArrayOfList(stringsListStrings1).toArrayOfArray(Types.STRING).get()));
        
        final List<String[]> listOfStringArray1 = new ArrayList<String[]>();
        listOfStringArray1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildArray(Types.STRING).get());
        listOfStringArray1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Ad�us").buildArray(Types.STRING).get());
        
        final List<Set<String>> listOfStringSet1 = new ArrayList<Set<String>>();
        listOfStringSet1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildSet().get());
        listOfStringSet1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Ad�us").buildSet().get());
        
        final Set<String[]> setOfStringArray1 = new LinkedHashSet<String[]>();
        setOfStringArray1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildArray(Types.STRING).get());
        setOfStringArray1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Ad�us").buildArray(Types.STRING).get());
        
        final Set<List<String>> setOfStringList1 = new LinkedHashSet<List<String>>();
        setOfStringList1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildList().get());
        setOfStringList1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Ad�us").buildList().get());
        
        final Set<Set<String>> setOfStringSet1 = new LinkedHashSet<Set<String>>();
        setOfStringSet1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildSet().get());
        setOfStringSet1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Ad�us").buildSet().get());
        
        System.out.println(printArray(Op.onListOfArray(Types.STRING, listOfStringArray1).toArrayOfArray(Types.STRING).get()));
        System.out.println(printArray(Op.onListOfList(listOfListOfString1).toArrayOfArray(Types.STRING).get()));
        System.out.println(printArray(Op.onListOfSet(listOfStringSet1).toArrayOfArray(Types.STRING).get()));
        
        System.out.println(printArray(Op.onSetOfArray(Types.STRING, setOfStringArray1).toArrayOfArray(Types.STRING).get()));
        System.out.println(printArray(Op.onSetOfList(setOfStringList1).toArrayOfArray(Types.STRING).get()));
        System.out.println(printArray(Op.onSetOfSet(setOfStringSet1).toArrayOfArray(Types.STRING).get()));

        
        System.out.println(printArray(Op.onArrayOfArray(arrayOfArrayOfString1).toArrayOfList().get()));
        System.out.println(printArray(Op.onListOfArray(Types.STRING, listOfStringArray1).toArrayOfList().get()));
        System.out.println(printArray(Op.onListOfList(listOfListOfString1).toArrayOfList().get()));
        
        System.out.println(Op.on("http://www.google.es/search?q=op4j&unusedParam=unusedValue '' 2^2 ")
            	.exec(StringFunc.escapeJavaScript()).get());
        System.out.println(Op.on("Body tag is written like \"<body>content here</body>\"")
            	.exec(StringFunc.escapeHTML()).get());
        
        System.out.println(Op.onArray(stringsArr1).removeNulls().toMap(Eval.integerExp("length()")).get());

        System.out.println(Op.onList(stringsList1).removeNullOrMatching("length() < 6").get());

        System.out.println(printArray(Op.onArrayOfMap(maps1).forEach().extractKeys().get()));
        System.out.println(printArray(Op.onArrayOfMap(maps1).forEach().extractValues().get()));
        
    }
    
    
    private static String printArray(Object[] array) {
    	final List<Object> components = new ArrayList<Object>();
    	for (final Object component : array) {
    		if (component instanceof Object[]) {
    			components.add(printArray((Object[])component));
    		} else {
    			components.add(component);
    		}
    	}
    	return components.toString();
    }
    
}
