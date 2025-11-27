package br.com.fiap.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_games")
public class Game {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "TBL_GAMES_SEQ")
    @SequenceGenerator(
            name = "TBL_GAMES_SEQ",
            sequenceName = "TBL_GAMES_SEQ",
            allocationSize = 1)
    private Long id;

    private String titulo;

    @Column(name = "dt_lancamento")
    private LocalDate dataLancamento;

    private Double valor;
    private String produtora;
    private Boolean finalizado;
    //private String categoria;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public LocalDate getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public String getProdutora() {
        return produtora;
    }
    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }
    public Boolean getFinalizado() {
        return finalizado;
    }
    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }
//    public String getCategoria() {
//        return categoria;
//    }
//    public void setCategoria(String categoria) {
//        this.categoria = categoria;
//    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ID:" + this.id + ""
                + "\nTitulo:" + this.titulo + ""
                + "\nProdutora:" + this.produtora + ""
                + "\nCategoria:" + categoria.getNomeCategoria() + ""
                + "\nLancamento:" + this.dataLancamento + ""
                + "\nFinalizado:" + this.finalizado + ""
                + "\nValor:" + this.valor;

    }

}
