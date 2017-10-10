/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralserver.processing.request;

import centralserver.processing.processor.WorkingServerRequestProcessor;

/**
 *
 * @author Asus
 */
public class RequestToWS extends Request {
    private final String _fileName;
    private final String _pTC;
    
    /**
     *
     * @param nameAdress
     * @param iP
     * @param port
     * @param fileName
     * @param pTC
     * @param processor
     */
    public RequestToWS(String nameAdress, String iP, int port, String fileName, String pTC, WorkingServerRequestProcessor processor) {
        super(nameAdress, iP, port, processor);
        _fileName = fileName;
        _pTC = pTC;
    }
    
    /**
     *
     * @return
     */
    public String getFileName() {
        return _fileName;
    }

    /**
     *
     * @return
     */
    public String getpTC() {
        return _pTC;
    }
    
}
