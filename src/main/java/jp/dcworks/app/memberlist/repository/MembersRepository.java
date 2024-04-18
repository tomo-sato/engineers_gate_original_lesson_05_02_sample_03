package jp.dcworks.app.memberlist.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import jp.dcworks.app.memberlist.entity.Members;

/**
 * メンバー関連リポジトリインターフェース。
 *
 * @author tomo-sato
 */
public interface MembersRepository extends PagingAndSortingRepository<Members, Long>, CrudRepository<Members, Long> {

	/**
	 * メンバー検索を行う。
	 * メールアドレスを指定し、メンバーを検索する。
	 *
	 * @param emailAddress メールアドレス
	 * @return メンバー情報を返す。
	 */
	List<Members> findByEmailAddress(String emailAddress);

	/**
	 * メンバー一覧を取得する。
	 * メンバーIDの昇順。
	 * @return メンバー一覧を返す。
	 */
	Page<Members> findByOrderByIdAsc(Pageable pageable);

	/**
	 * メンバーを削除する。
	 */
	void delete(Members members);
}
