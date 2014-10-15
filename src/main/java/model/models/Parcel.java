package model.models;

import java.util.Date;

import model.models.Customer;
import model.models.Station;
import model.models.Train;


public class Parcel {

	private long ID;
	private float weight;
	private Station currentStation;
	private Customer sender;
	private Customer receiver;
	private Station starts;
	private Station destination;
	private float totalCost;
	private boolean express;
	private boolean released;
	private Train train;
	private long dateRecieved;
	private long dateDelivered;
	private String addBy;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
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
	public Customer getReceiver() {
		return receiver;
	}
	public void setReceiver(Customer reciever) {
		this.receiver = reciever;
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
	public long getDateRecieved() {
		return dateRecieved;
	}
	public void setDateRecieved(long dateRecieved) {
		this.dateRecieved = dateRecieved;
	}
	public long getDateDelivered() {
		return dateDelivered;
	}
	public void setDateDelivered(long dateDelivered) {
		this.dateDelivered = dateDelivered;
	}
	public String getAddBy() {
		return addBy;
	}
	public void setAddBy(String addBy) {
		this.addBy = addBy;
	}
	
	
	
}
