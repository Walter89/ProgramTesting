import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * TriangleTest for testing the Triangle class. This template is used in the
 * exercise phase 1. Students should add relevant unit test cases related to the
 * Triangle class to this class.
 */
public class TriangleTest extends TestCase {

	private Triangle EC1;
	private Triangle EC2;
	private Triangle EC3;
	private Triangle EC4;
	private Triangle EC8;
	private Triangle EC9;
	private Triangle EC16;
	private Triangle EC19;
	private Triangle EC40;
	private Triangle EC37;
	private Triangle EC39;
	private Triangle almostRightAngle;
	private Triangle almostIsossceles;
	private Triangle almostEquilateral;
	private Triangle almostEquilateral2;
	private Triangle EC10;
	private Triangle EC5;
	private Triangle EC6;
	private Triangle EC7;

	/**
	 * Constructs a test case with the given name.
	 */
	public TriangleTest(String name) {
		super(name);
	}

	/**
	 * Initializes common objects. The JUnit framework automatically invokes
	 * this method before each test is run.
	 */
	protected void setUp() {
		EC1 = new Triangle(1, 1, 1);//valid: BVA/(EP, equilateral,isossceles, not right-angled,!isImpossible) 
		EC2 = new Triangle(0, 0, 0);//BVA/EP, inte valid
		EC3=new Triangle(0,0,1);//EP invalid
		EC5=new Triangle(0,1,1);//EP invalid
		EC6=new Triangle(1,1,-1);//EP invalid
		EC7=new Triangle(1,-1,-1);//EP invalid
		EC4 = new Triangle(2, 4, 5);//valid, BVA 			
		EC8 = new Triangle(2, 2, 5);//invalid,BVA
		EC9 = new Triangle(2, 2, 2);//valid EP				
		//EC10 = new Triangle(2, "k", 2);//invalid EP
		EC16 = new Triangle(5, 4, 5);//valid: (EP, isossceles, not equilateral, isImpossible)
		EC19 = new Triangle(5, 4, 3);//valid: BVA/(EP, right-angled, not isossceles, not scalene)
		EC40 = new Triangle(Integer.MAX_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE);//valid: BVA large value.
		EC37 = new Triangle(1, 2, 3);//scalene BVA/(EP, scalene)
		EC39 = new Triangle(3, 4, 5);//valid: BVA right-angled
		almostRightAngle = new Triangle(270, 110, 250);//BVA, almost right-angled
		almostIsossceles = new Triangle(300, 301, 100);//BVA, almost isossceles
		almostEquilateral = new Triangle(300, 300, 301);//BVA, almost equilateral, above
		almostEquilateral2 = new Triangle(300, 300, 299);//BVA, almost equilateral, under
	}

	/**
	 * Cleanup method. The JUnit framework automatically invokes this method
	 * after each test is run.
	 */

	protected void tearDown() {
		EC1 = null;
		EC2 = null;
		EC3 = null;
		EC4 = null;
		EC8 = null;
		EC9 = null;
		EC16 = null;
		EC19 = null;
		EC40 = null;
		EC37 = null;
		EC39 = null;
		almostRightAngle = null;
		almostIsossceles = null;
		almostEquilateral = null;
		almostEquilateral2 = null;

	}


	/**
	 * Test whether the triangle specified in the fixture (setUp) is
	 * right-angled.
	 */
	public void testRightAngledBVAEP() {
		assertTrue("Should return true for a right-angled triangle",
				EC19.isRightAngled()); // borde returnera true, fast var false
	}

	public void testRightAngled2BVA() {
		assertTrue("Should return true for a right-angled triangle",
				EC39.isRightAngled());// funkar
	}

	public void testRightAngled3BVAEP() {
		assertEquals("Should return 'right-angled'", "right-angled",
				EC19.classify()); // borde ge right angle, inte scalene
	}

	public void testRightAngled4EP() {
		assertFalse("Should return false for a right-angled triangle",
				EC9.isRightAngled());// funkar
	}

	public void testRightAngled5BVA() {
		assertFalse("Should return false for a right-angled triangle",
				almostRightAngle.isRightAngled());// funkar inte
	}

	public void testIsImpossibleBVAEP() {
		assertFalse("Should return false", EC1.isImpossible());

	}

	public void testIsImpossible2BVA() {
		assertTrue("Should return true", EC2.isImpossible());
	}

	public void testIsImpossible3BVA() {
		assertFalse("Should return false", EC4.isImpossible());
	}

	public void testIsImpossible4BVA() {
		assertTrue("Should return true", EC8.isImpossible()); // ska avra
																// omöjlig
	}

