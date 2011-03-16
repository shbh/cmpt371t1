package ca.sandstorm.luminance.gui;

import javax.microedition.khronos.opengles.GL10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sandstorm.luminance.Engine;

import android.view.MotionEvent;


/**
 * Class for handling buttons and whether they have been tapped.
 * 
 * @author Kumaran Vijayan
 *
 */
public class GUIManager
{
    private static final Logger _logger = LoggerFactory
    	.getLogger(GUIManager.class);
    
    public static int MAX_WIDGET_COUNT = 10;
    private float _compensatedY;

    private int _numberOfWidgets;
    private IWidget _widgets[];
    
    private Button _tappedButton;

    /**
     * Constructor. By default, the number of buttons to be managed is 0.
     * 
     * @precond n/a
     * @postcond this.getNumberOfButtons() == 0
     */
    public GUIManager()
    {
	_logger.debug("GUIManager()");
	
	_widgets = new IWidget[MAX_WIDGET_COUNT];
	_numberOfWidgets = 0;
    }
    
    public void initiate()
    {
	_compensatedY = Engine.getInstance().getMenuBarHeight() +
	Engine.getInstance().getTitleBarHeight();
    }
    
    /**
     * Get the number of widgets that are being managed by this GUIManager.
     * 
     * @return the number of widgets being managed by this GUIManager.
     */
    public int getNumberOfWidgets()
    {
	return _widgets.length;
    }
    
    /**
     * Get the array of widgets in this GUIManager
     * 
     * @return the widgets being managed by this GUIManager 
     */
    public IWidget[] getWidgets()
    {
	return _widgets;
    }

    /**
     * Return the Button that is currently being tapped.
     * @return the Button that is currently being tapped.
     */
    public Button getTappedButton()
    {
	return _tappedButton;
    }
    
    /**
     * Add the array of IWidgets to this GUIManager.
     * 
     * @param widgets The array of buttons to be managed by this GUIManager
     * @precond widgets != null
     * @postcond this.getNumberOfWidgets() <= MAX_BUTTON_COUNT
     */
    public void addWidgets(IWidget[] widgets)
    {
	for (IWidget widget : widgets) {
	    if (_numberOfWidgets < MAX_WIDGET_COUNT && widget != null) {
		_widgets[_numberOfWidgets++] = widget;
	    }
	}
    }
    
    /**
     * Add an IWidget to be managed by this GUIManager. If the GUIManager has
     * already hit its maximum number of buttons it can hold, then it won't add
     * the button and return false.
     * @param widget The widget to be added to, and managed by, this GUIManager
     * @return false if the widget wasn't added to the GUIManager, true
     * otherwise
     * @precond widget != null
     * @postcond this.getNumberOfWidgets() <= MAX_WIDGET_COUNT
     */
    public boolean addButton(IWidget widget)
    {
	if (_numberOfWidgets == MAX_WIDGET_COUNT) {
	    return false;
	} else {
	    _widgets[_numberOfWidgets++] = widget;
	    return true;
	}
    }

    public boolean buttonIsTapped()
    {
	if (_tappedButton == null) {
	    return false;
	} else {
	    return true;
	}
    }

    /**
     * Convenience method. Does the same thing as touchOccured(float, float)
     * except it uses the MotionEvent instance passed in. Checks the X and Y
     * coordinates of event to see if they fall in to any of the button's
     * space.
     * @param event The MotionEvent that represents the touch
     * @return the Button that was tapped.
     * @precond event != null
     * @postcond n/a
     */
    public Button touchOccured(MotionEvent event)
    {
	float xPosition = event.getX();
	float yPosition = event.getY();

	return this.touchOccured(xPosition, yPosition);
    }


    /**
     * @param x The X coordinate of the touch
     * @param y The Y coorindate of the touch
     * @return the Button that was tapped.
     * @precond x and y can't be negative
     * @postcond n/a
     */
    public Button touchOccured(float x, float y)
    {
	/*
	 * Searches through the array of widgets and compares each one
	 */
	for (int i = 0; i < _numberOfWidgets; i++) {
	    IWidget button = _widgets[i];
	    if (button.getClass() == Button.class &&
		x > button.getX() &&
		x < button.getX() + button.getWidth() &&
		y > button.getY() + _compensatedY &&
		y < button.getY() + button.getHeight() + _compensatedY) {
		_tappedButton = (Button)button;
		
		return (Button)button;
	    }
	}

	return null;
    }
    
    /**
     * Tell the GUIManager to notify that the currently tapped Button is no
     * longer being touched.
     * 
     * @precond n/a
     * @postcond _tappedButton == null
     */
    public void letGoOfButton()
    {
	if (_tappedButton != null &&
	_tappedButton.getMethod() != null &&
	_tappedButton.getCallee() != null) {
	    _tappedButton.tapped();
	    _tappedButton.setIsTapped(false);
	    _tappedButton = null;
	}
    }
    
    public void update(GL10 gl)
    {
	
    }
    
    
    public void draw(GL10 gl)
    {
	gl.glEnable(GL10.GL_BLEND);
	gl.glEnable(GL10.GL_CULL_FACE);
	gl.glCullFace(GL10.GL_BACK);
	gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE_MINUS_SRC_ALPHA);	
	
	for (int i = 0; i < _numberOfWidgets; i++) {
	    _widgets[i].draw(gl);
	}	
	gl.glDisable(GL10.GL_BLEND);
	gl.glDisable(GL10.GL_CULL_FACE);	
    }
    
}
