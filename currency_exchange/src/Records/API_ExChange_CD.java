package Records;

import com.google.gson.annotations.SerializedName;

public record API_ExChange_CD(String result, @SerializedName("error-type") String error_Type, String time_last_update_utc, String conversion_result, String target_code) {

    /*
     {
        "result": "success",
        "documentation": "https://www.exchangerate-api.com/docs",
        "terms_of_use": "https://www.exchangerate-api.com/terms",
        "time_last_update_unix": 1585267200,
        "time_last_update_utc": "Fri, 27 Mar 2020 00:00:00 +0000",
        "time_next_update_unix": 1585270800,
        "time_next_update_utc": "Sat, 28 Mar 2020 01:00:00 +0000",
        "base_code": "EUR",
        "target_code": "GBP",
        "conversion_rate": 0.8412,
        "conversion_result": 5.8884
    }
     */

}
