package com.example.business.area.mapper;

import com.example.business.area.dto.request.QueryOrderRequest;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
public class SqlProvideOrder {

    public String queryOrder(QueryOrderRequest request){
        String sql =" select * from order" +
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
        if(request.getRole()==1){
            sql+=" and order.user_id = '"+request.getUser_id()+"' ";
        }
        return sql;
    }
}
