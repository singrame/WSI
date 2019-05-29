package com.wsi.core;

import static org.junit.Assert.assertArrayEquals;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.junit.Test;

import com.wsi.data.ZipCodeRange;

public class ZipCodeRangeFinderTest {
	private static final Logger logger = LogManager.getLogger(ZipCodeRangeFinderTest.class);
	static {
		LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
		File file = new File("src/test/resources/log4j2.xml");
		context.setConfigLocation(file.toURI());
	}

	@Test
	public void testCase1() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("entering testCase1()");
		}
		String input = "[94133,94133] [94200,94299] [94600,94699]";
		ZipCodeRangeFinder codeRageFinder = new ZipCodeRangeFinder();
		ZipCodeRange [] actualOutput = codeRageFinder.findMiniumRanges(input);
		ZipCodeRange [] expectedOutput = new ZipCodeRange[3];
		expectedOutput[0] = new ZipCodeRange(94133, 94133);
		expectedOutput[1] = new ZipCodeRange(94200, 94299);
		expectedOutput[2] = new ZipCodeRange(94600, 94699);
		assertArrayEquals(expectedOutput, actualOutput);
		if (logger.isDebugEnabled()) {
			logger.debug("exiting testCase1()");
		}
	}

	@Test
	public void testCase2() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("entering testCase2()");
		}
		String input = "[94133,94133] [94200,94299] [94226,94399]";
		ZipCodeRangeFinder codeRageFinder = new ZipCodeRangeFinder();
		ZipCodeRange [] actualOutput = codeRageFinder.findMiniumRanges(input);
		ZipCodeRange [] expectedOutput = new ZipCodeRange[2];
		expectedOutput[0] = new ZipCodeRange(94133, 94133);
		expectedOutput[1] = new ZipCodeRange(94200, 94399);
		assertArrayEquals(expectedOutput, actualOutput);
		if (logger.isDebugEnabled()) {
			logger.debug("exiting testCase2()");
		}
	}

	@Test
	public void testCase3() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("entering testCase3()");
		}
		String input = "[49679, 52015] [49800, 50000] [51500, 53479] [45012, 46937] [54012, 59607] [45500, 45590] [45999, 47900] [44000, 45000] [43012, 45950]";
		ZipCodeRangeFinder codeRageFinder = new ZipCodeRangeFinder();
		ZipCodeRange [] actualOutput = codeRageFinder.findMiniumRanges(input);
		ZipCodeRange [] expectedOutput = new ZipCodeRange[3];
		expectedOutput[0] = new ZipCodeRange(43012, 47900);
		expectedOutput[1] = new ZipCodeRange(49679, 53479);
		expectedOutput[2] = new ZipCodeRange(54012, 59607);
		assertArrayEquals(expectedOutput, actualOutput);
		if (logger.isDebugEnabled()) {
			logger.debug("exiting testCase3()");
		}
	}

}
