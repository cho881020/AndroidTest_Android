package kr.co.idealidea.androidtest.util;

/**
 * Created by Administrator on 2018-02-25.
 */

public class BaseballGameUtil {

//    문제로 사용 될 배열.
    static int[] questionNumArray = {4,7,1};

//    1. 문제 출제

//    2. 정답 입력 => ?S ?B 채점

//    String 인풋 => 숫자를 입력: EditText를 통해 입력받으므로.
    public static int[] checkStrikeAndBall(String inputVal) {
//        채점 2S 1B
        int[] result = new int[2]; // 0번칸은 S, 1번칸은 B


//        1) 입력 들어온 String을 int로 변경.
//          => Wrapper 클래스.

//        String "123" => int 123
        int inputNum = Integer.parseInt(inputVal);


//         2) 123 => 1,2,3 분리. 하나의int를 int[]로 바꿀것이다.
        int[] numArray = new int[3];

//        3) 0번칸 : 100의자리, 1번칸 : 10의 자리, 2번칸: 1의자리.
//          => 123 => [1],[2],[3]
//        100의자리? => /100

        numArray[0] = inputNum / 100; // [4]23 / 100 ? 몫이몇인가.
        numArray[1] = inputNum / 10 % 10; // 4[2]3
        numArray[2] = inputNum % 10; // 42[3] % 10 => 몫 : 42, 나머지 : 3


//      문제(questionNumArray)와 입력값(numArray)을 비교.

//        strike의 갯수와 ball의 갯수를 기록할 변수.
        int strikeCount = 0;
        int ballCount = 0;

//        겉에 있을수록 더 늦게 도는 for문. 입력값 : i
        for (int i=0 ; i < 3 ; i++) {
//            빨리 도는 for문 : 문제 검사 : j
            for (int j=0 ; j < 3 ; j++) {

                if (questionNumArray[j] == numArray[i]) {

                    if (j == i) {
                        strikeCount++;
                    }
                    else {
                        ballCount++;
                    }

                }

            }
        }

        result[0] = strikeCount;
        result[1] = ballCount;


        return result;
    }

}










