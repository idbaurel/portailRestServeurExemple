package fr.infodb.exemples.portail.rest.serveur.dto;

import fr.infodb.exemples.portail.rest.serveur.dto.constants.TypeLoginHomepageMessageEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aurelien
 * créé le 10/01/18.
 */
public class LoginHomepageMessages implements Serializable {

    private final static long serialVersionUID = 1L;

    private final List<LoginHomepageMessage> messages = new ArrayList<>();

    public List<LoginHomepageMessage> getMessages() {
        return messages;
    }

    public static class LoginHomepageMessage implements Serializable {

        private final static long serialVersionUID = 1L;
        /**
         * Le message
         */
        private String message;

        /**
         * Le type de message
         */
        private TypeLoginHomepageMessageEnum type;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public TypeLoginHomepageMessageEnum getType() {
            return type;
        }

        public void setType(TypeLoginHomepageMessageEnum type) {
            this.type = type;
        }
    }
}
