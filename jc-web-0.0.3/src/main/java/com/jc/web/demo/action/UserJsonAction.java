package com.jc.web.demo.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jc.web.demo.domain.User;
import com.jc.web.demo.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Result(type = "json", params = { "includeProperties", "status,message" }) //至返回status和message字段
public class UserJsonAction implements ModelDriven<User> {

	private String userId;

	private String status;

	private String message;

	@Autowired
	private UserService userService;

	@Action(value = "/user/getjson")
	public String add() {
		String result = "success";
		User user = new User();
		user = userService.getUser(userId);
		message = user.toString();
		return result;
	}

	/* getter and setter */
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
