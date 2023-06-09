package library;

import java.util.InputMismatchException;
import java.util.Scanner;

import library.Main.Library;

public class Book {
	   private Scanner sc;
       private BookSign bookSign;
       
       public Book(Scanner sc,  BookSign bookSign) {
               this.sc 		 = sc;
               this.bookSign = bookSign;
       }

       public void showbookViewer() {

           while(true)
           {
               try
               {
                   System.out.println("1. 도서등록");
                   System.out.println("2. 도서정보수정");
                   System.out.println("3. 도서검색");
                   System.out.println("4. 도서전체조회");
                   System.out.println("5. 도서삭제");
                   System.out.println("6. 이전메뉴");


                   switch (sc.nextInt()) {
                       case 1:
                           bookSign.BookSignUp();
                           break;
                       case 2:
                           if (bookSign.getBookNumList().size() > 0) {
                               new CorrectBook(sc, bookSign.getBookNumList(), bookSign.getBookNameList(), bookSign.getRantList()).CorrectBook();
                           } else {
                               System.out.println("등록된 도서 정보가 없습니다.");
                           }
                           break;
                       case 3:
                           if (bookSign.getBookNumList().size() > 0) {
                               new PointbookSearch(sc, bookSign.getBookNumList(), bookSign.getBookNameList(), bookSign.getRantList()).pointbookSearch();
                           } else {
                               System.out.println("등록된 도서 정보가 없습니다.");
                           }
                           break;
                       case 4:
                           if (bookSign.getBookNumList().size() > 0) {
                               new SearchBook(bookSign.getBookNumList(), bookSign.getBookNameList(), bookSign.getRantList()).bookSearch();
                           } else {
                               System.out.println("등록된 도서 정보가 없습니다.");
                           }
                           break;
                       case 5:
                           if (bookSign.getBookNumList().size() > 0) {
                               new BookWithdrawal(sc, bookSign.getBookNumList(), bookSign.getBookNameList(),bookSign.getRantList()).BookWithdrawal();
                           } else {
                               System.out.println("등록된 도서 정보가 없습니다.");
                           }
                           break;
                       case 6:
                           sc.nextLine();
                           Library.returnToMain();
                           break;
                       default:
                           System.out.println("잘못된 입력입니다.");
                           break;
                   }
               }
               catch(InputMismatchException e)
               {
                   System.out.println("숫자만 입력하십시오.");
                   sc.nextLine();
               }
           }
       }
}
