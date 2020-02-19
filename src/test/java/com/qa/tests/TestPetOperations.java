package com.qa.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Category;
import com.qa.data.Pet;
import com.qa.data.TagsArrayElement;
import com.qa.util.TestUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class TestPetOperations extends TestBase {
    TestBase testBase;
    RestClient restClient;
    String apiurl;
    HashMap <String,String> headers = new HashMap<String, String>();

    @BeforeTest
    public void setUp() {
        testBase = new TestBase();
        apiurl = prop.getProperty("URL");
    }

    @DataProvider
    public Iterator<Object[]> getTestData(Method m) throws IOException {
        ArrayList<Object[]> testData = TestUtil.getDataFromExcel(m);
        return testData.iterator();
    }

    @Test(dataProvider = "getTestData")
    public void testfindByStatus(String status) throws IOException {
        System.out.println(apiurl+"/pet/findByStatus?status="+status);
        restClient = new RestClient();
        CloseableHttpResponse httpResponse = restClient.Get(apiurl+"/pet/findByStatus?status="+status);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(RESPONSE_ERROR_CODE_200,statusCode);
    }

    @Test(dataProvider = "getTestData")
    public void testfindByTags(String tags) throws IOException {
        System.out.println(apiurl+"/pet/findByTags?tags="+tags);
        restClient = new RestClient();
        CloseableHttpResponse httpResponse = restClient.Get(apiurl+"/pet/findByTags?tags="+tags);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(RESPONSE_ERROR_CODE_200,statusCode);
    }

    @Test(dataProvider = "getTestData")
    public void testfindByPetId(String petId) throws IOException {
        System.out.println(apiurl+"/pet/"+petId);
        restClient = new RestClient();
        CloseableHttpResponse httpResponse = restClient.Get(apiurl+"/pet/"+petId);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(RESPONSE_ERROR_CODE_200,statusCode);
    }

    @Test
    public void testUpdatePet() throws IOException {
        System.out.println(apiurl+"/pet");
        restClient = new RestClient();
        ObjectMapper mapper = new ObjectMapper();
        Category category = new Category(1,"gaurav");
        TagsArrayElement tagsArrayElement = new TagsArrayElement(1,"Sumit");
        ArrayList< Object > photoUrls = new ArrayList<Object>(Arrays.asList("string"));
        ArrayList < Object > tags = new ArrayList <Object> (Arrays.asList(tagsArrayElement));
        Pet pet = new Pet(1,"Amit", category,photoUrls, tags, "available");
//Object to JSON file
        mapper.writeValue(new File("src/main/java/com/qa/data/pet.json"),pet);

        //object to JSON in string
        String petString  = mapper.writeValueAsString(pet);
        System.out.println(petString);
        headers.put("Content-Type", "application/json");
        CloseableHttpResponse httpResponse = restClient.put(apiurl+"/pet",petString,headers);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(RESPONSE_ERROR_CODE_200,statusCode);
    }
}
