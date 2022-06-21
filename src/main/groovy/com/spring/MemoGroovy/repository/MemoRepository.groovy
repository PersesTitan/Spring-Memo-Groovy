package com.spring.MemoGroovy.repository

import com.spring.MemoGroovy.domain.Memo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import javax.persistence.EntityManager

@Repository
class MemoRepository {

    @Autowired
    private EntityManager entityManager

    def save(Memo memo) {
        entityManager.persist memo
    }

    def remove(Memo memo) {
        entityManager.remove memo
    }

    def update(Memo memo, String title, String content) {
        memo.setTitle title
        memo.setContent content
    }

    def findOne(Long id) {
        return entityManager.find(Memo.class, id)
    }

    def findAll() {
        return entityManager.createQuery("SELECT M FROM Memo AS M", Memo.class)
                .getResultList()
    }

    def findSearch(String keyWord) {
        return entityManager.createQuery("SELECT M FROM Memo AS M WHERE M.title LIKE :keyWord")
                .setParameter("keyWord", "%${keyWord}%")
                .getResultList()
    }
}
