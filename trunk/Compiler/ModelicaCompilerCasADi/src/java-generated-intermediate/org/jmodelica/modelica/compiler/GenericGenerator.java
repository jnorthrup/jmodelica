package org.jmodelica.modelica.compiler;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import org.jmodelica.util.BinaryOperation;
import org.jmodelica.util.StringUtil;
import org.jmodelica.util.collections.ConstArrayIterator;
import org.jmodelica.util.collections.SingleIterator;
import org.jmodelica.util.values.ConstValue;
import org.jmodelica.util.values.Evaluable;
import org.jmodelica.util.values.ConstantEvaluationException;
import org.jmodelica.util.values.ConstantEvaluationNotReadyException;
import org.jmodelica.util.values.FunctionEvaluationException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Timer;
import java.util.TimerTask;
import org.jmodelica.common.evaluation.ExternalFunction;
import org.jmodelica.common.evaluation.ExternalProcessCache;
import org.jmodelica.common.evaluation.ExternalProcessCacheImpl;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache;
import org.jmodelica.common.evaluation.ProcessCommunicator;
import org.jmodelica.common.ast.prefixes.EquationType;
import org.jmodelica.common.ast.prefixes.TypePrefixInputOutput;
import org.jmodelica.common.ast.prefixes.VisibilityType;
import org.jmodelica.util.Precedence;
import java.util.LinkedHashSet;
import java.util.EnumMap;
import java.io.File;
import java.math.BigInteger;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.DigestOutputStream;
import java.security.NoSuchAlgorithmException;
import org.jmodelica.common.GUIDManager;
import org.jmodelica.util.streams.StreamGobbler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.jmodelica.util.logging.StreamingLogger;
import org.jmodelica.util.logging.Level;
import org.jmodelica.util.AbstractModelicaScanner;
import beaver.Symbol;
import java.io.ByteArrayOutputStream;
import org.jmodelica.util.streams.CodeStream;
import org.jmodelica.util.streams.NotNullCodeStream;
import java.util.TreeSet;
import org.jmodelica.util.collections.ParallelIterable;
import org.jmodelica.util.ErrorCheckType;
import org.jmodelica.util.problemHandling.SimpleProblemProducer;
import org.jmodelica.util.problemHandling.SimpleWarningProducer;
import org.jmodelica.util.problemHandling.SimpleErrorProducer;
import org.jmodelica.util.problemHandling.ComplianceFMUOnlyProducer;
import org.jmodelica.common.URIResolver;
import org.jmodelica.common.URIResolver.URIException;
import java.util.LinkedList;
import org.jmodelica.util.collections.ListMap;
import org.jmodelica.util.collections.LinkedHashListMap;
import org.jmodelica.api.problemHandling.Problem;
import org.jmodelica.api.problemHandling.ProblemSeverity;
import org.jmodelica.api.problemHandling.ProblemKind;
import org.jmodelica.util.problemHandling.ReporterNode;
import org.jmodelica.util.problemHandling.ProblemOptionsProvider;
import org.jmodelica.util.Criteria;
import org.jmodelica.util.problemHandling.ErrorProducerUnlessDisabled;
import org.jmodelica.util.problemHandling.AbstractErrorProducerUnlessDisabled;
import org.jmodelica.util.collections.ReverseListIterable;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import org.jmodelica.util.Enumerator;
import org.jmodelica.util.collections.GrowableSetIterable;
import java.util.Stack;
import org.jmodelica.util.collections.FilteredIterator;
import org.jmodelica.util.collections.FilteredIterable;
import java.util.SortedSet;
import java.util.Comparator;
import org.jmodelica.common.options.OptionRegistry;
import org.jmodelica.util.problemHandling.ProblemProducer;
import org.jmodelica.util.AdjustableSymbol;
import org.jmodelica.util.QualifiedName;
import org.jmodelica.util.collections.SubClassIterator;
import org.jmodelica.util.collections.SingleIterable;
import org.jmodelica.util.collections.ChainedIterable;
import org.jmodelica.util.collections.NestledIterator;
import org.jmodelica.util.collections.NestledIterable;
import org.jmodelica.util.collections.SubClassIterable;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.jmodelica.util.collections.ChainedIterator;
import org.jmodelica.util.annotations.AnnotationProvider;
import org.jmodelica.util.annotations.AnnotationProvider.SubNodePair;
import org.jmodelica.util.annotations.FailedToSetAnnotationValueException;
import org.jmodelica.util.annotations.GenericAnnotationNode;
import org.jmodelica.util.annotations.IterableAnnotationProvider;
import org.jmodelica.util.collections.TransformerIterable;
import org.jmodelica.util.values.Evaluator;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.net.URI;
import java.net.URISyntaxException;
import org.jmodelica.util.formatting.FormattingRecorder;
import org.jmodelica.util.formatting.DefaultFormattingRecorder;
import org.jmodelica.common.ResourceLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.IdentityHashMap;
import org.jmodelica.util.streams.NullStream;
import org.jmodelica.util.problemHandling.SanityProblemProducer;
import java.util.EnumSet;
import org.jmodelica.util.munkres.DenseMunkresProblem;
import org.jmodelica.util.munkres.IntegerCost;
import java.util.BitSet;
import org.jmodelica.util.exceptions.BLTException;
import java.util.ListIterator;
import java.util.TreeMap;
import java.util.Random;
import org.jmodelica.util.collections.HashStack;
import org.jmodelica.util.tarjan.Tarjan;
import org.jmodelica.util.tarjan.SimpleTarjan;
import org.jmodelica.util.tarjan.TarjanComponent;
import org.jmodelica.util.exceptions.MunkresException;
import org.jmodelica.util.exceptions.IndexReductionException;
import org.jmodelica.util.munkres.SparseMunkresProblem;
import org.jmodelica.util.munkres.MunkresProblem;
import org.jmodelica.util.munkres.MunkresCost;
import org.jmodelica.util.Solvability;
import java.io.*;
import java.lang.reflect.Constructor;
import org.jmodelica.util.XMLUtil;
import java.io.OutputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import org.jmodelica.util.collections.ListUtil;
import java.io.FileReader;
import org.jmodelica.util.test.GenericTestCase;
import org.jmodelica.util.test.Assert;
import org.jmodelica.util.CompiledUnit;
import org.jmodelica.util.logging.units.LoggingUnit;
import org.jmodelica.util.test.GenericTestSuite;
import org.jmodelica.util.test.TestTree;
import org.jmodelica.common.options.TestOptions;
import org.jmodelica.util.AbstractFlatModelicaScanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jmodelica.util.streams.CStringCodeStream;
import org.jmodelica.common.ccodegen.CFuncParamDirection;
import org.jmodelica.util.exceptions.CompilerException;
import java.util.Deque;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.InterruptedException;
import java.lang.StringBuilder;
import java.nio.channels.FileChannel;
import java.util.Hashtable;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.jmodelica.util.logging.ModelicaLogger;
import org.jmodelica.util.logging.MemoryLogger;
import org.jmodelica.common.options.OptionRegistry.UnknownOptionException;
import org.jmodelica.util.Arguments;
import org.jmodelica.util.SymbolValueFixer;
import org.jmodelica.util.EnvironmentUtils;
import org.jmodelica.util.exceptions.ModelicaException;
import org.jmodelica.util.exceptions.InternalCompilerError;
import org.jmodelica.util.MemorySpider;
import org.jmodelica.util.exceptions.IllegalCompilerArgumentException;
import org.jmodelica.util.exceptions.ModelicaClassNotFoundException;
import org.jmodelica.util.exceptions.JModelicaHomeNotFoundException;
import org.jmodelica.util.exceptions.PackingFailedException;
import org.jmodelica.util.exceptions.CcodeCompilationException;
import org.jmodelica.util.PassAndForget;
import org.jmodelica.util.logging.IllegalLogStringException;
import org.jmodelica.util.streams.*;
import org.jmodelica.util.files.*;
import org.jmodelica.util.ccompiler.CCompilerArguments;
import org.jmodelica.util.ccompiler.CCompilerDelegator;
import org.jmodelica.util.ccompiler.CCompilerDelegator.Creator;
import org.jmodelica.util.ccompiler.CCompilerTarget;
import org.jmodelica.util.ccompiler.GccCompilerDelegator;
import org.jmodelica.common.LogContainer;
import org.jmodelica.modelica.compiler.generated.OptionsAggregated;
import org.xml.sax.SAXException;
import ifcasadi.ifcasadi;
import ifcasadi.GenericType;
import ifcasadi.MX;
import ifcasadi.MXFunction;
import ifcasadi.MXVector;
/**
 * @ast class
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\GenericCodeGen\\src\\jastadd\\GenericGenerator.jrag:30
 */
