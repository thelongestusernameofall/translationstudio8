package net.heartsome.cat.converter.text.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.heartsome.cat.converter.Converter;
import net.heartsome.cat.converter.ConverterException;
import net.heartsome.cat.converter.text.Text2Xliff;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class Text2XliffTest {
	private static Text2Xliff converter = new Text2Xliff();
	private static String srcFile = "rc/Test.txt";
	private static String sklFile = "rc/Test.txt.skl";
	private static String xlfFile = "rc/Test.txt.xlf";

	@Before
	public void setUp() {
		File skl = new File(sklFile);
		if (skl.exists()) {
			skl.delete();
		}

		File xlf = new File(xlfFile);
		if (xlf.exists()) {
			xlf.delete();
		}
	}

	@Test(expected = ConverterException.class)
	public void testConvertMissingCatalog() throws ConverterException {
		String rootFolder = "/data/john/Workspaces/CAT/HSTS7/";
		Map<String, String> args = new HashMap<String, String>();
		args.put(Converter.ATTR_SOURCE_FILE, srcFile); //$NON-NLS-1$
		args.put(Converter.ATTR_XLIFF_FILE, xlfFile); //$NON-NLS-1$
		args.put(Converter.ATTR_SKELETON_FILE, sklFile); //$NON-NLS-1$
		args.put(Converter.ATTR_SOURCE_LANGUAGE, "en-US"); //$NON-NLS-1$
		args.put(Converter.ATTR_SOURCE_ENCODING, "UTF-8"); //$NON-NLS-1$
		// args.put(Converter.ATTR_CATALOGUE, rootFolder +
		// "catalogue/catalogue.xml");
		args.put(Converter.ATTR_SRX, rootFolder + "srx/default_rules.srx");

		Map<String, String> result = converter.convert(args, null);
		String xliff = result.get(Converter.ATTR_XLIFF_FILE);
		assertNotNull(xliff);

		File xlfFile = new File(xliff);
		assertNotNull(xlfFile);
		assertTrue(xlfFile.exists());
	}

	@Test(expected = ConverterException.class)
	public void testConvertMissingSRX() throws ConverterException {
		String rootFolder = "/data/john/Workspaces/CAT/HSTS7/";
		Map<String, String> args = new HashMap<String, String>();
		args.put(Converter.ATTR_SOURCE_FILE, srcFile); //$NON-NLS-1$
		args.put(Converter.ATTR_XLIFF_FILE, xlfFile); //$NON-NLS-1$
		args.put(Converter.ATTR_SKELETON_FILE, sklFile); //$NON-NLS-1$
		args.put(Converter.ATTR_SOURCE_LANGUAGE, "en-US"); //$NON-NLS-1$
		args.put(Converter.ATTR_SOURCE_ENCODING, "UTF-8"); //$NON-NLS-1$
		args.put(Converter.ATTR_CATALOGUE, rootFolder
				+ "catalogue/catalogue.xml");
		// args.put(Converter.ATTR_SRX, rootFolder + "srx/default_rules.srx");

		Map<String, String> result = converter.convert(args, null);
		String xliff = result.get(Converter.ATTR_XLIFF_FILE);
		assertNotNull(xliff);

		File xlfFile = new File(xliff);
		assertNotNull(xlfFile);
		assertTrue(xlfFile.exists());
	}

	@AfterClass
	public static void testConvert() throws ConverterException {
		String rootFolder = "/data/john/Workspaces/CAT/HSTS7/";
		Map<String, String> args = new HashMap<String, String>();
		args.put(Converter.ATTR_SOURCE_FILE, srcFile); //$NON-NLS-1$
		args.put(Converter.ATTR_XLIFF_FILE, xlfFile); //$NON-NLS-1$
		args.put(Converter.ATTR_SKELETON_FILE, sklFile); //$NON-NLS-1$
		args.put(Converter.ATTR_SOURCE_LANGUAGE, "en-US"); //$NON-NLS-1$
		args.put(Converter.ATTR_SOURCE_ENCODING, "UTF-8"); //$NON-NLS-1$
		args.put(Converter.ATTR_CATALOGUE, rootFolder
				+ "catalogue/catalogue.xml");
		args.put(Converter.ATTR_SRX, rootFolder + "srx/default_rules.srx");

		Map<String, String> result = converter.convert(args, null);
		String xliff = result.get(Converter.ATTR_XLIFF_FILE);
		assertNotNull(xliff);

		File xlfFile = new File(xliff);
		assertNotNull(xlfFile);
		assertTrue(xlfFile.exists());
	}

}
