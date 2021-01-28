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

  int setAgua(int agua) {
    return this.agua = agua;
  }

  int setCopo200(int copo200) {
    return this.copos200 = copo200;
  }

  int setCopo300(int copo300) {
    return this.copos300 = copo300;
  }

  void servirCopo200() {
    if (this.copos200 == 0)
      throw new IllegalStateException("Acabaram os copos de 200ml");

    if (this.agua < 200)
      throw new IllegalStateException("Acabou o refil de agua");

    setCopo200(--this.copos200);
    setAgua(this.agua -= 200);
  }

  void servirCopo300() {
    if (this.copos300 == 0)
      throw new IllegalStateException("Acabaram os copos de 300ml");

    if (this.agua < 300)
      throw new IllegalStateException("Acabou o refil de agua");

    setCopo300(--this.copos300);
    setAgua(this.agua -= 300);
  }

  void abastecerCopo200() {
    setCopo200(100);
  }

  void abastecerCopo300() {
    setCopo300(100);
  }

  void abastecerAgua() {
    setAgua(20000);
  }

}