package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

import com.constants.FrameworkConstants;
import com.enums.ConfigProperties;

public final class PropertiesReader {

	private PropertiesReader() {
	}

	private static Properties prop = new Properties();
	private static final Map<String, String> CONFIG_MAP = new HashMap<>();

	static {
		FileInputStream input;
		try {
			input = new FileInputStream(FrameworkConstants.getConfigFilePath());
			prop.load(input);
			Set<Entry<Object, Object>> entries = prop.entrySet();
			for (Map.Entry<Object, Object> entry : entries) {
				CONFIG_MAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(ConfigProperties key) {
		if(Objects.isNull(key) || Objects.isNull(prop.get(key.name().toLowerCase()))){
			System.out.println("Property :: " + key + " is not available. Please check config.properties file.");
		}
		return CONFIG_MAP.get(key);
	}
}
