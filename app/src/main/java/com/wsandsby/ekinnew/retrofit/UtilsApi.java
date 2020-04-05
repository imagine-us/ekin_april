package com.wsandsby.ekinnew.retrofit;

public class UtilsApi {

     // 10.0.2.2 ini adalah localhost.
    public static final String BASE_URL_API = "http://tahutekno.com/ekinrest/api/Pegawai/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
