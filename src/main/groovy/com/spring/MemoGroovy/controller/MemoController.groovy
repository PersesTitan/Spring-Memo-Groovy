package com.spring.MemoGroovy.controller

import com.spring.MemoGroovy.domain.Memo
import com.spring.MemoGroovy.domain.MemoDTO
import com.spring.MemoGroovy.serivce.MemoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.Banner.Mode
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes

import javax.servlet.http.HttpServletRequest

@Controller
class MemoController {

    @Autowired
    private MemoService memoService

    @GetMapping("/memos")
    String memoList(Model model, HttpServletRequest httpServletRequest) {
        String search = httpServletRequest.getParameter "search"
        List<Memo> memos = memoService.findSearch search
        model.addAttribute "searchParam", !(search == null || search.isBlank())
        model.addAttribute "search", search
        model.addAttribute "memos", memos
        return "/memo_list"
    }

    @GetMapping("/memo")
    String createFrom() {
        return "/new_memo"
    }

    @PostMapping("/memo")
    String createMemo(Memo memo, RedirectAttributes redirectAttributes) {
        Long id = memoService.save memo
        redirectAttributes.addAttribute "id", id
        redirectAttributes.addAttribute "create", true
        return "redirect:/memo/{id}"
    }

    @GetMapping("/memo/{id}")
    String memo(@PathVariable Long id, Model model) {
        Memo memo = memoService.findOne id
        model.addAttribute "id", id
        model.addAttribute "memo", memo
        return "item/memo"
    }

    @GetMapping("/memo/{id}/edit")
    String editFrom(@PathVariable Long id, Model model) {
        Memo memo = memoService.findOne id
        model.addAttribute "id", id
        model.addAttribute "memo", memo
        return "edit_memo"
    }

    @PostMapping("/memo/{id}/edit")
    String edit(@PathVariable Long id, MemoDTO memoDTO) {
        memoService.update id, memoDTO.title, memoDTO.content
        return "redirect:/memo/{id}"
    }

    @PostMapping("/memo/{id}/remove")
    String remove(@PathVariable Long id) {
        memoService.remove id
        return "redirect:/memos"
    }
}
