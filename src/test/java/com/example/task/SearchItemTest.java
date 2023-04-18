package com.example.task;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {

    @Test
    public void searchItem() {

        app.getChoose().chooseDepartment("Elektronik");

        app.getChoose().chooseCategoryType("1");

        app.getItem().selectItem("1");

        String secondItem = app.getItem().getSecondItemName("2");

        app.getItem().enterSearchField(secondItem);

        String firstItem = app.getItem().getFirstItemName("2");

        Assert.assertTrue(firstItem.toLowerCase().contains(secondItem.toLowerCase()));

    }

}
