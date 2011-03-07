package ca.sandstorm.luminance.test.math;

import ca.sandstorm.luminance.math.Lerp;
import android.test.AndroidTestCase;

/**
 * Testing of the Lerp class 
 * @author Chet
 *
 */
public class LerpTest extends AndroidTestCase {

	/*
	 * (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	/*
	 * Testing of the lerp method
	 */
	public void testLerp() throws Exception {
		// Declare some initial values
		float start = 0.0f;
		float target = 6.0f;
		float duration = 15.0f;
		
		// if time since start is 0, result should be the start
		float result1 = Lerp.lerp(start, target, duration, 0.0f);
		assert(result1 == start);
		
		// if time since start is within duration
		float result2 = Lerp.lerp(start, target, duration, 12.0f);
		float range = target - start;
		float percent = 12.0f / duration;
		float value = start + (range*percent);
		assert(result2 == value);
		
		// if time since start is greater than duration, value is the target
		float result3 = Lerp.lerp(start, target, duration, 20.0f);
		assert(result3 == target);
	}
	
	/*
	 * public static float ease(float start, float target, float duration,
	    float timeSinceStart)
    {
	float value = start;
	if (timeSinceStart > 0.0f && timeSinceStart < duration) {
	    final float range = target - start;
	    final float percent = timeSinceStart / (duration / 2.0f);
	    if (percent < 1.0f) {
		value = start + ((range / 2.0f) * percent * percent * percent);
	    } else {
		final float shiftedPercent = percent - 2.0f;
		value = start +
			((range / 2.0f) * ((shiftedPercent * shiftedPercent * shiftedPercent) + 2.0f));
	    }
	} else if (timeSinceStart >= duration) {
	    value = target;
	}
	return value;
    }
	 */
	
	/*
	 * Testing of the ease() method
	 */
	public void testEase() throws Exception {
		// Declare some initial values
		// Declare some initial values
		float start = 0.0f;
		float target = 6.0f;
		float duration = 15.0f;
		
		// if time since start is 0, result should be the start
		float result1 = Lerp.ease(start, target, duration, 0.0f);
		assert(result1 == start);
		
		// if time since start is within duration
		float result2 = Lerp.ease(start, target, duration, 12.0f);
		float range = target - start;
		float percent = 12.0f / (duration / 2.0f);
		float value;
		if(percent < 1.0f){
			value = start + ((range/2.0f)*percent*percent*percent);
		}
		else {
			float shiftedPercent = percent - 2.0f;
			value = start +
				((range / 2.0f) * ((shiftedPercent * shiftedPercent * shiftedPercent) + 2.0f));
		}
		assert(result2 == value);
		
		// if time since start is greater than duration, value is the target
		float result3 = Lerp.ease(start, target, duration, 20.0f);
		assert(result3 == target);
	}

	/*
	 * (non-Javadoc)
	 * @see android.test.AndroidTestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
