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
package org.op4j.operators.intf.list;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
import org.op4j.operators.qualities.ICastableToOneLevelStructuresOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.INavigatingCollectionOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel1ListElementsOperator<T> 
		extends IUniqOperator<List<T>>,
                ICastableToOneLevelStructuresOperator,
                INavigatingCollectionOperator<T>,
                IConvertibleOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {

    
    public ILevel0ListOperator<T> endFor();
    
    public <X> ILevel1ListElementsOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> ILevel1ListElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public ILevel1ListElementsOperator<?> evalForObject(final String ognlExpression, final Object... optionalExpParams);
    public <X> ILevel1ListElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Short> evalForShort(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Long> evalForLong(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<String> evalForString(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Date> evalForDate(final String ognlExpression, final Object... optionalExpParams);


    public <X> ILevel1ListElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> ILevel1ListElementsOperator<X> of(final Type<X> of);
        
    public ILevel1ListElementsOperator<?> raw();
    
    
    
    public <X> ILevel1ListOfArrayElementsOperator<X> asArray(final Type<X> of);
    public <X> ILevel1ListOfListElementsOperator<X> asList(final Type<X> of);
    public <K,V> ILevel1ListOfMapElementsOperator<K,V> asMap(final Type<K> keyOf, final Type<V> valueOf);
    public <X> ILevel1ListOfSetElementsOperator<X> asSet(final Type<X> of);
    
                                    
}
