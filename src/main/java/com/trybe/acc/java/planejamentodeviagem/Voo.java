package com.trybe.acc.java.planejamentodeviagem;

// TODO: Auto-generated Javadoc
/**
 * The Class Voo.
 */
public class Voo {

  /** The tempo voo. */
  private int tempoVoo;

  /**
   * Método para retornar tempo de Voo.
   *
   * @param distanciaKm the distancia km
   * @return the int
   */
  public int retornarTempoVoo(double distanciaKm) {

    Double duracaoDouble = distanciaKm / 700.0;
    tempoVoo = (int) Math.floor(duracaoDouble);

    return tempoVoo;
  }

  /**
   * Método para retornar informaçao do Voo.
   *
   * @param embarque    the embarque
   * @param origem      the origem
   * @param desembarque the desembarque
   * @param destino     the destino
   * @return the string
   */
  public String retornarInformacaoVoo(String embarque, String origem, String desembarque,
      String destino) {
    return "Partida: " + embarque + "\n" + "Origem: " + origem + "\n" + "\n" + "Chegada: "
        + desembarque + "\n" + "Destino: " + destino + "\n";
  }
}
