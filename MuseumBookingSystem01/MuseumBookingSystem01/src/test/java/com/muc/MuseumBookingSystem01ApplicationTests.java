package com.muc;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.fasterxml.jackson.core.type.TypeReference;


@SpringBootTest
class MuseumBookingSystem01ApplicationTests {
//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    static class Order {
//        private LocalDateTime orderTime;
//        private LocalDateTime visitTime;
//        private List<Audience> audiences;
//        private List<Ticket> tickets;
//
//        // getters and setters
//    }
//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    static class Audience {
//        private String name;
//        private String id;
//
//        // getters and setters
//    }
//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    static class Ticket {
//        private String name;
//        private String id;
//
//        // getters and setters
//    }
//
//
//    @Test
//    void contextLoads() {
//    }
//    @Test
//    void jsonToMap(){
//
//        String jsonString = "{\"order\":{\"orderTime\":\"2023-01-01T12:00:00\",\"visitTime\":\"2023-01-10T14:30:00\",\"audiences\":[{\"name\":\"John\",\"id\":\"A001\"},{\"name\":\"Jane\",\"id\":\"A002\"}],\"tickets\":[{\"name\":\"VIP Ticket\",\"id\":\"T001\"},{\"name\":\"Standard Ticket\",\"id\":\"T002\"}]}";
//
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            Map<Order, Map<Audience, List<Ticket>>> nestedMap = objectMapper.readValue(jsonString, new TypeReference<Map<Order, Map<Audience, List<Ticket>>>>() {});
//
//            // 添加你的测试逻辑，这里只是简单的断言
////            assertEquals(1, nestedMap.size());
//
//            // 打印嵌套Map内容
//            nestedMap.forEach((order, audienceTicketMap) -> {
//                System.out.println("Order Time: " + order.getOrderTime());
//                System.out.println("Visit Time: " + order.getVisitTime());
//
//                audienceTicketMap.forEach((audience, tickets) -> {
//                    System.out.println("\tAudience Name: " + audience.getName() + ", Audience ID: " + audience.getId());
//
//                    tickets.forEach(ticket -> {
//                        System.out.println("\t\tTicket Name: " + ticket.getName() + ", Ticket ID: " + ticket.getId());
//                    });
//                });
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    @Test
    void Datetime(){
        LocalDateTime localDateTime=LocalDateTime.now();
        String time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        time = localDateTime.format(formatter);
        System.out.println(time);
    }

}
