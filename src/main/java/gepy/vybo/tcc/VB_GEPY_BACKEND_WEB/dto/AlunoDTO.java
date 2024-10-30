package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.AlunoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class AlunoDTO {

    private Long id;

    // Identificação
    private String nomeCompleto;
    private String dataNascimento;
    private String cidadeNascimento;
    private String ufNascimento;
    private String nacionalidade;
    private String genero;
    private String corRaca;
    private String necessidades;

    // Endereço
    private String cep;
    private String endereco;
    private int numeroEndereco;
    private String complemento;
    private String bairro;
    private String municipio;
    private String uf;

    // RG
    private String numeroRegistro;
    private String cpf;
    private String dataEmissao;
    private String orgaoExpedidor;

    // Contato Aluno
    private String emailAluno;
    private String telefoneAluno;

    // Contato Responsáveis
    private String nomeResponsavel;
    private String cpfResponsavel;
    private String relacao;
    private String telefoneResponsavel;
    private String emailResponsavel;

    public AlunoDTO(AlunoEntity aluno) {
        BeanUtils.copyProperties(aluno, this);
    }
}
