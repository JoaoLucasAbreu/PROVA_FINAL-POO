package br.espm.cambio;

import java.time.LocalDate;
import java.util.UUID;

public class Cotacao {
        private UUID id;
        private double valor;
        private LocalDate data;
        private UUID idMoeda;
    
        public Cotacao() {
    
        }
    
        public Cotacao(double valor) {
            this.valor=valor;
        }
    
        public UUID getId() {
            return id;
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
    
    

