package com.muc.mapper;

import com.muc.pojo.Audience;
import com.muc.pojo.MuseumTicket;
import com.muc.pojo.MuseumTicketInformation;
import com.muc.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Mapper
public interface BookTicketMapper {
    @Select("select Ttype as type ,Tprice as price from ticket where Hno=(select Hno from house where hname=\"大门票\") and Tseason=#{season};")
    List<MuseumTicket> selectTicketType(String season);

    @Select("select Lleft as ticketRemain from lefttickets where Ldate=#{visitDate} and Ltime=#{visitTime} and Hno=(select Hno from house where hname=\"大门票\");")
    Integer selectTicketRemain(String visitTime, LocalDate visitDate);

    @Select("select Vno as audience_no from visitor where vidnum = #{id,jdbcType=VARCHAR};")
    String selectVisitorById(String id);


    void insertAudience(Audience audience);

    String selectTicketNo(MuseumTicket museumTicket1);

    void insertOrder(Order order);

    String selectOrderId(Order order);

    void insertBookTicket(String orderId, String audienceNo1, String museumTicketNo1);

    void updateStateAndPayment(String orderId);



    List<MuseumTicket> selectOtherTicketInfoByTime(String visitTime, LocalDate visitDate, String season,String type);

    Audience getOrderedAudience(String id, String visitDate);
}
