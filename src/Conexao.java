import javax.swing.*;
import java.io.*;
import java.net.*;

public class Conexao extends Thread{
    private Socket socket;
    public Conexao(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        super.run();
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            int escolha = dis.readInt();

            do {

                int opcao = dis.readInt();
                switch (opcao){
                    case 1 :
                        int n1A = dis.readInt();
                        int n2A = dis.readInt();
                        int soma = (n1A+n2A);
                        dos.writeInt(soma);
                        break;

                    case 2 :
                        int n1M = dis.readInt();
                        int n2M = dis.readInt();
                        int multiplicacao = (n1M*n2M);
                        dos.writeInt(multiplicacao);
                        break;

                    case 3 :
                        int n1D = dis.readInt();
                        int n2D = dis.readInt();
                        double divisao = (n1D/n2D);
                        dos.writeDouble(divisao);


                }
            } while (escolha != 0);


        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    }

