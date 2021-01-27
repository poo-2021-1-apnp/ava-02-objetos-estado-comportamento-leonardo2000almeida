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

  void aumentarVolume() {
    if (!this.ligada)
      throw new IllegalStateException("Tv delsigada !");
    else if (this.volume == 100 || !this.ligada)
      throw new IllegalStateException("Volume máximo atingido");

    if (this.mudo) {
      this.mudo = !this.mudo;
    }
    ++this.volume;
  }

  void diminuirVolume() {
    if (!this.ligada) {
      throw new IllegalStateException("Tv delsigada !");
    } else if (this.volume == 0 || !this.ligada) {
      throw new IllegalArgumentException("Volume minimo atingido");
    }

    if (this.mudo) {
      this.volume = this.volumeAntigo;
      this.mudo = false;
    }

    --this.volume;
  }

  void irParaCanal(int canal) {
    if (!this.ligada) {
      throw new IllegalStateException("Tv delsigada !");
    } else if (canal < 2 || canal > 69) {
      throw new IllegalStateException("Canal fora do ar");
    }

    this.canalAntigo = this.canal;
    this.canal = canal;
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
    this.canal = this.canalAntigo;
  }

  void passarCanal() {
    if (!this.ligada) {
      throw new IllegalStateException("Tv delsigada !");
    }
    if (this.canal == 69) {
      this.canalAntigo = this.canal;
      this.canal = 2;
    } else {
      this.canalAntigo = canal;
      ++this.canal;
    }
  }

  void diminuirCanal() {
    if (!this.ligada) {
      throw new IllegalStateException("Tv delsigada !");
    }

    if (this.canal == 2) {
      this.canalAntigo = this.canal;
      this.canal = 69;
    } else {
      this.canalAntigo = this.canal;
      --this.canal;
    }
  }

  void mudo() {
    if (!this.ligada)
      throw new IllegalStateException("Tv delsigada !");

    if (this.mudo) {
      this.volume = this.volumeAntigo;
      this.mudo = !this.mudo;
    } else {
      this.volumeAntigo = this.volume;
      this.volume = 0;
      this.mudo = !this.mudo;
    }
  }

  void ligar() {
    this.ligada = !this.ligada;
  }

}
