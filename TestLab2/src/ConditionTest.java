import junit.framework.TestCase;

public class ConditionTest extends TestCase {

	private NextDate date;

	protected void setUp() {
		date = new NextDate(0, 0, 0);
	}

	protected void tearDown() {
		date = null;
	}

	public void testCase1() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(1, 0, 2013));

	}

	public void testCase2() {
		assertEquals("Should return '1/31/2013'", "1/31/2013",
				date.run(1, 30, 2013));
	}

	public void testCase3() {
		assertEquals("Should return '�2/1/2013�'", "2/1/2013",
				date.run(1, 31, 2013));
	}

	public void testCase4() {
		assertEquals("Should return '4/30/2013'", "4/30/2013",
				date.run(4, 29, 2013));
	}

	public void testCase5() {
		assertEquals("Should return '5/1/2013'", "5/1/2013",
				date.run(4, 30, 2013));
	}

	public void testCase6() {
		assertEquals("Should return 'Invalid Input Date'",
				"Invalid Input Date", date.run(4, 31, 2013));
	}

	public void testCase7() {
		assertEquals("Should return '12/31/2013'", "12/31/2013",
				date.run(12, 30, 2013));
	}

	public void testCase8() {
		assertEquals("Should return 'Invalid Next Year'", "Invalid Next Year",
				date.run(12, 32, 2021));
	}

	public void testCase9() {
		assertEquals("Should return 'Invalid Input Date'",
				"Invalid Input Date", date.run(12, 32, 2013));
	}

	public void testCase10() {
		assertEquals("Should return '2/28/2013'", "2/28/2013",
				date.run(2, 27, 2013));
	}

	public void testCase11() {
		assertEquals("Should return '2/29/2000'", "2/29/2000",
				date.run(2, 28, 2000));
	}

	public void testCase12() {
		assertEquals("Should return '3/1/1900'", "3/1/1900",
				date.run(2, 28, 1900));
	}

	public void testCase13() {
		assertEquals("Should return '3/1/2004'", "3/1/2004",
				date.run(2, 29, 2004));
	}

	public void testCase14() {
		assertEquals("Should return 'Invalid Input Date'",
				"Invalid Input Date", date.run(2, 29, 2013));
	}

	public void testCase15() {
		assertEquals("Should return 'Invalid Input Date'",
				"Invalid Input Date", date.run(2, 30, 2013));
	}

	public void testCase19() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(0, 0, 1800));
	}

	public void testCase20() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(0, 0, 2022));
	}

	public void testCase21() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(0, 0, 2013));
	}

	public void testCase22() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(0, 11, 1800));
	}

	public void testCase24() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(0, 11, 2013));
	}

	public void testCase25() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(0, 13, 1800));
	}

	public void testCase26() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(0, 13, 2022));
	}

	public void testCase27() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(0, 13, 2013));
	}

	public void testCase28() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(1, 0, 1800));
	}

	public void testCase29() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(1, 0, 2022));
	}

	public void testCase30() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(1, 0, 2013));
	}

	public void testCase31() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(11, 1, 1800));
	}

	public void testCase32() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(11, 1, 2022));
	}

	public void testCase34() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(13, 1, 1800));
	}

	public void testCase35() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(13, 1, 2022));
	}

	public void testCase36() {
		assertEquals("Should return 'invalid Input Date'",
				"invalid Input Date", date.run(13, 1, 2013));
	}

	public static void main(String args[]) {
		String[] testCaseName = { ConditionTest.class.getName() };

		// chooses the userinterface

		// junit.textui.TestRunner.main(testCaseName);
		// junit.awtui.TestRunner.main(testCaseName);
		junit.swingui.TestRunner.main(testCaseName);
	}

}
