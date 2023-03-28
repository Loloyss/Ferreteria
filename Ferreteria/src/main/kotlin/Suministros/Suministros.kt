package Suministros

class Suministros {
    var cif_pro = ""
    var cod_art = ""
    var referencia = ""
    var medida = ""
    var fecha = ""
    var unidades = 0
    var precio = 0
    constructor(cif_pro: String, cod_art: String, referencia:String, medida: String, fecha: String, unidades: Int, precio: Int ){
        this.cif_pro = cif_pro
        this.cod_art = cod_art
        this.referencia = referencia
        this.medida = medida
        this.fecha = fecha
        this.unidades = unidades
        this.precio = precio
    }
}