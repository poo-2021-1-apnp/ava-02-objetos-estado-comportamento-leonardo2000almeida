class MaquinaAguaConfiguravel {
  final int capacidadeAgua;
  final int capacidadeCopos200;
  final int capacidadeCopos300;
  int agua;
  int copos200;
  int copos300;

  MaquinaAguaConfiguravel(int capacidadeAgua, int capacidadeCopos200, int capacidadeCopos300) {
    if (capacidadeAgua <= 0)
      throw new IllegalArgumentException("Capacidade de agua deve ser positiva");
    if (capacidadeCopos200 <= 0)
      throw new IllegalArgumentException("Capacidade de copos200 deve ser positiva");
    if (capacidadeCopos300 <= 0)
      throw new IllegalArgumentException("Capacidade de copos300 deve ser positiva");

    this.capacidadeAgua = capacidadeAgua;
    this.capacidadeCopos200 = capacidadeCopos200;
    this.capacidadeCopos300 = capacidadeCopos300;
  }

  int agua() {
    return this.agua;
  }

  int copos200() {
    return this.copos200;
  }

  int copos300() {
    return this.copos300;
  }

  int capacidadeAgua() {
    return this.capacidadeAgua;
  }

  int capacidadeCopos200() {
    return this.capacidadeCopos200;
  }

  int abastecerAgua() {
    return this.agua = this.capacidadeAgua;
  }

  void servirCopo200() {
    if (copos200 == 0)
      throw new IllegalStateException("Acabaram os copos de 200ml");
    if (agua == 0)
      throw new IllegalStateException("Acabou o refil de agua");
    copos200--;
    agua -= 200;
  }

  void servirCopo300() {
    if (copos300 == 0)
      throw new IllegalStateException("Acabaram os copos de 300ml");
    if (capacidadeAgua == 0)
      throw new IllegalStateException("Acabou o refil de agua");
    copos300--;
    agua -= 300;
  }

  int abastecerCopo200() {
    if (this.copos200 < 0)
      throw new IllegalArgumentException("Copos de 200ml deve ser positivoo");
    return this.copos200 = this.capacidadeCopos200;
  }

  int abastecerCopo300() {
    if (this.copos300 < 0)
      throw new IllegalArgumentException("Copos de 300ml deve ser positivoo");
    return this.copos300 = this.capacidadeCopos300;
  }

}