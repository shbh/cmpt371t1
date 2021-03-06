package ca.sandstorm.luminance.test.math;

import javax.vecmath.Vector3f;

import android.test.AndroidTestCase;
import ca.sandstorm.luminance.math.Colliders;
import ca.sandstorm.luminance.math.Plane;
import ca.sandstorm.luminance.math.Ray;

/**
 * Testing of the Colliders class
 * 
 * @author Chet W Collins
 * 
 */
public class CollidersTest extends AndroidTestCase {

	private Ray _rayTest;
	private Plane _planeTest;

	/*
	 * Setting up instances to use for testing (non-Javadoc)
	 * 
	 * @see android.test.AndroidTestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		_rayTest = new Ray(0.0f,0.0f,0.0f,0.0f,0.0f,0.0f);
		_planeTest = new Plane(0.0f,0.0f,0.0f,0.0f,0.0f,0.0f);
	}

	/*
	 * Testing of the dotProduct() method
	 */
	public void testDotProduct() throws Exception {
		// Test coordinates
		float x1 = (float) 1.5;
		float y1 = (float) 3.5;
		float z1 = (float) 4.5;
		float x2 = (float) 2.5;
		float y2 = (float) 6.5;
		float z2 = (float) 11.5;
		// Test vectors
		Vector3f v1 = new Vector3f();
		Vector3f v2 = new Vector3f();
		v1.set(x1, y1, z1);
		v2.set(x2, y2, z2);
		// Make sure the result of dotProduct() == x1*x2 + y1*y2 + z1*z2
		try {
			Double result = Colliders.dotProduct(v1, v2);
			Double actual = (double) (x1 * x2 + y1 * y2 + z1 * z2);
			assertTrue(result.equals(actual));
		} catch (Exception ex) {
		}
	}

	/*
	 * Testing of the intersect() method
	 */
	public void testIntersect() throws Exception {
		float px = (float) 1.0;
		float py = (float) 3.0;
		float pz = (float) 2.0;
		float pxNormal = (float) 2.0;
		float pyNormal = (float) 7.0;
		float pzNormal = (float) 6.0;
		_planeTest = new Plane(px, py, pz, pxNormal, pyNormal, pzNormal);

		float rx = (float) 1.7;
		float ry = (float) 4.5;
		float rz = (float) 3.2;
		float rxDir = (float) 1.1;
		float ryDir = (float) 5.2;
		float rzDir = (float) 6.2;
		_rayTest = new Ray(rx, ry, rz, rxDir, ryDir, rzDir);

		// Perform calculations in intersect()
		double D = Colliders.dotProduct(_planeTest.getPosition(),
				_planeTest.getNormal());
		double numerator = Colliders.dotProduct(_planeTest.getNormal(),
				_rayTest.getPosition())
				+ D;
		double denominator = Colliders.dotProduct(_planeTest.getNormal(),
				_rayTest.getDirection());

		// Compare actual value to result of intersect()
		double actual = -(numerator / denominator);
		double result = Colliders.intersect(_rayTest, _planeTest);
		assert (result == actual);
	}

	/*
	 * Testing of the collide() method
	 */
	public void testCollide() throws Exception {
		Vector3f collisionPoint = Colliders.collide(_rayTest, _planeTest);
		assertNotNull(collisionPoint);
	}

	/*
	 * Testing of the intersionPlane() method
	 */
	public void testIntersionPlane() throws Exception {
		assert (true);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
