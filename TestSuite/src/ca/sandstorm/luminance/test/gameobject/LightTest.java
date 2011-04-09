package ca.sandstorm.luminance.test.gameobject;

import javax.vecmath.Vector3f;

import android.test.AndroidTestCase;
import ca.sandstorm.luminance.gameobject.Box;
import ca.sandstorm.luminance.gameobject.Light;
import ca.sandstorm.luminance.math.Ray;

/**
 * Testing of the Light class of the gameobject package
 * 
 * @author Martina Nagy
 * 
 */
public class LightTest extends AndroidTestCase {
	Light _myLight;

	/**
	 * Create an instance of Box to test.
	 */
	protected void setUp() throws Exception {
		super.setUp();
		_myLight = new Light(0,0,0,0,0,0,5,0);
	}
	
	/**
	 * Test the getStartPoint method.
	 * 
	 * @throws Exception
	 */
	public void testGetStartPoint() throws Exception {
		Vector3f dum = _myLight.getStartPoint();
		assertTrue(dum.x == 0);
		assertTrue(dum.y == 0);
		assertTrue(dum.z == 0);
	}
	
	/**
	 * Test the setStartPoint method.
	 * 
	 * @throws Exception
	 */
	public void testSetStartPoint() throws Exception {
		_myLight.setStartPoint(1,1,1);
		Vector3f dum = _myLight.getStartPoint();
		assertTrue(dum.x == 1);
		assertTrue(dum.y == 1);
		assertTrue(dum.z == 1);
	}
	
	/**
	 * Test the getPosition method.
	 * 
	 * @throws Exception
	 */
	public void testPosition() throws Exception {
		Vector3f dum = _myLight.getPosition();
		//Vector3f dum = _myLight.getStartPoint();
		assertTrue(dum.x == 0);
		assertTrue(dum.y == 0);
		assertTrue(dum.z == 0);
	}
	
	/**
	 * Test the getDirection method.
	 * 
	 * @throws Exception
	 */
	public void testGetDirection() throws Exception {
		Vector3f dum = _myLight.getDirection();
		assertTrue(dum.x == 0);
		assertTrue(dum.y == 0);
		assertTrue(dum.z == 0);
	}
	
	/**
	 * Test the setDirection method.
	 * 
	 * @throws Exception
	 */
	public void testSetDirection() throws Exception {
		_myLight.setDirection(1,1,1);
		Vector3f dum = _myLight.getDirection();
		assertTrue(dum.x == 1);
		assertTrue(dum.y == 1);
		assertTrue(dum.z == 1);
	}
	
	/**
	 * Test the getDistance method.
	 * 
	 * @throws Exception
	 */
	public void testGetDistance() throws Exception {
		assertTrue(_myLight.getDistance() == 5);
	}
	
	/**
	 * Test the setDistance method.
	 * 
	 * @throws Exception
	 */
	public void testSetDistance() throws Exception {
		_myLight.setDistance(6);
		assertTrue(_myLight.getDistance() == 6);
	}
	
	/**
	 * Test the getColour method.
	 * 
	 * @throws Exception
	 */
	public void testGetColor() throws Exception {
		assertTrue(_myLight.getColor() == 0);
	}
	
	/**
	 * Test the getStartTouchingObject method.
	 * 
	 * @throws Exception
	 */
	public void testGetStartTouchedObject() throws Exception {
		assertNull(_myLight.getStartTouchedObject());
	}
	
	/**
	 * Test the setStartTouchingObject method.
	 * 
	 * @throws Exception
	 */
	public void testSetStartTouchedObject() throws Exception {
		Box dum = new Box(new Vector3f(0.5f, 0.5f, 0.5f), new Vector3f(0.5f,
				0.5f, 0.5f));
		_myLight.setStartTouchedObject(dum);
		assertTrue(_myLight.getStartTouchedObject() == dum);
	}
	
	/**
	 * Test the getEndTouchingObject method.
	 * 
	 * @throws Exception
	 */
	public void testGetEndTouchedObject() throws Exception {
		assertNull(_myLight.getEndTouchedObject());
	}
	
	/**
	 * Test the setEndTouchingObject method.
	 * 
	 * @throws Exception
	 */
	public void testSetEndTouchedObject() throws Exception {
		Box dum = new Box(new Vector3f(0.5f, 0.5f, 0.5f), new Vector3f(0.5f,
				0.5f, 0.5f));
		_myLight.setEndTouchedObject(dum);
		assertTrue(_myLight.getEndTouchedObject() == dum);
	}

	/**
	 * Test the initialize method.
	 * 
	 * @throws Exception
	 */
	public void testInitialize() throws Exception {
		// assertTrue(_myLight.initialize());
		// TODO: write proper tests
	}

	/**
	 * Test the update method.
	 * 
	 * @throws Exception
	 */
	public void testUpdate() throws Exception {
		// assertTrue(_myLight.Update());
		// TODO: write proper tests
	}

	/**
	 * Test the destroy method.
	 * 
	 * @throws Exception
	 */
	public void testDestroy() throws Exception {
		// assertTrue(_myLight.destroy());
		// TODO: write proper tests
	}

	/**
	 * Test the getRotation method.
	 * 
	 * @throws Exception
	 */
	public void testRotation() throws Exception {
		// Vector4f dummy = _myLight.getRotation();
		// assertTrue(dummy.w == 0);
		// assertTrue(dummy.x == 0);
		// assertTrue(dummy.y == 0);
		// assertTrue(dummy.z == 0);
		// TODO: write proper tests
	}

	/**
	 * Test the getScale method.
	 * 
	 * @throws Exception
	 */
	public void testScale() throws Exception {
		// Vector3f dummy = _myLight.getScale();
		// assertTrue(dummy.x == 0);
		// assertTrue(dummy.y == 0);
		// assertTrue(dummy.z == 0);
		// TODO: write proper tests
	}
	
	/**
	 * Test the getRay method.
	 * 
	 * @throws Exception
	 */
	public void testGetRay() throws Exception {
		Ray dum = _myLight.getRay();
		assertTrue(dum.getPosition().x == 0);
		assertTrue(dum.getPosition().y == 0);
		assertTrue(dum.getPosition().z == 0);
		assertTrue(dum.getDirection().x == 0);
		assertTrue(dum.getDirection().y == 0);
		assertTrue(dum.getDirection().z == 0);
	}

	/**
	 * Dispose of the created resource.
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
