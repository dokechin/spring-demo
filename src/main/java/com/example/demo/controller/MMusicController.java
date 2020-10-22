package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.MMusicForm;
import com.example.demo.model.Index;
import com.example.demo.model.MMusic;
import com.example.demo.model.MUser;
import com.example.demo.model.UpdateMain;
import com.example.demo.service.MMusicService;
import com.example.demo.service.MUserService;;

// コントローラークラスであることを示すアノテーションを付加する
@Controller
// リクエストマッピング　クラス単位
@RequestMapping("/mmusic")
public class MMusicController {

	// MMusicServiceをインジェクトする
	@Autowired
	private MMusicService mMusicService;

	// TUseResultServiceをインジェクトする
	//@Autowired
	//private TUseResultService tUseResultService;

	// MUserServiceをインジェクトする
	@Autowired
	private MUserService mUserService;

	// 一覧表示遷移用のコントローラ
	@GetMapping("/index")
	public String index(Model model) {
		// 楽曲データを全件検索して、その結果を楽曲データ一覧画面に渡す
		List<Index> indexList = new ArrayList<Index>();

		//Listにデータを入れて、一覧表示に必要なデータをgetできるようにする。
		List<MMusic> mMusicList = (List<MMusic>) mMusicService.findAll();
		List<MUser> mUserList = (List<MUser>) mUserService.findAll();

		//for文でmusicCdに対応したuserNameを表示するようにするためにnewする。
		MUser mUser = new MUser();

		//一覧表示に必要なデータのフィールドを持つindex1にデータを入れ、mMusicsListの要素数だけ繰り返しindex1をindexListに入れいていく。
		for(int i=0;i < mMusicList.size(); i++) {
			Index index1 = new Index();
			index1.setUseResultId(mUserList.get(i).getUserId());
			index1.setMusicCd(mMusicList.get(i).getMusicCd());
			index1.setMusicName(mMusicList.get(i).getMusicName());
			index1.setRecv_percent_1(mMusicList.get(i).getRecv_percent_1());
			mUser = mUserService.findById(Integer.parseInt(mMusicList.get(i).getRecv_user_id_1()));
			index1.setUserName(mUser.getUserName());
			index1.setRecv_user_id_1(mMusicList.get(i).getRecv_user_id_1());
			indexList.add(index1);
		}

		model.addAttribute("indexList", indexList);

		return "/mmusic/index";
	}

	// 新規登録画面遷移するのコントローラメソッド
	@GetMapping("/insertMain")
	public String insertMain(Model model) {
		// フィールドが全てnullのフォームインスタンスを追加する
		MMusicForm form = MMusicForm.createEmptyForm();
		model.addAttribute("mmusicForm", form);

		// src/main/resources/templates/mmusic/insertMain.htmlに遷移する
		return "/mmusic/insertMain";
	}

	// 新規登録用のコントローラ
	@PostMapping("/insertComplete")
	public String insertComplete(
			@Validated @ModelAttribute("mmusicForm")
			MMusicForm mmusicForm,
			BindingResult bindingResult, Model model) {

		// バリデーションエラーの場合、更新画面へ戻る
		if (bindingResult.hasErrors()) {
			model.addAttribute("mmusicForm", mmusicForm);
			return "/mmusic/insertMain";
		}

		MMusic mmusic = null;

		try {
			// フォームをエンティティに変換
			//指定したユーザIDと楽曲コードが存在しない場合はエラー
			mmusic = mMusicService.convertToEntity(mmusicForm);
		} catch (Exception ex) {
			//ここで入力した「楽曲コードは存在しません」などが画面に出力される
			model.addAttribute("error", ex.getMessage());
			model.addAttribute("mmusicForm", mmusicForm);
			return "/mmusic/insertMain";
		}
		//楽曲データをDBに追加する
		mMusicService.save(mmusic);
		//「/mmusic/index」にリダイレクトする
		return "redirect:/mmusic/index";
	}

