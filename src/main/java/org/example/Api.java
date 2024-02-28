package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.example.request.UserRequestDto;
import org.example.response.CommentResponseDto;
import org.example.response.PostResponseDto;
import org.example.response.TodosResponseDto;
import org.example.response.UserResponseDto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Api {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    @SneakyThrows
    public static UserResponseDto newUser(UserRequestDto userRequestDto) {
        HttpClient httpClient = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String createUserRequestJson = objectMapper.writeValueAsString(userRequestDto);
        HttpRequest createUserRequest = HttpRequest.newBuilder(new URI(BASE_URL + "/users"))
                .POST(HttpRequest.BodyPublishers.ofString(createUserRequestJson))
                .header("accept", "application/json")
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> userResponse = httpClient.send(createUserRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("statusCode = " + userResponse.statusCode());
        return objectMapper.readValue(userResponse.body(), UserResponseDto.class);
    }
@SneakyThrows
    public static UserResponseDto changeUser(UserRequestDto userRequestDto, Long id) {
        HttpClient httpClient = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String createUserRequestJson = objectMapper.writeValueAsString(userRequestDto);
        HttpRequest createUserRequest = HttpRequest.newBuilder(new URI(BASE_URL + "/users/" + id))
                .PUT(HttpRequest.BodyPublishers.ofString(createUserRequestJson))
                .header("accept", "application/json")
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> userResponse = httpClient.send(createUserRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("statusCode = " + userResponse.statusCode());
        return objectMapper.readValue(userResponse.body(), UserResponseDto.class);
    }
    @SneakyThrows
    public static void deleteUser(Long id) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest createUserRequest = HttpRequest.newBuilder(new URI(BASE_URL + "/users/" + id))
                .DELETE()
                .build();
        HttpResponse<String> userResponse = httpClient.send(createUserRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("statusCode = " + userResponse.statusCode());
    }
    @SneakyThrows
    public static List<UserResponseDto> getAllUsers(){
        HttpClient httpClient = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
                HttpRequest getUserRequest = HttpRequest.newBuilder(new URI(BASE_URL + "/users"))
                .GET()
                .build();
        HttpResponse<String> userResponse = httpClient.send(getUserRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("productResponse.statusCode() = " + userResponse.statusCode());
        return objectMapper.readValue(userResponse.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, UserResponseDto.class));
    }

    @SneakyThrows
    public static UserResponseDto getUserById(Long id){
        HttpClient httpClient = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        HttpRequest getProductRequest = HttpRequest.newBuilder(new URI(BASE_URL + "/users/" + id))
                .GET()
                .build();
        HttpResponse<String> userResponse = httpClient.send(getProductRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("statusCode = " + userResponse.statusCode());
        return objectMapper.readValue(userResponse.body(), UserResponseDto.class);
    }
    @SneakyThrows
    public static List<UserResponseDto> getUserByUsername(String username){
        HttpClient httpClient = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        HttpRequest getUserRequest = HttpRequest.newBuilder(new URI(BASE_URL + "/users?username=" + username))
                .GET()
                .build();
        HttpResponse<String> userResponse = httpClient.send(getUserRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("statusCode = " + userResponse.statusCode());
        return objectMapper.readValue(userResponse.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, UserResponseDto.class));
    }

    @SneakyThrows
    public static List<CommentResponseDto> getAllLastPostComments(Long id){
        HttpClient httpClient = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        HttpRequest getPostRequest = HttpRequest.newBuilder(new URI(BASE_URL + "/users/" + id + "/posts"))
                .GET()
                .build();
        HttpResponse<String> postResponse = httpClient.send(getPostRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("statusCode = " + postResponse.statusCode());
        List<PostResponseDto> postResponseDtos = objectMapper.readValue(postResponse.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, PostResponseDto.class));
        Long lastPostId = postResponseDtos.get(postResponseDtos.size()-1).id();
        HttpRequest getCommentRequest = HttpRequest.newBuilder(new URI(BASE_URL + "/posts/" + lastPostId + "/comments"))
                .GET()
                .build();
        HttpResponse<String> commentResponse = httpClient.send(getCommentRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("statusCode = " + commentResponse.statusCode());
        List<CommentResponseDto> commentResponseDtos = objectMapper.readValue(commentResponse.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, CommentResponseDto.class));

        return commentResponseDtos;
    }
    @SneakyThrows
    public static List<TodosResponseDto> getAllNeedToDo(Long id){
        HttpClient httpClient = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        HttpRequest getUserRequest = HttpRequest.newBuilder(new URI(BASE_URL + "/users/" + id + "/todos?completed=false"))
                .GET()
                .build();
        HttpResponse<String> userResponse = httpClient.send(getUserRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("statusCode = " + userResponse.statusCode());
        return objectMapper.readValue(userResponse.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, TodosResponseDto.class));
    }

}
