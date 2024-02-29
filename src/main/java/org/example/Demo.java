package org.example;


import org.example.request.Address;
import org.example.request.Company;
import org.example.request.Geo;
import org.example.request.UserRequestDto;


public class Demo {

    public static void main(String[] args) {
//        UserRequestDto newUser = UserRequestDto.builder()
//                .name("Andriy")
//                .username("Andry")
//                .email("Andry@gmail.com")
//                .phone("555-666-77")
//                .website("www.andry.com")
//                .company(Company.builder()
//                        .name("Company")
//                        .catchPhrase("Don't do it")
//                        .bs("RREETT")
//                        .build())
//                .address(Address.builder()
//                        .city("Kuiv")
//                        .street("Main Street")
//                        .zipcode("56000")
//                        .suite("Apt. 556")
//                        .geo(Geo.builder()
//                                .lat("-37.3159")
//                                .lng("81.1496")
//                                .build())
//                        .build())
//                .build();
//        System.out.println(Api.changeUser(newUser , 5L));
        System.out.println(Api.getAllLastPostComments(1L));

    }
}