	/**
	 * 更新画面に遷移するコントローラーメソッド
	 * パスの中に更新するmusicCdが指定されて遷移してくる
	 */
	@GetMapping("/updateMain/{musicCd}")
	public String updateMain(@PathVariable String musicCd, Model model) {
		// musicCdからエンティティを引く
		MMusic mmusic = mMusicService.findByMusicCd(musicCd);

		//mmusicFormを初期化
		MMusicForm mmusicForm = MMusicForm.createEmptyForm();
		mmusicForm = MMusicForm.createFormSt(mmusic);
		List<MUser> mUserList = new ArrayList<MUser>();
		List<MUser> mUserAllList = (List<MUser>)mUserService.findAll();

		//登録や更新で""とnullと数字以外の値を保存できないので、この条件でExceptionが出ないようになる
		//MUserにFormの値が入っていたらuserIdでMUserを検索
		//初期データとしてnullが入れられていてもエラーページにならないように""とnull両方を条件にしている
		for(int i=0;i < mUserAllList.size();i++) {
			if(mmusicForm.getRecv_user_id_1() != "" && mmusicForm.getRecv_user_id_1() != null) {
				if(mUserAllList.get(i).getUserId() == Integer.parseInt(mmusicForm.getRecv_user_id_1())) {
					mUserList.add(mUserService.findById(Integer.parseInt(mmusicForm.getRecv_user_id_1())));
				}
			}
		}
		for(int i=0;i < mUserAllList.size();i++) {
			if(mmusicForm.getRecv_user_id_2() != "" && mmusicForm.getRecv_user_id_2() != null) {
				if(mUserAllList.get(i).getUserId() == Integer.parseInt(mmusicForm.getRecv_user_id_2())) {
					mUserList.add(mUserService.findById(Integer.parseInt(mmusicForm.getRecv_user_id_2())));
				}
			}
		}
		for(int i=0;i < mUserAllList.size();i++) {
			if(mmusicForm.getRecv_user_id_3() != "" && mmusicForm.getRecv_user_id_3() != null) {
				if(mUserAllList.get(i).getUserId() == Integer.parseInt(mmusicForm.getRecv_user_id_3())) {
					mUserList.add(mUserService.findById(Integer.parseInt(mmusicForm.getRecv_user_id_3())));
				}
			}
		}for(int i=0;i < mUserAllList.size();i++) {
			if(mmusicForm.getRecv_user_id_4() != "" && mmusicForm.getRecv_user_id_4() != null) {
				if(mUserAllList.get(i).getUserId() == Integer.parseInt(mmusicForm.getRecv_user_id_4())) {
					mUserList.add(mUserService.findById(Integer.parseInt(mmusicForm.getRecv_user_id_4())));
				}
			}
		}
		for(int i=0;i < mUserAllList.size();i++) {
			if(mmusicForm.getRecv_user_id_5() != "" && mmusicForm.getRecv_user_id_5() != null) {
				if(mUserAllList.get(i).getUserId() == Integer.parseInt(mmusicForm.getRecv_user_id_5())) {
					mUserList.add(mUserService.findById(Integer.parseInt(mmusicForm.getRecv_user_id_5())));
				}
			}
		}

		UpdateMain updateMain = new UpdateMain();

		updateMain.setMusicCd(mmusicForm.getMusicCd());
		updateMain.setMusicName(mmusicForm.getMusicName());
		updateMain.setRecv_user_id_1(mmusicForm.getRecv_user_id_1());
		updateMain.setRecv_percent_1(mmusicForm.getRecv_percent_1());
		updateMain.setRecv_user_id_2(mmusicForm.getRecv_user_id_2());
		updateMain.setRecv_percent_2(mmusicForm.getRecv_percent_2());
		updateMain.setRecv_user_id_3(mmusicForm.getRecv_user_id_3());
		updateMain.setRecv_percent_3(mmusicForm.getRecv_percent_3());
		updateMain.setRecv_user_id_4(mmusicForm.getRecv_user_id_4());
		updateMain.setRecv_percent_4(mmusicForm.getRecv_percent_4());
		updateMain.setRecv_user_id_5(mmusicForm.getRecv_user_id_5());
		updateMain.setRecv_percent_5(mmusicForm.getRecv_percent_5());

		//mUserListにrecv_user_idの値に紐づいたuserNmaeが入れられている
		if(mUserList.size() >= 1) {
			updateMain.setUserName1(mUserList.get(0).getUserName());
		}
		if(mUserList.size() >= 2) {
			updateMain.setUserName2(mUserList.get(1).getUserName());
		}
		if(mUserList.size() >= 3) {
			updateMain.setUserName3(mUserList.get(2).getUserName());
		}
		if(mUserList.size() >= 4) {
			updateMain.setUserName4(mUserList.get(3).getUserName());
		}
		if(mUserList.size() >= 5) {
			updateMain.setUserName5(mUserList.get(4).getUserName());
		}

		model.addAttribute("updateMain",updateMain);

		return "/mmusic/updateMain";
	}

