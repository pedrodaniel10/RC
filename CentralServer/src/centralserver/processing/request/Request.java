package centralserver.processing.request;

import centralserver.WSList;
import centralserver.exceptions.ConnectionException;
import centralserver.processing.processor.RequestProcessor;
import centralserver.processing.report.Report;

/**
 * Abstract class for Request
 */
public abstract class Request {
    //Client Request identifier
    private final String _nameAdress;
    private final String _iP;
    private final int _port;
    
     //Processor class of the request
    private final RequestProcessor _processor;

    /**
     *
     * @param _nameAdress
     * @param _iP
     * @param _port
     * @param _processor
     */
    public Request(String _nameAdress, String _iP, int _port, RequestProcessor _processor) {
        this._nameAdress = _nameAdress;
        this._iP = _iP;
        this._port = _port;
        
        this._processor = _processor;
    }

    /**
     *
     * @return
     */
    public String getNameAdress() {
        return _nameAdress;
    }

    /**
     *
     * @return
     */
    public String getIP() {
        return _iP;
    }

    /**
     *
     * @return
     */
    public int getPort() {
        return _port;
    }

    /**
     *
     * @return
     */
    public RequestProcessor getProcessor() {
        return _processor;
    }
    
    /**
     *
     * @param list
     * @return
     * @throws centralserver.exceptions.ConnectionException
     */
    public Report process(WSList list) throws ConnectionException {
        return _processor.process(this, list);
    }
     
}
