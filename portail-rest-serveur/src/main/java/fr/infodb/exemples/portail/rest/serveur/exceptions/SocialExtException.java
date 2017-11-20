package fr.infodb.exemples.portail.rest.serveur.exceptions;


/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 15/01/13
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 */
public class SocialExtException extends Exception {

	private static final long serialVersionUID = 1L;

    public SocialExtException(String msg) {
        super(msg);
    }

    public SocialExtException(String msg, Exception e) {
        super(msg, e);
    }
    
    public SocialExtException(Throwable cause) {
    	super(cause);
    }
    
}
