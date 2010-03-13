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

package org.op4j;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.time.StopWatch;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.junit.Test;
import org.op4j.functions.Call;
import org.op4j.functions.DecimalPoint;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.FnArray;
import org.op4j.functions.FnCalendar;
import org.op4j.functions.FnList;
import org.op4j.functions.FnMath;
import org.op4j.functions.FnNumber;
import org.op4j.functions.FnObject;
import org.op4j.functions.FnReduce;
import org.op4j.functions.FnSet;
import org.op4j.functions.FnString;
import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.functions.Ognl;
import org.op4j.functions.Reductor;
import org.op4j.util.ValuePair;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class MiscTest {

    
    
    
    @Test
    public void test() {
        
        
final StopWatch watch = new StopWatch();
watch.start();
        


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
        System.out.println(Op.onList(stringsList1).forEach().ifNotNull().exec(Ognl.asString("toUpperCase()")).get());
        
        
        
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
     
        System.out.println(Op.onList(stringsList1).addAll("World!", "Mars!").get());
        System.out.println(Op.onList(stringsList1).insertAll(1, "World!", "Mars!").get());
        System.out.println(Op.onList(stringsList1).addAll(stringsList1).get());
        System.out.println(Op.onList(stringsList1).get());
        System.out.println(Op.onList(stringsList1).removeAllIndexes(0,2).get());
        System.out.println(Op.onList(stringsList1).removeAllIndexesNot(0).get());
        System.out.println(Op.onList(stringsList1).removeAllIndexesNot(0,2).get());
        System.out.println(Op.onList(stringsList1).removeAllTrue(Ognl.asBoolean("#target eq 'Hello'")).get());
        System.out.println(Op.onList(stringsList1).removeAllTrue(new IFunction<String,Boolean>() {

            public Boolean execute(String target, final ExecCtx ctx) {
                return Boolean.valueOf(target == null);
            }
            
        }).get());
        System.out.println(Op.onList(stringsList1).removeAllNull().get());
        System.out.println(Op.onList(stringsList1).removeAllNotNullAndTrue(Ognl.asBoolean("length() > 5")).get());
            
        System.out.println("================");
        
        
        final Set<String> stringSet1 = new LinkedHashSet<String>(stringsList1);
        System.out.println(Op.onSet(stringSet1).addAll("World!", "Mars!").get());
        System.out.println(Op.onSet(stringSet1).insertAll(1, "World!", "Mars!").get());
        System.out.println(Op.onSet(stringSet1).addAll(stringsList1).get());
        System.out.println("---");
        System.out.println(Op.onSet(stringSet1).get());
        System.out.println(Op.onSet(stringSet1).removeAllIndexes(0,2).get());
        System.out.println(Op.onSet(stringSet1).removeAllIndexesNot(0).get());
        System.out.println(Op.onSet(stringSet1).removeAllIndexesNot(0,2).get());
        System.out.println(Op.onSet(stringSet1).removeAllTrue(Ognl.asBoolean("#target eq 'Hello'")).get());
        System.out.println(Op.onSet(stringSet1).removeAllNull().get());
        System.out.println(Op.onSet(stringSet1).removeAllNotNullAndTrue(Ognl.asBoolean("length() > 5")).get());
            
        System.out.println(printArray(Op.onArrayOf(Types.STRING, stringsArr1).insertAll(2,"lalero","lururu").get()));
     
        
        System.out.println(Op.onMap(map1).put("fr", "All�!").get());
        System.out.println(Op.onMap(map1).insert(0,"fr", "All�!").get());
        System.out.println(Op.onMap(map1).insert(2,"fr", "All�!").get());
        System.out.println(Op.onMap(map2).get());
        System.out.println(Op.onMap(map2).putAll(Op.onMap(map1).insert(0,"gl", "Meuuuu!").get()).get());
        System.out.println(Op.onMap(map2).putAll(Op.onMap(map1).insert(0,"gl", "Meuuuu!").get()).removeAllTrue(Ognl.asBoolean("!#target.key.startsWith('e')")).get());
        
        System.out.println(Op.onAll(234,12,231));
        System.out.println(Op.on(234).addAll(10));
        System.out.println(Op.on(234).insert(0,10));
        System.out.println(Op.on(234).addAll(10).insert(1,3));
        System.out.println(Op.on(234).addAll(10).insert(1,3).addAll((Integer)null));
        System.out.println(Op.on(234).addAll(10).insert(1,3).addAll((Integer)null).removeAllNull());
        System.out.println(Op.on(234).addAll(10).insert(1,3).removeAllIndexesNot(1));
        System.out.println(Op.on(234).addAll(10).insert(1,3).removeAllTrue(Ognl.asBoolean("#target > 100")));
        System.out.println(printArray(Op.on(234).addAll(10).insert(1,3).removeAllTrue(Ognl.asBoolean("#target > 100")).buildArrayOf(Types.INTEGER).get()));
        System.out.println(printArray(Op.on(234).buildArrayOf(Types.INTEGER).addAll(8).get()));
        System.out.println(Op.on((List)null).addAll(123));
        System.out.println(Op.on((Object)null).buildList().get());
        System.out.println(Op.on((Object)null).buildSet().get());
        System.out.println(printArray(Op.on((String)null).buildArrayOf(Types.STRING).addAll("a").removeAllNull().removeAllIndexes(0).get()));
        
//        System.out.println(printArray(Op.buildArrayOfArray(Types.STRING).addAll(Op.buildArray(Types.STRING).addAll("a","b").get()).addAll(Op.buildArray(Types.STRING).addAll("1","2","3").get()).get()));
//        System.out.println(Op.buildMap(Types.INTEGER,Types.STRING).put(12,"hello!").get());
        System.out.println(Op.onAll("a",1,"b",3).buildMapByAlternateElements().get());
        System.out.println(Op.onAll("hello", "goodbye").buildMapByKeyEval(Ognl.asInteger("length()")).get());
        
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildMapOfSetByKeyEval(Ognl.asInteger("length()")).get());
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildMapOfListByKeyEval(Ognl.asInteger("length()")).get());
        
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildMapOfArrayByKeyEvalOf(Types.STRING, Ognl.asInteger("length()")).get());
        
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
        
        System.out.println(printArray(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildArrayOf(Types.STRING).sort().get()));
        System.out.println(printArray(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildArrayOf(Types.STRING).sort(new Comparator<String>() {

            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() == o2.length()) {
                    return 0;
                }
                return 1;
            }
            
        }).get()));
        
        
        System.out.println(Op.on("12314123.4123").exec(FnString.toInteger(RoundingMode.CEILING, DecimalPoint.IS_POINT)).get());
        System.out.println(Op.on("12314123.4123").exec(FnString.toInteger(RoundingMode.CEILING, DecimalPoint.IS_POINT)).get());
        System.out.println(Op.on("12314123").exec(FnString.toInteger()).get());
        System.out.println(Op.on("12314123").exec(FnString.toLong()).get());
        System.out.println(Op.on("12314123").exec(FnString.toBigInteger()).get());
        System.out.println(Op.on("12314123.4123").exec(FnString.toDouble()).get());
        System.out.println(Op.on("12314123.4123").exec(FnString.toDouble(3, RoundingMode.CEILING)).get());
        System.out.println(Op.on("12314123.4123").exec(FnString.toBigDecimal(3, RoundingMode.CEILING)).get());
        
        final SimpleDateFormat dateFormat = new SimpleDateFormat();
        System.out.println(dateFormat.format(Op.on(Calendar.getInstance()).exec(FnCalendar.truncate(Calendar.DATE)).get().getTime()));
        
        System.out.println(dateFormat.format(Op.on("25/nov/1979").exec(FnString.toCalendar("dd/MMM/yyyy", "es")).get().getTime()));
        
