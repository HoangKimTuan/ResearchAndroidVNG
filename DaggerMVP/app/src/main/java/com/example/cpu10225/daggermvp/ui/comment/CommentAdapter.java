package com.example.cpu10225.daggermvp.ui.comment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cpu10225.daggermvp.R;
import com.example.cpu10225.daggermvp.data.db.Comment;

import java.util.List;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public class CommentAdapter extends BaseAdapter {
    private List<Comment> mCommentList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public CommentAdapter(List<Comment> commentList, Context context) {
        this.mCommentList = commentList;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mCommentList.size();
    }

    @Override
    public Object getItem(int i) {
        return mCommentList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.listview_comment, null);
            holder = new ViewHolder();
            holder.tvName = view.findViewById(R.id.tvName);
            holder.tvEmail = view.findViewById(R.id.tvEmail);
            holder.tvBody = view.findViewById(R.id.tvBody);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Comment comment = this.mCommentList.get(i);
        holder.tvName.setText(comment.getName());
        holder.tvEmail.setText(comment.getEmail());
        holder.tvBody.setText(comment.getBody());

        return view;
    }

    static class ViewHolder {
        TextView tvName, tvEmail, tvBody;
    }
}
