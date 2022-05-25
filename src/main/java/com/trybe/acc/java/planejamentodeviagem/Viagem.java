package com.trybe.acc.java.planejamentodeviagem;

// TODO: Auto-generated Javadoc
/**
 * The Class Viagem.
 */
public class Viagem {
  
  /** The embarque. */
  private String embarque;
  
  /** The origem. */
  private String origem;
  
  /** The destino. */
  private String destino;
  
  /** The distancia km. */
  private double distanciaKm;
  
  /** The voo. */
  private Voo voo;

  /**
   * Método construtor da classe.
   * 
   */
  public Viagem() {
    /* Implemente sua solução aqui (você pode ter que alterar o construtor) */
  }

  /**
   * Método para retorno do horário de Desembarque no Destino.
   *
   * @return the string
   */
  public String retonarDesembarqueHorarioLocalDestino() {
    Tempo tempoViagem =
        new Tempo(this.embarque, this.origem, this.destino, this.retornarDuracaoVoo());
    return tempoViagem.retonarDesembarqueHorarioLocalDestino();
  }

  /**
   * Retornar duracao voo.
   *
   * @return the int
   */
  // aqui consideramos que um aviao percorre em media 700 km a cada hora
  public int retornarDuracaoVoo() {
      /* Implemente sua solução aqui */
  }

  /**
   * Método para retorno da informaçao da viagem.
   *
   * @return the string
   */
  public String retornarInformacaoViagem() {
    Tempo tempoViagem =
        new Tempo(this.embarque, this.origem, this.destino, this.retornarDuracaoVoo());

    /* Implemente sua solução aqui */
  }
}
