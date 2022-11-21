package com.board;

import com.board.model.Board;
import com.board.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.stream.IntStream;

@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}


	//데이터 자동 생성
//	@Bean
//	public CommandLineRunner initData(BoardRepository boardRepository){
//		return args ->
//				IntStream.rangeClosed(1, 100).forEach(i -> {
//					Board board = Board.builder()
//							.title("test" + i)
//							.content("content" + i)
//							.name(("yang"))
//							.build();
//
//					boardRepository.save(board);
//				});
//	}

}
