package org.jdk.feature.featuretest;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

public class HandleTargetTest {


    private HandleTarget handleTarget = new HandleTarget();
    private VarHandle varHandle;


//    @Before
//    public void setUp() throws Exception {
//        this.handleTarget = new HandleTarget();
//        this.varHandle = MethodHandles
//                .lookup()
//                .findVarHandle(HandleTarget.class, "count", int.class);
//    }
//
//    @Test
//    public void testGet() {
//        assertEquals(1, this.varHandle.get(this.handleTarget));
//        Object o = this.varHandle.get(this.handleTarget);
//        System.out.println(o);
//    }


    private InputStream inputStream;
    private static final String CONTENT = "Hello World";
    @Before
    public void setUp() throws Exception {
        this.inputStream =
                HandleTargetTest.class.getResourceAsStream("/input.txt");
    }
    @Test
    public void testReadAllBytes() throws Exception {
        final String content = new String(this.inputStream.readAllBytes());
        assertEquals(CONTENT, content);
    }
    @Test
    public void testReadNBytes() throws Exception {
        final byte[] data = new byte[5];
        this.inputStream.readNBytes(data, 0, 5);
        assertEquals("Hello", new String(data));
    }
    @Test
    public void testTransferTo() throws Exception {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        this.inputStream.transferTo(outputStream);
        assertEquals(CONTENT, outputStream.toString());
    }

    @Test
    public void testStackWalker(
    ) throws Exception {
        // 创建 StackWalker 实例
        StackWalker walker = StackWalker.getInstance();

        // 获取调用栈并打印方法名和类名
        walker.walk(frameStream -> {
            frameStream.forEach(frame -> {
                System.out.println("Class: " + frame.getDeclaringClass().getName());
                System.out.println("Method: " + frame.getMethodName());
                System.out.println("Line number: " + frame.getLineNumber());
                System.out.println();
            });
            return null; // walk 方法需要返回一个值
        });
    }

    public static void main(final String[] args) throws NoSuchAlgorithmException {
        final MessageDigest instance = MessageDigest.getInstance("SHA3-224");
        final byte[] digest = instance.digest("".getBytes());
        System.out.println(digest);
//        System.out.println(Hex.encodeHexString(digest));
    }


}