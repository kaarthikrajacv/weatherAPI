package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HelloWorldStepDef {

    public String input;

    @Given("I initialise a field with Hello World string")
    public void initialiseHelloWorld(){
        System.out.println("The program has entered Initialise method");
        input = "Hello World";
    }

    @Then("Print Hello world")
    public void printHelloWorld(){
        System.out.println("The program has entered Print method");
        System.out.println(input);
    }

}
