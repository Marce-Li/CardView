package com.marcelolissa.cardview.restApi;

public final class ConstantesRestApi {

    public static final String ROOT_URL = "https://graph.instagram.com";
    public static final String ACCSESS_TOKEN = "IGQVJVTElXSEM2ZA2NGMkRScEtLTlE5b1ZAJQlZAlM1FvSVMwc2R4MVhsVlZAURVdBa0IzVDRkcThHNVZACdG5ZAaEF0ZAVdDMWZAvdXA2VElTbjRwQ0ZAqQTdMX1ZAaTy1QTXhDOVhQX2w5YUY3YVRSZAnRFeVBoNgZDZD";
    public static final String USER_ID = "/17841444055836399";
    public static final String KEY_ACCSESS_TOKEN = "&access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "/media?fields=id,media_type,media_url,owner,timestamp";

    //17841444055836399/media?fields=id,media_type,media_url,like_count,owner,timestamp&access_token="Aca poner el token"
    public static final String URL_GET_RECENT_MEDIA_USER = USER_ID + KEY_GET_RECENT_MEDIA_USER + KEY_ACCSESS_TOKEN + ACCSESS_TOKEN;


}
