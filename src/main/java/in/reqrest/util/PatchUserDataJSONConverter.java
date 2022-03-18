package in.reqrest.util;

import org.apache.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Paths;

import static in.reqrest.util.PatchUserJSONKey.JOB;
import static in.reqrest.util.PatchUserJSONKey.NAME;

public class PatchUserDataJSONConverter {
    public static Logger LOGGER = Logger.getLogger(PatchUserDataJSONConverter.class);
    private static final String JSON_PATH = "src/test/resources/files/patchuser/patchUser.json";

    //función para convertir en string el json de actualizar usuario
    public static String updateUserBody(String name, String job) {
        String result;
        try {
            result = new String(Files.readAllBytes(Paths.get(JSON_PATH)));
            result = result.replace(NAME.getValue(), name);
            result = result.replace(JOB.getValue(), job);
            return result;
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            return "";
        }
    }
}
