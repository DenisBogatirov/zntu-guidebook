package ua.edu.zntu.guidebook.api;

import java.util.LinkedList;

import retrofit2.http.GET;
import rx.Observable;
import ua.edu.zntu.guidebook.dto.TodosDTO;

public interface ApiEndpointInterface {

    @GET("/index.php/mobile-news")
    Observable<LinkedList<TodosDTO>> getTodos();
}
