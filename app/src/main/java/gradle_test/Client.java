package gradle_test;

import java.net.*;

import org.checkerframework.checker.calledmethods.qual.EnsuresCalledMethods;
import org.checkerframework.checker.mustcall.qual.MustCall;
import org.checkerframework.checker.mustcall.qual.Owning;

import java.io.*;

@MustCall({"close"})
public class Client {
    private final @Owning Socket socket;
    private final @Owning DataInputStream input;
    private final @Owning DataOutputStream out;

    public Client() throws UnknownHostException, IOException {
        socket = new Socket("192.168.1.16", 1336);
        System.out.println("connected");

        input = new DataInputStream(System.in);
        out = new DataOutputStream(socket.getOutputStream());
    }

    @EnsuresCalledMethods(value={"this.socket","this.input","this.out"}, methods="close")
    public void close() throws IOException {
        input.close();
        out.close();
        socket.close();
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
