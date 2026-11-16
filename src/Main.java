import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.print("\nDia da semana (1 = segunda ... 7 = domingo) ou 'sair': ");
            String resposta = entrada.nextLine();

            if (resposta.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                int dia = Integer.parseInt(resposta);

                System.out.print("Hora (0 a 23): ");
                resposta = entrada.nextLine();

                if (resposta.equalsIgnoreCase("sair")) {
                    break;
                }

                int hora = Integer.parseInt(resposta);

                System.out.print("Minuto (0 a 59): ");
                resposta = entrada.nextLine();

                if (resposta.equalsIgnoreCase("sair")) {
                    break;
                }

                int minuto = Integer.parseInt(resposta);

                // Dia útil (segunda a sexta)
                boolean diaValido = dia >= 1 && dia <= 5;

                // Expediente: primeira consulta às 08:00 e última às 17:30
                boolean horarioValido = hora >= 8 &&
                        (hora < 17 || (hora == 17 && minuto <= 30));

                // Início de blocos de 30 minutos
                boolean minutoValido = minuto == 0 || minuto == 30;

                // Validação dos intervalos de entrada
                boolean entradaValida = dia >= 1 && dia <= 7 &&
                        hora >= 0 && hora <= 23 &&
                        minuto >= 0 && minuto <= 59;

                // Resultado da validação
                if (!entradaValida) {
                    System.out.println("Erro: dia, hora ou minuto fora do intervalo permitido.");
                } else if (diaValido && horarioValido && minutoValido) {
                    System.out.println("Horário válido para consulta");
                } else {
                    System.out.println("Horário inválido:");

                    if (!diaValido) {
                        System.out.println("- O atendimento ocorre apenas de segunda a sexta.");
                    }

                    if (!horarioValido) {
                        System.out.println("- O horário deve estar entre 08:00 e 17:30.");
                    }

                    if (!minutoValido) {
                        System.out.println("- As consultas começam apenas nos minutos 00 ou 30.");
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Erro: digite um número inteiro válido.");
            }
        }

        entrada.close();
        System.out.println("Programa encerrado.");
    }
}
