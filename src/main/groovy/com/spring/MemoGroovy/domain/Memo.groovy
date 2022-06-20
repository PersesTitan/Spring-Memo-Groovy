package com.spring.MemoGroovy.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
class Memo {

    @Id @GeneratedValue
    @Column(name = "memo_id")
    private Long id

    private String title
    private String content

    private final LocalDateTime createDate = LocalDateTime.now()

    protected Memo() {}

    private Memo(String title, String content) {
        this.title = title
        this.content = content
    }

    static Memo createMemo(String title, String content) {
        return new Memo(title, content)
    }

    void setTitle(String title) {
        this.title = title
    }

    void setContent(String content) {
        this.content = content
    }

    Long getId() {
        return id
    }

    String getTitle() {
        return title
    }

    String getContent() {
        return content
    }

    LocalDateTime getCreateDate() {
        return createDate
    }
}