	// 更新用のコントローラ
	@PostMapping("/updateComplete")
	public String updateComplete(
			@Validated @ModelAttribute("updateMain")
			UpdateMain updateMain,
			BindingResult bindingResult, Model model) {

		//更新ではhtmlファイルとUpdateMain型で値をやり取りするが、新規登録ではMMusicForm型でやり取りしているので、updateMainの中身をMMusicForm型のmmusicFormにsetしてからconvertToEntity()を使う
		MMusicForm mmusicForm = new MMusicForm(null, null, null, null, null, null, null, null, null, null, null, null);

		mmusicForm.setMusicCd(updateMain.getMusicCd());
		mmusicForm.setMusicName(updateMain.getMusicName());
		mmusicForm.setRecv_user_id_1(updateMain.getRecv_user_id_1());
		mmusicForm.setRecv_percent_1(updateMain.getRecv_percent_1());
		mmusicForm.setRecv_user_id_2(updateMain.getRecv_user_id_2());
		mmusicForm.setRecv_percent_2(updateMain.getRecv_percent_2());
		mmusicForm.setRecv_user_id_3(updateMain.getRecv_user_id_3());
		mmusicForm.setRecv_percent_3(updateMain.getRecv_percent_3());
		mmusicForm.setRecv_user_id_4(updateMain.getRecv_user_id_4());
		mmusicForm.setRecv_percent_4(updateMain.getRecv_percent_4());
		mmusicForm.setRecv_user_id_5(updateMain.getRecv_user_id_5());
		mmusicForm.setRecv_percent_5(updateMain.getRecv_percent_5());
		mmusicForm.setUserName1(updateMain.getUserName1());
		mmusicForm.setUserName2(updateMain.getUserName2());
		mmusicForm.setUserName3(updateMain.getUserName3());
		mmusicForm.setUserName4(updateMain.getUserName4());
		mmusicForm.setUserName5(updateMain.getUserName5());

		// バリデーションエラーの場合、更新画面へ戻る
		if (bindingResult.hasErrors()) {
			model.addAttribute("updateMain", updateMain);
			return "/mmusic/updateMain";
		}

		MMusic mmusic = null;

		try {
			// フォームをエンティティに変換
			//入力にエラーがあった場合は、エラーメッセージがcatchされる
			mmusic = mMusicService.convertToEntity(mmusicForm);
		} catch (Exception ex) {
			String message = "";
			List<String> messages = new ArrayList<String>();
			messages.add(ex.getMessage());
			for(int i=0;i < messages.size();i++) {
				message += (messages.get(i) + "\n ");
			}
			System.out.println("ex.getMessage() = " + ex.getMessage());
			model.addAttribute("error", message);
			model.addAttribute("updateMain", updateMain);

			return "/mmusic/updateMain";
		}

		//楽曲データを更新する
		//BeanとFormが同じになっているので、saveはしない　保留
		//mMusicService.save(mmusic);
		// 「/mmusic/index」にリダイレクトする
		return "redirect:/mmusic/index";
	}
}