public class GenericGenerator extends AbstractGenerator {
    public  class DAETag_numIndependentConstants extends DAETag {
		
		public DAETag_numIndependentConstants(AbstractGenerator myGenerator, FClass fclass) {
			super("n_ci", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numIndependentConstants());
		}
	
	}

    public  class DAETag_numDependentConstants extends DAETag {
		
		public DAETag_numDependentConstants(AbstractGenerator myGenerator, FClass fclass) {
			super("n_cd", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDependentConstants());
		}
	
	}

    public  class DAETag_numIndependentParameters extends DAETag {
		
		public DAETag_numIndependentParameters(AbstractGenerator myGenerator, FClass fclass) {
			super("n_pi", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numIndependentParameters());
		}
	
	}

    public  class DAETag_numDependentParameters extends DAETag {
		
		public DAETag_numDependentParameters(AbstractGenerator myGenerator, FClass fclass) {
			super("n_pd", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDependentParameters());
		}
	
	}

    public  class DAETag_numIndependentRealConstants extends DAETag {
		
		public DAETag_numIndependentRealConstants(AbstractGenerator myGenerator, FClass fclass) {
			super("n_real_ci", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numIndependentRealConstants());
		}
	
	}

    public  class DAETag_numDependentRealConstants extends DAETag {
		
