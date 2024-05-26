
import javax.swing.*;
import java.net.*;
import java.io.*;

public class Servidor {
    static int conexoes = 0;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Esperando por conexoes...");
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("Conexao estabelecida!");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String nome = dis.readUTF();
                System.out.println("********* " + nome + " conectou-se! " + " ********* " );
                conexoes++;
                if (conexoes <= 1){
                    System.out.println(conexoes + " Cliente " +  " conectado!");
                }
                else {
                    System.out.println(conexoes + " Clientes " +  " conectados!");
                }
                Conexao con = new Conexao(socket);
                con.start();

            }

        }

        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro no servidor: " + e);
        }
    }
}
