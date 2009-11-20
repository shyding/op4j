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

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.functions.IFunc;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public class StringFunc {

	private StringFunc() {
		super();           
	}

	public static final EscapeCSVStringFunc escapeCSV() {
        return new EscapeCSVStringFunc();
    }
	public static final UnescapeCSVStringFunc unescapeCSV() {
        return new UnescapeCSVStringFunc();
    }	

	public static final EscapeXMLStringFunc escapeXML() {
        return new EscapeXMLStringFunc();
    }
	public static final UnescapeXMLStringFunc unescapeXML() {
        return new UnescapeXMLStringFunc();
    }
	
	public static final EscapeHTMLStringFunc escapeHTML() {
        return new EscapeHTMLStringFunc();
    }
	public static final UnescapeHTMLStringFunc unescapeHTML() {
        return new UnescapeHTMLStringFunc();
    }
	
	public static final EscapeJavaScriptStringFunc escapeJavaScript() {
        return new EscapeJavaScriptStringFunc();
    }
	public static final UnescapeJavaScriptStringFunc unescapeJavaScript() {
        return new UnescapeJavaScriptStringFunc();
    }
	
	public static final ToBase64StringFunc toBase64(Charset charset) {
        return new ToBase64StringFunc(charset);
    }
	public static final FromBase64StringFunc fromBase64(Charset charset) {
        return new FromBase64StringFunc(charset);
    }
	
	public static final ToHexadecimalStringFunc toHexadecimal(Charset charset) {
        return new ToHexadecimalStringFunc(charset);
    }
	public static final FromHexadecimalStringFunc fromHexadecimal(Charset charset) {
        return new FromHexadecimalStringFunc(charset);
    }
	
	public static final ToUpperCaseStringFunc toUpperCase() {
        return new ToUpperCaseStringFunc();
    }
	public static final ToLowerCaseStringFunc toLowerCase() {
        return new ToLowerCaseStringFunc();
    }
	
	public static final UnCapitalizeStringFunc unCapitalize() {
        return new UnCapitalizeStringFunc();
    }
	public static final CapitalizeStringFunc capitalize() {
        return new CapitalizeStringFunc();
    }
	
	public static final TrimStringFunc trim() {
        return new TrimStringFunc();
    }
	
	public static final StripStringFunc strip() {
        return new StripStringFunc();
    }
	
	static abstract class BaseStringFunc<X> implements IFunc<String, X> {		
		public BaseStringFunc() {
			super();			
		}

		public Type<? super String> getResultType() {
			return Types.STRING;
		}
	}
	
	/**
	 * The String is returned in a way it can be used to fill in a CSV column as StringEscapeUtils does
	 *
	 */
	public static final class EscapeCSVStringFunc extends BaseStringFunc<String> {
		
		public EscapeCSVStringFunc() {
			super();
		}

		public String execute(final String input) throws Exception {
			return StringEscapeUtils.escapeCsv(input);
		}		
	}

	/**
	 * The String is returned without the escape characters used to
	 * include it in a CSV column (i.e. no quotes enclosing it, no escaped quotes) 
	 * as StringEscapeUtils does
	 *
	 */
	public static final class UnescapeCSVStringFunc extends BaseStringFunc<String> {
		public UnescapeCSVStringFunc() {
			super();
		}

		public String execute(final String input) throws Exception {
			return StringEscapeUtils.unescapeCsv(input);
		}		
	}

	/**
	 * The String is returned with the XML characters escaped as StringEscapeUtils does
	 *
	 */
	public static final class EscapeXMLStringFunc extends BaseStringFunc<String> {
		public EscapeXMLStringFunc() {
			super();
		}

		public String execute(final String input) throws Exception {
			return StringEscapeUtils.escapeXml(input);
		}		
	}

	/**
	 * The String is returned without the XML escape characters as StringEscapeUtils does
	 *
	 */
	public static final class UnescapeXMLStringFunc extends BaseStringFunc<String> {
		public UnescapeXMLStringFunc() {
			super();
		}

		public String execute(final String input) throws Exception {
			return StringEscapeUtils.unescapeXml(input);
		}		
	}

	/**
	 * It escapes the given String using HTML entities (as StringEscapeUtils does)
	 *
	 */
	public static final class EscapeHTMLStringFunc extends BaseStringFunc<String> {
		public EscapeHTMLStringFunc() {
			super();
		}

		public String execute(final String input) throws Exception {
			return StringEscapeUtils.escapeHtml(input);
		}		
	}

	/**
	 * It unescapes the given String and converts its HTML entity escapes into 
	 * their unicode characters (as StringEscapeUtils does)
	 *
	 */
	public static final class UnescapeHTMLStringFunc extends BaseStringFunc<String> {
		public UnescapeHTMLStringFunc() {
			super();
		}

		public String execute(final String input) throws Exception {
			return StringEscapeUtils.unescapeHtml(input);
		}		
	}

	/**
	 * It converts the given String into a JavaScript valid one (as StringEscapeUtils does)
	 *
	 */
	public static final class EscapeJavaScriptStringFunc extends BaseStringFunc<String> {
		public EscapeJavaScriptStringFunc() {
			super();
		}

		public String execute(final String input) throws Exception {
			return StringEscapeUtils.escapeJavaScript(input);
		}		
	}

	/**
	 * It unescapes the given JavaScript valid String (as StringEscapeUtils does)
	 *
	 */
	public static final class UnescapeJavaScriptStringFunc extends BaseStringFunc<String> {
		public UnescapeJavaScriptStringFunc() {
			super();
		}

		public String execute(final String input) throws Exception {
			return StringEscapeUtils.unescapeJavaScript(input);
		}		
	}

	/**
	 * It converts the given String into a base64 encoded one
	 *
	 */
	public static final class ToBase64StringFunc extends BaseStringFunc<String> {

		private Charset charset = null;

		public ToBase64StringFunc(Charset charset) {
			super();
			this.charset = charset;
		}

		public String execute(final String input) throws Exception {
			Validate.notNull(this.charset, "Charset can't be null");
			return new String(new Base64().encode(input.getBytes(
					this.charset.name())), "US-ASCII");
		}		
	}

	/**
	 * It decodes the given base64 encoded String
	 *
	 */
	public static final class FromBase64StringFunc extends BaseStringFunc<String> {

		private Charset charset = null;

		public FromBase64StringFunc(Charset charset) {
			super();
			this.charset = charset;
		}

		public String execute(final String input) throws Exception {
			Validate.notNull(this.charset, "Charset can't be null");
			return new String(new Base64().decode(input.getBytes("US-ASCII")), 
					this.charset.name()); 
		}		
	}

	/**
	 * It converts the given String into its Hexadecimal representation using the specified Charset
	 *
	 */
	public static final class ToHexadecimalStringFunc extends BaseStringFunc<String> {

		private Charset charset = null;

		public ToHexadecimalStringFunc(Charset charset) {
			super();
			this.charset = charset;
		}

		public String execute(final String input) throws Exception {
			Validate.notNull(this.charset, "Charset can't be null");

			final byte[] inputAsByteArray = input.getBytes(this.charset.name());
			final StringBuffer output = new StringBuffer();
			for (byte i = 0; i < inputAsByteArray.length; i++) {
				output.append(Integer.toHexString(inputAsByteArray[i]));
			}
			return output.toString();      
		}		
	}

	/**
	 * The given String is converted from its Hexadecimal representation to a String using the specified Charset
	 *
	 */
	public static final class FromHexadecimalStringFunc extends BaseStringFunc<String> {

		private Charset charset = null;

		public FromHexadecimalStringFunc(Charset charset) {
			super();
			this.charset = charset;
		}

		public String execute(final String input) throws Exception {
			Validate.notNull(this.charset, "Charset can't be null");

			final StringBuffer output = new StringBuffer();            
			for (int i = 0; i < input.length(); i = i + 2) {
				final byte current = 
					(byte) Integer.parseInt(String.valueOf(input.charAt(i))
							+ String.valueOf(input.charAt(i + 1)), 16);

				output.append(new String(new byte[] {current},
						this.charset.name()));
			}            
			return output.toString();       
		}		
	}

	/**
	 * It converts the given String to uppercase
	 *
	 */
	public static final class ToUpperCaseStringFunc extends BaseStringFunc<String> {

		public ToUpperCaseStringFunc() {
			super();			
		}

		public String execute(final String input) throws Exception {
			return StringUtils.upperCase(input);
		}		
	}
	
	/**
	 * It converts the given String to lowercase
	 *
	 */
	public static final class ToLowerCaseStringFunc extends BaseStringFunc<String> {

		public ToLowerCaseStringFunc() {
			super();			
		}

		public String execute(final String input) throws Exception {
			return StringUtils.lowerCase(input);
		}		
	}

	/**
	 * It converts the first letter of the given String to lowercase
	 *
	 */
	public static final class UnCapitalizeStringFunc extends BaseStringFunc<String> {

		public UnCapitalizeStringFunc() {
			super();			
		}

		public String execute(final String input) throws Exception {
			return StringUtils.uncapitalize(input);
		}		
	}
	/**
	 * It converts the first letter of the given String to uppercase
	 *
	 */
	public static final class CapitalizeStringFunc extends BaseStringFunc<String> {

		public CapitalizeStringFunc() {
			super();			
		}

		public String execute(final String input) throws Exception {
			return StringUtils.capitalize(input);
		}		
	}	

	/**
	 * Removes control characters (char <= 32) from both ends of the given String
	 *
	 */
	public static final class TrimStringFunc extends BaseStringFunc<String> {

		public TrimStringFunc() {
			super();			
		}

		public String execute(final String input) throws Exception {
			return StringUtils.trim(input);
		}		
	}	
	
	/**
	 * Strips whitespace from both sides of the given String
	 *
	 */
	public static final class StripStringFunc extends BaseStringFunc<String> {

		public StripStringFunc() {
			super();			
		}

		public String execute(final String input) throws Exception {
			return StringUtils.strip(input);
		}		
	}	
}
