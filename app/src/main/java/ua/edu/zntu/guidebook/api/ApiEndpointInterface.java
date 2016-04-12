package ua.edu.zntu.guidebook.api;

import java.util.LinkedList;

import retrofit2.http.GET;
import rx.Observable;
import ua.edu.zntu.guidebook.dto.NewsDTO;

public interface ApiEndpointInterface {

    @GET("/index.php?option=com_mobilenews&view=mobilenews")
    Observable<LinkedList<NewsDTO>> getTodos();
}
