package ca.sandstorm.luminance.gameobject;

import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sandstorm.luminance.Engine;
import ca.sandstorm.luminance.graphics.IRenderable;

/**
 * Light receptor game object.
 * @author zenja
 */
public class Receptor extends GameObject implements IRenderableObject
{
    private static final Logger _logger = LoggerFactory.getLogger("Luminance.Sphere");

    private IRenderable _model;
    private int _texture;
    private double _scaleCounter = 0;
    
    private RenderType _renderType = RenderType.Normal;
    
    
    /**
     * Constructor.
     * Sets up the receptor position and scale.
     * @param position Position to put receptor at initially
     * @param scale receptor initial scale
     */
    public Receptor(Vector3f position, Vector3f scale)
    {
	_logger.debug("Receptor(" + position + ", " + scale + ")");
	
	_position = new Vector3f(position);
	_rotation = new Vector4f(1.0f, 1.0f, 1.0f, 0f);
	_scale = new Vector3f(scale);
	_model = Engine.getInstance().getRenderer().getSphere();
    }
    
    /**
     * Get the model associated with this object.
     * @return Associated model
     */
    @Override
    public IRenderable getRenderable()
    {
	return _model;
    }

    /**
     * Get the texture associated with this object.
     * @return Associated texture
     */
    @Override
    public int getTexture()
    {
	return _texture;
    }

    /**
     * Initialize the object.
     * Associate with the object's texture. The texture needs to be loaded
     * before calling this function.
     */
    @Override
    public void initialize(Grid grid)
    {
	// Use a solid color for now
	_texture = 0;
	
	super.initialize(grid);
    }

    /**
     * Update the object state.
     */
    @Override
    public void update()
    {
	// For fun
	_scaleCounter += 0.1f;
	_scale.x = _scale.y = _scale.z = (float)(1.0 + (Math.sin(_scaleCounter) * 0.3));
    }

    @Override
    public RenderType getRenderType()
    {
	return _renderType;
    }
}
