package TestServlet.service;

import TestServlet.dao.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentManager {
    public void addComment(String customerName, String message){
        Date date = new Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);

        CommentEntity commentEntity = new CommentEntity();
        Customers customers = new Customers();
        commentEntity.setCommentDate(currentTime);
        commentEntity.setCommentLine(message);
        commentEntity.setIDCustomer(customers.getMap().get(customerName));
        try {
            CommentDAO.addComment(commentEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getCommentsList(String customerID, int indicator){
        Customers customers = new Customers();

        List<CommentEntity> commentslist = (List<CommentEntity>) CommentDAO.getCommentsList(customers.getMap().get(customerID));
        JSONObject jsonObject = new JSONObject();
        if(indicator == 1){

                JSONArray jsonArray = new JSONArray();
                jsonArray.add(commentslist.get(commentslist.size()-1).getCommentLine());
                jsonArray.add(commentslist.get(commentslist.size()-1).getCommentDate());
            System.out.println(commentslist.get(commentslist.size()-1).getCommentLine());
            System.out.println(commentslist.get(commentslist.size()-1).getCommentDate());
                jsonObject.put("0", jsonArray);

            return jsonObject;
        }
        else if(indicator ==2){
             jsonObject = new JSONObject();
            for (int i = 0; i < commentslist.size(); i++) {
                JSONArray jsonArray = new JSONArray();
                jsonArray.add(commentslist.get(i).getCommentLine());
                jsonArray.add(commentslist.get(i).getCommentDate());
                jsonObject.put(i, jsonArray);
            }
            return jsonObject;
        }
        return null;
    }
}
