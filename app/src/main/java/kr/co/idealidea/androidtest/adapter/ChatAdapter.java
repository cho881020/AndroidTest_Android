package kr.co.idealidea.androidtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import kr.co.idealidea.androidtest.R;
import kr.co.idealidea.androidtest.data.Chat;

/**
 * Created by Administrator on 2018-02-25.
 */

public class ChatAdapter extends ArrayAdapter<Chat> {

    Context mContext;
    List<Chat> mList;
    LayoutInflater inf;

    public ChatAdapter(Context context, List<Chat> list) {
        super(context, R.layout.chat_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            row = inf.inflate(R.layout.chat_list_item, null);
        }

        Chat data = mList.get(position);

        LinearLayout myMessageLayout = row.findViewById(R.id.myMessageLayout);
        LinearLayout comMessageLayout = row.findViewById(R.id.comMessageLayout);
        TextView myContentTxt = row.findViewById(R.id.myContentTxt);
        TextView comContentTxt = row.findViewById(R.id.comContentTxt);

        if (data.isMyMessage()) {

            myMessageLayout.setVisibility(View.VISIBLE);
            comMessageLayout.setVisibility(View.GONE);

            myContentTxt.setText(data.getContent());
        }
        else {
            myMessageLayout.setVisibility(View.GONE);
            comMessageLayout.setVisibility(View.VISIBLE);

            comContentTxt.setText(data.getContent());
        }


        return row;
    }
}












