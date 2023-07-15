package src.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import src.Structure.*;

public class LoaderObject {
    //classe exclusiva para carregar os dados do CSV
    public static Produto[] Load(int limite) throws IOException {
        String csvFile = "C:/Users/railt/Documents/UFMA/ED2 - DALLYSON[/Tab01-ED2/src/IO/base.csv";
        ArrayList<Produto> produtos = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line;
        int count = 0;
        int[] colIndexes = {3, 5, 0 };
        int limit = limite;
    
        while ((line = reader.readLine()) != null && (limit == -1 || count < limit)) {
            String[] fields = line.split(",");
            String[] values = new String[3];
            for (int i = 0; i < colIndexes.length; i++) {
                int colIndex = colIndexes[i];
                if (colIndex < fields.length) {
                    values[i] = fields[colIndex];
                }
            }
            if (values[0] != null && values[1] != null && values[2] != null) {
                int quantidade = Integer.parseInt(values[0]);
                double preco = Double.parseDouble(values[1]);
                String id = values[2];
                Produto produto = new Produto(quantidade, preco, id);
                produtos.add(produto);
            }
            count++;
        }
        reader.close();
        Produto[] produtoArray = new Produto[produtos.size()];
        produtoArray = produtos.toArray(produtoArray);
        return produtoArray;
    }
    
}
