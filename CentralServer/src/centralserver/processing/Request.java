package centralserver.processing;

/**
 *
 * @author Asus
 */
public class Request {

    RequestProcessor _processor;
    String _command;
    String[] _pTCs;
    String _file;
    int _size;
    String _fileName;
    String _iP;
    int _port;

    /**
     *
     * @param processor
     * @param command
     * @param pTCs
     * @param file
     * @param size
     * @param fileName
     * @param iP
     * @param port
     */
    public Request(RequestProcessor processor, String command, String[] pTCs, String file, int size, String fileName, String iP, int port) {
        _processor = processor;
        _command = command;
        _pTCs = pTCs;
        _file = file;
        _size = size;
        _fileName = fileName;
        _iP = iP;
        _port = port;
    }

    Report process() {
        return _processor.process(this);
    }
    
     public RequestProcessor getProcessor() {
        return _processor;
    }

    public String getCommand() {
        return _command;
    }

    public String[] getpTCs() {
        return _pTCs;
    }

    public String getFile() {
        return _file;
    }

    public int getSize() {
        return _size;
    }

    public String getFileName() {
        return _fileName;
    }

    public String getiP() {
        return _iP;
    }

    public int getPort() {
        return _port;
    }
}