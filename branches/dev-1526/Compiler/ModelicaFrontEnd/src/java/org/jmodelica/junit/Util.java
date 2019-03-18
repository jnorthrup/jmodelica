package org.jmodelica.junit;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import org.jmodelica.util.exceptions.InternalCompilerError;

/**
 * Utility class for JUnit tests.
 */
public class Util {

    /**
     * Get the path to a resource using the class loader for a provided resource by name.
     * 
     * @param test  The object from which to find the sought resource file.
     * @param name  The name of the sought resource.
     * @return  the path to the resource.
     */
    public static String resource(Object test, String name) {
        return resource(test.getClass(), name);
    }

    /**
     * Get the path to a resource using the class loader for provided class object.
     * 
     * @param clazz The class object from which to search for the resource.
     * @param name  The name of the sought resource.
     * @return  the path to the resource.
     */
    public static String resource(Class<?> clazz, String name) {
        try {
            URL url = clazz.getResource(name);
            if (url == null) {
                throw new InternalCompilerError("Could not resolve url for resource \"" + name +
                        "\" from the class \"" + clazz.getSimpleName() + "\".");
            }

            // This ensures that spaces are encoded correctly!
            return URLDecoder.decode(url.getPath(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new InternalCompilerError("Unable to decode loaded resource URL; " + e.getMessage(), e);
        }
    }

}
