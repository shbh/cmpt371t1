package ca.sandstorm.luminance.test.gameobject;

import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

import android.test.AndroidTestCase;
import ca.sandstorm.luminance.gameobject.Light;
import ca.sandstorm.luminance.gameobject.LightBeam;
import ca.sandstorm.luminance.gameobject.LightBeamCollection;
import ca.sandstorm.luminance.gameobject.Mirror;
import ca.sandstorm.luminance.gameobject.RenderType;

/**
 * Testing of the Mirror class of the gameobject package
 * 
 * @author Martina Nagy
 * 
 */
public class MirrorTest extends AndroidTestCase {
	Mirror _myMirror;

	/**
	 * Create an instance of Box to test.
	 */
	protected void setUp() throws Exception {
		super.setUp();
		_myMirror = new Mirror(new Vector3f(0, 0, 0));
	}
	
	/**
	 * Test the getRenderable method.
	 * 
	 * @throws Exception
	 */
	public void testGetRenderable() throws Exception {
		assertTrue(_myMirror.getRenderable() != null);
	}
	
	/**
	 * Test the getTexture() method.
	 * 
	 * @throws Exception
	 */
	public void testGetTexture() throws Exception {
		assertNotNull(_myMirror.getTexture());
	}
	
	/**
	 * Test the getRenderType() method.
	 * 
	 * @throws Exception
	 */
	public void testGetRenderType() throws Exception {
		RenderType dummy = _myMirror.getRenderType();
		assertTrue(dummy == RenderType.Normal);
	}
	
	/**
	 * Test the getCollisionSphere() method
	 * 
	 * @throws Exception
	 */
	public void testGetCollisionSphere()
	{
		assertNotNull(_myMirror.getCollisionSphere());
	}
	
	/**
	 * Test the beamInteract() method
	 * 
	 * @throws Exception
	 */
	public void testBeamInteract()
	{
		LightBeamCollection lbc = new LightBeamCollection();
		LightBeam lb = new LightBeam();
		Light l = new Light(0, 0, 0, 0, 0, 0, 5, 0);
		lb.add(0, l);
		lbc.add(0, lb);
		
		_myMirror.beamInteract(lbc, 0, 0);
		
		assertTrue(l.getEndTouchedObject().equals(_myMirror));
		assertTrue(lb.size() > 1);
	}

	/**
	 * Test the update method.
	 * 
	 * @throws Exception
	 */
	public void testUpdate() throws Exception {
		// assertTrue(_myMirror.Update());
		// TODO: write proper tests
	}

	/**
	 * Test the destroy method.
	 * 
	 * @throws Exception
	 */
	public void testDestroy() throws Exception {
		// assertTrue(_myMirror.destroy());
		// TODO: write proper tests
	}

	/**
	 * Test the getPosition method.
	 * 
	 * @throws Exception
	 */
	public void testGetPosition() throws Exception {
		Vector3f dummy = _myMirror.getPosition();
		assertTrue(dummy.x == 0);
		assertTrue(dummy.y == 0);
		assertTrue(dummy.z == 0);
	}

	/**
	 * Test the getRotation method.
	 * 
	 * @throws Exception
	 */
	public void testGetRotation() throws Exception {
		Vector4f dummy = _myMirror.getRotation();
		assertTrue(dummy.w == 0.0f);
		assertTrue(dummy.x == 0.0f);
		assertTrue(dummy.y == 45.0f);
		assertTrue(dummy.z == 0.0f);
	}

	/**
	 * Test the getScale method.
	 * 
	 * @throws Exception
	 */
	public void testGetScale() throws Exception {
		Vector3f dummy = _myMirror.getScale();
		assertTrue(dummy.x == 0.1f);
		assertTrue(dummy.y == 0.5f);
		assertTrue(dummy.z == 0.5f);
	}

	/**
	 * Dispose of the created resource.
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
