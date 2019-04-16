package org.jmodelica.util;

import java.io.File;

import org.jmodelica.util.exceptions.JModelicaHomeNotFoundException;

/**
 * Utility class which contains methods for retrieving information about the
 * JModelica.org environment.
 */
public final class EnvironmentUtils {

    private static String javaExecutablePlatform_cache = null;

    private static String systemPlatform_cache = null;

    private static File jmodelicaHome_cache = null;

    private static void calcPlatform() {
        if (systemPlatform_cache != null) {
            return;
        }

        String platform;

        String sunPltform = System.getProperty("os.name");
        if (sunPltform.startsWith("Windows")) {
            platform = "win";
        } else if (sunPltform.startsWith("Mac")) {
            platform = "darwin";
        } else {
            // assume linux
            platform = "linux";
        }

        String architecture = System.getProperty("os.arch");
        String wow6432Arch = System.getenv("PROCESSOR_ARCHITEW6432");
        boolean exeIs64 = architecture.endsWith("64");
        boolean sysIs64 = exeIs64 || (wow6432Arch != null && wow6432Arch.endsWith("64"));

        javaExecutablePlatform_cache = platform + (exeIs64 ? "64" : "32");
        systemPlatform_cache = platform + (sysIs64 ? "64" : "32");
    }

    /**
     * Helper function. Returns an array describing the platforms that we can
     * run executables compiled for.
     * 
     * The possible strings in the array are the same as for
     * {@link #getJavaPlatform()}.
     */
    public static String[] getExecutablePlatforms() {
        calcPlatform();

        if (systemPlatform_cache.equals("win64")) {
            return new String[] { "win64", "win32" };
        } else {
            return new String[] { systemPlatform_cache };
        }
    }

    /**
     * @return the default target platform to be used for the current system.
     */
    public static String[] getDefaultTargetPlatform() {
        if (systemPlatform_cache.contains("darwin")) {
            throw new IllegalArgumentException("Can not use default platform target for platform " +
                    systemPlatform_cache + ". Set the compiler option 'platforms' to a valid value.");
        }

        return new String[] { systemPlatform_cache.replaceAll("32", "64") };
    }

    /**
     * Helper function. Returns string describing the system platform on which
     * jmodelica is run.
     * 
     * The possible return values are the same as for
     * {@link #getJavaPlatform()}.
     */
    public static String getSystemPlatform() {
        calcPlatform();
        return systemPlatform_cache;
    }

    /**
     * Helper function. Returns string describing the platform that the JVM is
     * compiled for.
     * This can differ from getSystemPlatform() on Windows.
     * 
     * Possible return values:
     * <ul>
     * <li>win32</li>
     * <li>win64</li>
     * <li>darwin32</li>
     * <li>darwin64</li>
     * <li>linux32</li>
     * <li>linux64</li>
     * </ul>
     */
    // TODO: If this not a return an infinite set of values, shouldn't this be an enum?
    public static String getJavaPlatform() {
        calcPlatform();
        return javaExecutablePlatform_cache;
    }

    /**
     * Provides the path to JModelica home.
     * 
     * @return file object representing the path to jmodelica home
     */
    public static File getJModelicaHome() {
        if (jmodelicaHome_cache == null) {
            String env = System.getenv("JMODELICA_HOME");
            if (env == null) { 
                throw new JModelicaHomeNotFoundException("The environment variable JMODELICA_HOME has not been set.");
            }
            jmodelicaHome_cache = new File(env);
        }

        if (!jmodelicaHome_cache.exists()) {
            throw new JModelicaHomeNotFoundException(String.format("JMODELICA_HOME does not exist: '%s'", jmodelicaHome_cache));
        }
        return jmodelicaHome_cache;
    }

    /**
     * Calculates the path to the ThirdParty folder in the installation
     * 
     * @return File object pointing to the ThirdParty folder
     */
    public static File getThirdParty() {
        return new File(getJModelicaHome(), "ThirdParty");
    }

    /**
     * Calculates the path to the MSL folder in the installation
     * 
     * @return File object pointing to the MSL folder
     */
    public static File getThirdPartyMSL() {
        return new File(getThirdParty(), "MSL");
    }

    /**
     * Calculates the path to the Modelica folder in the installation
     * 
     * @return File object pointing to the Modelica folder
     */
    public static File getThirdPartyMSLModelica() {
        return new File(getThirdPartyMSL(), "Modelica");
    }

    private EnvironmentUtils() {
        // Private constructor so this object can't be instantiated!
    }
}
