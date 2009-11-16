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
import java.util.LinkedHashSet;
import java.util.List;
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
public final class GenericBuildListFunction extends FunctionImplementation<List<?>, Object> {

	public static final String NAME = BuiltinNaming.getBuiltinFunctionName(Types.OBJECT, BuiltinNaming.OPERATION_NAME_BUILD_LIST); 

    
    private static final FunctionArgumentScheme GEN_UNIQ_BUILD = 
        FunctionArgumentScheme.from(
            "It builds a list containing the target object.",
            Types.OBJECT,
            "'UNIQ_BUILD'");
    
    private static final FunctionArgumentScheme GEN_MULTI_BUILD = 
        FunctionArgumentScheme.from(
            "It builds a list containing all the target objects.",
            Types.LIST_OF_UNKNOWN,
            "'MULTI_BUILD'");
    

    
    
    
    public GenericBuildListFunction() {
    	super();
    }
	

    @Override
    protected Set<FunctionArgumentScheme> registerMatchedSchemes() {
        final Set<FunctionArgumentScheme> matched = new LinkedHashSet<FunctionArgumentScheme>();
        matched.add(GEN_UNIQ_BUILD);
        matched.add(GEN_MULTI_BUILD);
        return matched;
    }


    
	@Override
	protected String registerFunctionName() {
		return NAME;
	}
	
	
	@Override
	protected Type<List<?>> registerResultType() {
		return Types.LIST_OF_UNKNOWN;
	}

	
	@Override
	protected Type<Object> registerTargetType() {
		return Types.OBJECT;
	}
	
	

    @Override
    public List<?> execute(final FunctionArguments arguments) throws Exception {
        
        if (GEN_UNIQ_BUILD.matches(arguments)) {
            final Object target = arguments.getTarget();
            final List<Object> newList = new ArrayList<Object>();
            newList.add(target);
            return newList;
        }
        
        if (GEN_MULTI_BUILD.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
            final List<Object> newList = new ArrayList<Object>(target);
            return newList;
        }
        
        return null;
         
    }
	
	
	
}