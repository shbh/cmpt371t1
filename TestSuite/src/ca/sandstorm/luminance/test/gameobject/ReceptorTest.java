package ca.sandstorm.luminance.test.gameobject;
import android.test.AndroidTestCase;

import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

import ca.sandstorm.luminance.gameobject.Receptor;
import ca.sandstorm.luminance.gameobject.RenderType;
import ca.sandstorm.luminance.graphics.IRenderable;

/**
 * Testing of the Receptor class of the gameobject package
 * @author Martina Nagy
 *
 */
public class ReceptorTest extends AndroidTestCase {
	Receptor myReceptor;

	/**
	 * Create an instance of Box to test. 
	 */
	protected void setUp() throws Exception {
	super.setUp();
	myReceptor = new Receptor(new Vector3f(0.0f,0.0f,0.0f), new Vector3f(0.0f,0.0f,0.0f));
	 }

	/**
	 * Test the update method.
	 * @throws Exception
	 */
	public void testUpdate() throws Exception {
	//assertTrue(myReceptor.Update());
	//TODO: write proper tests
	 }
	
	/**
	 * Test the destroy method.
	 * @throws Exception
	 */
	public void testDestroy() throws Exception {
	//assertTrue(myReceptor.destroy());
	//TODO: write proper tests
	 }
	
	/**
	 * Test the getPosition method.
	 * @throws Exception
	 */
	public void testGetPosition() throws Exception {
	Vector3f dummy = myReceptor.getPosition();
	assertTrue(dummy.x == 0);
	assertTrue(dummy.y == 0);
	assertTrue(dummy.z == 0);
	 }
	
	/**
	 * Test the getRotation method.
	 * @throws Exception
	 */
	public void testGetRotation() throws Exception {
	Vector4f dummy = myReceptor.getRotation();
	assertTrue(dummy.w == 0.0f);
	assertTrue(dummy.x == 1.0f);
	assertTrue(dummy.y == 0.0f);
	assertTrue(dummy.z == 0.5f);
	 }
	
	/**
	 * Test the getScale method.
	 * @throws Exception
	 */
	public void testGetScale() throws Exception {
	Vector3f dummy = myReceptor.getScale();
	assertTrue(dummy.x == 0.0f);
	assertTrue(dummy.y == 0.0f);
	assertTrue(dummy.z == 0.0f);
	 }
	
	/**
	 * Test the getRenderable method.
	 * @throws Exception
	 */
	public void testGetRenderable() throws Exception {
	assertNotNull(myReceptor.getRenderable());
	 }
	
	/**
	 * Test the getTexture() method.
	 * @throws Exception
	 */
	public void testGetTexture() throws Exception {
	assertNotNull(myReceptor.getTexture());
 	 }
	
	/**
	 * Test the getRenderType() method.
	 * @throws Exception
	 */
	public void testGetRenderType() throws Exception {
	RenderType dummy = myReceptor.getRenderType();
	assertTrue(dummy == RenderType.Normal);
	 }
	
	/**
	 * Dispose of the created resource.
	 */
	protected void tearDown() throws Exception {
	super.tearDown();
	 }
}
