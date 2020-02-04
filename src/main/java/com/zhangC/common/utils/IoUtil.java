package com.zhangC.common.utils;

/**
 * Created by zhangc on 2017/8/29.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.text.NumberFormat;

public class IoUtil {
    private static final String DEFAULT_CHAR_SET = "UTF-8";
    public static final int BUFFERSIZE = 4096;
    public static final long ONE_KB = 1024L;
    public static final long ONE_MB = 1048576L;
    public static final long ONE_GB = 1073741824L;
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';
    private static final Logger log = Logger.getLogger(IoUtil.class);

    private IoUtil() {
    }

    public static File createFile(String filePath) throws IOException {
        if (filePath == null) {
            return null;
        } else {
            File f = new File(filePath);
            if (f.exists()) {
                return f;
            } else {
                File p = f.getParentFile();
                if (!p.exists()) {
                    p.mkdirs();
                }

                f.createNewFile();
                return f;
            }
        }
    }

    public static boolean deleteFile(String filePath) throws IOException {
        if (filePath == null) {
            return true;
        } else {
            File f = new File(filePath);
            return f.exists() ? f.delete() : true;
        }
    }

    public static final void writeToFile(String fileName, String content) throws IOException {
        writeToFile(fileName, content, "UTF-8");
    }

    public static final void writeToFile(String fileName, String content, String charSet) throws IOException {
        if (fileName != null && content != null) {
            if (charSet == null || charSet.trim().length() == 0) {
                charSet = "UTF-8";
            }

            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(createFile(fileName)), charSet);
            writer.write(content);
            writer.close();
        }
    }

    public static final void writeToFile(File file, String content) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        writer.write(content);
        writer.close();
    }

    public static final void writeToFile(File file, String content, String charSet) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), charSet);
        writer.write(content);
        writer.close();
    }

    public static final void writeToFile(OutputStream out, String content) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");
        writer.write(content);
        writer.close();
    }

    public static final void writeToFile(OutputStream out, String content, String charSet) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(out, charSet);
        writer.write(content);
        writer.close();
    }

    public static void appendToFile(String fileName, String content) throws IOException {
        if (fileName != null && content != null) {
            BufferedReader reader = new BufferedReader(new FileReader(createFile(fileName)));
            StringBuffer buff = new StringBuffer();

            for(String lineContent = null; (lineContent = reader.readLine()) != null; buff = buff.append(lineContent).append("\n")) {
                ;
            }

            reader.close();
            FileWriter writer = new FileWriter(createFile(fileName));
            writer.write(buff.toString());
            writer.write(content);
            writer.close();
        }
    }

    public static String readFromFile(String fileName) throws IOException {
        return readFromFile(fileName, "UTF-8");
    }

    public static String readFromFile(String fileName, String charSet) throws IOException {
        if (fileName != null && fileName.trim().length() != 0) {
            if (charSet == null || charSet.trim().length() == 0) {
                charSet = "UTF-8";
            }

            FileInputStream inputStream = new FileInputStream(fileName);
            InputStreamReader reader = new InputStreamReader(inputStream, charSet);
            StringBuffer buffer = new StringBuffer();
            char[] buf = new char[64];
            boolean var6 = false;

            int count;
            while((count = reader.read(buf)) != -1) {
                buffer.append(buf, 0, count);
            }

            return buffer.toString();
        } else {
            return null;
        }
    }

    public static String readFromFile(File file) throws IOException {
        return readFromFile(file, "UTF-8");
    }

    public static String readFromFile(File file, String charSet) throws IOException {
        if (charSet == null || charSet.trim().length() == 0) {
            charSet = "UTF-8";
        }

        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream, charSet);
        StringBuffer buffer = new StringBuffer();
        char[] buf = new char[64];
        boolean var6 = false;

        int count;
        while((count = reader.read(buf)) != -1) {
            buffer.append(buf, 0, count);
        }

        return buffer.toString();
    }

    public static String readFromFile(InputStream in) throws IOException {
        return readFromFile(in, "UTF-8");
    }

    public static String readFromFile(InputStream in, String charSet) throws IOException {
        if (charSet == null || charSet.trim().length() == 0) {
            charSet = "UTF-8";
        }

        InputStreamReader reader = new InputStreamReader(in, charSet);
        StringBuffer buffer = new StringBuffer();
        char[] buf = new char[64];
        boolean var5 = false;

        int count;
        while((count = reader.read(buf)) != -1) {
            buffer.append(buf, 0, count);
        }

        return buffer.toString();
    }

    public static void copyFile(String des, String src) throws IOException {
        FileInputStream fis = new FileInputStream(createFile(src));
        FileOutputStream fos = new FileOutputStream(createFile(des));
        byte[] b = new byte[8192];
        boolean var5 = false;

        int len;
        while((len = fis.read(b)) > 0) {
            fos.write(b, 0, len);
        }

        fos.close();
        fis.close();
    }

    public static boolean deleteFiles(String filePath) throws IOException {
        File f = new File(filePath);
        if (!f.exists()) {
            return true;
        } else {
            if (f.isDirectory()) {
                File[] files = f.listFiles();
                if (files != null) {
                    int i = 0;

                    for(int len = files.length; i < len; ++i) {
                        if (files[i].isFile()) {
                            files[i].delete();
                        } else {
                            deleteFiles(files[i].getAbsolutePath());
                        }
                    }
                }
            }

            return f.delete();
        }
    }

    public static byte[] readBytes(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        transfer(in, out);
        return out.toByteArray();
    }

//    public static byte[] readBytes(String filePath) throws IOException {
//        InputStream in = null;
//
//        byte[] var4;
//        try {
//            FileLoader fileLoader = FileLoaderFactory.creatFileLoader(PathFileLoader.class, (String)null);
//            fileLoader.setFile(filePath);
//            in = fileLoader.getInputStream();
//            var4 = readBytes(in);
//        } finally {
//            close(in);
//        }
//
//        return var4;
//    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException var2) {
                if (log.isDebugEnabled()) {
                    log.debug("failed to close stream", var2);
                }
            }
        }

    }

    public static long transfer(InputStream in, OutputStream out) throws IOException {
        long total = 0L;

        int count;
        for(byte[] buffer = new byte[4096]; (count = in.read(buffer)) != -1; total += (long)count) {
            out.write(buffer, 0, count);
        }

        return total;
    }

//    public static void zipFile(File inputFile, CZipOutputStream ouputStream) throws IOException {
//        FileInputStream inputstream = null;
//
//        try {
//            if (!inputFile.exists() || !inputFile.isFile()) {
//                throw new BaseException("打包的文件" + inputFile.getName() + "不存在！");
//            }
//
//            inputstream = new FileInputStream(inputFile);
//            CZipEntry entry = new CZipEntry(inputFile.getName());
//            ouputStream.putNextEntry(entry);
//            transfer(inputstream, ouputStream);
//        } finally {
//            if (inputstream != null) {
//                close(inputstream);
//            }
//
//        }
//
//    }
//
//    public static void zipFile(String fileName, InputStream inputStream, CZipOutputStream zipOutputStream) throws IOException {
//        CZipEntry entry = new CZipEntry(fileName);
//        zipOutputStream.putNextEntry(entry);
//        transfer(inputStream, zipOutputStream);
//        zipOutputStream.closeEntry();
//    }

    public static String getExtension(String fileName) {
        if (fileName != null) {
            int index = fileName.lastIndexOf(".");
            if (index != -1 && index != fileName.length() - 1) {
                return fileName.substring(index);
            }
        }

        return ".unknown";
    }

//    public static long createFile(File file, InputStream in) {
//        if (!file.getParentFile().exists()) {
//            file.getParentFile().mkdirs();
//        }
//
//        FileOutputStream out = null;
//
//        long var5;
//        try {
//            out = new FileOutputStream(file);
//            var5 = transfer(in, out);
//        } catch (Exception var9) {
//            throw new BaseException("保存文件失败！");
//        } finally {
//            if (out != null) {
//                close(out);
//            }
//
//            if (in != null) {
//                close(in);
//            }
//
//        }
//
//        return var5;
//    }

    public static String getFileName(String fileName) {
        return FilenameUtils.getName(fileName);
    }

    public static String trimEndFilePathSeparator(String filePath) {
        return trimEndFilePathSeparator(filePath, false);
    }

    public static String trimEndFilePathSeparator(String filePath, boolean unixSeparator) {
        filePath = FilenameUtils.normalizeNoEndSeparator(filePath);
        return unixSeparator ? toUnixFilePath(filePath) : filePath;
    }

    public static String getBaseFileName(String fileName) {
        return FilenameUtils.getBaseName(fileName);
    }

    public static String concat(String rootPath, String fileName) {
        return concat(rootPath, fileName, false);
    }

    private static boolean isSeparator(char ch) {
        return ch == '/' || ch == '\\';
    }

    public static String concat(String rootPath, String fileName, boolean unixSeparator) {
        fileName = FilenameUtils.normalize(rootPath + fileName);
        return unixSeparator ? toUnixFilePath(fileName) : fileName;
    }

    public static String countFileDisplaySize(long size) {
        String displaySize;
        if (size / 1073741824L > 0L) {
            displaySize = format(Math.floor((double)size * 100.0D / 1.073741824E9D) / 100.0D) + "G";
        } else if (size / 1048576L > 0L) {
            displaySize = format(Math.floor((double)size * 100.0D / 1048576.0D) / 100.0D) + "M";
        } else if (size / 1024L > 0L) {
            displaySize = format(Math.floor((double)size * 100.0D / 1024.0D) / 100.0D) + "K";
        } else {
            displaySize = size + "Bytes";
        }

        return displaySize;
    }

    public static String toUnixFilePath(String filePath) {
        return FilenameUtils.separatorsToUnix(filePath);
    }

    private static String format(double number) {
        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(0);
        format.setGroupingUsed(false);
        return format.format(number);
    }
}