		public DAETag_numDependentRealConstants(AbstractGenerator myGenerator, FClass fclass) {
			super("n_real_cd", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDependentRealConstants());
		}
	
	}

    public  class DAETag_numIndependentRealParameters extends DAETag {
		
		public DAETag_numIndependentRealParameters(AbstractGenerator myGenerator, FClass fclass) {
			super("n_real_pi", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numIndependentRealParameters());
		}
	
	}

    public  class DAETag_numStructuralIndependentRealParameters extends DAETag {
        
        public DAETag_numStructuralIndependentRealParameters(AbstractGenerator myGenerator, FClass fclass) {
            super("n_real_pi_s", myGenerator, fclass);
        }
    
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numStructuralIndependentRealParameters());
        }
    
    }

    public  class DAETag_numFinalIndependentRealParameters extends DAETag {
        
        public DAETag_numFinalIndependentRealParameters(AbstractGenerator myGenerator, FClass fclass) {
            super("n_real_pi_f", myGenerator, fclass);
        }
    
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numFinalIndependentRealParameters());
        }
    
    }

    public  class DAETag_numEvalIndependentRealParameters extends DAETag {
        
        public DAETag_numEvalIndependentRealParameters(AbstractGenerator myGenerator, FClass fclass) {
            super("n_real_pi_e", myGenerator, fclass);
        }
    
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numEvalIndependentRealParameters());
        }
    
    }

    public  class DAETag_numDependentRealParameters extends DAETag {
		
		public DAETag_numDependentRealParameters(AbstractGenerator myGenerator, FClass fclass) {
			super("n_real_pd", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDependentRealParameters());
		}
	
	}

    public  class DAETag_numIndependentIntegerConstants extends DAETag {
		
		public DAETag_numIndependentIntegerConstants(AbstractGenerator myGenerator, FClass fclass) {
			super("n_integer_ci", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numIndependentIntegerConstants());
		}
	
	}

    public  class DAETag_numIndependentEnumConstants extends DAETag {
		
		public DAETag_numIndependentEnumConstants(AbstractGenerator myGenerator, FClass fclass) {
			super("n_enum_ci", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numIndependentEnumConstants());
		}
	
	}

    public  class DAETag_numDependentIntegerConstants extends DAETag {
		
		public DAETag_numDependentIntegerConstants(AbstractGenerator myGenerator, FClass fclass) {
			super("n_integer_cd", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDependentIntegerConstants());
		}
	
	}

    public  class DAETag_numDependentEnumConstants extends DAETag {
		
		public DAETag_numDependentEnumConstants(AbstractGenerator myGenerator, FClass fclass) {
			super("n_enum_cd", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDependentEnumConstants());
		}
	
	}

    public  class DAETag_numIndependentIntegerParameters extends DAETag {
		
		public DAETag_numIndependentIntegerParameters(AbstractGenerator myGenerator, FClass fclass) {
			super("n_integer_pi", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numIndependentIntegerParameters());
		}
	
	}

    public  class DAETag_numStructuralIndependentIntegerParameters extends DAETag {
        
        public DAETag_numStructuralIndependentIntegerParameters(AbstractGenerator myGenerator, FClass fclass) {
            super("n_integer_pi_s", myGenerator, fclass);
        }
    
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numStructuralIndependentIntegerParameters());
        }
    
    }

    public  class DAETag_numFinalIndependentIntegerParameters extends DAETag {
        
        public DAETag_numFinalIndependentIntegerParameters(AbstractGenerator myGenerator, FClass fclass) {
            super("n_integer_pi_f", myGenerator, fclass);
        }
    
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numFinalIndependentIntegerParameters());
        }
    
    }

    public  class DAETag_numEvalIndependentIntegerParameters extends DAETag {
        
        public DAETag_numEvalIndependentIntegerParameters(AbstractGenerator myGenerator, FClass fclass) {
            super("n_integer_pi_e", myGenerator, fclass);
        }
    
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numEvalIndependentIntegerParameters());
        }
    
    }

    public  class DAETag_numIndependentEnumParameters extends DAETag {
		
		public DAETag_numIndependentEnumParameters(AbstractGenerator myGenerator, FClass fclass) {
			super("n_enum_pi", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numIndependentEnumParameters());
		}
	
	}

    public  class DAETag_numStructuralIndependentEnumParameters extends DAETag {
        
        public DAETag_numStructuralIndependentEnumParameters(AbstractGenerator myGenerator, FClass fclass) {
            super("n_enum_pi_s", myGenerator, fclass);
        }
    
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numStructuralIndependentEnumParameters());
        }
    
    }

    public  class DAETag_numFinalIndependentEnumParameters extends DAETag {
        
        public DAETag_numFinalIndependentEnumParameters(AbstractGenerator myGenerator, FClass fclass) {
            super("n_enum_pi_f", myGenerator, fclass);
        }
    
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numFinalIndependentEnumParameters());
        }
    
    }

    public  class DAETag_numEvalIndependentEnumParameters extends DAETag {
        
        public DAETag_numEvalIndependentEnumParameters(AbstractGenerator myGenerator, FClass fclass) {
            super("n_enum_pi_e", myGenerator, fclass);
        }
    
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numEvalIndependentEnumParameters());
        }
    
    }

    public  class DAETag_numDependentIntegerParameters extends DAETag {
		
		public DAETag_numDependentIntegerParameters(AbstractGenerator myGenerator, FClass fclass) {
			super("n_integer_pd", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDependentIntegerParameters());
		}
	
	}

    public  class DAETag_numDependentEnumParameters extends DAETag {
		
		public DAETag_numDependentEnumParameters(AbstractGenerator myGenerator, FClass fclass) {
			super("n_enum_pd", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDependentEnumParameters());
		}
	
	}

    public  class DAETag_numIndependentBooleanConstants extends DAETag {
		
		public DAETag_numIndependentBooleanConstants(AbstractGenerator myGenerator, FClass fclass) {
			super("n_boolean_ci", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numIndependentBooleanConstants());
		}
	
	}

    public  class DAETag_numDependentBooleanConstants extends DAETag {
		
		public DAETag_numDependentBooleanConstants(AbstractGenerator myGenerator, FClass fclass) {
			super("n_boolean_cd", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDependentBooleanConstants());
		}
	
	}

    public  class DAETag_numIndependentBooleanParameters extends DAETag {
		
		public DAETag_numIndependentBooleanParameters(AbstractGenerator myGenerator, FClass fclass) {
			super("n_boolean_pi", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numIndependentBooleanParameters());
		}
	
	}

    public  class DAETag_numStructuralIndependentBooleanParameters extends DAETag {
        
        public DAETag_numStructuralIndependentBooleanParameters(AbstractGenerator myGenerator, FClass fclass) {
            super("n_boolean_pi_s", myGenerator, fclass);
        }
        
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numStructuralIndependentBooleanParameters());
        }
        
    }

    public  class DAETag_numFinalIndependentBooleanParameters extends DAETag {
        
        public DAETag_numFinalIndependentBooleanParameters(AbstractGenerator myGenerator, FClass fclass) {
            super("n_boolean_pi_f", myGenerator, fclass);
        }
        
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numFinalIndependentBooleanParameters());
        }
        
    }

    public  class DAETag_numEvalIndependentBooleanParameters extends DAETag {
        
        public DAETag_numEvalIndependentBooleanParameters(AbstractGenerator myGenerator, FClass fclass) {
            super("n_boolean_pi_e", myGenerator, fclass);
        }
        
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numEvalIndependentBooleanParameters());
        }
        
    }

    public  class DAETag_numDependentBooleanParameters extends DAETag {
		
		public DAETag_numDependentBooleanParameters(AbstractGenerator myGenerator, FClass fclass) {
			super("n_boolean_pd", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDependentBooleanParameters());
		}
	
	}

    public  class DAETag_numIndependentStringConstants extends DAETag {
		
		public DAETag_numIndependentStringConstants(AbstractGenerator myGenerator, FClass fclass) {
			super("n_string_ci", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numIndependentStringConstants());
		}
	
	}

    public  class DAETag_numDependentStringConstants extends DAETag {
		
		public DAETag_numDependentStringConstants(AbstractGenerator myGenerator, FClass fclass) {
			super("n_string_cd", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDependentStringConstants());
		}
	
	}

    public  class DAETag_numIndependentStringParameters extends DAETag {
		
		public DAETag_numIndependentStringParameters(AbstractGenerator myGenerator, FClass fclass) {
			super("n_string_pi", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numIndependentStringParameters());
		}
	
	}

    public  class DAETag_numStructuralIndependentStringParameters extends DAETag {
        
        public DAETag_numStructuralIndependentStringParameters(AbstractGenerator myGenerator, FClass fclass) {
            super("n_string_pi_s", myGenerator, fclass);
        }
    
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numStructuralIndependentStringParameters());
        }
    
    }

    public  class DAETag_numFinalIndependentStringParameters extends DAETag {
        
        public DAETag_numFinalIndependentStringParameters(AbstractGenerator myGenerator, FClass fclass) {
            super("n_string_pi_f", myGenerator, fclass);
        }
    
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numFinalIndependentStringParameters());
        }
    
    }

    public  class DAETag_numEvalIndependentStringParameters extends DAETag {
        
        public DAETag_numEvalIndependentStringParameters(AbstractGenerator myGenerator, FClass fclass) {
            super("n_string_pi_e", myGenerator, fclass);
        }
    
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numEvalIndependentStringParameters());
        }
    
    }

    public  class DAETag_numDependentStringParameters extends DAETag {
		
		public DAETag_numDependentStringParameters(AbstractGenerator myGenerator, FClass fclass) {
			super("n_string_pd", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDependentStringParameters());
		}
	
	}

    public  class DAETag_numStateSwitchingFunctions extends DAETag {
        
        public DAETag_numStateSwitchingFunctions(AbstractGenerator myGenerator, FClass fclass) {
            super("n_state_switches", myGenerator, fclass);
        }
        
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numStateSwitches());
        }
        
    }

    public  class DAETag_numTimeSwitchingFunctions extends DAETag {
        
        public DAETag_numTimeSwitchingFunctions(AbstractGenerator myGenerator, FClass fclass) {
            super("n_time_switches", myGenerator, fclass);
        }
    
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numTimeSwitches());
        }
    
    }

    public  class DAETag_numInitialSwitchingFunctions extends DAETag {
		
		public DAETag_numInitialSwitchingFunctions(AbstractGenerator myGenerator, FClass fclass) {
			super("n_initial_switches", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numInitialEventIndicators());
		}
	
	}

    public  class DAETag_numGuards extends DAETag {
		
		public DAETag_numGuards(AbstractGenerator myGenerator, FClass fclass) {
			super("n_guards", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numGuardExpInEquations());
		}

	}

    public  class DAETag_numInitialGuards extends DAETag {
		
		public DAETag_numInitialGuards(AbstractGenerator myGenerator, FClass fclass) {
			super("n_guards_init", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numGuardExpInInitialEquations());
		}
	
	}

    public  class DAETag_numAlgebraicContinousRealVariables extends DAETag {
		
		public DAETag_numAlgebraicContinousRealVariables(AbstractGenerator myGenerator, FClass fclass) {
			super("n_real_w", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numAlgebraicContinousRealVariables());
		}
	
	}

    public  class DAETag_numDiscreteVariables extends DAETag {
		
		public DAETag_numDiscreteVariables(AbstractGenerator myGenerator, FClass fclass) {
			super("n_d", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDiscreteVariables());
		}
	
	}

    public  class DAETag_numDiscreteRealVariables extends DAETag {
		
		public DAETag_numDiscreteRealVariables(AbstractGenerator myGenerator, FClass fclass) {
			super("n_real_d", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDiscreteRealVariables());
		}
	
	}

    public  class DAETag_numOutputs extends DAETag {
		
		public DAETag_numOutputs(AbstractGenerator myGenerator, FClass fclass) {
			super("n_outputs", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numOutputs());
		}
	
	}

    public  class DAETag_numDiscreteIntegerVariables extends DAETag {
		
		public DAETag_numDiscreteIntegerVariables(AbstractGenerator myGenerator, FClass fclass) {
			super("n_integer_d", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDiscreteIntegerVariables());
		}
	
	}

    public  class DAETag_numDiscreteEnumVariables extends DAETag {
		
		public DAETag_numDiscreteEnumVariables(AbstractGenerator myGenerator, FClass fclass) {
			super("n_enum_d", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDiscreteEnumVariables());
		}
	
	}

    public  class DAETag_numDiscreteBooleanVariables extends DAETag {
		
		public DAETag_numDiscreteBooleanVariables(AbstractGenerator myGenerator, FClass fclass) {
			super("n_boolean_d", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDiscreteBooleanVariables());
		}
	
	}

    public  class DAETag_numDiscreteStringVariables extends DAETag {
		
		public DAETag_numDiscreteStringVariables(AbstractGenerator myGenerator, FClass fclass) {
			super("n_string_d", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDiscreteStringVariables());
		}
	
	}

    public  class DAETag_numInputs extends DAETag {
		
		public DAETag_numInputs(AbstractGenerator myGenerator, FClass fclass) {
			super("n_u", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numInputs());
		}
	
	}

    public  class DAETag_numRealInputs extends DAETag {
		
		public DAETag_numRealInputs(AbstractGenerator myGenerator, FClass fclass) {
			super("n_real_u", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numRealInputs());
		}
	
	}

    public  class DAETag_numIntegerInputs extends DAETag {
		
		public DAETag_numIntegerInputs(AbstractGenerator myGenerator, FClass fclass) {
			super("n_integer_u", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numIntegerInputs());
		}
	
	}

    public  class DAETag_numEnumInputs extends DAETag {
		
		public DAETag_numEnumInputs(AbstractGenerator myGenerator, FClass fclass) {
			super("n_enum_u", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numEnumInputs());
		}
	
	}

    public  class DAETag_numBooleanInputs extends DAETag {
		
		public DAETag_numBooleanInputs(AbstractGenerator myGenerator, FClass fclass) {
			super("n_boolean_u", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numBooleanInputs());
		}
	
	}

    public  class DAETag_numStringInputs extends DAETag {
		
		public DAETag_numStringInputs(AbstractGenerator myGenerator, FClass fclass) {
			super("n_string_u", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numStringInputs());
		}
	
	}

    public  class DAETag_numExternalObjects extends DAETag {
        
        public DAETag_numExternalObjects(AbstractGenerator myGenerator, FClass fclass) {
            super("n_ext_objs", myGenerator, fclass);
        }
    
        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.numExternalObjectVariables());
        }
    
    }

    public  class DAETag_numEquations extends DAETag {
		
		public DAETag_numEquations(AbstractGenerator myGenerator, FClass fclass) {
			super("n_equations", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numScalarEquations());
		}
	
	}

    public  class DAETag_numEventIndicators extends DAETag {
		
		public DAETag_numEventIndicators(AbstractGenerator myGenerator, FClass fclass) {
			super("n_event_indicators", myGenerator, fclass);
		}
	
        public void generate(CodeStream genPrinter) {
            if (fclass.onlyInitBLT())
                genPrinter.print(fclass.numEventIndicators() + fclass.numInitialEventIndicators());
            else
                genPrinter.print(fclass.numEventIndicators());
        }
	}

    public  class DAETag_numInitialEquations extends DAETag {
		
		public DAETag_numInitialEquations(AbstractGenerator myGenerator, FClass fclass) {
			super("n_initial_equations", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numInitialScalarEquations());
		}
	
	}

    public  class DAETag_numInitialEventIndicators extends DAETag {
		
		public DAETag_numInitialEventIndicators(AbstractGenerator myGenerator, FClass fclass) {
			super("n_initial_event_indicators", myGenerator, fclass);
		}
	
        public void generate(CodeStream genPrinter) {
            if (fclass.onlyInitBLT())
                genPrinter.print(0);
            else
                genPrinter.print(fclass.numInitialEventIndicators());
        }
	}

    public  class DAETag_numInitialGuessEquations extends DAETag {
		
		public DAETag_numInitialGuessEquations(AbstractGenerator myGenerator, FClass fclass) {
			super("n_initial_guess_equations", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numInitialGuessEquations());
		}
	
	}

    public  class DAETag_numDifferentiatedRealVariables extends DAETag {
		
		public DAETag_numDifferentiatedRealVariables(AbstractGenerator myGenerator, FClass fclass) {
			super("n_real_x", myGenerator, fclass);
		}
	
		public void generate(CodeStream genPrinter) {
			genPrinter.print(fclass.numDifferentiatedRealVariables());
		}
	
	}

    public  class DAETag_dynamic_state_n_sets extends DAETag {
        
        public DAETag_dynamic_state_n_sets(AbstractGenerator myGenerator, FClass fclass) {
            super("dynamic_state_n_sets", myGenerator, fclass);
        }

        public void generate(CodeStream genPrinter) {
            genPrinter.print(fclass.getDynamicStateManager().getNumSet());
        }
    }

    public  class DAETag_fmu_type_define extends DAETag {
        
        public DAETag_fmu_type_define(AbstractGenerator myGenerator, FClass fclass) {
            super("fmu_type_define", myGenerator, fclass);
        }

        public void generate(CodeStream genPrinter) {
            String[] fmuTypes = fclass.myOptions().getStringOption("fmu_type").split(";");
            for (String fType : fmuTypes) {
            	genPrinter.print("#define ");
            	genPrinter.print(fType);
            	genPrinter.print(" 1\n");
            }
            genPrinter.print("");
        }
    }

    public  GenericGenerator(Printer expPrinter, char escapeCharacter,
	  FClass fclass) {
		super(expPrinter,escapeCharacter, fclass);
	}


}
