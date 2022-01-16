# たまごちゃん

[![Kotlin](https://img.shields.io/badge/kotlin-1.6.10-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)
[![GitHub Releases](https://img.shields.io/github/v/release/sushi-dayo/tamago)](https://github.com/sushi-dayo/tamago/releases)
[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

Discord Bot

## コンフィグ

### config.properties

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
