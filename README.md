# たまごちゃん

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
