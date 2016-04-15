/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.integral.database;

/**
 *
 * @author cassisi
 */
public class DataBaseException extends Exception {

    private static final long serialVersionUID = 1L;

    public DataBaseException() {
        super();
    }

    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataBaseException(String message) {
        super(message);
    }

    public DataBaseException(Throwable cause) {
        super(cause);
    }
}
