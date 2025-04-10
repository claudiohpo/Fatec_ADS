import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class CnaeEngine {
    public static Cnae consultarCnae(String codigo) throws Exception {
        //Realizado a busca na API por Subclasse, realizado o tratamento do JSON para extrair a Classe, Grupo, Divisão e Seção.
        String endpoint = "https://servicodados.ibge.gov.br/api/v2/cnae/subclasses/" + codigo;
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

        try {
            // Tratamento da resposta do JSON
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject json = jsonArray.getJSONObject(0);

            // Pega a descrição da subclasse e código
            String descricaoSubclasse = json.getString("descricao");

            String codigoSubclasse = json.getString("id");

            // Pega a descrição da classe e código
            JSONObject classeObj = json.getJSONObject("classe");
            String descricaoClasse = classeObj.getString("descricao");

            JSONObject classeCodObj = json.getJSONObject("classe");
            String codigoClasse = classeCodObj.getString("id");

            // Pega a descrição do Grupo e código
            JSONObject  grupoObj = classeObj.getJSONObject("grupo");
            String descricaoGrupo = grupoObj.getString("descricao");

            JSONObject grupoCodObj = classeObj.getJSONObject("grupo");
            String codigoGrupo = grupoCodObj.getString("id");

            // Pega a descrição da Divisão e código
            JSONObject divisaoObj = grupoObj.getJSONObject("divisao");
            String descricaoDivisao = divisaoObj.getString("descricao");

            JSONObject divisaoCodObj = grupoObj.getJSONObject("divisao");
            String codigoDivisao = divisaoCodObj.getString("id");

            // Pega a descrição da Seção e código
            JSONObject secaoObj = divisaoObj.getJSONObject("secao");
            String descricaoSecao = secaoObj.getString("descricao");

            JSONObject secaoCodObj = divisaoObj.getJSONObject("secao");
            String codigoSecao = secaoCodObj.getString("id");

            //Console
            System.out.println("Subclasse: " + descricaoSubclasse);
            System.out.println("Classe: " + descricaoClasse);
            System.out.println("Grupo: " + descricaoGrupo);
            System.out.println("Divisão: " + descricaoDivisao);
            System.out.println("Seção: " + descricaoSecao);

            return new Cnae(codigo, descricaoSubclasse, descricaoClasse, descricaoGrupo,
                    descricaoDivisao, descricaoSecao, codigoSecao, codigoDivisao,
                    codigoGrupo, codigoClasse, codigoSubclasse);
        } catch (Exception e) {
            throw new Exception("Erro ao processar JSON: " + e.getMessage());
        }
    }
}