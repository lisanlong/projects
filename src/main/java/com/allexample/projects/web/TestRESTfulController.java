package com.allexample.projects.web;

import com.allexample.projects.model.TestRESTful;
import com.allexample.projects.service.TestRESTfulService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*RESTful 是一种非常优雅的设计，相同 URL 请求方式不同后端处理逻辑不同，利用 RESTful 风格很容易设计出更优雅和直观的 API 交互接口。
        同时 Spring Boot 对 RESTful 的支持也做了大量的优化，方便在 Spring Boot 体系内使用 RESTful 架构。*/

@Api(value = "TestRESTfulController", description = "消息操作 API", position = 100, protocols = "http")
@RestController
@RequestMapping("/")
public class TestRESTfulController {
    @Autowired
    private TestRESTfulService testRESTfulService;

    // 获取所有消息体
    @GetMapping(value = "messages")
    public List<TestRESTful> list() {
        List<TestRESTful> messages = this.testRESTfulService.findAll();
        return messages;
    }

    // 创建一个消息体
    @PostMapping(value = "message")
    public TestRESTful create(TestRESTful message) {
        message = this.testRESTfulService.save(message);
        return message;
    }

    // 使用 put 请求进行修改
    @PutMapping(value = "message")
    public TestRESTful modify(TestRESTful message) {
        TestRESTful messageResult=this.testRESTfulService.update(message);
        return messageResult;
    }

    // 更新消息的 text 字段
    @PatchMapping(value="/message/text")
    public TestRESTful patch(TestRESTful message) {
        TestRESTful messageResult=this.testRESTfulService.updateText(message);
        return messageResult;
    }

    @GetMapping(value = "message/{id}")
    public TestRESTful get(@PathVariable Long id) {
        TestRESTful message = this.testRESTfulService.findMessage(id);
        return message;
    }

    @DeleteMapping(value = "message/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.testRESTfulService.deleteMessage(id);
    }



}
