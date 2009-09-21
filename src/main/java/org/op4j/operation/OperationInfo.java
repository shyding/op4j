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
package org.op4j.operation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.op4j.typescheme.TypeScheme;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class OperationInfo {
    
    private final String operationName;
    private final TypeScheme resultTypeScheme;
    private final Map<String,Set<ArgumentsTypeScheme>> matchedArgumentTypeSchemeSetsByOperationDefClassName;
    private final Set<ArgumentsTypeScheme> matchedArgumentTypeSchemeAggregateSet;
    
    
    OperationInfo(final OperationRegistryInfo operationRegistryInfo) {
        
        this.operationName = operationRegistryInfo.getOperationName();
        this.resultTypeScheme = operationRegistryInfo.getResultTypeScheme();
        this.matchedArgumentTypeSchemeSetsByOperationDefClassName = 
            Collections.unmodifiableMap(
                    operationRegistryInfo.getMatchedArgumentTypeSchemeSetsByOperationDefClassName());
        
        final Set<ArgumentsTypeScheme> tempMatchedArgumentTypeSchemeAggregateSet = new HashSet<ArgumentsTypeScheme>();
        for (Set<ArgumentsTypeScheme> typeSchemesSet : 
                this.matchedArgumentTypeSchemeSetsByOperationDefClassName.values()) {
            tempMatchedArgumentTypeSchemeAggregateSet.addAll(typeSchemesSet);
        }
        this.matchedArgumentTypeSchemeAggregateSet =
            Collections.unmodifiableSet(tempMatchedArgumentTypeSchemeAggregateSet);
    }
    
    
    public String getOperationName() {
        return this.operationName;
    }
    
    
    public TypeScheme getResultTypeScheme() {
        return this.resultTypeScheme;
    }

    
    public Set<ArgumentsTypeScheme> getMatchedArgumentTypeSchemeSetByOperationDefClassName(final String className) {
        Validate.notNull(className, "Class name cannot be null");
        return this.matchedArgumentTypeSchemeSetsByOperationDefClassName.get(className);
    }

    
    public Map<String,Set<ArgumentsTypeScheme>> getMatchedArgumentTypeSchemeSetsByOperationDefClassName() {
        return this.matchedArgumentTypeSchemeSetsByOperationDefClassName;
    }

    
    public Set<ArgumentsTypeScheme> getMatchedArgumentTypeSchemeAggregateSet() {
        return this.matchedArgumentTypeSchemeAggregateSet;
    }
    
    
    @Override
    public String toString() {
        return this.resultTypeScheme + " " + this.operationName + 
                " " + this.matchedArgumentTypeSchemeAggregateSet;
        
    }
    
}
