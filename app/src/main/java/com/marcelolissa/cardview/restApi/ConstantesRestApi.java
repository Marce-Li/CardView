package com.marcelolissa.cardview.restApi;

public final class ConstantesRestApi {

    public static final String VERSION = "/v9.0/";
    public static final String ROOT_URL = "https://graph.facebook.com" + VERSION;
    public static final String ACCSESS_TOKEN = "EAAFTZBbnhRRkBADkfo3DN61cr3B9S7kKzZACGzhpOZCDkgBQc6EEeSpcwXI9CzWDlkSuZBqKuxouyTAZAIzitzOuA1F3Vq5MNCPRcldmZA0QgwfSJQIV7KuPmvSPK7CZCdKZBgQa73vEYbe3ia1KCLcyylA2fVI164WFMgPWKB34ZCQZDZD";
    public static final String USER_ID = "17841444055836399";
    public static final String KEY_ACCSESS_TOKEN = "&access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "/media?fields=id,media_type,media_url,like_count,owner,timestamp";

    //17841444055836399/media?fields=id,media_type,media_url,like_count,owner,timestamp&access_token="Aca poner el token"
    public static final String URL_GET_RECENT_MEDIA_USER = USER_ID + KEY_GET_RECENT_MEDIA_USER + KEY_ACCSESS_TOKEN + ACCSESS_TOKEN;

}
