import ch.hearc.ged.JSONUtilities;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;


import static ch.hearc.ged.JSONUtilities.RequestMethod.*;

/**
 * @author outerLeitmotiv
 * <a href="https://github.com/outerLeitmotiv">...</a>
 * {@code @Date} 30.03.23
 */
public class ApiCalls {
    private static final String url = "http://157.26.83.80:2240/";
    private static final String user = "admin.groupe3";
    private static final String password = "Notre super mot de passe";
    private String token ;

    String getToken() throws JSONException {
        HttpURLConnection testConnection = null;
        try {
            testConnection = JSONUtilities.write(url+"token", POST, "grant_type=password&username="+user+"&password="+password, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            token = JSONUtilities.read(testConnection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return toJson(token).getString("access_token");
    }

    static JSONObject toJson (String args) throws JSONException {
        JSONObject jsonArgs = new JSONObject(args);
        return jsonArgs;
    }

    public String getContentTypeList(String token) throws JSONException {
        ArrayList<JSONObject> contentTypeList = new ArrayList<>();
        String response = null;
        HttpURLConnection contentType = null;
        try {
            contentType = JSONUtilities.write(url + "api/content-type/list", GET, null, token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            response = JSONUtilities.read(contentType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JSONArray jsonArray = new JSONArray(response);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            contentTypeList.add(jsonObj);
        }
            return contentTypeList.get(0).getString("id");
    }

    public Invoices getInvoice(String token) {
        Invoices invoice = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            HttpURLConnection connection = JSONUtilities.write(url + "api/search/fulltext", POST, "{ " +
                    " \"searchPattern\" : \"facture\", " +
                    " \"contentTypeIDs\" : \"18\"" +
                    " }", token);
            String response = JSONUtilities.read(connection);

            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                invoice = mapper.readValue(jsonObj.toString(), Invoices.class);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return invoice;
    }
}