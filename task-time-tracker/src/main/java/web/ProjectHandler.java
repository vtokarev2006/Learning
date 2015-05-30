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

import domain.Project;
import domain.User;
import service.ProjectService;
import vo.Result;


@Controller
@RequestMapping("/project")
public class ProjectHandler extends AbstractHandler {
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/find", method=RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String find(
			@RequestParam(value="projectId", required=true) Integer projectId,
			HttpServletRequest request){
		
		
		User sessionUser = getSessionUser(request);
		
		
		Result<Project> ar = projectService.find(projectId, sessionUser.getUsername());
		
		if (ar.isSuccess()) {
			return getJsonSuccessData(ar.getData());
		} else {
			return getJsonErrorMsg(ar.getMsg());
		}
	}
	
	@RequestMapping(value="/store", method=RequestMethod.POST, produces={"application/json"})
	@ResponseBody
	public String store(
			@RequestParam(value="data", required=true) String jsonData,
			HttpServletRequest request){
		
		User sessionUser = getSessionUser(request);
		
		JsonObject jsonObj = parseJsonObject(jsonData);
		
		Result<Project> ar = projectService.store(
				getIntegerValue(jsonObj.get("projectId")), 
				getIntegerValue(jsonObj.get("companyId")), 
				jsonObj.getString("projectName"), 
				sessionUser.getUsername());
		
		if (ar.isSuccess()) {
			return getJsonSuccessData(ar.getData());
		} else {
			return getJsonErrorMsg(ar.getMsg());
		}
		
	}
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String findAll(HttpServletRequest request){
		
		User sessionUser = getSessionUser(request);
		
		Result<List<Project>> ar = projectService.findAll(sessionUser.getUsername());
		
		if (ar.isSuccess()) {
			return getJsonSuccessData(ar.getData());
		} else {
			return getJsonErrorMsg(ar.getMsg());
		}
		
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST, produces={"application/json"})
	@ResponseBody
	public String remove(
			@RequestParam(value="data", required=true) String jsonData, 
			HttpServletRequest request){
		
		User sessionUser = getSessionUser(request);
		
		JsonObject jsonObj = parseJsonObject(jsonData);
		
		Result<Project> ar = projectService.remove(
				getIntegerValue(jsonObj.get("projectId")), 
				sessionUser.getUsername());
		
		if (ar.isSuccess()) {
			return getJsonSuccessMsg(ar.getMsg());
		} else {
			return getJsonErrorMsg(ar.getMsg());
		}
		
	}

}
