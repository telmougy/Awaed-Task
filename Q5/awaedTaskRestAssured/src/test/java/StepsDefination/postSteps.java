package StepsDefination;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;


public class postSteps {

    JSONObject request = new JSONObject();

    @Given("the user can add new record through post operation")
    public void the_user_can_add_new_record_through_post_operation() {
        request.put("firstName", "Tarek");
        request.put("lastName", "Elmougy");
        request.put("email", "t.mougy@gmail.com");
        request.put("active", true);
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).when().
                post("https://63fe35bb571200b7b7c75edc.mockapi.io/awaed/users").
                then().
                statusCode(201);

    }
    @Then("the new record should be returned when performing get operation")
    public void the_new_record_should_be_returned_when_performing_get_operation() {
        given().get("https://63fe35bb571200b7b7c75edc.mockapi.io/awaed/users").then().assertThat().body("firstName[10]",equalTo("Tarek"));

    }
@AfterAll
    public static void  deleteNewRecord(){
        given().delete("https://63fe35bb571200b7b7c75edc.mockapi.io/awaed/users/11").then().statusCode(200);
}
}
