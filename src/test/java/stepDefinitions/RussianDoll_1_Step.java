package stepDefinitions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIHelper.ApiIntegrationUtil;
import utils.APIHelper.PropertyFileReader;
import utils.APIHelper.ResponseHelper;
import utils.APIHelper.RuntimeData;
import utils.POJOS.CustomerPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class RussianDoll_1_Step {
    private RequestSpecification request;
    private Response response;
    private CustomerPojo customer;


    public static void statusCode(Response response, int code) {
        response.then().log().all().statusCode(code);
    }

    @Given("I have extracted russian doll base firstname")
    public void i_have_extracted_russian_doll_base_firstname() {
        request = given().headers(PropertyFileReader.getFullHeader()).log().headers();
    }

    @Given("I use customer dynamic header for doll")
    public void i_use_customer_dynamic_header_for_doll() {
        request = given().headers(PropertyFileReader.getDynamicFullHeader()).log().headers();
    }

    @Given("I have the data to create Russian Doll with {string},{string},{string},{string}")
    public void i_have_the_data_to_create_Russian_Doll_with(String address1, String address2, String lastName, String phone) {
        ArrayList<String> addresses = new ArrayList<String>();
        addresses.add(address1);
        addresses.add(address2);
        customer = new CustomerPojo();
        customer.setFirstName(RuntimeData.getInstance().getRussianDollVariable());
        customer.setLastName(lastName);
        customer.setPhone(phone);
        customer.setAddresses(addresses);
    }

    @When("I create post request to create russian doll one")
    public void i_create_post_request_to_create_russian_doll_one() {
        String apiPath = PropertyFileReader.getUrl();
        response = ApiIntegrationUtil.getInstance().createPostRequest(request,customer,apiPath);

    }

    @Then("I get status code {int} from doll")
    public void i_get_status_code_from_doll(Integer code) {

        RussianDoll_1_Step.statusCode(response, code);
    }

    @Then("response body Russian Doll one should contain")
    public void response_body_Russian_Doll_one_should_contain(List<String> responseMap) {
        ResponseHelper.responseValidations(response, responseMap);

        }
    }

