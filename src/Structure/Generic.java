package src.Structure;

public class Generic<Key extends Comparable<Key>, Value > implements Comparable<Generic<Key, Value>> {
    // implementação do generics com chave e valor
    private Key chave;
    private Value valor;

    public Generic(Key chave, Value valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public Key getKey() {
        return this.chave;
    }

    public Value getValue() {
        return this.valor;
    }

    @Override
    public int compareTo(Generic o) {
        // faz o casting da chave para determinado tipo seja Int , Double ou String.
        if(this.chave instanceof Integer){
            return((Integer) this.chave).compareTo((Integer) o.getKey());//cast para integer
        }else if(this.chave instanceof String){
            return((String) this.chave).compareTo((String) o.getKey());// cast para String
        }else{
            return((Double) this.chave).compareTo((Double) o.getKey());// cast para Double
        }
    }
}