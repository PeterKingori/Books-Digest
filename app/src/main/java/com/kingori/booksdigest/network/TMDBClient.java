package com.kingori.booksdigest.network;

import com.kingori.booksdigest.network.TMDBApi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.kingori.booksdigest.Constants.THEMOVIEDB_API_KEY;
import static com.kingori.booksdigest.Constants.THEMOVIEDB_BASE_URL;

public class TMDBClient {
    private static Retrofit retrofit = null;

    public static TMDBApi getClient() {
        if (retrofit == null) {
            OkHttpClient.Builder okHttClient = new OkHttpClient.Builder();
            Interceptor interceptorOne = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest = chain.request().newBuilder()
                            .addHeader("api_key", THEMOVIEDB_API_KEY)
                            .build();
                    return chain.proceed(newRequest);
                }
            };
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttClient.addInterceptor(interceptorOne)
                    .addInterceptor(interceptor);
            retrofit = new Retrofit.Builder()
                    .baseUrl(THEMOVIEDB_BASE_URL)
                    .client(okHttClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(TMDBApi.class);
    }
}
