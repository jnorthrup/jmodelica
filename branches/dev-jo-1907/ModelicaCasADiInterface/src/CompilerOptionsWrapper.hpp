/*
Copyright (C) 2013 Modelon AB

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, version 3 of the License.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

#ifndef _MODELICACASADI_COMPILER_OPTIONS_WRAPPER
#define _MODELICACASADI_COMPILER_OPTIONS_WRAPPER
#include <string>
#include <iostream>

#include "jni.h"
#include "jccexception.h"
#include "RefCountedNode.hpp"
#include "java/util/Collection.h"
#include "java/util/Iterator.h"
#include "java/lang/String.h"
#include "JCCEnv.h"
#include "org/jmodelica/common/options/OptionRegistry.h"
#include "org/jmodelica/modelica/compiler/ModelicaCompiler.h"
#include "org/jmodelica/modelica/compiler/generated/CompileOptions.h"
#include "org/jmodelica/optimica/compiler/ModelicaCompiler.h"
#include "org/jmodelica/optimica/compiler/generated/CompileOptions.h"

::java::lang::String StringFromUTF(const char *bytes);

namespace ModelicaCasADi
{
template<class TCompiler, class TOptions>
class CompilerOptionsWrapper: public RefCountedNode {
    public:
        CompilerOptionsWrapper() : optr(TCompiler::createOptions()) {}
        void setStringOption(std::string opt, std::string val);
        void setBooleanOption(std::string opt, bool val);
        void setIntegerOption(std::string opt, int val);
        void setRealOption(std::string opt, double val);

        bool getBooleanOption(std::string opt);

        void printCompilerOptions(std::ostream& out);
        void printOpts() {printCompilerOptions(std::cout);}

        TOptions getOptionRegistry() { return optr; }

    protected:
        TOptions optr;
};

class ModelicaOptionsWrapper : public CompilerOptionsWrapper<org::jmodelica::modelica::compiler::ModelicaCompiler,
        org::jmodelica::modelica::compiler::generated::CompileOptions> {

    public:
        /** Allows the use of the operator << to print this class to a stream, through Printable */
        virtual void print(std::ostream& os) const;

        MODELICACASADI_SHAREDNODE_CHILD_PUBLIC_DEFS
};

class OptimicaOptionsWrapper : public CompilerOptionsWrapper<org::jmodelica::optimica::compiler::ModelicaCompiler,
        org::jmodelica::optimica::compiler::generated::CompileOptions> {

    public:
        /** Allows the use of the operator << to print this class to a stream, through Printable */
        virtual void print(std::ostream& os) const;

        MODELICACASADI_SHAREDNODE_CHILD_PUBLIC_DEFS
};

template<class TCompiler, class TOptions>
bool CompilerOptionsWrapper<TCompiler, TOptions>::getBooleanOption(std::string opt) {
    bool roption;
    try {
        roption = optr.getBooleanOption(StringFromUTF(opt.c_str()));
    } catch (JavaError e) {
        rethrowJavaException(e);
    }
    return roption;
}

template<class TCompiler, class TOptions>
void CompilerOptionsWrapper<TCompiler, TOptions>::setStringOption(std::string opt, std::string val) {
    try {
        optr.setStringOption(StringFromUTF(opt.c_str()), StringFromUTF(val.c_str()));
    } catch (JavaError e) {
        rethrowJavaException(e);
    }
}

template<class TCompiler, class TOptions>
void CompilerOptionsWrapper<TCompiler, TOptions>::setBooleanOption(std::string opt, bool val) {
    try {
        optr.setBooleanOption(StringFromUTF(opt.c_str()), val);
    } catch (JavaError e) {
        rethrowJavaException(e);
    }
}

template<class TCompiler, class TOptions>
void CompilerOptionsWrapper<TCompiler, TOptions>::setIntegerOption(std::string opt, int val) {
    try {
        optr.setIntegerOption(StringFromUTF(opt.c_str()), val);
    } catch (JavaError e) {
        rethrowJavaException(e);
    }
}

template<class TCompiler, class TOptions>
void CompilerOptionsWrapper<TCompiler, TOptions>::setRealOption(std::string opt, double val) {
    try {
        optr.setRealOption(StringFromUTF(opt.c_str()), val);
    } catch (JavaError e) {
        rethrowJavaException(e);
    }
}

template<class TCompiler, class TOptions>
void CompilerOptionsWrapper<TCompiler, TOptions>::printCompilerOptions(std::ostream& out){
    try {
        java::util::Collection opts(optr.getOptionKeys().this$);

        java::util::Iterator iter(opts.iterator().this$);
        while(iter.hasNext()){
            java::lang::String key(iter.next().this$);
            out <<"\033[31m"<<env->toString(key.this$) <<"\033[0m"<< ": ";
            out << env->toString(optr.getDescription(key).this$);
            out << "\n";
        }

    } catch (JavaError e) {
        rethrowJavaException(e);
    }
}

}; // End namespace
#endif
