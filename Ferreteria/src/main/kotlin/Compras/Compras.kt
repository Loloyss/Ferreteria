package Compras

class Compras {

    var cod_cli = ""
    var cod_art = ""
    var referencia = ""
    var medida = ""
    var fecha = ""
    var unidades = 0

    constructor(cod_cli: String, cod_art: String, referencia: String, medida: String, fecha: String, unidades: Int) {
        this.cod_art = cod_cli
        this.cod_cli = cod_art
        this.referencia = referencia
        this.medida = medida
        this.fecha = fecha
        this.unidades = unidades
    }

    override fun toString(): String {
        return "Compras(cod_cli='$cod_cli', cod_art='$cod_art', referencia='$referencia', medida='$medida', fecha='$fecha', unidades=$unidades)"
    }


}