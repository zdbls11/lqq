package com.example.business.area.mapper;

import com.example.business.area.dto.request.QueryOrderRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
public class SqlProvideOrder {

    public String queryOrder(QueryOrderRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql =" select * from `order`" +
                " left join area on area.id = order.area_id " +
                " left join user on user.id = order.user_id " +
                "where 1=1 ";
        if(request.getArea()!=null){
            sql+=" and area.name like '%"+request.getArea()+"%' ";
        }
        if(request.getUser()!=null){
            sql+=" and user.username like '%"+request.getUser()+"%' ";
        }
        if(request.getTime()!=null){
            sql+=" and order.time = '"+request.getTime()+"' ";
        }
        if(request.getDay()!=null){
            sql+=" and order.order_date like '%"+request.getDay()+"%' ";
        }
        if(request.getRole()==1){
            sql+=" and order.user_id = '"+request.getUser_id()+"' ";
        }
        if(!request.getIs_history()){
            sql+=" and `order`.order_date > '"+sdf.format(date)+" 00:00:00' ";
        }else {
            sql+=" and `order`.order_date < '"+sdf.format(date)+" 00:00:00' ";
        }
        sql+= " order by `order`.order_date asc,`order`.time asc";
        return sql;
    }
}
