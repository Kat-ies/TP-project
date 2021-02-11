

/**
 * @author fedya001
 * @version 1.0
 * @created 12-Feb-2021 1:23:07 AM
 */
public interface ControllerInterface {

	/**
	 *
	 * @param shapeType
	 */
	public void changeShapeCreationForm(String shapeType);

	/**
	 *
	 * @param id
	 */
	public void deleteClicked(int id);

	/**
	 *
	 * @param id
	 */
	public void getLocationClicked(int id);

	/**
	 *
	 * @param id
	 */
	public void moveClicked(int id);

	public void submitClicked();

}