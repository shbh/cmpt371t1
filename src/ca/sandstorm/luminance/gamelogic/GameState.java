package ca.sandstorm.luminance.gamelogic;

import javax.microedition.khronos.opengles.GL10;
import javax.vecmath.Vector3f;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import android.opengl.GLU;
import android.view.KeyEvent;
import android.view.MotionEvent;

import ca.sandstorm.luminance.Engine;
import ca.sandstorm.luminance.camera.Camera;
import ca.sandstorm.luminance.gameobject.Box;
import ca.sandstorm.luminance.gameobject.Grid;
import ca.sandstorm.luminance.gameobject.Skybox;
import ca.sandstorm.luminance.input.InputButton;
import ca.sandstorm.luminance.state.IState;


public class GameState implements IState
{
    private static final Logger logger = LoggerFactory
	    .getLogger(GameState.class);

    private Camera _cam;

    private Box testBox;
    private Grid _grid;
    private Skybox _sky;

    private float initialX = 0.0f;
    private float initialY = 0.0f;
    private static final int DRAG = 0;
    private static final int ZOOM = 1;
    private static final float TOUCH_SENSIVITY = 0.2f;
    private int touchMode;


    public GameState()
    {
	logger.debug("GameState()");

	_cam = new Camera();
	_cam.setEye(0, 0, 5);

	// Temporary box for testing
	testBox = new Box(new Vector3f(0f, 0f, -14f));
	Engine.getInstance().getRenderer().addRenderable(testBox);
	
	_grid = new Grid(10, 10, 1.0f, 1.0f);
	_sky = new Skybox();
    }


    @Override
    public void pause()
    {
	logger.debug("pause()");

    }


    @Override
    public void resume()
    {
	logger.debug("resume()");

	Engine.getInstance().getTimer().reset();
    }


    @Override
    public void update(GL10 gl)
    {
	InputButton[] keys = Engine.getInstance().getInputSystem()
		.getKeyboard().getKeys();
	if (keys[KeyEvent.KEYCODE_1].getPressed()) {
	    System.exit(-1);
	}

	if (keys[KeyEvent.KEYCODE_W].getPressed()) {
	    _cam.moveForward(1.0f);
	}

	if (keys[KeyEvent.KEYCODE_S].getPressed()) {
	    _cam.moveForward(-1.0f);
	}

	if (keys[KeyEvent.KEYCODE_A].getPressed()) {
	    // _cam.rotateCamera(-0.01f, 0, 1, 0);
	    _cam.moveLeft(-1.0f);
	}

	if (keys[KeyEvent.KEYCODE_D].getPressed()) {
	    // _cam.rotateCamera(0.01f, 0, 1, 0);
	    _cam.moveLeft(1.0f);
	}

	if (keys[KeyEvent.KEYCODE_Q].getPressed()) {
	    // _cam.rotateCamera(0.01f, 0, 1, 0);
	    _cam.moveUp(1.0f);
	}

	if (keys[KeyEvent.KEYCODE_E].getPressed()) {
	    // _cam.rotateCamera(0.01f, 0, 1, 0);
	    _cam.moveUp(-1.0f);
	}

	if (Engine.getInstance().getInputSystem().getTouchScreen()
		.getPressed(0)) {
	    logger.debug("from rp: " +
			 Float.toString(Engine.getInstance().getInputSystem()
				 .getTouchScreen().getX(0)));

	    logger.debug("from motion event: " +
			 Float.toString(Engine.getInstance().getInputSystem()
				 .getTouchScreen().getTouchEvent().getX()));
	}

	// use touch screen to move the camera
	//
	// not using replica island coordinates
	if (Engine.getInstance().getInputSystem().getTouchScreen()
		.getTouchEvent() != null) {

	    MotionEvent touchEvent = Engine.getInstance().getInputSystem()
		    .getTouchScreen().getTouchEvent();

	    switch (touchEvent.getAction()) {
		case MotionEvent.ACTION_DOWN:
		    initialX = touchEvent.getX();
		    initialY = touchEvent.getY();
		    touchMode = DRAG;
		case MotionEvent.ACTION_UP:
		    // Check whether user released tap on top of button
		case MotionEvent.ACTION_POINTER_DOWN:
		    touchMode = ZOOM;
		case MotionEvent.ACTION_POINTER_UP:
		    touchMode = DRAG;
		case MotionEvent.ACTION_MOVE:
		    if (touchMode == DRAG) {
			float newX = touchEvent.getX();
			float newY = touchEvent.getY();

			float moveX = newX - initialX;
			float moveY = newY - initialY;

			if (moveX > 0) {
			    // Left to right
			    _cam.moveLeft(-TOUCH_SENSIVITY);
			    logger.debug("Left to right: " +
					 Float.toString(-moveX));

			} else if (moveX < 0) {
			    // Right to left
			    _cam.moveLeft(TOUCH_SENSIVITY);
			    logger.debug("Right to left: " +
					 Float.toString(-moveX));

			} else if (moveY > 0) {
			    // up to down
			    _cam.moveUp(TOUCH_SENSIVITY);
			    logger.debug("Up to down: " + Float.toString(moveY));

			} else if (moveY < 0) {
			    // Down to up
			    _cam.moveUp(-TOUCH_SENSIVITY);
			    logger.debug("Down to up: " + Float.toString(moveY));

			}
			initialX = touchEvent.getX();
			initialY = touchEvent.getY();
		    } else if (touchMode == ZOOM) {
			// need an android phone to test it.
		    }

	    }
	}
    }


