package jp.dcworks.app.memberlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

/**
 * ホーム画面コントローラー。
 *
 * @author tomo-sato
 */
@Log4j2
@Controller
@RequestMapping("/")
public class HomeController {

	/**
	 * [GET]メンバー一覧画面のアクション。
	 *
	 * @param model 入力フォームのオブジェクト
	 * @return テンプレートpath
	 */
	@GetMapping(path = { "", "/" })
	public String index(Model model) {
		return "home/index";
	}
}
