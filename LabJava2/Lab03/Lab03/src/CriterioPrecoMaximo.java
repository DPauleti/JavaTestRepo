public class CriterioPrecoMaximo implements CriterioBusca{
    public boolean testar(Produto p, String valor) {
        if (p.getPreco() <= Float.parseFloat(valor)) 
            return true;
        else return false;
    }
}