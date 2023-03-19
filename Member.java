package library;

import java.util.InputMismatchException;
import java.util.Scanner;

import library.Main.Library;

public class Member {
	 private Scanner sc;
     private MemberSign memberSign;

     public Member(Scanner sc, MemberSign memberSign) {
             this.sc 		 = sc;
             this.memberSign = memberSign;
     }

     public void showMemberViewer() {
             System.out.println("1. 회원등록");
             System.out.println("2. 정보수정");
             System.out.println("3. 회원검색");
             System.out.println("4. 전체조회");
             System.out.println("5. 회원탈퇴");
             System.out.println("6. 이전메뉴");

             while(true)
             {
                     try
                     {
                             switch (sc.nextInt()) {
                                     case 1:
                                             memberSign.memberSignUp();
                                             break;
                                     case 2:
                                             if (memberSign.getNumList().size() > 0) {
                                                     new CorrectMember(sc, memberSign.getNumList(), memberSign.getNameList()).correctMember();
                                             } else {
                                                     System.out.println("등록된 회원 정보가 없습니다.");
                                             }
                                             break;
                                     case 3:
                                             if (memberSign.getNumList().size() > 0) {
                                                     new PointSearch(sc, memberSign.getNumList(), memberSign.getNameList()).pointSearch();
                                             } else {
                                                     System.out.println("등록된 회원 정보가 없습니다.");
                                             }
                                             break;
                                     case 4:
                                             if (memberSign.getNumList().size() > 0) {
                                                     new SearchMember(memberSign.getNumList(), memberSign.getNameList()).memberSearch();
                                             } else {
                                                     System.out.println("등록된 회원 정보가 없습니다.");
                                             }
                                             break;
                                     case 5:
                                             if (memberSign.getNumList().size() > 0) {
                                                     new MemberWithdrawal(sc, memberSign.getNumList(), memberSign.getNameList()).memberWithdrawal();
                                             } else {
                                                     System.out.println("등록된 회원 정보가 없습니다.");
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

