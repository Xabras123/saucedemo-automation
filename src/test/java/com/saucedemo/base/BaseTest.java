package com.saucedemo.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saucedemo.model.testcasesmodels.CheckoutTestCaseModel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Map;



public class BaseTest {
    protected WebDriver driver;
    protected Map<String, CheckoutTestCaseModel> testCases;


    @BeforeEach
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/test/resources/data/checkoutCases.json");
        testCases = mapper.readValue(file,
                mapper.getTypeFactory().constructMapType(Map.class, String.class, CheckoutTestCaseModel.class));

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
