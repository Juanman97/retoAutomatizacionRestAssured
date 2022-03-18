package in.reqrest.stepdefinition.httpoperations;

import in.reqrest.stepdefinition.setup.services.ServiceSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class DeleteUserStepDefinition extends ServiceSetUp {
    private static Logger LOGGER = Logger.getLogger(DeleteUserStepDefinition.class);

    private Response response;
    private RequestSpecification request;

    @Given("El usuario esta en la pagina para eliminar su informacion")
    public void elUsuarioEstaEnLaPaginaParaEliminarSuInformacion() {
        try {
            generalSetup();
            request = given()
                    .log().all();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }
    @When("el usuario realiza la peticion de eliminacion de datos con el id {int}")
    public void elUsuarioRealizaLaPeticionDeEliminacionDeDatosConElId(Integer id) {
        try {
            response = request.when()
                    .delete(USER_PATCH_AND_DELETE + id);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @Then("el usuario debera ver un codigo de respuesta de eliminacion exitosa")
    public void elUsuarioDeberaVerUnCodigoDeRespuestaDeEliminacionExitosa() {
        try {
            //se espera un error 204 (no content)
            response.then()
                    .log().all()
                    .statusCode(HttpStatus.SC_NO_CONTENT);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
