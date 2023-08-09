package com.fastcampus.ch4;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTest3 {

    @Autowired
    private BoardRepository boardRepo;
    @Autowired
    public EntityManager em;
    @BeforeEach
    public void testData(){
        for (int i = 1; i <= 100; i++) {
            Board board = new Board();
            board.setBno((long) i);
            board.setTitle("title" + i);
            board.setContent("content" + i);
            //board.setWriter("writer" + (i % 5));
            board.setViewCnt((long) (Math.random() * 100));
            board.setInDate(new Date());
            board.setUpDate(new Date());
            boardRepo.save(board);
        }
    }

//    @Test
//    @DisplayName("@Query로 네이티브SQL사용")
//    public void queryAnnoTest5() {
//
//        List<Object[]> list = boardRepo.findAllBaordBySQL2();
//        list.stream()//list -> stream
//                .map(arr -> Arrays.toString(arr)) // arr -> String
//                .forEach(System.out::println);
//
//        assertTrue(list.size() == 100);
//    }
//    @Test
//    @DisplayName("@Query로 네이티브SQL사용")
//    public void queryAnnoTest4() {
//
//        List<Board> list = boardRepo.findAllBaordBySQL();
//        assertTrue(list.size() == 100);
//    }
//
//
//    @Test
//    @DisplayName("@Query로 JPSQ작성 테스트 - 매개변수 순서")
//    public void queryAnnoTest3() {
//        List<Board> list = boardRepo.findByTitleAndWriter2("title1", "writer1");
//        list.forEach(System.out::println);
//        assertTrue(list.size()==1);
//    }
//
//    @Test
//    @DisplayName("@Query로 JPSQ작성 테스트 - 매개변수 순서")
//    public void queryAnnoTest2() {
//        List<Board> list = boardRepo.findByTitleAndWriter2("title1", "writer1");
//        list.forEach(System.out::println);
//        assertTrue(list.size()==1);
//    }
//    @Test
//    @DisplayName("@Query로 JPSQ작성 테스트")
//    public void queryAnnoTest() {
//        List<Board> list = boardRepo.findAllBoard();
//        assertTrue(list.size()==100);
//    }
//
//
//
//    @Test
//    @DisplayName("createQuery로 SPQL작성 테스트")
//    public void createQueryTest() {
//        String query = "SELECT b FROM Board b";
//        TypedQuery<Board> tQuery = em.createQuery(query, Board.class);
//        List<Board> list = tQuery.getResultList();
//
//        list.forEach(System.out::println);
//        assertTrue(list.size()==100);
//
//
//    }


}