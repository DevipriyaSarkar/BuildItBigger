package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Pair;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;


/**
 * Created by Devipriya on 11-Jul-16.
 */
public class AsyncTaskTest extends AndroidTestCase {
    public void testAsyncTaskResponse() {
        assertNotNull("Async task returns null object.", new EndpointsAsyncTask().execute(new Pair<Context, String>(getContext(), "Funny Joke.")));
    }
}
