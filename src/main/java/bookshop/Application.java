package bookshop;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(
    info = @Info(
            title = "bookshop",
            version = "0.0"
    )
)
public class Application {

    public static void main(String[] args) {
        System.getProperties().setProperty("org.jooq.no-logo", "true");
        Micronaut.run(Application.class);
    }
}
