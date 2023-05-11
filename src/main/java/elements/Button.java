package elements;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface Button extends AtlasWebElement  {
    @FindBy(".//button[contains(.,'{{ value }}')] | .//a[contains(.,'{{ value }}')]")
    AtlasWebElement button(@Param("value") String value);

    @FindBy(".//li[a[contains(.,'{{ value }}')]]")
    AtlasWebElement tab(@Param("value") String value);

    @FindBy(".//div/a[contains(.,'{{ value }}')] | .//a[contains(.,'{{ value }}')]/parent::li")
    AtlasWebElement link(@Param("value") String value);

    @FindBy("//a[@id='logo']")
    AtlasWebElement logo();
}
