package com.spring.MemoGroovy.serivce;

import com.spring.MemoGroovy.domain.Memo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@Transactional
public class MemoServiceTest {

    private MemoService memoService = new MemoService();

    @Test
    public void search() {
        List<Memo> list = memoService.findSearch("");
        System.out.println(list.get(0).getContent());
    }
}