package ch9.security;

import java.io.*;
import java.security.*;

/**
 * This program demonstrates how to sign a message with a private DSA key
 * and verify it with the matching public key. Usage:
 * java SignatureTest -genkey public private
 * java SignatureTest -sign message signed private
 * java SignatureTest -verify signed public
 *
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 7/31/2015
 * Email: billchen01@163.com
 */
public class SignatureTest {

    private static final int KEYSIZE = 512;

    public static void main(String[] args) {

        try{
            if (args[0].equals("-genkey")){
                KeyPairGenerator pairgen = KeyPairGenerator.getInstance("DSA");
                SecureRandom random = new SecureRandom();
                pairgen.initialize(KEYSIZE, random);
                KeyPair keyPair = pairgen.generateKeyPair();
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(args[1]));
                out.writeObject(keyPair.getPublic());
                out.close();
                out = new ObjectOutputStream(new FileOutputStream(args[2]));
                out.writeObject(keyPair.getPrivate());
                out.close();

            }else if(args[0].equals("-sign")){
                ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(args[3]));
                PrivateKey privateKey = (PrivateKey) keyIn.readObject();
                keyIn.close();

                Signature signalg = Signature.getInstance("DSA");
                signalg.initSign(privateKey);

                File infile = new File(args[1]);
                InputStream in = new FileInputStream(infile);
                int length = (int) infile.length();
                byte[] message = new byte[length];
                in.read(message, 0, length);
                in.close();

                signalg.update(message);
                byte[] signature = signalg.sign();

                DataOutputStream out = new DataOutputStream(new FileOutputStream(args[2]));
                int signlength = signature.length;
                out.writeInt(signlength);
                out.write(signature, 0, signlength);
                out.write(message, 0, length);
                out.close();

            }else if(args[0].equals("-verify")){
                ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(args[2]));
                PublicKey pubkey = (PublicKey) keyIn.readObject();
                keyIn.close();

                Signature verifyalg = Signature.getInstance("DSA");
                verifyalg.initVerify(pubkey);

                File infile = new File(args[1]);
                DataInputStream in = new DataInputStream(new FileInputStream(infile));
                int signlength = in.readInt();
                byte[] signature = new byte[signlength];
                in.read(signature, 0, signlength);

                int length = (int) infile.length() - signlength -4;
                byte[] message = new byte[length];
                in.read(message, 0, length);
                in.close();

                verifyalg.update(message);
                if(!verifyalg.verify(signature)){
                    System.out.println("not ");
                }
                System.out.println("verified");

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
