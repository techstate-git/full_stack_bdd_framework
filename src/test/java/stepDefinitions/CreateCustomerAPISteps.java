package stepDefinitions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.POJOS.CustomerPojo;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateCustomerAPISteps {

    CustomerPojo customer = new CustomerPojo();
    private RequestSpecification request;
    private Response response;
    @Given("I have the data to create customer with {string},{string},{string},{string},{string}")
    public void i_have_the_data_to_create_customer_with(String firstName, String lastName, String phone, String address1, String address2) throws Throwable {

        ArrayList<String> addresses = new ArrayList<String>();
        addresses.add(address1);
        addresses.add(address2);

        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhone(phone);
        customer.setAddresses(addresses);}

    @Given("I use customer header")
    public void i_use_customer_header() {
        request = given()
                .header("Content-Type","application/json")
                .header("Accept-Charset","UTF-8")
                .log()
                .headers();
    }

    @When("I create post request to create customer")
    public void i_create_post_request_to_create_customer() {
        response = request.when()
                .body(customer)
                .log()
                .body()
                .post("https://jsonplaceholder.typicode.com/users");
    }

    @Then("I get status code {int} from database")
    public void i_get_status_code_from_database(Integer statusCode) {
        response.then().statusCode(statusCode).log().all();
    }

    @Then("response body should contain")
    public void response_body_should_contain(io.cucumber.datatable.DataTable dataTable) {

    }

}
