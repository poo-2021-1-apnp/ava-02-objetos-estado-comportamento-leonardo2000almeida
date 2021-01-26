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
    if (ligada == false) {
      throw new IllegalStateException("Tv delsigada !");
    } else if (volume == 100 || ligada == false) {
      throw new IllegalStateException("Volume máximo atingido");
    }
    if (mudo == true) {
      mudo = false;
      volume = volumeAntigo;
    }
    return this.volume++;
  }

  int diminuirVolume() {
    if (ligada == false) {
      throw new IllegalStateException("Tv delsigada !");
    } else if (volume == 0 || ligada == false) {
      throw new IllegalArgumentException("Volume minimo atingido");
    }

    if (mudo == true) {
      volume = volumeAntigo;
      mudo = false;
    }

    return this.volume--;
  }

  int irParaCanal(int canal) {
    if (ligada == false) {
      throw new IllegalStateException("Tv delsigada !");
    } else if (canal < 2 || canal > 69) {
      throw new IllegalStateException("Canal fora do ar");
    }

    canalAntigo = this.canal;
    return this.canal = canal;
  }

  int verCanal() {
    return this.canal;
  }

  int verVolume() {
    return this.volume;
  }

  int voltarCanal() {
    if (ligada == false) {
      throw new IllegalStateException("Tv delsigada !");
    }

    return this.canalAntigo;
  }

  int passarCanal() {
    if (ligada == false) {
      throw new IllegalStateException("Tv delsigada !");
    }
    if (canal == 69) {
      canalAntigo = canal;
      return this.canal = 2;
    } else {
      canalAntigo = canal;
      return this.canal++;
    }
  }

  int diminuirCanal() {
    if (ligada == false) {
      throw new IllegalStateException("Tv delsigada !");
    }

    if (canal == 2) {
      canalAntigo = canal;
      return this.canal = 69;
    } else {
      canalAntigo = canal;
      return this.canal--;
    }
  }

  boolean mudo() {
    if (ligada == false) {
      throw new IllegalStateException("Tv delsigada !");
    }

    if (mudo == true) {
      volume = volumeAntigo;
      return this.mudo = false;
    } else {
      volumeAntigo = volume;
      volume = 0;
      return this.mudo = true;
    }
  }

  boolean ligar() {
    if (ligada == true) {
      return this.ligada = false;
    }
    this.canal = 2;
    return this.ligada = true;
  }

}
