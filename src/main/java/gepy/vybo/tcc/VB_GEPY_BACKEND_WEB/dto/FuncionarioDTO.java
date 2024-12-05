package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.FuncionarioEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class FuncionarioDTO {

    private Long id;

    // Dados Pessoais
    private String nomeCompleto;
    private String dataNascimento;
    private String cidadeNascimento;
    private String ufNascimento;
    private String nacionalidade;
    private String genero;
    private String corRaca;
    private String telefone;
    private String email;

    // Endereço Residencial
    private String cep;
    private String endereco;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;

    // RG
    private String numeroRegistro;
    private String cpf;
    private String dataEmissao;
    private String orgaoExpedidor;

    public FuncionarioDTO(FuncionarioEntity funcionario) {
        BeanUtils.copyProperties(funcionario, this);
    }
}
