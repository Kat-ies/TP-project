

/**
 * @author fedya001
 * @version 1.0
 * @created 12-Feb-2021 1:23:10 AM
 */
public interface ObservableModel {

	/**
	 *
	 * @param shape
	 */
	public int addShape(Shape shape);

	/**
	 *
	 * @param id
	 */
	public void deleteShape(int id);

	/**
	 *
	 * @param id
	 */
	public void drawShape(int id);

	public List<int> getIds();

	/**
	 *
	 * @param id
	 */
	public Point getShapeLocation(int id);

	/**
	 *
	 * @param id
	 * @param point
	 */
	public void moveShape(int id, Point point);

	public void stateChanged();

}