//        System.out.println(dateFormat.format(Op.onAll(1979, 11, 25, 12, 30).buildList().exec(ToCalendar.fromString("dd/MMM/yyyy", "es")).get().getTime()));
        System.out.println(dateFormat.format(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildList().get()).exec(FnCalendar.fieldIntegerListToCalendar()).get().getTime()));
        System.out.println(dateFormat.format(Op.on(Op.onAll("1979", "11", "25", "12", "30").buildArrayOf(Types.STRING).get()).exec(FnCalendar.fieldStringArrayToCalendar()).get().getTime()));
        
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildList().get()).exec(FnList.ofInteger().sort()).get());
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildSet().get()).exec(FnSet.ofInteger().sort()).get());
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildList().get()).exec(FnList.ofInteger().distinct()).get());
        
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildArrayOf(Types.INTEGER).get()).exec(FnArray.ofInteger().sort()).get()));
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildArrayOf(Types.INTEGER).get()).exec(FnArray.ofInteger().distinct()).get()));
        
        
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildList().get()).exec(FnList.ofInteger().insert(2, 1492)).get());
        
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildList().get()).exec(FnList.ofInteger().insert(2, 1492)).exec(FnList.ofInteger().removeAllTrue(Ognl.asBoolean("#target < 1000"))).exec(FnList.ofInteger().sort()).get());
        
        
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildArrayOf(Types.INTEGER).get()).exec(FnArray.ofInteger().insert(2, 1492)).get()));
        
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildArrayOf(Types.INTEGER).get()).exec(FnArray.ofInteger().insert(2, 1492)).exec(FnArray.ofInteger().removeAllTrue(Ognl.asBoolean("#target < 1000"))).exec(FnArray.ofInteger().sort()).get()));
        
        System.out.println(Op.on(Op.onAll("hello", "hola", "ciao", "ola", "ol�", "hall�", "hallo", "hej").buildArrayOf(Types.STRING).get()).exec(FnArray.of(Types.STRING).toMapByKeyEval(Ognl.asInteger("length()"))).get());

        final Map<Integer,String[]> greetingsByLength = 
            Op.on(Op.onAll("hello", "hola", "ciao", "ola", "ol�", "hall�", "hallo", "hej").buildArrayOf(Types.STRING).get()).exec(FnArray.of(Types.STRING).toMapOfArrayByKeyEval(Ognl.asInteger("length()"))).get();
        System.out.println("*** MAP: ");
        for (Map.Entry<Integer,String[]> entry : greetingsByLength.entrySet()) {
            System.out.println(entry.getKey() + " : " + Arrays.asList(entry.getValue()));
        }
        System.out.println("***");


        System.out.println(Op.on("hello").addAll("goodbye"));
        System.out.println(Op.on("hello").buildList().get());
        System.out.println(printArray(Op.on("hello").buildArrayOf(Types.STRING).get()));
        System.out.println(Op.on("hello").buildMapByKeyEval(Ognl.asInteger("length()")).get());
        System.out.println(Op.on("hello").buildMapOfListByKeyEval(Ognl.asInteger("length()")).get());
        System.out.println(Op.onAll(12, "hello", 14, "goodbye").buildMapOfListByAlternateElements().get());
        
        
