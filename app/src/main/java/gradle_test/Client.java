package gradle_test;

import java.net.*;

import org.checkerframework.checker.mustcall.qual.CreatesMustCallFor;
import org.checkerframework.checker.mustcall.qual.MustCall;
import org.checkerframework.checker.mustcall.qual.Owning;

import java.io.*;

@MustCall("close")
public class Client {
    private @Owning Socket socket;
    private @Owning DataInputStream input;
    private @Owning DataOutputStream out;

    public Client() throws UnknownHostException, IOException {
        socket = new Socket("192.168.1.16", 1336);
        System.out.println("connected");

        input = new DataInputStream(System.in);
        out = new DataOutputStream(socket.getOutputStream());
    }

    public void close() {
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // @CreatesMustCallFor("this")
    // public void reconnect() {
    //     System.out.println("closing");
    //     try {
    //         if (!socket.isClosed()) {
    //             socket.close();
    //         }
    //         socket = new Socket("192.168.1.16", 1336);
    //         socket.close();
    //     } catch (IOException e) {
    //         System.out.println(e);
    //     }
    //   }
}
