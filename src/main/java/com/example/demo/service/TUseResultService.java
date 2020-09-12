package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.form.TUseResultForm;
import com.example.demo.model.MMusic;
import com.example.demo.model.MUser;
import com.example.demo.model.TUseResult;
import com.example.demo.model.TUseResultRepository;

// ビジネスロジッククラスのBeanであることを示すServiceアノテーションを付加する
@Service
public class TUseResultService {

    // TUseResult操作用のリポジトリをインジェクションする
	@Autowired
    private TUseResultRepository tUseResultRepository;

    // MUser操作用のリポジトリをインジェクションする
	@Autowired
	private MUserService mUserService;

    // MMusicS操作用のリポジトリをインジェクションする
	@Autowired
	private MMusicService mMusicService;

	// メッセージ取得用サービス
	@Autowired
	private MessageService messageService;

	// 全件検索
    public Iterable<TUseResult> findAll() {
    	return tUseResultRepository.findAll();
    }

	// IDによる検索
    public TUseResult findById(Integer id) {
    	return tUseResultRepository.findById(id).get();
    }

	// エンティティの保存
    public void save(TUseResult tUseResult) {
    	tUseResultRepository.save(tUseResult);
    }

	// フォームからエンティティへ変換
    // ユーザコード,楽曲コードが存在しない場合Exception
	public TUseResult convertToEntity(TUseResultForm form) throws Exception{
		MUser user = mUserService.findByUserCd(form.getUserCd());
		if (user == null) {
			throw new Exception(messageService.getMessage("E10001"));
		}
		MMusic music = mMusicService.findByMusicCd(form.getMusicCd());
		if (music == null ) {
			throw new Exception (messageService.getMessage("E10002"));
		}
		if (form.getId() == null) {
			return new TUseResult(user,music,form.getAmount(),form.getUseDate(),form.getUsePlace(),LocalDate.now(),null);
		} else {
			return new TUseResult(form.getId(), user, music,form.getAmount(),form.getUseDate(),form.getUsePlace(),LocalDate.now(),null);
		}
	}
}
