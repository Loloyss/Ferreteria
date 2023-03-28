package Medidas

class Medidas {
    var codigo = ""
    var referencia = ""
    var medida = ""
    var stock = 0

    constructor(codigo: String, referencia: String, medida: String, stock: Int){
        this.codigo = codigo
        this.referencia = referencia
        this.medida = medida
        this.stock = stock
    }

}