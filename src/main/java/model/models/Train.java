package model.models;

/**
 * Entity class for train object
 * 
 * @author Dilanka1
 * 
 */
public class Train {

	private int ID;
	private String name;
	private String addBy;
	private Station start;
	private Station finish;

	public Train() {

	}

	public Train(int id, String Name, String addby, Station Start, Station Finish) {
		this.ID = id;
		this.name = Name;
		this.start = Start;
		this.finish = Finish;
		this.addBy = addby;
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

	public Station getStart() {
		return start;
	}

	public void setStart(Station start) {
		this.start = start;
	}

	public Station getFinish() {
		return finish;
	}

	public void setFinish(Station finish) {
		this.finish = finish;
	}

	

}
