package Articulos

class Articulos {
    var cod_art = ""
    var ref_art = ""
    var denomina = ""
    var precio = 0
    var descuento = 0

    constructor(cod_art: String, ref_art:String, denomina:String, precio: Int, descuento: Int){
        this.cod_art = cod_art
        this.ref_art = ref_art
        this.denomina = denomina
        this.precio = precio
        this.descuento = descuento
    }

    override fun toString(): String {
        return "Articulos(cod_art='$cod_art', ref_art='$ref_art', denomina='$denomina', precio=$precio, descuento=$descuento)"
    }

}