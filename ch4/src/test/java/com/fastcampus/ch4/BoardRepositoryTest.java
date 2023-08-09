//package com.fastcampus.ch4;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class BoardRepositoryTest {
//    @Autowired
//    private BoardRepository boardRepo;
//
//    @Test
//    @Order(2)
//    public void selectTest(){
//       // Board board = boardRepo.findById(1L).get(); //값이 없을 때 예외 발생
//        Board board = boardRepo.findById(1L).orElse(null); //값이 없으면 null반환
//        assertTrue(board != null);
//    }
//    @Test
//    @Order(1)
//    public void insertTest(){
//        Board board = new Board();
//        board.setBno(1L);
//        board.setTitle("Test Title");
//        board.setContent("This is Test");
//        board.setWriter("aaa");
//        board.setInDate(new Date());
//        board.setUpDate(new Date());
//
//        boardRepo.save(board);
//    }
//
//    @Test
//    @Order(3)
//    public void updateTest(){
//        Board board = boardRepo.findById(1L).orElse(null);
//        assertTrue(board != null);
//
//        board.setTitle("modified Title");
//        boardRepo.save(board);
//        //못찾으면 새로운 board객체 반환
//        Board board2 = boardRepo.findById(1L).orElse(new Board());
//        System.out.println("board = " + board);
//        System.out.println("board2 = " + board2);
//
//        assertTrue(board.getTitle().equals(board2.getTitle()));
//    }
//
//    @Test
//    public void deleteTest(){
//        boardRepo.deleteById(1L);
//
//        Board board = boardRepo.findById(1L).orElse(null);
//        assertTrue(board == null);
//
//    }
//}