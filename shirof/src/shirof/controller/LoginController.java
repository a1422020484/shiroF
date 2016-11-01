package shirof.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import shirof.po.ActiveUser;
import shirof.service.SysService;
import shirof.util.exception.UserException;

@Controller
@RequestMapping("/ttt")
public class LoginController {
	
	@Autowired
	private SysService sysService;

	@RequestMapping("/login")
	public String login(HttpSession session ,String randomcode,String usercode,String password) throws Exception{
		
		String validateCode = (String) session.getAttribute("validateCode");
		if(!validateCode.equals(randomcode)){
			throw new UserException("验证码输入错误！");
		}
		//验证用户名和密码是否正确，返回用户信息 id,name,usercode
		ActiveUser activeUser = sysService.authenticat(usercode, password);
		//通过校验后把用户信息放到session里面！
		session.setAttribute("activeUser", activeUser);
		
		return "jsp/index";
	}
}
