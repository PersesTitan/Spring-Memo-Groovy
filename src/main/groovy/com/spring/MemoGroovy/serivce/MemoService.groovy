package com.spring.MemoGroovy.serivce

import ch.qos.logback.core.net.AutoFlushingObjectWriter
import com.spring.MemoGroovy.domain.Memo
import com.spring.MemoGroovy.repository.MemoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemoService {

    @Autowired
    private MemoRepository memoRepository

    @Transactional
    def save(Memo memo) {
        memoRepository.save memo
        return memo.getId()
    }

    @Transactional
    def remove(Long id) {
        Memo memo = memoRepository.findOne id
        memoRepository.remove memo
    }

    @Transactional
    def update(Long id, String title, String content) {
        Memo memo = memoRepository.findOne id
        memoRepository.update memo, title, content
    }

    Memo findOne(Long id) {
        return memoRepository.findOne(id)
    }

    List<Memo> findAll() {
        return memoRepository.findAll()
    }

    List<Memo> findSearch(String keyWord) {
        if (keyWord == null || keyWord.isEmpty()) return memoRepository.findAll()
        else return memoRepository.findSearch(keyWord)
    }
}
