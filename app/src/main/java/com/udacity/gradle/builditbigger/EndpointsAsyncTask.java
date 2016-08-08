package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.teapink.dispjokeandroidlib.DisplayJoke;
import com.teapink.joke.backend.jokeApi.JokeApi;

import java.io.IOException;

/**
 * Created by Devipriya on 11-Jul-16.
 */
public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private JokeApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {

        context = params[0].first;
        String joke = params[0].second;

        if (myApiService == null) {     // Only do this once
            //for local server
                /*JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 10.0.2.2 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                        .setRootUrl("http://192.168.1.148:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });*/
            //after deploying to App Engine
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokebuilditbigger.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.tellJoke(joke).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        // after the joke is loaded, pass it to the Android library to display it
        Intent intent = new Intent(context, DisplayJoke.class);
        intent.putExtra("jokePassed", result);
        context.startActivity(intent);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }


}