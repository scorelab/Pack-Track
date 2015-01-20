package model.models;

/**
 * Entity class for train object
 * 
 * 
 */
public class Train {

	private String train_num;
	private String train_name;
	private String start_station;
	private String destination;
	private String train_type;
	private String train_run;
	private String train_direction;

	public String getTrain_num() {
		return train_num;
	}

	public void setTrain_num(String train_num) {
		this.train_num = train_num;
	}

	public String getTrain_name() {
		return train_name;
	}

	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}

	public String getStart_station() {
		return start_station;
	}

	public void setStart_station(String start_station) {
		this.start_station = start_station;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTrain_type() {
		return train_type;
	}

	public void setTrain_type(String train_type) {
		this.train_type = train_type;
	}

	public String getTrain_run() {
		return train_run;
	}

	public void setTrain_run(String train_run) {
		this.train_run = train_run;
	}

	public String getTrain_direction() {
		return train_direction;
	}

	public void setTrain_direction(String train_direction) {
		this.train_direction = train_direction;
	}

}
