package kr.co.idealidea.androidtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2018-03-13.
 */

public abstract class BaseActivity extends AppCompatActivity {

    Context mContext = this;

    public abstract void setupEvents(); // 클릭 등의 이벤트 처리 담당
    public abstract void setValues(); // 상황에 따른 데이터를 표시 용도 (내 정보. => 조경진에 대한 정보)
    public abstract void bindViews(); // findViewByID를 치워두는 용도

    public void setCustomActionBar() {
//        기능을 모두 정의해서 물려줌.
    }


//   추상화

//    1. 클래스
//      => 객체화 되는것을 방지.
//         abstrcat class Animal

//    2. 메쏘드
//        => 상속받은 자식 클래스가 반드시 구현해야함. (의무 부여) -> 빼먹으면 안되는것들.
}














