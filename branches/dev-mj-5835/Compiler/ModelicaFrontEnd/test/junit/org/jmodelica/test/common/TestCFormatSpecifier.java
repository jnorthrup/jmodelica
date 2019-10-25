package org.jmodelica.test.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.jmodelica.util.values.CFormatSpecifier;
import org.jmodelica.util.values.CFormatSpecifier.ValueType;
import org.junit.Test;

public class TestCFormatSpecifier {

    private static final String SIMPLE_REAL = "g";

    @Test
    public void testParseSimpleReal() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(SIMPLE_REAL);
        assertEquals(fmt.format,         SIMPLE_REAL);
        assertEquals(fmt.javaFormat,     "%g");
        assertEquals(fmt.expectedType,   ValueType.REAL);
        assertEquals(fmt.parsingFailed,  false);
        assertEquals(fmt.initialPercent, false);
        assertEquals(fmt.flags,          "");
        assertEquals(fmt.width,          -1);
        assertEquals(fmt.precision,      -1);
        assertEquals(fmt.length,         "");
        assertEquals(fmt.conversion,     "g");
    }

    @Test
    public void testMethodsSimpleReal() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(SIMPLE_REAL);
        assertTrue(fmt.isValid());
        assertFalse(fmt.hasProblem());
        assertFalse(fmt.hasError());
        assertFalse(fmt.hasWarning());
        assertEquals(fmt.errorMessage(), null);
    }

    private static final String COMPLEX_VALID_REAL = "- 3.4E";

    @Test
    public void testParseComplexValidReal() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(COMPLEX_VALID_REAL);
        assertEquals(fmt.format,         COMPLEX_VALID_REAL);
        assertEquals(fmt.javaFormat,     "%- 3.4E");
        assertEquals(fmt.expectedType,   ValueType.REAL);
        assertEquals(fmt.parsingFailed,  false);
        assertEquals(fmt.initialPercent, false);
        assertEquals(fmt.flags,          "- ");
        assertEquals(fmt.width,          3);
        assertEquals(fmt.precision,      4);
        assertEquals(fmt.length,         "");
        assertEquals(fmt.conversion,     "E");
    }

    @Test
    public void testMethodsComplexValidReal() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(COMPLEX_VALID_REAL);
        assertTrue(fmt.isValid());
        assertFalse(fmt.hasProblem());
        assertFalse(fmt.hasError());
        assertFalse(fmt.hasWarning());
        assertEquals(fmt.errorMessage(), null);
    }

    private static final String COMPLEX_REAL_WITH_LENGTH = "+05.2lg";

    @Test
    public void testParseComplexRealWithLength() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(COMPLEX_REAL_WITH_LENGTH);
        assertEquals(fmt.format,         COMPLEX_REAL_WITH_LENGTH);
        assertEquals(fmt.javaFormat,     "%+05.2g");
        assertEquals(fmt.expectedType,   ValueType.REAL);
        assertEquals(fmt.parsingFailed,  false);
        assertEquals(fmt.initialPercent, false);
        assertEquals(fmt.flags,          "+0");
        assertEquals(fmt.width,          5);
        assertEquals(fmt.precision,      2);
        assertEquals(fmt.length,         "l");
        assertEquals(fmt.conversion,     "g");
    }

    @Test
    public void testMethodsComplexRealWithLength() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(COMPLEX_REAL_WITH_LENGTH);
        assertFalse(fmt.isValid());
        assertTrue(fmt.hasProblem());
        assertTrue(fmt.hasError());
        assertFalse(fmt.hasWarning());
        assertEquals(fmt.errorMessage(), 
                "Length modifiers are not allowed in format strings, but \"" + 
                COMPLEX_REAL_WITH_LENGTH + "\" has length modifier \"l\".");
    }

    private static final String REAL_WITH_STAR = "*.*g";

    @Test
    public void testParseRealWithStar() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(REAL_WITH_STAR);
        assertEquals(fmt.format,         REAL_WITH_STAR);
        assertEquals(fmt.javaFormat,     "%f");
        assertEquals(fmt.expectedType,   ValueType.REAL);
        assertEquals(fmt.parsingFailed,  true);
        assertEquals(fmt.initialPercent, false);
        assertEquals(fmt.flags,          "");
        assertEquals(fmt.width,          -1);
        assertEquals(fmt.precision,      -1);
        assertEquals(fmt.length,         "");
        assertEquals(fmt.conversion,     "f");
    }

    @Test
    public void testMethodsRealWithStar() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(REAL_WITH_STAR);
        assertFalse(fmt.isValid());
        assertTrue(fmt.hasProblem());
        assertTrue(fmt.hasError());
        assertFalse(fmt.hasWarning());
        assertEquals(fmt.errorMessage(), 
                "Failed to parse format string \"" + REAL_WITH_STAR + "\".");
    }

    private static final String REAL_WITH_PERCENT = "%f";

    @Test
    public void testParseRealWithPercent() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(REAL_WITH_PERCENT);
        assertEquals(fmt.format,         REAL_WITH_PERCENT);
        assertEquals(fmt.javaFormat,     "%f");
        assertEquals(fmt.expectedType,   ValueType.REAL);
        assertEquals(fmt.parsingFailed,  false);
        assertEquals(fmt.initialPercent, true);
        assertEquals(fmt.flags,          "");
        assertEquals(fmt.width,          -1);
        assertEquals(fmt.precision,      -1);
        assertEquals(fmt.length,         "");
        assertEquals(fmt.conversion,     "f");
    }

    @Test
    public void testMethodsRealWithPercent() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(REAL_WITH_PERCENT);
        assertTrue(fmt.isValid());
        assertTrue(fmt.hasProblem());
        assertFalse(fmt.hasError());
        assertTrue(fmt.hasWarning());
        assertEquals(fmt.errorMessage(), 
                "The format string argument should not include the initial '%': \"" + 
                REAL_WITH_PERCENT + "\".");
    }

    private static final String SIMPLE_INTEGER = "i";

    @Test
    public void testParseSimpleInteger() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(SIMPLE_INTEGER);
        assertEquals(fmt.format,         SIMPLE_INTEGER);
        assertEquals(fmt.javaFormat,     "%d");
        assertEquals(fmt.expectedType,   ValueType.INT);
        assertEquals(fmt.parsingFailed,  false);
        assertEquals(fmt.initialPercent, false);
        assertEquals(fmt.flags,          "");
        assertEquals(fmt.width,          -1);
        assertEquals(fmt.precision,      -1);
        assertEquals(fmt.length,         "");
        assertEquals(fmt.conversion,     "i");
    }

    @Test
    public void testMethodsSimpleInteger() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(SIMPLE_INTEGER);
        assertTrue(fmt.isValid());
        assertFalse(fmt.hasProblem());
        assertFalse(fmt.hasError());
        assertFalse(fmt.hasWarning());
        assertEquals(fmt.errorMessage(), null);
    }

    private static final String SIMPLE_UNSIGNED_INTEGER = "u";

    @Test
    public void testParseSimpleUnsignedInteger() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(SIMPLE_UNSIGNED_INTEGER);
        assertEquals(fmt.format,         SIMPLE_UNSIGNED_INTEGER);
        assertEquals(fmt.javaFormat,     "%d");
        assertEquals(fmt.expectedType,   ValueType.UNSIGNED_INT);
        assertEquals(fmt.parsingFailed,  false);
        assertEquals(fmt.initialPercent, false);
        assertEquals(fmt.flags,          "");
        assertEquals(fmt.width,          -1);
        assertEquals(fmt.precision,      -1);
        assertEquals(fmt.length,         "");
        assertEquals(fmt.conversion,     "u");
    }

    @Test
    public void testMethodsSimpleUnsignedInteger() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(SIMPLE_UNSIGNED_INTEGER);
        assertTrue(fmt.isValid());
        assertFalse(fmt.hasProblem());
        assertFalse(fmt.hasError());
        assertFalse(fmt.hasWarning());
        assertEquals(fmt.errorMessage(), null);
    }

    private static final String SIMPLE_STRING = "s";

    @Test
    public void testParseSimpleString() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(SIMPLE_STRING);
        assertEquals(fmt.format,         SIMPLE_STRING);
        assertEquals(fmt.javaFormat,     "%s");
        assertEquals(fmt.expectedType,   ValueType.STRING);
        assertEquals(fmt.parsingFailed,  false);
        assertEquals(fmt.initialPercent, false);
        assertEquals(fmt.flags,          "");
        assertEquals(fmt.width,          -1);
        assertEquals(fmt.precision,      -1);
        assertEquals(fmt.length,         "");
        assertEquals(fmt.conversion,     "s");
    }

    @Test
    public void testMethodsSimpleString() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(SIMPLE_STRING);
        assertTrue(fmt.isValid());
        assertFalse(fmt.hasProblem());
        assertFalse(fmt.hasError());
        assertFalse(fmt.hasWarning());
        assertEquals(fmt.errorMessage(), null);
    }

    private static final String SIMPLE_CHAR = "c";

    @Test
    public void testParseSimpleChar() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(SIMPLE_CHAR);
        assertEquals(fmt.format,         SIMPLE_CHAR);
        assertEquals(fmt.javaFormat,     "%c");
        assertEquals(fmt.expectedType,   ValueType.CHAR);
        assertEquals(fmt.parsingFailed,  false);
        assertEquals(fmt.initialPercent, false);
        assertEquals(fmt.flags,          "");
        assertEquals(fmt.width,          -1);
        assertEquals(fmt.precision,      -1);
        assertEquals(fmt.length,         "");
        assertEquals(fmt.conversion,     "c");
    }

    @Test
    public void testMethodsSimpleChar() {
        CFormatSpecifier fmt = CFormatSpecifier.parseFormat(SIMPLE_CHAR);
        assertTrue(fmt.isValid());
        assertFalse(fmt.hasProblem());
        assertFalse(fmt.hasError());
        assertFalse(fmt.hasWarning());
        assertEquals(fmt.errorMessage(), null);
    }

    @Test
    public void testBuildReal() {
        CFormatSpecifier fmt = CFormatSpecifier.realFormat(true, 2, 3);
        assertEquals(fmt.format,         "-2.3g");
        assertEquals(fmt.javaFormat,     "%-2.3g");
        assertEquals(fmt.expectedType,   ValueType.REAL);
        assertEquals(fmt.parsingFailed,  false);
        assertEquals(fmt.initialPercent, false);
        assertEquals(fmt.flags,          "-");
        assertEquals(fmt.width,          2);
        assertEquals(fmt.precision,      3);
        assertEquals(fmt.length,         "");
        assertEquals(fmt.conversion,     "g");
    }

    @Test
    public void testBuildInteger() {
        CFormatSpecifier fmt = CFormatSpecifier.integerFormat(true, 2);
        assertEquals(fmt.format,         "-2d");
        assertEquals(fmt.javaFormat,     "%-2d");
        assertEquals(fmt.expectedType,   ValueType.INT);
        assertEquals(fmt.parsingFailed,  false);
        assertEquals(fmt.initialPercent, false);
        assertEquals(fmt.flags,          "-");
        assertEquals(fmt.width,          2);
        assertEquals(fmt.precision,      -1);
        assertEquals(fmt.length,         "");
        assertEquals(fmt.conversion,     "d");
    }

    @Test
    public void testBuildString() {
        CFormatSpecifier fmt = CFormatSpecifier.stringFormat(true, 2);
        assertEquals(fmt.format,         "-2s");
        assertEquals(fmt.javaFormat,     "%-2s");
        assertEquals(fmt.expectedType,   ValueType.STRING);
        assertEquals(fmt.parsingFailed,  false);
        assertEquals(fmt.initialPercent, false);
        assertEquals(fmt.flags,          "-");
        assertEquals(fmt.width,          2);
        assertEquals(fmt.precision,      -1);
        assertEquals(fmt.length,         "");
        assertEquals(fmt.conversion,     "s");
    }

}
