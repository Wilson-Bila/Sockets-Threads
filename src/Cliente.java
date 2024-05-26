
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        Socket socket = new Socket("localhost", 12345);

        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            String nome = "Wilson Bila";
            dos.writeUTF(nome);
            System.out.println("Escolha uma opcao \n 1- Continuar \n 0- Sair");
            int escolha = leitor.nextInt();
            dos.writeInt(escolha);
            do {
                System.out.println("******************MENU*****************");
                System.out.println("1- Adicao \n 2- Multiplicacao \n 3- Divisao");
                int opcao = leitor.nextInt();
                dos.writeInt(opcao);
                switch (opcao){
                    case 1 :
                        System.out.println("Digite o primeiro numero");
                        int n1A = leitor.nextInt();
                        dos.writeInt(n1A);
                        System.out.println("Digite o segundo numero");
                        int n2A = leitor.nextInt();
                        dos.writeInt(n2A);
                        System.out.println(n1A + "+" + n2A + "=" + dis.readInt());
                        break;

                    case 2 :
                        System.out.println("Digite o primeiro numero");
                        int n1M = leitor.nextInt();
                        dos.writeInt(n1M);
                        System.out.println("Digite o segundo numero");
                        int n2M = leitor.nextInt();
                        dos.writeInt(n2M);
                        System.out.println(n1M + "*" + n2M + "=" + dis.readInt());
                        break;

                    case 3 :
                        System.out.println("Digite o primeiro numero");
                        int n1D = leitor.nextInt();
                        dos.writeInt(n1D);
                        System.out.println("Digite o segundo numero");
                        int n2D = leitor.nextInt();
                        dos.writeInt(n2D);
                        System.out.println(n1D + "/" + n2D + "=" + dis.readDouble());


                }
            } while (escolha != 0);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro no cliente: " + e);
        }
    }
}
