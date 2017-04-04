package api;

import model.com.weather.CityData;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by User on 4/3/2017.
 */

public interface OpenWeatherService {

   //  static final String BASE_URL = "http://api.openweathermap.org/data/2.5";
     @GET("weather")
     Observable<CityData> getWeatherDataforCity(@Query("id") String cityID,
                                                @Query("appid") String appid);


}
