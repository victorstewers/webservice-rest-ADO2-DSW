package br.senac.tads.dsw.webservice_rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public class DadosService {
    private Map<Integer, String> dados;

    public DadosService() {
        dados = new HashMap<>();

        dados.put(1,"""
                {
                    "id": 1,
                    "nome": "Fulano da Silva",
                    "dataNascimento": "2000-10-20",
                    "email": "fulano@email.com",
                    "telefone": "11 99999-9999"
                 }
                """);
        dados.put(2,"""
                {
                    "id": 2,
                    "nome": "Ciclano de Souza",
                    "dataNascimento": "1999-05-15",
                    "email": "ciclano@email.com",
                    "telefone": "11 98888-8888"
                 }
                """);
        dados.put(3,"""
                {
                    "id": 3,
                    "nome": "Beltrano dos Santos",
                    "dataNascimento": "1999-05-15",
                    "email": "beltrano@email.com",
                    "telefone": "11 97777-7777"
                 }
                """);
    }

    public String findAll(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (String dado: dados.values()) {
            sb.append(dado).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
}
    public String findById(Integer id){
        return dados.get(id);
    }

    public static void main(String[] args) {
        DadosService dadosService = new DadosService();
        System.out.println(dadosService.findAll());
        System.out.println(dadosService.findById(1));
    }
}
