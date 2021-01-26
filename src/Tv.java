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

  int aumentarVolume() {
    if (!this.ligada) {
      throw new IllegalStateException("Tv delsigada !");
    } else if (volume == 100 || ligada == false) {
      throw new IllegalStateException("Volume máximo atingido");
    }
    if (this.mudo) {
      this.mudo = false;
      this.volume = volumeAntigo;
    }
    return this.volume++;
  }

  int diminuirVolume() {
    if (!this.ligada) {
      throw new IllegalStateException("Tv delsigada !");
    } else if (volume == 0 || ligada == false) {
      throw new IllegalArgumentException("Volume minimo atingido");
    }

    if (mudo) {
      volume = volumeAntigo;
      mudo = false;
    }

    return this.volume--;
  }

  int irParaCanal(int canal) {
    if (!this.ligada) {
      throw new IllegalStateException("Tv delsigada !");
    } else if (canal < 2 || canal > 69) {
      throw new IllegalStateException("Canal fora do ar");
    }

    this.canalAntigo = this.canal;
    return this.canal = canal;
  }

  int verCanal() {
    return this.canal;
  }

  int verVolume() {
    return this.volume;
  }

  int voltarCanal() {
    if (!this.ligada) {
      throw new IllegalStateException("Tv delsigada !");
    }

    return this.canalAntigo;
  }

  int passarCanal() {
    if (!this.ligada) {
      throw new IllegalStateException("Tv delsigada !");
    }
    if (this.canal == 69) {
      this.canalAntigo = this.canal;
      return this.canal = 2;
    } else {
      this.canalAntigo = canal;
      return ++this.canal;
    }
  }

  int diminuirCanal() {
    if (!this.ligada) {
      throw new IllegalStateException("Tv delsigada !");
    }

    if (this.canal == 2) {
      this.canalAntigo = this.canal;
      return this.canal = 69;
    } else {
      this.canalAntigo = this.canal;
      return --this.canal;
    }
  }

  boolean mudo() {
    if (!this.ligada) {
      throw new IllegalStateException("Tv delsigada !");
    }

    if (this.mudo) {
      this.volume = this.volumeAntigo;
      return !this.mudo;
    } else {
      this.volumeAntigo = this.volume;
      this.volume = 0;
      return this.mudo = true;
    }
  }

  boolean ligar() {
    return this.ligada = !this.ligada;
  }

}
