class MaquinaAgua {
  int agua = 0;
  int copos200 = 0;
  int copos300 = 0;

  int agua() {
    return this.agua;
  }

  int copos200() {
    return this.copos200;
  }

  int copos300() {
    return this.copos300;
  }

  int abastecerAgua() {
    return this.agua = 20000;
  }

  void servirCopo200() {
    if (this.copos200 == 0)
      throw new IllegalStateException("Acabaram os copos de 200ml");
    if (this.agua < 200)
      throw new IllegalStateException("Acabou o refil de agua");
    this.copos200--;
    this.agua -= 200;
  }

  void servirCopo300() {
    if (this.copos300 == 0)
      throw new IllegalStateException("Acabaram os copos de 300ml");
    if (this.agua < 300)
      throw new IllegalStateException("Acabou o refil de agua");
    this.copos300--;
    this.agua -= 300;
  }

  void abastecerCopo200() {
    this.copos200 = 100;
  }

  void abastecerCopo300() {
    this.copos300 = 100;
  }

}