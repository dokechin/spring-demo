package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

//ビジネスロジッククラスのBeanであることを示すServiceアノテーションを付加する
@Service
public class MessageService {

	// messages.propertiesにアクセスするためのインジェクションする
	@Autowired
    MessageSource messageSource;

	@Autowired
	private HttpServletRequest request;

	// メッセージを取得する可変引数でメッセージに埋め込みたい文字列を指定できる
	public String getMessage(String code, String ...args) {
		return messageSource.getMessage(code, args, request.getLocale());
	}

}
