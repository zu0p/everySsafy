package everyssafy.dispatcher;

import java.util.HashMap;

import everyssafy.controller.ChNickController;
import everyssafy.controller.ChPassController;
import everyssafy.controller.ChkIdController;
import everyssafy.controller.Controller;
import everyssafy.controller.DeleteArticleController;
import everyssafy.controller.DeleteCommentController;
import everyssafy.controller.DeleteController;
import everyssafy.controller.GetListArticleController;
import everyssafy.controller.GetListCommentController;
import everyssafy.controller.LoginController;
import everyssafy.controller.LogoutController;
import everyssafy.controller.ModifyArticleController;
import everyssafy.controller.MyPageController;
import everyssafy.controller.ModifyCommentController;
import everyssafy.controller.RegistController;
import everyssafy.controller.RegisterArticleController;
import everyssafy.controller.RegisterCommnetController;

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
		map.put("/deleteUser.do", new DeleteController());
		map.put("/mypage.do", new MyPageController());
		map.put("/regitercomment.do", new RegisterCommnetController());
		map.put("/modifycomment.do", new ModifyCommentController());
		map.put("/deletecomment.do", new DeleteCommentController());
		map.put("/getlistcommnet.do", new GetListCommentController());
	}
	public static Controller getMapping(String path) {		
		return map.get(path);
	}
}
