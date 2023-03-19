package library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
static class Library{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> booknumList  = new ArrayList<>();
		ArrayList<String> booknameList = new ArrayList<>();
		ArrayList<Boolean> rantList     = new ArrayList<>();
        ArrayList<String> numList      = new ArrayList<>();
        ArrayList<String> nameList     = new ArrayList<>();
        MemberSign memberSign = new MemberSign(sc, numList, nameList);
        Member member = new Member(sc, memberSign);
        BookSign bookSign = new BookSign(sc, booknumList, booknameList, rantList);
        Book book = new Book(sc, bookSign);


        Main.Library.loadFromFile(booknumList,booknameList,rantList);
        Main.Library.loadFromFile2(numList,nameList);
        while (true) {
            try
            {
                MenuInfo.showMenuInfo();
                switch (sc.nextInt()) {

                    case 1:
                        book.showbookViewer();
                        break;
                    case 2:
                        member.showMemberViewer();
                        break;
                    case 3:
                        sc.nextLine();
                        saveToFile(booknumList, booknameList, rantList);
                        saveToFile2(numList, nameList);
                        System.exit(0);
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("숫자만 입력하십시오.");
                sc.nextLine();
            }

        }
    }

    public static void saveToFile(ArrayList<String> booknumList, ArrayList<String> booknameList, ArrayList<Boolean> rantList) {
        try {
            FileWriter fileWriter = new FileWriter("library Book.txt");
            for(int i = 0; i < booknumList.size(); i++) {
                fileWriter.write(booknumList.get(i) + "," + booknameList.get(i) + "," + rantList.get(i) + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다.");
        }
    }

    public static void saveToFile2(ArrayList<String> numList, ArrayList<String> nameList) {
        try {
            FileWriter fileWriter = new FileWriter("library Member.txt");
            for(int i = 0; i < numList.size(); i++) {
                fileWriter.write(numList.get(i) + "," + nameList.get(i) + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다.");
        }
    }

    public static void loadFromFile(ArrayList<String> booknumList, ArrayList<String> booknameList, ArrayList<Boolean> rantList) {
        try {
            FileReader fileReader = new FileReader("library Book.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                booknumList.add(arr[0]);
                booknameList.add(arr[1]);
                rantList.add(Boolean.parseBoolean(arr[2]));
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("파일 로드 중 오류가 발생했습니다.");
        }
    }

    public static void loadFromFile2(ArrayList<String>numList, ArrayList<String> nameList) {
        try {
            FileReader fileReader = new FileReader("library Member.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                numList.add(arr[0]);
                nameList.add(arr[1]);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("파일 로드 중 오류가 발생했습니다.");
        }
    }

    public static void returnToMain() {
        main(null);
    }
}}