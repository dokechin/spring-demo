package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MMusicDto;
import com.example.demo.entity.MMusic;
import com.example.demo.entity.MUser;
import com.example.demo.form.MMusicForm;
import com.example.demo.repository.MMusicRepository;
import com.example.demo.repository.MUserRepository;

// ビジネスロジッククラスのBeanであることを示すServiceアノテーションを付加する
@Service
public class MMusicService {

	// MMusic操作用のリポジトリをインジェクションする
	@Autowired
	private MMusicRepository mMusicRepository;

	// MMusic操作用のリポジトリをインジェクションする
	@Autowired
	private MUserRepository mUserRepository;

	// MMusic操作用のリポジトリをインジェクションする
	@Autowired
	private MMusicService mMusicService;

	// メッセージ取得用サービス
	@Autowired
	private MessageService messageService;

	//全件検索
	public Iterable<MMusic> findAll() {
		return mMusicRepository.findAll();
	}

	// IDによる検索
	public MMusic findById(Integer id) {
		return mMusicRepository.findById(id).get();
	}

	// ユーザIDによる検索
	public MUser findByUserId(Integer recv_user_id_1) {
		return mUserRepository.findById(recv_user_id_1).get();
	}

	// 楽曲コードによる検索
	public MMusic findByMusicCd(String musicCd) {
		return mMusicRepository.findByMusicCd(musicCd);
	}

	public List<MMusicDto> findMMusicAll(){
		return mMusicRepository.findMMusicAll();
	}

	// エンティティの保存
	public void save(MMusic mmusic) {
		mMusicRepository.save(mmusic);
	}