//        System.out.println(Op.buildList(Types.CALENDAR)
//              .addAll(Calendar.getInstance(), Calendar.getInstance())
//              .forEach().exec(ToString.fromCalendar(DateStyle.FULL, TimeStyle.NONE, Locale.UK)).get());
//        
//        System.out.println(Op.buildList(Types.CALENDAR)
//              .addAll(Calendar.getInstance(), Calendar.getInstance())
//              .forEach().exec(ToString.fromCalendar(DateStyle.FULL, TimeStyle.SHORT, Locale.UK)).get());
//        
//        System.out.println(Op.buildList(Types.CALENDAR)
//              .addAll(Calendar.getInstance(), Calendar.getInstance())
//              .forEach().exec(ToString.fromCalendar("dd-MMM-yyyy", Locale.UK)).get());
//            
//        System.out.println(Op.buildList(Types.CALENDAR)
//              .addAll(Calendar.getInstance(), Calendar.getInstance())
//              .forEach().exec(ToString.fromCalendar("dd-MMMM-yyyy")).get());
//        
//        System.out.println(Op.buildList(Types.DATE)
//              .addAll(new java.sql.Date(Calendar.getInstance().getTimeInMillis()))
//              .forEach().exec(ToString.fromDate("dd-MMM-yyyy", Locale.UK)).get());
//        
//        
//        System.out.println(Op.buildList(Types.STRING)
//              .addAll("  Company ", " day ")
//              .forEach().exec(StringFuncs.trim()).get());
//        System.out.println(Op.buildList(Types.STRING)
//              .addAll("  Company ", " day ")
//              .forEach().exec(StringFuncs.trim()).exec(StringFuncs.toUpperCase()).get());
        
        System.out.println(Op.on("Dublin")
                .exec(FnString.toHexadecimal(Charset.forName("ISO-8859-1")))
                .exec(FnString.fromHexadecimal(Charset.forName("ISO-8859-1"))).get());
        
