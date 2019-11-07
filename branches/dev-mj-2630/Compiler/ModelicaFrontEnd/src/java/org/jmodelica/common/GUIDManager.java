package org.jmodelica.common;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jmodelica.util.logging.ModelicaLogger;

public class GUIDManager {

    private final Token guidToken = new Token("$GUID_TOKEN$");
    private final Token dateToken = new Token("$DATE_TOKEN$");
    private final Token generationToolToken = new Token("$GENERATION_TOOL$");
    private final Token toolNameToken = new Token("$TOOL_NAME$");
    private final Token versionToken = new Token("$COMPILER_VERSION$");

    private final Token[] tokens = {guidToken, dateToken, generationToolToken, toolNameToken, versionToken};
    private final SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    private final List<Openable> dependentFiles = new ArrayList<>();
    private Openable source;
    private boolean hasProcessedFiles;


    public GUIDManager(String vendorName, String compilerVersion) {
        generationToolToken.setValue(vendorName);
        toolNameToken.setValue(vendorName);
        versionToken.setValue(compilerVersion);
    }

    public String getGuidToken() {
        return guidToken.getStringOrValue(hasProcessedFiles);
    }

    public String getDateToken() {
        return dateToken.getStringOrValue(hasProcessedFiles);
    }

    public String getGenerationToolToken() {
        return generationToolToken.getStringOrValue(hasProcessedFiles);
    }

    public String getToolNameToken() {
        return toolNameToken.getStringOrValue(hasProcessedFiles);
    }
    
    public String getCompilerVersionToken() {
        return versionToken.getStringOrValue(hasProcessedFiles);
    }

    public void setSourceFile(File source) {
        this.source = new FileOpenable(source.toPath());
    }

    public void setSourceFile(Path source) {
        this.source = new FileOpenable(source);
    }

    public void setSourceString(String source) {
        this.source = new StringOpenable(source, null);
    }

    public void addDependentFile(File dependentFile) {
        dependentFiles.add(new FileOpenable(dependentFile.toPath()));
    }

    public void addDependentFile(Path dependentFile) {
        dependentFiles.add(new FileOpenable(dependentFile));
    }

    public void addDependentString(String input, ByteArrayOutputStream output) {
        dependentFiles.add(new StringOpenable(input, output));
    }
    
    public ArrayList<String> filesMd5 = new ArrayList<String>();

    public void printFileChecksums(ModelicaLogger log) {
        for (String fileMd5 : filesMd5) {
            log.debug(fileMd5);
        }
    }

    public void computeFileChecksum(Reader file, String fileName, ModelicaLogger log) {
        String checksum = calculateMD5Checksum(file);
        filesMd5.add("Generated file "+ fileName + " with checksum " + checksum);
    }

    private String getGuid() {
        String guid = calculateMD5Checksum(new InputStreamReader(source.openInput()));
        for (Token token : tokens) {
            token.resetFoundFirst();
        }

        return guid;
    }
    
    public String calculateMD5Checksum(Reader r) {
        try {
            final MessageDigest md5 = MessageDigest.getInstance("MD5");

            try (final BufferedReader reader = new BufferedReader(r)) {
                String line = reader.readLine();
                while (line != null) {
                    // A naive implementation that is expected to create a digest different from what a command
                    // line tool would create. No lines breaks are included in the digest, and no
                    // character encodings are specified.
                    md5.update(line.getBytes(Charset.forName("UTF-8")));
                    line = reader.readLine();
                }
            }
        return new BigInteger(1,md5.digest()).toString(16);
        
        }  catch (IOException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String getDate() {
        return dateformat.format(new Date());
    }

    public void processDependentFiles() {
        guidToken.setValue(getGuid());
        dateToken.setValue(getDate());
        hasProcessedFiles = true;
        
        for (final Openable openable : dependentFiles) {
            try {
                try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
                    processFiles(openable.openInput(), os);
                    try (PrintWriter writer = new PrintWriter(openable.openOutput())) {
                        writer.append(os.toString());
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void processFiles(InputStream source, OutputStream destination) throws IOException {
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(source));
             final PrintWriter writer = new PrintWriter(destination)) {

            String line =  reader.readLine();
            while (line != null) {
                for (Token token : tokens) {
                    if (!token.hasfoundFirst() && line.contains(token.getString())) {
                        token.foundFirst();
                        line = line.replaceFirst(token.getRegex(), token.getValue());
                    }
                }

                writer.write(line);
                writer.write('\n');
                line = reader.readLine();
            }
        }
        for (Token token : tokens) {
            token.resetFoundFirst();
        }
    }

    private static class Token {
        private String string;
        private String regex;
        private String value;
        private boolean foundFirst;
        
        public Token(String string) {
            this.string = string;
            regex = string.replace("$", "\\$");
        }
        
        public String getString() {
            return string;
        }
        
        public String getRegex() {
            return regex;
        }
        
        public String getValue() {
            return value;
        }
        
        public String getStringOrValue(boolean getValue) {
            return getValue ? getValue() : getString();
        }
        
        public void setValue(String value) {
            this.value = value;
        }
        
        public boolean hasfoundFirst() {
            return foundFirst;
        }
        
        public void foundFirst() {
            foundFirst = true;
        }
        
        public void resetFoundFirst() {
            foundFirst = false;
        }
    }

    private static interface Openable {
        public InputStream openInput();
        public OutputStream openOutput();
    }
    
    private static class FileOpenable implements Openable {
        private Path path;
        
        public FileOpenable(Path file) {
            this.path = file;
        }
        
        @Override
        public InputStream openInput() {
            try {
                return Files.newInputStream(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        
        @Override
        public OutputStream openOutput() {
            try {
                return Files.newOutputStream(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        
        @Override
        public String toString() {
            return path.toString();
        }
    }
    
    private static class StringOpenable implements Openable {
        
        private String input;
        private ByteArrayOutputStream output;
        
        public StringOpenable(String input, ByteArrayOutputStream output) {
            this.input = input;
            this.output = output;
        }
        
        @Override
        public InputStream openInput() {
            return new ByteArrayInputStream(input.getBytes());
        }
        
        @Override
        public OutputStream openOutput() {
            return output;
        }
    }
}
