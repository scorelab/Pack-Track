package model.models;

/**
 * Entity class for train object
 * 
 * @author Dilanka1
 * 
 */
public class Train {

	int ID;
	String name;
	String addBy;
	int start;
	int finish;

	public Train() {

	}

	public Train(int id, String Name, String addby, int Start, int Finish) {
		ID = id;
		name = Name;
		start = Start;
		finish = Finish;
		addBy = addby;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddBy() {
		return addBy;
	}

	public void setAddBy(String addBy) {
		this.addBy = addBy;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getFinish() {
		return finish;
	}

	public void setFinish(int finish) {
		this.finish = finish;
	}

	

}
