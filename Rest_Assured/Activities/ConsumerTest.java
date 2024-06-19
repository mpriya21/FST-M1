package pactproject;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    Map<String,String> headers= new HashMap<>();

    //create contract
    @Pact(consumer= "UserConsumer" , provider= "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){

        headers.put("Content-Type", "application/json");

        DslPart requestResponseBody= new PactDslJsonBody()
                .numberType("id", 100)
                .stringType("firstName", "Sai")
                .stringType("lastName", "S")
                .stringType("email", "sais@gmail.com");

        return builder.given("POST Request")
                .uponReceiving("Request to create user")
                .method("POST")
                .path("/api/users")
                .headers(headers)
                .body(requestResponseBody)
                .willRespondWith()
                .status(201)
                .body(requestResponseBody)
                .toPact();
    }

    @Test
    @PactTestFor(providerName = "UserProvider" , port= "8282")
    public void consumerTest(){
        Map<String,Object> reqBody= new HashMap<>();
        reqBody.put("id", 100);
        reqBody.put("firstName", "Sai");
        reqBody.put("lastName", "S");
        reqBody.put("email", "sais@gmail.com");

        given().baseUri("http://localhost:8282/api/users")
                .headers(headers)
                .body(reqBody)
                .log().all()
                .when().post()
                .then().statusCode(201)
                .body("email", equalTo("sais@gmail.com"))
                .log().all();

    }
}
