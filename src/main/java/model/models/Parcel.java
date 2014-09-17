package model.models;

import java.util.Date;

import model.models.Customer;
import model.models.Station;
import model.models.Train;


public class Parcel {

	private int ID;
	private float weight;
	private Station currentStation;
	private Customer sender;
	private Customer reciever;
	private Station starts;
	private Station destination;
	private float totalCost;
	private boolean express;
	private boolean released;
	private Train train;
	private Date dateRecieved;
	private Date dateDelivered;
	private String addBy;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public Station getCurrentStation() {
		return currentStation;
	}
	public void setCurrentStation(Station currentStation) {
		this.currentStation = currentStation;
	}
	public Customer getSender() {
		return sender;
	}
	public void setSender(Customer sender) {
		this.sender = sender;
	}
	public Customer getReciever() {
		return reciever;
	}
	public void setReciever(Customer reciever) {
		this.reciever = reciever;
	}
	public Station getStarts() {
		return starts;
	}
	public void setStarts(Station starts) {
		this.starts = starts;
	}
	public Station getDestination() {
		return destination;
	}
	public void setDestination(Station destination) {
		this.destination = destination;
	}
	public float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	public boolean isExpress() {
		return express;
	}
	public void setExpress(boolean express) {
		this.express = express;
	}
	public boolean isReleased() {
		return released;
	}
	public void setReleased(boolean released) {
		this.released = released;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public Date getDateRecieved() {
		return dateRecieved;
	}
	public void setDateRecieved(Date dateRecieved) {
		this.dateRecieved = dateRecieved;
	}
	public Date getDateDelivered() {
		return dateDelivered;
	}
	public void setDateDelivered(Date dateDelivered) {
		this.dateDelivered = dateDelivered;
	}
	public String getAddBy() {
		return addBy;
	}
	public void setAddBy(String addBy) {
		this.addBy = addBy;
	}
	
	
	
}
