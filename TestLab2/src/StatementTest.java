import junit.framework.TestCase;

public class StatementTest extends TestCase {

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

	public void testCase4() {
		assertEquals("Should return '4/30/2013'", "4/30/2013",
				date.run(4, 29, 2013));
	}

	public void testCase5() {
		assertEquals("Should return '5/1/2013'", "5/1/2013",
				date.run(4, 30, 2013));
	}

	public void testCase7() {
		assertEquals("Should return '12/31/2013'", "12/31/2013",
				date.run(12, 30, 2013));
	}

	public void testCase8() {
		assertEquals("Should return 'Invalid Next Year'", "Invalid Next Year",
				date.run(12, 32, 2021));
	}

	public void testCase10() {
		assertEquals("Should return '2/28/2013'", "2/28/2013",
				date.run(2, 27, 2013));
	}

	public void testCase11() {
		assertEquals("Should return '2/29/2000'", "2/29/2000",
				date.run(2, 28, 2000));
	}

	public void testCase13() {
		assertEquals("Should return '3/1/2004'", "3/1/2004",
				date.run(2, 29, 2004));
	}

	public void testCase15() {
		assertEquals("Should return 'Invalid Input Date'",
				"Invalid Input Date", date.run(2, 30, 2013));
	}

	public static void main(String args[]) {
		String[] testCaseName = { StatementTest.class.getName() };

		// chooses the userinterface

		// junit.textui.TestRunner.main(testCaseName);
		// junit.awtui.TestRunner.main(testCaseName);
		junit.swingui.TestRunner.main(testCaseName);
	}
}
