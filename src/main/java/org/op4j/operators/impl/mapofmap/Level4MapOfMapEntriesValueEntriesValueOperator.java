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
package org.op4j.operators.impl.mapofmap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Map;

import org.op4j.IOf;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IConv;
import org.op4j.executables.IEval;
import org.op4j.executables.IExec;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.mapofmap.ILevel3MapOfMapEntriesValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.ILevel4MapOfMapEntriesValueEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level4MapOfMapEntriesValueEntriesValueOperator<K1,K2,V> extends Operator
        implements ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,V> {

    
    public Level4MapOfMapEntriesValueEntriesValueOperator(final Target target) {
        super(target);
    }


    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> call(final ICall<X, ? super V> call) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X>(getTarget().execute(call));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Byte>(getTarget().execute(Call.aByteMethod(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Short>(getTarget().execute(Call.aShortMethod(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Integer>(getTarget().execute(Call.aIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Long>(getTarget().execute(Call.aLongMethod(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Float>(getTarget().execute(Call.aFloatMethod(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Double>(getTarget().execute(Call.aDoubleMethod(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigInteger>(getTarget().execute(Call.aBigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigDecimal>(getTarget().execute(Call.aBigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Boolean>(getTarget().execute(Call.aBooleanMethod(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Calendar>(getTarget().execute(Call.aCalendarMethod(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, String> callString(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, String>(getTarget().execute(Call.aStringMethod(methodName, optionalParameters)));
    }




    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> conv(
            IConv<X, ? super V> conv) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigDecimal> convToBigDecimal(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigInteger> convToBigInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Boolean> convToBoolean(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Byte> convToByte(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Calendar> convToCalendar(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Double> convToDouble(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Float> convToFloat(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Integer> convToInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Long> convToLong(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Short> convToShort(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, String> convToString(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfMapEntriesValueEntriesOperator<K1, K2, V> endOn() {
        return new Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> eval(final IEval<X, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X>(getTarget().execute(eval));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigDecimal>(getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigInteger>(getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Boolean>(getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Byte>(getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Calendar>(getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Double>(getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Float>(getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Integer>(getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Long>(getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Short>(getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, String> evalString(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, String>(getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }


    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> exec(final IExec<X, ? super V> exec) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X>(getTarget().execute(exec));
    }


    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> of(
            IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> of(
            Class<X> classOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public Map<K1, Map<K2, V>> get() {
        return endOn().endFor().endOn().endFor().get();
    }

}
