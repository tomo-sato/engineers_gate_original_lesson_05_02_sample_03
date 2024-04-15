package jp.dcworks.app.memberlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.dcworks.app.memberlist.dto.RequestMember;
import jp.dcworks.app.memberlist.entity.Members;
import jp.dcworks.app.memberlist.repository.MembersRepository;
import lombok.extern.log4j.Log4j2;

/**
 * メンバー関連サービスクラス。
 *
 * @author tomo-sato
 */
@Log4j2
@Service
public class MembersService {

	/** リポジトリインターフェース。 */
	@Autowired
	private MembersRepository repository;

	/**
	 * メンバー全件取得する。
	 *
	 * @return メンバーを全件取得する。
	 */
	public List<Members> findAllTopics() {
		return (List<Members>) repository.findByOrderByIdAsc();
	}

	/**
	 * メンバー検索を行う。
	 * メンバーIDを指定し、メンバーを検索する。
	 *
	 * @param membersId メンバーID
	 * @return メンバー情報を返す。
	 */
	public Members findById(Long membersId) {
		log.info("メンバーを検索します。：membersId={}", membersId);

		Members members = repository.findById(membersId).orElse(null);
		log.info("メンバー検索結果。：usersId={}, members={}", membersId, members);

		return members;
	}

	/**
	 * メンバー検索を行う。
	 * メールアドレスを指定し、メンバーを検索する。
	 *
	 * @param emailAddress メールアドレス
	 * @return メンバー情報を返す。
	 */
	public Members findByEmailAddress(String emailAddress) {
		log.info("メンバーを検索します。：emailAddress={}", emailAddress);

		Members members = repository.findByEmailAddress(emailAddress);
		log.info("メンバー検索結果。：emailAddress={}, members={}", emailAddress, members);

		return members;
	}

	/**
	 * メンバー登録処理を行う。
	 *
	 * @param requestMember メンバーDTO
	 */
	public void save(RequestMember requestMember) {
		Members members = new Members();
		members.setName(requestMember.getName());
		members.setEmailAddress(requestMember.getEmailAddress());
		repository.save(members);
	}

	/**
	 * メンバー登録処理を行う。
	 *
	 * @param members メンバーエンティティ
	 */
	public void save(Members members) {
		repository.save(members);
	}

	/**
	 * メンバー一覧を取得する。
	 * @return メンバー一覧
	 */
	public Iterable<Members> findAll() {
		return repository.findAll();
	}
}