package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FuncionarioDTO {

    private Long id;

    // Dados Pessoais
    private String nomeCompleto;
    private String dataNascimento;
    private String genero;
    private String telefone;
    private String email;

    // Dados Profissionais
    private String cargo;
    private String departamento;
    private String dataAdmissao;

    // Endereço Residencial
    private String cep;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;

    // RG
    private String numeroRegistro;
    private String cpf;
    private String dataEmissao;
    private String orgaoExpedidor;
}
