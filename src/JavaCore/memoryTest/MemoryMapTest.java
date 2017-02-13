/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCore;

/**
 *
 * @author ywu
 */
import java.io.*;

import java.nio.*; // new io

import java.nio.channels.*;

import java.nio.file.*;

import java.util.zip.*;

public class MemoryMapTest {

    public static long checksnumInputStream(Path filename) throws IOException {

        try (InputStream in = Files.newInputStream(filename)) {

            CRC32 crc = new CRC32();

            int c;

            while ((c = in.read()) != -1) {
                crc.update(c);
            }

            return crc.getValue();
        }
    }

    public static long checksumBufferedInputStream(Path filename) throws IOException {

        try {
            InputStream in = new BufferedInputStream(Files.newInputStream(filename))
            
            
                ){
            
                CRC32 crc = new CRC32();

                int c;

                while ((c = in.read()) != -1) {

                    crc.update(c);
                }

                return crc.getValue();

            }
        }
    }

    public static long checksumRandomAccessFile(Path filename) throws IOException {

        try (RandomAccessFile file = new RandomAccessFile(filename.toFile(), "r")) {

            long length = file.length();

            CRC32 crc = new CRC32();

            for (long p = 0; p < length; ++p) {

                file.seek(p);

                int c = file.readByte();

                crc.update(c);
            }

            return crc.getValue();
        }
    }

    public static long checksumMappedFile(Path filename) throws IOException {

        try (FileChannel channel = FileChannel.open(filename)) {

            CRC32 crc = new CRC32();

            int length = (int) channel.size();

            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);

            for (int p = 0; p < length; ++p) {

                int c = buffer.get(p);

                crc.update(c);
            }

            return crc.getValue();
        }
    }
}