    private float rquad = 0.0f;


    @Override
    public void draw(GL10 gl)
    {
	gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

	_cam.updateViewMatrix(gl);

	gl.glPushMatrix();
	gl.glLoadIdentity();
	GLU.gluLookAt(gl, 0, 0, 0, 0, 0, -14, 0, 1, 0);
	gl.glDisable(GL10.GL_DEPTH_TEST);
	gl.glColor4f(0.2f, 0.2f, 0.2f, 1.0f);
	_sky.draw(gl);
	gl.glEnable(GL10.GL_DEPTH_TEST);
	gl.glPopMatrix();

//	gl.glPushMatrix();
//	gl.glTranslatef(0.0f, 0, -14.0f);
	gl.glRotatef(rquad, 1.0f, 1.0f, 1.0f);
//	_box.draw(gl);
	rquad -= 0.45f;
//	gl.glPopMatrix();
	
	// Get renderer to draw everything on its renderable list
	Engine.getInstance().getRenderer().drawObjects(gl);
	
	gl.glPushMatrix();
	gl.glTranslatef(0.0f, 0, -7.0f);
	_grid.draw(gl);
	gl.glPopMatrix();
	
    }


    @Override
    public void deviceChanged(GL10 gl, int w, int h)
    {
	logger.debug("deviceChanged(" + gl + ", " + w + ", " + h + ")");

	gl.glShadeModel(GL10.GL_SMOOTH); // Enable Smooth Shading
	gl.glClearColor(0.182f, 0.182f, 1, 1); // Error blue
	gl.glClearDepthf(1.0f); // Depth Buffer Setup
	gl.glEnable(GL10.GL_DEPTH_TEST); // Enables Depth Testing
	gl.glDepthFunc(GL10.GL_LEQUAL); // The Type Of Depth Testing To Do

	// Really Nice Perspective Calculations
	gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);

	// prevent divide by zero.
	// @HACK - Forgiven since h == 0 means the game window is probably
	// hidden.
	if (h == 0) {
	    h = 1;
	}

	_cam.setViewPort(gl, 0, 0, w, h);
	_cam.setPerspective(gl, 45.0f, (float) w / (float) h, 0.1f, 100.0f);
    }


    @Override
    public void messageRecieved()
    {
	// TODO Auto-generated method stub

    }


    @Override
    public boolean isActive()
    {
	return true;
    }


    @Override
    public boolean isVisible()
    {
	// TODO Auto-generated method stub
	return true;
    }

}
