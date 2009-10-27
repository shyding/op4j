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
package org.op4j.exceptions;

import java.util.List;

import org.apache.commons.lang.exception.NestableRuntimeException;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class MethodInvocationException 
        extends NestableRuntimeException {

	
	private static final long serialVersionUID = -3061625112500997810L;

	
	public MethodInvocationException(final String methodName, final Class<?> objectClass, 
			final List<Class<?>> parameterClasses, final Exception e) {
        super("Could not invoke method " + methodName +
                " on object of class " + objectClass.getName() +
                " with parameters of classes: " + parameterClasses, e);
    }
	
	public MethodInvocationException(final String methodName, final Class<?> objectClass, 
			final List<Class<?>> parameterClasses) {
        super("Could not invoke method " + methodName +
                " on object of class " + objectClass.getName() +
                " with parameters of classes: " + parameterClasses);
    }
	
	public MethodInvocationException(final String methodName, final Class<?> objectClass, 
			final List<Class<?>> parameterClasses, final Class<?> resultClass) {
        super("Invocation of method " + methodName +
                " on object of class " + objectClass.getName() +
                " with parameters of classes: " + parameterClasses + 
                " did not return a result compatible with " + resultClass);
    }

    
}
