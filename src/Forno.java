class Forno {
  final int volume;
  final int tensao;
  final int potencia;
  final int largura;
  final int altura;
  final int profundidade;
  private int temperatura = 0;
  private boolean ligado = false;
  int tempo;

  Forno(int volume, int tensao, int potencia, int largura, int altura, int profundidade) {
    this.volume = volume;
    this.tensao = tensao;
    this.potencia = potencia;
    this.largura = largura;
    this.altura = altura;
    this.profundidade = profundidade;
  }

  int temperatura() {
    return this.temperatura;
  }

  boolean ligado() {
    return this.ligado;
  }

  void aumentarTemperatura() {
    if (this.temperatura > 300)
      throw new IllegalStateException("Temperatura máxima!");
    this.temperatura += 50;
    this.ligado = true;
  }

  int count = 3;

  int diminuirTemperatura() {
    if (this.temperatura < 50)
      throw new IllegalStateException("Temperatura minima atingida");
    if (count == 3) {
      return this.temperatura -= 50;
    } else if (count == 2) {
      return this.temperatura -= 30;
    } else {
      count = 3;
      return this.temperatura -= 20;
    }
  }

  void setTimer(int tempo) {
    if (tempo < 0 || tempo > 120)
      throw new IllegalArgumentException("Tempo inválido");
    this.tempo = tempo;
  }

  boolean desligar() {
    return this.ligado = !this.ligado;
  }

  int tick() {
    if (this.tempo != 0) {
      return --this.tempo;
    }
    this.temperatura = 0;
    this.ligado = false;
    return this.tempo;
  }

  int tempoRestante() {
    return this.tempo;
  }
}
