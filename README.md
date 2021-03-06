<div align="center">
  <img alt="icon" src="icon.png" width="200" />
  <h1>たまごちゃん</h1>

[![Kotlin](https://img.shields.io/badge/kotlin-1.7.10-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)
[![GitHub Releases](https://img.shields.io/github/v/release/sushi-dayo/tamago)](https://github.com/sushi-dayo/tamago/releases)
[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)
</div>

## 機能

- ルールに同意(リアクション)したら、メンバーロールを付与する。
- カラーコードを送信したら、プレビューを表示する。
- メッセージリンクを送信したら、内容のプレビューを表示する。

## コンフィグ

### config.properties

- `Tamago` というプリフィックスをつけたシステム環境変数でも設定可能です(例: `BotToken` → `TamagoBotToken`)
- ファイルに設定された値を優先します

```properties
# Discord Bot Token
# https://discord.com/developers/applications
BotToken=

# Rule Message ID
RuleMessageId=

# Member Role ID
MemberRoleId=
```

## 開発

### Gradle スクリプト

```shell
# Windows
gradlew.bat build

# Mac, Linux
./gradlew build
```

プロジェクトをビルドします。`build/libs` に `.jar` が生成されます。

```shell
# Windows
gradlew.bat run

# Mac, Linux
./gradlew run
```

ボットを起動します。`config.properties` の設定が必要です。

```shell
# Windows
gradlew.bat formatKotlin

# Mac, Linux
./gradlew formatKotlin
```

ソースコードを綺麗にします。
