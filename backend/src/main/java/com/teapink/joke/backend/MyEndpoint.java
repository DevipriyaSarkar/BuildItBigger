/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.teapink.joke.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "jokeApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.joke.teapink.com",
    ownerName = "backend.joke.teapink.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a joke and returns it back */
    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke(@Named("joke") String joke) {
        MyBean response = new MyBean();
        response.setData(joke);

        return response;
    }

}
