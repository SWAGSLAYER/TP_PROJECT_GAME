package my.project.gop.main;

public class Vector2F {
	public float xpos,ypos;
	public static float worldXpos,worldYpos;
	
	public Vector2F() {
		this.xpos = 0.0f;
		this.ypos = 0.0f;	
	}
	
	public static Vector2F zero() {
		return new Vector2F(0,0);
	}
	
	public Vector2F(float xpos,float ypos) {
		this.xpos = xpos;
		this.ypos = ypos;
	}
	
	public void normalize(){
		double length = Math.sqrt(xpos * xpos + ypos * ypos);
		if (length != 0.0){
			float s = 1.0f / (float) length;
			xpos = xpos*s;
			ypos = ypos*s;
		}
	}
	public Vector2F getScreenLocation(){
		return new Vector2F(xpos,ypos);
	}
	
	public Vector2F getWorldLocation(){
		return new Vector2F(xpos - worldXpos,ypos - worldYpos);
	}
	
	public boolean equals(Vector2F vec){
		return (this.xpos == vec.xpos && this.ypos == vec.ypos);
	}
	
	public Vector2F copy(Vector2F vec){
		xpos = vec.xpos;
		ypos = vec.ypos;
		return new Vector2F(xpos, ypos);
	}
	
	public Vector2F add(Vector2F vec){
		xpos = xpos + vec.xpos;
		ypos = ypos + vec.ypos;
		return new Vector2F(xpos, ypos);
	}

	public static void setWorldVariables(float wx, float wy){
		worldXpos = wx;
		worldYpos = wy;
	}
	
	public static double getDistanceOnScreen(Vector2F vec1, Vector2F vec2){
		float v1 = vec1.xpos - vec2.xpos;
		float v2 = vec1.ypos - vec2.ypos;
		return Math.sqrt(v1*v1 + v2*v2);
	}
	
	public double getDistanceBetweenWorldVectors(Vector2F vec){
		float dx = Math.abs(getWorldLocation().xpos - vec.getWorldLocation().xpos);
		float dy = Math.abs(getWorldLocation().ypos - vec.getWorldLocation().ypos);
		return Math.abs(dx * dx - dy * dy);
	}
}