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

package org.op4j.executables.functions.builtin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Types;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.IFunc;
import org.op4j.util.OgnlExpressionUtil;
import org.op4j.util.VarArgsUtil;


/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
class StructureFunc {

    
    
    
    private StructureFunc() {
        super();
    }

    
    
    
    
    static abstract class Sort<T extends Comparable<? super T>, X extends Collection<T>> implements IFunc<X, X> {

        private Comparator<T> comparator = null;

        public Sort() {
            super();
        }

        public Sort(final Comparator<T> comparator) {
            super();
            this.comparator = comparator;
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            if (this.comparator == null) {
                Collections.sort(result);
            } else {
                Collections.sort(result, this.comparator);
            }
            return fromList(result);
        }

        public abstract X fromList(final List<T> object);

    }

    

    
    static abstract class Add<T, X extends Collection<T>> implements IFunc<X,X> {

        private final List<T> newElements;
        
        public Add(final T... newElements) {
            super();
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            result.addAll(this.newElements);
            return fromList(result);
        }

        public abstract X fromList(final List<T> object);
        
    }

    
    
    static abstract class Insert<T, X extends Collection<T>> implements IFunc<X,X> {

        private final int position;
        private final List<T> newElements;
        
        public Insert(final int position, final T... newElements) {
            super();
            this.position = position;
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            result.addAll(this.position, this.newElements);
            return fromList(result);
        }

        public abstract X fromList(final List<T> object);
        
    }


    
    
    
    static abstract class AddAll<T, X extends Collection<T>> implements IFunc<X,X> {

        private final List<T> newElements;
        
        public AddAll(final Collection<T> collection) {
            super();
            this.newElements = new ArrayList<T>(collection);
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            result.addAll(this.newElements);
            return fromList(result);
        }

        public abstract X fromList(final List<T> object);
        
    }

    
    

    
    static abstract class RemovePositions<T, X extends Collection<T>> implements IFunc<X,X> {

        private final List<Integer> positions;
        
        public RemovePositions(final int... positions) {
            super();
            this.positions = VarArgsUtil.asRequiredIntegerList(positions);
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>();
            int i = 0;
            for (final T element : object) {
                if (!this.positions.contains(Integer.valueOf(i))) {
                    result.add(element);
                }
                i++;
            }
            return fromList(result);
        }

        public abstract X fromList(final List<T> object);
        
    }

    
    

    
    static abstract class RemoveValues<T, X extends Collection<T>> implements IFunc<X,X> {

        private final List<T> values;
        
        public RemoveValues(final T... values) {
            super();
            this.values = VarArgsUtil.asRequiredObjectList(values);
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            result.removeAll(this.values);
            return fromList(result);
        }

        public abstract X fromList(final List<T> object);
        
    }

    
    

    
    static abstract class RemoveMatching<T, X extends Collection<T>> implements IFunc<X,X> {

        private final String expression;
        private final List<Object> expParams;
        
        public RemoveMatching(final String expression, final Object... optionalExpParams) {
            super();
            this.expression = expression;
            this.expParams = VarArgsUtil.asOptionalObjectList(optionalExpParams);
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (!OgnlExpressionUtil.evalOgnlExpression(Types.BOOLEAN, this.expression, element, this.expParams).booleanValue()) {
                    result.add(element);
                }
            }
            return fromList(result);
        }

        public abstract X fromList(final List<T> object);
        
    }

    
    

    
    static abstract class RemoveSelected<T, X extends Collection<T>> implements IFunc<X,X> {

        private final ISelect<T> selector;
        
        public RemoveSelected(final ISelect<T> selector) {
            super();
            this.selector = selector;
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (!this.selector.eval(element)) {
                    result.add(element);
                }
            }
            return fromList(result);
        }

        public abstract X fromList(final List<T> object);
        
    }
    
    

    
    
    static abstract class RemoveAllExceptPositions<T, X extends Collection<T>> implements IFunc<X,X> {

        private final List<Integer> positions;
        
        public RemoveAllExceptPositions(final int... positions) {
            super();
            this.positions = VarArgsUtil.asRequiredIntegerList(positions);
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>();
            int i = 0;
            for (final T element : object) {
                if (this.positions.contains(Integer.valueOf(i))) {
                    result.add(element);
                }
                i++;
            }
            return fromList(result);
        }

        public abstract X fromList(final List<T> object);
        
    }

    

    
    
    static abstract class RemoveNulls<T, X extends Collection<T>> implements IFunc<X,X> {

        public RemoveNulls() {
            super();
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    result.add(element);
                }
            }
            return fromList(result);
        }

        public abstract X fromList(final List<T> object);
        
    }
    

    

    
    
    static abstract class RemoveNotNullsMatching<T, X extends Collection<T>> implements IFunc<X,X> {

        private final String expression;
        private final List<Object> expParams;
        
        public RemoveNotNullsMatching(final String expression, final Object... optionalExpParams) {
            super();
            this.expression = expression;
            this.expParams = VarArgsUtil.asOptionalObjectList(optionalExpParams);
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    if (!OgnlExpressionUtil.evalOgnlExpression(Types.BOOLEAN, this.expression, element, this.expParams).booleanValue()) {
                        result.add(element);
                    }
                } else {
                    result.add(element);
                }
            }
            return fromList(result);
        }

        public abstract X fromList(final List<T> object);
        
    }
    
    
}
