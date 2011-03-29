package ca.sandstorm.luminance.gui;

/**
 * Creates a textual label based on the string passed in and can be rendered.
 * @author zenja
 */
public class TextLabel extends Label
{
    /**
     * Create the label, constructing the texture based on the "text" param.
     * @param text The string to render.
     */
    public TextLabel(float x, float y, float width, float height, String text)
    {
	super(x, y, width, height, text);
//
//	// Create an empty, mutable bitmap
//	Bitmap bitmap = Bitmap.createBitmap((int)width, (int)height, Bitmap.Config.ARGB_4444);
//	// get a canvas to paint over the bitmap
//	Canvas canvas = new Canvas(bitmap);
//	bitmap.eraseColor(0);
//
//	// get a background image from resources
//	// note the image format must match the bitmap format
//	//Drawable background = context.getResources().getDrawable(R.drawable.background);
//	//background.setBounds(0, 0, 256, 256);
//	//background.draw(canvas); // draw the background to our bitmap
//
//	// Draw the text
//	Paint textPaint = new Paint();
//	textPaint.setTextSize(32);
//	textPaint.setAntiAlias(true);
//	textPaint.setARGB(0xff, 0x88, 0x88, 0x88);
//	// draw the text centered
//	canvas.drawText(text, 0, 0, textPaint);
//
//	//Generate one texture pointer...
//	int[] textures = new int[1];
//	gl.glGenTextures(1, textures, 0);
//	//...and bind it to our array
//	gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);
//
//	//Create Nearest Filtered Texture
//	gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
//	gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
//
//	//Different possible texture parameters, e.g. GL10.GL_CLAMP_TO_EDGE
//	gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S, GL10.GL_REPEAT);
//	gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T, GL10.GL_REPEAT);
//
//	//Use the Android GLUtils to specify a two-dimensional texture image from our bitmap
//	GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
//
//	//Clean up
//	bitmap.recycle();
//		
//	// Create the texture resource associated with this
//	TextureResource texRes = new TextureResource("TextLabel " + text, textures[0], gl);
//	setTexture(texRes);
    }
}
