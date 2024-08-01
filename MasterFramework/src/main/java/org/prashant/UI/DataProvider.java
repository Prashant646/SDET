package org.prashant.UI;

import org.prashant.utils.CSVUtils;

import java.util.List;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "csvDataProvider")
    public Object[][] getCsvData() {
        return new Object[][]{{"username1", "password1"}, {"username2", "password2"}};
    }
}

