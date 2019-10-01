package org.jmodelica.common.evaluation;

import java.io.FileNotFoundException;

import org.jmodelica.common.LogContainer;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache.External;
import org.jmodelica.util.ccompiler.CCompilerDelegator;
import org.jmodelica.util.exceptions.CcodeCompilationException;

public interface Compiler<K, E extends External<K>> extends LogContainer {
    public String compileExternal(E ext) throws FileNotFoundException, CcodeCompilationException;

    public CCompilerDelegator getCCompiler();
}