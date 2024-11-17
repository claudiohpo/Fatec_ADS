import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CnaeEngine {
    public static Cnae consultarCnae(String codigo) throws Exception {
        String endpoint = "https://servicodados.ibge.gov.br/api/v2/cnae/" + codigo;
        URL url = new URL(endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Erro: " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            response.append(line);
        }
        conn.disconnect();

        JSONObject json = new JSONObject(response.toString());
        String descricao = json.getString("descricao");
        return new Cnae(codigo, descricao);
    }
}
