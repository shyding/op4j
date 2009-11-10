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

package org.op4j.executables.functions.util;

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
public class ListModifyFunction extends FunctionImplementation<List<?>, List<?>> {

	public static final String NAME = UtilNaming.getUtilName(Types.LIST_OF_UNKNOWN, UtilNaming.OPERATION_NAME_MODIFY); 
	
	
    private static final FunctionArgumentScheme SCH_LIST_ELEMENTS_ADD = 
        FunctionArgumentScheme.from(
            "It adds the passed elements to the target list.",
            Types.LIST_OF_UNKNOWN,
            "List<?> newElements, 'ADD'");
    
    private static final FunctionArgumentScheme SCH_LIST_ELEMENTS_POSITION_ADD = 
        FunctionArgumentScheme.from(
            "It adds the passed elements to the target list in the specified position.",
            Types.LIST_OF_UNKNOWN,
            "List<?> newElements, Integer position, 'ADD'");
    
    private static final FunctionArgumentScheme SCH_LIST_ELEMENTS_REMOVE = 
        FunctionArgumentScheme.from(
            "It removes the passed elements from the target list.",
            Types.LIST_OF_UNKNOWN,
            "List<?> elements, 'REMOVE'");
    
    private static final FunctionArgumentScheme SCH_LIST_POSITIONS_REMOVE = 
        FunctionArgumentScheme.from(
            "It adds the passed elements to the target list in the specified position.",
            Types.LIST_OF_UNKNOWN,
            "Integer[] positions, 'REMOVE'");

    
    
    public ListModifyFunction() {
    	super();
    }
	
	
    
	@Override
	protected String registerFunctionName() {
		return NAME;
	}

	@Override
	protected Set<FunctionArgumentScheme> registerMatchedSchemes() {
        final Set<FunctionArgumentScheme> matched = new LinkedHashSet<FunctionArgumentScheme>();
        matched.add(SCH_LIST_ELEMENTS_ADD);
        matched.add(SCH_LIST_ELEMENTS_POSITION_ADD);
        matched.add(SCH_LIST_ELEMENTS_REMOVE);
        matched.add(SCH_LIST_POSITIONS_REMOVE);
        return matched;
	}

	
	
	@Override
	protected Type<List<?>> registerResultType() {
		return Types.LIST_OF_UNKNOWN;
	}

	@Override
	protected Type<List<?>> registerTargetType() {
		return Types.LIST_OF_UNKNOWN;
	}

	@Override
	public List<?> execute(FunctionArguments arguments) throws Exception {
		
		if (arguments.isTargetNull()) {
			return null;
		}
		
		if (SCH_LIST_ELEMENTS_ADD.matches(arguments)) {
			final List<?> list = (List<?>) arguments.getTarget();
			final List<?> newElements = (List<?>) arguments.getParameter(0);
			final List<Object> newList = new ArrayList<Object>(list);
			newList.addAll(newElements);
			return newList;
		}
        
        if (SCH_LIST_ELEMENTS_POSITION_ADD.matches(arguments)) {
            final List<?> list = (List<?>) arguments.getTarget();
            final List<?> newElements = (List<?>) arguments.getParameter(0);
            final Integer position = arguments.getIntegerParameter(1);
            final List<Object> newList = new ArrayList<Object>(list);
            newList.addAll(position.intValue(), newElements);
            return newList;
        }
        
        if (SCH_LIST_ELEMENTS_REMOVE.matches(arguments)) {
            final List<?> list = (List<?>) arguments.getTarget();
            final List<?> newElements = (List<?>) arguments.getParameter(0);
            final List<Object> newList = new ArrayList<Object>(list);
            newList.removeAll(newElements);
            return newList;
        }
        
        if (SCH_LIST_POSITIONS_REMOVE.matches(arguments)) {
            final List<?> list = (List<?>) arguments.getTarget();
            final Integer[] positions = (Integer[]) arguments.getParameter(0);
            final List<Object> newList = new ArrayList<Object>(list);
            for (final Integer position : positions) {
                newList.remove(position.intValue());
            }
            return newList;
        }
		
		return null;
	}

}
