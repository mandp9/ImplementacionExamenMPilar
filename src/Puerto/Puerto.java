package Puerto;
public class Puerto {
    private Hub[] hub;
    public Puerto()
    {
        hub = new Hub[3];
        for (int i = 0; i < 3; i++) {
            hub[i] = new Hub();
        }
    }

    public boolean ApilarContenedor(Contenedor cont)
    {
        boolean apilado = false;

        for (int i = 0; i < 3; i++) {

            apilado = this.hub[i].apilar(cont);

            if (apilado)
            {
                break;
            }
        }

        return apilado;
    }

    public boolean DesapilarContenedor(int numHub, int numColumna)
    {
        return this.hub[numHub].desapilar(numColumna);
    }

    public Contenedor BuscarContenedor(int idContenedor)
    {
        Contenedor aux = null;
        for (int i = 0; i < 3; i++) {

            aux = this.hub[i].datosContenedor(idContenedor);

            if (aux != null)
            {
                break;
            }
        }
        return aux;
    }

    public int BuscarContenedoresPorPais(String pais)
    {
        int contador =0;

        for (int i = 0; i < 3; i++) {

            contador += this.hub[i].cantidadContPais(pais);
        }

        return contador;
    }

    public String toString()
    {
        String mapa = "";

        for (int i = 0; i < 3; i++) {

            mapa += "Hub Nº " + (i + 1) + ":\n" + this.hub[i].toString() + "\n";

        }

        return mapa;
    }
    public String prioridad (int prio){
        Contenedor [] aux = new Contenedor[10];
        String cadena = "";
        int c = 0;
        Hub aux2 = new Hub();
        for (int i = 0; i < 3; i++) {
                aux2 = hub[i];
                aux [c] = aux2.datosContenedorPorPrioridad(prio);
                c++;
        }
        for (int j = 0; j <= c; j++) {
            cadena = aux[j] + "  ";
        }
        return cadena;
    }

}
