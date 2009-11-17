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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.functions.FunctionArgumentScheme;
import org.op4j.executables.functions.FunctionArguments;
import org.op4j.executables.functions.FunctionImplementation;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class ArrayDistinctFunction<T> extends FunctionImplementation<T[], T[]> {

	public static final String NAME = BuiltinNaming.getBuiltinFunctionName(Types.ARRAY_OF_OBJECT, BuiltinNaming.OPERATION_NAME_DISTINCT); 
	
	
    private static final FunctionArgumentScheme SCH_ARRAY = 
        FunctionArgumentScheme.from(
            "It returns an array containing only the non-repeated elements.",
            Types.ARRAY_OF_OBJECT);

    
    
    public ArrayDistinctFunction() {
    	super();
    }
	
	
    
	@Override
	protected String registerFunctionName() {
		return NAME;
	}

	@Override
	protected Set<FunctionArgumentScheme> registerMatchedSchemes() {
        final Set<FunctionArgumentScheme> matched = new LinkedHashSet<FunctionArgumentScheme>();
        matched.add(SCH_ARRAY);
        return matched;
	}

	
	
	@Override
	protected Type<? super T[]> registerResultType() {
		return Types.ARRAY_OF_OBJECT;
	}

	@Override
	protected Type<? super T[]> registerTargetType() {
		return Types.ARRAY_OF_OBJECT;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] execute(FunctionArguments arguments) throws Exception {
		
		if (arguments.isTargetNull()) {
			throw new NullPointerException("Cannot execute operation on null target");
		}
		
		if (SCH_ARRAY.matches(arguments)) {
			
			final T[] array = (T[]) arguments.getTarget();
            final Class<?> arrayClass = array.getClass().getComponentType();
            
            Set<?> set = null;
            if (!arrayClass.isArray()) {
				set = new LinkedHashSet<T>(Arrays.asList(array));
			} else {
			    set = new ArrayLinkedHashSet<Object>();
	            ((ArrayLinkedHashSet<Object>)set).addAll(Arrays.asList((Object[][])array));
			}
			
            final T[] newArray = (T[]) Array.newInstance(arrayClass, new int[] {set.size()});
            return set.toArray(newArray);
				
		}
		
		
		return null;
	}

	
	
	
	private static class ArrayLinkedHashSet<T> extends LinkedHashSet<T[]> {

        private static final long serialVersionUID = 4483418737509306962L;

        
        
        public ArrayLinkedHashSet() {
            super();
        }
        

        @Override
        public boolean add(T[] e) {
            if (contains(e)) {
                return false;
            }
            return super.add(e);
        }

		@Override
        @SuppressWarnings("unchecked")
        public boolean contains(Object o) {
            final Iterator<T[]> it = iterator();
            while (it.hasNext()) {
                if (Arrays.equals(it.next(), (T[])o)) {
                    return true;
                }
            }
            return false;
        }
        
	}
	

}
