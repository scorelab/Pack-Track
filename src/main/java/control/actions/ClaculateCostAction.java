package control.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import model.managers.StationManager;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import control.util.CostFunction;
import control.util.StationSearch;

/**
 * API for cost calculation
 *
 */
@Result(name = "success", type = "json")
@ParentPackage("json-default")
public class ClaculateCostAction extends ActionSupport implements
		ServletRequestAware {

	private HttpServletRequest request;
	private float cost;

	/**
	 * Executes POST to calculate-cost. Responses JSON object
	 */
	@org.apache.struts2.convention.annotation.Action(value = "calculate-cost", results = { @Result(name = "success", type = "json") })
	public String execute() {
		String start = request.getParameter("start");
		String finish = request.getParameter("finish");
		String weight = request.getParameter("weight");
		String express = request.getParameter("express");
		boolean e;
		if (express.equals("1")) {
			e = true;
		} else {
			e = false;
		}
		String category = request.getParameter("category");
		StationManager sm = new StationManager();
		float dist = StationSearch.getInstance().getDistance(
				sm.getStation(Integer.parseInt(start)).getCode(),
				sm.getStation(Integer.parseInt(finish)).getCode());
		cost = CostFunction.calculate(dist, Float.parseFloat(category),
				Float.parseFloat(weight), e);
		BigDecimal bd = new BigDecimal(Float.toString(cost));
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		cost = bd.floatValue();
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
}
