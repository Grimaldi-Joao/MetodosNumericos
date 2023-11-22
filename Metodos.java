public class Metodos {
    public class InterpolacaoLagrange {

    public static double lagrange(double[] x, double[] y, double xi) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Os arrays x e y devem ter o mesmo tamanho.");
        }

        int n = x.length;
        double resultado = 0.0;

        for (int i = 0; i < n; i++) {
            double termo = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    termo = termo * (xi - x[j]) / (x[i] - x[j]);
                }
            }
            resultado += termo;
        }

        return resultado;
    }

    public static double interpolarLinear(double x1, double y1, double x2, double y2, double xi) {
        return y1 + (xi - x1) * (y2 - y1) / (x2 - x1);
    }

    public static double interpolarGeometrica(double x1, double y1, double x2, double y2, double xi) {
        if (y1 <= 0 || y2 <= 0) {
            throw new IllegalArgumentException("Os valores de y1 e y2 devem ser positivos para interpolação geométrica.");
        }
        return y1 * Math.pow(y2 / y1, (xi - x1) / (x2 - x1));
    }

    public static void main(String[] args) {
        double[] anos = {0, 5, 10, 15}; //2005,2010,2015,2020
        double[] populacoes = {186.13, 195.71, 205.19, 213.20};

        // Ponto para interpolar daqui a 17 anos
        double xi = 17;

        double resultadoLagrange = lagrange(anos, populacoes, xi);
        double resultadoLinear = interpolarLinear(anos[2], populacoes[2], anos[3], populacoes[3], xi);
        double resultadoGeometrico = interpolarGeometrica(anos[2], populacoes[2], anos[3], populacoes[3], xi);

        System.out.println("População em 2020 (Interpolação Lagrange): " + resultadoLagrange +" milhões");
        System.out.println("População em 2020 (Interpolação Linear): " + resultadoLinear +" milhões");
        System.out.println("População em 2020 (Interpolação Geométrica): " + resultadoGeometrico +" milhões");
}
}
}
