package com.board.service;

import com.board.model.Board;
import com.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public List<Board> list() throws Exception{

        List<Board> boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        return boardList;
    }

    @Override
    public Long write(Board board) throws Exception {
        Board write = boardRepository.save(board);
        return write.getId();
    }

    @Override
    public Board detail(Long id) throws Exception{
        Optional<Board> board = boardRepository.findById(id);
        return board.get();
    }


    @Override
    public Board delete(Long id) throws Exception {
        Board board = boardRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
        boardRepository.delete(board);
        return board;
    }

}
