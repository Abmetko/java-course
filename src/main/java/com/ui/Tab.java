package com.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class Tab {

    public final SelenideElement COMPONENT_CONTAINER = $("div[role='tablist']");

    public ElementsCollection getTabs() {
        return COMPONENT_CONTAINER.$$("a[role='tab']");
    }

    public SelenideElement getTab(String name) {
        return getTabs().stream()
                .filter(menuItem -> menuItem.$("span.the-services__tab-text")
                        .getText()
                        .equalsIgnoreCase(name))
                .findFirst().orElseThrow();
    }

    public void openTab(String name) {
        getTab(name).shouldBe(Condition.enabled).shouldBe(Condition.visible).click();
    }

    public boolean isTabSelected(String name) {
        return Objects.requireNonNull(getTab(name).getAttribute("class")).contains("active show");
    }
}