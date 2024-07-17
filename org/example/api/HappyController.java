package org.example.api;

import org.example.model.MxxModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/happy")
public class HappyController {

    private static final Logger log= LoggerFactory.getLogger(HappyController.class);

    @Autowired
    MxxModel model;

    @GetMapping(value = "/mxx")
    public MxxModel mxx() {
        return model;  // String内容を返す
    }

    // ---追加・確認---
    @RequestMapping("/")
    public String home(){
        return "from StackOverFlow...Hello!";
    }
    @GetMapping(value = "/aaa")
    public String test(){
        return "0";
    }
    @GetMapping(value = "xyz")
    public String ABC(){
        return "solved? yay!";
    }
    // ----------------------------------

    // ぇぇっと,これはpost箇所だけど...レスポンスさせるために
    // curl -X POST -H "Content-Type: application/json" -d '{"value":"happyaaa"}'
    // curl -X POST -H "Content-Type: application/json" -d '{"value":"HappyNewYear"}' http://localhost:8080/happy/mxx
    // と、どこかで入力する必要あるけど どｋだろうか...  2024.07.10 この左横下のターミナル！
    @PostMapping(value = "/mxx")
    public MxxModel setMxx(@RequestBody MxxModel mxx) {
        model.setValue(mxx.getValue());
        log.info("set value:{}",model.getValue());
        return mxx;
    }
}


/* 2024/07/17(解決)
  GitBashでは成功したけど、どうしてもIDEターミナルで解決したい postリクエスト。

「Invoke-WebRequest : パラメーター 'Headers' をバインドできません。
            "Content-Type: application/json" の値を "System.String" 型から
            "System.Collections.IDictionary" 型に変換できません。」　の巻

https://qiita.com/inbyt/items/dcd00dac7a00aa4d2aa4
引数が異なる？

元のコマンド
-----------
curl http://localhost/auth -X POST \
                           -H "Content-Type: application/json" \
                           -d "{ 'user': 'user1', 'pw': 'abcxyz' }"
変更コマンド
-----------
Invoke-RestMethod -Uri "http://localhost:5000/auth" -Method POST `
                  -Body (@{"user"="user1";"pw"="abcxyz"} | ConvertTo-Json) `
                  -ContentType "application/json"

↓
↓
↓

元
--------
curl -X POST -H "Content-Type: application/json" -d '{"value":"HappyNewYear"}' http://localhost:8080/happy/mxx

変更
--------
Invoke-RestMethod -Uri "http://localhost:8080/happy/mxx" -Method POST `
                  -Body (@{"value":"HappyNewYear"} | ConvertTo-Json) `
                  -ContentType "application/json"

再変更
--------
Invoke-RestMethod -Uri "http://localhost:8080/happy/mxx" -Method POST `
                  -Body (@{"value"="HappyNewYear"} | ConvertTo-Json) `
                  -ContentType "application/json"

------------------ YES!!!!
                   SUCCESS!!!!!

 */

/*
https://stackoverflow.com/questions/31134333/this-application-has-no-explicit-mapping-for-error

Many Spring Boot developers always have their main class annotated with
@Configuration,
@EnableAutoConfiguration
 and @ComponentScan.

Since these annotations are so frequently used together
(especially if you follow the best practices above),
Spring Boot provides a convenient @SpringBootApplication alternative.

The @SpringBootApplication annotation is equivalent to using
@Configuration,
@EnableAutoConfiguration
 and @ComponentScan
 with their default attributes

 --------
 This application has no explicit mapping for /error, so you are seeing this as a fallback.

This is because
it is not scanning your Controller & Service classes
which you have to specify in your main() class
 */