package com.atmecsautomation.constants;

import java.util.Properties;

import com.atmecsautomation.utils.ReadPropertiesFile;

public class LoadPropertyFile {
	public static Properties locators;
	public static Properties validate;

	public LoadPropertyFile() {
		locators = ReadPropertiesFile.loadProperty(FilePath.LOCATOR_FILE);
		validate = ReadPropertiesFile.loadProperty(FilePath.VALIDATION_PROPERTY_FILE);
	}

}
