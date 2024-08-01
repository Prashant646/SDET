package org.prashant.config;

import org.aeonbits.owner.Config;
import org.prashant.converters.StringToBrowserClassConverter;
import org.prashant.enums.BrowserType;

@Config.Sources({"system:properties", "system.env", "file:${user.dir}/src/test/resources/testExecution.properties"})
public interface FrameworkConfig extends Config {

    @ConverterClass(StringToBrowserClassConverter.class)
    BrowserType browser();
}
