package entities;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;


public class Endereco {

    private String Id;
    private String cep;
    private String localidade;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;

    public String getId() {
        return Id;
    }

    public void setID(String Id) {
        this.Id = Id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocaliade(String localidade) {
        this.localidade = localidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public static Endereco getEnderecoByCep(String cep) {
        Endereco endereco = new Endereco();
        
        // Montar o URL corretamente
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        HttpGet request = new HttpGet(url);

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            System.out.println(result);

            Gson gson = new Gson();
            endereco = gson.fromJson(result, Endereco.class);
            endereco.setComplemento(null);
            System.out.println(endereco);

        } catch (Exception e) {
            // Tratar a resposta do ViaCep
        }

        // Retornar o Endereco
        return endereco;
    }

}
