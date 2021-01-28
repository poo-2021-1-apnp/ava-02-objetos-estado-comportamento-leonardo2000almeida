class Tv {
  final String fabricante;
  final String modelo;
  final int tamanho;
  final String resolucao;
  int volume;
  int canal;
  int canalAntigo;
  int volumeAntigo;
  boolean mudo = false;
  boolean ligada = false;
  int aux;

  Tv(String fabricante, String modelo, int tamanho, String resolucao) {
    this.fabricante = fabricante;
    this.modelo = modelo;
    this.tamanho = tamanho;
    this.resolucao = resolucao;
  }

  String checarModelo() {
    return this.modelo;
  }

  String checarResolucao() {
    return this.resolucao;
  }

  int setVolume(int volume) {
    return this.volume = volume;
  }

  int setCanal(int canal) {
    return this.canal = canal;
  }

  boolean setMudo(boolean mudo) {
    return this.mudo = mudo;
  }

  int setVolumeAntigo(int volumeAntigo) {
    return this.volumeAntigo = volumeAntigo;
  }

  int setCanalAntigo(int canalAntigo) {
    return this.canalAntigo = canalAntigo;
  }

  boolean setLigada(boolean ligada) {
    return this.ligada = ligada;
  }

  void aumentarVolume() {
    if (!this.ligada)
      throw new IllegalStateException("Tv delsigada !");
    else if (this.volume == 100 || !this.ligada)
      throw new IllegalStateException("Volume máximo atingido");

    if (this.mudo) {
      setMudo(!this.mudo);
    }
    setVolume(++this.volume);
  }

  void diminuirVolume() {
    if (!this.ligada)
      throw new IllegalStateException("Tv delsigada !");
    else if (this.volume == 0 || !this.ligada)
      throw new IllegalArgumentException("Volume minimo atingido");

    if (this.mudo) {
      setVolume(this.volumeAntigo);
      setMudo(!this.mudo);
    }

    setVolume(--this.volume);
  }

  void irParaCanal(int canal) {
    if (!this.ligada)
      throw new IllegalStateException("Tv delsigada !");
    else if (canal < 2 || canal > 69)
      throw new IllegalStateException("Canal fora do ar");

    setCanalAntigo(this.canal);
    setCanal(canal);
  }

  int verCanal() {
    return this.canal;
  }

  int verVolume() {
    return this.volume;
  }

  void voltarCanal() {
    if (!this.ligada) {
      throw new IllegalStateException("Tv delsigada !");
    }
    setCanal(this.canalAntigo);
  }

  void passarCanal() {
    if (!this.ligada)
      throw new IllegalStateException("Tv delsigada !");

    if (this.canal == 69) {
      setCanalAntigo(this.canal);
      setCanal(2);
    } else {
      setCanalAntigo(canal);
      setCanal(++this.canal);
    }
  }

  void diminuirCanal() {
    if (!this.ligada) {
      throw new IllegalStateException("Tv delsigada !");
    }

    if (this.canal == 2) {
      setCanalAntigo(this.canal);
      setCanal(69);
    } else {
      setCanalAntigo(this.canal);
      setCanal(--this.canal);
    }
  }

  void mudo() {
    if (!this.ligada)
      throw new IllegalStateException("Tv delsigada !");

    if (this.mudo) {
      setVolume(this.volumeAntigo);
      setMudo(!this.mudo);
    } else {
      setVolumeAntigo(this.volume);
      setVolume(0);
      setMudo(!this.mudo);
    }
  }

  void ligar() {
    setLigada(!this.ligada);
  }

}
