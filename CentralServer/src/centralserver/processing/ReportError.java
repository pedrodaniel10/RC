/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralserver.processing;

/**
 *
 * @author Asus
 */
public class ReportError extends Report {
    //Error
    private String _error;

    /**
     *
     * @param _nameAdress
     * @param _iP
     * @param _port
     */
    public ReportError(String _nameAdress, String _iP, int _port, String error) {
        super(_nameAdress, _iP, _port);
        
        _error = error;
    }

    /**
     *
     * @return
     */
    public String getError() {
        return _error;
    }
    
    
}
