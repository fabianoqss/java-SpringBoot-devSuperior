package crud.com.example.REST.dto;

import crud.com.example.REST.entities.Client;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class ClientDTO {

    private Long id;

    @Size(min = 3, message = "Nome Precisa ter de 3 no mínimo 3 caracteres")
    @NotBlank(message = "Nome é Obrigatório e não pode ser vazio")
    private String name;

    @Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres")
    @Pattern(regexp = "^\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}$",
            message = "CPF deve estar no formato 000.000.000-00 ou 00000000000")
    private String cpf;

    private Double income;

    @PastOrPresent(message = "Data de nascimento não pode ser futura")
    private LocalDate birthDate;

    @PositiveOrZero(message = "Número de filhos não pode ser negativo")
    private Integer children;

    public ClientDTO (){

    }

    public ClientDTO(Client client) {
        id = client.getId();
        name = client.getName();
        cpf = client.getCpf();
        income = client.getIncome();
        birthDate = client.getBirthDate();
        children = client.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
