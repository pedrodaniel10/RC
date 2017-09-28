/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserver;

/**
 * All constant
 */
public final class Constants {
    //Constant values
    public static final String DEFAULT_HOST = "hostname";

    public static final int DEFAULT_PORT = 58063;

    //Request Error Messages
    /**
     *Message: Nothing received from CS.
     */
    public static final String REQ_NULL = "Nothing received from CS.\n";

    /**
     *Message: Request cannot be answered by the CS.
     */
    public static final String REQ_EOF = "Request cannot be answered by the CS.\n";

    /**
     *Message: Error request to the CS.
     */
    public static final String REQ_ERR = "Error request to the CS.\n";

    //Argument Error Messages
    /**
     *Message: Too few arguments.
     */
    public static final String ARG_LESS = "Too few arguments.\n";

    /**
     *Message: Too many arguments.
     */
    public static final String ARG_HIGH = "Too many arguments.";

    /**
     *Message: PTC is not correct.
     */
    public static final String ARG_PTCERR = "PTC is not correct.\n";

    //Files Error Messages
    /**
     *Message: File not founded.
     */
    public static final String FILE_NFOUND = "File not founded.\n";

    //Protocol Error Messages
    /**
     *Message: Message received does't follow the protocol.
     */
    public static final String PT_NFOLLOW = "Message received does't follow the protocol.\n";

    //Socket Error Messages
    /**
     *Message: Unknown host: [hostname]
     */
    public static final String SOCK_UHOST = "Unknown host: ";

    /**
     *Message: Couldn't get I/O for the connection to [hostname]
     */
    public static final String SOCK_IOERR = "Couldn't get I/O for the connection to ";


}
