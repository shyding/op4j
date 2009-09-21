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
package org.op4j.type;

/**
 * <p>
 * Represents a type parameter which contains an "extends" clause.
 * </p>
 * <p>
 * For example, the type <tt>List&lt;? extends Set&lt;String[]&gt;&gt;,
 * would have an <tt>ExtendsTypeParameter</tt>
 * containing the <tt>? extends Set&lt;String[]&gt;</tt> parameter.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class ExtendsTypeParameter extends TypeParameter {

    private static final long serialVersionUID = -3422656676188437147L;
    

    private final Type type;
    
    private final String stringRepresentation;
    
    private final int hashCode;
    
    
    
    private static String createStringRepresentation(final Type type) {
        return  "? extends " + type.getName();
    }
    
    
    ExtendsTypeParameter(final Type type) {
        super();
        this.type = type;
        this.stringRepresentation = createStringRepresentation(type);
        this.hashCode = this.stringRepresentation.hashCode();
    }


    @Override
    public Type getType() {
        return this.type;
    }


    @Override
    boolean isAssignableFrom(final TypeParameter typeParameter) {

        if (this.equals(typeParameter)) {
            return true;
        }
        if ((typeParameter instanceof WildcardTypeParameter) || 
            (typeParameter instanceof SuperTypeParameter)) {
            return false;
        } 
        return this.type.isAssignableFrom(typeParameter.getType());
        
    }

    

    @Override
    public int hashCode() {
        return this.hashCode;
    }


    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExtendsTypeParameter other = (ExtendsTypeParameter) obj;
        return this.stringRepresentation.equals(other.stringRepresentation);
    }


    @Override
    public String toString() {
        return this.stringRepresentation;
    }
    
    
    
}
