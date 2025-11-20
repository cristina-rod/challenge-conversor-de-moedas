import br.com.conversor.moedas.ConversaoMoeda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExchangeRateApi exchangeRateApi = new ExchangeRateApi();
        List<String> historico = new ArrayList<>();

        var opcaoEscolhida = 0;
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Boas vindas ao Conversor de Moedas");
            System.out.println("""
                    \n(1) Real -> Peso Argentino
                    (2) Peso Argentido -> Real
                    (3) Dólar -> Real Brasileiro
                    (4) Real Brasileiro -> Dólar
                    (5) Euro -> Real
                    (6) Real -> Euro
                    (7) Visualizar histórico de conversões
                    (8) Sair\n
                    Escolha uma opção válida:
                    ---------------------------------------------""");

            //Tratamento básico para não quebrar se digitarem letras
            try {
                opcaoEscolhida = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor, digite apenas números.");
                scanner.nextLine(); // limpa o buffer
                continue;
            }

            if (opcaoEscolhida == 8){
                System.out.println("Finalizando a aplicação...");
                break;
            }

            if (opcaoEscolhida == 7) {
                System.out.println("--- Histórico de Conversões ---");
                if (historico.isEmpty()) {
                    System.out.println("Nenhuma conversão realizada ainda.");
                } else {
                    for (String registro : historico) {
                        System.out.println(registro);
                    }
                }
                continue;
            }

            String baseCode = "";
            String targetCode = "";

            switch (opcaoEscolhida) {
                case 1: baseCode = "BRL"; targetCode = "ARS"; break;
                case 2: baseCode = "ARS"; targetCode = "BRL"; break;
                case 3: baseCode = "USD"; targetCode = "BRL"; break;
                case 4: baseCode = "BRL"; targetCode = "USD"; break;
                case 5: baseCode = "EUR"; targetCode = "BRL"; break;
                case 6: baseCode = "BRL"; targetCode = "EUR"; break;
                default: System.out.println("Opção inválida! Tente novamente."); continue;
            }

            System.out.println("Digite o valor que deseja converter:");
            double valorInserido = scanner.nextDouble();
            scanner.nextLine();

            try {
                ConversaoMoeda novaConversao = exchangeRateApi.buscarCotacao(baseCode, targetCode);
                double taxa = novaConversao.conversionRate();
                double valorConvertido = valorInserido * taxa;
                String resultadoFormatado = String.format("Valor %.2f [%s] corresponde ao valor final de -> %.2f [%s]",
                        valorInserido, baseCode, valorConvertido, targetCode);
                System.out.println(resultadoFormatado);

                LocalDateTime agora = LocalDateTime.now();
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String registroHistorico = "[" + agora.format(formatador) + "] " + resultadoFormatado;
                historico.add(registroHistorico);

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando a aplicação.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }
}
