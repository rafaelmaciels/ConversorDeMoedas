import com.google.gson.Gson;
import java.util.Scanner;

public class ConversorDeMoedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiClient apiClient = new ApiClient();
        Gson gson = new Gson();

        while (true) {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 7) {
                System.out.println("Obrigado por usar o Conversor de Moedas! Saindo...");
                break;
            }

            if (opcao < 1 || opcao > 6) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            String moedaOrigem = "";
            String moedaDestino = "";

            switch (opcao) {
                case 1: moedaOrigem = "USD"; moedaDestino = "BRL"; break;
                case 2: moedaOrigem = "BRL"; moedaDestino = "USD"; break;
                case 3: moedaOrigem = "EUR"; moedaDestino = "BRL"; break;
                case 4: moedaOrigem = "BRL"; moedaDestino = "EUR"; break;
                case 5: moedaOrigem = "USD"; moedaDestino = "ARS"; break;
                case 6: moedaOrigem = "ARS"; moedaDestino = "USD"; break;
            }

            try {
                // 1. Fazer a requisição para a API usando a moeda de origem
                String jsonResponse = apiClient.getExchangeRates(moedaOrigem);

                // 2. Analisar (parse) a resposta JSON para um objeto Java
                ExchangeRateResponse response = gson.fromJson(jsonResponse, ExchangeRateResponse.class);

                // 3. Obter a taxa de conversão para a moeda de destino
                Double taxaConversao = response.conversion_rates().get(moedaDestino);
                if (taxaConversao == null) {
                    System.out.println("Não foi possível encontrar a taxa de conversão para " + moedaDestino);
                    continue;
                }

                // 4. Calcular o valor convertido
                double valorConvertido = valor * taxaConversao;

                // 5. Exibir o resultado formatado
                System.out.printf("---------------------------------------------%n");
                System.out.printf("Resultado: %.2f %s = %.2f %s%n", valor, moedaOrigem, valorConvertido, moedaDestino);
                System.out.printf("---------------------------------------------%n%n");

            } catch (Exception e) {
                System.err.println("Ocorreu um erro: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("*********************************************");
        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("1) Dólar (USD) => Real (BRL)");
        System.out.println("2) Real (BRL) => Dólar (USD)");
        System.out.println("3) Euro (EUR) => Real (BRL)");
        System.out.println("4) Real (BRL) => Euro (EUR)");
        System.out.println("5) Dólar (USD) => Peso Argentino (ARS)");
        System.out.println("6) Peso Argentino (ARS) => Dólar (USD)");
        System.out.println("7) Sair");
        System.out.println("*********************************************");
    }
}
