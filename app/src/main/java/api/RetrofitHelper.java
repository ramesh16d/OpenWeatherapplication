package api;

import model.com.weather.CityData;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by User on 4/3/2017.
 */

public class RetrofitHelper {

    static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    public static  class Factory{
        static Retrofit retrofit = create();
        static  OpenWeatherService openWeatherService = retrofit.create(OpenWeatherService.class);


        public static Retrofit create() {
            return new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build();
        }
        public static Observable<CityData> createCityDataObservable(String cityID , String appid) {
            return openWeatherService.getWeatherDataforCity(cityID , appid);
        }


    }

}
