package com.example.sparta.week03.controller;

import com.example.sparta.week03.domain.Memo;
import com.example.sparta.week03.domain.MemoRepository;
import com.example.sparta.week03.domain.MemoRequestDto;
import com.example.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;

    private final MemoService memoService;

    @PostMapping("/api/memos/new")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }
    @PostMapping("/api/memos/{id}")
    public Boolean dataPassword(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){

        return memoService.data(id, requestDto);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByCreatedAtDesc();
    }

    @DeleteMapping("/api/memos/{id}")
    public List<Memo> deleteMemo(@PathVariable Long id) {
        memoService.deleteById(id);
        return memoRepository.findAll();
    }


    @PutMapping("/api/memos/{id}")
    public Memo updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.update(id, requestDto);

    }
}