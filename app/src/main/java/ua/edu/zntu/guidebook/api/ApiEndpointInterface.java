package ua.edu.zntu.guidebook.api;

import java.util.LinkedList;

import retrofit2.http.GET;
import rx.Observable;
import ua.edu.zntu.guidebook.dto.NewsDTO;

public interface ApiEndpointInterface {

    @GET(ApiConstants.GET_NEWS_URL)
    Observable<LinkedList<NewsDTO>> getTodos();
}
