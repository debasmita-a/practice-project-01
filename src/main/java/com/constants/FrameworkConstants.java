package com.constants;

public final class FrameworkConstants {
	
	private FrameworkConstants() {}
	
	private static final String CONFIG_FILE_PATH = "./src/test/resources/config/config.properties";
	private static final String EXCEL_TESTDATA_PATH = "./src/test/resources/testdata/testdata.xlsx";
	
	private static final int EXPLICITWAIT_SHORT = 5;
	private static final int EXPLICITWAIT_LONG = 10;
	

	public static int getExplicitwaitShort() {
		return EXPLICITWAIT_SHORT;
	}

	public static int getExplicitwaitLong() {
		return EXPLICITWAIT_LONG;
	}

	public static String getExcelTestdataPath() {
		return EXCEL_TESTDATA_PATH;
	}

	public static String getConfigFilePath() {
		return CONFIG_FILE_PATH;
	}
	

}
