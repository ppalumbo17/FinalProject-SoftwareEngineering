package Final;

import java.util.Random;

public class TargetGenerator {

	private int x, y, width, height;
	
	
	public TargetGenerator(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}



	public Target createTarget()
	{
		Random r = new Random();
		double xcoor = x + width * r.nextDouble();
		double ycoor = y + height * r.nextDouble();
		
		return new Target((int)Math.round(xcoor), (int)Math.round(ycoor));
	}
}
