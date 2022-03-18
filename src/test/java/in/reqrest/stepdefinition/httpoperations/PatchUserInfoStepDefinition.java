package in.reqrest.stepdefinition.httpoperations;

import in.reqrest.stepdefinition.setup.services.ServiceSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static in.reqrest.util.PatchUserDataJSONConverter.updateUserBody;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class PatchUserInfoStepDefinition extends ServiceSetUp {
    private static Logger LOGGER = Logger.getLogger(PatchUserInfoStepDefinition.class);

    private Response response;
    private RequestSpecification request;

    @Given("El usuario esta en la pagina para actualizar su informacion con el nombre {string} y el trabajo {string}")
    public void elUsuarioEstaEnLaPaginaParaActualizarSuInformacionConElNombreYElTrabajo(String name, String job) {
        try {
            generalSetup();
            request = given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(updateUserBody(name, job));
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @When("el usuario realiza la peticion de actualizacion de datos con el id {int}")
    public void elUsuarioRealizaLaPeticionDeActualizacionDeDatosConElId(Integer id) {
        try {
            response = request.when()
                    .patch(USER_PATCH_AND_DELETE + id);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Then("el usuario debera ver un codigo de respuesta exitoso y su informacion completa actualizada")
    public void elUsuarioDeberaVerUnCodigoDeRespuestaExitosoYSuInformacionCompletaActualizada() {
        try {
            //Se obtiene la fecha y hora actual (UTC)
            LocalDateTime plainTodayDate = LocalDateTime.now(ZoneOffset.UTC);
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedTodayDate = plainTodayDate.format(format);

            /* Se verifica el código 200 y que el campo "updatedAt" de la respuesta
            contenga la fecha completa y la hora y minutos en que se ejecutó el test.
            No se usan segundos porque el response y la verificación no son en el mismo
            instante y podrían haber problemas si cambia de segundo. */
            response.then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("updatedAt", containsString(formattedTodayDate.substring(0,10)))
                    .body("updatedAt", containsString(formattedTodayDate.substring(11,16)));
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
