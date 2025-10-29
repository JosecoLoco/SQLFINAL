package edu.udla.isw;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class App extends RouteBuilder {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.configure().addRoutesBuilder(new App());
        main.run(args);
    }

    @Override
    public void configure() {
        from("file:/C:/Users/Jose Perez/Desarrollo/IntegracionSistemas/camel-labs/lab01/input?noop=true")
            .log("Procesando archivo: ${file:name}")
            .to("file:/C:/Users/Jose Perez/Desarrollo/IntegracionSistemas/camel-labs/lab01/output");
    }
}
