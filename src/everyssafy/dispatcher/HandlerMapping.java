package everyssafy.dispatcher;

import java.util.HashMap;

import everyssafy.controller.ArticleController;
import everyssafy.controller.ChkIdController;
import everyssafy.controller.Controller;
import everyssafy.controller.LoginController;
import everyssafy.controller.LogoutController;
import everyssafy.controller.RegistController;

public class HandlerMapping {
	static HashMap<String, Controller> map = new HashMap<>();
	static { 
		map.put("/login.do", new LoginController());
		map.put("/logout.do", new LogoutController());
		map.put("/register.do", new RegistController());
		map.put("/article.do", new ArticleController());
		map.put("/chkId.do", new ChkIdController());
	}
	public static Controller getMapping(String path) {		
		return map.get(path);
	}
}