//        System.out.println(Op.buildList(Types.NUMBER)
//                .addAll(45.9, new BigDecimal(34.456))
//                .forEach().exec(ToString.fromCurrency(Locale.getDefault(), 
//                        1, 2, 10, true)).get());
//        System.out.println(Op.buildList(Types.NUMBER)
//                .addAll(45.9, 45, new BigDecimal(34.456))
//                .forEach().exec(ToString.fromCurrency(Locale.getDefault(), 
//                        1, 0, 0, true)).get());
//        
//        System.out.println(Op.buildList(Types.NUMBER)
//                .addAll(45.9, 45, new BigDecimal(34.456), 0, 0.5, 0.211)
//                .forEach().exec(ToString.fromPercent(Locale.getDefault(), 
//                        1, 0, 10, ',', '\'', false)).get());
     
        
        System.out.println(Op.onArrayOf(Types.STRING, stringsArr1).toSet().get());
        
        final List<String[]> listOfStringArray1 = new ArrayList<String[]>();
        listOfStringArray1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildArrayOf(Types.STRING).get());
        listOfStringArray1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Ad�us").buildArrayOf(Types.STRING).get());
        
        final List<Set<String>> listOfStringSet1 = new ArrayList<Set<String>>();
        listOfStringSet1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildSet().get());
        listOfStringSet1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Ad�us").buildSet().get());
        
        final Set<String[]> setOfStringArray1 = new LinkedHashSet<String[]>();
        setOfStringArray1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildArrayOf(Types.STRING).get());
        setOfStringArray1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Ad�us").buildArrayOf(Types.STRING).get());
        
        final Set<List<String>> setOfStringList1 = new LinkedHashSet<List<String>>();
        setOfStringList1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildList().get());
        setOfStringList1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Ad�us").buildList().get());
        
        final Set<Set<String>> setOfStringSet1 = new LinkedHashSet<Set<String>>();
        setOfStringSet1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildSet().get());
        setOfStringSet1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Ad�us").buildSet().get());
        
        System.out.println(Op.on("http://www.google.es/search?q=op4j&unusedParam=unusedValue '' 2^2 ")
                .exec(FnString.escapeJavaScript()).get());
        System.out.println(Op.on("Body tag is written like \"<body>content here</body>\"")
                .exec(FnString.escapeHTML()).get());
        
        System.out.println(Op.onArrayOf(Types.STRING, stringsArr1).removeAllNull().toMapByKeyEval(Ognl.asInteger("length()")).get());

        System.out.println(Op.onList(stringsList1).removeAllNullOrTrue(Ognl.asBoolean("length() < 6")).get());

        System.out.println("***___****___****");
        System.out.println(Op.onList(stringsList1).forEach().ifNotNull().exec(FnString.toUpperCase()).get());
        System.out.println("***___****___****");
        
        System.out.println(Op.onAll("hello", "goodbye").exec(Ognl.asString("#target + ' world!'")).getAsList());
        
        System.out.println(Op.onList(listOfListOfString1).get());
        
        
//        System.out.println(Op.onMap(map1).forEachEntry().exec(Ognl.forString("'in ' + #target.key + ' you say ' + #target.value")).get());
        
        
        
        System.out.println(Op.onList(stringsList1).removeAllNull().sort().get());
        System.out.println(Op.onList(stringsList1).removeAllNull().forEach().exec(Ognl.asInteger("length()")).get());
        
        System.out.println(Op.on(maps1).exec(Ognl.asInteger("length")).get());
        System.out.println(printArray(Op.onArrayOf(Types.MAP_OF_STRING_STRING, maps1).forEach().exec(Types.INTEGER, Ognl.asInteger("size()")).get()));

//        final List<Map<String,String>> listOfMapOfStringString1 = 
//          Op.buildList(Types.MAP_OF_STRING_STRING).add(map1).add(map2).get();
//        
//        System.out.println(printArray(Op.onListOfMap(listOfMapOfStringString1).toArrayOfMap().get()));
    
        System.out.println(Op.onMap(map1).forEachEntry().exec(Ognl.asString("'<<KEY: ' + #target.key + ' | VALUE: ' + #target.value + '>>'")).get());
        
        System.out.println(Types.LIST_ITERATOR_OF_BOOLEAN.getSimpleName());
        
        
        System.out.println(Op.onList(stringsList1).get());
        System.out.println(Op.onList(stringsList1).forEach().replaceWith("op4j is great!").get());
        System.out.println(Op.onList(stringsList1).forEach().replaceIfNullWith("op4j is great!").get());
        System.out.println(printArray(Op.onArrayOf(Types.STRING, stringsArr1).forEach().replaceIfNullWith("op4j is great!").get()));
        System.out.println(printArray(Op.onArrayOf(Types.STRING, stringsArr1).replaceWith(new String[] {"alpha", "beta"}).forEach().exec(FnString.toUpperCase()).get()));
        
        
