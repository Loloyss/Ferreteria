package Sucursales

import ConexionBD


class SucursalesDAOImpl: SucursalesDAO {
    val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun getSucursales(): ArrayList<Sucursales> {
        conexion.conectar()

        var arrSc = ArrayList<Sucursales>()
        var query = "SELECT * FROM sucursales"
        var ps = conexion.getPreparedStatement(query)
        var st = ps?.executeQuery()

        while (st!!.next()) {
            var cif = st.getString("cif")
            var cod_postal = st.getString("cod_postal")
            var direccion = st.getString("direccion")

            var pr = Sucursales(cif, cod_postal, direccion)
            arrSc.add(pr)
        }

        ps?.close()
        conexion.desconectar()

        return arrSc
    }

    override fun getSucursalesID(id: String): Sucursales? {
        conexion.conectar()

        var suc: Sucursales ?= null
        var query = "SELECT * FROM sucursales where cif = ?"
        var ps = conexion.getPreparedStatement(query)

        ps?.setString(1,id)
        var st = ps?.executeQuery()

        while (st!!.next()) {
            var cif = st.getString("cif")
            var cod_postal = st.getString("cod_postal")
            var direccion = st.getString("direccion")

            suc = Sucursales(cif, cod_postal, direccion)
        }

        ps?.close()
        conexion.desconectar()

        return suc
    }

    override fun insertSucursales(Sucursales: Sucursales): Boolean {
        return false
    }

    override fun insertArrSucursales(arrSuc: ArrayList<Sucursales>): Boolean {
        return false
    }

}