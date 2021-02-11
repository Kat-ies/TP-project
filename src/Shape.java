

/**
 * @author fedya001
 * @version 1.0
 * @created 12-Feb-2021 1:23:13 AM
 */
public interface Shape {

	public void draw();

	public Point location();

	/**
	 *
	 * @param point
	 */
	public void move(Point point);

}