	// フォームからエンティティへ変換
	// 楽曲名、ユーザID1,ユーザ分配率1が存在しない場合Exceptionをthrow
	public MMusic convertToEntity(MMusicForm form) throws Exception{

		String message = "";

		MMusic music = null;

		List<MMusic> mMusicList = (List<MMusic>) mMusicService.findAll();

		//ここでExceptionの対策として、MMusicのmusicCdの最大値よりform.getMusicCdが大きかったら（まだ登録されていないmusicCdだったら）というif文を作ってfinByMusicCdメソッドを使う
		//mMusicListはmusicCdが1ずつ増えていくことを想定している
		if(Integer.parseInt(form.getMusicCd()) <= Integer.parseInt(mMusicList.get(mMusicList.size()-1).getMusicCd())) {
			music = mMusicService.findByMusicCd(form.getMusicCd());
		}

		//recv_user_id_1～5のいずれかが数値でも""でもない場合、エラーメッセージを出力
		if((!isNumber(form.getRecv_user_id_1()) && form.getRecv_user_id_1() != "") ||
				(!isNumber(form.getRecv_user_id_2()) && form.getRecv_user_id_2() != "") ||
				(!isNumber(form.getRecv_user_id_3()) && form.getRecv_user_id_3() != "") ||
				(!isNumber(form.getRecv_user_id_4()) && form.getRecv_user_id_4() != "") ||
				(!isNumber(form.getRecv_user_id_5()) && form.getRecv_user_id_5() != "")){
			message += messageService.getMessage("E10001");
			message += " ";
		}

		//formの中のmusicCdがDBにすでにあったら、Exceptionをthrowする。なければformのデータを入れて、MMusic型のmusicをreturnする
		if (music == null && form.getUserName1() != " ") {
			message += messageService.getMessage("E10002");
			message += "\n";
		}

		//musicCdがすでに登録されていたら *userNameが" "だったら新規登録画面と判別する
		if(Integer.parseInt(form.getMusicCd()) <= Integer.parseInt(mMusicList.get(mMusicList.size()-1).getMusicCd()) && form.getUserName1() == " ") {
			System.out.println("楽曲コードは登録済みです。");
			message += messageService.getMessage("E10003");
			message += "\n";
		}

		//recv_user_id_1がブランクで他がブランクでないとき
		if(form.getRecv_user_id_1() == "" && (form.getRecv_user_id_2() != "" || form.getRecv_user_id_3() != "" || form.getRecv_user_id_4() != "" || form.getRecv_user_id_5() != "")){
			//throw new Exception (messageService.getMessage("E10004")); //E10004 = 「ユーザーIDは上から順に入力してください。」
			message += messageService.getMessage("E10004");
		}
		//recv_user_id_2がブランクでrecv_user_id_3以下がブランクでないとき
		else if(form.getRecv_user_id_2() == "" && (form.getRecv_user_id_3() != "" || form.getRecv_user_id_4() != "" || form.getRecv_user_id_5() != "")){
			message += messageService.getMessage("E10004");
		}
		//recv_user_id_3がブランクでrecv_user_id_4以下がブランクでないとき
		else if(form.getRecv_user_id_3() == "" && (form.getRecv_user_id_4() != "" || form.getRecv_user_id_5() != "")){
			message += messageService.getMessage("E10004");
		}
		//recv_user_id_4がブランクでrecv_user_id_5以下がブランクでないとき
		else if(form.getRecv_user_id_4() == "" && form.getRecv_user_id_5() != ""){
			message += messageService.getMessage("E10004");
		}

		//recv_user_id_1がブランク以外でpercent1がブランクなとき またはrecv_user_id_1がブランクでpercent1がブランク以外のとき
		if((form.getRecv_user_id_1() == "" && form.getRecv_percent_1() != null) || (form.getRecv_user_id_1() != "" && form.getRecv_percent_1() == null)){
			message += messageService.getMessage("E10005");
		}
		//recv_user_id_2がブランク以外でpercent2がブランクなとき またはrecv_user_id_2がブランクでpercent2がブランク以外のとき
		else if((form.getRecv_user_id_2() == "" && form.getRecv_percent_2() != null) || (form.getRecv_user_id_2() != "" && form.getRecv_percent_2() == null)){
			message += messageService.getMessage("E10005");
		}
		//recv_user_id_3がブランク以外でpercent3がブランクなとき またはrecv_user_id_3がブランクでpercent3がブランク以外のとき
		else if((form.getRecv_user_id_3() == "" && form.getRecv_percent_3() != null) || (form.getRecv_user_id_3() != "" && form.getRecv_percent_3() == null)){
			message += messageService.getMessage("E10005");
		}
		//recv_user_id_4がブランク以外でpercent4がブランクなとき またはrecv_user_id_4がブランクでpercent4がブランク以外のとき
		else if((form.getRecv_user_id_4() == "" && form.getRecv_percent_4() != null) || (form.getRecv_user_id_4() != "" && form.getRecv_percent_4() == null)){
			message += messageService.getMessage("E10005");
		}
		//recv_user_id_5がブランク以外でpercent5がブランクなとき またはrecv_user_id_5がブランクでpercent5がブランク以外のとき
		else if((form.getRecv_user_id_5() == "" && form.getRecv_percent_5() != null) || (form.getRecv_user_id_5() != "" && form.getRecv_percent_5() == null)){
			message += messageService.getMessage("E10005");
		}

		//ユーザーマスタを検索
		try{
			MUser muser = findByUserId(Integer.parseInt(form.getRecv_user_id_1()));
		}catch (Exception e){
			message += messageService.getMessage("E10006");
			message += "\n ";
		};
		//分配率の合計が100でなかったらエラーメッセージを表示
		BigDecimal sum = new BigDecimal("0.00");
		sum = sum.add(form.getRecv_percent_1());
		if(form.getRecv_percent_2() !=null) {
			sum = sum.add(form.getRecv_percent_2());
		}
		if(form.getRecv_percent_3() !=null) {
			sum = sum.add(form.getRecv_percent_3());
		}
		if(form.getRecv_percent_4() !=null) {
			sum = sum.add(form.getRecv_percent_4());
		}
		if(form.getRecv_percent_5() !=null) {
			sum = sum.add(form.getRecv_percent_5());
		}

		//入力された分配率の合計が100以外にExceptionをthrowする
		if(sum.compareTo(BigDecimal.valueOf(100)) != 0) {
			message += messageService.getMessage("E10007");
			message += "\n";
		}

		//messageの中身があればExceptionをthrow
		if(message.length() > 0){
			throw new Exception (message);
		}

		return new MMusic(form.getMusicId(), form.getMusicCd(),form.getMusicName(), form.getRecv_user_id_1(),form.getRecv_percent_1(),
				form.getRecv_user_id_2(), form.getRecv_percent_2(), form.getRecv_user_id_3(), form.getRecv_percent_3(),
				form.getRecv_user_id_4(), form.getRecv_percent_4(), form.getRecv_user_id_5(), form.getRecv_percent_5(),
				LocalDate.now(),null);
	}

	//入力されたString型の値が数値であるか判定
	public boolean isNumber(String num){
		if(Pattern.matches("^[1-9]?[0-9]+$", num)){
			return true;
		}
		return false;
	}
}
