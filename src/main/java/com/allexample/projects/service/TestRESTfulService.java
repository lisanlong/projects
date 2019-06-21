package com.allexample.projects.service;

import com.allexample.projects.model.TestRESTful;

import java.util.List;

public interface TestRESTfulService {
    List<TestRESTful> findAll();

    TestRESTful save(TestRESTful message);

    TestRESTful update(TestRESTful message);

    TestRESTful updateText(TestRESTful message);

    TestRESTful findMessage(Long id);

    void deleteMessage(Long id);


}
