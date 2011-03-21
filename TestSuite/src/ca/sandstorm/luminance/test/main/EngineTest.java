/**
 * 
 */
package ca.sandstorm.luminance.test.main;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import javax.microedition.khronos.opengles.GL10;
import javax.vecmath.Vector3f;



import ca.sandstorm.luminance.Engine;
import ca.sandstorm.luminance.gamelogic.GameState;
import ca.sandstorm.luminance.gameobject.IGameObject;
import ca.sandstorm.luminance.state.IState;
import android.content.Context;
import android.content.res.AssetManager;
import android.test.AndroidTestCase;


/**
 * Testing Engine functionality
 * @author Amara Daal
 *
 */
public class EngineTest extends AndroidTestCase
{
    Engine mockEngine;
    Engine engine;
    Context mockContext;
    AssetManager mockAssetManager;
    IState mockState;

    GL10 mockGl;
    int w = 60; //arbitrary value
    int h = 60;
    int viewHeight = 100;
    int viewWidth = 100;
    
    int heightMenuBar;
    /**
     * @param name
     */
    public EngineTest(String name)
    {
	super();
    }
	
	public void testAddObject() {
		int level =1;
		//setup
		IGameObject mockLight = mock(IGameObject.class);
		GameState gameState = new GameState(1);
		stub(mockLight.getPosition()).toReturn(new Vector3f(3f, 3f, 3f));
		//added mock light into gameState
		gameState.addObject(mockLight);
		//execute
		assertEquals(mockLight.getPosition().x, gameState.getObjectAtGridCoords(3, 3).getPosition().x, .001);
		//verify
		verify(mockLight).getPosition();
		
	}

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception
    {
	super.setUp();
	//Setting up mock context
	mockContext = mock(Context.class);
	mockEngine = mock(Engine.class);
	mockAssetManager = mock(AssetManager.class);
	mockState = mock(IState.class);
    }


    /* (non-Javadoc)
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception
    {
	super.tearDown();
    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#getInstance()}.
     */
    public void testGetInstance()
    {
	engine = Engine.getInstance();
	assertNotNull(engine);
    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#setContext(android.content.Context)}.
     */
    public void testSetContext()
    {
	//Used to compare when we call get context
	stub(mockContext.hashCode()).toReturn(3);
	
	stub(mockContext.getAssets()).toReturn(mockAssetManager);
	engine.setContext(mockContext);
    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#getContext()}.
     */
    public void testGetContext()
    {
	Context rtContext = engine.getContext();
	assertNotNull(rtContext);

	//Should be both 3
	assertEquals(rtContext.hashCode(), mockContext.hashCode());
    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#getRenderer()}.
     */
    public void testGetRenderer()
    {
	assertNotNull(engine.getRenderer());
    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#getTimer()}.
     */
    public void testGetTimer()
    {
	assertNotNull(engine.getTimer());
    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#getInputSystem()}.
     */
    public void testGetInputSystem()
    {
	assertNotNull(engine.getInputSystem());
    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#getResourceManager()}.
     */
    public void testGetResourceManager()
    {
	assertNotNull(engine.getResourceManager());
    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#setMenuBarHeight(int)}.
     */
    public void testSetGetMenuBarHeight()
    {
	heightMenuBar = 50;
	engine.setMenuBarHeight(50);
	assertEquals(engine.getMenuBarHeight(), heightMenuBar);
    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#setTitleBarHeight(int)}.
     */
    public void testSetGetTitleBarHeight()
    {
	int titleBarHeight = 60;
	engine.setTitleBarHeight(titleBarHeight);
	assertEquals(engine.getTitleBarHeight(), titleBarHeight);
    }
    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#deviceChanged(javax.microedition.khronos.opengles.GL10, int, int, int, int)}.
     */
    public void testDeviceChanged()
    {

	//OpenGL
	mockGl = mock(GL10.class);
	stub(mockGl.toString()).toReturn("testMockGL");
	engine.deviceChanged(mockGl, w, h, viewWidth, viewHeight);
    }
    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#getViewWidth()}.
     */
    public void testGetViewWidth()
    {
	//Might not work since deviceChanged needs to be 
	//called first
	assertEquals(viewWidth, engine.getViewWidth());
    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#getViewHeight()}.
     */
    public void testGetViewHeight()
    {
	//Might not work since deviceChanged needs to be 
	//called first
	assertEquals(viewHeight, engine.getViewHeight());
    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#getViewScaleX()}.
     */
    public void testGetViewScaleX()
    {
	//Might not work since deviceChanged needs to be 
	//called first
	float viewScaleX = viewWidth / w;
	assertEquals(viewScaleX, engine.getViewScaleX(), .001);
    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#getViewScaleY()}.
     */
    public void testGetViewScaleY()
    {
	//Might not work since deviceChanged needs to be 
	//called first
	float viewScaleY = viewHeight / h;
	assertEquals(viewScaleY, engine.getViewScaleY(), .001);
    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#setMultiTouchFilter(boolean)}.
     */
    public void testSetGetMultiTouchFilter()
    {
	//MultiTouchFilter
	engine.setMultiTouchFilter(true);
	assertNotNull(engine.getTouchFilter());
	
	//SingleTouchFilter
	engine.setMultiTouchFilter(false);
	assertNotNull(engine.getTouchFilter());
	
    }



    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#pushState(ca.sandstorm.luminance.state.IState)}.
     */
    public void testPushPopState()
    {

	
	//Used later for comparing what we pushed is what is popped
	stub(mockState.isActive()).toReturn(true);

	engine.pushState(mockState);
	assertEquals(true, engine.popState().isActive());
    }



    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#resume()}.
     */
    public void testResume()
    {

	
	engine.pushState(mockState);
	engine.resume();

    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#pause()}.
     */
    public void testPause()
    {
	engine.pause();
    }





    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#init(javax.microedition.khronos.opengles.GL10)}.
     */
    public void testInit()
    {
    	engine.init(mockGl);
    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#update(javax.microedition.khronos.opengles.GL10)}.
     */
    public void testUpdate()
    {
	engine.update(mockGl);
    }


    /**
     * Test method for {@link ca.sandstorm.luminance.Engine#draw(javax.microedition.khronos.opengles.GL10)}.
     */
    public void testDraw()
    {
	engine.draw(mockGl);
    }

}
