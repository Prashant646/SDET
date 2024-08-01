package org.prashant.api;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiHelpers {
    public static JsonPath rawToJson(Response jsonAsString) {
        String responce =  jsonAsString.asString();
        JsonPath jsonPath = new JsonPath(responce);
        return jsonPath;
    }
}
