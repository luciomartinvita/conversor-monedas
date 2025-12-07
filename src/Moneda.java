public class Moneda {
    private String monedaBase;
    private String monedaDestino;
    private double tasaConversion;

    public Moneda(String json) {
        // Extraer conversion_rate del JSON
        String[] partes = json.split("\"conversion_rate\":");
        String numeroStr = partes[1].split("}")[0].trim();
        this.tasaConversion = Double.parseDouble(numeroStr);
    }

    public double convertir(double cantidad) {
        return cantidad * tasaConversion;
    }

    public double getTasaConversion() {
        return tasaConversion;
    }
}

