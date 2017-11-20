package fr.infodb.exemples.portail.rest.serveur.config;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

/**
 * Configuration de swagger.
 * <p>
 * Swagger est un framework pour les API web.
 * Il est utilisé pour documenter en ligne les web services.
 * <p>
 * L'IHM exposé par Swagger est accessible à l'url "http://host:port/context/swagger-ui.html"
 * <p>
 * La description de l'api exposée est accessible à l'url "http://host:port/context/v2/api-docs".
 * Cette description permet d'obtenir le code client pour interagir avec l'api via un générateur de code comme swagger-codegen ou même SoapUI.
 *
 * @author aurelien
 * créé le 20/11/17.
 * @see "http://swagger.io"
 * @see "http://swagger.io/swagger-codegen"
 * @see "https://github.com/swagger-api/swagger-codegen"
 * @see "https://www.soapui.org"
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String SCAN_BASE_PACKAGE = "fr.infodb.exemples.portail.rest.serveur";
    private static final String SCAN_ALL_PACKAGES = "all";

    @Value(SCAN_BASE_PACKAGE)
    private String packageSelector;

    /**
     * Configuration du bean Swagger
     *
     * @return Configuration de Swagger
     * @see "https://springfox.github.io/springfox/docs/current/#quick-start-guides"
     */
    @Bean
    public Docket api() {

        final Set<String> mediaTypeSet = new HashSet<>(1);
        mediaTypeSet.add(MediaType.APPLICATION_JSON_UTF8.toString());

        return new Docket(DocumentationType.SWAGGER_2)
                .produces(mediaTypeSet)
                .consumes(mediaTypeSet)
                .select()
                .apis(getPackageSelector())
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * Filtrer les web services exposés par swagger.
     * <p>
     * Le filtre est réalisé via un scan des packages java.
     */
    private Predicate<RequestHandler> getPackageSelector() {
        final Predicate<RequestHandler> predicate;
        if (SCAN_ALL_PACKAGES.equals(packageSelector)) {
            //tout est exposé, même ce qui provient des frameworks
            predicate = RequestHandlerSelectors.any();
        } else {
            //filtre à partir de la racine d'un package
            final String packageFilter = StringUtils.trimAllWhitespace(packageSelector);
            predicate = RequestHandlerSelectors.basePackage(StringUtils.isEmpty(packageFilter) ? SCAN_BASE_PACKAGE : packageFilter);
        }
        return predicate;
    }
}
