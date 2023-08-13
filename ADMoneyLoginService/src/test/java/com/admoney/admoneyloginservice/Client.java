package com.admoney.admoneyloginservice;

import com.google.gson.JsonObject;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class Client {

    private final RestTemplate restTemplate;
    private String url;

    public Client(String url) {
        restTemplate = new RestTemplate(new CustomHttpComponentsClientHttpRequestFactory());
        this.url=url;
    }

    public String getWithBody(Object requestBody) {

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(requestBody), String.class).getBody();

    }

    private static final class CustomHttpComponentsClientHttpRequestFactory extends HttpComponentsClientHttpRequestFactory {

        @Override
        protected HttpUriRequest createHttpUriRequest(HttpMethod httpMethod, URI uri) {

            if (HttpMethod.GET.equals(httpMethod)) {
                return new HttpEntityEnclosingGetRequestBase(uri);
            }
            return super.createHttpUriRequest(httpMethod, uri);
        }
    }

    private static final class HttpEntityEnclosingGetRequestBase extends HttpEntityEnclosingRequestBase {

        public HttpEntityEnclosingGetRequestBase(final URI uri) {
            super.setURI(uri);
        }

        @Override
        public String getMethod() {
            return HttpMethod.GET.name();
        }
    }
}