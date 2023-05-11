package elements;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface InputField extends AtlasWebElement {
    @FindBy(".//input[contains(@placeholder,'{{ value }}')]")
    AtlasWebElement logPassField(@Param("value") String value);

    @FindBy("//label[normalize-space(.)='{{ value }}']/following::input[1]")
    AtlasWebElement inputField(@Param("value") String value);

    @FindBy("//label[normalize-space(.)='{{ value }}' ]/following::input[1 and @class[contains(.,'error')]]")
    AtlasWebElement inputRedError(@Param("value") String value);
}