	public void testIsImpossible5EP() {
		assertFalse("Should return false", EC9.isImpossible());

	}
	/**
	public void testIsImpossible6BVAEP() {
		assertTrue("Should return true", EC10.isImpossible());
	}
*/
	public void testIsImpossible7EP() {
		assertTrue("Should return true", EC3.isImpossible());
	}
	public void testIsImpossible8EP() {
		assertTrue("Should return true", EC5.isImpossible());
	}
	public void testIsImpossible9EP() {
		assertTrue("Should return true", EC6.isImpossible());
	}
	public void testIsImpossible10EP() {
		assertTrue("Should return true", EC7.isImpossible());
	}
	public void testGetSideLengthBVA() {
		assertEquals("Should return '2,4,5'", "2,4,5", EC4.getSideLengths());

	}

	public void testclassifyBVAEP() {

		assertEquals("Should return 'equilateral'", "equilateral",
				EC1.classify());
	}

	public void testclassify2EP() {
		assertFalse("Should not return 'equilateral'",
				EC16.classify().equals("equilateral"));
	}

	public void testclassify3EP() {
		assertEquals("Should return 'isossceles'", "isossceles",
				EC16.classify()); // borde ge likbent, fast var Scale
	}

	public void testclassify4BVAEP() {
		assertFalse("Should not return 'isossceles'",
				EC1.classify().equals("isossceles"));
	}

	

	public void testclassify6BVAEP() {
		assertFalse("Should not return 'right-angled'",
				EC1.classify().equals("right-angled"));
	}

	public void testclassify7BVAEP() {
		assertEquals("Should return 'scalene'", "scalene", EC37.classify());
	}

	public void testclassify8BVAEP() {
		assertFalse("Should not return 'scalene'",
				EC1.classify().equals("scalene"));

	}

	public void testGetAreaBVAEP() {
		assertEquals("Should return '0.4330127018922193'", 0.4330127018922193,
				EC1.getArea());
	}

	public void testGetArea2EP() {
		assertEquals("Should return '9.16515138991168'", 9.16515138991168,
				EC16.getArea());
	}

	public void testGetArea3EPBVA() {
		assertEquals("Should return '6.0'", 6.0, EC19.getArea());
	}

	public void testGetArea4BVA() {
		assertEquals("Should return '3.799671038392666'", 3.799671038392666,
				EC4.getArea());// ska inte avra 0
	}

	public void testGetPerimeterBVA() {
		assertEquals("Should return '3*Integer.MAX_VALUE",
				3 * Integer.MAX_VALUE, EC40.getPerimeter());
	}

	public void testGetPerimeter2BVAEP() {
		assertEquals("Should return '3'", 3, EC1.getPerimeter());
	}

	public void testGetPerimeter3BVAEP() {
		assertEquals("Should return '0'", 0, EC2.getPerimeter());// borde
																	// resultera
																	// i
																	// invalid(exception)

	}

	public void testisIsoscelesEP() {
		assertTrue("Should  return 'TRUE'", EC16.isIsosceles());
	}

	public void testisIsosceles2BVAEP() {
		assertTrue("Should  return 'TRUE'", EC1.isIsosceles());
	}

	public void testisIsosceles3BVAEP() {
		assertFalse("Should  return 'FALSE'", EC19.isIsosceles());
	}

	public void testisIsosceles4BVA() {
		assertFalse("Should  return 'FALSE'", almostIsossceles.isIsosceles());
	}

	public void testisEquilateralBVAEP() {
		assertTrue("Should  return 'TRUE'", EC1.isEquilateral());
	}

	public void testisEquilateral2EP() {
		assertFalse("Should  return 'FALSE'", EC16.isEquilateral());// Den är
																	// likbent,
																	// men inte
																	// liksidig.
	}

	public void testisEquilateral3BVA() {
		assertFalse("Should  return 'FALSE'", almostEquilateral.isEquilateral());
	}

	public void testisEquilatera4BVA() {
		assertFalse("Should  return 'FALSE'",
				almostEquilateral2.isEquilateral());
	}

	public void testIsScaleneEP() {
		assertTrue("Should  return 'True'", EC16.isIsosceles()); 
	}

	public void testIsScalene2BVAEP() {

		assertFalse("Should  return 'False'", EC1.isScalene());
	}

	public void testIsScalene3BVA() {
		assertFalse("Should  return 'FALSE'", EC2.isScalene());
	}

	public void testIsScalene4BVAEP() {
		assertTrue("Should  return 'TRUE'", EC37.isScalene());
	}

	public void testIsScalene5EP() {
		assertFalse("Should  return 'FALSE'", EC9.isScalene());
	}

	/**
	 * Creates a test suite. You can use this if you have a hierarchy of suites
	 * where a suite higher in the hierarchy can have
	 * suite.addTest(TriangleTest.suite())
	 * 
	 * @return a test suite
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite(TriangleTest.class);
		return suite;
	}

	/**
	 * Main function for starting the TestRunner.
	 * 
	 * @param args
	 *            no parameters required.
	 */
	public static void main(String args[]) {
		String[] testCaseName = { TriangleTest.class.getName() };

		// chooses the userinterface

		// junit.textui.TestRunner.main(testCaseName);
		// junit.awtui.TestRunner.main(testCaseName);
		junit.swingui.TestRunner.main(testCaseName);
	}
}

