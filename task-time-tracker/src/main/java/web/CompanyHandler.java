package web;

import static web.SecurityHelper.getSessionUser;

import java.util.List;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Company;
import domain.User;
import service.CompanyService;
import vo.Result;


@Controller
@RequestMapping("/company")
public class CompanyHandler extends AbstractHandler {
	
	@Autowired
	protected CompanyService companyService;
	
	@RequestMapping(value="/find", method=RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String find(
			@RequestParam(value="companyId", required=true)
			Integer companyId,
			HttpServletRequest request){
		
		
		User sessionUser = 	getSessionUser(request);
		
		Result<Company> ar = companyService.find(companyId, sessionUser.getUsername());
		
		if (ar.isSuccess()) {
			
			return getJsonSuccessData(ar.getData());
			
		} else {
			
			return getJsonErrorMsg(ar.getMsg());
			
		}
		
	}
	
	
	@RequestMapping(value="/store", method=RequestMethod.POST, produces={"application/json"})
	@ResponseBody
	public String store(
			@RequestParam(value = "data", required = true)
			String JsonData,
			HttpServletRequest request){
		
		User sessionUser = getSessionUser(request);
		 
		JsonObject jsonObj = parseJsonObject(JsonData);
		
		Result<Company> ar = companyService.store(
				getIntegerValue(jsonObj.get("companyId")), 
				jsonObj.getString("companyName"), 
				sessionUser.getUsername());
		
		if(ar.isSuccess()){
			
			return getJsonSuccessData(ar.getData());
			
		} else {
			
			return getJsonErrorMsg(ar.getMsg());
		}
		
	}
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String findAll(HttpServletRequest request){
		
		User userSession = getSessionUser(request);
		
		Result<List<Company>> ar = companyService.findAll(userSession.getUsername());
		
		if(ar.isSuccess()) {
			
			return getJsonSuccessData(ar.getData());
			
		} else {
			
			return getJsonErrorMsg(ar.getMsg());
			
		}
		
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST, produces={"application/json"})
	@ResponseBody
	public String remove(
			@RequestParam(value = "data", required = true) String jsonData, 
			HttpServletRequest request){
		
		User userSession = getSessionUser(request);
		
		JsonObject jsonObj = parseJsonObject(jsonData);
		
		
		
		Result<Company> ar = companyService.remove(getIntegerValue(jsonObj.get("companyId")), userSession.getUsername());
		
		if(ar.isSuccess()) {
			
			return getJsonSuccessMsg(ar.getMsg());
			
		} else {
			
			return getJsonErrorMsg(ar.getMsg());
			
		}
		
	}
	

}
