＃スプリングブートの簡単なデモ

デモは以下を使用します：
* [Spring Boot](https://spring.pleiades.io/spring-boot/docs/current/reference/html/)
* Maven（依存関係マネージャー）
* H2組み込みデータベース
* Thymeleaf（フロントエンドテンプレート用）
* JPA（データベースでより高いレベルの抽象化を実現するため）

## インストール

1. Eclipse 2020-06(Java Full Edition)をインストールする[Pleiades All in One](https://mergedoc.osdn.jp)
2. [spring demo](https://github.com/dokechin/spring-demo)をgit cloneするかDownload ZIP
3. Eclipseからプロジェクトをインポートします。 「ファイル」->「インポート」->「プロジェクト」を選択し、「Mavenプロジェクトのインポート」を選択します

## HTTPサーバがproxy環境の場合 以下のEclipseの設定が必要となります

1. [mavenの設定](http://bnote.net/java/eclipse_maven_proxy.shtml)
2. 1.で動かない場合 [Eclipseが使用するJavaVMを変えてみる](https://penult.hatenablog.com/category/Eclipse)
3. 2.で動かない場合、認証局の証明書をJDKのkeytoolで[インストール](https://stackoverflow.com/questions/684081/importing-ssl-certificate-into-eclipse)

## 実行
1. Eclipseからサーバーを起動します（プロジェクト右クリックして[Run as-> Spring Boot App]を選択）。
2. ブラウザからアドレス「localhost：8888」にアクセスします

## その他

* モデル（モデル）：src/main/java/com/example/demo/model folder
* テンプレート（ビュー）：src/main/resources/templates folder
* コントローラー（コントローラー）：src/main/java/com/example/demo/controller folder
* サービスクラス：src/main/java/com/example/demo/service folder
* メイン：src / main / javaフォルダーのDemoApplicationクラス
* データベースの内容を表示して管理するには、アドレス「localhost:8888/console」にアクセスします JDBC URLをjdbc:h2:./databaseに変更してConnectしてください
* 構成パラメーター：/src/main/resourcesフォルダーのapplication.propertiesファイル
* メッセージファイル：/src/main/resourcesフォルダーのmessages.propertiesファイル
* スタイルファイル（* .css）は、src/main/resources/static/css /フォルダーに配置する必要があります。 staticフォルダーとcssフォルダーが存在しない場合は作成します。
* JavaScriptファイル（* .js）は、src / main/resources/static/js /フォルダーに配置する必要があります。 staticフォルダーとjsフォルダーが存在しない場合は作成します。

## モデル

* エンティティ（データベースのテーブルに当たるもの）及びリポジトリ、エンティティの取得のためのクラスからなる
* アプリケーション起動時にエンティティからテーブル生成が自動的に行われている
* 構成パラメータ「spring.jpa.hibernate.ddl-auto」を変更することで、テーブルの自動生成をやめて自前で実行するようにすることもできる

## テンプレート

* Thymeleafの特徴としてはhtmlモックのをそのままソースとして使うことができるth名前空間は実行環境で使われるタグ。th名前空間がついていないものがモック用 (例 th:action,action)

## コントローラ

* URLとロジック（サービス）、ビュー(Thymeleaf)を結び付けているクラス

## サービス

* コントローラの中から呼びだすのは、必ずサービスクラスのメソッドとする
* サービスクラスの中で、モデルクラスやサービスクラスのメソッドを呼び出す

## テストを実行する（JUnitおよびMockito）

1.プロジェクトを右クリックして、「実行」->「JUnitテスト」

