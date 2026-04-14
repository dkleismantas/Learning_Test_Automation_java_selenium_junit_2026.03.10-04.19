package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (className = "new-todo")
    WebElement inputToDo;

    @FindBy (className = "todo-list")
    WebElement listToDo;

    @FindBy (className = "completed")
    List<WebElement> listCompletedToDo;

    @FindBy (xpath = "//*[@class='main']//ul//li[not(contains(@class, 'completed'))]")
    List<WebElement> listNotCompleted;

    public void sendValuesToToDo(String... values) {
        for (String value : values) {
            inputToDo.sendKeys(value +  Keys.ENTER);
        }
    }

    public void clickToDoValueCheckboxOfProvidedToDoValue(String valueToCheck){
        listToDo.findElement(By.xpath("//label[text()='" +  valueToCheck + "']/preceding-sibling::input")).click();
    }

    public String getToDoListValues(){
        return listToDo.getText();
    }

    public String getCompletedListValues(){
        List<String> listCompletedValues = listCompletedToDo.stream()
                .map(WebElement::getText)
                .toList();
        StringBuilder listCompleted = new StringBuilder();
        for (String value : listCompletedValues) {
            listCompleted.append(value);
        }
        return listCompleted.toString();
    }

    public String getListNotCompleted(){
        List<String> notCompletedValues = listNotCompleted.stream()
                .map(WebElement::getText)
                .toList();
        StringBuilder listNotCompleted = new StringBuilder();
        for (String value : notCompletedValues) {
            listNotCompleted.append(value);
        }
        return listNotCompleted.toString();
    }


}
