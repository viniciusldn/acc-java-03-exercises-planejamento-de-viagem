package com.trybe.acc.java.planejamentodeviagem;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

// TODO: Auto-generated Javadoc
/**
 * The Class Tempo.
 */
public class Tempo {

  /** The embarque. */
  private LocalDateTime embarque;

  /** The origem. */
  private String origem;

  /** The destino. */
  private String destino;

  /** The duracao. */
  private int duracao;

  /** The Constant formato. */
  private static final String formato = "dd/MM/yyyy HH:mm:ss";

  /**
   * Método construtor da classe.
   *
   * @param embarque the embarque
   * @param origem   the origem
   * @param destino  the destino
   * @param duracao  the duracao
   */
  public Tempo(String embarque, String origem, String destino, int duracao) {
    this.embarque = LocalDateTime.parse(embarque, DateTimeFormatter.ofPattern(formato));
    this.origem = origem;
    this.destino = destino;
    this.duracao = duracao;
  }

  /**
   * retonarDesembarqueHorarioLocalDestino.
   * <p>
   * Transforma todos os fusos horarios disponíveis na classe ZoneId em um array
   * de Strings, onde nos percorremos em busca do identificador do fuso horario do
   * nosso destino, uma vez com esse fuso horario, podemos recuperar o horario
   * local de desembarque no nosso destino
   * </p>
   *
   * @return the string
   */
  public String retonarDesembarqueHorarioLocalDestino() {

    String[] fusosHorarios = new String[ZoneId.getAvailableZoneIds().size()];
    ZoneId.getAvailableZoneIds().toArray(fusosHorarios);

    int indiceFusoHorarioOrigem = 0;

    for (int i = 0; i < fusosHorarios.length; i++) {
      if (fusosHorarios[i].contains(this.origem)) {
        indiceFusoHorarioOrigem = i;
      }
    }

    String fusoHorarioOrigem = fusosHorarios[indiceFusoHorarioOrigem];
    ZoneId fusoHorarioIdOrigem = ZoneId.of(fusoHorarioOrigem);

    ZonedDateTime origemHorarioLocal = this.embarque.atZone(fusoHorarioIdOrigem);

    int indiceFusoHorarioDestino = 0;

    for (int i = 0; i < fusosHorarios.length; i++) {
      if (fusosHorarios[i].contains(this.destino)) {
        indiceFusoHorarioDestino = i;
      }
    }

    String fusoHorarioDestino = fusosHorarios[indiceFusoHorarioDestino];
    ZonedDateTime destinoHorarioLocal = origemHorarioLocal
        .withZoneSameInstant(ZoneId.of(fusoHorarioDestino));

    return destinoHorarioLocal.plusHours(this.duracao).format(DateTimeFormatter.ofPattern(formato));
  }

  /**
   * retonarDesembarqueHorarioLocalOrigem.
   *
   * @return the string
   */
  public String retonarDesembarqueHorarioLocalOrigem() {
    String[] fusosHorarios = new String[ZoneId.getAvailableZoneIds().size()];
    ZoneId.getAvailableZoneIds().toArray(fusosHorarios);

    int indiceFusoHorarioOrigem = 0;

    for (int i = 0; i < fusosHorarios.length; i++) {
      if (fusosHorarios[i].contains(origem)) {
        indiceFusoHorarioOrigem = i;
      }
    }

    String fusoHorarioOrigem = fusosHorarios[indiceFusoHorarioOrigem];
    ZoneId fusoHorarioIdOrigem = ZoneId.of(fusoHorarioOrigem);

    ZonedDateTime origemHorarioLocal = this.embarque.atZone(fusoHorarioIdOrigem);

    return origemHorarioLocal.plusHours(this.duracao).format(DateTimeFormatter.ofPattern(formato));
  }
}
