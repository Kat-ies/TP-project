

/**
 * @author fedya001
 * @version 1.0
 * @created 12-Feb-2021 1:23:09 AM
 */
public class Model implements ObservableModel {

	private List<Observer> observers;
	private List<Shape> shapes;
	public Shape m_Shape;
	public Observer m_Observer;

	public Model(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 *
	 * @param shape
	 */
	public int addShape(Shape shape){
		return 0;
	}

	/**
	 *
	 * @param id
	 */
	public void deleteShape(int id){

	}

	/**
	 *
	 * @param id
	 */
	public void drawShape(int id){

	}

	public List<int> getIds(){
		return null;
	}

	/**
	 *
	 * @param id
	 */
	public Point getShapeLocation(int id){
		return null;
	}

	/**
	 *
	 * @param id
	 * @param point
	 */
	public void moveShape(int id, Point point){

	}

	public void stateChanged(){

	}

	public void stateChanged(){

	}
}//end Model