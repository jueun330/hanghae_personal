package com.example.sparta.week03;

import com.example.sparta.week03.domain.Memo;
import com.example.sparta.week03.domain.MemoRepository;
import com.example.sparta.week03.domain.MemoRequestDto;
import com.example.sparta.week03.service.MemoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Week03Application {

	public static void main(String[] args) {
		SpringApplication.run(Week03Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(MemoRepository memoRepository, MemoService memoService) {
		return (args) -> {
			memoRepository.save(new Memo("첫번째제목", "김주은",0,""));
			memoRepository.save(new Memo("두번째제목", "나주은",0,""));
			List<Memo> memoList = memoRepository.findAll();
			for (int i = 0; i < memoList.size(); i++) {
				Memo memo = memoList.get(i);
				System.out.println(memo.getId());
				System.out.println(memo.getUsername());
				System.out.println(memo.getTitle());
			}


			/*MemoRequestDto requestDto = new MemoRequestDto("세번째제목", "다주은", 1234, "세번째내용");

			memoService.update(1L, requestDto);
			List<Memo> memoList = memoRepository.findAll();
			for (int i = 0; i < memoList.size(); i++) {
				Memo memo = memoList.get(i);
				System.out.println(memo.getId());
				System.out.println(memo.getUsername());
				System.out.println(memo.getTitle());
			}
			MemoRequestDto requestDto2 = new MemoRequestDto("네번째제목", "라주은", 123, "네번째내용");
			memoService.update(2L, requestDto2);
			memoList = memoRepository.findAll();
			for (int i = 0; i < memoList.size(); i++) {
				Memo memo = memoList.get(i);
				System.out.println(memo.getId());
				System.out.println(memo.getUsername());
				System.out.println(memo.getTitle());
			}
			//memoRepository.deleteAll();*/
		};
	}
}
