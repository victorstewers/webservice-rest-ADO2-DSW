package br.senac.tads.dsw.webservice_rest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class DadosDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/registroPessoas";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    private static final String SELECT_ALL_DADOS = "SELECT * FROM dados";
    private static final String SELECT_DADO_BY_ID = "SELECT * FROM dados WHERE id = ?";

    public List<DadosDto> findAll() {
        List<DadosDto> dadosList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_DADOS)) {

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String dataNascimento = resultSet.getString("dataNascimento");
                String email = resultSet.getString("email");
                String telefone = resultSet.getString("telefone");

                DadosDto dados = new DadosDto(id, nome, dataNascimento, email, telefone);
                dadosList.add(dados);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dadosList;
    }

    public Optional<DadosDto> findById(Integer id) {
        DadosDto dados = null;
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DADO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String dataNascimento = resultSet.getString("dataNascimento");
                String email = resultSet.getString("email");
                String telefone = resultSet.getString("telefone");
                dados = new DadosDto(id, nome, dataNascimento, email, telefone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(dados);
    }
}
