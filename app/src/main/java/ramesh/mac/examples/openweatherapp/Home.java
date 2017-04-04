package ramesh.mac.examples.openweatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import api.RetrofitHelper;
import model.com.weather.CityData;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Home extends AppCompatActivity {
    private static final String TAG = "Home";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Observable<CityData> myCityDataObservable = RetrofitHelper.Factory.createCityDataObservable("7778677","5ad7218f2e11df834b0eaf3a33a39d2a");
        Observer<CityData> myObserver = new Observer<CityData>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(CityData cityData) {

                Log.d(TAG, "onNext: " + cityData.getName());

            }
        };

        myCityDataObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(myObserver);
    }
}
