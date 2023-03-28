package Poblaciones

class Poblaciones {

    var cod_postal = ""
    var poblacion = ""
    var provincia = ""

    constructor(cod_postal: String, poblacion: String, provincia: String){
        this.cod_postal = cod_postal
        this.poblacion = poblacion
        this.provincia = provincia
    }

    override fun toString(): String {
        return "Poblaciones(cod_postal='$cod_postal', poblacion='$poblacion', provincia='$provincia')"
    }
}