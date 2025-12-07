package crudagenda;

public class Agenda {
    
    private int id;
    private int idCliente;
    private String nomeCliente; 
    private String data;
    private String hora;
    private String servico;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public String getServico() { return servico; }
    public void setServico(String servico) { this.servico = servico; }
}

