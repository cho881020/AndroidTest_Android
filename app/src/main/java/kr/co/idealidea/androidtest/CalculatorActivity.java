package kr.co.idealidea.androidtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends BaseActivity {

    private android.widget.TextView resultTxt;
    private android.widget.Button btn01;
    private android.widget.Button btn02;
    private android.widget.Button btn03;
    private android.widget.Button btnPlus;

    String operator = ""; // 계산해야하는 연산자 저장. + - * /
    boolean needToReset = true; // true면 처음부터 숫자 입력, false면 뒤에 이어붙이기.
    int calculNum = 0; // 같이 계산되어야 하는 값을 저장.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        bindViews();
        setupEvents();
        setValues();


    }

    @Override
    public void setupEvents() {

        View.OnClickListener numberEvent = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                숫자 버튼 (0~9) 이 눌리면 발생되어야 하는 일

                Button b = (Button) view;

//                누른 버튼의 숫자를 추출

                int inputVal = Integer.parseInt(b.getText().toString());  // "3"  => 3


                int currentVal = Integer.parseInt(resultTxt.getText().toString()); // "123" => 123

                int result; // 화면에 출력될 숫자.

                // 계산 해야하는 숫자가 0. => 아직 +를 누르지 않은 상태.
                if (needToReset) {
                    // 기존의 입력을 무시하고 새로 숫자를 찍어야하는 상황.
                    result = inputVal; // 입력한 버튼의 숫자로 갈아엎음.

                    needToReset = false; // 처음 숫자 뒤로는 다시 이어붙임.
                }
                else {
                    result = currentVal  * 10 + inputVal; // false일때는 이어붙이는 동작 실행
                }

                resultTxt.setText(String.valueOf(result));



            }
        };

        btn01.setOnClickListener(numberEvent);
        btn02.setOnClickListener(numberEvent);
        btn03.setOnClickListener(numberEvent);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                operator = "+"; // 이번 연산이 +임을 기록.

                needToReset = true; // + 버튼 이후의 숫자는 기존 값을 날려야한다.

                int result = calculNum + Integer.parseInt(resultTxt.getText().toString()); // 현재 타이핑 된 값 + 기존에 저장한값 => 화면 출력.

                resultTxt.setText(String.valueOf(result));

                calculNum = Integer.parseInt(resultTxt.getText().toString());




            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        this.btnPlus = (Button) findViewById(R.id.btnPlus);
        this.btn03 = (Button) findViewById(R.id.btn03);
        this.btn02 = (Button) findViewById(R.id.btn02);
        this.btn01 = (Button) findViewById(R.id.btn01);
        this.resultTxt = (TextView) findViewById(R.id.resultTxt);
    }
}
