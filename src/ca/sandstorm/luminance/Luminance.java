package ca.sandstorm.luminance;

import java.lang.reflect.Method;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sandstorm.luminance.gamelogic.GameState;
import ca.sandstorm.luminance.gamelogic.MenuState;
import ca.sandstorm.luminance.gui.Button;
import ca.sandstorm.luminance.gui.GUIManager;
import ca.sandstorm.luminance.gui.IWidget;
import ca.sandstorm.luminance.gui.Label;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;


/**
 * ANDROID MAIN CLASS
 * - The activity for our App (essentially the entry point)
 * - Everything is passed into the Engine.  This is essentially
 * a bridge between Android and our Engine.
 * @author halsafar
 *
 */
public class Luminance extends Activity
{
    private static final Logger logger = LoggerFactory.getLogger("Luminance");

    // openGL view
    private GLSurfaceView mGLView;

    // a handler for updating the ui thread from the android thread
    private final Handler handler = new Handler()
    {
	public void handleMessage(Message msg)
	{
	    float fps = msg.getData().getFloat("fps");

	    Luminance.this.setTitle("Luminance - " + fps);
	}
    };


    /**
     * Android Activity OnCreate()
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
	logger.debug("onCreate()");
	
	// Assign the engine's application context
	Engine.getInstance().setContext(getApplicationContext());
	
	// init the engine and add our states
	Engine.getInstance().pushState(new GameState());
	
	// UNCOMMENT TO START IN MENU STATE
	/*
	Method method = null;
	try {
	    method = MenuState.class.getMethod("test", (Class[])null);
	} catch (SecurityException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	if (method == null) {
	    logger.debug("method is null");
	} else {
	    logger.debug("methos is not null");
	}
	MenuState menuState = new MenuState();
	
	IWidget[] widgets = new IWidget[GUIManager.MAX_WIDGET_COUNT];
	Button startButton = new Button(20, 50, 280, 30, "Start");
	startButton.setTextureResourceLocation("textures/startImage.png");
	startButton.setCalleeAndMethod(menuState, method);
	
	Button optionsButton = new Button(20, 110, 280, 30, "Options");
	optionsButton.setTextureResourceLocation("textures/optionsImage.png");
	optionsButton.setCalleeAndMethod(menuState, method);
	
	Button helpButton = new Button(20, 170, 280, 30, "Help");
	helpButton.setTextureResourceLocation("textures/helpImage.png");
	helpButton.setCalleeAndMethod(menuState, method);
	
	Button aboutButton = new Button(20, 350, 280, 30, "About");
	aboutButton.setTextureResourceLocation("textures/aboutImage.png");
	aboutButton.setCalleeAndMethod(menuState, method);
	
	// An example label
	Label testLabel = new Label(20, 210, 280, 30, "Test");
	testLabel.setTextureResourceLocation("textures/aboutImage.png");
	
	widgets[0] = startButton;
	widgets[1] = optionsButton;
	widgets[2] = aboutButton;
	widgets[3] = helpButton;
	widgets[4] = testLabel;
	menuState.addWidgets(widgets);
	Engine.getInstance().pushState(menuState);
	*/
		
	// init gl surface view for android
	super.onCreate(savedInstanceState);
	mGLView = new GLSurfaceView(this);
	mGLView.setRenderer(new ClearRenderer());
	mGLView.setGLWrapper(new GLSurfaceView.GLWrapper()
        {
            @Override
            public GL wrap(GL gl) { return new MatrixTrackingGL(gl); }
        });
	
	setContentView(mGLView);
    }


    /**
     * Android Activity has been paused.
     */
    @Override
    protected void onPause()
    {
	logger.debug("onPause()");

	super.onPause();
	mGLView.onPause();

	Engine.getInstance().pause();
    }


    /**
     * Android activity has been resumed.
     */
    @Override
    protected void onResume()
    {
	logger.debug("onResume()");

	super.onResume();
	mGLView.onResume();

	Engine.getInstance().resume();
    }


    /**
     * Android received a touch even.
     */
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
	logger.debug("onTouchEvent(" + event + ")");

	Engine.getInstance().getTouchFilter().updateTouch(event);
	
	try {Thread.sleep(16);} catch (Exception e) { logger.error("Could not sleep event thread"); }

	return true;
    }


    /**
     * Android received a keydown event.
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
	logger.debug("onKeyDown(" + keyCode + ", " + event + ")");

	boolean result = false;

	Engine.getInstance().getInputSystem().keyDown(keyCode);

	return result;
    }


    /**
     * Android received a keyup event.
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
	logger.debug("onKeyUp(" + keyCode + ", " + event + ")");

	boolean result = false;

	Engine.getInstance().getInputSystem().keyUp(keyCode);

	return result;
    }


    /**
     * Inline class to handle opengl rendering.
     * Passes off all work to the Engine singleton.
     * @author halsafar
     *
     */
    class ClearRenderer implements GLSurfaceView.Renderer
    {
	
	/**
	 * OpenGL surface first created.
	 */
	public void onSurfaceCreated(GL10 gl, EGLConfig config)
	{
	    logger.debug("onSurfaceCreated(" + gl.toString() + ", " +
			 config.toString() + ")");

	    
	    Engine.getInstance().init(gl);
	}


	/**
	 * OpenGL surface has changed.
	 */
	public void onSurfaceChanged(GL10 gl, int w, int h)
	{
	    logger.debug("onSurfaceChanged(" + gl.toString() + ", " + w + ", " +
			 h + ")");

	    DisplayMetrics dm = new DisplayMetrics();
	    getWindowManager().getDefaultDisplay().getMetrics(dm);

	    int defaultWidth = 480;
	    int defaultHeight = 320;
	    if (dm.widthPixels != defaultWidth) {
		float ratio = ((float) dm.widthPixels) / dm.heightPixels;
		defaultWidth = (int) (defaultHeight * ratio);
	    }
	    
	    Engine.getInstance().deviceChanged(gl, w, h, dm.widthPixels,
	                                       dm.heightPixels);
	    logger.debug("width:" + defaultWidth + "\theight: " + defaultHeight);
	}


	/**
	 * OpenGL Surface has finished swapping.
	 * Ready for a new frame.
	 */
	public void onDrawFrame(GL10 gl)
	{
	    // do not log...
	    Message msg = new Message();
	    Bundle b = new Bundle();
	    b.putFloat("fps", Engine.getInstance().getTimer().getFrameDelta());
	    msg.setData(b);
	    handler.sendMessage(msg);

	    // update/draw engine
	    Engine.getInstance().update(gl);
	    Engine.getInstance().draw(gl);
	}
    }
}
