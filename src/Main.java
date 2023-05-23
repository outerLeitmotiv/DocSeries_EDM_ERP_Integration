import org.codehaus.jettison.json.JSONException;


/**
 * @author outerLeitmotiv
 * <a href="https://github.com/outerLeitmotiv">...</a>
 * {@code @Date} 30.03.23
 */// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


public class Main {
    public static void main(String[] args) throws JSONException {
        ApiCalls api = new ApiCalls();
        String token = (api.getToken());
        api.getContentTypeList(token);
    }
}