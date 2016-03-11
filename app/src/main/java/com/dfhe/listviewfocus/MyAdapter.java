package com.dfhe.listviewfocus;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * 项目名称：ListViewFocus
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2016/3/11 15:10
 * 修改人：Administrator
 * 修改时间：2016/3/11 15:10
 * 修改备注：
 *
 * @param
 */
public class MyAdapter extends BaseAdapter {

    int mCurrentPos;
    ArrayList<String> list;
    Context mContext;

    public MyAdapter(ArrayList<String> list,Context context) {
        this.list = list;
        this.mContext = context;
    }

    public void setCurrentPosition(int position){
        this.mCurrentPos = position;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.VERTICAL);

        //说明点击的是当前的位置,设置为获取焦点
        if(mCurrentPos == position){
            layout.addView(addFocusView());
        }else{
            layout.addView(addNormalView(position));
        }
        layout.setGravity(Gravity.CENTER);

        return layout;
    }


    /**
     * 获取焦点的位置
     */
    public View addFocusView(){
        ImageView iv = new ImageView(mContext);
        iv.setLayoutParams(new LinearLayout.LayoutParams(150,150));
        iv.setImageResource(R.drawable.focus);
        return iv;
    }


    /**
     * 正常情况下listView的内容显示
     */
    public View addNormalView(int position){
        LinearLayout layout  = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        ImageView iv = new ImageView(mContext);
        iv.setImageResource(R.drawable.nomal);
        layout.addView(iv, new LinearLayout.LayoutParams(150,150));
        TextView tv  = new TextView(mContext);
        tv.setText(list.get(position));
        tv.setTextSize(30);
        layout.addView(tv,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.setGravity(Gravity.CENTER);
        return layout;
    }
}
