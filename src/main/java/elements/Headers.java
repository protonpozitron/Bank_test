package src.main.java.elements;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Headers extends AtlasWebElement{
    @FindBy(".//div[contains(text(),'{{ value }}')] | .//span[contains(text(),'{{ value }}')]")
    AtlasWebElement text(@Param("value") String value);

    @FindBy(".//div[h1[contains(.,'{{ value }}')]]")
    AtlasWebElement header(@Param("value") String value);

    @FindBy(".//label[contains(text(),'{{ value }}')]")
    AtlasWebElement label(@Param("value") String value);

    @FindBy(".//tr/td['{{ value }}']/descendant::span[@class='alias']")
    AtlasWebElement columnValue(@Param("value") String value);

    default String ge1tValue(String sentence) {

        String s =".//tr/td['"+sentence+"']/descendant::span[@class='alias']";
        Pattern p = Pattern.compile("(?:<span class=\"alias\">)([^\\)]*)(?:<\\/span>)");
        Matcher m = p.matcher(s);
        String temp=null;
        if (m.matches()) {
            temp = m.group(1);}
        return temp;

    }
}
