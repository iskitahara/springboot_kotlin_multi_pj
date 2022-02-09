# 概要
ひとまず動くところまでで、何をどう整理していくかイシューを１００個作るレポジトリ。
orderサービスはDBを参照、itemサービスはAPIを参照してデータを取得する。

### 修正するところ
./infra-order-db/src/main/resources/generatorConfig.xml
の以下の設定の「フルパス」を起動環境のパスに変更する

location="フルパス/infra-order-db/src/main/resources/mysql-connector-java-8.0.20.jar"/>

### もとのプロジェクト
こちらのブログ記事を元につくっています。  
GradleのマルチプロジェクトによるKotlin、Spring Bootでのオニオンアーキテクチャの実現
https://github.com/n-takehata/kotlin-onion-architecture-order-with-springboot-and-gradle

# 実行方法
以下の方法でアプリケーションを起動できます。

### Container起動
- mysql & redis start
```
% cd docker
% docker-compose up
```

### アプリケーション起動
- IntelliJ IDEAのGradleビューから、[api]->[Tasks]->[application]->[bootRun]を実行
- ターミナルで `./gradlew api:bootRun` を実行

### Database setup
- order_manager.sql を手動で実行する場合
```
% cd docker
% docker-compose up
% docker-compose exec db sh

mysql -u root -p mysql
```
docker/db/sql/order_manager.sql のqueryを実行

## mybatisGenerator 実行
- mysqlが起動していてテーブル定義がインポートされている状態
- コマンドを実行(gradleのバージョンでエラーとなったため distributionUrl=gradle-6.9-bin.zip にしています)
```
% cd infra-order-db
% ./gradlew mbGenerator
```

## swagger URL
http://localhost:8080/swagger-ui/index.html
