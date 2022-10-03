package com.example.sparta.week03.service;

import com.example.sparta.week03.domain.Memo;
import com.example.sparta.week03.domain.MemoRepository;
import com.example.sparta.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Setter
@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    //public MemoService(MemoRepository memoRepository) {this.memoRepository = memoRepository;}
    @Transactional
    public Memo update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo;
    }
    @Transactional
    public void create(String title, String username, Integer password, String contents){
        Memo memo = new Memo();
        memo.setTitle(title);
        memo.setUsername(username);
        memo.setPassword(password);
        memo.setContents(contents);
        this.memoRepository.save(memo);
    }

    @Transactional
    public Boolean data(Long id, MemoRequestDto requestDto){
        Memo memo = memoRepository.findById(id).orElseThrow();
        return memo.data(requestDto);
    }
    @Transactional
    public void deleteById(Long id) {
        memoRepository.deleteById(id);
    }
}