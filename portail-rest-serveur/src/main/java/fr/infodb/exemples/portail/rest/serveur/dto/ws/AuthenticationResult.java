package fr.infodb.exemples.portail.rest.serveur.dto.ws;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 22/05/13
 * Time: 11:53
 * To change this template use File | Settings | File Templates.
 */
public enum AuthenticationResult {
    OK(1), KO(0), EXPIRED(-1), NOT_SOCIAL_WORKER(-2), NO_PROFILE(-3), NO_USER(-4);

    final private Integer code;

    AuthenticationResult(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
