package br.espm.cambio;

import java.time.LocalDate;
import java.util.UUID;

public class Cotacao {
        private UUID id;
        private String nome;
        private double valor;
        private LocalDate data;
        private UUID idMoeda;
    
        public Cotacao() {
    
        }
    
        public Cotacao(String nome, double valor, LocalDate data) {
            this.nome = nome;
            this.valor=valor;
            this.data=data;
        }
    
        public UUID getId() {
            return id;
        }
    
        public String getNome() {
            return nome;
        }

        public LocalDate getData() {
            return data;
        }

        public UUID getIdMoeda() {
            return idMoeda;
        }

        public double getValor() {
            return valor;
        }
        
        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public void setData(LocalDate data) {
            this.data = data;
        }

        public void setIdMoeda(UUID idMoeda) {
            this.idMoeda = idMoeda;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }
 }
    
    

