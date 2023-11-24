/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counter;

import java.util.HashMap; //tao cac lop trong java
//HashMap về cơ bản chỉ định các  key cho các value tương ứng có thể được truy xuất tại bất kỳ điểm nào.
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Counter1 {

    //ham display dung de hien thi ket qua cua cac MAP wordcounter va charcounter
    public void display(Map<Character, Integer> charCounter, Map<String, Integer> wordCounter) {
        System.out.println(wordCounter);
        System.out.println(charCounter);
    }

    //ham analyze dung de phan tich chuoi 

    public Map<Character, Integer> analyze1(String content) {
        Map<Character, Integer> charCounter = new HashMap<Character, Integer>();
        for (char ch : content.toCharArray()) { // vong for dung de duyet qua tat ca cac ky tu trong chuoi //charArray đổi 1 chuỗi thành cách mảng ký tự vào ch
            if (Character.isSpaceChar(ch)) {
                continue;    //neu ky tu do la 1 dau cach thi se bo qua va khong dem ky tu do 
            }
            if (!charCounter.containsKey(ch)) { //containkey tra ve gia tri true hoac false  //kiểm tra xem ký tự "ch" có xuất hiện dưới dạng khóa hashmap "charCounter" hay không. //neu true ki tu  chua duoc dem// 
                charCounter.put(ch, 1); // no se them ky tu char vao charcounter voi gia tri 1
            } else {
                charCounter.put(ch, charCounter.get(ch) + 1);  //neu false lay gia tri hien tai của char trong counter và ép kiểu về số int //neu ki tu da duoc dem truoc do thi no se tang gia tri hien tai them 1
            }
        }
        return charCounter;
    }

    ///hello world
    public Map<String, Integer> analyze2(String content) {
        content = content.replaceAll("[\\W+]", " ");//[\\W+] đại diện cho các kí tự khác chữ cái và số//+ là đại diện cho 1 hay nhiều phần tử//" "sử dụng để thay thế các kí tự không phải chữ và số 
        content = content.toLowerCase();
        Map<String, Integer> wordCounter = new HashMap<String, Integer>(); //để chia một Chuỗi thành các mã hoặc chia một câu thành các từ
        StringTokenizer tokenizer = new StringTokenizer(content, " ");  //tach cac chuoi dau vao, chuỗi string mà đánh dấu bởi dấu cách
        while (tokenizer.hasMoreTokens()) { //Trả về true nếu còn 2 hay nhiều token trong chuỗi.//ham while dung de duyet qua tung tu
            String token = tokenizer.nextToken();
            if (!wordCounter.containsKey(token)) { // neu tu do chua duoc dem truoc do 
                wordCounter.put(token, 1); //thi se them vao wordcounter va dat gia tri la 1
            } else {
                wordCounter.put(token, ( wordCounter.get(token)) + 1); //neu da duoc dem truoc do thi se tang gia tri len 1
            }
        }
        return wordCounter;
    }

    public static void main(String[] args) {
        Counter1 count1 = new Counter1();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String content = scanner.nextLine();
        content = content.replaceAll("[\\W+]", " ");
        System.out.println(content);
        content = content.toLowerCase();

        Map<Character, Integer> charCounter = count1.analyze1(content); // tao hashmap dem ky tu
        Map<String, Integer> wordCounter = count1.analyze2(content);// tao hash map dem tu 
        count1.display(charCounter, wordCounter);
        
    }
}
