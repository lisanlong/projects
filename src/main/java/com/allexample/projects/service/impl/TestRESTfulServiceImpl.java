package com.allexample.projects.service.impl;

import com.allexample.projects.model.TestRESTful;
import com.allexample.projects.service.TestRESTfulService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Service("TestRESTfulService")
public class TestRESTfulServiceImpl implements TestRESTfulService {
    /*我们使用 ConcurrentHashMap 来模拟存储 Message 对象的增删改查，AtomicLong 做为消息的自增组建来使用。ConcurrentHashMap
    是 Java 中高性能并发的 Map 接口，AtomicLong 作用是对长整形进行原子操作，可以在高并场景下获取到唯一的 Long 值。*/
    private static AtomicLong counter = new AtomicLong();
    private final ConcurrentMap<Long, TestRESTful> messages = new ConcurrentHashMap<>();

    @Override
    public List<TestRESTful> findAll() {
        List<TestRESTful> messages = new ArrayList<TestRESTful>(this.messages.values());
        return messages;
    }

    @Override
    public TestRESTful save(TestRESTful message) {
        Long id = message.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            message.setId(id);
        }
        this.messages.put(id, message);
        return message;
    }

    @Override
    public TestRESTful update(TestRESTful message) {
        this.messages.put(message.getId(), message);
        return message;
    }

    @Override
    public TestRESTful updateText(TestRESTful message) {
        TestRESTful msg=this.messages.get(message.getId());
        msg.setText(message.getText());
        this.messages.put(msg.getId(), msg);
        return msg;
    }

    @Override
    public TestRESTful findMessage(Long id) {
        return this.messages.get(id);
    }

    @Override
    public void deleteMessage(Long id) {
        this.messages.remove(id);
    }
}
