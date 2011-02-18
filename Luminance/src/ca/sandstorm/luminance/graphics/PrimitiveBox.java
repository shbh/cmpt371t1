package ca.sandstorm.luminance.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * A primitive box using an index buffer.
 * @author zenja
 */
public class PrimitiveBox implements IRenderable
{
    // Vertex coordinates
    private float[] _vertices = {
		-1.0f, -1.0f, 1.0f,
    		1.0f, -1.0f, 1.0f,
    		-1.0f, 1.0f, 1.0f,
    		1.0f, 1.0f, 1.0f,
    		
    		1.0f, -1.0f, 1.0f,
    		1.0f, -1.0f, -1.0f,    		
    		1.0f, 1.0f, 1.0f,
    		1.0f, 1.0f, -1.0f,
    		
    		1.0f, -1.0f, -1.0f,
    		-1.0f, -1.0f, -1.0f,    		
    		1.0f, 1.0f, -1.0f,
    		-1.0f, 1.0f, -1.0f,
    		
    		-1.0f, -1.0f, -1.0f,
    		-1.0f, -1.0f, 1.0f,    		
    		-1.0f, 1.0f, -1.0f,
    		-1.0f, 1.0f, 1.0f,
    		
    		-1.0f, -1.0f, -1.0f,
    		1.0f, -1.0f, -1.0f,    		
    		-1.0f, -1.0f, 1.0f,
    		1.0f, -1.0f, 1.0f,
    		
    		-1.0f, 1.0f, 1.0f,
    		1.0f, 1.0f, 1.0f,    		
    		-1.0f, 1.0f, -1.0f,
    		1.0f, 1.0f, -1.0f,

    };
    
    // Indices
    private byte[] _indices = {
		0,1,3, 0,3,2,
    		4,5,7, 4,7,6,
    		8,9,11, 8,11,10,
    		12,13,15, 12,15,14, 	
    		16,17,19, 16,19,18, 	
    		20,21,23, 20,23,22 	

    };
    
    // Texture coordinates
    private float[] _textureCoords = {
		0.0f, 0.0f,
    		0.0f, 1.0f,
    		1.0f, 0.0f,
    		1.0f, 1.0f, 
    		
    		0.0f, 0.0f,
    		0.0f, 1.0f,
    		1.0f, 0.0f,
    		1.0f, 1.0f,
    		
    		0.0f, 0.0f,
    		0.0f, 1.0f,
    		1.0f, 0.0f,
    		1.0f, 1.0f,
    		
    		0.0f, 0.0f,
    		0.0f, 1.0f,
    		1.0f, 0.0f,
    		1.0f, 1.0f,
    		
    		0.0f, 0.0f,
    		0.0f, 1.0f,
    		1.0f, 0.0f,
    		1.0f, 1.0f,
    		
    		0.0f, 0.0f,
    		0.0f, 1.0f,
    		1.0f, 0.0f,
    		1.0f, 1.0f

    };
    
    private FloatBuffer _vertexBuffer;
    private ByteBuffer _indexBuffer;
    private FloatBuffer _textureBuffer;
    
    /**
     * Constructor.
     * Create the buffers from the data.
     */
    public PrimitiveBox()
    {
	// Create vertex buffer
	ByteBuffer byteBuf = ByteBuffer.allocateDirect(_vertices.length * 4);
	byteBuf.order(ByteOrder.nativeOrder());
	_vertexBuffer = byteBuf.asFloatBuffer();
	_vertexBuffer.put(_vertices);
	_vertexBuffer.position(0);
	
	// Create texture buffer
	ByteBuffer byteTexBuf = ByteBuffer.allocateDirect(_textureCoords.length * 4);
	byteTexBuf.order(ByteOrder.nativeOrder());
	_textureBuffer = byteTexBuf.asFloatBuffer();
	_textureBuffer.put(_textureCoords);
	_textureBuffer.position(0);

	// Create index buffer
	_indexBuffer = ByteBuffer.allocateDirect(_indices.length);
	_indexBuffer.put(_indices);
	_indexBuffer.position(0);
    }
    
    /**
     * Render the box.
     * Texture or color should be set before this call.
     * @param gl The OpenGL context to render with
     */
    @Override
    public void draw(GL10 gl)
    {
	// Set the face rotation
	gl.glFrontFace(GL10.GL_CCW);
	
	gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
	gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
	
	// Point to the buffers
	gl.glVertexPointer(3, GL10.GL_FLOAT, 0, _vertexBuffer);
	gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, _textureBuffer);

	// Draw triangles using index buffer
	gl.glDrawElements(GL10.GL_TRIANGLES, _indexBuffer.limit(), GL10.GL_UNSIGNED_BYTE, _indexBuffer);

	// Restore state
	gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
	gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
