package org.prashant.api;

public class Payloads {

    public static String getAddPlacePayload() {

        return "{\n" + "  \"location\": {\n" + "    \"lat\": -38.383494,\n" + "    \"lng\": 33.427362\n" + "  },\n" + "  \"accuracy\": 50,\n" + "  \"name\": \"Frontline house\",\n" + "  \"phone_number\": \"(+91) 983 893 3937\",\n" + "  \"address\": \"29, side layout, cohen 09\",\n" + "  \"types\": [\n" + "    \"shoe park\",\n" + "    \"shop\"\n" + "  ],\n" + "  \"website\": \"http://google.com\",\n" + "  \"language\": \"French-IN\"\n" + "}";
    }

    public static String CoursePrice()
    {

        return "{\r\n" +
                "  \"dashboard\": {\r\n" +
                "    \"purchaseAmount\": 1162,\r\n" +
                "    \"website\": \"rahulshettyacademy.com\"\r\n" +
                "  },\r\n" +
                "  \"courses\": [\r\n" +
                "    {\r\n" +
                "      \"title\": \"Selenium Python\",\r\n" +
                "      \"price\": 50,\r\n" +
                "      \"copies\": 6\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"Cypress\",\r\n" +
                "      \"price\": 40,\r\n" +
                "      \"copies\": 4\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"RPA\",\r\n" +
                "      \"price\": 45,\r\n" +
                "      \"copies\": 10\r\n" +
                "    },\r\n" +
                "     {\r\n" +
                "      \"title\": \"Appium\",\r\n" +
                "      \"price\": 36,\r\n" +
                "      \"copies\": 7\r\n" +
                "    }\r\n" +
                "    \r\n" +
                "    \r\n" +
                "    \r\n" +
                "  ]\r\n" +
                "}\r\n" +
                "";
    }


    public static String addBook(){
        return "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\"15897\",\n" +
                "\"aisle\":\"8781\",\n" +
                "\"author\":\"Aunty\"\n" +
                "}\n";
    }

}
