package everyssafy.dispatcher;

import java.util.HashMap;
import everyssafy.controller.ArticleController;
import everyssafy.controller.ChNickController;
import everyssafy.controller.ChPassController;
import everyssafy.controller.ChkIdController;
import everyssafy.controller.Controller;
import everyssafy.controller.DeleteArticleController;
import everyssafy.controller.GetListArticleController;
import everyssafy.controller.LoginController;
import everyssafy.controller.LogoutController;
import everyssafy.controller.ModifyArticleController;
import everyssafy.controller.RegistController;
import everyssafy.controller.RegisterArticleController;

public class HandlerMapping {
	static HashMap<String, Controller> map = new HashMap<>();
	static { 	
		map.put("/login.do", new LoginController());
		map.put("/logout.do", new LogoutController());
		map.put("/register.do", new RegistController());
		map.put("/chkId.do", new ChkIdController());
		map.put("/registerArticle.do", new RegisterArticleController());
		map.put("/modifyArticle.do", new ModifyArticleController());
		map.put("/getlistArticle.do", new GetListArticleController());
		map.put("/deleteArticle.do", new DeleteArticleController());
		map.put("/changeNick.do", new ChNickController());
		map.put("/changePass.do", new ChPassController());

	}
	public static Controller getMapping(String path) {		
		return map.get(path);
	}
}
