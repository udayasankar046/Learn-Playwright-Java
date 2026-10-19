package utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;

public class ScreenshotsUtils {

	public static String takeScreenshot(Page page, String testName) {

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(new Date());

		String folder = "test-output/screenshots/";
		String path = folder + testName + "_" + timestamp + ".png";

		try {
			Files.createDirectories(Paths.get(folder));
			page.screenshot(new ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));

			return path;

		} catch (Exception e) {
			throw new RuntimeException("Screenshot capture failed", e);
		}
	} 
}
