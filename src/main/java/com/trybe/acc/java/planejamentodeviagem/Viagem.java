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
   * @param embarque    the embarque
   * @param origem      the origem
   * @param destino     the destino
   * @param distanciaKm the distancia km
   */
  public Viagem(String embarque, String origem, String destino, double distanciaKm) {
    this.embarque = embarque;
    this.origem = origem;
    this.destino = destino;
    this.distanciaKm = distanciaKm;
  }

  /**
   * Método para retorno do horário de Desembarque no Destino.
   *
   * @return the string
   */
  public String retonarDesembarqueHorarioLocalDestino() {
    Tempo tempoViagem = new Tempo(this.embarque, this.origem, this.destino,
        this.retornarDuracaoVoo());
    return tempoViagem.retonarDesembarqueHorarioLocalDestino();
  }

  /**
   * Retornar duracao voo.
   *
   * @return the int
   */
  // aqui consideramos que um aviao percorre em media 700 km a cada hora.
  public int retornarDuracaoVoo() {
    Voo duracaoVoo = new Voo();
    return duracaoVoo.retornarTempoVoo(distanciaKm);
  }

  /**
   * Método para retorno da informaçao da viagem.
   *
   * @return the string
   */
  public String retornarInformacaoViagem() {
    Tempo tempoViagem = new Tempo(this.embarque, this.origem, this.destino,
        this.retornarDuracaoVoo());

    return this.embarque + " - " + this.origem + "\n" + this.retonarDesembarqueHorarioLocalDestino()
        + " - " + this.destino;
  }
}
