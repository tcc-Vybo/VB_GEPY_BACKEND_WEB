package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.AlunoDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Entity
@Table (name = "aluno")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    // Identificação
    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false)
    private String dataNascimento;

    @Column(nullable = false)
    private String cidadeNascimento;

    @Column(nullable = false)
    private String ufNascimento;

    @Column(nullable = false)
    private String nacionalidade;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private String corRaca;

    @Column(nullable = false)
    private String necessidades;

    // Endereço
    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private int numeroEndereco;

    private String complemento;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String municipio;

    @Column(nullable = false)
    private String uf;

    // RG
    @Column(nullable = false)
    private String numeroRegistro;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String dataEmissao;

    @Column(nullable = false)
    private String orgaoExpedidor;

    // Contato Aluno
    @Column(nullable = false)
    private String telefoneAluno;

    // Contato Responsáveis
    @Column(nullable = false)
    private String nomeResponsavel;

    @Column(nullable = false)
    private String cpfResponsavel;

    @Column(nullable = false)
    private String relacao;

    @Column(nullable = false)
    private String telefoneResponsavel;

    @Column(nullable = false)
    private String emailResponsavel;

    public AlunoEntity(AlunoDTO aluno) {
        BeanUtils.copyProperties(aluno, this);
    }
}
