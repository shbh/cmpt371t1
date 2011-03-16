package ca.sandstorm.luminance.state;

import javax.microedition.khronos.opengles.GL10;


public interface IState
{
    public boolean isInitialized();
    
    
    public boolean isVisible();


    public boolean isActive();


    public void messageRecieved();


    public void deviceChanged(GL10 gl, int w, int h);


    public void pause();


    public void resume();


    public void update(GL10 gl);


    public void draw(GL10 gl);
    
    
    public void init(GL10 gl);
}
