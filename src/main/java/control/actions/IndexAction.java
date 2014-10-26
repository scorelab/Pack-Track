package control.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.managers.CategoryManager;
import model.managers.StationManager;
import model.models.Category;
import model.models.Station;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{

	private List<Station> stationList = new StationManager().getStationList();
	private List<Category> categoryList = new CategoryManager().getCategoryList();
	public List<Station> getStationList() {
		return stationList;
	}
	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
}
