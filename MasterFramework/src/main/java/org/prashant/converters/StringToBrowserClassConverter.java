package org.prashant.converters;

import org.aeonbits.owner.Converter;
import org.prashant.enums.BrowserType;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowserClassConverter implements Converter<BrowserType> {

    @Override
    public BrowserType convert(Method method, String browserName) {
        return BrowserType.valueOf(browserName.toUpperCase());
    }
}
