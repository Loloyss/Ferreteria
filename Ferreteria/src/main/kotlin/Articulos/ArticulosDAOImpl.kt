package Articulos

import ConexionBD
import Constantes

class ArticulosDAOImpl : ArticulosDAO {

    val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun getArticulos(): ArrayList<Articulos> {
        conexion.conectar()

        var query = "SELECT * FROM ARTICULOS"

        var ps = conexion?.getPreparedStatement(query)
        var artcRtn = ArrayList<Articulos>()

        var st = ps?.executeQuery()
        while (st!!.next()) {
            var cod_art = st.getString("cod_art")
            var ref_art = st.getString("ref_art")
            var denomina = st.getString("denomina")
            var precio = st.getInt("precio")
            var descuento = st.getInt("descuento")

            var arti = Articulos(cod_art, ref_art, denomina, precio, descuento)
            artcRtn.add(arti)
        }
        conexion.desconectar()
        return artcRtn
    }

    override fun getArticuloByID(id: Int): ArrayList<Articulos> {
        TODO("Not yet implemented")
    }

    override fun insertArticulo(articulo: Articulos): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertArrArticulo(arrArticulo: Articulos): ArrayList<Articulos> {
        TODO("Not yet implemented")
    }
}