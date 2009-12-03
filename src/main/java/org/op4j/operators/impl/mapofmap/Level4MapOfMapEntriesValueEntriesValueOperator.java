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
import java.util.Date;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
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

    
    
    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> convert(final IConverter<X, ? super V> converter) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X>(getTarget().execute(converter));
    }    
    
    

    public ILevel3MapOfMapEntriesValueEntriesOperator<K1, K2, V> endOn() {
        return new Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X>(getTarget().execute(eval));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, ?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> exec(final IFunction<X, ? super V> function) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X>(getTarget().execute(function));
    }


    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> of(final Type<X> of) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X>(getTarget());
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, ?> raw() {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, V>(getTarget());
    }


    public Map<K1, Map<K2, V>> get() {
        return endOn().endFor().endOn().endFor().get();
    }

}
