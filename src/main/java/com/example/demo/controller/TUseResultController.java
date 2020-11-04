package com.example.demo.controller;

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

import com.example.demo.entity.TUseResult;
import com.example.demo.form.TUseResultForm;
import com.example.demo.service.TUseResultService;;

// コントローラークラスであることを示すアノテーションを付加する
@Controller
// リクエストマッピング　クラス単位
@RequestMapping("/tuseresult")
public class TUseResultController {

    // TUseResultServiceをインジェクトする
	@Autowired
    private TUseResultService tUseResultService;

    // 一覧表示遷移用のコントローラ
    @GetMapping("/index")
    public String index(Model model) {
        // 実績データを全件検索して、その結果を実績データ一覧画面に渡す
        Iterable<TUseResult> tUseResults = tUseResultService.findAll();
        System.out.println(tUseResults);
        model.addAttribute("tuseresults", tUseResults);
        // src/main/resources/templates/tuseresult/index.htmlに遷移する
        return "/tuseresult/index";
    }

    // 新規登録画面遷移するのコントローラメソッド
    @GetMapping("/insertMain")
    public String insertMain(Model model) {
        // フィールドが全てnullのフォームインスタンスを追加する
    	TUseResultForm form = TUseResultForm.createEmptyForm();
        model.addAttribute("tUseResultForm", form);

        // src/main/resources/templates/tuseresult/insertMain.htmlに遷移する
        return "/tuseresult/insertMain";
    }

    // 新規登録用のコントローラ
    @PostMapping("/insertComplete")
    public String insertComplete(
        @Validated @ModelAttribute("tUseResultForm")
            TUseResultForm tUseResultForm,
            BindingResult bindingResult, Model model) {

    	// バリデーションエラーの場合、更新画面へ戻る
        if (bindingResult.hasErrors()) {
            model.addAttribute("tUseResultForm", tUseResultForm);
            return "/tuseresult/insertMain";
        }
    	TUseResult tUseResult = null;
        try {
            // フォームをエンティティに変換
        	//　指定したユーザIDと楽曲コードが存在しない場合はエラー
        	tUseResult = tUseResultService.convertToEntity(tUseResultForm);
        } catch (Exception ex) {
        	model.addAttribute("error", ex.getMessage());
            model.addAttribute("tUseResultForm", tUseResultForm);
            return "/tuseresult/insertMain";
        }
        // 実績をDBに追加する
        tUseResultService.save(tUseResult);
        // 「/tuseresult/index」にリダイレクトする
        return "redirect:/tuseresult/index";
    }

    /**
     * 更新画面に遷移するコントローラーメソッド
     * パスの中に更新するIDが指定されて遷移してくる
     */
    @GetMapping("/updateMain/{id}")
    public String updateMain(@PathVariable Integer id, Model model) {
        // IDからエンティティを引く
    	TUseResult tuseResult = tUseResultService.findById(id);
        model.addAttribute("tUseResultForm", TUseResultForm.createForm(tuseResult));
        return "/tuseresult/updateMain";
    }

    // 更新用のコントローラ
    @PostMapping("/updateComplete")
    public String updateComplete(
    		@Validated @ModelAttribute("tUseResultForm")
               TUseResultForm tUseResultForm,
            BindingResult bindingResult, Model model) {

        // フォームをエンティティに変換
        if (bindingResult.hasErrors()) {
            model.addAttribute("tUseResultForm", tUseResultForm);
            return "/tuseresult/updateMain";
        }
    	TUseResult tUseResult = null;
        try {
        	tUseResult = tUseResultService.convertToEntity(tUseResultForm);
        } catch (Exception ex) {
        	model.addAttribute("error", ex.getMessage());
            model.addAttribute("tUseResultForm", tUseResultForm);
            return "/tuseresult/updateMain";
        }
        // 実績を更新する
        tUseResultService.save(tUseResult);
        // 「/tuseresult/index」にリダイレクトする
        return "redirect:/tuseresult/index";
    }

}
