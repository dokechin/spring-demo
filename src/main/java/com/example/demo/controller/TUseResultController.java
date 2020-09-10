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
        return "/tuseresult/index";
    }

    @GetMapping("/insertMain")
    public String insertMain(Model model) {
        // フィールドが全てnullのフォームインスタンスを追加する
    	TUseResultForm form = TUseResultForm.createEmptyForm();
        model.addAttribute("tUseResultForm", form);

        // src/main/resources/templates/insertMain.htmlに遷移する
        return "/tuseresult/insertMain";
    }

    @PostMapping("/insertComplete")
    public String insertComplete(
    		@Validated @ModelAttribute
               TUseResultForm tUseResultForm,
            BindingResult bindingResult, Model model) {

        // フォームをエンティティに変換
        if (bindingResult.hasErrors()) {
            model.addAttribute("tUseResultForm", tUseResultForm);
            return "/tuseresult/insertMain";
        }
    	TUseResult tUseResult = null;
        try {
        	tUseResult = tUseResultService.convertToEntity(tUseResultForm);
        } catch (Exception ex) {
        	model.addAttribute("error", ex.getMessage());
            model.addAttribute("tUseResultForm", tUseResultForm);
            return "/tuseresult/insertMain";
        }
        // 顧客をDBに追加する
        tUseResultService.save(tUseResult);
        // 「/」にリダイレクトする
        return "redirect:/tuseresult/index";
    }

    /**
     * 社員更新画面に遷移するコントローラーメソッド。
     */
    // updateMain()
    @GetMapping("/updateMain/{id}")
    public String updateMain(@PathVariable Integer id, Model model) {
        // idからエンティティを引く
    	TUseResult tuseResult = tUseResultService.findById(id);
        model.addAttribute("tUseResultForm", TUseResultForm.createForm(tuseResult));
        return "/tuseresult/updateMain";
    }

    @PostMapping("/updateComplete")
    public String updateComplete(
    		@Validated @ModelAttribute
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
        // 顧客をDBに追加する
        tUseResultService.save(tUseResult);
        // 「/」にリダイレクトする
        return "redirect:/tuseresult/index";
    }

}
