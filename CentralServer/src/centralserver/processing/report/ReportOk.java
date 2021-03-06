package centralserver.processing.report;

/**
 * Reports that follow the protocol
 */
public class ReportOk extends Report {
    private String _command;
    private String[] _pTCs;
    private String _file;
    private int _size;
    private char _rT;

    /**
     *
     * @param nameAdress
     * @param iP
     * @param port
     * @param command
     * @param pTCs
     * @param file
     * @param size
     * @param rT
     */
    public ReportOk(String nameAdress, String iP, int port,
                    String command, String[] pTCs, String file, int size, char rT) {
        super(nameAdress, iP, port);
        _command = command;
        _pTCs = pTCs;
        _file = file;
        _size = size;
        _rT = rT;
    }

    /**
     *
     * @param nameAdress
     * @param iP
     * @param port
     * @param file
     * @param size
     * @param rT
     */
    public ReportOk(String nameAdress, String iP, int port, String file, int size, char rT) {
        super(nameAdress, iP, port);
        _file = file;
        _size = size;
        _rT = rT;
    }

    /**
     *
     * @param nameAdress
     * @param iP
     * @param port
     * @param command
     * @param pTCs
     */
    public ReportOk(String nameAdress, String iP, int port, String command, String[] pTCs) {
        this(nameAdress, iP, port, command, pTCs, null, 0, '\0');
    }

    /**
     *
     * @return command
     */
    public String getCommand() {
        return _command;
    }

    /**
     *
     * @return pTCs
     */
    public String[] getpTCs() {
        return _pTCs;
    }

    /**
     *
     * @return file
     */
    public String getFile() {
        return _file;
    }

    /**
     *
     * @return size
     */
    public int getSize() {
        return _size;
    }

    /**
     *
     * @return
     */
    public char getRT() {
        return _rT;
    }

    @Override
    public String toString() {
        return "REP " + _rT + " " + _size + " " + _file + "\n";
    }

}
