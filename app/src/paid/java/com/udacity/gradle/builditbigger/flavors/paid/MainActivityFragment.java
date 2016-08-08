package com.udacity.gradle.builditbigger.flavors.paid;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.teapink.joke.JokeTeller;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button jokeButton = (Button) root.findViewById(R.id.jokeButton);

        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JokeTeller jokeTeller = new JokeTeller();
                String joke = jokeTeller.tellJoke();    //fetches jokes from Java library

                new EndpointsAsyncTask().execute(new Pair<Context, String>(getContext(), joke));    //sending joke to GCE server

            }
        });

        return root;
    }
}
