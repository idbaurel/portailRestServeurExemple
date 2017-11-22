package fr.infodb.exemples.portail.rest.serveur.exceptions;


/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 15/01/13
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 */
public class SocialExtException extends RuntimeException {

    public SocialExtException() {
        super();
    }

    public SocialExtException(String message) {
        super(message);
    }

    public SocialExtException(String message, Throwable cause) {
        super(message, cause);
    }

    public SocialExtException(Throwable cause) {
        super(cause);
    }
}
