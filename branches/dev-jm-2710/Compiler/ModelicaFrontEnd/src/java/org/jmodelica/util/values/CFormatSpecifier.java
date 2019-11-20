package org.jmodelica.util.values;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.jmodelica.util.values.CFormatSpecifier.ValueType.*;

/**
 * Describes a printf-style format specifier, parsed and separated into fields.
 * 
 * For the fields with and precision, a negative value means that is was not given when 
 * constructing the specifier.
 */
public class CFormatSpecifier {

    public enum ValueType {
        REAL         ("g", "f", "e", "E", "G"), 
        INT          ("d", "i", "o", "x", "X"), 
        STRING       ("s"), 
        UNSIGNED_INT ("u"),
        CHAR         ("c");
        
        public final String defaultConversion;
        private final String[] conversions;
        
        private ValueType(String... conv) {
            defaultConversion = conv[0];
            conversions = conv;
        }

        public boolean isReal() {
            return this == REAL;
        }

        public boolean isInteger() {
            return this == INT || this == UNSIGNED_INT || this == CHAR;
        }

        public boolean isString() {
            return this == STRING;
        }

        public boolean isUnsigned() {
            return this == UNSIGNED_INT;
        }

        public boolean isChar() {
            return this == CHAR;
        }

        public static ValueType forConversion(String conversion) {
            for (ValueType v : values()) {
                for (String c : v.conversions) {
                    if (c.equals(conversion)) {
                        return v;
                    }
                }
            }
            return null;
        }
    }

    public final String format;
    public final String javaFormat;
    public final ValueType expectedType;
    public final boolean parsingFailed;
    public final boolean initialPercent;

    public final String flags;
    public final int width;
    public final int precision;
    public final String length;
    public final String conversion;

    private static final String SYNTAX_TAG        = "(%|)";
    private static final String SYNTAX_FLAGS      = "([-+ 0#]*)";
    private static final String SYNTAX_WIDTH      = "([1-9][0-9]*)?";
    private static final String SYNTAX_PRECISION  = "(\\.([1-9][0-9]*))?";
    private static final String SYNTAX_LENGTH     = "(hh|h|l|ll|L|z|j|t|)";
    private static final String SYNTAX_CONVERSION = "(d|i|u|f|e|E|g|G|x|X|o|c|s)";
    private static final String SYNTAX_REGEX = 
            SYNTAX_TAG + SYNTAX_FLAGS + SYNTAX_WIDTH + SYNTAX_PRECISION + SYNTAX_LENGTH + SYNTAX_CONVERSION;
    private static final Pattern SYNTAX = Pattern.compile(SYNTAX_REGEX);

    private CFormatSpecifier(String format) {
        this.format = format;
        Matcher matcher = SYNTAX.matcher(format);
        if (matcher.matches()) {
            String g = matcher.group(1);
            initialPercent = !g.isEmpty();
            g = matcher.group(2);
            flags = matcher.group(2);
            g = matcher.group(3);
            width = (g == null) ? -1 : Integer.parseInt(g);
            g = matcher.group(5);
            precision = (g == null) ? -1 : Integer.parseInt(g);
            length = matcher.group(6);
            conversion = matcher.group(7);
            expectedType = ValueType.forConversion(conversion);
            parsingFailed = false;
        } else {
            parsingFailed = true;
            initialPercent = false;
            flags = "";
            width = -1;
            precision = -1;
            length = "";
            conversion = "f";
            expectedType = REAL;
        }
        javaFormat = buildJavaFormat();
    }

    private CFormatSpecifier(
            boolean leftJustified, int minimumLength, int significantDigits, ValueType type) {
        flags = leftJustified ? "-" : "";
        width = minimumLength;
        precision = significantDigits;
        length = "";
        conversion = type.defaultConversion;
        javaFormat = buildJavaFormat();
        format = javaFormat.substring(1);
        expectedType = type;
        parsingFailed = false;
        initialPercent = false;
    }

    private String buildJavaFormat() {
        StringBuilder buf = new StringBuilder("%");
        buf.append(flags);
        if (width >= 0) {
            buf.append(width);
        }
        if (precision >= 0) {
            buf.append(".");
            buf.append(precision);
        }
        if (conversion.equals("i") || conversion.equals("u")) {
            buf.append("d");
        } else {
            buf.append(conversion);
        }
        return buf.toString();
    }

    public static CFormatSpecifier parseFormat(String format) {
        return new CFormatSpecifier(format);
    }

    /**
     * Build a format string from the "options" arguments of the String() operator, 
     * for an Integer argument.
     */
    public static CFormatSpecifier integerFormat(boolean leftJustified, int minimumLength) {
        return new CFormatSpecifier(leftJustified, minimumLength, -1, INT);
    }

    /**
     * Build a format string from the "options" arguments of the String() operator, 
     * for a Real argument.
     */
    public static CFormatSpecifier realFormat(boolean leftJustified, int minimumLength, int significantDigits) {
        return new CFormatSpecifier(leftJustified, minimumLength, significantDigits, REAL);
    }

    /**
     * Build a format string from the "options" arguments of the String() operator, 
     * for a String or enumeration argument.
     */
    public static CFormatSpecifier stringFormat(boolean leftJustified, int minimumLength) {
        return new CFormatSpecifier(leftJustified, minimumLength, -1, STRING);
    }

    public boolean isValid() {
        return !parsingFailed && 
               length.isEmpty();
    }

    public boolean hasProblem() {
        return hasError() || hasWarning();
    }

    public boolean hasError() {
        return !isValid();
    }

    public boolean hasWarning() {
        return initialPercent;
    }

    public String errorMessage() {
        if (parsingFailed) {
            return "Failed to parse format string \"" + format + "\".";
        } else if (initialPercent) {
            return "The format string argument should not include the initial '%': \"" + format + "\".";
        } else if (!length.isEmpty()) {
            return "Length modifiers are not allowed in format strings, but \"" + format + 
                    "\" has length modifier \"" + length + "\".";
        } else {
            return null;
        }
    }

    

}
