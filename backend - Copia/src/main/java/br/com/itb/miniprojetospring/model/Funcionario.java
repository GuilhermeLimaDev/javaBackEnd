package br.com.itb.miniprojetospring.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

    @Column
    private String cargo;

    @Column
    private Long codStatus;

    public Funcionario(){

    }
    public Funcionario(Long id, String nome, String email, String senha, String cargo, Long codStatus){
      this.id = id;
      this.nome = nome;
      this.email = email;
      this.senha = senha;
      this.cargo = cargo;
      this.codStatus = codStatus;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(Long codStatus) {
        this.codStatus = codStatus;
    }
}
