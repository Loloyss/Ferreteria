package Articulos

interface ArticulosDAO {
    fun getArticulos():ArrayList<Articulos>
    fun getArticuloByID(vcod_art: String, vref_art: String): Articulos
    fun insertArticulo(articulo:Articulos):Boolean
    fun insertArrArticulo(arrArticulo: ArrayList<Articulos>):Boolean
    fun modificarArticulo(articulo: Articulos): Boolean
    fun `eliminarArticuloByCod-Y-Ref_Art`(cod_art :String, ref_art:String): Boolean
}