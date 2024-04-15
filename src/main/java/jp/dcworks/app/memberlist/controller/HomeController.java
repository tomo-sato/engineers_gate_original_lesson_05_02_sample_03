package jp.dcworks.app.memberlist.controller;

import java.util.List;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.dcworks.app.memberlist.entity.Members;
import jp.dcworks.app.memberlist.service.MembersService;
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

	/** メンバー関連サービスクラス。 */
	@Autowired
	private MembersService membersService;

	/**
	 * [GET]メンバー一覧画面のアクション。
	 *
	 * @param model 入力フォームのオブジェクト
	 * @return テンプレートpath
	 */
	@GetMapping(path = { "", "/" })
	public String index(@ModelAttribute("isSuccess") String isSuccess,
			Model model) {

		// トピック全件取得する。
		List<Members> membersList = membersService.findAllTopics();
		model.addAttribute("membersList", membersList);
		model.addAttribute("isSuccess", BooleanUtils.toBoolean(isSuccess));

		return "home/index";
	}
}
