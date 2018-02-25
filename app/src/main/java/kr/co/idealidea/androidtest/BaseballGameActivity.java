package kr.co.idealidea.androidtest;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import kr.co.idealidea.androidtest.adapter.ChatAdapter;
import kr.co.idealidea.androidtest.data.Chat;
import kr.co.idealidea.androidtest.util.BaseballGameUtil;

public class BaseballGameActivity extends BaseActivity {

//    화면에 들어오면 onCreate 자동으로 문제를 생성.
//    버튼을 누르면 ?s ?b


    private android.widget.ListView chatListView;
    private android.widget.EditText numberInputEdt;
    private android.widget.Button sendBtn;


    List<Chat> chatList = new ArrayList<>();
    ChatAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball_game);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Chat tempChat = new Chat(true, numberInputEdt.getText().toString());
                chatList.add(tempChat);

                mAdapter.notifyDataSetChanged();




                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        int[] strikeAndBall = BaseballGameUtil.checkStrikeAndBall(numberInputEdt.getText().toString());

                        String resultStr = String.format(Locale.KOREA, "%dS %dB 입니다.", strikeAndBall[0], strikeAndBall[1]);

                        Chat comChat = new Chat(false, resultStr);
                        chatList.add(comChat);
                        mAdapter.notifyDataSetChanged();
                    }
                }, 1000);


//                Toast.makeText(mContext, strikeAndBall[0]+"S " + strikeAndBall[1] + "B 입니다.", Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public void setValues() {
        BaseballGameUtil.makeQuestion();

        mAdapter = new ChatAdapter(mContext, chatList);
        chatListView.setAdapter(mAdapter);

    }

    @Override
    public void bindViews() {
        this.sendBtn = (Button) findViewById(R.id.sendBtn);
        this.numberInputEdt = (EditText) findViewById(R.id.numberInputEdt);
        this.chatListView = (ListView) findViewById(R.id.chatListView);

    }
}
