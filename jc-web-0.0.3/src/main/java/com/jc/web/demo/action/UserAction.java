package com.jc.web.demo.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jc.web.demo.domain.User;
import com.jc.web.demo.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class UserAction implements ModelDriven<User> {

	private String userId;
	private User user = new User();

	@Autowired
	private UserService userService;

	@Action(value = "/user/add", results = {
			@Result(name = "success", location = "/successPage.jsp"),
			@Result(name = "fail", location = "/fail.jsp") })
	public String add() {
		System.out.println("using action");
		String result = "success";
		userService.addUser(user);
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

}
