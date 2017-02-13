/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCore.server;

/**
 *
 * @author ywu
 */
import java.io.*;

import java.net.*;

import java.util.*;

public class EchoServer {

    public static void main(String args) {

        try (ServerSocket s = new ServerSocket(8189)) {

            try (Socket incoming = s.accept()) {

                InputStream inStream = incoming.getInputStream();

                OutputStream outStream = incoming.getOutputStream();
            }

            try (Scanner in = new Scanner(inStream)) {

                PrintWriter out = new PrintWriter(outStream, true);

                out.println("Hello! Enter BYE to exit.");

                boolean done = false;

                while (!done && in.hasNextLine()) {

                    String line = in.nextLine();

                    out.println("Echo: " + line);

                    if (line.trim().equals("BYE")) {
                        done = true;
                    }
                }
            }
        }
    }
}
