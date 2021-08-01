package com.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class ContainerHeader {

    public final SelenideElement COMPONENT_CONTAINER = $("div.container");

    public ElementsCollection getMenuItems(){
        return COMPONENT_CONTAINER.$$("li > a");
    }

    public SelenideElement getMenuItem(String name){
        return getMenuItems().stream().filter(menuItem -> menuItem.getText().equalsIgnoreCase(name))
                .findFirst().orElseThrow();
    }

    public void selectHeaderMenu(String name) {
        getMenuItem(name).shouldBe(Condition.enabled).shouldBe(Condition.visible).click();
    }

    public boolean isMenuItemSelected(String name){
        return Objects.requireNonNull(getMenuItem(name).getAttribute("class")).contains("active");
    }
}