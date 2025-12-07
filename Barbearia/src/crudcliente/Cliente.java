package crudcliente;

/**
 * Classe de modelo/entidade que representa um Cliente.
 * Contém os atributos básicos (ID, Nome, Telefone, Email) e métodos de acesso.
 */
public class Cliente {
    // --- Atributos ---
    private Integer id;
    private String nome;
    private String telefone;
    private String email;

    // --- Construtores ---
    
    /**
     * Construtor padrão (vazio).
     */
    public Cliente() {
    }

    /**
     * Construtor para inserção (sem ID).
     * @param nome O nome do cliente.
     * @param telefone O telefone do cliente.
     * @param email O e-mail do cliente.
     */
    public Cliente(String nome, String telefone, String email) {
        this.nome = nome.toUpperCase(); // Mantendo a regra de negócio do nome em maiúsculas
        this.telefone = telefone;
        this.email = email;
    }

    /**
     * Construtor completo (com ID) para recuperação de dados do banco.
     * @param id O ID único do cliente.
     * @param nome O nome do cliente.
     * @param telefone O telefone do cliente.
     * @param email O e-mail do cliente.
     */
    public Cliente(Integer id, String nome, String telefone, String email) {
        this(nome, telefone, email); 
        this.id = id;
    }

    // --- Métodos de Acesso (Getters e Setters) ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}