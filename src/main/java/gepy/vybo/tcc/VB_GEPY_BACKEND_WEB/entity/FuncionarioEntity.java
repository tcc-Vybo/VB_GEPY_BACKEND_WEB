package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.FuncionarioDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Dados Pessoais
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
    private String telefone;

    @Column(nullable = false)
    private String email;

    // Dados Profissionais
    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private String departamento;

    @Column(nullable = false)
    private String dataAdmissao;

    // Endereço Residencial
    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private int numero;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

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

    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate(){
        if (this.nomeCompleto != null){
            this.nomeCompleto = this.nomeCompleto.toUpperCase();
        }
    }

    public FuncionarioEntity(FuncionarioDTO funcionario) {
        BeanUtils.copyProperties(funcionario, this);
    }
}
