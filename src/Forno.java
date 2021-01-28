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

  boolean setLigado(boolean ligado) {
    return this.ligado = ligado;
  }

  int setTemperatura(int temperatura) {
    return this.temperatura = temperatura;
  }

  int setTempo(int tempo) {
    return this.tempo = tempo;
  }

  int temperatura() {
    return this.temperatura;
  }

  boolean ligado() {
    return this.ligado;
  }

  void aumentarTemperatura() {
    if (!this.ligado)
      setLigado(!this.ligado);

    if (this.temperatura < 300)
      throw new IllegalStateException("Temperatura máxima!");

    if (this.temperatura < 200)
      setTemperatura(this.temperatura += 50);
    else if (this.temperatura == 200)
      setTemperatura(this.temperatura += 20);
    else if (this.temperatura == 220)
      setTemperatura(this.temperatura += 30);
    else if (this.temperatura == 250)
      setTemperatura(this.temperatura += 50);

  }

  void diminuirTemperatura() {
    if (this.temperatura < 50)
      throw new IllegalStateException("Temperatura minima atingida");

    if (this.temperatura < 200)
      setTemperatura(this.temperatura -= 50);
    else if (this.temperatura == 220)
      setTemperatura(this.temperatura -= 20);
    else if (this.temperatura == 250)
      setTemperatura(this.temperatura -= 30);
    else if (this.temperatura == 300)
      setTemperatura(this.temperatura -= 50);
  }

  void setTimer(int tempo) {
    if (tempo < 0 || tempo > 120)
      throw new IllegalArgumentException("Tempo inválido");

    setTempo(tempo);
  }

  void desligar() {
    setLigado(!this.ligado);
  }

  void tick() {
    if (this.tempo != 0)
      setTempo(--this.tempo);
    setTemperatura(this.temperatura = 0);
    setLigado(!this.ligado);
  }

  int tempoRestante() {
    return this.tempo;
  }
}
