package api;

import static io.restassured.RestAssured.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.prashant.api.ApiHelpers;
import org.prashant.api.Payloads;
import org.prashant.beans.GetCourse;
import org.testng.annotations.Test;

public class ApiTests {

    /* @Test(enabled = false)
     public void testFirstApi() {
         //RestAssured works on , Given , when and then
         //given - all input details
         //when - Submit the api- Resource and http method
         //Then - validate the response

         RestAssured.baseURI = "https://rahulshettyacademy.com";

         Response response = given().queryParam("key", "qaclick123").header("Content-Type", "Application/json").body(Payloads.getAddPlacePayload()).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

         JsonPath jsonPath = ApiHelpers.rawToJson(response);
         String placeId = jsonPath.getString("place_id");

         String response2 = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "Application/json").body("{\n" + "\"place_id\":\"" + placeId + "\",\n" + "\"address\":\"70 winter walk, USA\",\n" + "\"key\":\"qaclick123\"\n" + "}").when().put("maps/api/place/update/json").then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated")).extract().asString();

         String response3 = given().log().all().queryParam("place_id", placeId).queryParam("key", "qaclick123").when().get("maps/api/place/get/json").then().assertThat().statusCode(200).extract().response().asString();

         JsonPath jsonPath1 = ApiHelpers.rawToJson(response3);
         String address = jsonPath1.getString("address");
         System.out.println(address);
         Assert.assertEquals(address, "70 winter walk, USA");
     }


     @Test(enabled = false)
     public void parseComplexJson() {

         JsonPath jsonPath = ApiHelpers.rawToJson(Payloads.CoursePrice());
         System.out.println(jsonPath.getString("courses[0].title"));

         for (int i = 0; i < jsonPath.getInt("courses.size()"); i++) {
             String title = jsonPath.getString("courses[" + i + "].title");
             String price = jsonPath.getString("courses[" + i + "].price");
             System.out.println("Title " + title + " Price " + price);
         }
     }
 */
    @Test(enabled = false)
    public void advancedPayloadCreation() {

        baseURI = "https://rahulshettyacademy.com";

        String resource = "/Library/Addbook.php";

        Response responce = given().header("Content-Type", "application/json").body(Payloads.addBook()).when().put(resource).then().assertThat().statusCode(200).extract().response();

        JsonPath jspath = ApiHelpers.rawToJson(responce);

        String id = jspath.getString("ID");

        System.out.println(id);
    }

    @Test(enabled = true)
    public void testOAuth() {

        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addFormParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").addFormParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").addFormParam("grant_type", "client_credentials").addFormParam("scope", "trust").setContentType("Application/json").build();

        Response response = given().spec(spec).log().all().when().post("/oauthapi/oauth2/resourceOwner/token").then().log().all().extract().response();

        JsonPath jsonPath = ApiHelpers.rawToJson(response);

        String accessToken = jsonPath.getString("access_token");

        GetCourse getCourse = given().queryParams("access_token", accessToken).when().log().all().get("/oauthapi/getCourseDetails").as(GetCourse.class);

        System.out.println(getCourse.toString());

    }

    @Test
    public void testOAuth2() {






    }


}
