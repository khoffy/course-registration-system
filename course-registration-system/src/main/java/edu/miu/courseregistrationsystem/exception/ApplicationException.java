package edu.miu.courseregistrationsystem.exception;

/**
 * @author Koffi
 * @version %I% %G%
 * @since 12/22/2022
 */
public class ApplicationException extends Exception{

    public ApplicationException() {
        super();
    }

    public ApplicationException(String errorMsg) {
        super(errorMsg);
    }
}
