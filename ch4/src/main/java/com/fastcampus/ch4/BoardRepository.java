package com.fastcampus.ch4;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    //SELECT COUNT(*) FROM BOARD WHERE WRITER = :writer


}
