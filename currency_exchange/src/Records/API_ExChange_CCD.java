package Records;

import com.google.gson.annotations.SerializedName;

public record API_ExChange_CCD(String result, @SerializedName("error-type") String error_Type, Object supported_codes) {

    /*
     {
	"result":"success",
	"documentation":"https://www.exchangerate-api.com/docs",
	"terms_of_use":"https://www.exchangerate-api.com/terms"
	"supported_codes":[
		["AED","UAE Dirham"],
		["AFN","Afghan Afghani"],
		["ALL","Albanian Lek"],
		["AMD","Armenian Dram"],
		["ANG","Netherlands Antillian Guilder"],
		["AOA","Angolan Kwanza"],
		["ARS","Argentine Peso"],
		["AUD","Australian Dollar"],
		["AWG","Aruban Florin"],
		["AZN","Azerbaijani Manat"],
		["BAM","Bosnia and Herzegovina Convertible Mark"],
		["BBD","Barbados Dollar"] etc. etc.]
     }
     */

}
