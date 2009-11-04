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
package org.op4j.operators.impl.set;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.op4j.Of;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
import org.op4j.executables.functions.conversion.IConv;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.set.ILevel1SetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1SetElementsOperator<T> extends Operator
        implements ILevel1SetElementsOperator<T>  {

    
    public Level1SetElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel1SetElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level1SetElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel1SetElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Byte>(getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Short>(getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Integer>(getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Long>(getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Float>(getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Double>(getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<BigInteger>(getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<BigDecimal>(getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Boolean>(getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Calendar>(getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<String>(getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Character> callCharacter(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Character>(getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Number> callNumber(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Number>(getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Date> callDate(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Date>(getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public <X> ILevel1SetElementsOperator<X> conv(IConv<X, ? super T> conv) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetElementsOperator<BigDecimal> convToBigDecimal(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetElementsOperator<BigInteger> convToBigInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetElementsOperator<Boolean> convToBoolean(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetElementsOperator<Byte> convToByte(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetElementsOperator<Calendar> convToCalendar(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetElementsOperator<Double> convToDouble(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetElementsOperator<Float> convToFloat(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetElementsOperator<Integer> convToInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetElementsOperator<Long> convToLong(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetElementsOperator<Short> convToShort(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetElementsOperator<String> convToString(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel1SetElementsOperator<Character> convToCharacter(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel1SetElementsOperator<Number> convToNumber(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel1SetElementsOperator<Date> convToDate(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> endFor() {
        return new Level0SetOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> ILevel1SetElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level1SetElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel1SetElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level1SetElementsOperator<BigDecimal>(getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel1SetElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level1SetElementsOperator<BigInteger>(getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Boolean>(getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Byte>(getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Calendar>(getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Double>(getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Float>(getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Integer>(getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Long>(getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Short>(getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel1SetElementsOperator<String> evalString(final String evalExpression, final Object... parameters) {
        return new Level1SetElementsOperator<String>(getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel1SetElementsOperator<Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Character>(getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel1SetElementsOperator<Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Number>(getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel1SetElementsOperator<Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Date>(getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel1SetElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level1SetElementsOperator<X>(getTarget().execute(exec));
    }


    public <X> ILevel1SetElementsOperator<X> of(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1SetElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public Set<T> get() {
        return endFor().get();
    }

}
