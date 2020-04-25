package es.aivm.sgpm.exception;

/**
 * Created by AIVM on 22/04/2020.
 */
public class AccesLoginException extends Exception {

    @Override
    public String getMessage() {
        return "Los datos de acceso son erroneos.";
    }
}
