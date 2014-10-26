package control.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.managers.ParcelManager;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class TrackParcelAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map<String, Object> session;
	private String res;
	
	@org.apache.struts2.convention.annotation.Action(value = "track-parcel")
	public String changeUser() throws Exception {
		String id = request.getParameter("id");
		String nic = request.getParameter("nic");
		ParcelManager pm=new ParcelManager();
		String temp;
		if(id.equals("")|| nic.equals("")){
			res="Invalid details";
			return SUCCESS;
		}
		temp=pm.trackParcel(Long.parseLong(id), nic);
		if(temp==null){
			res="Invalid details";
		}else if(pm.getParcel(Long.parseLong(id)).getDestination().getName().equals(temp)){
			res="Your package is at it's destination<b>("+temp+")</b>. Please pick it from there.";
		}else {
			res="Your package is at <b>"+temp+"</b>";
		}
		return SUCCESS;
	}
	
	
	public void setServletRequest(HttpServletRequest  request) {
		this. request =  request;
	}

	public HttpServletRequest getServletRequest() {
		return this. request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}


	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}


	public String getRes() {
		return res;
	}


	public void setRes(String res) {
		this.res = res;
	}
}
