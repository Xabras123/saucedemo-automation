package com.saucedemo.base;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import java.io.File;
import java.io.IOException;
import java.util.Map;


public abstract class BaseTest<T> {
    protected WebDriver driver;
    protected Map<String, T> testCases;

    private final String dataFileName;
    private final Class<T> modelClass;
    private final static String PATH = "src/test/resources/data/";


    public BaseTest(String dataFileName, Class<T> modelClass) {
        this.dataFileName = dataFileName;
        this.modelClass = modelClass;
    }

    @BeforeEach
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        ObjectMapper mapper = new ObjectMapper();
        File file = new File(PATH + dataFileName);
        testCases = mapper.readValue(file,
                mapper.getTypeFactory().constructMapType(Map.class, String.class, modelClass));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
