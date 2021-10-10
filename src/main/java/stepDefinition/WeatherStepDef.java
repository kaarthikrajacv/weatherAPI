package stepDefinition;

import dataFramework.Datatable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WeatherStepDef {

    RequestSpecification request;
    Response response;
    Map<String, Object> queryParamMap;
    Datatable datatable;
    Scenario scenario;

    @Before
    public void initialiseDataTable(Scenario scenario) throws Exception {
        this.scenario = scenario;
        datatable = new Datatable("src/main/resources/excel/weather1.xls");
        datatable.createConnection();

    }

    @Given("The OpenWeather MAP API end point")
    public void initialiseWeatherEndPoint(){
        System.out.println("The program has entered end point method");
        RestAssured.baseURI = "https://api.openweathermap.org";
    }

    @When("Required data like API key & City is given")
    public void populateData() throws IOException {
        System.out.println("The program has entered data population method");
        request = RestAssured.given();

        // Get data from excel...
        String city = datatable.getDataFromExcel(scenario.getName().trim(), "city");
        String appId = datatable.getDataFromExcel(scenario.getName().trim(), "appId");

        System.out.println("The city is " + city +" and the app id is " + appId);
        //This is the map for Weather API query params...
        queryParamMap = new HashMap<>();
        queryParamMap.put("q", city);
        queryParamMap.put("appid",appId);
    }

    @Then("Hit the Weather API and print the response in Console")
    public void getWeatherAPIResults() throws IOException {

        response = request.given().queryParams(queryParamMap).when().get(datatable.getDataFromExcel(scenario.getName().trim(), "endpoint"));
        System.out.println("The response is ");
        System.out.println(response.prettyPrint());

        String cityResponse = response.jsonPath().getString("name");
        //Soft Assertions...
        SoftAssertions softAssertions = new SoftAssertions();


        softAssertions.assertThat("hi").isEqualTo("hi");
        if(scenario.getName().contains("mumbai")) {
            softAssertions.assertThat(cityResponse).isEqualTo("mumbai");
            Assert.assertEquals("Mumbai", cityResponse);
        } else{
            Assert.assertEquals("Chennai", cityResponse);
        }

        softAssertions.assertAll();
    }


    @When("We parametarise {string} along with API key {string}")
    public void getWeatherDetailsForVariousCities(String city, String number){
        System.out.println("The number is " + Long.valueOf(number));
        System.out.println("The Cucumber has entered the parameterised weather details for CITY " + city);
        request = RestAssured.given();
        //This is the map for Weather API query params...
        queryParamMap = new HashMap<>();
        queryParamMap.put("q", city);
        queryParamMap.put("appid","5661a8ed7941f24452984807b47e5b89");

    }







}
