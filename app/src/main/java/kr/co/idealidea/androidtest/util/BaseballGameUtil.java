package kr.co.idealidea.androidtest.util;

import android.util.Log;

/**
 * Created by Administrator on 2018-02-25.
 */

public class BaseballGameUtil {

//    문제로 사용 될 배열.
    static int[] questionNumArray = {4,7,1};

//    1. 문제 출제

    public static void makeQuestion() {

//        문제를 내는 방법? 룰.=> 3자리. 100 ~ 999 Ex. 12 버림
//        문제는 매번 랜덤으로 생성되어야. Math.random => 0 <= x < 1 사이의 소수를 랜덤으로 방출.
//        응용. 0~0.999999 사이의 값 => 100~999 => 0 (+100)~899 (+100)
//         0~1 값을 0~899 => * 900  0 ~ 900

        while (true) {
            int questionNum = (int) (Math.random() * 900) + 100; // 100~999 소수점 버림 저장.

            questionNumArray[0] = questionNum / 100;
            questionNumArray[1] = questionNum / 10 % 10;
            questionNumArray[2] = questionNum % 10;

//       문제의 조건. 숫자는 중복을 허용하지 않는다. [4,7,1]
//        => 0은 아예 금지. 408
//        => 만약 중복이 있다면 다시 문제를 내라. => 중복이 없을때까지 계속 문제를 내라.


            Log.d("출제된값", questionNum+"");

//            중복이 아니라면 => OK! 문제 그만내도 됨. => 반복문 탈출 => break;
            if (!(questionNumArray[0] == questionNumArray[1] || questionNumArray[1] == questionNumArray[2] || questionNumArray[0] == questionNumArray[2])) {

                if (questionNumArray[0] != 0 && questionNumArray[1] != 0 && questionNumArray[2] != 0) {
                    break;
                }


            }
        }




    }

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










