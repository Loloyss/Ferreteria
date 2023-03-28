package Articulos

interface ArticulosDAO {
    fun getArticulos():ArrayList<Articulos>
    fun getArticuloByID(id:Int):ArrayList<Articulos>
    fun insertArticulo(articulo:Articulos):Boolean
    fun insertArrArticulo(arrArticulo: Articulos):ArrayList<Articulos>
}