package br.senac.tads.dsw.webservice_rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DadosService {

    @Autowired
    private DadosDAO dadosDAO;

    public List<DadosDto> findAll() {
        return dadosDAO.findAll();
    }

    public Optional<DadosDto> findById(Integer id) {
        return dadosDAO.findById(id);
    }
}
