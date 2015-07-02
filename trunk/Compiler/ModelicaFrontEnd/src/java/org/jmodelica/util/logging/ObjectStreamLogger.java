package org.jmodelica.util.logging;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.jmodelica.util.logging.units.LoggingUnit;

public class ObjectStreamLogger extends PipeLogger {
    
    public static final byte[] START_BYTES = new byte[]{ 74, 77, 54, 46, 50, 56, 51, 49, 56, 53, 51 };
    
    public ObjectStreamLogger(Level level, String filename) throws IOException {
        super(level, filename);
    }
    
    public ObjectStreamLogger(Level level, File file) throws IOException {
        super(level, file);
    }
    
    public ObjectStreamLogger(Level level, OutputStream stream) throws IOException {
        super(level, createStream(stream));
    }
    
    @Override
    public void do_close() throws IOException {
        getStream().writeObject(null);
        super.do_close();
    }

    @Override
    protected OutputStream createStream(File file) throws IOException {
        return createStream(super.createStream(file));
    }
    
    @Override
    protected ObjectOutputStream getStream() {
        return (ObjectOutputStream) super.getStream();
    }
    
    @Override
    protected void do_write(LoggingUnit logMessage) throws IOException {
        getStream().writeObject(logMessage);
    }

    private static ObjectOutputStream createStream(OutputStream stream) throws IOException {
        stream.write(START_BYTES);
        return new ObjectOutputStream(stream);
    }
}