//        System.out.println(Op.buildListOfList(Types.STRING).add(stringsList1).add(stringsList1).get());
//        System.out.println(Op.buildListOfList(Types.STRING).addAll(stringsList1, stringsList1).get());


        Op.on(Integer.valueOf(12)).exec(FnObject.toSingletonArrayOf(Types.INTEGER)).get();
        
        watch.stop();
        
        System.out.println("TIME: " + watch.toString());
        
        
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");

        
        List<String> list = Arrays.asList(new String[] { "12/10/1492", "6/12/1978", "15/07/2045", null });
        
        Set<String> set1 = new LinkedHashSet<String>(list);
        Set<String> set2 = Op.on(list).toSet().get();

        System.out.println("set1 : " + set1);
        System.out.println("set2 : " + set2);

        Set<Calendar> set3 = 
            Op.on(list).toSet().forEach().exec(FnString.toCalendar("dd/MM/yyyy")).get();

        System.out.println("set3asStr : " + Op.on(set3).map(FnCalendar.toStr("EEEE dd MMMM yyyy")).get());
        
        Set<Calendar> set4 = 
            Op.on(list).toSet().removeAllNull().forEach().exec(FnString.toCalendar("dd/MM/yyyy")).get();
        
        System.out.println("set4asStr : " + Op.on(set4).map(FnCalendar.toStr("EEEE dd MMMM yyyy", new Locale("en"))).get());

        Set<Calendar> set5 = 
            Op.on(list).toSet().removeAllNull().map(FnString.toCalendar("dd/MM/yyyy")).get();
        
        System.out.println("set5asStr : " + Op.on(set5).map(FnCalendar.toStr("EEEE dd MMMM yyyy", new Locale("en"))).get());
     
        Calendar now = Calendar.getInstance();
        Set<Calendar> set6 = 
            Op.on(list).toSet().map(FnString.toCalendar("dd/MM/yyyy")).removeAllNullOrTrue(FnCalendar.after(now)).get();
        
        System.out.println("set6asStr : " + Op.on(set6).map(FnCalendar.toStr("EEEE dd MMMM yyyy HH:mm:ss", new Locale("en"))).get());

        
        // ****************************
        // WARNING: Non-op4j code!!
        // ****************************
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        Set<Calendar> set = new LinkedHashSet<Calendar>();
        for (String element : list) {
          if (element != null) {
              Date date = null;
              try {
                  date = dateFormat1.parse(element);
              } catch (ParseException e) {
                  throw new RuntimeException(e);
              }
              Calendar calendar = Calendar.getInstance();
              calendar.setTimeInMillis(date.getTime());
              if (!calendar.after(now)) {
                  set.add(calendar);
              }
          }
        }

        
        System.out.println("setasStr : " + Op.on(set).map(FnCalendar.toStr("EEEE dd MMMM yyyy HH:mm:ss", new Locale("en"))).get());
        

        Function<List<String>,Set<Calendar>> conversionFunction = 
            Fn.onListOf(Types.STRING).toSet().map(FnString.toCalendar("dd/MM/yyyy")).removeAllNullOrTrue(FnCalendar.after(now)).get();

        System.out.println("setFnasStr : " + Op.on(conversionFunction.execute(list)).map(FnCalendar.toStr("EEEE dd MMMM yyyy HH:mm:ss", new Locale("en"))).get());
     
        
        int[] v1 = new int[] {3,2,1,3};
        long[] v2 = new long[] {3,2,1,3};
        
        Op.on(1).get();
        List<Integer> iL = Op.onAll(2,1,4,213).buildList().get();
        System.out.println(iL);
        
        System.out.println(Arrays.asList(Op.on(v1).forEach().exec(FnMath.ofInteger().add(Integer.valueOf(10))).get()));
        
        Op.on(v2).forEach().get();
        
        
        Op.on(123).exec(new IFunction<Integer,String>() {
            public String execute(Integer input, ExecCtx ctx) throws Exception {
                return "The input number is: " + input;
            }
        }).get();
        
        
        Reductor<String,Integer,String> redFn1 = new Reductor<String,Integer,String>() {

            @Override
            protected String reduce(final String left, final Integer right, final ExecCtx ctx) throws Exception {
                return left + "(" + right + ")";
            }
            
        };
        
        System.out.println(Op.onAll(12,3,41,22).buildArrayOf(Types.INTEGER).reduce(FnReduce.ofInteger().max()).get());
        
        System.out.println(Op.onAll("hello", "hola", "ola", "ciao").buildArrayOf(Types.STRING).reduce(FnReduce.ofString().join("%")).get());
        
        System.out.println(Op.onAll("hello", "hola", "ola", "ciao").buildArrayOf(Types.STRING).reduce(FnReduce.ofString().join("%"), "---").get());
        
        System.out.println(Op.onAll(1,2,3,4,5,6).buildArrayOf(Types.INTEGER).reduce(redFn1, "-->").get());
        
        System.out.println(Op.onAll(1,2,3,4,5,6).reduce(redFn1, "-->").get());
        System.out.println(Op.on(1).reduce(redFn1, "-->").get());
        
        
        System.out.println(Arrays.asList(Op.on(2).exec(FnNumber.toBigInteger()).unfoldArrayOf(Types.BIG_INTEGER, FnMath.ofBigInteger().multiplyBy(BigInteger.valueOf(2)), Ognl.asBoolean("#index < 10")).get()));

        Function<Class,List<Class>> fnImplemented = 
            Fn.on(Types.forClass(Class.class)).unfoldList(
                    Call.asType(Types.forClass(Class.class), "getSuperclass")).get();
                    
        System.out.println(fnImplemented.execute(String.class));
        System.out.println(fnImplemented.execute(Integer.class));
        System.out.println(fnImplemented.execute(Serializable[].class));
        
        
        IFunction<ValuePair<Number,Number>,BigDecimal> fnSumBigDecimal =
            new IFunction<ValuePair<Number,Number>,BigDecimal>() {

                public BigDecimal execute(final ValuePair<Number, Number> input, final ExecCtx ctx) throws Exception {
                    final Number left = input.getLeft();
                    final Number right = input.getRight();
                    if (left == null && right == null) {
                        return null;
                    }
                    if (left == null) {
                        if (right instanceof BigDecimal) {
                            return (BigDecimal) right;
                        }
                        if (right instanceof BigInteger) {
                            return new BigDecimal((BigInteger)right);
                        }
                        return BigDecimal.valueOf(right.doubleValue());
                    }
                    if (right == null) {
                        if (left instanceof BigDecimal) {
                            return (BigDecimal) left;
                        }
                        if (left instanceof BigInteger) {
                            return new BigDecimal((BigInteger)left);
                        }
                        return BigDecimal.valueOf(left.doubleValue());
                    }
                    return BigDecimal.valueOf(left.doubleValue()).add(BigDecimal.valueOf(right.doubleValue()));
                }
            
            };
        
        
        System.out.println(Op.onAll(213,23,142).reduce(fnSumBigDecimal, BigDecimal.valueOf(0)).get());
     
        System.out.println(Op.onAll(213,23,142).reduce(FnReduce.ofBigInteger().sum(), BigInteger.valueOf(0)).get());
        System.out.println(Op.onAll(213,23,142).exec(FnNumber.toBigDecimal()).reduce(FnReduce.ofBigDecimal().sum()).get());
        
    
        System.out.println(ValuePair.TYPE_VALUE_PAIR_OF_UNKNOWN);
        System.out.println(ValuePair.TYPE_VALUE_PAIR_OF(Types.STRING, Types.CALENDAR));
        
        
        System.out.println(Op.on(23.24).exec(FnMath.ofDouble().add(43)).get());
        
        System.out.println(Op.on(BigDecimal.valueOf(23.24)).exec(FnMath.ofBigDecimal().add(1.2)).get());
        
        System.out.println(Op.onAll(30,30,40).exec(FnNumber.toBigInteger()).buildList().exec(FnMath.ofBigInteger().avg(RoundingMode.CEILING)).get());
        
        System.out.println(Op.on(10).exec(FnMath.ofInteger().divideBy(3,RoundingMode.CEILING)).get());
        System.out.println(Op.onAll(10,3).reduce(FnReduce.ofInteger().div(RoundingMode.CEILING)).get());
        
    }
    
    
    
    
    private static String printArray(Object[] array) {
        if (array == null) {
            return null;
        }
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
