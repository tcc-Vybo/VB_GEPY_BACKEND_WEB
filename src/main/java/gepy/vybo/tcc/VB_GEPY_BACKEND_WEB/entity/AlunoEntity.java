package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.AlunoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table (name = "aluno")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Identificação
    @NotBlank
    @Column(nullable = false)
    private String nomeCompleto;

    @NotBlank
    @Column(nullable = false)
    private String dataNascimento;

    @NotBlank
    @Column(nullable = false)
    private String cidadeNascimento;

    @NotBlank
    @Column(nullable = false)
    private String ufNascimento;

    @NotBlank
    @Column(nullable = false)
    private String nacionalidade;

    @NotBlank
    @Column(nullable = false)
    private String genero;

    @NotBlank
    @Column(nullable = false)
    private String corRaca;

    @NotBlank
    @Column(nullable = false)
    private String necessidades;

    // Endereço
    @NotBlank
    @Column(nullable = false)
    private String cep;

    @NotBlank
    @Column(nullable = false)
    private String endereco;

    @NotNull
    @Column(nullable = false)
    private int numeroEndereco;

    private String complemento;

    @NotBlank
    @Column(nullable = false)
    private String bairro;

    @NotBlank
    @Column(nullable = false)
    private String municipio;

    @NotBlank
    @Column(nullable = false)
    private String uf;

    // RG
    @NotBlank
    @Column(nullable = false)
    private String numeroRegistro;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String cpf;

    @NotBlank
    @Column(nullable = false)
    private String dataEmissao;

    @NotBlank
    @Column(nullable = false)
    private String orgaoExpedidor;

    // Contato Aluno
    @NotBlank
    @Column(nullable = false)
    private String emailAluno;

    @NotBlank
    @Column(nullable = false)
    private String telefoneAluno;

    // Contato Responsáveis
    @NotBlank
    @Column(nullable = false)
    private String nomeResponsavel;

    @NotBlank
    @Column(nullable = false)
    private String cpfResponsavel;

    @NotBlank
    @Column(nullable = false)
    private String relacao;

    @NotBlank
    @Column(nullable = false)
    private String telefoneResponsavel;

    @NotBlank
    @Column(nullable = false)
    private String emailResponsavel;

    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate(){
        if (this.nomeCompleto != null){
            this.nomeCompleto = this.nomeCompleto.toUpperCase();
        }
        if(this.nomeResponsavel != null){
            this.nomeResponsavel = this.nomeResponsavel.toUpperCase();
        }
    }

    public AlunoEntity(AlunoDTO aluno) {
        BeanUtils.copyProperties(aluno, this);
    }
}
