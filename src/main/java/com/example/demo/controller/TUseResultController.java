package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.TUseResultForm;
import com.example.demo.model.TUseResult;
import com.example.demo.service.TUseResultService;;

// TODO 3-04 コントローラークラスであることを示すアノテーションを付加する
@Controller
@RequestMapping("/tuseresult")
public class TUseResultController {

    // TODO 3-05 CustomerServiceをコンストラクタインジェクションする
	@Autowired
    private TUseResultService tUseResultService;

    @GetMapping("/index")
    public String index(Model model) {
        // 顧客を全件検索して、その結果を顧客一覧画面に渡す
        Iterable<TUseResult> tUseResults = tUseResultService.findAll();
        model.addAttribute("tuseresults", tUseResults);
        // src/main/resources/templates/index.htmlに遷移する
        return "tuseresult/index";
    }

    @GetMapping("/insertMain")
    public String insertMain(Model model) {
        // フィールドが全てnullのフォームインスタンスを追加する
        model.addAttribute("tUseResultForm", TUseResultForm.createEmptyForm());
        // src/main/resources/templates/insertMain.htmlに遷移する
        return "tuseresult/insertMain";
    }

    @PostMapping("/insertComplete")
    public String insertComplete(
            // Bean Validationを実行するアノテーションを付加する
    		@Valid
               TUseResultForm tUseResultForm,
            BindingResult bindingResult , Model model) {
        // フォームをエンティティに変換
    	System.out.println(tUseResultForm.toString());
        TUseResult tUseResult = tUseResultForm.convertToEntity();
        // 顧客をDBに追加する
        tUseResultService.save(tUseResult);
        // 「/」にリダイレクトする
        return "redirect:/tuseresult/index";
    }
}
