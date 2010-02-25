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

package org.op4j.target;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class Target {

    public static enum Structure { ARRAY, LIST, SET, MAP }

    public static enum CastType { 
        OBJECT,
        ARRAY, LIST, SET, MAP }

    
    
    
    protected Target() {
        super();
    }
    
    
    abstract Target doIterate(final Structure structure, final boolean excludeFirstIndex);
    abstract Target doOnKey();
    abstract Target doOnValue();
    abstract Target doEndOn();
    

    abstract Target doSelectIndex(final boolean desiredResult, final List<Integer> positions);
    abstract Target doSelectMapKeys(final boolean desiredResult, final List<Object> objects);
    abstract Target doSelectMatching(final boolean desiredResult, final IFunction<Object,Boolean> eval);
    abstract Target doSelectNull(final boolean desiredResult);
    abstract Target doSelectNullOrMatching(final boolean desiredResult, final IFunction<Object,Boolean> eval);
    abstract Target doSelectNotNullAndMatching(final boolean desiredResult, final IFunction<Object,Boolean> eval);

    abstract Target doCast(final CastType targetType, final Type<?>... types);
    
    abstract Target doMap(final Structure structure, final IFunction<?,?> executable, final Class<?> arrayComponentClass);
    abstract Target doMapIfNotNull(final Structure structure, final IFunction<?,?> executable, final Class<?> arrayComponentClass);

    
    
    public final Target map(final Structure structure, final IFunction<?,?> executable, final Class<?> arrayComponentClass) {
        Validate.notNull(executable, "Specified function cannot be null");
        return doMap(structure, executable, arrayComponentClass);
    }
    
    public final Target mapIfNotNull(final Structure structure, final IFunction<?,?> executable, final Class<?> arrayComponentClass) {
        Validate.notNull(executable, "Specified function cannot be null");
        return doMapIfNotNull(structure, executable, arrayComponentClass);
    }
    
    
    public final Target cast(final CastType targetType, final Type<?>... types) {
        // Types will be validated at the Cast operation
        return doCast(targetType, types);
    }
    
    public final Target iterate(final Structure structure) {
        return doIterate(structure, false);
    }
    
    public final Target iterate(final Structure structure, final boolean excludeFirstIndex) {
        return doIterate(structure, excludeFirstIndex);
    }
    
    public final Target onKey() {
        return doOnKey();
    }
    
    public final Target onValue() {
        return doOnValue();
    }
    
    
    public final Target endOn() {
        return doEndOn();
    }

    
    abstract Target doEndIterate(final Class<?> arrayComponentClass);

    
    public final Target endIterate(final Class<?> arrayComponentClass) {
        return doEndIterate(arrayComponentClass);
    }

    
    abstract Target doEndSelect();

    
    public final Target endSelect() {
        return doEndSelect();
    }
    
    
    public final Target selectIndex(final int... positions) {
    	return doSelectIndex(true, VarArgsUtil.asRequiredIntegerList(positions));
    }
    
    
    public final Target selectIndexNot(final int... positions) {
        return doSelectIndex(false, VarArgsUtil.asRequiredIntegerList(positions));
    }

    
    public final Target selectMapKeys(final Object... keys) {
    	return doSelectMapKeys(true, VarArgsUtil.asRequiredObjectList(keys));
    }

    
    public final Target selectMapKeysNot(final Object... objects) {
        return doSelectMapKeys(false, VarArgsUtil.asRequiredObjectList(objects));
    }
    
    
    @SuppressWarnings("unchecked")
    public final Target selectMatching(final IFunction<? extends Object,Boolean> eval) {
    	Validate.notNull(eval, "Specified evaluator cannot be null");
    	return doSelectMatching(true, (IFunction<Object,Boolean>) eval);
    }

    
    @SuppressWarnings("unchecked")
    public final Target selectNotMatching(final IFunction<? extends Object,Boolean> eval) {
        Validate.notNull(eval, "Specified evaluator cannot be null");
    	return doSelectMatching(false, (IFunction<Object,Boolean>) eval);
    }

    
    public final Target selectNull() {
        return doSelectNull(true);
    }

    
    public final Target selectNotNull() {
        return doSelectNull(false);
    }

    
    @SuppressWarnings("unchecked")
    public final Target selectNullOrMatching(final IFunction<? extends Object,Boolean> eval) {
        Validate.notNull(eval, "Specified evaluator cannot be null");
        return doSelectNullOrMatching(true, (IFunction<Object,Boolean>) eval);
    }

    
    @SuppressWarnings("unchecked")
    public final Target selectNullOrNotMatching(final IFunction<? extends Object,Boolean> eval) {
        Validate.notNull(eval, "Specified evaluator cannot be null");
        return doSelectNullOrMatching(false, (IFunction<Object,Boolean>) eval);
    }

    
    @SuppressWarnings("unchecked")
    public final Target selectNotNullAndMatching(final IFunction<? extends Object,Boolean> eval) {
        Validate.notNull(eval, "Specified evaluator cannot be null");
        return doSelectNotNullAndMatching(true, (IFunction<Object,Boolean>) eval);
    }

    
    @SuppressWarnings("unchecked")
    public final Target selectNotNullAndNotMatching(final IFunction<? extends Object,Boolean> eval) {
        Validate.notNull(eval, "Specified evaluator cannot be null");
        return doSelectNotNullAndMatching(false, (IFunction<Object,Boolean>) eval);
    }
    
    
    
    abstract Target doReplaceWith(final Object replacement, final Normalisation normalisation);
    

    public final Target replaceWith(final Object replacement, final Normalisation normalisation) {
        return doReplaceWith(replacement, normalisation);
    }
    
    
    abstract Target doExecute(final IFunction<?,?> executable, final Normalisation normalisation);
    abstract Target doExecuteIfNotNull(final IFunction<?,?> executable, final Normalisation normalisation);

    
    public final Target execute(final IFunction<?,?> executable) {
        Validate.notNull(executable, "Specified executable function cannot be null");
        return execute(executable, Normalisation.NONE);
    }

    public final Target execute(final IFunction<?,?> executable, final Normalisation normalisation) {
        Validate.notNull(executable, "Specified executable function cannot be null");
        return doExecute(executable, normalisation);
    }

    
    public final Target executeIfNotNull(final IFunction<?,?> executable, final Normalisation normalisation) {
        Validate.notNull(executable, "Specified executable function cannot be null");
        return doExecuteIfNotNull(executable, normalisation);
    }
    
    
    public abstract Object get();
    
    public abstract Object execute(final Object target);
    
    
    

    public static class Normalisation {

        static enum NormalisationType { 
            TYPE_NONE, 
            TYPE_ARRAY, TYPE_LIST, TYPE_SET, TYPE_MAP, TYPE_MAPENTRY }
    
        public static Normalisation NONE = new Normalisation(NormalisationType.TYPE_NONE, null);
        public static Normalisation LIST = new Normalisation(NormalisationType.TYPE_LIST, null);
        public static Normalisation SET = new Normalisation(NormalisationType.TYPE_SET, null);
        public static Normalisation MAP = new Normalisation(NormalisationType.TYPE_MAP, null);
        public static Normalisation MAP_ENTRY = new Normalisation(NormalisationType.TYPE_MAPENTRY, null);
    
        
            
            
        private final NormalisationType normalisationType;
        private final Class<?> arrayComponentClass;
        
        
        
        public static Normalisation ARRAY(final Class<?> arrayComponentClass) {
            return new Normalisation(NormalisationType.TYPE_ARRAY, arrayComponentClass);
        }
        
        
        private Normalisation(final NormalisationType normalisationType, final Class<?> arrayComponentClass) {
            super();
            this.normalisationType = normalisationType;
            this.arrayComponentClass = arrayComponentClass;
        }

        public NormalisationType getNormalisationType() {
            return this.normalisationType;
        }

        public Class<?> getArrayComponentClass() {
            return this.arrayComponentClass;
        }
        
    }
    
}
