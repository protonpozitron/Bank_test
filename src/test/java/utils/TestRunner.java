package src.test.java.utils;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "cucumber.glue", value = "steps")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, json:target/cucumber.json")
@ConfigurationParameter(key = "cucumber.filter.tags", value = "@1")
public class TestRunner {
}